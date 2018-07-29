package it.dbb.common.language.loader.statics.sample;

import com.liferay.portal.kernel.language.Language;
import org.osgi.service.component.annotations.Component;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import it.dbb.common.language.loader.statics.BaseStaticCommonLanguageLoader;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author danielebb
 *
 */
@Component(property = { "it.dbb.common.language.type=static" }, service = CommonLanguageLoader.class)
public class StaticCommonLanguageLoader extends BaseStaticCommonLanguageLoader {
    
    @Override
    @Reference(unbind = "-", service = Language.class)
    protected void setLanguage(Language language) {
        
        super.setLanguage(language);
    }
}
