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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Simulation. This utility wraps
 * {@link org.kisti.edison.bestsimulation.service.impl.SimulationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see SimulationLocalService
 * @see org.kisti.edison.bestsimulation.service.base.SimulationLocalServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.impl.SimulationLocalServiceImpl
 * @generated
 */
public class SimulationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.bestsimulation.service.impl.SimulationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the simulation to the database. Also notifies the appropriate model listeners.
	*
	* @param simulation the simulation
	* @return the simulation that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.Simulation addSimulation(
		org.kisti.edison.bestsimulation.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSimulation(simulation);
	}

	/**
	* Creates a new simulation with the primary key. Does not add the simulation to the database.
	*
	* @param simulationPK the primary key for the new simulation
	* @return the new simulation
	*/
	public static org.kisti.edison.bestsimulation.model.Simulation createSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK) {
		return getService().createSimulation(simulationPK);
	}

	/**
	* Deletes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationPK the primary key of the simulation
	* @return the simulation that was removed
	* @throws PortalException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.Simulation deleteSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSimulation(simulationPK);
	}

	/**
	* Deletes the simulation from the database. Also notifies the appropriate model listeners.
	*
	* @param simulation the simulation
	* @return the simulation that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.Simulation deleteSimulation(
		org.kisti.edison.bestsimulation.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSimulation(simulation);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.kisti.edison.bestsimulation.model.Simulation fetchSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSimulation(simulationPK);
	}

	/**
	* Returns the simulation with the primary key.
	*
	* @param simulationPK the primary key of the simulation
	* @return the simulation
	* @throws PortalException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.Simulation getSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSimulation(simulationPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the simulations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulations
	* @param end the upper bound of the range of simulations (not inclusive)
	* @return the range of simulations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.bestsimulation.model.Simulation> getSimulations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSimulations(start, end);
	}

	/**
	* Returns the number of simulations.
	*
	* @return the number of simulations
	* @throws SystemException if a system exception occurred
	*/
	public static int getSimulationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSimulationsCount();
	}

	/**
	* Updates the simulation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param simulation the simulation
	* @return the simulation that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.Simulation updateSimulation(
		org.kisti.edison.bestsimulation.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSimulation(simulation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.kisti.edison.bestsimulation.model.Simulation addSimulation(
		java.util.Map params)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSimulation(params);
	}

	/**
	* 占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉�     * 占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉�     * 占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쏙옙Icebreaker Service Start 占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙占�    * 占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉�     * 占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉싷옙議삳폏占쎌』堉�     */
	public static org.kisti.edison.model.IcebreakerVcToken getOrCreateToken(
		long thisGroupId, com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.net.MalformedURLException,
			java.text.ParseException {
		return getService().getOrCreateToken(thisGroupId, user);
	}

	/**
	* 占쎌뮆占쏙옙�됱뵠占쏙옙占쎌빘苑�     *
	* @throws JSONException
	* @Token : Token
	* @title : title
	* @description : description
	* @return String uuid
	*/
	public static java.util.Map createSimulation(
		java.lang.String icebreakerUrl, java.lang.String icebreakerZone,
		java.lang.String vcToken, java.lang.String scienceAppId,
		java.lang.String title, java.lang.String description)
		throws java.io.IOException, java.net.MalformedURLException {
		return getService()
				   .createSimulation(icebreakerUrl, icebreakerZone, vcToken,
			scienceAppId, title, description);
	}

	/**
	* 占쎌뮆占쏙옙�됱뵠占쏙옙占쎌꼹六�     *
	* @simulationUuid
	* @fileId
	* @Token
	* @title
	* @description
	* @scienceApp_name
	* @return
	* @throws ParserConfigurationException
	* @throws SAXException
	*/
	public static java.util.Map executeJob(java.lang.String icebreakerUrl,
		java.util.Map params)
		throws java.io.IOException, java.net.MalformedURLException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return getService().executeJob(icebreakerUrl, params);
	}

	/**
	* 占쎌뮆占쏙옙�됱뵠占쏙옙占쎌꼹六�     *
	* @simulationUuid
	* @job_uuid
	* @Token
	* @return status
	*/
	public static java.util.Map statusJob(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String simulationUuid,
		java.lang.String job_uuid)
		throws java.io.IOException, java.net.MalformedURLException {
		return getService()
				   .statusJob(icebreakerUrl, vcToken, simulationUuid, job_uuid);
	}

	/**
	* 占쎌뮆占쏙옙�됱뵠占쏙옙占쎌꼷��     *
	* @throws JSONException
	* @Token : 占쎈챷弛�占쎌쥚寃�     * @uuid : 占쎌뮆占쏙옙�됱뵠占쏙옙占쎄쑴�좑옙占�    * @return int resultCode
	*/
	public static int updateSimulation(java.lang.String icebreakerUrl,
		java.lang.String simulationUuid, java.lang.String vcToken,
		java.lang.String title, java.lang.String description)
		throws java.io.IOException, java.net.MalformedURLException {
		return getService()
				   .updateSimulation(icebreakerUrl, simulationUuid, vcToken,
			title, description);
	}

	/**
	* 占쎈슣��占쎈굝以덌옙占�    *
	*
	* @param params
	String    Token
	File        file
	* @throws MalformedURLException
	* @throws IOException
	* @throws JSONException
	* @throws InterruptedException
	*/
	public static java.util.Map uploadFile(java.lang.String cluster,
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.io.File file)
		throws java.io.IOException, java.lang.InterruptedException,
			java.net.MalformedURLException {
		return getService().uploadFile(cluster, icebreakerUrl, vcToken, file);
	}

	/**
	* 占쎈슣��占쏙옙��     *
	* @param icebreakerUrl
	* @param vcToken
	* @param fileId
	* @throws IOException
	*/
	public static void deleteFile(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String fileId)
		throws java.io.IOException {
		getService().deleteFile(icebreakerUrl, vcToken, fileId);
	}

	/**
	* serverFile 筌뤴뫖以�     */
	public static java.lang.String getServerFileList(
		java.lang.String icebreakerUrl, java.lang.String cmd_directory,
		java.lang.String cluster, java.lang.String vcToken)
		throws java.io.IOException, java.net.MalformedURLException {
		return getService()
				   .getServerFileList(icebreakerUrl, cmd_directory, cluster,
			vcToken);
	}

	/**
	* job癰귨옙野껉퀗��占쎈슣��zip占쎈벤源�에占쏙옙�쇱뒲嚥≪뮆諭�     *
	* @simulationUuid
	* @job_uuid
	* @Token
	* @return status
	*/
	public static java.io.InputStream downloadFileJob(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String job_uuid)
		throws java.io.IOException, java.net.MalformedURLException {
		return getService().downloadFileJob(icebreakerUrl, vcToken, job_uuid);
	}

	/**
	* job error 癰귣떯由�     *
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	public static java.lang.String errorView(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String job_uuid)
		throws java.io.IOException {
		return getService().errorView(icebreakerUrl, vcToken, job_uuid);
	}

	/**
	* 占쎈슣��ID 占쎈벡��     *
	* @throws IOException
	*/
	public static java.lang.String retrieveFileId(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String job_uuid, java.lang.String fileName)
		throws java.io.IOException {
		return getService()
				   .retrieveFileId(icebreakerUrl, vcToken, job_uuid, fileName);
	}

	/**
	* 占쎈뗀�놅옙醫듼봺 占쎈슣��鈺곌퀬��     * 占쎌눖而뀐옙怨몄뵥 占쎄쑴荑귞뵳�由�筌뤴뫖以됵옙占폻ir = result
	*
	* @throws IOException
	*/
	public static java.lang.String retrievePostProcessor(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String jobUuid) throws java.io.IOException {
		return getService()
				   .retrievePostProcessor(icebreakerUrl, vcToken, jobUuid);
	}

	public static java.lang.String retrieveRemoteDir(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String jobUuid, java.lang.String dirPath)
		throws java.io.IOException {
		return getService()
				   .retrieveRemoteDir(icebreakerUrl, vcToken, jobUuid, dirPath);
	}

	/**
	* simulation job 餓λ쵐占�     *
	* @param params
	* @return
	* @throws IOException
	*/
	public static int cancleJob(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String simulationUuid,
		java.lang.String job_uuid) throws java.io.IOException {
		return getService()
				   .cancleJob(icebreakerUrl, vcToken, simulationUuid, job_uuid);
	}

	/**
	* job error 癰귣떯由�     *
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	public static java.lang.String getResultRead(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String fileId) throws java.io.IOException {
		return getService().getResultRead(icebreakerUrl, vcToken, fileId);
	}

	/**
	* file 鈺곌퀬��     *
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	public static java.io.InputStream getFileRead(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String fileId) throws java.io.IOException {
		return getService().getFileRead(icebreakerUrl, vcToken, fileId);
	}

	/**
	* webgl占쏙옙占쎄쑵釉�占쎈슣��占쎌빘苑�占쏙옙url �귐뗪쉘(占쎄쑴��占싼딆뒠-�곕���占쎌꼷��占쎈뜆��
	*
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	public static java.lang.String getResultFile(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String simulationUuid, java.lang.String fileName)
		throws java.io.IOException {
		return getService()
				   .getResultFile(icebreakerUrl, vcToken, simulationUuid,
			fileName);
	}

	/**
	* Get Current Assignd Core Count
	*
	* @param params
	* @throws IOException
	*/
	public static java.lang.String getCurrentAssignedCoresByUser(
		java.lang.String icebreakerUrl, java.lang.String vcToken)
		throws java.io.IOException {
		return getService().getCurrentAssignedCoresByUser(icebreakerUrl, vcToken);
	}

	/**
	* getUserRepositorySize 鈺곌퀬��     *
	* @param params
	* @return
	* @throws IOException
	* @throws JSONException
	*/
	public static java.lang.String getUserRepositorySize(
		java.lang.String icebreakerUrl, java.lang.String vcToken)
		throws java.io.IOException {
		return getService().getUserRepositorySize(icebreakerUrl, vcToken);
	}

	public static int deleteSimulationJob(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String simulationUuid,
		java.lang.String jobUuid) throws java.io.IOException {
		return getService()
				   .deleteSimulationJob(icebreakerUrl, vcToken, simulationUuid,
			jobUuid);
	}

	public static void clearService() {
		_service = null;
	}

	public static SimulationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SimulationLocalService.class.getName());

			if (invokableLocalService instanceof SimulationLocalService) {
				_service = (SimulationLocalService)invokableLocalService;
			}
			else {
				_service = new SimulationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SimulationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SimulationLocalService service) {
	}

	private static SimulationLocalService _service;
}