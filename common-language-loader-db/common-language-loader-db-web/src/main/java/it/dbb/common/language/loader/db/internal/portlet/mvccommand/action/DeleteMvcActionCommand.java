package it.dbb.common.language.loader.db.internal.portlet.mvccommand.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import it.dbb.common.language.loader.db.constants.CommonLanguageLoaderAdminPortletKeys;
import it.dbb.common.language.loader.db.service.LanguageLocalServiceUtil;

@Component(service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + CommonLanguageLoaderAdminPortletKeys.COMMON_LANGUAGE_LOADER_ADMIN_PORTLET,
		"mvc.command.name=deleteLanguage" })
public class DeleteMvcActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		try {
			
			long languageId = ParamUtil.getLong(actionRequest, "languageId");

			LanguageLocalServiceUtil.deleteLanguage(languageId);
			
		} catch(Exception e) {
			
			_log.error(e.toString());
			throw e;
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(DeleteMvcActionCommand.class);
}
