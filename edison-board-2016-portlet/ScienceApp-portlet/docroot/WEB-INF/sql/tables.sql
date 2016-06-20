create table ScienceApp_CommonLibrary (
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	libName VARCHAR(75) not null,
	cLibVer VARCHAR(75) null,
	sysArch VARCHAR(75) null,
	kernelVer VARCHAR(75) null,
	libPath VARCHAR(75) not null,
	primary key (libName, libPath)
);

create table ScienceApp_CommonModule (
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	moduleName VARCHAR(75) not null primary key,
	moduleRootDir VARCHAR(75) null
);

create table ScienceApp_CommonPackage (
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	pkgName VARCHAR(75) not null,
	pkgVersion VARCHAR(75) not null,
	sysArch VARCHAR(75) null,
	installMethod VARCHAR(75) null,
	installPath VARCHAR(75) null,
	primary key (pkgName, pkgVersion)
);

create table ScienceApp_PortType (
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

create table ScienceApp_PortTypeAnalyzerLink (
	uuid_ VARCHAR(75) null,
	portTypeAnalyzerLinkId LONG not null primary key,
	companyId LONG,
	portTypeId LONG,
	analyzerId LONG
);

create table ScienceApp_PortTypeEditorLink (
	uuid_ VARCHAR(75) null,
	portTypeEditorLinkId LONG not null primary key,
	companyId LONG,
	portTypeId LONG,
	editorId LONG
);

create table ScienceApp_PortTypeInputdeckForm (
	portTypeId LONG not null primary key,
	inputdeckForm STRING null
);

create table ScienceApp_PortTypeInputdeckUserForm (
	inputdeckId LONG not null primary key,
	portTypeId LONG,
	inputdeckUserForm STRING null,
	userId LONG,
	userName VARCHAR(75) null
);

create table ScienceApp_ScienceApp (
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
	manualId LONG,
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
	targetLanguage VARCHAR(75) null
);

create table ScienceApp_ScienceAppCategoryLink (
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

create table ScienceApp_ScienceAppInputPorts (
	scienceAppId LONG not null primary key,
	inputPorts VARCHAR(75) null
);

create table ScienceApp_ScienceAppManager (
	scienceAppManagerId LONG not null primary key,
	userId LONG,
	createDate DATE null,
	scienceAppId LONG,
	managerId LONG
);

create table ScienceApp_ScienceAppOutputPorts (
	scienceAppId LONG not null primary key,
	outputPorts VARCHAR(75) null
);