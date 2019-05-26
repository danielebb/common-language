package it.dbb.common.language.core.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.Validator;
import it.dbb.common.language.api.CommonResourceBundleProviderAggregator;
import it.dbb.common.language.api.model.CommonResourceBundleLoader;
import it.dbb.common.language.core.util.BundlePropertyUtil;
import org.osgi.framework.*;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.ServiceTracker;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@Component(immediate = true, service = CommonResourceBundleLoaderRegistrar.class)
public class CommonResourceBundleLoaderRegistrar {
    
    private void publishCommonResourceBundleLoader(ServiceReference<ResourceBundleLoader> serviceReference, ResourceBundleLoader resourceBundleLoader, Bundle bundle) {
        
        String bundleSymbolicName = BundlePropertyUtil.getBundleSymbolicName(serviceReference, bundle);
        
        if (Validator.isNull(bundleSymbolicName) || bundleContext == null) {
            
            return;
        }
        
        Hashtable<String, Object> properties = new Hashtable<>();
        
        properties.put("bundle.symbolic.name", bundleSymbolicName);
        properties.put("resource.bundle.base.name", BundlePropertyUtil.getResourceBundleBaseName(serviceReference, bundle));
        properties.put("servlet.context.name", BundlePropertyUtil.getServletContextName(serviceReference, bundle));
        properties.put(Constants.SERVICE_RANKING, BundlePropertyUtil.getNextServiceRanking(serviceReference, bundle));
        
        CommonResourceBundleLoader aggregateResourceBundleLoader = new CommonResourceBundleLoader(commonResourceBundleProviderAggregator, resourceBundleLoader);
        
        if (_log.isDebugEnabled()) {
            
            _log.debug("Registering new service " + aggregateResourceBundleLoader.getClass().getName() + " with properties " + properties.toString());
        }
        
        ServiceRegistration<ResourceBundleLoader> serviceRegistration = bundleContext.registerService(ResourceBundleLoader.class, aggregateResourceBundleLoader, properties);
        
        serviceRegistrations.put(resourceBundleLoader, serviceRegistration);
    }
    
    private void unpublishCommonResourceBundleLoader(ResourceBundleLoader service) {
        
        if (serviceRegistrations.containsKey(service)) {
            
            ServiceRegistration<ResourceBundleLoader> serviceRegistration = serviceRegistrations.get(service);
            
            if (_log.isDebugEnabled()) {
                
                _log.debug("Unregistering service " + service.getClass().getName());
            }
            
            serviceRegistration.unregister();
            
            serviceRegistrations.remove(service);
        }
    }
    
    @Activate
    protected void activate(BundleContext bundleContext) {
        
        this.bundleContext = bundleContext;
        
        ResourceBundleLoaderServiceTracker serviceTracker = new ResourceBundleLoaderServiceTracker(bundleContext);
        
        serviceTracker.open();
    }
    
    @Deactivate
    protected void deactivate() {
        
        this.bundleContext = null;
    }
    
    private class ResourceBundleLoaderServiceTracker extends ServiceTracker<ResourceBundleLoader, ResourceBundleLoader> {
        
        ResourceBundleLoaderServiceTracker(BundleContext bundleContext) {
            
            super(bundleContext, ResourceBundleLoader.class, null);
        }
        
        @Override
        public ResourceBundleLoader addingService(ServiceReference<ResourceBundleLoader> reference) {
            
            ResourceBundleLoader resourceBundleLoader = super.addingService(reference);
            
            if (_log.isDebugEnabled()) {
                
                _log.debug("Tracking service " + BundlePropertyUtil.getBundleSymbolicName(reference, reference.getBundle()));
            }
            
            if (!(resourceBundleLoader instanceof CommonResourceBundleLoader)) {
                
                publishCommonResourceBundleLoader(reference, resourceBundleLoader, reference.getBundle());
            }
            
            return resourceBundleLoader;
        }
        
        @Override
        public void modifiedService(ServiceReference<ResourceBundleLoader> reference, ResourceBundleLoader service) {
            
            if (_log.isDebugEnabled()) {
                
                _log.debug("Service " + BundlePropertyUtil.getBundleSymbolicName(reference, reference.getBundle()) + " was modified");
            }
            
            // TODO
            // what to do if a resourceBundleLoader service is being modified?
            
            super.modifiedService(reference, service);
        }
        
        @Override
        public void removedService(ServiceReference<ResourceBundleLoader> reference, ResourceBundleLoader resourceBundleLoader) {
            
            if (_log.isDebugEnabled()) {
                
                _log.debug("Service " + BundlePropertyUtil.getBundleSymbolicName(reference, reference.getBundle()) + " was removed");
            }
            
            if (!(resourceBundleLoader instanceof CommonResourceBundleLoader)) {
                
                unpublishCommonResourceBundleLoader(resourceBundleLoader);
            }
            
            super.removedService(reference, resourceBundleLoader);
        }
    }
    
    @Reference
    private CommonResourceBundleProviderAggregator commonResourceBundleProviderAggregator;
    
    private Log _log = LogFactoryUtil.getLog(CommonResourceBundleLoaderRegistrar.class);
    
    private BundleContext bundleContext;
    
    private Map<ResourceBundleLoader, ServiceRegistration<ResourceBundleLoader>> serviceRegistrations = new HashMap<>();
}
