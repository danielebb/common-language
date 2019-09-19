package it.dbb.common.language.provider.db.web.internal.portlet.command.render;

import com.liferay.frontend.js.loader.modules.extender.npm.JSPackage;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import it.dbb.common.language.provider.db.service.TranslationLocalService;
import it.dbb.common.language.provider.db.web.constants.TranslationPortletWebKeys;
import it.dbb.common.language.provider.db.web.internal.context.TranslationsViewDisplayContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
	property = {
		"javax.portlet.name=" + TranslationPortletWebKeys.TRANSLATION_ADMIN,
		"mvc.command.name=/",
		"mvc.command.name="+TranslationPortletWebKeys.VIEW_TRANSLATIONS_COMMAND
	},
	service = MVCRenderCommand.class
)
public class ViewRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {
		
		TranslationsViewDisplayContext displayContext = new TranslationsViewDisplayContext(renderRequest, renderResponse,
                translationLocalService);
		
		String indexModuleName = npmResolver.resolveModuleName(
				"common-language-provider-db-web");
		
		renderRequest.setAttribute(
				"common-language-provider-db-web/mainRequire",
				indexModuleName + " as Main");
		
		renderRequest.setAttribute(TranslationsViewDisplayContext.class.getName(), displayContext);
		
		return "/html/view.jsp";
	}
	
	 @Reference
	private TranslationLocalService translationLocalService;
	
	@Reference
	private NPMResolver npmResolver;
}