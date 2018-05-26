package it.dbb.common.language.bundleloader.api;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.liferay.portal.kernel.util.ResourceBundleLoader;

public interface CommonLanguageLoader {

	public void initResourceBundles(ResourceBundle parentResourceBundle, Map<String, String> bundleProperties);
	
	public ResourceBundleLoader getResourceBundleLoader();
	
	public Set<String> getResourceBundleLoaderLanguageIds();
}
