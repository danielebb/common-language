package it.dbb.common.language.loader.db.activator;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.liferay.portal.kernel.model.ModelListener;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import it.dbb.common.language.loader.db.internal.DatabaseCommonLanguageLoader;
import it.dbb.common.language.loader.db.internal.model.listener.LanguageModelListener;
import it.dbb.common.language.loader.db.service.LanguageLocalService;

/**
 * @author danielebb
 */
public class DatabaseCommonLanguageLoaderActivator implements BundleActivator {

	private ServiceRegistration<CommonLanguageLoader> databaseCommonLanguageLoaderServiceRegistration;
	@SuppressWarnings("rawtypes")
	private ServiceRegistration<ModelListener> languageModelListenerServiceRegistration;

	@Override
	public void start(BundleContext bundleContext) throws Exception {

		DatabaseCommonLanguageLoader databaseCommonLanguageLoader = new DatabaseCommonLanguageLoader();

		ServiceReference<LanguageLocalService> languageLocalServiceServiceReference = bundleContext
				.getServiceReference(LanguageLocalService.class);

		if (languageLocalServiceServiceReference == null) {

			throw new ServiceException("No service found for " + LanguageLocalService.class.getName());
		}

		databaseCommonLanguageLoader
				.setLanguageLocalService(bundleContext.getService(languageLocalServiceServiceReference));

		Hashtable<String, String> properties = new Hashtable<>();
		properties.put("it.dbb.common.language.type", "database");

		databaseCommonLanguageLoaderServiceRegistration = bundleContext.registerService(CommonLanguageLoader.class,
				databaseCommonLanguageLoader, properties);

		LanguageModelListener languageModelListener = new LanguageModelListener(
				databaseCommonLanguageLoaderServiceRegistration);

		languageModelListenerServiceRegistration = bundleContext.registerService(ModelListener.class,
				languageModelListener, new Hashtable<>());
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {

		databaseCommonLanguageLoaderServiceRegistration.unregister();
		languageModelListenerServiceRegistration.unregister();
	}

}