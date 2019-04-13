package it.dbb.common.language.provider.resource.sample;

import com.liferay.portal.kernel.language.Language;
import it.dbb.common.language.api.CommonResourceBundleProvider;
import it.dbb.common.language.provider.resource.BaseStaticCommonLanguageProvider;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author danielebb
 *
 */
@Component(property = { "it.dbb.common.language.type=resource" }, service = CommonResourceBundleProvider.class)
public class StaticCommonLanguageLoader extends BaseStaticCommonLanguageProvider {
    
    @Override
    @Reference(unbind = "-", service = Language.class)
    protected void setLanguage(Language language) {
        
        super.setLanguage(language);
    }
}
