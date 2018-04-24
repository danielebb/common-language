package it.dbb.common.language.activator;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.Validator;

import it.dbb.common.language.bundleloader.CommonLanguageAggregateResourceBundleLoader;
import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import it.dbb.common.language.util.BundlePropertyUtil;

/**
 * @author danielebb
 */
public class CommonLanguageActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {

		this.bundleContext = bundleContext;

		commonLanguageServiceTracker = new CommonLanguageServiceTracker(bundleContext);
		commonLanguageServiceTracker.open();

		resourceBundleLoaderServiceTracker = new ResourceBundleLoaderServiceTracker();
		resourceBundleLoaderServiceTracker.open();
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {

		serviceRegistrations.entrySet().removeIf(entry -> {
			entry.getValue().unregister();
			return true;
		});

		resourceBundleLoaderServiceTracker.close();

		commonLanguageServiceTracker.close();
	}

	private class ResourceBundleLoaderServiceTracker
			extends ServiceTracker<ResourceBundleLoader, ResourceBundleLoader> {

		public ResourceBundleLoaderServiceTracker() {

			super(bundleContext, ResourceBundleLoader.class, null);
		}

		@Override
		public ResourceBundleLoader addingService(ServiceReference<ResourceBundleLoader> reference) {

			ResourceBundleLoader resourceBundleLoader = bundleContext.getService(reference);
			
			if (_log.isDebugEnabled()) {
				_log.debug("Tracking service "
						+ BundlePropertyUtil.getBundleSymbolicName(reference, reference.getBundle()));
			}

			if (!resourceBundleLoader.getClass().equals(CommonLanguageAggregateResourceBundleLoader.class)) {

				registerAggregateBundleLoader(reference, resourceBundleLoader, reference.getBundle());
			}

			return super.addingService(reference);
		}

		@Override
		public void modifiedService(ServiceReference<ResourceBundleLoader> reference, ResourceBundleLoader service) {

			if (_log.isDebugEnabled()) {
				_log.debug("Service " + BundlePropertyUtil.getBundleSymbolicName(reference, reference.getBundle())
						+ " was modified");
			}

			// TODO
			// what to do if a resourceBundleLoader service is being modified?

			super.modifiedService(reference, service);
		}

		@Override
		public void removedService(ServiceReference<ResourceBundleLoader> reference, ResourceBundleLoader service) {

			if (_log.isDebugEnabled()) {
				_log.debug("Service " + BundlePropertyUtil.getBundleSymbolicName(reference, reference.getBundle())
						+ " was removed");
			}

			if (!service.getClass().equals(CommonLanguageAggregateResourceBundleLoader.class)) {

				unregisterAggregateBundleLoader(reference);
				bundleContext.ungetService(reference);
			}

			super.removedService(reference, service);
		}
	}

	public void registerAggregateBundleLoader(ServiceReference<ResourceBundleLoader> serviceReference,
			ResourceBundleLoader resourceBundleLoader, Bundle bundle) {

		if (serviceRegistrations == null) {

			serviceRegistrations = new HashMap<>();
		}

		String bundleSymbolicName = BundlePropertyUtil.getBundleSymbolicName(serviceReference, bundle);
		
		if (Validator.isNull(bundleSymbolicName) || serviceRegistrations.containsKey(serviceReference)) {
			
			return;
		}
		
		Hashtable<String, Object> properties = new Hashtable<>();
		
		properties.put("bundle.symbolic.name", bundleSymbolicName);
		properties.put("resource.bundle.base.name",
				BundlePropertyUtil.getResourceBundleBaseName(serviceReference, bundle));
		properties.put("servlet.context.name", BundlePropertyUtil.getServletContextName(serviceReference, bundle));
		properties.put(Constants.SERVICE_RANKING, BundlePropertyUtil.getNextServiceRanking(serviceReference, bundle));
		
		CommonLanguageAggregateResourceBundleLoader aggregateResourceBundleLoader = new CommonLanguageAggregateResourceBundleLoader(
				commonLanguageServiceTracker, resourceBundleLoader, properties);

		if (_log.isDebugEnabled()) {
			_log.debug("Registering new service " + aggregateResourceBundleLoader.getClass().getName()
					+ " with properties " + properties.toString());
		}

		ServiceRegistration<ResourceBundleLoader> serviceRegistration = bundleContext
				.registerService(ResourceBundleLoader.class, aggregateResourceBundleLoader, properties);

		serviceRegistrations.put(serviceReference, serviceRegistration);
	}

	public void unregisterAggregateBundleLoader(ServiceReference<ResourceBundleLoader> serviceReference) {

		if (serviceRegistrations != null && serviceRegistrations.containsKey(serviceReference)) {

			ServiceRegistration<ResourceBundleLoader> serviceRegistration = serviceRegistrations.get(serviceReference);

			if (_log.isDebugEnabled()) {
				_log.debug("Unregistering service "
						+ BundlePropertyUtil.getBundleSymbolicName(serviceReference, serviceReference.getBundle()));
			}

			serviceRegistration.unregister();

			serviceRegistrations.remove(serviceReference);
		}
	}

	private class CommonLanguageServiceTracker extends ServiceTracker<CommonLanguageLoader, CommonLanguageLoader> {

		public CommonLanguageServiceTracker(BundleContext bundleContext) throws InvalidSyntaxException {

			super(bundleContext,
					FrameworkUtil
							.createFilter("(&(" + Constants.OBJECTCLASS + "=" + CommonLanguageLoader.class.getName()
									+ ")(it.dbb.common.language.type=" + commonLanguageType + "))"),
					null);
		}
	}

	private BundleContext bundleContext;
	private ResourceBundleLoaderServiceTracker resourceBundleLoaderServiceTracker;
	private CommonLanguageServiceTracker commonLanguageServiceTracker;
	private Map<ServiceReference<ResourceBundleLoader>, ServiceRegistration<ResourceBundleLoader>> serviceRegistrations;
	private final String commonLanguageType = GetterUtil.get(PropsUtil.get("common.language.resource.loader.type"),
			"static");
	private static final Log _log = LogFactoryUtil.getLog(CommonLanguageActivator.class);
}