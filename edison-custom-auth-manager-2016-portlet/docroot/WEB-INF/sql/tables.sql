create table EDAUT_UserGroupRoleCustom (
	userId LONG not null,
	groupId LONG not null,
	roleId LONG not null,
	customId LONG not null,
	createDate DATE null,
	primary key (userId, groupId, roleId, customId)
);