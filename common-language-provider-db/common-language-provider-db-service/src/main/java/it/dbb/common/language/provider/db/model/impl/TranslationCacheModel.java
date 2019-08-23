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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.dbb.common.language.provider.db.model.Translation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Translation in entity cache.
 *
 * @author danielebb
 * @generated
 */
@ProviderType
public class TranslationCacheModel
	implements CacheModel<Translation>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TranslationCacheModel)) {
			return false;
		}

		TranslationCacheModel translationCacheModel =
			(TranslationCacheModel)obj;

		if (translationId == translationCacheModel.translationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, translationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", translationId=");
		sb.append(translationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", key=");
		sb.append(key);
		sb.append(", language=");
		sb.append(language);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Translation toEntityModel() {
		TranslationImpl translationImpl = new TranslationImpl();

		if (uuid == null) {
			translationImpl.setUuid("");
		}
		else {
			translationImpl.setUuid(uuid);
		}

		translationImpl.setTranslationId(translationId);
		translationImpl.setCompanyId(companyId);
		translationImpl.setUserId(userId);

		if (userName == null) {
			translationImpl.setUserName("");
		}
		else {
			translationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			translationImpl.setCreateDate(null);
		}
		else {
			translationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			translationImpl.setModifiedDate(null);
		}
		else {
			translationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (key == null) {
			translationImpl.setKey("");
		}
		else {
			translationImpl.setKey(key);
		}

		if (language == null) {
			translationImpl.setLanguage("");
		}
		else {
			translationImpl.setLanguage(language);
		}

		if (value == null) {
			translationImpl.setValue("");
		}
		else {
			translationImpl.setValue(value);
		}

		translationImpl.resetOriginalValues();

		return translationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		translationId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		key = objectInput.readUTF();
		language = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(translationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String uuid;
	public long translationId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String key;
	public String language;
	public String value;

}