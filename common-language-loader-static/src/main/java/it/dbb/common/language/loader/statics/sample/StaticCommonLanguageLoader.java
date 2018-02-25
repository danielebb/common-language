package it.dbb.common.language.loader.statics.sample;

import org.osgi.service.component.annotations.Component;

import it.dbb.common.language.bundleloader.api.CommonLanguageLoader;
import it.dbb.common.language.loader.statics.BaseStaticCommonLanguageLoader;

/**
 * 
 * @author danielebb
 *
 */
@Component(property = { "it.dbb.common.language.type=static" }, service = CommonLanguageLoader.class)
public class StaticCommonLanguageLoader extends BaseStaticCommonLanguageLoader {

}
