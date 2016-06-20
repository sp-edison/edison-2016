create table EDWF_Workflow (
	workflowId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	description STRING null,
	isPublic BOOLEAN,
	parentWorkflowId LONG,
	screenLogic TEXT null
);

create table EDWF_WorkflowInstance (
	workflowInstanceId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title STRING null,
	status STRING null,
	startTime DATE null,
	endTime DATE null,
	workflowId LONG,
	workflowUUID VARCHAR(75) null,
	screenLogic TEXT null
);

create table EDWF_Workflow_WorkflowInstance (
	workflowId LONG not null,
	workflowInstanceId LONG not null,
	primary key (workflowId, workflowInstanceId)
);