package it.dbb.common.language.provider.resource;

import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import it.dbb.common.language.api.CommonResourceBundleProvider;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author danielebb
 */
public class BaseStaticCommonLanguageProvider implements CommonResourceBundleProvider {
	
	/**
	 * The path where to search for Language properties files.
	 * Default is <b>common.Language</b>
	 *
	 * @return the resources language path
	 */
	protected String getResourceLanguagePath() {

		return "common.Language";
	}
	
	@Override
	public ResourceBundle getResourceBundle(Locale locale) {
		
		return staticBundleLoader.loadResourceBundle(locale);
	}
	
	@Override
	public List<Locale> managedLocales() {
		
		if(_managedLocales == null) {
			
			Set<Locale> resourceBundleLoaderLocales = new HashSet<>();
			
			Language language = getInstance();
			
			if (language != null) {
				
				for (Locale locale : language.getSupportedLocales()) {
					
					try {
						
						ResourceBundle resourceBundle = ResourceBundle.getBundle(getResourceLanguagePath(), locale, this.getClass().getClassLoader());
						
						if (resourceBundle != null) {
							
							resourceBundleLoaderLocales.add(locale);
						}
						
					} catch (MissingResourceException mre) {
						
						// no bundle for this locale
					}
				}
			}
			
			_managedLocales = new ArrayList<>(resourceBundleLoaderLocales);
		}
		
		return _managedLocales;
	}
	
	@Override
	public void changeConsumer(Consumer<Locale> consumer) {
	
		// no change emitted by this type of provider
	}
	
	@Override
	public void emitChange(Locale locale) {
		
		// no change emitted by this type of provider
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
	
	private List<Locale> _managedLocales;
}