package it.dbb.common.language.bundleloader;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.osgi.util.tracker.ServiceTracker;

import com.liferay.portal.kernel.util.AggregateResourceBundle;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.StringPool;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;

/**
 * @author danielebb
 */
public class CommonLanguageAggregateResourceBundleLoader implements ResourceBundleLoader {

	public CommonLanguageAggregateResourceBundleLoader(
			ServiceTracker<CommonLanguageLoader, CommonLanguageLoader> serviceTracker,
			ResourceBundleLoader resourceBundleLoader) {
		
		this.serviceTracker = serviceTracker;
		this.baseResourceBundleLoader = resourceBundleLoader;
	}

	@Override
	public ResourceBundle loadResourceBundle(String languageId) {

		ResourceBundle commonLanguageResourceBundle = null;
		ResourceBundle baseResourceBundle = loadResourceBundle(baseResourceBundleLoader, languageId);

		if (!serviceTracker.isEmpty()) {

			commonLanguageResourceBundle = loadResourceBundle(serviceTracker.getService().getResourceBundleLoader(),
					languageId);
		}

		if (commonLanguageResourceBundle != null && baseResourceBundle != null) {

			return new AggregateResourceBundle(commonLanguageResourceBundle, baseResourceBundle);

		} else if (baseResourceBundle != null) {

			return baseResourceBundle;

		} else if (commonLanguageResourceBundle != null) {

			return commonLanguageResourceBundle;
		}

		throw new MissingResourceException(
				"Resource bundle loader " + this + " was unable to load " + "resource bundle for " + languageId,
				StringPool.BLANK, languageId);
	}

	protected ResourceBundle loadResourceBundle(ResourceBundleLoader resourceBundleLoader, String languageId) {

		try {

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
