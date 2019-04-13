package it.dbb.common.language.api;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public interface CommonResourceBundleProvider {
    
    ResourceBundle getResourceBundle(Locale locale);
    
    List<Locale> managedLocales();
    
    void changeConsumer(Consumer<Locale> consumer);
    
    void emitChange(Locale locale);
}
