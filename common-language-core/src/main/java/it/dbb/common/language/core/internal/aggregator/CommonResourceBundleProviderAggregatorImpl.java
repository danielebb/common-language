package it.dbb.common.language.core.internal.aggregator;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.AggregateResourceBundle;
import it.dbb.common.language.api.CommonResourceBundleProvider;
import it.dbb.common.language.api.CommonResourceBundleProviderAggregator;
import it.dbb.common.language.api.ResourceBundlePublisher;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.ServiceTracker;

import java.util.*;

@Component
public class CommonResourceBundleProviderAggregatorImpl implements CommonResourceBundleProviderAggregator {
    
    @Override
    public ResourceBundle getAggregateResourceBundle(Locale locale) {
        
        return aggregatedResourceBundles.get(locale);
    }
    
    @Activate
    protected void activate(BundleContext bundleContext) {
        
        this.bundleContext = bundleContext;
        
        if (_log.isDebugEnabled()) {
            
            _log.debug("Starting CommonResourceBundleProvider tracker");
        }
        
        CommonResourceBundleProviderTracker commonResourceBundleProviderTracker = new CommonResourceBundleProviderTracker(bundleContext);
        
        commonResourceBundleProviderTracker.open();
    }
    
    private void initAggregatedResourceBundle(Locale locale) {
    
        if (_log.isDebugEnabled()) {
        
            _log.debug("Generating aggregate resource bundle for locale " + locale.toString());
        }
        
        ResourceBundle[] resourceBundles = providers.stream().map(commonResourceBundleProviderServiceReference -> {
        
            CommonResourceBundleProvider commonResourceBundleProvider = bundleContext.getService(commonResourceBundleProviderServiceReference);
        
            return commonResourceBundleProvider.getResourceBundle(locale);
            
        }).toArray(ResourceBundle[]::new);
    
        AggregateResourceBundle aggregateResourceBundle = new AggregateResourceBundle(resourceBundles);
        
        aggregatedResourceBundles.put(locale, aggregateResourceBundle);
    }
    
    private class CommonResourceBundleProviderTracker extends ServiceTracker<CommonResourceBundleProvider, CommonResourceBundleProvider> {
        
        CommonResourceBundleProviderTracker(BundleContext context) {
            
            super(context, CommonResourceBundleProvider.class, null);
        }
        
        @Override
        public CommonResourceBundleProvider addingService(ServiceReference<CommonResourceBundleProvider> reference) {
            
            CommonResourceBundleProvider commonResourceBundleProvider = super.addingService(reference);
            
            if (_log.isDebugEnabled()) {
                
                _log.debug("Discovered CommonResourceBundleProvider " + commonResourceBundleProvider.getClass().getName());
            }
    
            providers.add(reference);
    
            Collections.sort(providers);
    
            commonResourceBundleProvider.changeConsumer(locale -> resourceBundlePublisher.publishResourceBundle(locale, getAggregateResourceBundle(locale)));
            
            publishResourceBundles(commonResourceBundleProvider);
            
            return commonResourceBundleProvider;
        }
        
        @Override
        public void removedService(ServiceReference<CommonResourceBundleProvider> reference, CommonResourceBundleProvider commonResourceBundleProvider) {
    
            if (_log.isDebugEnabled()) {
        
                _log.debug("Unbind CommonResourceBundleProvider " + commonResourceBundleProvider.getClass().getName());
            }
            
            providers.removeIf(commonResourceBundleProviderServiceReference -> commonResourceBundleProviderServiceReference.compareTo(reference) == 0);
            
            publishResourceBundles(commonResourceBundleProvider);
        }
        
        private void publishResourceBundles(CommonResourceBundleProvider commonResourceBundleProvider) {
            
            List<Locale> locales = commonResourceBundleProvider.managedLocales();
            
            if (_log.isDebugEnabled()) {
                
                _log.debug("Republish ResourceBundles for Locales " + Arrays.toString(locales.toArray()));
            }
            
            for (Locale locale : locales) {
    
                initAggregatedResourceBundle(locale);
                
                if (_log.isDebugEnabled()) {
                    
                    _log.debug("Republishing ResourceBundle for Locale " + locale.toString());
                }
                
                resourceBundlePublisher.publishResourceBundle(locale, getAggregateResourceBundle(locale));
            }
        }
    }
    
    @Reference
    private ResourceBundlePublisher resourceBundlePublisher;
    
    private List<ServiceReference<CommonResourceBundleProvider>> providers = new ArrayList<>();
    
    private Map<Locale, ResourceBundle> aggregatedResourceBundles = new HashMap<>();
    
    private Log _log = LogFactoryUtil.getLog(CommonResourceBundleProviderAggregatorImpl.class);
    
    private BundleContext bundleContext;
}
