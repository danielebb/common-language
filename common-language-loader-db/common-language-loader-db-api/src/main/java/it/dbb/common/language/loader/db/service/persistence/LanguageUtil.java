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

package it.dbb.common.language.loader.db.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.dbb.common.language.loader.db.model.Language;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the language service. This utility wraps {@link it.dbb.common.language.loader.db.service.persistence.impl.LanguagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author danielebb
 * @see LanguagePersistence
 * @see it.dbb.common.language.loader.db.service.persistence.impl.LanguagePersistenceImpl
 * @generated
 */
@ProviderType
public class LanguageUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Language language) {
		getPersistence().clearCache(language);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Language> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Language> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Language> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Language update(Language language) {
		return getPersistence().update(language);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Language update(Language language,
		ServiceContext serviceContext) {
		return getPersistence().update(language, serviceContext);
	}

	/**
	* Returns all the languages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching languages
	*/
	public static List<Language> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the languages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @return the range of matching languages
	*/
	public static List<Language> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the languages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching languages
	*/
	public static List<Language> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Language> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the languages where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching languages
	*/
	public static List<Language> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Language> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public static Language findByUuid_First(java.lang.String uuid,
		OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public static Language findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the languages before and after the current language in the ordered set where uuid = &#63;.
	*
	* @param languageId the primary key of the current language
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next language
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public static Language[] findByUuid_PrevAndNext(long languageId,
		java.lang.String uuid, OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence()
				   .findByUuid_PrevAndNext(languageId, uuid, orderByComparator);
	}

	/**
	* Removes all the languages where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of languages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching languages
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the languages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching languages
	*/
	public static List<Language> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the languages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @return the range of matching languages
	*/
	public static List<Language> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the languages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching languages
	*/
	public static List<Language> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the languages where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching languages
	*/
	public static List<Language> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Language> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public static Language findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Language> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public static Language findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Language> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the languages before and after the current language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param languageId the primary key of the current language
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next language
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public static Language[] findByUuid_C_PrevAndNext(long languageId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(languageId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the languages where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of languages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching languages
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the languages where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @return the matching languages
	*/
	public static List<Language> findByLanguageCode(
		java.lang.String languageCode) {
		return getPersistence().findByLanguageCode(languageCode);
	}

	/**
	* Returns a range of all the languages where languageCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param languageCode the language code
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @return the range of matching languages
	*/
	public static List<Language> findByLanguageCode(
		java.lang.String languageCode, int start, int end) {
		return getPersistence().findByLanguageCode(languageCode, start, end);
	}

	/**
	* Returns an ordered range of all the languages where languageCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param languageCode the language code
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching languages
	*/
	public static List<Language> findByLanguageCode(
		java.lang.String languageCode, int start, int end,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence()
				   .findByLanguageCode(languageCode, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the languages where languageCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param languageCode the language code
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching languages
	*/
	public static List<Language> findByLanguageCode(
		java.lang.String languageCode, int start, int end,
		OrderByComparator<Language> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByLanguageCode(languageCode, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public static Language findByLanguageCode_First(
		java.lang.String languageCode,
		OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence()
				   .findByLanguageCode_First(languageCode, orderByComparator);
	}

	/**
	* Returns the first language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByLanguageCode_First(
		java.lang.String languageCode,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence()
				   .fetchByLanguageCode_First(languageCode, orderByComparator);
	}

	/**
	* Returns the last language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public static Language findByLanguageCode_Last(
		java.lang.String languageCode,
		OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence()
				   .findByLanguageCode_Last(languageCode, orderByComparator);
	}

	/**
	* Returns the last language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByLanguageCode_Last(
		java.lang.String languageCode,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence()
				   .fetchByLanguageCode_Last(languageCode, orderByComparator);
	}

	/**
	* Returns the languages before and after the current language in the ordered set where languageCode = &#63;.
	*
	* @param languageId the primary key of the current language
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next language
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public static Language[] findByLanguageCode_PrevAndNext(long languageId,
		java.lang.String languageCode,
		OrderByComparator<Language> orderByComparator)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence()
				   .findByLanguageCode_PrevAndNext(languageId, languageCode,
			orderByComparator);
	}

	/**
	* Removes all the languages where languageCode = &#63; from the database.
	*
	* @param languageCode the language code
	*/
	public static void removeByLanguageCode(java.lang.String languageCode) {
		getPersistence().removeByLanguageCode(languageCode);
	}

	/**
	* Returns the number of languages where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @return the number of matching languages
	*/
	public static int countByLanguageCode(java.lang.String languageCode) {
		return getPersistence().countByLanguageCode(languageCode);
	}

	/**
	* Returns the language where languageCode = &#63; and key = &#63; or throws a {@link NoSuchLanguageException} if it could not be found.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public static Language findByLanguageCodeKey(
		java.lang.String languageCode, java.lang.String key)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence().findByLanguageCodeKey(languageCode, key);
	}

	/**
	* Returns the language where languageCode = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByLanguageCodeKey(
		java.lang.String languageCode, java.lang.String key) {
		return getPersistence().fetchByLanguageCodeKey(languageCode, key);
	}

	/**
	* Returns the language where languageCode = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param languageCode the language code
	* @param key the key
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching language, or <code>null</code> if a matching language could not be found
	*/
	public static Language fetchByLanguageCodeKey(
		java.lang.String languageCode, java.lang.String key,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByLanguageCodeKey(languageCode, key, retrieveFromCache);
	}

	/**
	* Removes the language where languageCode = &#63; and key = &#63; from the database.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the language that was removed
	*/
	public static Language removeByLanguageCodeKey(
		java.lang.String languageCode, java.lang.String key)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence().removeByLanguageCodeKey(languageCode, key);
	}

	/**
	* Returns the number of languages where languageCode = &#63; and key = &#63;.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the number of matching languages
	*/
	public static int countByLanguageCodeKey(java.lang.String languageCode,
		java.lang.String key) {
		return getPersistence().countByLanguageCodeKey(languageCode, key);
	}

	/**
	* Caches the language in the entity cache if it is enabled.
	*
	* @param language the language
	*/
	public static void cacheResult(Language language) {
		getPersistence().cacheResult(language);
	}

	/**
	* Caches the languages in the entity cache if it is enabled.
	*
	* @param languages the languages
	*/
	public static void cacheResult(List<Language> languages) {
		getPersistence().cacheResult(languages);
	}

	/**
	* Creates a new language with the primary key. Does not add the language to the database.
	*
	* @param languageId the primary key for the new language
	* @return the new language
	*/
	public static Language create(long languageId) {
		return getPersistence().create(languageId);
	}

	/**
	* Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param languageId the primary key of the language
	* @return the language that was removed
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public static Language remove(long languageId)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence().remove(languageId);
	}

	public static Language updateImpl(Language language) {
		return getPersistence().updateImpl(language);
	}

	/**
	* Returns the language with the primary key or throws a {@link NoSuchLanguageException} if it could not be found.
	*
	* @param languageId the primary key of the language
	* @return the language
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public static Language findByPrimaryKey(long languageId)
		throws it.dbb.common.language.loader.db.exception.NoSuchLanguageException {
		return getPersistence().findByPrimaryKey(languageId);
	}

	/**
	* Returns the language with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param languageId the primary key of the language
	* @return the language, or <code>null</code> if a language with the primary key could not be found
	*/
	public static Language fetchByPrimaryKey(long languageId) {
		return getPersistence().fetchByPrimaryKey(languageId);
	}

	public static java.util.Map<java.io.Serializable, Language> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the languages.
	*
	* @return the languages
	*/
	public static List<Language> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the languages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @return the range of languages
	*/
	public static List<Language> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the languages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of languages
	*/
	public static List<Language> findAll(int start, int end,
		OrderByComparator<Language> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the languages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LanguageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of languages
	* @param end the upper bound of the range of languages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of languages
	*/
	public static List<Language> findAll(int start, int end,
		OrderByComparator<Language> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the languages from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of languages.
	*
	* @return the number of languages
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LanguagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LanguagePersistence, LanguagePersistence> _serviceTracker =
		ServiceTrackerFactory.open(LanguagePersistence.class);
}