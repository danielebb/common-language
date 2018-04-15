create table CLL_Language (
	uuid_ VARCHAR(75) null,
	languageId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	key_ VARCHAR(75) null,
	languageCode VARCHAR(75) null,
	value VARCHAR(75) null
);