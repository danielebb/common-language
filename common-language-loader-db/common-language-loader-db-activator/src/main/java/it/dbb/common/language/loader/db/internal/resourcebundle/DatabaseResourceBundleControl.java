package it.dbb.common.language.loader.db.internal.resourcebundle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;

public class DatabaseResourceBundleControl extends Control {

	@Override
	public List<Locale> getCandidateLocales(String basename, Locale locale) {

		return super.getCandidateLocales(basename, locale);
	}

	@Override
	public List<String> getFormats(String basename) {

		return Arrays.asList("database");
	}

	@Override
	public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
			throws IllegalAccessException, InstantiationException, IOException {

		return null;
	}

}
