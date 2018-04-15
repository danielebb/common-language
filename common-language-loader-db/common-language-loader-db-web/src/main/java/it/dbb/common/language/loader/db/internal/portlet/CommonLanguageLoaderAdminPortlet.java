package it.dbb.common.language.loader.db.internal.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.dbb.common.language.loader.db.constants.CommonLanguageLoaderAdminPortletKeys;

/**
 * @author daniele
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.admin",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=common-language-loader-db-web-admin-portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CommonLanguageLoaderAdminPortletKeys.COMMON_LANGUAGE_LOADER_ADMIN_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CommonLanguageLoaderAdminPortlet extends MVCPortlet {
}