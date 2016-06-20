/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.kisti.edison.bestsimulation.service.persistence;

/**
 * @author EDISON
 */
public interface SimulationJobFinder {
	public long getMaxJobSeqNoSimulationJob(long groupId,
		java.lang.String simulationUuid);

	public int deleteSimulationJob(long groupId,
		java.lang.String simulationUuid, long jobPhase, long jobSeqNo);

	public int deleteSimulationCommandOption(long groupId,
		java.lang.String simulationUuid, long optionSeq);

	public int deleteSimulationParameter(long groupId,
		java.lang.String simulationUuid, long jobSeqNo);

	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJob> getListSimulationJob(
		long groupId, java.lang.String simulationUuid, long jobPhase,
		long jobSeqNo);

	public java.util.List<java.lang.Object[]> getMonitoringList(long groupId,
		long userId, long jobVirtualLabId, long jobClassId,
		java.lang.String searchValue, long jobStatus, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getMonitoringCount(long groupId, long userId,
		long jobVirtualLabId, long jobClassId, java.lang.String searchValue,
		long jobStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getMonitoringJobList(
		long groupId, java.lang.String simulationUuid, long jobSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int updateSimulationJobSetJobSeqNo(long V_jobSeqNo, long jobSeqNo,
		java.lang.String simulationUuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Long getJobSeqNoSimulationJob(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long getStatusSimulationJobStatus(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid);

	public long getMaxStatusSeqSimulationJobStatus(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid);

	public java.util.List<java.lang.Object[]> getListVirtualLabSearchUni(
		long groupId, java.lang.String languageId, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getListVirtualClassSearchLab(
		long groupId, java.lang.String languageId, long jobVirtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsExecTableOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsExecPieChartOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsExecBarChartDate(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsSwTableOrganigation(
		long entryId, long vocabularyId, long columnId,
		java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long universityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsSwBarChartDate(
		long entryId, long vocabularyId, long columnId,
		java.lang.String startDt, java.lang.String endDt, long universityId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsSwExeTableOrganigation(
		long groupId, java.lang.String languageId, long columnId,
		java.lang.String startDt, java.lang.String endDt, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsSwExeBarChartDate(
		long groupId, long columnId, java.lang.String startDt,
		java.lang.String endDt, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsTimeTableOrganigation(
		long groupId, java.lang.String startDt, java.lang.String endDt)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsUserTableOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsUserPieChartOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getStatisticsUserBarChartDate(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException;
}