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

package it.dbb.common.language.loader.db.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import it.dbb.common.language.loader.db.model.Language;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Language in entity cache.
 *
 * @author danielebb
 * @see Language
 * @generated
 */
@ProviderType
public class LanguageCacheModel implements CacheModel<Language>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LanguageCacheModel)) {
			return false;
		}

		LanguageCacheModel languageCacheModel = (LanguageCacheModel)obj;

		if (languageId == languageCacheModel.languageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, languageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", languageId=");
		sb.append(languageId);
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
		sb.append(", languageCode=");
		sb.append(languageCode);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Language toEntityModel() {
		LanguageImpl languageImpl = new LanguageImpl();

		if (uuid == null) {
			languageImpl.setUuid(StringPool.BLANK);
		}
		else {
			languageImpl.setUuid(uuid);
		}

		languageImpl.setLanguageId(languageId);
		languageImpl.setCompanyId(companyId);
		languageImpl.setUserId(userId);

		if (userName == null) {
			languageImpl.setUserName(StringPool.BLANK);
		}
		else {
			languageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			languageImpl.setCreateDate(null);
		}
		else {
			languageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			languageImpl.setModifiedDate(null);
		}
		else {
			languageImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (key == null) {
			languageImpl.setKey(StringPool.BLANK);
		}
		else {
			languageImpl.setKey(key);
		}

		if (languageCode == null) {
			languageImpl.setLanguageCode(StringPool.BLANK);
		}
		else {
			languageImpl.setLanguageCode(languageCode);
		}

		if (value == null) {
			languageImpl.setValue(StringPool.BLANK);
		}
		else {
			languageImpl.setValue(value);
		}

		languageImpl.resetOriginalValues();

		return languageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		languageId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		key = objectInput.readUTF();
		languageCode = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(languageId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (languageCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageCode);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String uuid;
	public long languageId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String key;
	public String languageCode;
	public String value;
}