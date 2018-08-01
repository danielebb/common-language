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
package it.dbb.common.language.loader.db.exception;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author danielebb
 */
@ProviderType
public class DuplicateLanguageCodeKeyException extends PortalException {

	public DuplicateLanguageCodeKeyException() {
	}

	public DuplicateLanguageCodeKeyException(String msg) {
		super(msg);
	}

	public DuplicateLanguageCodeKeyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DuplicateLanguageCodeKeyException(Throwable cause) {
		super(cause);
	}

}