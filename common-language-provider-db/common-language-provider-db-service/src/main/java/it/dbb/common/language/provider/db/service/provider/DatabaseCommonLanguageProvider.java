package it.dbb.common.language.provider.db.service.provider;

import it.dbb.common.language.api.CommonResourceBundleProvider;
import it.dbb.common.language.api.base.BaseCommonResourceBundleProvider;
import it.dbb.common.language.provider.db.service.TranslationLocalService;
import it.dbb.common.language.provider.db.service.provider.bundle.DatabaseResourceBundle;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

@Component(property = { "it.dbb.common.language.type=database", "service.ranking:Integer=-1" }, service = CommonResourceBundleProvider.class)
public class DatabaseCommonLanguageProvider extends BaseCommonResourceBundleProvider {
    
    @Override
    public ResourceBundle getResourceBundle(Locale locale) {
        
        if(translationLocalService == null) {
            
            return null;
        }
        
        if(!resourceBundleMap.containsKey(locale)) {
            
            resourceBundleMap.put(locale, new DatabaseResourceBundle(translationLocalService, locale));
        }
        
        return resourceBundleMap.get(locale);
    }
    
    @Override
    public List<Locale> managedLocales() {
        
        if(translationLocalService == null) {
            
            return Collections.emptyList();
        }
        
        return translationLocalService.getSupportedLocales();
    }
    
    @Reference
    private TranslationLocalService translationLocalService;
    
    private Map<Locale, ResourceBundle> resourceBundleMap = new HashMap<>();
}
