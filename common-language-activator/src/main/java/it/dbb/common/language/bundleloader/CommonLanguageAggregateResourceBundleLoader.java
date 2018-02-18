package it.dbb.common.language.bundleloader;

import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.CacheResourceBundleLoader;
import com.liferay.portal.kernel.util.ClassResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoader;

/**
 * @author danielebb
 */
public class CommonLanguageAggregateResourceBundleLoader extends AggregateResourceBundleLoader {

	public CommonLanguageAggregateResourceBundleLoader(ResourceBundleLoader resourceBundleLoader) {

		super(new CacheResourceBundleLoader(new ClassResourceBundleLoader("common.Language",
				CommonLanguageAggregateResourceBundleLoader.class.getClassLoader())), resourceBundleLoader);
	}
}
