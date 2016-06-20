create table EDPRJ_HistoryAppSimulation (
	scienceAppId LONG not null,
	groupId LONG not null,
	projectCategoryId LONG not null,
	title STRING null,
	version VARCHAR(75) null,
	name STRING null,
	affiliation_id VARCHAR(75) null,
	AppStatus VARCHAR(75) null,
	userId LONG,
	runtime LONG,
	executeCount LONG,
	averageRuntime LONG,
	userCount LONG,
	insertDate DATE null,
	primary key (scienceAppId, groupId, projectCategoryId)
);

create table EDPRJ_HistoryContent (
	contentSeq LONG not null,
	groupId LONG not null,
	projectCategoryId LONG not null,
	contentDiv LONG,
	title STRING null,
	insertId LONG,
	insertDate DATE null,
	updateId LONG,
	updateDate DATE null,
	primary key (contentSeq, groupId, projectCategoryId)
);

create table EDPRJ_HistoryScienceApp (
	scienceAppId LONG not null,
	groupId LONG not null,
	projectCategoryId LONG not null,
	title STRING null,
	version VARCHAR(75) null,
	name STRING null,
	affiliation_id VARCHAR(75) null,
	AppStatus VARCHAR(75) null,
	userId LONG,
	insertDate DATE null,
	primary key (scienceAppId, groupId, projectCategoryId)
);