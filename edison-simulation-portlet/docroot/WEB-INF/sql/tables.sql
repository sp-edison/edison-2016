create table EDSIM_Simulation (
	simulationUuid VARCHAR(75) not null,
	groupId LONG not null,
	userId LONG,
	simulationTitle STRING null,
	simulationDescription STRING null,
	scienceAppId VARCHAR(75) null,
	scienceAppName STRING null,
	simulationCreateDt DATE null,
	cluster VARCHAR(75) null,
	testYn VARCHAR(75) null,
	primary key (simulationUuid, groupId)
);

create table EDSIM_SimulationJob (
	jobSeqNo LONG not null,
	simulationUuid VARCHAR(75) not null,
	groupId LONG not null,
	jobUuid VARCHAR(75) null,
	jobStatus LONG,
	jobStartDt DATE null,
	jobEndDt DATE null,
	jobTitle STRING null,
	jobExecPath STRING null,
	jobPhase LONG,
	jobSubmitDt DATE null,
	jobPostProcessor VARCHAR(75) null,
	jobUniversityField LONG,
	jobVirtualLabId LONG,
	jobClassId LONG,
	jobInputDeckYn BOOLEAN,
	jobInputDeckName VARCHAR(75) null,
	resultSize INTEGER,
	testYn VARCHAR(75) null,
	primary key (jobSeqNo, simulationUuid, groupId)
);

create table EDSIM_SimulationJobData (
	jobUuid VARCHAR(75) not null primary key,
	jobData STRING null
);

create table EDSIM_SimulationJobStatus (
	statusSeq LONG not null,
	groupId LONG not null,
	simulationUuid VARCHAR(75) not null,
	jobUuid VARCHAR(75) not null,
	jobStatus LONG,
	jobStartDt DATE null,
	jobEndDt DATE null,
	writeDt DATE null,
	primary key (statusSeq, groupId, simulationUuid, jobUuid)
);