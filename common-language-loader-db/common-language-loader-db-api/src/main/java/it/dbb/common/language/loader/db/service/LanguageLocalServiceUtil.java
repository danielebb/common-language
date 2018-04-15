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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Language. This utility wraps
 * {@link it.dbb.common.language.loader.db.service.impl.LanguageLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author danielebb
 * @see LanguageLocalService
 * @see it.dbb.common.language.loader.db.service.base.LanguageLocalServiceBaseImpl
 * @see it.dbb.common.language.loader.db.service.impl.LanguageLocalServiceImpl
 * @generated
 */
@ProviderType
public class LanguageLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.dbb.common.language.loader.db.service.impl.LanguageLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int countByLanguage(java.lang.String languageCode) {
		return getService().countByLanguage(languageCode);
	}

	/**
	* Returns the number of languages.
	*
	* @return the number of languages
	*/
	public static int getLanguagesCount() {
		return getService().getLanguagesCount();
	}

	/**
	* Adds the language to the database. Also notifies the appropriate model listeners.
	*
	* @param language the language
	* @return the language that was added
	*/
	public static it.dbb.common.language.loader.db.model.Language addLanguage(
		it.dbb.common.language.loader.db.model.Language language) {
		return getService().addLanguage(language);
	}

	public static it.dbb.common.language.loader.db.model.Language addLanguage(
		java.lang.String key, java.lang.String languageCode,
		java.lang.String value,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return getService().addLanguage(key, languageCode, value, serviceContext);
	}

	/**
	* Creates a new language with the primary key. Does not add the language to the database.
	*
	* @param languageId the primary key for the new language
	* @return the new language
	*/
	public static it.dbb.common.language.loader.db.model.Language createLanguage(
		long languageId) {
		return getService().createLanguage(languageId);
	}

	/**
	* Deletes the language from the database. Also notifies the appropriate model listeners.
	*
	* @param language the language
	* @return the language that was removed
	*/
	public static it.dbb.common.language.loader.db.model.Language deleteLanguage(
		it.dbb.common.language.loader.db.model.Language language) {
		return getService().deleteLanguage(language);
	}

	/**
	* Deletes the language with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param languageId the primary key of the language
	* @return the language that was removed
	* @throws PortalException if a language with the primary key could not be found
	*/
	public static it.dbb.common.language.loader.db.model.Language deleteLanguage(
		long languageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLanguage(languageId);
	}

	public static it.dbb.common.language.loader.db.model.Language fetchLanguage(
		long languageId) {
		return getService().fetchLanguage(languageId);
	}

	/**
	* Returns the language with the matching UUID and company.
	*
	* @param uuid the language's UUID
	* @param companyId the primary key of the company
	* @return the matching language, or <code>null</code> if a matching language could not be found
	*/
	public static it.dbb.common.language.loader.db.model.Language fetchLanguageByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().fetchLanguageByUuidAndCompanyId(uuid, companyId);
	}

	public static it.dbb.common.language.loader.db.model.Language getByLanguageCodeKey(
		java.lang.String languageCode, java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getByLanguageCodeKey(languageCode, key);
	}

	/**
	* Returns the language with the primary key.
	*
	* @param languageId the primary key of the language
	* @return the language
	* @throws PortalException if a language with the primary key could not be found
	*/
	public static it.dbb.common.language.loader.db.model.Language getLanguage(
		long languageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLanguage(languageId);
	}

	/**
	* Returns the language with the matching UUID and company.
	*
	* @param uuid the language's UUID
	* @param companyId the primary key of the company
	* @return the matching language
	* @throws PortalException if a matching language could not be found
	*/
	public static it.dbb.common.language.loader.db.model.Language getLanguageByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLanguageByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Updates the language in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param language the language
	* @return the language that was updated
	*/
	public static it.dbb.common.language.loader.db.model.Language updateLanguage(
		it.dbb.common.language.loader.db.model.Language language) {
		return getService().updateLanguage(language);
	}

	public static it.dbb.common.language.loader.db.model.Language updateLanguage(
		long languageId, java.lang.String key, java.lang.String value,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateLanguage(languageId, key, value, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<it.dbb.common.language.loader.db.model.Language> findByLanguageCode(
		java.lang.String languageCode) {
		return getService().findByLanguageCode(languageCode);
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
	public static java.util.List<it.dbb.common.language.loader.db.model.Language> getLanguages(
		int start, int end) {
		return getService().getLanguages(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static LanguageLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LanguageLocalService, LanguageLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LanguageLocalService.class);
}