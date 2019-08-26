package it.dbb.common.language.provider.db.web.internal.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import it.dbb.common.language.provider.db.model.Translation;
import it.dbb.common.language.provider.db.service.TranslationLocalService;
import it.dbb.common.language.provider.db.web.constants.TranslationPortletWebKeys;

import javax.portlet.*;
import java.util.*;

public class TranslationsViewDisplayContext {
    
    private LiferayPortletRequest liferayPortletRequest;
    private LiferayPortletResponse liferayPortletResponse;
    private ThemeDisplay themeDisplay;
    private ResourceBundle resourceBundle;
    private SearchContainer<Translation> searchContainer;
    private String languageId;
    private PortletRequest portletRequest;
    private PortletResponse portletResponse;
    private Set<Locale> supportedLocales;
    private List<DropdownItem> localesDropdownItems;
    private ActionURL addTranslationURL;
    private RenderURL searchURL;
    private String searchKeywords;
    private TranslationLocalService translationLocalService;
    
    public TranslationsViewDisplayContext(PortletRequest portletRequest, PortletResponse portletResponse, TranslationLocalService translationLocalService) {
        
        this.portletRequest = portletRequest;
        this.portletResponse = portletResponse;
        this.translationLocalService = translationLocalService;
        
        liferayPortletRequest = PortalUtil.getLiferayPortletRequest(portletRequest);
        liferayPortletResponse = PortalUtil.getLiferayPortletResponse(portletResponse);
        
        themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
        resourceBundle = ResourceBundleLoaderUtil.getResourceBundleLoaderByBundleSymbolicName("it.dbb.common.language.provider.db.web").loadResourceBundle(themeDisplay.getLocale());
        
        languageId = ParamUtil.getString(portletRequest, TranslationPortletWebKeys.LANGUAGE_ID_PARAM, LocaleUtil.toLanguageId(LocaleUtil.getDefault()));
        
        searchKeywords = ParamUtil.get(portletRequest, TranslationPortletWebKeys.KEYWORDS_PARAM, StringPool.BLANK);
    
        supportedLocales = LanguageUtil.getAvailableLocales();
    
        addTranslationURL = liferayPortletResponse.createActionURL();
        addTranslationURL.getActionParameters().setValue(ActionRequest.ACTION_NAME, TranslationPortletWebKeys.ADD_TRANSLATION_COMMAND);
    
        searchURL = liferayPortletResponse.createRenderURL();
        searchURL.getRenderParameters().setValue(TranslationPortletWebKeys.LANGUAGE_ID_PARAM, languageId);
        
        initLocalesDropdownItems();
    
        initSearchContainer(languageId);
    }
    
    private void initSearchContainer(String languageId) {
        
        searchContainer = new SearchContainer<>(portletRequest, buildIteratorURL(), null, "no-translations-yet");
        
        QueryDefinition<Translation> queryDefinition = new QueryDefinition<>();
        
        queryDefinition.setStart(searchContainer.getStart());
        queryDefinition.setEnd(searchContainer.getEnd());
        
        List<Translation> translations = translationLocalService.getTranslationByLanguage(languageId, queryDefinition);
        
        int total = translationLocalService.countTranslationByLanguage(languageId);
        
        searchContainer.setResults(translations);
        searchContainer.setTotal(total);
    }
    
    private PortletURL buildIteratorURL() {
        
        RenderURL iteratorURL = liferayPortletResponse.createRenderURL();
        
        iteratorURL.getRenderParameters().setValue(TranslationPortletWebKeys.LANGUAGE_ID_PARAM, languageId);
        iteratorURL.getRenderParameters().setValue(TranslationPortletWebKeys.KEYWORDS_PARAM, searchKeywords);
        
        return iteratorURL;
    }
    
    private void initLocalesDropdownItems() {
        
        localesDropdownItems = new ArrayList<>();
        
        supportedLocales.forEach(locale -> {
            
            DropdownItem localeDropdownItem = new DropdownItem();
            
            String languageId = LocaleUtil.toLanguageId(locale);
            
            localeDropdownItem.setHref(liferayPortletResponse.createRenderURL(), TranslationPortletWebKeys.LANGUAGE_ID_PARAM, languageId, TranslationPortletWebKeys.KEYWORDS_PARAM, searchKeywords);
            localeDropdownItem.setLabel(LanguageUtil.get(themeDisplay.getLocale(), "language." + locale.getLanguage()));
            localeDropdownItem.setIcon(locale.getCountry() + "-" + locale.getLanguage());
            localeDropdownItem.setActive(this.languageId.equals(languageId));
            
            localesDropdownItems.add(localeDropdownItem);
        });
    }
    
    public LiferayPortletRequest getLiferayPortletRequest() {
        return liferayPortletRequest;
    }
    
    public LiferayPortletResponse getLiferayPortletResponse() {
        return liferayPortletResponse;
    }
    
    public SearchContainer<Translation> getSearchContainer() {
        return searchContainer;
    }
    
    public String getLanguageId() {
        return languageId;
    }
    
    public PortletRequest getPortletRequest() {
        return portletRequest;
    }
    
    public PortletResponse getPortletResponse() {
        return portletResponse;
    }
    
    public Set<Locale> getSupportedLocales() {
        return supportedLocales;
    }
    
    public ActionURL getAddTranslationURL() {
        return addTranslationURL;
    }
    
    public RenderURL getSearchURL() {
        return searchURL;
    }
    
    public boolean isShowSearch() {
        return false;
    }
    
    public List<DropdownItem> getLocalesDropdownItems() {
        return localesDropdownItems;
    }
    
    public String getSearchParameter() {
        
        return TranslationPortletWebKeys.KEYWORDS_PARAM;
    }
    
    public String getSearchKeywords() {
        return searchKeywords;
    }
    
    public Translation getEmptyTranslation() {
        
        return translationLocalService.createDraft();
    }
    
    public ActionURL getDeleteTranslationURL(Translation translation) {
    
        ActionURL deleteTranslationURL = liferayPortletResponse.createActionURL();
        deleteTranslationURL.getActionParameters().setValue(ActionRequest.ACTION_NAME, TranslationPortletWebKeys.DELETE_TRANSLATION_COMMAND);
        deleteTranslationURL.getActionParameters().setValue("translationId", String.valueOf(translation.getTranslationId()));
        deleteTranslationURL.getActionParameters().setValue("redirect", searchContainer.getIteratorURL().toString());
        
        return deleteTranslationURL;
    }
    
    public ResourceURL getEditTranslationURL(Translation translation) {
    
        ResourceURL editTranslationURL = liferayPortletResponse.createResourceURL();
        editTranslationURL.setResourceID(TranslationPortletWebKeys.EDIT_TRANSLATION_COMMAND);
        editTranslationURL.getResourceParameters().setValue("translationId", String.valueOf(translation.getTranslationId()));
        
        return editTranslationURL;
    }
    
    public PortletURL getRedirectURL() {
        
        return searchContainer.getIteratorURL();
    }
}
