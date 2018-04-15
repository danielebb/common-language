package it.dbb.common.language.loader.db.internal.portlet.mvccommand.render;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import it.dbb.common.language.loader.db.constants.CommonLanguageLoaderAdminPortletKeys;
import it.dbb.common.language.loader.db.model.Language;
import it.dbb.common.language.loader.db.service.LanguageLocalServiceUtil;

@Component(service = MVCRenderCommand.class, property = {
		"javax.portlet.name=" + CommonLanguageLoaderAdminPortletKeys.COMMON_LANGUAGE_LOADER_ADMIN_PORTLET,
		"mvc.command.name=/edit" })
public class EditMvcRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		String redirect = ParamUtil.getString(renderRequest, "redirect");
		long languageId = ParamUtil.getLong(renderRequest, "languageId");
		String languageCode = ParamUtil.getString(renderRequest, "languageCode");
		
		Language language = LanguageLocalServiceUtil.fetchLanguage(languageId);
		if(language == null) {
			
			language = LanguageLocalServiceUtil.createLanguage(0);
		}
		
		renderRequest.setAttribute("modelBean", language);
		renderRequest.setAttribute("modelClass", language.getModelClass());
		renderRequest.setAttribute("languageId", language.getLanguageId());
		renderRequest.setAttribute("languageCode", languageCode);
		renderRequest.setAttribute("redirect", redirect);
		renderRequest.setAttribute("backURL", redirect);
		
		return "/edit.jsp";
	}
}
