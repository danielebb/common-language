package it.dbb.common.language.loader.db.internal;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import it.dbb.common.language.loader.db.internal.resourcebundle.DatabaseResourceBundle;
import it.dbb.common.language.loader.db.service.LanguageLocalService;

public class DatabaseCommonLanguageLoader implements CommonLanguageLoader {

	@Override
	public ResourceBundleLoader getResourceBundleLoader() {
		
		return new CacheResourceBundleLoader(new DatabaseResourceBundleLoader());
	}

	private class DatabaseResourceBundleLoader implements ResourceBundleLoader {

		public ResourceBundle loadResourceBundle(Locale locale) {
			
			return loadResourceBundle(LocaleUtil.toLanguageId(locale));
		}
		
		public ResourceBundle loadResourceBundle(String languageId) {
			
			return new DatabaseResourceBundle(languageLocalService, languageId);
		}
	}
	
	@Override
	public void initResourceBundles(ResourceBundle parentResourceBundle, Map<String, String> bundleProperties) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Set<String> getResourceBundleLoaderLanguageIds() {
		
		Set<String> resourceBundleLoaderLanguageIds = new HashSet<>();
		
		for (String availableLanguageId : languageLocalService.getAvailableLanguageIds()) {
			
			resourceBundleLoaderLanguageIds.add(availableLanguageId);
		}
		
		return resourceBundleLoaderLanguageIds;
	}

	public void setLanguageLocalService(LanguageLocalService languageLocalService) {
		
		this.languageLocalService = languageLocalService;
	}
	
	private LanguageLocalService languageLocalService;
}
