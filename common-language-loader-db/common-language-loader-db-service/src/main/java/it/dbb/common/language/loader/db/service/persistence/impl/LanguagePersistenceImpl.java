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

package it.dbb.common.language.loader.db.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.dbb.common.language.loader.db.exception.NoSuchLanguageException;
import it.dbb.common.language.loader.db.model.Language;
import it.dbb.common.language.loader.db.model.impl.LanguageImpl;
import it.dbb.common.language.loader.db.model.impl.LanguageModelImpl;
import it.dbb.common.language.loader.db.service.persistence.LanguagePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the language service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author danielebb
 * @see LanguagePersistence
 * @see it.dbb.common.language.loader.db.service.persistence.LanguageUtil
 * @generated
 */
@ProviderType
public class LanguagePersistenceImpl extends BasePersistenceImpl<Language>
	implements LanguagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LanguageUtil} to access the language persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LanguageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LanguageModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the languages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching languages
	 */
	@Override
	public List<Language> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Language> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Language> findByUuid(String uuid, int start, int end,
		OrderByComparator<Language> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Language> findByUuid(String uuid, int start, int end,
		OrderByComparator<Language> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Language> list = null;

		if (retrieveFromCache) {
			list = (List<Language>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Language language : list) {
					if (!Objects.equals(uuid, language.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LANGUAGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first language in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language
	 * @throws NoSuchLanguageException if a matching language could not be found
	 */
	@Override
	public Language findByUuid_First(String uuid,
		OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = fetchByUuid_First(uuid, orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the first language in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByUuid_First(String uuid,
		OrderByComparator<Language> orderByComparator) {
		List<Language> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last language in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language
	 * @throws NoSuchLanguageException if a matching language could not be found
	 */
	@Override
	public Language findByUuid_Last(String uuid,
		OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = fetchByUuid_Last(uuid, orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the last language in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByUuid_Last(String uuid,
		OrderByComparator<Language> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Language> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Language[] findByUuid_PrevAndNext(long languageId, String uuid,
		OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Language[] array = new LanguageImpl[3];

			array[0] = getByUuid_PrevAndNext(session, language, uuid,
					orderByComparator, true);

			array[1] = language;

			array[2] = getByUuid_PrevAndNext(session, language, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Language getByUuid_PrevAndNext(Session session,
		Language language, String uuid,
		OrderByComparator<Language> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANGUAGE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LanguageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(language);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Language> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Language language : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(language);
		}
	}

	/**
	 * Returns the number of languages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching languages
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANGUAGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "language.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "language.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(language.uuid IS NULL OR language.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			LanguageModelImpl.UUID_COLUMN_BITMASK |
			LanguageModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the languages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching languages
	 */
	@Override
	public List<Language> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Language> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Language> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Language> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Language> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Language> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Language> list = null;

		if (retrieveFromCache) {
			list = (List<Language>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Language language : list) {
					if (!Objects.equals(uuid, language.getUuid()) ||
							(companyId != language.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LANGUAGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Language findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the first language in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Language> orderByComparator) {
		List<Language> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Language findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the last language in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Language> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Language> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Language[] findByUuid_C_PrevAndNext(long languageId, String uuid,
		long companyId, OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Language[] array = new LanguageImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, language, uuid,
					companyId, orderByComparator, true);

			array[1] = language;

			array[2] = getByUuid_C_PrevAndNext(session, language, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Language getByUuid_C_PrevAndNext(Session session,
		Language language, String uuid, long companyId,
		OrderByComparator<Language> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LANGUAGE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LanguageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(language);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Language> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Language language : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(language);
		}
	}

	/**
	 * Returns the number of languages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching languages
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LANGUAGE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "language.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "language.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(language.uuid IS NULL OR language.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "language.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGECODE =
		new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLanguageCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGECODE =
		new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLanguageCode",
			new String[] { String.class.getName() },
			LanguageModelImpl.LANGUAGECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGECODE = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLanguageCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the languages where languageCode = &#63;.
	 *
	 * @param languageCode the language code
	 * @return the matching languages
	 */
	@Override
	public List<Language> findByLanguageCode(String languageCode) {
		return findByLanguageCode(languageCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Language> findByLanguageCode(String languageCode, int start,
		int end) {
		return findByLanguageCode(languageCode, start, end, null);
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
	@Override
	public List<Language> findByLanguageCode(String languageCode, int start,
		int end, OrderByComparator<Language> orderByComparator) {
		return findByLanguageCode(languageCode, start, end, orderByComparator,
			true);
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
	@Override
	public List<Language> findByLanguageCode(String languageCode, int start,
		int end, OrderByComparator<Language> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGECODE;
			finderArgs = new Object[] { languageCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGUAGECODE;
			finderArgs = new Object[] {
					languageCode,
					
					start, end, orderByComparator
				};
		}

		List<Language> list = null;

		if (retrieveFromCache) {
			list = (List<Language>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Language language : list) {
					if (!Objects.equals(languageCode, language.getLanguageCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LANGUAGE_WHERE);

			boolean bindLanguageCode = false;

			if (languageCode == null) {
				query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_1);
			}
			else if (languageCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LanguageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLanguageCode) {
					qPos.add(languageCode);
				}

				if (!pagination) {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first language in the ordered set where languageCode = &#63;.
	 *
	 * @param languageCode the language code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language
	 * @throws NoSuchLanguageException if a matching language could not be found
	 */
	@Override
	public Language findByLanguageCode_First(String languageCode,
		OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = fetchByLanguageCode_First(languageCode,
				orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("languageCode=");
		msg.append(languageCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the first language in the ordered set where languageCode = &#63;.
	 *
	 * @param languageCode the language code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByLanguageCode_First(String languageCode,
		OrderByComparator<Language> orderByComparator) {
		List<Language> list = findByLanguageCode(languageCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last language in the ordered set where languageCode = &#63;.
	 *
	 * @param languageCode the language code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language
	 * @throws NoSuchLanguageException if a matching language could not be found
	 */
	@Override
	public Language findByLanguageCode_Last(String languageCode,
		OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = fetchByLanguageCode_Last(languageCode,
				orderByComparator);

		if (language != null) {
			return language;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("languageCode=");
		msg.append(languageCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLanguageException(msg.toString());
	}

	/**
	 * Returns the last language in the ordered set where languageCode = &#63;.
	 *
	 * @param languageCode the language code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByLanguageCode_Last(String languageCode,
		OrderByComparator<Language> orderByComparator) {
		int count = countByLanguageCode(languageCode);

		if (count == 0) {
			return null;
		}

		List<Language> list = findByLanguageCode(languageCode, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Language[] findByLanguageCode_PrevAndNext(long languageId,
		String languageCode, OrderByComparator<Language> orderByComparator)
		throws NoSuchLanguageException {
		Language language = findByPrimaryKey(languageId);

		Session session = null;

		try {
			session = openSession();

			Language[] array = new LanguageImpl[3];

			array[0] = getByLanguageCode_PrevAndNext(session, language,
					languageCode, orderByComparator, true);

			array[1] = language;

			array[2] = getByLanguageCode_PrevAndNext(session, language,
					languageCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Language getByLanguageCode_PrevAndNext(Session session,
		Language language, String languageCode,
		OrderByComparator<Language> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LANGUAGE_WHERE);

		boolean bindLanguageCode = false;

		if (languageCode == null) {
			query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_1);
		}
		else if (languageCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_3);
		}
		else {
			bindLanguageCode = true;

			query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LanguageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLanguageCode) {
			qPos.add(languageCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(language);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Language> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the languages where languageCode = &#63; from the database.
	 *
	 * @param languageCode the language code
	 */
	@Override
	public void removeByLanguageCode(String languageCode) {
		for (Language language : findByLanguageCode(languageCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(language);
		}
	}

	/**
	 * Returns the number of languages where languageCode = &#63;.
	 *
	 * @param languageCode the language code
	 * @return the number of matching languages
	 */
	@Override
	public int countByLanguageCode(String languageCode) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LANGUAGECODE;

		Object[] finderArgs = new Object[] { languageCode };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LANGUAGE_WHERE);

			boolean bindLanguageCode = false;

			if (languageCode == null) {
				query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_1);
			}
			else if (languageCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				query.append(_FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLanguageCode) {
					qPos.add(languageCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_1 = "language.languageCode IS NULL";
	private static final String _FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_2 = "language.languageCode = ?";
	private static final String _FINDER_COLUMN_LANGUAGECODE_LANGUAGECODE_3 = "(language.languageCode IS NULL OR language.languageCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_LANGUAGECODEKEY = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, LanguageImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByLanguageCodeKey",
			new String[] { String.class.getName(), String.class.getName() },
			LanguageModelImpl.LANGUAGECODE_COLUMN_BITMASK |
			LanguageModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGUAGECODEKEY = new FinderPath(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLanguageCodeKey",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the language where languageCode = &#63; and key = &#63; or throws a {@link NoSuchLanguageException} if it could not be found.
	 *
	 * @param languageCode the language code
	 * @param key the key
	 * @return the matching language
	 * @throws NoSuchLanguageException if a matching language could not be found
	 */
	@Override
	public Language findByLanguageCodeKey(String languageCode, String key)
		throws NoSuchLanguageException {
		Language language = fetchByLanguageCodeKey(languageCode, key);

		if (language == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("languageCode=");
			msg.append(languageCode);

			msg.append(", key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLanguageException(msg.toString());
		}

		return language;
	}

	/**
	 * Returns the language where languageCode = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param languageCode the language code
	 * @param key the key
	 * @return the matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByLanguageCodeKey(String languageCode, String key) {
		return fetchByLanguageCodeKey(languageCode, key, true);
	}

	/**
	 * Returns the language where languageCode = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param languageCode the language code
	 * @param key the key
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching language, or <code>null</code> if a matching language could not be found
	 */
	@Override
	public Language fetchByLanguageCodeKey(String languageCode, String key,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { languageCode, key };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY,
					finderArgs, this);
		}

		if (result instanceof Language) {
			Language language = (Language)result;

			if (!Objects.equals(languageCode, language.getLanguageCode()) ||
					!Objects.equals(key, language.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LANGUAGE_WHERE);

			boolean bindLanguageCode = false;

			if (languageCode == null) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_1);
			}
			else if (languageCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_2);
			}

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLanguageCode) {
					qPos.add(languageCode);
				}

				if (bindKey) {
					qPos.add(key);
				}

				List<Language> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY,
						finderArgs, list);
				}
				else {
					Language language = list.get(0);

					result = language;

					cacheResult(language);

					if ((language.getLanguageCode() == null) ||
							!language.getLanguageCode().equals(languageCode) ||
							(language.getKey() == null) ||
							!language.getKey().equals(key)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY,
							finderArgs, language);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Language)result;
		}
	}

	/**
	 * Removes the language where languageCode = &#63; and key = &#63; from the database.
	 *
	 * @param languageCode the language code
	 * @param key the key
	 * @return the language that was removed
	 */
	@Override
	public Language removeByLanguageCodeKey(String languageCode, String key)
		throws NoSuchLanguageException {
		Language language = findByLanguageCodeKey(languageCode, key);

		return remove(language);
	}

	/**
	 * Returns the number of languages where languageCode = &#63; and key = &#63;.
	 *
	 * @param languageCode the language code
	 * @param key the key
	 * @return the number of matching languages
	 */
	@Override
	public int countByLanguageCodeKey(String languageCode, String key) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LANGUAGECODEKEY;

		Object[] finderArgs = new Object[] { languageCode, key };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LANGUAGE_WHERE);

			boolean bindLanguageCode = false;

			if (languageCode == null) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_1);
			}
			else if (languageCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_3);
			}
			else {
				bindLanguageCode = true;

				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_2);
			}

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_LANGUAGECODEKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLanguageCode) {
					qPos.add(languageCode);
				}

				if (bindKey) {
					qPos.add(key);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_1 = "language.languageCode IS NULL AND ";
	private static final String _FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_2 = "language.languageCode = ? AND ";
	private static final String _FINDER_COLUMN_LANGUAGECODEKEY_LANGUAGECODE_3 = "(language.languageCode IS NULL OR language.languageCode = '') AND ";
	private static final String _FINDER_COLUMN_LANGUAGECODEKEY_KEY_1 = "language.key IS NULL";
	private static final String _FINDER_COLUMN_LANGUAGECODEKEY_KEY_2 = "language.key = ?";
	private static final String _FINDER_COLUMN_LANGUAGECODEKEY_KEY_3 = "(language.key IS NULL OR language.key = '')";

	public LanguagePersistenceImpl() {
		setModelClass(Language.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("key", "key_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the language in the entity cache if it is enabled.
	 *
	 * @param language the language
	 */
	@Override
	public void cacheResult(Language language) {
		entityCache.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageImpl.class, language.getPrimaryKey(), language);

		finderCache.putResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY,
			new Object[] { language.getLanguageCode(), language.getKey() },
			language);

		language.resetOriginalValues();
	}

	/**
	 * Caches the languages in the entity cache if it is enabled.
	 *
	 * @param languages the languages
	 */
	@Override
	public void cacheResult(List<Language> languages) {
		for (Language language : languages) {
			if (entityCache.getResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
						LanguageImpl.class, language.getPrimaryKey()) == null) {
				cacheResult(language);
			}
			else {
				language.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all languages.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LanguageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the language.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Language language) {
		entityCache.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageImpl.class, language.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LanguageModelImpl)language, true);
	}

	@Override
	public void clearCache(List<Language> languages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Language language : languages) {
			entityCache.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
				LanguageImpl.class, language.getPrimaryKey());

			clearUniqueFindersCache((LanguageModelImpl)language, true);
		}
	}

	protected void cacheUniqueFindersCache(LanguageModelImpl languageModelImpl) {
		Object[] args = new Object[] {
				languageModelImpl.getLanguageCode(), languageModelImpl.getKey()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_LANGUAGECODEKEY, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY, args,
			languageModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LanguageModelImpl languageModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					languageModelImpl.getLanguageCode(),
					languageModelImpl.getKey()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGECODEKEY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY, args);
		}

		if ((languageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LANGUAGECODEKEY.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					languageModelImpl.getOriginalLanguageCode(),
					languageModelImpl.getOriginalKey()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGECODEKEY, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_LANGUAGECODEKEY, args);
		}
	}

	/**
	 * Creates a new language with the primary key. Does not add the language to the database.
	 *
	 * @param languageId the primary key for the new language
	 * @return the new language
	 */
	@Override
	public Language create(long languageId) {
		Language language = new LanguageImpl();

		language.setNew(true);
		language.setPrimaryKey(languageId);

		String uuid = PortalUUIDUtil.generate();

		language.setUuid(uuid);

		language.setCompanyId(companyProvider.getCompanyId());

		return language;
	}

	/**
	 * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param languageId the primary key of the language
	 * @return the language that was removed
	 * @throws NoSuchLanguageException if a language with the primary key could not be found
	 */
	@Override
	public Language remove(long languageId) throws NoSuchLanguageException {
		return remove((Serializable)languageId);
	}

	/**
	 * Removes the language with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the language
	 * @return the language that was removed
	 * @throws NoSuchLanguageException if a language with the primary key could not be found
	 */
	@Override
	public Language remove(Serializable primaryKey)
		throws NoSuchLanguageException {
		Session session = null;

		try {
			session = openSession();

			Language language = (Language)session.get(LanguageImpl.class,
					primaryKey);

			if (language == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(language);
		}
		catch (NoSuchLanguageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Language removeImpl(Language language) {
		language = toUnwrappedModel(language);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(language)) {
				language = (Language)session.get(LanguageImpl.class,
						language.getPrimaryKeyObj());
			}

			if (language != null) {
				session.delete(language);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (language != null) {
			clearCache(language);
		}

		return language;
	}

	@Override
	public Language updateImpl(Language language) {
		language = toUnwrappedModel(language);

		boolean isNew = language.isNew();

		LanguageModelImpl languageModelImpl = (LanguageModelImpl)language;

		if (Validator.isNull(language.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			language.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (language.getCreateDate() == null)) {
			if (serviceContext == null) {
				language.setCreateDate(now);
			}
			else {
				language.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!languageModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				language.setModifiedDate(now);
			}
			else {
				language.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (language.isNew()) {
				session.save(language);

				language.setNew(false);
			}
			else {
				language = (Language)session.merge(language);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LanguageModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { languageModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					languageModelImpl.getUuid(),
					languageModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { languageModelImpl.getLanguageCode() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGECODE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGECODE,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((languageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { languageModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { languageModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((languageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						languageModelImpl.getOriginalUuid(),
						languageModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						languageModelImpl.getUuid(),
						languageModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((languageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						languageModelImpl.getOriginalLanguageCode()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGECODE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGECODE,
					args);

				args = new Object[] { languageModelImpl.getLanguageCode() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LANGUAGECODE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGUAGECODE,
					args);
			}
		}

		entityCache.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
			LanguageImpl.class, language.getPrimaryKey(), language, false);

		clearUniqueFindersCache(languageModelImpl, false);
		cacheUniqueFindersCache(languageModelImpl);

		language.resetOriginalValues();

		return language;
	}

	protected Language toUnwrappedModel(Language language) {
		if (language instanceof LanguageImpl) {
			return language;
		}

		LanguageImpl languageImpl = new LanguageImpl();

		languageImpl.setNew(language.isNew());
		languageImpl.setPrimaryKey(language.getPrimaryKey());

		languageImpl.setUuid(language.getUuid());
		languageImpl.setLanguageId(language.getLanguageId());
		languageImpl.setCompanyId(language.getCompanyId());
		languageImpl.setUserId(language.getUserId());
		languageImpl.setUserName(language.getUserName());
		languageImpl.setCreateDate(language.getCreateDate());
		languageImpl.setModifiedDate(language.getModifiedDate());
		languageImpl.setKey(language.getKey());
		languageImpl.setLanguageCode(language.getLanguageCode());
		languageImpl.setValue(language.getValue());

		return languageImpl;
	}

	/**
	 * Returns the language with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the language
	 * @return the language
	 * @throws NoSuchLanguageException if a language with the primary key could not be found
	 */
	@Override
	public Language findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLanguageException {
		Language language = fetchByPrimaryKey(primaryKey);

		if (language == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLanguageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return language;
	}

	/**
	 * Returns the language with the primary key or throws a {@link NoSuchLanguageException} if it could not be found.
	 *
	 * @param languageId the primary key of the language
	 * @return the language
	 * @throws NoSuchLanguageException if a language with the primary key could not be found
	 */
	@Override
	public Language findByPrimaryKey(long languageId)
		throws NoSuchLanguageException {
		return findByPrimaryKey((Serializable)languageId);
	}

	/**
	 * Returns the language with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the language
	 * @return the language, or <code>null</code> if a language with the primary key could not be found
	 */
	@Override
	public Language fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
				LanguageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Language language = (Language)serializable;

		if (language == null) {
			Session session = null;

			try {
				session = openSession();

				language = (Language)session.get(LanguageImpl.class, primaryKey);

				if (language != null) {
					cacheResult(language);
				}
				else {
					entityCache.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
						LanguageImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
					LanguageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return language;
	}

	/**
	 * Returns the language with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param languageId the primary key of the language
	 * @return the language, or <code>null</code> if a language with the primary key could not be found
	 */
	@Override
	public Language fetchByPrimaryKey(long languageId) {
		return fetchByPrimaryKey((Serializable)languageId);
	}

	@Override
	public Map<Serializable, Language> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Language> map = new HashMap<Serializable, Language>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Language language = fetchByPrimaryKey(primaryKey);

			if (language != null) {
				map.put(primaryKey, language);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
					LanguageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Language)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LANGUAGE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Language language : (List<Language>)q.list()) {
				map.put(language.getPrimaryKeyObj(), language);

				cacheResult(language);

				uncachedPrimaryKeys.remove(language.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LanguageModelImpl.ENTITY_CACHE_ENABLED,
					LanguageImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the languages.
	 *
	 * @return the languages
	 */
	@Override
	public List<Language> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Language> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Language> findAll(int start, int end,
		OrderByComparator<Language> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Language> findAll(int start, int end,
		OrderByComparator<Language> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Language> list = null;

		if (retrieveFromCache) {
			list = (List<Language>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LANGUAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LANGUAGE;

				if (pagination) {
					sql = sql.concat(LanguageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Language>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the languages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Language language : findAll()) {
			remove(language);
		}
	}

	/**
	 * Returns the number of languages.
	 *
	 * @return the number of languages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LANGUAGE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LanguageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the language persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LanguageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LANGUAGE = "SELECT language FROM Language language";
	private static final String _SQL_SELECT_LANGUAGE_WHERE_PKS_IN = "SELECT language FROM Language language WHERE languageId IN (";
	private static final String _SQL_SELECT_LANGUAGE_WHERE = "SELECT language FROM Language language WHERE ";
	private static final String _SQL_COUNT_LANGUAGE = "SELECT COUNT(language) FROM Language language";
	private static final String _SQL_COUNT_LANGUAGE_WHERE = "SELECT COUNT(language) FROM Language language WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "language.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Language exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Language exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LanguagePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "key"
			});
}