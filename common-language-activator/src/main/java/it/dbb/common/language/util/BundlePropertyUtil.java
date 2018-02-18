package it.dbb.common.language.util;

import java.util.Dictionary;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author danielebb
 */
public class BundlePropertyUtil {

	public static String getBundleSymbolicName(ServiceReference<?> serviceReference, Bundle bundle) {

		return getBundleProperty("bundle.symbolic.name", "Bundle-SymbolicName", serviceReference, bundle);
	}

	public static String getServletContextName(ServiceReference<?> serviceReference, Bundle bundle) {

		String property = getBundleProperty("servlet.context.name", "Web-ContextPath", serviceReference, bundle);

		if (StringUtil.startsWith(property, '/')) {

			property = property.substring(1);
		}

		return property;
	}

	public static String getResourceBundleBaseName(ServiceReference<?> serviceReference, Bundle bundle) {

		String property = getBundleProperty("resource.bundle.base.name", null, serviceReference, bundle);

		if (Validator.isNull(property)) {

			property = "content.Language";
		}

		return property;
	}

	public static String getBundleProperty(String propertyKey, String headerKey, ServiceReference<?> serviceReference,
			Bundle bundle) {

		if (Validator.isNotNull(propertyKey)) {

			String property = GetterUtil.getString(serviceReference.getProperty(propertyKey));

			if (Validator.isNotNull(property)) {

				return property;
			}

			BundleContext bundleContext = bundle.getBundleContext();

			property = bundleContext.getProperty(propertyKey);

			if (Validator.isNotNull(property)) {

				return property;
			}
		}

		if (Validator.isNotNull(headerKey)) {

			Dictionary<String, String> headers = bundle.getHeaders();

			String property = headers.get(headerKey);

			if (Validator.isNotNull(property)) {

				return property;
			}
		}

		return StringPool.BLANK;
	}
}
