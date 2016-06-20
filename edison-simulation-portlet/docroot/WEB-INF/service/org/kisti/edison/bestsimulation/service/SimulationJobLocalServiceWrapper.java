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

package org.kisti.edison.bestsimulation.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SimulationJobLocalService}.
 *
 * @author EDISON
 * @see SimulationJobLocalService
 * @generated
 */
public class SimulationJobLocalServiceWrapper
	implements SimulationJobLocalService,
		ServiceWrapper<SimulationJobLocalService> {
	public SimulationJobLocalServiceWrapper(
		SimulationJobLocalService simulationJobLocalService) {
		_simulationJobLocalService = simulationJobLocalService;
	}

	/**
	* Adds the simulation job to the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJob the simulation job
	* @return the simulation job that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob addSimulationJob(
		org.kisti.edison.bestsimulation.model.SimulationJob simulationJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.addSimulationJob(simulationJob);
	}

	/**
	* Creates a new simulation job with the primary key. Does not add the simulation job to the database.
	*
	* @param simulationJobPK the primary key for the new simulation job
	* @return the new simulation job
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob createSimulationJob(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK simulationJobPK) {
		return _simulationJobLocalService.createSimulationJob(simulationJobPK);
	}

	/**
	* Deletes the simulation job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobPK the primary key of the simulation job
	* @return the simulation job that was removed
	* @throws PortalException if a simulation job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob deleteSimulationJob(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK simulationJobPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.deleteSimulationJob(simulationJobPK);
	}

	/**
	* Deletes the simulation job from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJob the simulation job
	* @return the simulation job that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob deleteSimulationJob(
		org.kisti.edison.bestsimulation.model.SimulationJob simulationJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.deleteSimulationJob(simulationJob);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _simulationJobLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob fetchSimulationJob(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK simulationJobPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.fetchSimulationJob(simulationJobPK);
	}

	/**
	* Returns the simulation job with the primary key.
	*
	* @param simulationJobPK the primary key of the simulation job
	* @return the simulation job
	* @throws PortalException if a simulation job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob getSimulationJob(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK simulationJobPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.getSimulationJob(simulationJobPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the simulation jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulation jobs
	* @param end the upper bound of the range of simulation jobs (not inclusive)
	* @return the range of simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJob> getSimulationJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.getSimulationJobs(start, end);
	}

	/**
	* Returns the number of simulation jobs.
	*
	* @return the number of simulation jobs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSimulationJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.getSimulationJobsCount();
	}

	/**
	* Updates the simulation job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param simulationJob the simulation job
	* @return the simulation job that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob updateSimulationJob(
		org.kisti.edison.bestsimulation.model.SimulationJob simulationJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.updateSimulationJob(simulationJob);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _simulationJobLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_simulationJobLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _simulationJobLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public long getMaxJobSeqNoSimulationJob(long groupId,
		java.lang.String simulationUuid) {
		return _simulationJobLocalService.getMaxJobSeqNoSimulationJob(groupId,
			simulationUuid);
	}

	@Override
	public int deleteSimulationJob(long groupId,
		java.lang.String simulationUuid, long jobPhase, long jobSeqNo) {
		return _simulationJobLocalService.deleteSimulationJob(groupId,
			simulationUuid, jobPhase, jobSeqNo);
	}

	@Override
	public int deleteSimulationParameter(long groupId,
		java.lang.String simulationUuid, long jobSeqNo) {
		return _simulationJobLocalService.deleteSimulationParameter(groupId,
			simulationUuid, jobSeqNo);
	}

	@Override
	public int deleteSimulationCommandOption(long groupId,
		java.lang.String simulationUuid, long optionSeq) {
		return _simulationJobLocalService.deleteSimulationCommandOption(groupId,
			simulationUuid, optionSeq);
	}

	@Override
	public java.util.List getListSimulationJob(long groupId,
		java.lang.String simulationUuid, long jobPhase, long jobSeqNo,
		java.util.Locale locale) {
		return _simulationJobLocalService.getListSimulationJob(groupId,
			simulationUuid, jobPhase, jobSeqNo, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMonitoringList(
		long groupId, long userId, long jobVirtualLabId, long jobClassId,
		java.lang.String searchValue, long jobStatus, int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getMonitoringList(groupId, userId,
			jobVirtualLabId, jobClassId, searchValue, jobStatus, begin, end);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMonitoringJobList(
		long groupId, java.lang.String simulationUuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getMonitoringJobList(groupId,
			simulationUuid);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getMonitoringJob(
		long groupId, java.lang.String simulationUuid, long jobSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getMonitoringJob(groupId,
			simulationUuid, jobSeqNo);
	}

	@Override
	public int getMonitoringCount(long groupId, long userId,
		long jobVirtualLabId, long jobClassId, java.lang.String searchValue,
		long jobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.getMonitoringCount(groupId, userId,
			jobVirtualLabId, jobClassId, searchValue, jobStatus);
	}

	@Override
	public boolean deleteMonitoringByJobClassId(long groupId, long jobClassId,
		com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.deleteMonitoringByJobClassId(groupId,
			jobClassId, user);
	}

	@Override
	public java.lang.String deleteMonitoring(java.lang.String simulationUuid,
		long groupId, long jobSeqNo, com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobLocalService.deleteMonitoring(simulationUuid,
			groupId, jobSeqNo, user);
	}

	@Override
	public long getMaxStatusSeqSimulationJobStatus(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid) {
		return _simulationJobLocalService.getMaxStatusSeqSimulationJobStatus(groupId,
			simulationUuid, jobUuid);
	}

	@Override
	public long getStatusSimulationJobStatus(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid) {
		return _simulationJobLocalService.getStatusSimulationJobStatus(groupId,
			simulationUuid, jobUuid);
	}

	/**
	* ###########################################################################################################################################################################
	* ###########################################################################################################################################################################
	* ###########################################################################################################################################################################
	* ###########################################################################################################################################################################
	* ##### 占쎈벀��Service #########################################################################################################################################################
	* ###########################################################################################################################################################################
	* ###########################################################################################################################################################################
	* ###########################################################################################################################################################################
	* ###########################################################################################################################################################################
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLabSearchUni(
		long groupId, java.lang.String languageId, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getListVirtualLabSearchUni(groupId,
			languageId, jobUniversityField);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualClassSearchLab(
		long groupId, java.lang.String languageId, long jobVirtualLabId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getListVirtualClassSearchLab(groupId,
			languageId, jobVirtualLabId);
	}

	/**
	* ##### 1. EXE START ###################################################################################################################################################
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsExecTableOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsExecTableOrganigation(groupId,
			languageId, startDt, endDt, jobUniversityField);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsExecPieChartOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsExecPieChartOrganigation(groupId,
			languageId, startDt, endDt, jobUniversityField);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsExecBarChartDate(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsExecBarChartDate(groupId,
			languageId, startDt, endDt, jobUniversityField);
	}

	/**
	* ##### 2. Sw START ###################################################################################################################################################
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsSwTableOrganigation(
		long entryId, long vocabularyId, long columnId,
		java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long universityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsSwTableOrganigation(entryId,
			vocabularyId, columnId, languageId, startDt, endDt, universityId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsSwBarChartDate(
		long entryId, long vocabularyId, long columnId,
		java.lang.String startDt, java.lang.String endDt, long universityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsSwBarChartDate(entryId,
			vocabularyId, columnId, startDt, endDt, universityId);
	}

	/**
	* ##### 3. SwExe START ###################################################################################################################################################
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsSwExeTableOrganigation(
		long groupId, java.lang.String languageId, long columnId,
		java.lang.String startDt, java.lang.String endDt, long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsSwExeTableOrganigation(groupId,
			languageId, columnId, startDt, endDt, scienceAppId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsSwExeBarChartDate(
		long groupId, long columnId, java.lang.String startDt,
		java.lang.String endDt, long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsSwExeBarChartDate(groupId,
			columnId, startDt, endDt, scienceAppId);
	}

	/**
	* ##### 4. Time START ###################################################################################################################################################
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsTimeTableOrganigation(
		long groupId, java.lang.String startDt, java.lang.String endDt)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsTimeTableOrganigation(groupId,
			startDt, endDt);
	}

	/**
	* ##### 5. User START ###################################################################################################################################################
	*/
	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsUserTableOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsUserTableOrganigation(groupId,
			languageId, startDt, endDt, jobUniversityField);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsUserPieChartOrganigation(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsUserPieChartOrganigation(groupId,
			languageId, startDt, endDt, jobUniversityField);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsUserBarChartDate(
		long groupId, java.lang.String languageId, java.lang.String startDt,
		java.lang.String endDt, long jobUniversityField)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _simulationJobLocalService.getStatisticsUserBarChartDate(groupId,
			languageId, startDt, endDt, jobUniversityField);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SimulationJobLocalService getWrappedSimulationJobLocalService() {
		return _simulationJobLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSimulationJobLocalService(
		SimulationJobLocalService simulationJobLocalService) {
		_simulationJobLocalService = simulationJobLocalService;
	}

	@Override
	public SimulationJobLocalService getWrappedService() {
		return _simulationJobLocalService;
	}

	@Override
	public void setWrappedService(
		SimulationJobLocalService simulationJobLocalService) {
		_simulationJobLocalService = simulationJobLocalService;
	}

	private SimulationJobLocalService _simulationJobLocalService;
}