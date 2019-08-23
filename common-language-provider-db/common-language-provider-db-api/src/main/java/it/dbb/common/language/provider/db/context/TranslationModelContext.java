package it.dbb.common.language.provider.db.context;

public class TranslationModelContext {
    
    private long primaryKey;
    private final String key;
    private final String languageCode;
    private final String value;
    
    public TranslationModelContext(String key, String languageCode, String value) {
        
        this.key = key;
        this.languageCode = languageCode;
        this.value = value;
    }
    
    public long getPrimaryKey() {
        return primaryKey;
    }
    
    public void setPrimaryKey(long primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    public String getKey() {
        return key;
    }
    
    public String getLanguageCode() {
        return languageCode;
    }
    
    public String getValue() {
        return value;
    }
}
