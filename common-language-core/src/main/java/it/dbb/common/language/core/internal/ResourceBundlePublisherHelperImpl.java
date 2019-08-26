package it.dbb.common.language.core.internal;

import it.dbb.common.language.api.CommonResourceBundleProviderAggregator;
import it.dbb.common.language.api.ResourceBundlePublisher;
import it.dbb.common.language.api.ResourceBundlePublisherHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component
public class ResourceBundlePublisherHelperImpl implements ResourceBundlePublisherHelper {
    
    @Override
    public void republishLocale(Locale locale) {
        
        resourceBundlePublisher.publishResourceBundle(locale, commonResourceBundleProviderAggregator.refreshAggregateResourceBundle(locale));
    }
    
    @Reference
    private ResourceBundlePublisher resourceBundlePublisher;
    
    @Reference
    private CommonResourceBundleProviderAggregator commonResourceBundleProviderAggregator;
}
