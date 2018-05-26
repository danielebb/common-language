package it.dbb.common.language.service.tracker;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

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

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;

public class CommonLanguageServiceTracker extends ServiceTracker<CommonLanguageLoader, CommonLanguageLoader> {

	public CommonLanguageServiceTracker(BundleContext bundleContext) throws InvalidSyntaxException {

		super(bundleContext,
				FrameworkUtil.createFilter("(&(" + Constants.OBJECTCLASS + "=" + CommonLanguageLoader.class.getName()
						+ ")(it.dbb.common.language.type=" + COMMON_LANGUAGE_TYPE + "))"),
				null);

		this.bundleContext = bundleContext;
	}

	@Override
	public CommonLanguageLoader addingService(ServiceReference<CommonLanguageLoader> reference) {

		// when a CommonLanguage service is discovered, register a ResourceBundle
		if (currentServiceReference == null || currentServiceReference.compareTo(reference) < 0) {

			if (!serviceRegistrations.isEmpty()) {

				unregisterResourceBundleService();
			}

			registerResourceBundleService(reference);

			currentServiceReference = reference;
		}

		return super.addingService(reference);
	}

	@Override
	public void modifiedService(ServiceReference<CommonLanguageLoader> reference, CommonLanguageLoader service) {

		if (currentServiceReference.equals(reference)) {

			unregisterResourceBundleService();
			registerResourceBundleService(reference);
		}

		super.modifiedService(reference, service);
	}

	@Override
	public void removedService(ServiceReference<CommonLanguageLoader> reference, CommonLanguageLoader service) {

		unregisterResourceBundleService();
		currentServiceReference = null;

		super.removedService(reference, service);
	}

	protected void registerResourceBundleService(ServiceReference<CommonLanguageLoader> reference) {

		CommonLanguageLoader commonLanguageLoader = bundleContext.getService(reference);

		if (commonLanguageLoader == null) {

			_log.error("No services returned by OSGI framework");
			return;
		}

		_log.info("Exporting service ResourceBundle for bundle " + reference.getBundle().getBundleId());

		ResourceBundleLoader resourceBundleLoader = commonLanguageLoader.getResourceBundleLoader();

		Set<String> resourceBundleLoaderLanguageIds = commonLanguageLoader.getResourceBundleLoaderLanguageIds();

		if (resourceBundleLoaderLanguageIds == null || resourceBundleLoaderLanguageIds.isEmpty()) {

			_log.warn("No languageIds returned from bundle " + reference.getBundle().getBundleId());
			return;
		}

		for (String languageId : resourceBundleLoaderLanguageIds) {

			_log.info("Found languageId " + languageId);

			ResourceBundle resourceBundle = resourceBundleLoader.loadResourceBundle(languageId);

			Hashtable<String, String> properties = new Hashtable<>();
			properties.put("language.id", languageId);

			ServiceRegistration<ResourceBundle> registerService = bundleContext.registerService(ResourceBundle.class,
					resourceBundle, properties);

			serviceRegistrations.add(registerService);
		}
	}

	protected void unregisterResourceBundleService() {

		serviceRegistrations.removeIf((serviceRegistration) -> {

			serviceRegistration.unregister();

			return true;
		});
	}

	private BundleContext bundleContext;
	private ServiceReference<CommonLanguageLoader> currentServiceReference;
	private List<ServiceRegistration<ResourceBundle>> serviceRegistrations = new ArrayList<>();

	private static final String COMMON_LANGUAGE_TYPE = GetterUtil
			.get(PropsUtil.get("common.language.resource.loader.type"), "static");

	private Log _log = LogFactoryUtil.getLog(CommonLanguageServiceTracker.class);
}