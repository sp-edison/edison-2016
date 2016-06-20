create table EDAPP_CommonLib (
	libName VARCHAR(75) not null,
	libPath VARCHAR(75) not null,
	libraryVersion VARCHAR(75) null,
	cLibVer VARCHAR(75) null,
	sysArch VARCHAR(75) null,
	kernelVer VARCHAR(75) null,
	primary key (libName, libPath)
);

create table EDAPP_CommonModule (
	commonModuleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	moduleName VARCHAR(75) null,
	moduleVersion VARCHAR(75) null
);

create table EDAPP_DeveloperInfo (
	userId LONG not null,
	groupId LONG not null,
	screenName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	universityField VARCHAR(75) null,
	majorField VARCHAR(75) null,
	useStart VARCHAR(75) null,
	useEnd VARCHAR(75) null,
	developerSort VARCHAR(75) null,
	languageFortran BOOLEAN,
	languageCpp BOOLEAN,
	languagePython BOOLEAN,
	languageJava BOOLEAN,
	languageOther BOOLEAN,
	languageOtherDescription VARCHAR(75) null,
	rem STRING null,
	agreementYn BOOLEAN,
	writtenOathLogical VARCHAR(75) null,
	writtenOathPhysical VARCHAR(75) null,
	detailIp VARCHAR(75) null,
	detailOs VARCHAR(75) null,
	detailCpu VARCHAR(75) null,
	detailStorate VARCHAR(75) null,
	detailLibrary VARCHAR(75) null,
	insertId LONG,
	insertDate DATE null,
	updateId LONG,
	updateDate DATE null,
	etc STRING null,
	developerId VARCHAR(75) null,
	developerPassword VARCHAR(75) null,
	primary key (userId, groupId)
);

create table EDAPP_DeveloperIp (
	ipSeq LONG not null,
	userId LONG not null,
	groupId LONG not null,
	ip1 VARCHAR(75) null,
	ip2 VARCHAR(75) null,
	ip3 VARCHAR(75) null,
	ip4 VARCHAR(75) null,
	insertId LONG,
	insertDate DATE null,
	updateId LONG,
	updateDate DATE null,
	primary key (ipSeq, userId, groupId)
);

create table EDAPP_DeveloperRequest (
	requestSeq LONG not null,
	userId LONG not null,
	groupId LONG not null,
	requestSort VARCHAR(75) null,
	requestDate DATE null,
	requestNote STRING null,
	requestStatus VARCHAR(75) null,
	processDate DATE null,
	processNote STRING null,
	insertId LONG,
	insertDate DATE null,
	updateId LONG,
	updateDate DATE null,
	primary key (requestSeq, userId, groupId)
);

create table EDAPP_PortType (
	uuid_ VARCHAR(75) null,
	portTypeId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	defaultEditorId LONG,
	defaultAnalyzerId LONG,
	name VARCHAR(75) null,
	dataType VARCHAR(75) null,
	sampleFilePath VARCHAR(75) null,
	targetLanguage VARCHAR(75) null,
	status VARCHAR(75) null
);

create table EDAPP_PortTypeAnalyzerLink (
	uuid_ VARCHAR(75) null,
	portTypeAnalyzerLinkId LONG not null primary key,
	companyId LONG,
	portTypeId LONG,
	analyzerId LONG
);

create table EDAPP_PortTypeEditorLink (
	uuid_ VARCHAR(75) null,
	portTypeEditorLinkId LONG not null primary key,
	companyId LONG,
	portTypeId LONG,
	editorId LONG
);

create table EDAPP_PortTypeInputdeckForm (
	portTypeId LONG not null primary key,
	inputdeckForm TEXT null
);

create table EDAPP_RequiredLib (
	requiredLibId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	libraryName VARCHAR(256) null,
	libraryVersion VARCHAR(75) null,
	libraryType VARCHAR(75) null,
	librarySrcPath VARCHAR(75) null,
	installScript TEXT null
);

create table EDAPP_RequiredLibConfirm (
	requiredLibId LONG not null,
	scienceAppId LONG not null,
	companyId LONG,
	userId LONG,
	requiredDate DATE null,
	confirmDate DATE null,
	libraryName VARCHAR(75) null,
	libraryVersion VARCHAR(75) null,
	requiredContent VARCHAR(75) null,
	requiredState VARCHAR(75) null,
	confirmContent VARCHAR(75) null,
	primary key (requiredLibId, scienceAppId)
);

create table EDAPP_RequiredModule (
	requiredModuleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	moduleName VARCHAR(75) null,
	moduleVersion VARCHAR(75) null
);

create table EDAPP_ScienceApp (
	uuid_ VARCHAR(75) null,
	scienceAppId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	version VARCHAR(75) null,
	title STRING null,
	descriptionId LONG,
	previousVersionId LONG,
	iconId LONG,
	manualId STRING null,
	exeFileName VARCHAR(256) null,
	appType VARCHAR(75) null,
	runType VARCHAR(75) null,
	authorId LONG,
	stage VARCHAR(75) null,
	status INTEGER,
	recentModifierId LONG,
	parallelModule VARCHAR(75) null,
	maxCpus INTEGER,
	defaultCpus INTEGER,
	statusDate DATE null,
	openLevel VARCHAR(75) null,
	license VARCHAR(75) null,
	srcFileName VARCHAR(256) null,
	targetLanguage VARCHAR(75) null,
	developers STRING null,
	editorType VARCHAR(75) null,
	swTest BOOLEAN,
	projectCategoryId LONG
);

create table EDAPP_ScienceAppCategoryLink (
	uuid_ VARCHAR(75) null,
	scienceAppCategoryLinkId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	categoryId LONG,
	scienceAppId LONG,
	parentCategoryId LONG
);

create table EDAPP_ScienceAppDescription (
	descriptionId LONG not null primary key,
	content STRING null,
	insertId LONG,
	insertDt DATE null,
	updateId LONG,
	updateDt DATE null
);

create table EDAPP_ScienceAppFavorite (
	scienceAppId LONG not null,
	userId LONG not null,
	groupId LONG,
	primary key (scienceAppId, userId)
);

create table EDAPP_ScienceAppInputPorts (
	scienceAppId LONG not null primary key,
	inputPorts TEXT null
);

create table EDAPP_ScienceAppManager (
	scienceAppManagerId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	scienceAppId LONG,
	managerId LONG
);

create table EDAPP_ScienceAppOutputPorts (
	scienceAppId LONG not null primary key,
	outputPorts TEXT null
);