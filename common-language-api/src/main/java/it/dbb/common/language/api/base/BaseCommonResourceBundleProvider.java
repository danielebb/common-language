package it.dbb.common.language.api.base;

import it.dbb.common.language.api.CommonResourceBundleProvider;

import java.util.Locale;
import java.util.function.Consumer;

public abstract class BaseCommonResourceBundleProvider implements CommonResourceBundleProvider {
    
    protected Consumer<Locale> changeConsumer;
    
    @Override
    public void changeConsumer(Consumer<Locale> consumer) {
        
        this.changeConsumer = consumer;
    }
    
    @Override
    public void emitChange(Locale locale) {
        
        changeConsumer.accept(locale);
    }
}
