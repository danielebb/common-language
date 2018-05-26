package it.dbb.common.language.loader.db.internal.model.listener;

import java.util.Hashtable;

import org.osgi.framework.ServiceRegistration;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import it.dbb.common.language.loader.db.model.Language;

public class LanguageModelListener extends BaseModelListener<Language> {

	private ServiceRegistration<CommonLanguageLoader> serviceRegistration;

	public LanguageModelListener(ServiceRegistration<CommonLanguageLoader> serviceRegistration) {
		
		super();
		this.serviceRegistration = serviceRegistration;
	}

	@Override
	public void onAfterCreate(Language model) throws ModelListenerException {
		
		fireModifiedService();
		
		super.onAfterCreate(model);
	}

	@Override
	public void onAfterRemove(Language model) throws ModelListenerException {
		
		fireModifiedService();
		
		super.onAfterRemove(model);
	}

	@Override
	public void onAfterUpdate(Language model) throws ModelListenerException {
		
		fireModifiedService();
		
		super.onAfterUpdate(model);
	}

	protected void fireModifiedService() {
		
		Hashtable<String, String> properties = new Hashtable<>();
		properties.put("it.dbb.common.language.type", "database");
		
		serviceRegistration.setProperties(properties);
	}
}
