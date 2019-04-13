package it.dbb.common.language.core.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import it.dbb.common.language.api.ResourceBundlePublisher;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.*;

@Component(service = ResourceBundlePublisher.class)
public class ResourceBundlePublisherImpl implements ResourceBundlePublisher {
    
    @Override
    public void publishResourceBundle(String languageId, ResourceBundle resourceBundle) {
    
        registerResourceBundleService(languageId, resourceBundle);
    }
    
    @Activate
    protected void activate(BundleContext bundleContext) {
        
        this.bundleContext = bundleContext;
    }
    
    private void registerResourceBundleService(String languageId, ResourceBundle resourceBundle) {
        
        if (resourceBundle == null) {
            
            if (_log.isDebugEnabled()) {
                
                _log.debug("No resource bundle to register");
            }
            
            return;
        }
    
        if (Validator.isNull(languageId)) {
        
            if (_log.isDebugEnabled()) {
            
                _log.debug("No languageId was specified");
            }
        
            return;
        }
        
        // first try to unregister if already registered
        unregisterResourceBundleService(languageId);
        
        if (_log.isDebugEnabled()) {
            
            _log.debug("Registering ResourceBundle service for language " + languageId);
        }
        
        Hashtable<String, String> properties = new Hashtable<>();
        properties.put("language.id", languageId);
        
        ServiceRegistration<ResourceBundle> registerService = bundleContext.registerService(ResourceBundle.class, resourceBundle, properties);
        
        serviceRegistrations.put(languageId, registerService);
    }
    
    private void unregisterResourceBundleService(String languageId) {
        
        serviceRegistrations.computeIfPresent(languageId, (s, resourceBundleServiceRegistration) -> {
    
            if (_log.isDebugEnabled()) {
        
                _log.debug("Unregistering ResourceBundle service for language " + languageId);
            }
            
            resourceBundleServiceRegistration.unregister();
            
            return resourceBundleServiceRegistration;
        });
        
        serviceRegistrations.remove(languageId);
    }
    
    private Map<String, ServiceRegistration<ResourceBundle>> serviceRegistrations = new HashMap<>();
    
    private Log _log = LogFactoryUtil.getLog(ResourceBundlePublisherImpl.class);
    
    private BundleContext bundleContext;
}
