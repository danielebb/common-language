package it.dbb.common.language.api;

import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

public interface ResourceBundlePublisher {
    
    default void publishResourceBundle(Locale locale, ResourceBundle resourceBundle) {
        
        publishResourceBundle(LocaleUtil.toLanguageId(locale), resourceBundle);
    }
    
    void publishResourceBundle(String languageId, ResourceBundle resourceBundle);
}
