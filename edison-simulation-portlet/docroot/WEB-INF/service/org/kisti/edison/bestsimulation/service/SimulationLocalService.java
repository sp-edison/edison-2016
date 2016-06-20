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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for Simulation. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author EDISON
 * @see SimulationLocalServiceUtil
 * @see org.kisti.edison.bestsimulation.service.base.SimulationLocalServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.impl.SimulationLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SimulationLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SimulationLocalServiceUtil} to access the simulation local service. Add custom service methods to {@link org.kisti.edison.bestsimulation.service.impl.SimulationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the simulation to the database. Also notifies the appropriate model listeners.
	*
	* @param simulation the simulation
	* @return the simulation that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.bestsimulation.model.Simulation addSimulation(
		org.kisti.edison.bestsimulation.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new simulation with the primary key. Does not add the simulation to the database.
	*
	* @param simulationPK the primary key for the new simulation
	* @return the new simulation
	*/
	public org.kisti.edison.bestsimulation.model.Simulation createSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK);

	/**
	* Deletes the simulation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationPK the primary key of the simulation
	* @return the simulation that was removed
	* @throws PortalException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.bestsimulation.model.Simulation deleteSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the simulation from the database. Also notifies the appropriate model listeners.
	*
	* @param simulation the simulation
	* @return the simulation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.bestsimulation.model.Simulation deleteSimulation(
		org.kisti.edison.bestsimulation.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.bestsimulation.model.Simulation fetchSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulation with the primary key.
	*
	* @param simulationPK the primary key of the simulation
	* @return the simulation
	* @throws PortalException if a simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.bestsimulation.model.Simulation getSimulation(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK simulationPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.bestsimulation.model.Simulation> getSimulations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of simulations.
	*
	* @return the number of simulations
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSimulationsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the simulation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param simulation the simulation
	* @return the simulation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.bestsimulation.model.Simulation updateSimulation(
		org.kisti.edison.bestsimulation.model.Simulation simulation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public org.kisti.edison.bestsimulation.model.Simulation addSimulation(
		java.util.Map params)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* �졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚
	* �졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚
	* �졻뼚�졻뼚�졻뼚�졻뼚��Icebreaker Service Start �졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚��     * �졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚
	* �졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚�졻뼚
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.model.IcebreakerVcToken getOrCreateToken(
		long thisGroupId, com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.net.MalformedURLException,
			java.text.ParseException;

	/**
	* �쒕��덉씠���앹꽦
	*
	* @throws JSONException
	* @Token : Token
	* @title : title
	* @description : description
	* @return String uuid
	*/
	public java.util.Map createSimulation(java.lang.String icebreakerUrl,
		java.lang.String icebreakerZone, java.lang.String vcToken,
		java.lang.String scienceAppId, java.lang.String title,
		java.lang.String description)
		throws java.io.IOException, java.net.MalformedURLException;

	/**
	* �쒕��덉씠���섑뻾
	*
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
	public java.util.Map executeJob(java.lang.String icebreakerUrl,
		java.util.Map params)
		throws java.io.IOException, java.net.MalformedURLException,
			javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException;

	/**
	* �쒕��덉씠���섑뻾
	*
	* @simulationUuid
	* @job_uuid
	* @Token
	* @return status
	*/
	public java.util.Map statusJob(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String simulationUuid,
		java.lang.String job_uuid)
		throws java.io.IOException, java.net.MalformedURLException;

	/**
	* �쒕��덉씠���섏젙
	*
	* @throws JSONException
	* @Token : �몄쬆 �좏겙
	* @uuid : �쒕��덉씠���꾩씠��     * @return int resultCode
	*/
	public int updateSimulation(java.lang.String icebreakerUrl,
		java.lang.String simulationUuid, java.lang.String vcToken,
		java.lang.String title, java.lang.String description)
		throws java.io.IOException, java.net.MalformedURLException;

	/**
	* �뚯씪 �낅줈��     *
	* @param params
	String    Token
	File        file
	* @throws MalformedURLException
	* @throws IOException
	* @throws JSONException
	* @throws InterruptedException
	*/
	public java.util.Map uploadFile(java.lang.String cluster,
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.io.File file)
		throws java.io.IOException, java.lang.InterruptedException,
			java.net.MalformedURLException;

	/**
	* �뚯씪 ��젣
	*
	* @param icebreakerUrl
	* @param vcToken
	* @param fileId
	* @throws IOException
	*/
	public void deleteFile(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String fileId)
		throws java.io.IOException;

	/**
	* serverFile 紐⑸줉
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getServerFileList(java.lang.String icebreakerUrl,
		java.lang.String cmd_directory, java.lang.String cluster,
		java.lang.String vcToken)
		throws java.io.IOException, java.net.MalformedURLException;

	/**
	* job蹂�寃곌낵 �뚯씪 zip�뺥깭濡��ㅼ슫濡쒕뱶
	*
	* @simulationUuid
	* @job_uuid
	* @Token
	* @return status
	*/
	public java.io.InputStream downloadFileJob(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String job_uuid)
		throws java.io.IOException, java.net.MalformedURLException;

	/**
	* job error 蹂닿린
	*
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	public java.lang.String errorView(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String job_uuid)
		throws java.io.IOException;

	/**
	* �뚯씪 ID �뺤씤
	*
	* @throws IOException
	*/
	public java.lang.String retrieveFileId(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String job_uuid,
		java.lang.String fileName) throws java.io.IOException;

	/**
	* �붾젆�좊━ �뚯씪 議고쉶
	* �쇰컲�곸씤 �꾩쿂由ш린 紐⑸줉��dir = result
	*
	* @throws IOException
	*/
	public java.lang.String retrievePostProcessor(
		java.lang.String icebreakerUrl, java.lang.String vcToken,
		java.lang.String jobUuid) throws java.io.IOException;

	public java.lang.String retrieveRemoteDir(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String jobUuid,
		java.lang.String dirPath) throws java.io.IOException;

	/**
	* simulation job 以묒�
	*
	* @param params
	* @return
	* @throws IOException
	*/
	public int cancleJob(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String simulationUuid,
		java.lang.String job_uuid) throws java.io.IOException;

	/**
	* job error 蹂닿린
	*
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getResultRead(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String fileId)
		throws java.io.IOException;

	/**
	* file 議고쉶
	*
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.io.InputStream getFileRead(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String fileId)
		throws java.io.IOException;

	/**
	* webgl���꾪븳 �뚯씪 �앹꽦 ��url 由ы꽩(�꾩떆 �ъ슜-異뷀썑 �섏젙 �덉젙)
	*
	* @param params
	* @throws IOException
	* @throws JSONException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getResultFile(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String simulationUuid,
		java.lang.String fileName) throws java.io.IOException;

	/**
	* Get Current Assignd Core Count
	*
	* @param params
	* @throws IOException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCurrentAssignedCoresByUser(
		java.lang.String icebreakerUrl, java.lang.String vcToken)
		throws java.io.IOException;

	/**
	* getUserRepositorySize 議고쉶
	*
	* @param params
	* @return
	* @throws IOException
	* @throws JSONException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getUserRepositorySize(
		java.lang.String icebreakerUrl, java.lang.String vcToken)
		throws java.io.IOException;

	public int deleteSimulationJob(java.lang.String icebreakerUrl,
		java.lang.String vcToken, java.lang.String simulationUuid,
		java.lang.String jobUuid) throws java.io.IOException;
}