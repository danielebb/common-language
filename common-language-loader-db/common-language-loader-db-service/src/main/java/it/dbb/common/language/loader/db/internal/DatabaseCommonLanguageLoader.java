package it.dbb.common.language.loader.db.internal;

import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import it.dbb.common.language.loader.db.internal.resourcebundle.DatabaseResourceBundle;
import it.dbb.common.language.loader.db.service.LanguageLocalService;

@Component(service = CommonLanguageLoader.class, property = { "it.dbb.common.language.type=database" })
public class DatabaseCommonLanguageLoader implements CommonLanguageLoader {

	@Override
	public ResourceBundleLoader getResourceBundleLoader() {
		
		return new CacheResourceBundleLoader(new DatabaseResourceBundleLoader());
	}

	private class DatabaseResourceBundleLoader implements ResourceBundleLoader {

		@Override
		public ResourceBundle loadResourceBundle(String languageId) {
			
			return new DatabaseResourceBundle(languageLocalService, languageId);
		}
	}
	
	@Reference(unbind = "-")
	protected LanguageLocalService languageLocalService;
}
