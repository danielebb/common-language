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

package it.dbb.common.language.loader.db.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LanguageLocalService}.
 *
 * @author danielebb
 * @see LanguageLocalService
 * @generated
 */
@ProviderType
public class LanguageLocalServiceWrapper implements LanguageLocalService,
	ServiceWrapper<LanguageLocalService> {
	public LanguageLocalServiceWrapper(
		LanguageLocalService languageLocalService) {
		_languageLocalService = languageLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _languageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _languageLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _languageLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _languageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languageLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int countByLanguage(java.lang.String languageCode) {
		return _languageLocalService.countByLanguage(languageCode);
	}

	/**
	* Returns the number of languages.
	*
	* @return the number of languages
	*/
	@Override
	public int getLanguagesCount() {
		return _languageLocalService.getLanguagesCount();
	}

	/**
	* Adds the language to the database. Also notifies the appropriate model listeners.
	*
	* @param language the language
	* @return the language that was added
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language addLanguage(
		it.dbb.common.language.loader.db.model.Language language) {
		return _languageLocalService.addLanguage(language);
	}

	@Override
	public it.dbb.common.language.loader.db.model.Language addLanguage(
		java.lang.String key, java.lang.String languageCode,
		java.lang.String value,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _languageLocalService.addLanguage(key, languageCode, value,
			serviceContext);
	}

	/**
	* Creates a new language with the primary key. Does not add the language to the database.
	*
	* @param languageId the primary key for the new language
	* @return the new language
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language createLanguage(
		long languageId) {
		return _languageLocalService.createLanguage(languageId);
	}

	/**
	* Deletes the language from the database. Also notifies the appropriate model listeners.
	*
	* @param language the language
	* @return the language that was removed
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language deleteLanguage(
		it.dbb.common.language.loader.db.model.Language language) {
		return _languageLocalService.deleteLanguage(language);
	}

	/**
	* Deletes the language with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param languageId the primary key of the language
	* @return the language that was removed
	* @throws PortalException if a language with the primary key could not be found
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language deleteLanguage(
		long languageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languageLocalService.deleteLanguage(languageId);
	}

	@Override
	public it.dbb.common.language.loader.db.model.Language fetchLanguage(
		long languageId) {
		return _languageLocalService.fetchLanguage(languageId);
	}

	/**
	* Returns the language with the matching UUID and company.
	*
	* @param uuid the language's UUID
	* @param companyId the primary key of the company
	* @return the matching language, or <code>null</code> if a matching language could not be found
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language fetchLanguageByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _languageLocalService.fetchLanguageByUuidAndCompanyId(uuid,
			companyId);
	}

	@Override
	public it.dbb.common.language.loader.db.model.Language getByLanguageCodeKey(
		java.lang.String languageCode, java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languageLocalService.getByLanguageCodeKey(languageCode, key);
	}

	/**
	* Returns the language with the primary key.
	*
	* @param languageId the primary key of the language
	* @return the language
	* @throws PortalException if a language with the primary key could not be found
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language getLanguage(
		long languageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languageLocalService.getLanguage(languageId);
	}

	/**
	* Returns the language with the matching UUID and company.
	*
	* @param uuid the language's UUID
	* @param companyId the primary key of the company
	* @return the matching language
	* @throws PortalException if a matching language could not be found
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language getLanguageByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languageLocalService.getLanguageByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Updates the language in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param language the language
	* @return the language that was updated
	*/
	@Override
	public it.dbb.common.language.loader.db.model.Language updateLanguage(
		it.dbb.common.language.loader.db.model.Language language) {
		return _languageLocalService.updateLanguage(language);
	}

	@Override
	public it.dbb.common.language.loader.db.model.Language updateLanguage(
		long languageId, java.lang.String key, java.lang.String value,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _languageLocalService.updateLanguage(languageId, key, value,
			serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _languageLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _languageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.dbb.common.language.loader.db.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _languageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.dbb.common.language.loader.db.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _languageLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<it.dbb.common.language.loader.db.model.Language> findByLanguageCode(
		java.lang.String languageCode) {
		return _languageLocalService.findByLanguageCode(languageCode);
	}

	@Override
	public java.util.List<java.lang.String> getAvailableLanguageIds() {
		return _languageLocalService.getAvailableLanguageIds();
	}

	/**
	* Returns a range of all the languages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.dbb.common.language.loader.db.model.impl.LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @return the range of languages
	*/
	@Override
	public java.util.List<it.dbb.common.language.loader.db.model.Language> getLanguages(
		int start, int end) {
		return _languageLocalService.getLanguages(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _languageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _languageLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public LanguageLocalService getWrappedService() {
		return _languageLocalService;
	}

	@Override
	public void setWrappedService(LanguageLocalService languageLocalService) {
		_languageLocalService = languageLocalService;
	}

	private LanguageLocalService _languageLocalService;
}