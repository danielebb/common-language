package it.dbb.common.language.api;

import java.util.Locale;
import java.util.ResourceBundle;

public interface CommonResourceBundleProviderAggregator {
    
    ResourceBundle getAggregateResourceBundle(Locale locale);
    
    
}
