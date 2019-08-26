package it.dbb.common.language.provider.db.internal.controller;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import it.dbb.common.language.api.ResourceBundlePublisherHelper;
import it.dbb.common.language.provider.db.context.TranslationModelContext;
import it.dbb.common.language.provider.db.controller.TranslationController;
import it.dbb.common.language.provider.db.model.Translation;
import it.dbb.common.language.provider.db.service.TranslationLocalService;
import it.dbb.common.language.provider.db.service.provider.DatabaseCommonLanguageProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

@Component
public class TranslationControllerImpl implements TranslationController {
    
    @Override
    public Translation updateTranslation(TranslationModelContext modelContext, ServiceContext serviceContext) throws PortalException {
        
        Translation translation;
        
        if (modelContext.getPrimaryKey() == 0) {
            
            translation = translationLocalService.addTranslation(modelContext, serviceContext);
            
        } else {
    
            translation = translationLocalService.updateTranslation(modelContext.getPrimaryKey(), modelContext, serviceContext);
        }
    
        Locale locale = LocaleUtil.fromLanguageId(translation.getLanguage());
        
        databaseCommonLanguageProvider.cleanResourceBundle(locale);
        
        resourceBundlePublisherHelper.republishLocale(locale);
        
        return translation;
    }
    
    @Override
    public Translation removeTranslation(long translationId) throws PortalException {
    
        Translation translation = translationLocalService.deleteTranslation(translationId);
    
        Locale locale = LocaleUtil.fromLanguageId(translation.getLanguage());
    
        databaseCommonLanguageProvider.cleanResourceBundle(locale);
    
        resourceBundlePublisherHelper.republishLocale(locale);
    
        return translation;
    }
    
    @Override
    public TranslationLocalService dao() {
        
        return translationLocalService;
    }
    
    @Reference
    private ResourceBundlePublisherHelper resourceBundlePublisherHelper;
    
    @Reference
    private TranslationLocalService translationLocalService;
    
    @Reference
    private DatabaseCommonLanguageProvider databaseCommonLanguageProvider;
}
