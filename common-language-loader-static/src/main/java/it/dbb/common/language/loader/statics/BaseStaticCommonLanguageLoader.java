package it.dbb.common.language.loader.statics;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Reference;

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

		Language language = getInstance();
		
		if(language != null) {
			
			for (Locale locale : language.getAvailableLocales()) {
				
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
		}

		return resourceBundleLoaderLanguageIds;
	}

	private ResourceBundleLoader staticBundleLoader = new CacheResourceBundleLoader(
			new ClassResourceBundleLoader(getResourceLanguagePath(), this.getClass().getClassLoader()));

	private Language language;
	
	protected void setLanguage(Language language) {
		
		this.language = language;
	}
	
	private Language getInstance() {
		
		if(language == null) {
			
			Bundle bundle = FrameworkUtil.getBundle(this.getClass());
			
			BundleContext bundleContext = bundle.getBundleContext();
			
			if(bundleContext != null) {
				
				ServiceReference<Language> serviceReference = bundleContext.getServiceReference(Language.class);
				
				if(serviceReference != null) {
					
					language = bundleContext.getService(serviceReference);
				}
			}
		}
		
		return language;
	}
}