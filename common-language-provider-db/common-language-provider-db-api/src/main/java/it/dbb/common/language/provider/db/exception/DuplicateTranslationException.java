package it.dbb.common.language.provider.db.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class DuplicateTranslationException extends PortalException {
    
    public DuplicateTranslationException() {
    }
    
    public DuplicateTranslationException(String msg) {
        super(msg);
    }
    
    public DuplicateTranslationException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public DuplicateTranslationException(Throwable cause) {
        super(cause);
    }
}
