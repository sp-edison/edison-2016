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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class SimulationJobFinderUtil {
	public static long getMaxJobSeqNoSimulationJob(long groupId,
		java.lang.String simulationUuid) {
		return getFinder().getMaxJobSeqNoSimulationJob(groupId, simulationUuid);
	}

	public static int deleteSimulationJob(long groupId,
		java.lang.String simulationUuid, long jobPhase, long jobSeqNo) {
		return getFinder()
				   .deleteSimulationJob(groupId, simulationUuid, jobPhase,
			jobSeqNo);
	}

	public static int deleteSimulationCommandOption(long groupId,
		java.lang.String simulationUuid, long optionSeq) {
		return getFinder()
				   .deleteSimulationCommandOption(groupId, simulationUuid,
			optionSeq);
	}

	public static int deleteSimulationParameter(long groupId,
		java.lang.String simulationUuid, long jobSeqNo) {
		return getFinder()
				   .deleteSimulationParameter(groupId, simulationUuid, jobSeqNo);
	}

	public static java.util.List<org.kisti.edison.bestsimulation.model.SimulationJob> getListSimulationJob(
		long groupId, java.lang.String simulationUuid, long jobPhase,
		long jobSeqNo) {
		return getFinder()
				   .getListSimulationJob(groupId, simulationUuid, jobPhase,
			jobSeqNo);
	}

	public static java.util.List<java.lang.Object[]> getMonitoringList(
		long groupId, long userId, long jobVirtualLabId, long jobClassId,
		java.lang.String searchValue, long jobStatus, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getMonitoringList(groupId, userId, jobVirtualLabId,
			jobClassId, searchValue, jobStatus, begin, end);
	}

	public static int getMonitoringCount(long groupId, long userId,
		long jobVirtualLabId, long jobClassId, java.lang.String searchValue,
		long jobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getMonitoringCount(groupId, userId, jobVirtualLabId,
			jobClassId, searchValue, jobStatus);
	}

	public static java.util.List<java.lang.Object[]> getMonitoringJobList(
		long groupId, java.lang.String simulationUuid, long jobSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getMonitoringJobList(groupId, simulationUuid, jobSeqNo);
	}

	public static int updateSimulationJobSetJobSeqNo(long V_jobSeqNo,
		long jobSeqNo, java.lang.String simulationUuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .updateSimulationJobSetJobSeqNo(V_jobSeqNo, jobSeqNo,
			simulationUuid, groupId);
	}

	public static java.lang.Long getJobSeqNoSimulationJob(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getJobSeqNoSimulationJob(groupId, simulationUuid, jobUuid);
	}

	public static long getStatusSimulationJobStatus(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid) {
		return getFinder()
				   .getStatusSimulationJobStatus(groupId, simulationUuid,
			jobUuid);
	}

	public static long getMaxStatusSeqSimulationJobStatus(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid) {
		return getFinder()
				   .getMaxStatusSeqSimulationJobStatus(groupId, simulationUuid,
			jobUuid);
	}

	public static java.util.List<java.lang.Object[]> getListVirtualLabSearchUni(
		long groupId, java.lang.String languageId, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getListVirtualLabSearchUni(groupId, languageId,
			jobUniversityField);
	}

	public static java.util.List<java.lang.Object[]> getListVirtualClassSearchLab(
		long groupId, java.lang.String languageId, long jobVirtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getListVirtualClassSearchLab(groupId, languageId,
			jobVirtualLabId);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsExecTableOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsExecTableOrganigation(groupId, languageId,
			startDt, endDt, jobUniversityField);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsExecPieChartOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsExecPieChartOrganigation(groupId, languageId,
			startDt, endDt, jobUniversityField);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsExecBarChartDate(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsExecBarChartDate(groupId, languageId, startDt,
			endDt, jobUniversityField);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsSwTableOrganigation(
		long entryId, long vocabularyId, long columnId,
		java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long universityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsSwTableOrganigation(entryId, vocabularyId,
			columnId, languageId, startDt, endDt, universityId);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsSwBarChartDate(
		long entryId, long vocabularyId, long columnId,
		java.lang.String startDt, java.lang.String endDt, long universityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsSwBarChartDate(entryId, vocabularyId,
			columnId, startDt, endDt, universityId);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsSwExeTableOrganigation(
		long groupId, java.lang.String languageId, long columnId,
		java.lang.String startDt, java.lang.String endDt, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsSwExeTableOrganigation(groupId, languageId,
			columnId, startDt, endDt, scienceAppId);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsSwExeBarChartDate(
		long groupId, long columnId, java.lang.String startDt,
		java.lang.String endDt, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsSwExeBarChartDate(groupId, columnId, startDt,
			endDt, scienceAppId);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsTimeTableOrganigation(
		long groupId, java.lang.String startDt, java.lang.String endDt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsTimeTableOrganigation(groupId, startDt, endDt);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsUserTableOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsUserTableOrganigation(groupId, languageId,
			startDt, endDt, jobUniversityField);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsUserPieChartOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsUserPieChartOrganigation(groupId, languageId,
			startDt, endDt, jobUniversityField);
	}

	public static java.util.List<java.lang.Object[]> getStatisticsUserBarChartDate(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStatisticsUserBarChartDate(groupId, languageId, startDt,
			endDt, jobUniversityField);
	}

	public static SimulationJobFinder getFinder() {
		if (_finder == null) {
			_finder = (SimulationJobFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.bestsimulation.service.ClpSerializer.getServletContextName(),
					SimulationJobFinder.class.getName());

			ReferenceRegistry.registerReference(SimulationJobFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SimulationJobFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SimulationJobFinderUtil.class,
			"_finder");
	}

	private static SimulationJobFinder _finder;
}