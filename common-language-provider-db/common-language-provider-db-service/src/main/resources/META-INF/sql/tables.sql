create table INTERNATIONAL_Translation (
	uuid_ VARCHAR(75) null,
	translationId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	key_ VARCHAR(75) null,
	language VARCHAR(75) null,
	value STRING null
);