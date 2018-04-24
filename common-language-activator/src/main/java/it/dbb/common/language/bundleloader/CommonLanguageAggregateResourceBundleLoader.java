package it.dbb.common.language.bundleloader;

import java.util.Hashtable;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.osgi.util.tracker.ServiceTracker;

import com.liferay.portal.kernel.util.AggregateResourceBundle;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringPool;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;

/**
 * @author danielebb
 */
public class CommonLanguageAggregateResourceBundleLoader implements ResourceBundleLoader {

	public CommonLanguageAggregateResourceBundleLoader(
			ServiceTracker<CommonLanguageLoader, CommonLanguageLoader> serviceTracker,
			ResourceBundleLoader resourceBundleLoader, Hashtable<String, Object> bundleProperties) {

		this.serviceTracker = serviceTracker;
		this.baseResourceBundleLoader = resourceBundleLoader;
	}

	public ResourceBundle loadResourceBundle(String languageId) {

		Locale locale = LocaleUtil.fromLanguageId(languageId);

		return loadResourceBundle(locale);
	}

	public ResourceBundle loadResourceBundle(Locale locale) {

		ResourceBundle commonLanguageResourceBundle = null;
		ResourceBundle baseResourceBundle = loadResourceBundle(baseResourceBundleLoader, locale);

		if (!serviceTracker.isEmpty()) {

			commonLanguageResourceBundle = loadResourceBundle(serviceTracker.getService().getResourceBundleLoader(),
					locale);
		}

		if (commonLanguageResourceBundle != null && baseResourceBundle != null) {

			return new AggregateResourceBundle(commonLanguageResourceBundle, baseResourceBundle);

		} else if (baseResourceBundle != null) {

			return baseResourceBundle;

		} else if (commonLanguageResourceBundle != null) {

			return commonLanguageResourceBundle;
		}

		throw new MissingResourceException(
				"Resource bundle loader " + this + " was unable to load " + "resource bundle for " + locale,
				StringPool.BLANK, locale.toString());

	}

	protected ResourceBundle loadResourceBundle(ResourceBundleLoader resourceBundleLoader, Locale locale) {

		try {

			// retrocompatibility

			String languageId = LocaleUtil.toLanguageId(locale);

			ResourceBundle resourceBundle = resourceBundleLoader.loadResourceBundle(languageId);

			if (resourceBundle != null) {

				return resourceBundle;
			}

		} catch (Exception e) {
		}

		return null;
	}

	private final ResourceBundleLoader baseResourceBundleLoader;
	private ServiceTracker<CommonLanguageLoader, CommonLanguageLoader> serviceTracker;
}
