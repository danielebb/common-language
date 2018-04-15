package it.dbb.common.language.loader.db.internal.resourcebundle;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;

import com.liferay.portal.kernel.exception.PortalException;

import it.dbb.common.language.loader.db.model.Language;
import it.dbb.common.language.loader.db.service.LanguageLocalService;

public class DatabaseResourceBundle extends ResourceBundle {

	private LanguageLocalService languageLocalService;
	private String languageId;

	public DatabaseResourceBundle(LanguageLocalService languageLocalService, String languageId) {

		this.languageLocalService = languageLocalService;
		this.languageId = languageId;
	}

	@Override
	public Enumeration<String> getKeys() {
		
		Vector<String> keys = new Vector<>(); 
		
		for (Language language : languageLocalService.findByLanguageCode(languageId)) {
			
			keys.add(language.getKey());
		}
		
		return keys.elements();
	}

	@Override
	protected Object handleGetObject(String key) {
		
		try {
			
			return languageLocalService.getByLanguageCodeKey(languageId, key).getValue();
			
		} catch (PortalException pe) {
			
			return null;
		}
	}
}
