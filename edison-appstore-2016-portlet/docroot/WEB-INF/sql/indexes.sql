create index IX_4EB5533D on EDAPP_CommonLib (libName);

create index IX_7CAE173B on EDAPP_DeveloperInfo (userId);

create index IX_E4755BB4 on EDAPP_DeveloperIp (userId);
create index IX_D08A0376 on EDAPP_DeveloperIp (userId, groupId);

create index IX_B282DE48 on EDAPP_DeveloperRequest (userId, groupId);
create index IX_8DABFB66 on EDAPP_DeveloperRequest (userId, requestSeq);

create unique index IX_6F5F9D1D on EDAPP_PortType (name);
create index IX_10C88816 on EDAPP_PortType (uuid_);
create index IX_8D0B252 on EDAPP_PortType (uuid_, companyId);

create index IX_D3C4C774 on EDAPP_PortTypeAnalyzerLink (companyId, portTypeId);
create index IX_FDAB8636 on EDAPP_PortTypeAnalyzerLink (uuid_);
create index IX_D2F7A032 on EDAPP_PortTypeAnalyzerLink (uuid_, companyId);

create index IX_9B704A8F on EDAPP_PortTypeEditorLink (portTypeId);
create index IX_54797ECF on EDAPP_PortTypeEditorLink (uuid_);
create index IX_DB6A7DF9 on EDAPP_PortTypeEditorLink (uuid_, companyId);

create index IX_705D8649 on EDAPP_RequiredLibConfirm (scienceAppId);

create index IX_79D47B8B on EDAPP_ScienceApp (appType);
create index IX_E5A7B2A on EDAPP_ScienceApp (appType, runType);
create index IX_7A699267 on EDAPP_ScienceApp (appType, runType, targetLanguage);
create index IX_4240B0C8 on EDAPP_ScienceApp (appType, targetLanguage);
create index IX_56924F5A on EDAPP_ScienceApp (authorId);
create index IX_CFB7B751 on EDAPP_ScienceApp (authorId, appType);
create index IX_FBAFA08E on EDAPP_ScienceApp (authorId, appType, targetLanguage);
create index IX_6B209440 on EDAPP_ScienceApp (authorId, status);
create index IX_1076BF7D on EDAPP_ScienceApp (authorId, status, targetLanguage);
create index IX_40530697 on EDAPP_ScienceApp (authorId, targetLanguage);
create index IX_3418699F on EDAPP_ScienceApp (name);
create index IX_502DF6DC on EDAPP_ScienceApp (name, targetLanguage);
create index IX_C80B51C6 on EDAPP_ScienceApp (name, title, targetLanguage);
create index IX_66FB6F49 on EDAPP_ScienceApp (name, version);
create index IX_4AE12EAA on EDAPP_ScienceApp (openLevel);
create index IX_61945E7 on EDAPP_ScienceApp (openLevel, targetLanguage);
create index IX_7738B44E on EDAPP_ScienceApp (stage);
create index IX_9199038B on EDAPP_ScienceApp (stage, targetLanguage);
create index IX_709D60C6 on EDAPP_ScienceApp (status);
create index IX_33C5C003 on EDAPP_ScienceApp (status, targetLanguage);
create index IX_9A67A528 on EDAPP_ScienceApp (title);
create index IX_898F0065 on EDAPP_ScienceApp (title, targetLanguage);
create index IX_E3294BD4 on EDAPP_ScienceApp (uuid_);
create index IX_140CBD4 on EDAPP_ScienceApp (uuid_, companyId);
create unique index IX_E723756 on EDAPP_ScienceApp (uuid_, groupId);

create index IX_767E0605 on EDAPP_ScienceAppCategoryLink (categoryId);
create index IX_89F2884F on EDAPP_ScienceAppCategoryLink (parentCategoryId);
create index IX_9A9B1024 on EDAPP_ScienceAppCategoryLink (scienceAppId);
create index IX_ACDF7B9C on EDAPP_ScienceAppCategoryLink (uuid_);
create index IX_C9F06F0C on EDAPP_ScienceAppCategoryLink (uuid_, companyId);
create unique index IX_26A1488E on EDAPP_ScienceAppCategoryLink (uuid_, groupId);

create index IX_7E8D0CA8 on EDAPP_ScienceAppFavorite (scienceAppId);

create index IX_609BF4FF on EDAPP_ScienceAppManager (managerId);
create index IX_8A796C05 on EDAPP_ScienceAppManager (scienceAppId);
create index IX_76420E33 on EDAPP_ScienceAppManager (scienceAppId, managerId);
create index IX_EF60EF3F on EDAPP_ScienceAppManager (scienceAppId, userId);
create index IX_5C715BF3 on EDAPP_ScienceAppManager (userId);