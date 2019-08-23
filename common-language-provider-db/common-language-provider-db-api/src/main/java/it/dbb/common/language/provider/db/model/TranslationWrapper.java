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

package it.dbb.common.language.provider.db.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Translation}.
 * </p>
 *
 * @author danielebb
 * @see Translation
 * @generated
 */
@ProviderType
public class TranslationWrapper
	implements Translation, ModelWrapper<Translation> {

	public TranslationWrapper(Translation translation) {
		_translation = translation;
	}

	@Override
	public Class<?> getModelClass() {
		return Translation.class;
	}

	@Override
	public String getModelClassName() {
		return Translation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("translationId", getTranslationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("key", getKey());
		attributes.put("language", getLanguage());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long translationId = (Long)attributes.get("translationId");

		if (translationId != null) {
			setTranslationId(translationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public Object clone() {
		return new TranslationWrapper((Translation)_translation.clone());
	}

	@Override
	public int compareTo(
		it.dbb.common.language.provider.db.model.Translation translation) {

		return _translation.compareTo(translation);
	}

	/**
	 * Returns the company ID of this translation.
	 *
	 * @return the company ID of this translation
	 */
	@Override
	public long getCompanyId() {
		return _translation.getCompanyId();
	}

	/**
	 * Returns the create date of this translation.
	 *
	 * @return the create date of this translation
	 */
	@Override
	public Date getCreateDate() {
		return _translation.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _translation.getExpandoBridge();
	}

	/**
	 * Returns the key of this translation.
	 *
	 * @return the key of this translation
	 */
	@Override
	public String getKey() {
		return _translation.getKey();
	}

	/**
	 * Returns the language of this translation.
	 *
	 * @return the language of this translation
	 */
	@Override
	public String getLanguage() {
		return _translation.getLanguage();
	}

	/**
	 * Returns the modified date of this translation.
	 *
	 * @return the modified date of this translation
	 */
	@Override
	public Date getModifiedDate() {
		return _translation.getModifiedDate();
	}

	/**
	 * Returns the primary key of this translation.
	 *
	 * @return the primary key of this translation
	 */
	@Override
	public long getPrimaryKey() {
		return _translation.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _translation.getPrimaryKeyObj();
	}

	/**
	 * Returns the translation ID of this translation.
	 *
	 * @return the translation ID of this translation
	 */
	@Override
	public long getTranslationId() {
		return _translation.getTranslationId();
	}

	/**
	 * Returns the user ID of this translation.
	 *
	 * @return the user ID of this translation
	 */
	@Override
	public long getUserId() {
		return _translation.getUserId();
	}

	/**
	 * Returns the user name of this translation.
	 *
	 * @return the user name of this translation
	 */
	@Override
	public String getUserName() {
		return _translation.getUserName();
	}

	/**
	 * Returns the user uuid of this translation.
	 *
	 * @return the user uuid of this translation
	 */
	@Override
	public String getUserUuid() {
		return _translation.getUserUuid();
	}

	/**
	 * Returns the uuid of this translation.
	 *
	 * @return the uuid of this translation
	 */
	@Override
	public String getUuid() {
		return _translation.getUuid();
	}

	/**
	 * Returns the value of this translation.
	 *
	 * @return the value of this translation
	 */
	@Override
	public String getValue() {
		return _translation.getValue();
	}

	@Override
	public int hashCode() {
		return _translation.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _translation.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _translation.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _translation.isNew();
	}

	@Override
	public void persist() {
		_translation.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_translation.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this translation.
	 *
	 * @param companyId the company ID of this translation
	 */
	@Override
	public void setCompanyId(long companyId) {
		_translation.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this translation.
	 *
	 * @param createDate the create date of this translation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_translation.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_translation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_translation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_translation.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the key of this translation.
	 *
	 * @param key the key of this translation
	 */
	@Override
	public void setKey(String key) {
		_translation.setKey(key);
	}

	/**
	 * Sets the language of this translation.
	 *
	 * @param language the language of this translation
	 */
	@Override
	public void setLanguage(String language) {
		_translation.setLanguage(language);
	}

	/**
	 * Sets the modified date of this translation.
	 *
	 * @param modifiedDate the modified date of this translation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_translation.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_translation.setNew(n);
	}

	/**
	 * Sets the primary key of this translation.
	 *
	 * @param primaryKey the primary key of this translation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_translation.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_translation.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the translation ID of this translation.
	 *
	 * @param translationId the translation ID of this translation
	 */
	@Override
	public void setTranslationId(long translationId) {
		_translation.setTranslationId(translationId);
	}

	/**
	 * Sets the user ID of this translation.
	 *
	 * @param userId the user ID of this translation
	 */
	@Override
	public void setUserId(long userId) {
		_translation.setUserId(userId);
	}

	/**
	 * Sets the user name of this translation.
	 *
	 * @param userName the user name of this translation
	 */
	@Override
	public void setUserName(String userName) {
		_translation.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this translation.
	 *
	 * @param userUuid the user uuid of this translation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_translation.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this translation.
	 *
	 * @param uuid the uuid of this translation
	 */
	@Override
	public void setUuid(String uuid) {
		_translation.setUuid(uuid);
	}

	/**
	 * Sets the value of this translation.
	 *
	 * @param value the value of this translation
	 */
	@Override
	public void setValue(String value) {
		_translation.setValue(value);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.dbb.common.language.provider.db.model.Translation> toCacheModel() {

		return _translation.toCacheModel();
	}

	@Override
	public it.dbb.common.language.provider.db.model.Translation
		toEscapedModel() {

		return new TranslationWrapper(_translation.toEscapedModel());
	}

	@Override
	public String toString() {
		return _translation.toString();
	}

	@Override
	public it.dbb.common.language.provider.db.model.Translation
		toUnescapedModel() {

		return new TranslationWrapper(_translation.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _translation.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TranslationWrapper)) {
			return false;
		}

		TranslationWrapper translationWrapper = (TranslationWrapper)obj;

		if (Objects.equals(_translation, translationWrapper._translation)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _translation.getStagedModelType();
	}

	@Override
	public Translation getWrappedModel() {
		return _translation;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _translation.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _translation.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_translation.resetOriginalValues();
	}

	private final Translation _translation;

}