/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.dbb.common.language.provider.db.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.spring.extender.service.ServiceReference;
import it.dbb.common.language.provider.db.context.TranslationModelContext;
import it.dbb.common.language.provider.db.exception.DuplicateTranslationException;
import it.dbb.common.language.provider.db.exception.InvalidTranslationException;
import it.dbb.common.language.provider.db.model.Translation;
import it.dbb.common.language.provider.db.service.base.TranslationLocalServiceBaseImpl;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * The implementation of the translation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.dbb.common.language.provider.db.service.TranslationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author danielebb
 * @see TranslationLocalServiceBaseImpl
 * @see it.dbb.common.language.provider.db.service.TranslationLocalServiceUtil
 */
@ProviderType
public class TranslationLocalServiceImpl extends TranslationLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link it.dbb.common.language.provider.db.service.TranslationLocalServiceUtil} to access the translation local service.
     */
    
    public Translation createDraft() {
        
        return createTranslation(0);
    }
    
    public Translation addTranslation(TranslationModelContext translationModelContext, ServiceContext serviceContext) throws InvalidTranslationException, DuplicateTranslationException {
        
        Translation translation = createTranslation(counterLocalService.increment(Translation.class.getName()));
    
        updateModelFields(translation, translationModelContext);
    
        updateAuditFields(translation, serviceContext);
        
        validate(translation);
        
        return addTranslation(translation);
    }
    
    public Translation updateTranslation(long translationId, TranslationModelContext translationModelContext, ServiceContext serviceContext) throws PortalException {
    
        Translation translation = getTranslation(translationId);
    
        updateModelFields(translation, translationModelContext);
    
        updateAuditFields(translation, serviceContext);
        
        validate(translation);
        
        return updateTranslation(translation);
    }
    
    public List<Translation> getTranslationByLanguage(String language, QueryDefinition<Translation> qd) {
        
        if(qd == null) {
            
            qd = new QueryDefinition<>();
        }
        
        return translationPersistence.findByLanguage(language, qd.getStart(), qd.getEnd(), qd.getOrderByComparator());
    }
    
    public int countTranslationByLanguage(String language) {
        
        return translationPersistence.countByLanguage(language);
    }
    
    public Translation fetchByLocaleKey(Locale locale, String key) {
    
        String language = LocaleUtil.toLanguageId(locale);
        
        return translationPersistence.fetchByLanguageKey(language, key);
    }
    
    public List<Locale> getSupportedLocales() {
    
        DynamicQuery dynamicQuery = dynamicQuery();
        
        dynamicQuery.setProjection(ProjectionFactoryUtil.groupProperty("language"));
    
        List<String> languages = dynamicQuery(dynamicQuery);
        
        return languages.stream().map(LocaleUtil::fromLanguageId).collect(Collectors.toList());
    }
    
    public List<Translation> getByLocale(Locale locale) {
    
        String language = LocaleUtil.toLanguageId(locale);
        
        return translationPersistence.findByLanguage(language);
    }
    
    private void updateModelFields(Translation translation, TranslationModelContext translationModelContext) {
        
        translation.setKey(translationModelContext.getKey());
        translation.setLanguage(translationModelContext.getLanguageCode());
        translation.setValue(translationModelContext.getValue());
    }
    
    private void updateAuditFields(Translation translation, ServiceContext serviceContext) {
        
        if (translation.isNew()) {
            
            translation.setUserId(serviceContext.getUserId());
            translation.setUserName(PortalUtil.getUserName(serviceContext.getUserId(), ""));
            translation.setCreateDate(serviceContext.getCreateDate(null));
        }
        
        translation.setModifiedDate(serviceContext.getModifiedDate(null));
    }
    
    private void validate(Translation translation) throws DuplicateTranslationException, InvalidTranslationException {
        
        Translation duplicateTranslation = translationPersistence.fetchByLanguageKey(translation.getLanguage(), translation.getKey());
        
        if (duplicateTranslation != null && !duplicateTranslation.equals(translation)) {
            
            throw new DuplicateTranslationException("Duplicate translation for key " + translation.getKey() + " and language " + translation.getLanguage());
        }
        
        if(Validator.isNull(translation.getKey())) {
            
            throw new InvalidTranslationException("Key");
        }
        
        if(Validator.isNull(translation.getLanguage())) {
            
            throw new InvalidTranslationException("Language");
        }
        
        if(Validator.isNull(translation.getValue())) {
            
            throw new InvalidTranslationException("Value");
        }
    }
}