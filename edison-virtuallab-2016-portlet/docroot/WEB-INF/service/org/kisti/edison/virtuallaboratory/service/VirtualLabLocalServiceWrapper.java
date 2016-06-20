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

package org.kisti.edison.virtuallaboratory.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VirtualLabLocalService}.
 *
 * @author EDISON
 * @see VirtualLabLocalService
 * @generated
 */
public class VirtualLabLocalServiceWrapper implements VirtualLabLocalService,
	ServiceWrapper<VirtualLabLocalService> {
	public VirtualLabLocalServiceWrapper(
		VirtualLabLocalService virtualLabLocalService) {
		_virtualLabLocalService = virtualLabLocalService;
	}

	/**
	* Adds the virtual lab to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLab the virtual lab
	* @return the virtual lab that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab addVirtualLab(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.addVirtualLab(virtualLab);
	}

	/**
	* Creates a new virtual lab with the primary key. Does not add the virtual lab to the database.
	*
	* @param virtualLabId the primary key for the new virtual lab
	* @return the new virtual lab
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab createVirtualLab(
		long virtualLabId) {
		return _virtualLabLocalService.createVirtualLab(virtualLabId);
	}

	/**
	* Deletes the virtual lab with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabId the primary key of the virtual lab
	* @return the virtual lab that was removed
	* @throws PortalException if a virtual lab with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab deleteVirtualLab(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.deleteVirtualLab(virtualLabId);
	}

	/**
	* Deletes the virtual lab from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLab the virtual lab
	* @return the virtual lab that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab deleteVirtualLab(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.deleteVirtualLab(virtualLab);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _virtualLabLocalService.dynamicQuery();
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
		return _virtualLabLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _virtualLabLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _virtualLabLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _virtualLabLocalService.dynamicQueryCount(dynamicQuery);
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
		return _virtualLabLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab fetchVirtualLab(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.fetchVirtualLab(virtualLabId);
	}

	/**
	* Returns the virtual lab with the primary key.
	*
	* @param virtualLabId the primary key of the virtual lab
	* @return the virtual lab
	* @throws PortalException if a virtual lab with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab getVirtualLab(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLab(virtualLabId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the virtual labs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual labs
	* @param end the upper bound of the range of virtual labs (not inclusive)
	* @return the range of virtual labs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabs(start, end);
	}

	/**
	* Returns the number of virtual labs.
	*
	* @return the number of virtual labs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabsCount();
	}

	/**
	* Updates the virtual lab in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLab the virtual lab
	* @return the virtual lab that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLab(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.updateVirtualLab(virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLab(long classId, long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addVirtualLabClassVirtualLab(classId,
			virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLab(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addVirtualLabClassVirtualLab(classId, virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabs(long classId, long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addVirtualLabClassVirtualLabs(classId,
			virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabs(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addVirtualLabClassVirtualLabs(classId,
			VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearVirtualLabClassVirtualLabs(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.clearVirtualLabClassVirtualLabs(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLab(long classId, long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteVirtualLabClassVirtualLab(classId,
			virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLab(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteVirtualLabClassVirtualLab(classId,
			virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabs(long classId,
		long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteVirtualLabClassVirtualLabs(classId,
			virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabs(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteVirtualLabClassVirtualLabs(classId,
			VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabClassVirtualLabs(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabClassVirtualLabs(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabClassVirtualLabs(
		long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabClassVirtualLabs(classId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabClassVirtualLabs(
		long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabClassVirtualLabs(classId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabClassVirtualLabsCount(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabClassVirtualLabsCount(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassVirtualLab(long classId, long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.hasVirtualLabClassVirtualLab(classId,
			virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassVirtualLabs(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.hasVirtualLabClassVirtualLabs(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setVirtualLabClassVirtualLabs(long classId, long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.setVirtualLabClassVirtualLabs(classId,
			virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyVirtualLab(long surveySeqNo, long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addSurveyVirtualLab(surveySeqNo, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyVirtualLab(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addSurveyVirtualLab(surveySeqNo, virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyVirtualLabs(long surveySeqNo, long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addSurveyVirtualLabs(surveySeqNo, virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyVirtualLabs(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.addSurveyVirtualLabs(surveySeqNo, VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearSurveyVirtualLabs(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.clearSurveyVirtualLabs(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyVirtualLab(long surveySeqNo, long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteSurveyVirtualLab(surveySeqNo, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyVirtualLab(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteSurveyVirtualLab(surveySeqNo, virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyVirtualLabs(long surveySeqNo, long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteSurveyVirtualLabs(surveySeqNo,
			virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyVirtualLabs(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.deleteSurveyVirtualLabs(surveySeqNo, VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getSurveyVirtualLabs(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getSurveyVirtualLabs(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getSurveyVirtualLabs(
		long surveySeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getSurveyVirtualLabs(surveySeqNo, start,
			end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getSurveyVirtualLabs(
		long surveySeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getSurveyVirtualLabs(surveySeqNo, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyVirtualLabsCount(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getSurveyVirtualLabsCount(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyVirtualLab(long surveySeqNo, long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.hasSurveyVirtualLab(surveySeqNo,
			virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyVirtualLabs(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.hasSurveyVirtualLabs(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setSurveyVirtualLabs(long surveySeqNo, long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabLocalService.setSurveyVirtualLabs(surveySeqNo, virtualLabIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _virtualLabLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_virtualLabLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _virtualLabLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab addVirtualLab(
		java.util.Map<java.lang.String, java.lang.String> param,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.addVirtualLab(param, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualLabAuthList(
		long groupId, long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabAuthList(groupId, userId,
			locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualLabClassRegisterList(
		long groupId, long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabClassRegisterList(groupId,
			userId, locale);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getVirtualLabClassRegisterInfo(
		long classId, long userId, long groupId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getVirtualLabClassRegisterInfo(classId,
			userId, groupId, locale);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getVirtualLabInfomation(
		long virtualLabId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return _virtualLabLocalService.getVirtualLabInfomation(virtualLabId,
			locale);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLabStatus(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return _virtualLabLocalService.updateVirtualLabStatus(params);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLab(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabLocalService.getListVirtualLab(params, locale);
	}

	@Override
	public int getCountVirtualLab(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _virtualLabLocalService.getCountVirtualLab(params, locale);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLabInfomation(
		java.util.Map<java.lang.String, java.lang.String> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return _virtualLabLocalService.updateVirtualLabInfomation(params, locale);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLabDisable(
		long virtualLabId, java.lang.String disableFlag)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return _virtualLabLocalService.updateVirtualLabDisable(virtualLabId,
			disableFlag);
	}

	@Override
	public void transferVirtualLabOwner(long virtualLabId, long userId,
		long roleId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		_virtualLabLocalService.transferVirtualLabOwner(virtualLabId, userId,
			roleId, companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VirtualLabLocalService getWrappedVirtualLabLocalService() {
		return _virtualLabLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVirtualLabLocalService(
		VirtualLabLocalService virtualLabLocalService) {
		_virtualLabLocalService = virtualLabLocalService;
	}

	@Override
	public VirtualLabLocalService getWrappedService() {
		return _virtualLabLocalService;
	}

	@Override
	public void setWrappedService(VirtualLabLocalService virtualLabLocalService) {
		_virtualLabLocalService = virtualLabLocalService;
	}

	private VirtualLabLocalService _virtualLabLocalService;
}