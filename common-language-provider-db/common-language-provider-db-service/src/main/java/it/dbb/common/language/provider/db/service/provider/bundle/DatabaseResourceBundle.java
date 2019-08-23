package it.dbb.common.language.provider.db.service.provider.bundle;

import it.dbb.common.language.provider.db.model.Translation;
import it.dbb.common.language.provider.db.service.TranslationLocalService;

import java.util.*;
import java.util.stream.Collectors;

public class DatabaseResourceBundle extends ResourceBundle {
    
    private final TranslationLocalService translationLocalService;
    private final Locale locale;
    
    public DatabaseResourceBundle(TranslationLocalService translationLocalService, Locale locale) {
        
        this.translationLocalService = translationLocalService;
        this.locale = locale;
    }
    
    @Override
    protected Object handleGetObject(String key) {
    
        Translation translation = translationLocalService.fetchByLocaleKey(locale, key);
        
        if(translation != null) {
            
            return translation.getValue();
        }
        
        return null;
    }
    
    @Override
    public Enumeration<String> getKeys() {
    
        List<String> keys = translationLocalService.getByLocale(locale).stream().map(translation -> translation.getKey()).collect(Collectors.toList());
        
        return Collections.enumeration(keys);
    }
    
    @Override
    public Locale getLocale() {
        
        return locale;
    }
}
