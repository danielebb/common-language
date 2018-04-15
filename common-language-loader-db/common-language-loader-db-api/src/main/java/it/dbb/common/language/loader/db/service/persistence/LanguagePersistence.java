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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.dbb.common.language.loader.db.exception.NoSuchLanguageException;
import it.dbb.common.language.loader.db.model.Language;

/**
 * The persistence interface for the language service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author danielebb
 * @see it.dbb.common.language.loader.db.service.persistence.impl.LanguagePersistenceImpl
 * @see LanguageUtil
 * @generated
 */
@ProviderType
public interface LanguagePersistence extends BasePersistence<Language> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LanguageUtil} to access the language persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the languages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching languages
	*/
	public java.util.List<Language> findByUuid(java.lang.String uuid);

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
	public java.util.List<Language> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<Language> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

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
	public java.util.List<Language> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public Language findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Returns the first language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

	/**
	* Returns the last language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public Language findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Returns the last language in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

	/**
	* Returns the languages before and after the current language in the ordered set where uuid = &#63;.
	*
	* @param languageId the primary key of the current language
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next language
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public Language[] findByUuid_PrevAndNext(long languageId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Removes all the languages where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of languages where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching languages
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns all the languages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching languages
	*/
	public java.util.List<Language> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Language> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Language> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

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
	public java.util.List<Language> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public Language findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Returns the first language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

	/**
	* Returns the last language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public Language findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Returns the last language in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

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
	public Language[] findByUuid_C_PrevAndNext(long languageId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Removes all the languages where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of languages where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching languages
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the languages where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @return the matching languages
	*/
	public java.util.List<Language> findByLanguageCode(
		java.lang.String languageCode);

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
	public java.util.List<Language> findByLanguageCode(
		java.lang.String languageCode, int start, int end);

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
	public java.util.List<Language> findByLanguageCode(
		java.lang.String languageCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

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
	public java.util.List<Language> findByLanguageCode(
		java.lang.String languageCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public Language findByLanguageCode_First(java.lang.String languageCode,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Returns the first language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByLanguageCode_First(java.lang.String languageCode,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

	/**
	* Returns the last language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public Language findByLanguageCode_Last(java.lang.String languageCode,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Returns the last language in the ordered set where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByLanguageCode_Last(java.lang.String languageCode,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

	/**
	* Returns the languages before and after the current language in the ordered set where languageCode = &#63;.
	*
	* @param languageId the primary key of the current language
	* @param languageCode the language code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next language
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public Language[] findByLanguageCode_PrevAndNext(long languageId,
		java.lang.String languageCode,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException;

	/**
	* Removes all the languages where languageCode = &#63; from the database.
	*
	* @param languageCode the language code
	*/
	public void removeByLanguageCode(java.lang.String languageCode);

	/**
	* Returns the number of languages where languageCode = &#63;.
	*
	* @param languageCode the language code
	* @return the number of matching languages
	*/
	public int countByLanguageCode(java.lang.String languageCode);

	/**
	* Returns the language where languageCode = &#63; and key = &#63; or throws a {@link NoSuchLanguageException} if it could not be found.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the matching language
	* @throws NoSuchLanguageException if a matching language could not be found
	*/
	public Language findByLanguageCodeKey(java.lang.String languageCode,
		java.lang.String key) throws NoSuchLanguageException;

	/**
	* Returns the language where languageCode = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByLanguageCodeKey(java.lang.String languageCode,
		java.lang.String key);

	/**
	* Returns the language where languageCode = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param languageCode the language code
	* @param key the key
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching language, or <code>null</code> if a matching language could not be found
	*/
	public Language fetchByLanguageCodeKey(java.lang.String languageCode,
		java.lang.String key, boolean retrieveFromCache);

	/**
	* Removes the language where languageCode = &#63; and key = &#63; from the database.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the language that was removed
	*/
	public Language removeByLanguageCodeKey(java.lang.String languageCode,
		java.lang.String key) throws NoSuchLanguageException;

	/**
	* Returns the number of languages where languageCode = &#63; and key = &#63;.
	*
	* @param languageCode the language code
	* @param key the key
	* @return the number of matching languages
	*/
	public int countByLanguageCodeKey(java.lang.String languageCode,
		java.lang.String key);

	/**
	* Caches the language in the entity cache if it is enabled.
	*
	* @param language the language
	*/
	public void cacheResult(Language language);

	/**
	* Caches the languages in the entity cache if it is enabled.
	*
	* @param languages the languages
	*/
	public void cacheResult(java.util.List<Language> languages);

	/**
	* Creates a new language with the primary key. Does not add the language to the database.
	*
	* @param languageId the primary key for the new language
	* @return the new language
	*/
	public Language create(long languageId);

	/**
	* Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param languageId the primary key of the language
	* @return the language that was removed
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public Language remove(long languageId) throws NoSuchLanguageException;

	public Language updateImpl(Language language);

	/**
	* Returns the language with the primary key or throws a {@link NoSuchLanguageException} if it could not be found.
	*
	* @param languageId the primary key of the language
	* @return the language
	* @throws NoSuchLanguageException if a language with the primary key could not be found
	*/
	public Language findByPrimaryKey(long languageId)
		throws NoSuchLanguageException;

	/**
	* Returns the language with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param languageId the primary key of the language
	* @return the language, or <code>null</code> if a language with the primary key could not be found
	*/
	public Language fetchByPrimaryKey(long languageId);

	@Override
	public java.util.Map<java.io.Serializable, Language> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the languages.
	*
	* @return the languages
	*/
	public java.util.List<Language> findAll();

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
	public java.util.List<Language> findAll(int start, int end);

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
	public java.util.List<Language> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator);

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
	public java.util.List<Language> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Language> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the languages from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of languages.
	*
	* @return the number of languages
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}