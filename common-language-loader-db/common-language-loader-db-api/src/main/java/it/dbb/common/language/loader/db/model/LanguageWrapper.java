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

package it.dbb.common.language.loader.db.model;

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
 * This class is a wrapper for {@link Language}.
 * </p>
 *
 * @author danielebb
 * @see Language
 * @generated
 */
@ProviderType
public class LanguageWrapper implements Language, ModelWrapper<Language> {
	public LanguageWrapper(Language language) {
		_language = language;
	}

	@Override
	public Class<?> getModelClass() {
		return Language.class;
	}

	@Override
	public String getModelClassName() {
		return Language.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("languageId", getLanguageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("key", getKey());
		attributes.put("languageCode", getLanguageCode());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long languageId = (Long)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
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

		String languageCode = (String)attributes.get("languageCode");

		if (languageCode != null) {
			setLanguageCode(languageCode);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _language.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _language.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _language.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _language.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<it.dbb.common.language.loader.db.model.Language> toCacheModel() {
		return _language.toCacheModel();
	}

	@Override
	public int compareTo(
		it.dbb.common.language.loader.db.model.Language language) {
		return _language.compareTo(language);
	}

	@Override
	public int hashCode() {
		return _language.hashCode();
	}

	@Override
	public it.dbb.common.language.loader.db.model.Language toEscapedModel() {
		return new LanguageWrapper(_language.toEscapedModel());
	}

	@Override
	public it.dbb.common.language.loader.db.model.Language toUnescapedModel() {
		return new LanguageWrapper(_language.toUnescapedModel());
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _language.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LanguageWrapper((Language)_language.clone());
	}

	/**
	* Returns the key of this language.
	*
	* @return the key of this language
	*/
	@Override
	public java.lang.String getKey() {
		return _language.getKey();
	}

	/**
	* Returns the language code of this language.
	*
	* @return the language code of this language
	*/
	@Override
	public java.lang.String getLanguageCode() {
		return _language.getLanguageCode();
	}

	/**
	* Returns the user name of this language.
	*
	* @return the user name of this language
	*/
	@Override
	public java.lang.String getUserName() {
		return _language.getUserName();
	}

	/**
	* Returns the user uuid of this language.
	*
	* @return the user uuid of this language
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _language.getUserUuid();
	}

	/**
	* Returns the uuid of this language.
	*
	* @return the uuid of this language
	*/
	@Override
	public java.lang.String getUuid() {
		return _language.getUuid();
	}

	/**
	* Returns the value of this language.
	*
	* @return the value of this language
	*/
	@Override
	public java.lang.String getValue() {
		return _language.getValue();
	}

	@Override
	public java.lang.String toString() {
		return _language.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _language.toXmlString();
	}

	/**
	* Returns the create date of this language.
	*
	* @return the create date of this language
	*/
	@Override
	public Date getCreateDate() {
		return _language.getCreateDate();
	}

	/**
	* Returns the modified date of this language.
	*
	* @return the modified date of this language
	*/
	@Override
	public Date getModifiedDate() {
		return _language.getModifiedDate();
	}

	/**
	* Returns the company ID of this language.
	*
	* @return the company ID of this language
	*/
	@Override
	public long getCompanyId() {
		return _language.getCompanyId();
	}

	/**
	* Returns the language ID of this language.
	*
	* @return the language ID of this language
	*/
	@Override
	public long getLanguageId() {
		return _language.getLanguageId();
	}

	/**
	* Returns the primary key of this language.
	*
	* @return the primary key of this language
	*/
	@Override
	public long getPrimaryKey() {
		return _language.getPrimaryKey();
	}

	/**
	* Returns the user ID of this language.
	*
	* @return the user ID of this language
	*/
	@Override
	public long getUserId() {
		return _language.getUserId();
	}

	@Override
	public void persist() {
		_language.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_language.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this language.
	*
	* @param companyId the company ID of this language
	*/
	@Override
	public void setCompanyId(long companyId) {
		_language.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this language.
	*
	* @param createDate the create date of this language
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_language.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_language.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_language.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_language.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the key of this language.
	*
	* @param key the key of this language
	*/
	@Override
	public void setKey(java.lang.String key) {
		_language.setKey(key);
	}

	/**
	* Sets the language code of this language.
	*
	* @param languageCode the language code of this language
	*/
	@Override
	public void setLanguageCode(java.lang.String languageCode) {
		_language.setLanguageCode(languageCode);
	}

	/**
	* Sets the language ID of this language.
	*
	* @param languageId the language ID of this language
	*/
	@Override
	public void setLanguageId(long languageId) {
		_language.setLanguageId(languageId);
	}

	/**
	* Sets the modified date of this language.
	*
	* @param modifiedDate the modified date of this language
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_language.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_language.setNew(n);
	}

	/**
	* Sets the primary key of this language.
	*
	* @param primaryKey the primary key of this language
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_language.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_language.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this language.
	*
	* @param userId the user ID of this language
	*/
	@Override
	public void setUserId(long userId) {
		_language.setUserId(userId);
	}

	/**
	* Sets the user name of this language.
	*
	* @param userName the user name of this language
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_language.setUserName(userName);
	}

	/**
	* Sets the user uuid of this language.
	*
	* @param userUuid the user uuid of this language
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_language.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this language.
	*
	* @param uuid the uuid of this language
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_language.setUuid(uuid);
	}

	/**
	* Sets the value of this language.
	*
	* @param value the value of this language
	*/
	@Override
	public void setValue(java.lang.String value) {
		_language.setValue(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LanguageWrapper)) {
			return false;
		}

		LanguageWrapper languageWrapper = (LanguageWrapper)obj;

		if (Objects.equals(_language, languageWrapper._language)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _language.getStagedModelType();
	}

	@Override
	public Language getWrappedModel() {
		return _language;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _language.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _language.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_language.resetOriginalValues();
	}

	private final Language _language;
}