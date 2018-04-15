create index IX_ACA53B87 on CLL_Language (companyId, languageCode[$COLUMN_LENGTH:75$]);
create unique index IX_B2421627 on CLL_Language (languageCode[$COLUMN_LENGTH:75$], key_[$COLUMN_LENGTH:75$]);
create index IX_54AD56E on CLL_Language (uuid_[$COLUMN_LENGTH:75$], companyId);