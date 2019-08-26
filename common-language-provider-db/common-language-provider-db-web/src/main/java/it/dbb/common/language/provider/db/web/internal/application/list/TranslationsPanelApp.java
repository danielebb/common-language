package it.dbb.common.language.provider.db.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import it.dbb.common.language.provider.db.web.constants.TranslationPortletWebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=600",
                "panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
        },
        service = PanelApp.class
)
public class TranslationsPanelApp extends BasePanelApp {
    
    @Override
    public String getPortletId() {
        
        return TranslationPortletWebKeys.TRANSLATION_ADMIN;
    }
    
    @Override
    @Reference(
            target = "(javax.portlet.name=" + TranslationPortletWebKeys.TRANSLATION_ADMIN + ")",
            unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        
        super.setPortlet(portlet);
    }
    
}