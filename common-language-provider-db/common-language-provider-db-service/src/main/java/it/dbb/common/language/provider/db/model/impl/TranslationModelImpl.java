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

package it.dbb.common.language.provider.db.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.dbb.common.language.provider.db.model.Translation;
import it.dbb.common.language.provider.db.model.TranslationModel;
import it.dbb.common.language.provider.db.model.TranslationSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Translation service. Represents a row in the &quot;INTERNATIONAL_Translation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TranslationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TranslationImpl}.
 * </p>
 *
 * @author danielebb
 * @see TranslationImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TranslationModelImpl
	extends BaseModelImpl<Translation> implements TranslationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a translation model instance should use the <code>Translation</code> interface instead.
	 */
	public static final String TABLE_NAME = "INTERNATIONAL_Translation";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"translationId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"key_", Types.VARCHAR},
		{"language", Types.VARCHAR}, {"value", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("translationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("language", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("value", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table INTERNATIONAL_Translation (uuid_ VARCHAR(75) null,translationId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,key_ VARCHAR(75) null,language VARCHAR(75) null,value STRING null)";

	public static final String TABLE_SQL_DROP =
		"drop table INTERNATIONAL_Translation";

	public static final String ORDER_BY_JPQL =
		" ORDER BY translation.translationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY INTERNATIONAL_Translation.translationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		it.dbb.common.language.provider.db.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.it.dbb.common.language.provider.db.model.Translation"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		it.dbb.common.language.provider.db.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.it.dbb.common.language.provider.db.model.Translation"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		it.dbb.common.language.provider.db.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.it.dbb.common.language.provider.db.model.Translation"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long KEY_COLUMN_BITMASK = 2L;

	public static final long LANGUAGE_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long TRANSLATIONID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Translation toModel(TranslationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Translation model = new TranslationImpl();

		model.setUuid(soapModel.getUuid());
		model.setTranslationId(soapModel.getTranslationId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setKey(soapModel.getKey());
		model.setLanguage(soapModel.getLanguage());
		model.setValue(soapModel.getValue());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Translation> toModels(TranslationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Translation> models = new ArrayList<Translation>(
			soapModels.length);

		for (TranslationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		it.dbb.common.language.provider.db.service.util.ServiceProps.get(
			"lock.expiration.time.it.dbb.common.language.provider.db.model.Translation"));

	public TranslationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _translationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTranslationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _translationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		Map<String, Function<Translation, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Translation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Translation, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Translation)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Translation, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Translation, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Translation)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Translation, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Translation, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Translation>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Translation.class.getClassLoader(), Translation.class,
			ModelWrapper.class);

		try {
			Constructor<Translation> constructor =
				(Constructor<Translation>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Translation, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Translation, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Translation, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Translation, Object>>();
		Map<String, BiConsumer<Translation, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Translation, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object uuid) {
					translation.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"translationId",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getTranslationId();
				}

			});
		attributeSetterBiConsumers.put(
			"translationId",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(
					Translation translation, Object translationId) {

					translation.setTranslationId((Long)translationId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object companyId) {
					translation.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object userId) {
					translation.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object userName) {
					translation.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object createDate) {
					translation.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(
					Translation translation, Object modifiedDate) {

					translation.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"key",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getKey();
				}

			});
		attributeSetterBiConsumers.put(
			"key",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object key) {
					translation.setKey((String)key);
				}

			});
		attributeGetterFunctions.put(
			"language",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getLanguage();
				}

			});
		attributeSetterBiConsumers.put(
			"language",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object language) {
					translation.setLanguage((String)language);
				}

			});
		attributeGetterFunctions.put(
			"value",
			new Function<Translation, Object>() {

				@Override
				public Object apply(Translation translation) {
					return translation.getValue();
				}

			});
		attributeSetterBiConsumers.put(
			"value",
			new BiConsumer<Translation, Object>() {

				@Override
				public void accept(Translation translation, Object value) {
					translation.setValue((String)value);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTranslationId() {
		return _translationId;
	}

	@Override
	public void setTranslationId(long translationId) {
		_translationId = translationId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@JSON
	@Override
	public String getLanguage() {
		if (_language == null) {
			return "";
		}
		else {
			return _language;
		}
	}

	@Override
	public void setLanguage(String language) {
		_columnBitmask |= LANGUAGE_COLUMN_BITMASK;

		if (_originalLanguage == null) {
			_originalLanguage = _language;
		}

		_language = language;
	}

	public String getOriginalLanguage() {
		return GetterUtil.getString(_originalLanguage);
	}

	@JSON
	@Override
	public String getValue() {
		if (_value == null) {
			return "";
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		_value = value;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Translation.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Translation.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Translation toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Translation>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TranslationImpl translationImpl = new TranslationImpl();

		translationImpl.setUuid(getUuid());
		translationImpl.setTranslationId(getTranslationId());
		translationImpl.setCompanyId(getCompanyId());
		translationImpl.setUserId(getUserId());
		translationImpl.setUserName(getUserName());
		translationImpl.setCreateDate(getCreateDate());
		translationImpl.setModifiedDate(getModifiedDate());
		translationImpl.setKey(getKey());
		translationImpl.setLanguage(getLanguage());
		translationImpl.setValue(getValue());

		translationImpl.resetOriginalValues();

		return translationImpl;
	}

	@Override
	public int compareTo(Translation translation) {
		long primaryKey = translation.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Translation)) {
			return false;
		}

		Translation translation = (Translation)obj;

		long primaryKey = translation.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TranslationModelImpl translationModelImpl = this;

		translationModelImpl._originalUuid = translationModelImpl._uuid;

		translationModelImpl._originalCompanyId =
			translationModelImpl._companyId;

		translationModelImpl._setOriginalCompanyId = false;

		translationModelImpl._setModifiedDate = false;

		translationModelImpl._originalKey = translationModelImpl._key;

		translationModelImpl._originalLanguage = translationModelImpl._language;

		translationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Translation> toCacheModel() {
		TranslationCacheModel translationCacheModel =
			new TranslationCacheModel();

		translationCacheModel.uuid = getUuid();

		String uuid = translationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			translationCacheModel.uuid = null;
		}

		translationCacheModel.translationId = getTranslationId();

		translationCacheModel.companyId = getCompanyId();

		translationCacheModel.userId = getUserId();

		translationCacheModel.userName = getUserName();

		String userName = translationCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			translationCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			translationCacheModel.createDate = createDate.getTime();
		}
		else {
			translationCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			translationCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			translationCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		translationCacheModel.key = getKey();

		String key = translationCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			translationCacheModel.key = null;
		}

		translationCacheModel.language = getLanguage();

		String language = translationCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			translationCacheModel.language = null;
		}

		translationCacheModel.value = getValue();

		String value = translationCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			translationCacheModel.value = null;
		}

		return translationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Translation, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Translation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Translation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Translation)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Translation, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Translation, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Translation, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Translation)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Translation>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _translationId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _key;
	private String _originalKey;
	private String _language;
	private String _originalLanguage;
	private String _value;
	private long _columnBitmask;
	private Translation _escapedModel;

}