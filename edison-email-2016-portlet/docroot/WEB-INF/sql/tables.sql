create table EDMAIL_SendMailContent (
	sendMailId LONG not null primary key,
	userId LONG,
	sendCount INTEGER,
	successCount INTEGER,
	failCount INTEGER,
	sendDate DATE null,
	siteGroup VARCHAR(75) null,
	userGroup VARCHAR(75) null,
	state_ VARCHAR(75) null,
	title VARCHAR(75) null,
	content VARCHAR(75) null
);