package it.dbb.common.language.loader.db.internal.portlet.mvccommand.render;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.frontend.taglib.servlet.taglib.ManagementBarFilterItem;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import it.dbb.common.language.loader.db.constants.CommonLanguageLoaderAdminPortletKeys;
import it.dbb.common.language.loader.db.model.Language;
import it.dbb.common.language.loader.db.service.LanguageLocalService;

@Component(service = MVCRenderCommand.class, property = {
		"javax.portlet.name=" + CommonLanguageLoaderAdminPortletKeys.COMMON_LANGUAGE_LOADER_ADMIN_PORTLET,
		"mvc.command.name=/" })
public class ViewMvcRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String currentLanguageId = ParamUtil.getString(renderRequest, "language",
				LocaleUtil.toLanguageId(LocaleUtil.getDefault()));

		List<ManagementBarFilterItem> localeFilterItems = getLocaleFilterItems(currentLanguageId, renderResponse);
		String localeFilterItemLabel = LanguageUtil.get(renderRequest.getLocale(), "locale");
		for (ManagementBarFilterItem localeFilterItem : localeFilterItems) {

			if (localeFilterItem.isActive()) {

				localeFilterItemLabel = localeFilterItemLabel + StringPool.COLON + StringPool.SPACE
						+ LanguageUtil.get(renderRequest.getLocale(), localeFilterItem.getLabel());
				break;
			}
		}

		renderRequest.setAttribute("languageCode", currentLanguageId);
		renderRequest.setAttribute("localeFilterItems", localeFilterItems);
		renderRequest.setAttribute("localeFilterItemLabel", localeFilterItemLabel);

		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("language", currentLanguageId);

		SearchContainer<Language> searchContainer = new SearchContainer<>(renderRequest, iteratorURL, null,
				"no-languages-were-found");

		int total = languageLocalService.countByLanguage(currentLanguageId);
		List<Language> results = languageLocalService.findByLanguageCode(currentLanguageId);

		searchContainer.setTotal(total);
		searchContainer.setResults(results);

		renderRequest.setAttribute("searchContainer", searchContainer);

		return "/view.jsp";
	}

	protected List<ManagementBarFilterItem> getLocaleFilterItems(String currentLanguageId,
			RenderResponse renderResponse) {

		List<ManagementBarFilterItem> filterItems = new ArrayList<>();

		for (Locale locale : LanguageUtil.getAvailableLocales()) {

			String languageId = LocaleUtil.toLanguageId(locale);
			String label = "language." + locale.getLanguage();
			boolean active = Validator.equals(currentLanguageId, languageId);

			PortletURL renderURL = renderResponse.createRenderURL();
			renderURL.setParameter("language", languageId);

			ManagementBarFilterItem filterItem = new ManagementBarFilterItem(active, label, renderURL.toString());

			filterItems.add(filterItem);
		}

		return filterItems;
	}

	@Reference
	LanguageLocalService languageLocalService;
}
