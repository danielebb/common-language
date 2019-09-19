package it.dbb.common.language.provider.db.web.internal.portlet.command.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import it.dbb.common.language.provider.db.context.TranslationModelContext;
import it.dbb.common.language.provider.db.controller.TranslationController;
import it.dbb.common.language.provider.db.exception.NoSuchTranslationException;
import it.dbb.common.language.provider.db.model.Translation;
import it.dbb.common.language.provider.db.service.TranslationLocalService;
import it.dbb.common.language.provider.db.web.constants.TranslationPortletWebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.Arrays;

@Component(
        property = {
                "javax.portlet.name=" + TranslationPortletWebKeys.TRANSLATION_ADMIN,
                "mvc.command.name="+TranslationPortletWebKeys.EDIT_TRANSLATION_COMMAND
        },
        service = MVCResourceCommand.class
)
public class UpdateTranslationResourceCommand extends BaseMVCResourceCommand {
    
    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
    
        try {
    
            long translationId = ParamUtil.getLong(resourceRequest, "translationId");
    
            Translation translation = translationLocalService.getTranslation(translationId);
    
            TranslationModelContext modelContext = new TranslationModelContext(translation.getKey(), translation.getLanguage(), ParamUtil.getString(resourceRequest, "value"));
    
            modelContext.setPrimaryKey(translation.getTranslationId());
    
            ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
    
            translationController.updateTranslation(modelContext, serviceContext);
    
        } catch(NoSuchTranslationException nste) {
            
            _log.error(nste.getMessage(), nste);
    
            resourceResponse.setStatus(404);
            
        } catch (Exception e) {
            
            _log.error(e.getMessage(), e);
            
            resourceResponse.setStatus(300);
        }
    }
    
    @Reference
    private TranslationController translationController;
    
    @Reference
    private TranslationLocalService translationLocalService;
    
    private Log _log = LogFactoryUtil.getLog(UpdateTranslationResourceCommand.class);
}
