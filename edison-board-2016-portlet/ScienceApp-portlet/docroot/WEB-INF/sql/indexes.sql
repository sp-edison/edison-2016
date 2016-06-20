create index IX_7F3F9B6C on ScienceApp_CommonLibrary (libName);

create index IX_C9D702EA on ScienceApp_CommonModule (moduleName);

create unique index IX_EC5BFE42 on ScienceApp_PortType (name);
create index IX_33584B91 on ScienceApp_PortType (uuid_);
create index IX_A3383F7 on ScienceApp_PortType (uuid_, companyId);

create index IX_81D40D6D on ScienceApp_PortTypeAnalyzerLink (portTypeId);
create index IX_728DD40D on ScienceApp_PortTypeAnalyzerLink (portTypeUuid);
create index IX_28A2E931 on ScienceApp_PortTypeAnalyzerLink (uuid_);
create index IX_841C2257 on ScienceApp_PortTypeAnalyzerLink (uuid_, companyId);

create index IX_A617C1B4 on ScienceApp_PortTypeEditorLink (portTypeId);
create index IX_94B59294 on ScienceApp_PortTypeEditorLink (portTypeUuid);
create index IX_8E53648A on ScienceApp_PortTypeEditorLink (uuid_);
create index IX_B7A3455E on ScienceApp_PortTypeEditorLink (uuid_, companyId);

create index IX_7F900986 on ScienceApp_ScienceApp (appType);
create index IX_424F778F on ScienceApp_ScienceApp (appType, runType);
create index IX_4FEB24CC on ScienceApp_ScienceApp (appType, runType, targetLanguage);
create index IX_17CEE8C3 on ScienceApp_ScienceApp (appType, targetLanguage);
create index IX_84880BF on ScienceApp_ScienceApp (authorId);
create index IX_1A62478C on ScienceApp_ScienceApp (authorId, appType);
create index IX_D6605AC9 on ScienceApp_ScienceApp (authorId, appType, targetLanguage);
create index IX_9F1590A5 on ScienceApp_ScienceApp (authorId, status);
create index IX_E5F851E2 on ScienceApp_ScienceApp (authorId, status, targetLanguage);
create index IX_1C8BCDFC on ScienceApp_ScienceApp (authorId, targetLanguage);
create index IX_63811584 on ScienceApp_ScienceApp (name);
create index IX_4ED438C1 on ScienceApp_ScienceApp (name, targetLanguage);
create index IX_3B771441 on ScienceApp_ScienceApp (name, title, targetLanguage);
create index IX_A0D55504 on ScienceApp_ScienceApp (name, version);
create index IX_CFF129E5 on ScienceApp_ScienceApp (openLevel);
create index IX_B0F96B22 on ScienceApp_ScienceApp (openLevel, targetLanguage);
create index IX_34E58509 on ScienceApp_ScienceApp (stage);
create index IX_67BAFE46 on ScienceApp_ScienceApp (stage, targetLanguage);
create index IX_688AA76B on ScienceApp_ScienceApp (status);
create index IX_21E31CA8 on ScienceApp_ScienceApp (status, targetLanguage);
create index IX_2F78BEC2 on ScienceApp_ScienceApp (targetLanguage);
create index IX_581475E3 on ScienceApp_ScienceApp (title);
create index IX_5FB0FB20 on ScienceApp_ScienceApp (title, targetLanguage);
create index IX_A0D61C8F on ScienceApp_ScienceApp (uuid_);
create index IX_3535C839 on ScienceApp_ScienceApp (uuid_, companyId);
create unique index IX_FD508FB on ScienceApp_ScienceApp (uuid_, groupId);

create index IX_649B62AA on ScienceApp_ScienceAppCategoryLink (categoryId);
create index IX_83FF1534 on ScienceApp_ScienceAppCategoryLink (parentCategoryId);
create index IX_76D3D789 on ScienceApp_ScienceAppCategoryLink (scienceAppId);
create index IX_F78A0BD7 on ScienceApp_ScienceAppCategoryLink (uuid_);
create index IX_C3FCFBF1 on ScienceApp_ScienceAppCategoryLink (uuid_, companyId);
create unique index IX_D7C5CAB3 on ScienceApp_ScienceAppCategoryLink (uuid_, groupId);

create index IX_9490F164 on ScienceApp_ScienceAppManager (managerId);
create index IX_D4C0D980 on ScienceApp_ScienceAppManager (scienceAppId);
create index IX_1F5EF5D8 on ScienceApp_ScienceAppManager (scienceAppId, managerId);
create index IX_BD77E760 on ScienceApp_ScienceAppManager (scienceAppUuid);
create index IX_F6F6CBD8 on ScienceApp_ScienceAppManager (scienceAppUuid, managerUuid);