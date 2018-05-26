package it.dbb.common.language.loader.statics;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.LocaleUtil;
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

	@Override
	public void initResourceBundles(ResourceBundle parentResourceBundle, Map<String, String> bundleProperties) {
	}

	@Override
	public Set<String> getResourceBundleLoaderLanguageIds() {

		Set<String> resourceBundleLoaderLanguageIds = new HashSet<>();

		for (Locale locale : LanguageUtil.getAvailableLocales()) {

			try {

				ResourceBundle resourceBundle = ResourceBundle.getBundle(getResourceLanguagePath(), locale,
						this.getClass().getClassLoader());

				if (resourceBundle != null) {

					resourceBundleLoaderLanguageIds.add(LocaleUtil.toLanguageId(locale));
				}

			} catch (MissingResourceException mre) {

				// no bundle for this locale
			}
		}

		return resourceBundleLoaderLanguageIds;
	}

	private ResourceBundleLoader staticBundleLoader = new CacheResourceBundleLoader(
			new ClassResourceBundleLoader(getResourceLanguagePath(), this.getClass().getClassLoader()));
}