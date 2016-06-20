create index IX_50F953FD on EDWF_Workflow (isPublic);
create index IX_FF0D8532 on EDWF_Workflow (title);

create index IX_D5FCD81D on EDWF_WorkflowInstance (title);
create index IX_492DA5C5 on EDWF_WorkflowInstance (userId);

create index IX_4701B357 on EDWF_Workflow_WorkflowInstance (workflowId);
create index IX_2A27FF8C on EDWF_Workflow_WorkflowInstance (workflowInstanceId);