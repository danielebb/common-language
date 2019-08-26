package it.dbb.common.language.provider.db.web.internal.portlet.command.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import it.dbb.common.language.provider.db.controller.TranslationController;
import it.dbb.common.language.provider.db.web.constants.TranslationPortletWebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        property = {
                "javax.portlet.name=" + TranslationPortletWebKeys.TRANSLATION_ADMIN,
                "mvc.command.name="+TranslationPortletWebKeys.DELETE_TRANSLATION_COMMAND
        },
        service = MVCActionCommand.class
)
public class DeleteTranslationActionCommand extends BaseMVCActionCommand {
    
    @Override
    protected void doProcessAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
 
        long translationId = ParamUtil.getLong(actionRequest, "translationId");
        
        translationController.removeTranslation(translationId);
    }
    
    @Reference
    private TranslationController translationController;
    
}
