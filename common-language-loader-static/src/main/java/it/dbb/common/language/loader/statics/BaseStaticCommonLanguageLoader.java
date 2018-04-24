package it.dbb.common.language.loader.statics;

import java.util.Map;
import java.util.ResourceBundle;

import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;

/**
 * @author danielebb
 */
public class BaseStaticCommonLanguageLoader implements CommonLanguageLoader {

	@Override
	public ResourceBundleLoader getResourceBundleLoader() {

		return staticBundleLoader;
	}

	public String getResourceLanguagePath() {

		return "common.Language";
	}

	private ResourceBundleLoader staticBundleLoader = new CacheResourceBundleLoader(
			new ClassResourceBundleLoader(getResourceLanguagePath(), this.getClass().getClassLoader()));

	@Override
	public void initResourceBundles(ResourceBundle parentResourceBundle, Map<String, String> bundleProperties) {
		// TODO Auto-generated method stub
		
	}

}