create table EDMED_AdvancedContent (
	contentSeq LONG not null,
	groupId LONG not null,
	title VARCHAR(75) null,
	resume VARCHAR(75) null,
	contentFilePath VARCHAR(75) null,
	contentFileNm VARCHAR(75) null,
	contentStartFileNm VARCHAR(75) null,
	serviceLanguage VARCHAR(75) null,
	viewCnt LONG,
	insertId LONG,
	insertDate DATE null,
	updateId LONG,
	updateDate DATE null,
	primary key (contentSeq, groupId)
);

create table EDMED_GeneralContent (
	contentSeq LONG not null,
	groupId LONG not null,
	contentDiv LONG,
	title STRING null,
	downloadCnt LONG,
	serviceLanguage VARCHAR(75) null,
	projectYn VARCHAR(75) null,
	projectId LONG,
	insertId LONG,
	insertDate DATE null,
	updateId LONG,
	updateDate DATE null,
	primary key (contentSeq, groupId)
);

create table EDMED_OrgImgContent (
	orgImgSeq LONG not null,
	groupId LONG not null,
	order_ LONG,
	orgNm VARCHAR(75) null,
	orgLink VARCHAR(75) null,
	fileEntryId LONG,
	insertId LONG,
	insertDate DATE null,
	updateId LONG,
	updateDate DATE null,
	primary key (orgImgSeq, groupId)
);