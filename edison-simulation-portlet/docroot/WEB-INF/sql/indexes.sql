create index IX_B6D91891 on EDSIM_SimulationJob (groupId, jobClassId, jobPhase);
create index IX_8C9823DF on EDSIM_SimulationJob (simulationUuid, groupId);

create index IX_101568AF on EDSIM_SimulationJobStatus (groupId, simulationUuid, jobUuid);