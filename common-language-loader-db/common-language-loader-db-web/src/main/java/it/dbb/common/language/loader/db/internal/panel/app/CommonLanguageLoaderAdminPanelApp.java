package it.dbb.common.language.loader.db.internal.panel.app;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import it.dbb.common.language.loader.db.constants.CommonLanguageLoaderAdminPortletKeys;

@Component(immediate = true, property = { "panel.app.order:Integer=900",
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION }, service = PanelApp.class)
public class CommonLanguageLoaderAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {

		return CommonLanguageLoaderAdminPortletKeys.COMMON_LANGUAGE_LOADER_ADMIN_PORTLET;
	}

	@Override
	@Reference(target = "(javax.portlet.name="
			+ CommonLanguageLoaderAdminPortletKeys.COMMON_LANGUAGE_LOADER_ADMIN_PORTLET + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {

		super.setPortlet(portlet);
	}
}
