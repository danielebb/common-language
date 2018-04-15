/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.dbb.common.language.loader.db.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import it.dbb.common.language.loader.db.model.Language;
import it.dbb.common.language.loader.db.service.base.LanguageLocalServiceBaseImpl;

/**
 * The implementation of the language local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link it.dbb.common.language.loader.db.service.LanguageLocalService}
 * interface.
 *
 * <p>
 * * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author danielebb
 * @see LanguageLocalServiceBaseImpl
 * @see it.dbb.common.language.loader.db.service.LanguageLocalServiceUtil
 */
public class LanguageLocalServiceImpl extends LanguageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * it.dbb.common.language.loader.db.service.LanguageLocalServiceUtil} to access
	 * the language local service.
	 */

	public Language addLanguage(String key, String languageCode, String value, ServiceContext serviceContext) {

		Language language = createLanguage(counterLocalService.increment(Language.class.getName()));

		language.setKey(key);
		language.setLanguageCode(languageCode);
		language.setValue(value);

		language.setCompanyId(serviceContext.getCompanyId());

		return addLanguage(language);
	}

	public Language updateLanguage(long languageId, String key, String value, ServiceContext serviceContext)
			throws PortalException {

		Language language = getLanguage(languageId);

		language.setKey(key);
		language.setValue(value);
		language.setModifiedDate(new Date());

		return updateLanguage(language);
	}

	public List<Language> findByLanguageCode(String languageCode) {

		return languagePersistence.findByLanguageCode(languageCode);
	}
	
	public int countByLanguage(String languageCode) {
		
		return languagePersistence.countByLanguageCode(languageCode);
	}
	
	public Language getByLanguageCodeKey(String languageCode, String key) throws PortalException {
		
		return languagePersistence.findByLanguageCodeKey(languageCode, key);
	}
}