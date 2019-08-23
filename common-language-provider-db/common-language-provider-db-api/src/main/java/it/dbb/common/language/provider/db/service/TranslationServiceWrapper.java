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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TranslationService}.
 *
 * @author danielebb
 * @see TranslationService
 * @generated
 */
@ProviderType
public class TranslationServiceWrapper
	implements TranslationService, ServiceWrapper<TranslationService> {

	public TranslationServiceWrapper(TranslationService translationService) {
		_translationService = translationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _translationService.getOSGiServiceIdentifier();
	}

	@Override
	public TranslationService getWrappedService() {
		return _translationService;
	}

	@Override
	public void setWrappedService(TranslationService translationService) {
		_translationService = translationService;
	}

	private TranslationService _translationService;

}