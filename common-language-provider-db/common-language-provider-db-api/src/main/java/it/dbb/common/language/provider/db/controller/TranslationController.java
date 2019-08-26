package it.dbb.common.language.provider.db.controller;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import it.dbb.common.language.provider.db.context.TranslationModelContext;
import it.dbb.common.language.provider.db.model.Translation;
import it.dbb.common.language.provider.db.service.TranslationLocalService;

public interface TranslationController {
    Translation updateTranslation(TranslationModelContext modelContext, ServiceContext serviceContext) throws PortalException;
    
    Translation removeTranslation(long translationId) throws PortalException;
    
    TranslationLocalService dao();
}
