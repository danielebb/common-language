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

package it.dbb.common.language.provider.db.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Translation. This utility wraps
 * <code>it.dbb.common.language.provider.db.service.impl.TranslationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author danielebb
 * @see TranslationLocalService
 * @generated
 */
@ProviderType
public class TranslationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.dbb.common.language.provider.db.service.impl.TranslationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the translation to the database. Also notifies the appropriate model listeners.
	 *
	 * @param translation the translation
	 * @return the translation that was added
	 */
	public static it.dbb.common.language.provider.db.model.Translation
		addTranslation(
			it.dbb.common.language.provider.db.model.Translation translation) {

		return getService().addTranslation(translation);
	}

	public static it.dbb.common.language.provider.db.model.Translation
			addTranslation(
				it.dbb.common.language.provider.db.context.
					TranslationModelContext translationModelContext,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws it.dbb.common.language.provider.db.exception.
			DuplicateTranslationException,
			   it.dbb.common.language.provider.db.exception.
				   InvalidTranslationException {

		return getService().addTranslation(
			translationModelContext, serviceContext);
	}

	public static int countTranslationByLanguage(String language) {
		return getService().countTranslationByLanguage(language);
	}

	public static it.dbb.common.language.provider.db.model.Translation
		createDraft() {

		return getService().createDraft();
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param translationId the primary key for the new translation
	 * @return the new translation
	 */
	public static it.dbb.common.language.provider.db.model.Translation
		createTranslation(long translationId) {

		return getService().createTranslation(translationId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation that was removed
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	public static it.dbb.common.language.provider.db.model.Translation
			deleteTranslation(long translationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTranslation(translationId);
	}

	/**
	 * Deletes the translation from the database. Also notifies the appropriate model listeners.
	 *
	 * @param translation the translation
	 * @return the translation that was removed
	 */
	public static it.dbb.common.language.provider.db.model.Translation
		deleteTranslation(
			it.dbb.common.language.provider.db.model.Translation translation) {

		return getService().deleteTranslation(translation);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.dbb.common.language.provider.db.model.impl.TranslationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.dbb.common.language.provider.db.model.impl.TranslationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
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

	public static it.dbb.common.language.provider.db.model.Translation
		fetchByLocaleKey(java.util.Locale locale, String key) {

		return getService().fetchByLocaleKey(locale, key);
	}

	public static it.dbb.common.language.provider.db.model.Translation
		fetchTranslation(long translationId) {

		return getService().fetchTranslation(translationId);
	}

	/**
	 * Returns the translation with the matching UUID and company.
	 *
	 * @param uuid the translation's UUID
	 * @param companyId the primary key of the company
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static it.dbb.common.language.provider.db.model.Translation
		fetchTranslationByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchTranslationByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<it.dbb.common.language.provider.db.model.Translation> getByLocale(
			java.util.Locale locale) {

		return getService().getByLocale(locale);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<java.util.Locale> getSupportedLocales() {
		return getService().getSupportedLocales();
	}

	/**
	 * Returns the translation with the primary key.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	public static it.dbb.common.language.provider.db.model.Translation
			getTranslation(long translationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTranslation(translationId);
	}

	public static java.util.List
		<it.dbb.common.language.provider.db.model.Translation>
			getTranslationByLanguage(
				String language,
				com.liferay.portal.kernel.dao.orm.QueryDefinition
					<it.dbb.common.language.provider.db.model.Translation> qd) {

		return getService().getTranslationByLanguage(language, qd);
	}

	/**
	 * Returns the translation with the matching UUID and company.
	 *
	 * @param uuid the translation's UUID
	 * @param companyId the primary key of the company
	 * @return the matching translation
	 * @throws PortalException if a matching translation could not be found
	 */
	public static it.dbb.common.language.provider.db.model.Translation
			getTranslationByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTranslationByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.dbb.common.language.provider.db.model.impl.TranslationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of translations
	 */
	public static java.util.List
		<it.dbb.common.language.provider.db.model.Translation> getTranslations(
			int start, int end) {

		return getService().getTranslations(start, end);
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	public static int getTranslationsCount() {
		return getService().getTranslationsCount();
	}

	public static it.dbb.common.language.provider.db.model.Translation
			updateTranslation(
				long translationId,
				it.dbb.common.language.provider.db.context.
					TranslationModelContext translationModelContext,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTranslation(
			translationId, translationModelContext, serviceContext);
	}

	/**
	 * Updates the translation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param translation the translation
	 * @return the translation that was updated
	 */
	public static it.dbb.common.language.provider.db.model.Translation
		updateTranslation(
			it.dbb.common.language.provider.db.model.Translation translation) {

		return getService().updateTranslation(translation);
	}

	public static TranslationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TranslationLocalService, TranslationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TranslationLocalService.class);

		ServiceTracker<TranslationLocalService, TranslationLocalService>
			serviceTracker =
				new ServiceTracker
					<TranslationLocalService, TranslationLocalService>(
						bundle.getBundleContext(),
						TranslationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}