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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Language service. Represents a row in the &quot;CLL_Language&quot; database table, with each column mapped to a property of this class.
 *
 * @author danielebb
 * @see LanguageModel
 * @see it.dbb.common.language.loader.db.model.impl.LanguageImpl
 * @see it.dbb.common.language.loader.db.model.impl.LanguageModelImpl
 * @generated
 */
@ImplementationClassName("it.dbb.common.language.loader.db.model.impl.LanguageImpl")
@ProviderType
public interface Language extends LanguageModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link it.dbb.common.language.loader.db.model.impl.LanguageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Language, Long> LANGUAGE_ID_ACCESSOR = new Accessor<Language, Long>() {
			@Override
			public Long get(Language language) {
				return language.getLanguageId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Language> getTypeClass() {
				return Language.class;
			}
		};
}