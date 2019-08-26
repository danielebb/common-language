package it.dbb.common.language.provider.db.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import it.dbb.common.language.provider.db.web.constants.TranslationPortletWebKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

@Component(
        property = {
                "com.liferay.portlet.css-class-wrapper=portlet-translations-admin",
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.use-default-template=true",
                "javax.portlet.display-name=Translations",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.init-param.always-send-redirect=true",
                "javax.portlet.init-param.mvc-command-names-default-views="+ TranslationPortletWebKeys.VIEW_TRANSLATIONS_COMMAND,
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.name=" + TranslationPortletWebKeys.TRANSLATION_ADMIN,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=administrator",
                "javax.portlet.supports.mime-type=text/html",
                "javax.portlet.version=3.0"
        },
        service = Portlet.class
)
public class TranslationsAdminPortlet extends MVCPortlet {
    
}