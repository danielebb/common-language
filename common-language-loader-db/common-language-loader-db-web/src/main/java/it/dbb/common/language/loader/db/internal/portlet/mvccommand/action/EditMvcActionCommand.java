package it.dbb.common.language.loader.db.internal.portlet.mvccommand.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import it.dbb.common.language.loader.db.constants.CommonLanguageLoaderAdminPortletKeys;
import it.dbb.common.language.loader.db.service.LanguageLocalServiceUtil;

@Component(service = MVCActionCommand.class, property = {
		"javax.portlet.name=" + CommonLanguageLoaderAdminPortletKeys.COMMON_LANGUAGE_LOADER_ADMIN_PORTLET,
		"mvc.command.name=editLanguage" })
public class EditMvcActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		try {
			
			long languageId = ParamUtil.getLong(actionRequest, "languageId");
			String key = ParamUtil.getString(actionRequest, "key");
			String languageCode = ParamUtil.getString(actionRequest, "languageCode");
			String value = ParamUtil.getString(actionRequest, "value");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			
			if(languageId > 0) {
				
				LanguageLocalServiceUtil.updateLanguage(languageId, key, value, serviceContext);
				
			} else {
				
				LanguageLocalServiceUtil.addLanguage(key, languageCode, value, serviceContext);
			}
			
		} catch(Exception e) {
			
			_log.error(e.toString());
			throw e;
		}

	}

	private static final Log _log = LogFactoryUtil.getLog(EditMvcActionCommand.class);
}
