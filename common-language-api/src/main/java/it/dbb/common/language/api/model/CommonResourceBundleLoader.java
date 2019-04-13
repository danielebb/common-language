package it.dbb.common.language.api.model;

import com.liferay.portal.kernel.util.AggregateResourceBundle;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringPool;
import it.dbb.common.language.api.CommonResourceBundleProviderAggregator;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author danielebb
 */
public class CommonResourceBundleLoader implements ResourceBundleLoader {
    
    public CommonResourceBundleLoader(CommonResourceBundleProviderAggregator commonResourceBundleLoaderProviderAggregator, ResourceBundleLoader resourceBundleLoader) {
        
        this.commonResourceBundleLoaderProviderAggregator = commonResourceBundleLoaderProviderAggregator;
        this.baseResourceBundleLoader = resourceBundleLoader;
    }
    
    public ResourceBundle loadResourceBundle(Locale locale) {
        
        ResourceBundle commonLanguageResourceBundle;
        ResourceBundle baseResourceBundle = baseResourceBundleLoader.loadResourceBundle(locale);
        
        commonLanguageResourceBundle = commonResourceBundleLoaderProviderAggregator.getAggregateResourceBundle(locale);
        
        if (commonLanguageResourceBundle != null && baseResourceBundle != null) {
            
            return new AggregateResourceBundle(commonLanguageResourceBundle, baseResourceBundle);
            
        } else if (baseResourceBundle != null) {
            
            return baseResourceBundle;
            
        } else if (commonLanguageResourceBundle != null) {
            
            return commonLanguageResourceBundle;
        }
        
        throw new MissingResourceException("Resource bundle loader " + this + " was unable to load " + "resource bundle for " + locale, StringPool.BLANK, locale.toString());
        
    }
    
    private final ResourceBundleLoader baseResourceBundleLoader;
    private CommonResourceBundleProviderAggregator commonResourceBundleLoaderProviderAggregator;
}
