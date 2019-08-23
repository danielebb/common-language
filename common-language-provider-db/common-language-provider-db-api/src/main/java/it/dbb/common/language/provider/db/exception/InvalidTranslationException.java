package it.dbb.common.language.provider.db.exception;

import com.liferay.portal.kernel.exception.RequiredFieldException;

public class InvalidTranslationException extends RequiredFieldException {
    
    public InvalidTranslationException(String requiredField) {
        
        super(requiredField, null);
    }
    
    @Override
    public String getMessage() {
        
        return "Missing required field " + getRequiredField();
    }
}
