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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VirtualLab. This utility wraps
 * {@link org.kisti.edison.virtuallaboratory.service.impl.VirtualLabLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see VirtualLabLocalService
 * @see org.kisti.edison.virtuallaboratory.service.base.VirtualLabLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.impl.VirtualLabLocalServiceImpl
 * @generated
 */
public class VirtualLabLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.virtuallaboratory.service.impl.VirtualLabLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the virtual lab to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLab the virtual lab
	* @return the virtual lab that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab addVirtualLab(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVirtualLab(virtualLab);
	}

	/**
	* Creates a new virtual lab with the primary key. Does not add the virtual lab to the database.
	*
	* @param virtualLabId the primary key for the new virtual lab
	* @return the new virtual lab
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab createVirtualLab(
		long virtualLabId) {
		return getService().createVirtualLab(virtualLabId);
	}

	/**
	* Deletes the virtual lab with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabId the primary key of the virtual lab
	* @return the virtual lab that was removed
	* @throws PortalException if a virtual lab with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab deleteVirtualLab(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVirtualLab(virtualLabId);
	}

	/**
	* Deletes the virtual lab from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLab the virtual lab
	* @return the virtual lab that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab deleteVirtualLab(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVirtualLab(virtualLab);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.virtuallaboratory.model.VirtualLab fetchVirtualLab(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVirtualLab(virtualLabId);
	}

	/**
	* Returns the virtual lab with the primary key.
	*
	* @param virtualLabId the primary key of the virtual lab
	* @return the virtual lab
	* @throws PortalException if a virtual lab with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab getVirtualLab(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLab(virtualLabId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabs(start, end);
	}

	/**
	* Returns the number of virtual labs.
	*
	* @return the number of virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabsCount();
	}

	/**
	* Updates the virtual lab in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLab the virtual lab
	* @return the virtual lab that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLab(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVirtualLab(virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLab(long classId,
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabClassVirtualLab(classId, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLab(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabClassVirtualLab(classId, virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLabs(long classId,
		long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabClassVirtualLabs(classId, virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLabs(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabClassVirtualLabs(classId, VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabClassVirtualLabs(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearVirtualLabClassVirtualLabs(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLab(long classId,
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabClassVirtualLab(classId, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLab(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabClassVirtualLab(classId, virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLabs(long classId,
		long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabClassVirtualLabs(classId, virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLabs(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabClassVirtualLabs(classId, VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabClassVirtualLabs(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassVirtualLabs(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabClassVirtualLabs(
		long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassVirtualLabs(classId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabClassVirtualLabs(
		long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassVirtualLabs(classId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassVirtualLabsCount(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassVirtualLabsCount(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabClassVirtualLab(long classId,
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabClassVirtualLab(classId, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabClassVirtualLabs(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabClassVirtualLabs(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClassVirtualLabs(long classId,
		long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setVirtualLabClassVirtualLabs(classId, virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyVirtualLab(long surveySeqNo, long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyVirtualLab(surveySeqNo, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyVirtualLab(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyVirtualLab(surveySeqNo, virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyVirtualLabs(long surveySeqNo,
		long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyVirtualLabs(surveySeqNo, virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyVirtualLabs(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyVirtualLabs(surveySeqNo, VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveyVirtualLabs(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearSurveyVirtualLabs(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyVirtualLab(long surveySeqNo,
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyVirtualLab(surveySeqNo, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyVirtualLab(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyVirtualLab(surveySeqNo, virtualLab);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyVirtualLabs(long surveySeqNo,
		long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyVirtualLabs(surveySeqNo, virtualLabIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyVirtualLabs(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> VirtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyVirtualLabs(surveySeqNo, VirtualLabs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getSurveyVirtualLabs(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyVirtualLabs(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getSurveyVirtualLabs(
		long surveySeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyVirtualLabs(surveySeqNo, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getSurveyVirtualLabs(
		long surveySeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveyVirtualLabs(surveySeqNo, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyVirtualLabsCount(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyVirtualLabsCount(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveyVirtualLab(long surveySeqNo,
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasSurveyVirtualLab(surveySeqNo, virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveyVirtualLabs(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasSurveyVirtualLabs(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveyVirtualLabs(long surveySeqNo,
		long[] virtualLabIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setSurveyVirtualLabs(surveySeqNo, virtualLabIds);
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

	public static org.kisti.edison.virtuallaboratory.model.VirtualLab addVirtualLab(
		java.util.Map<java.lang.String, java.lang.String> param,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVirtualLab(param, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualLabAuthList(
		long groupId, long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabAuthList(groupId, userId, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualLabClassRegisterList(
		long groupId, long userId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassRegisterList(groupId, userId, locale);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getVirtualLabClassRegisterInfo(
		long classId, long userId, long groupId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassRegisterInfo(classId, userId, groupId,
			locale);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getVirtualLabInfomation(
		long virtualLabId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return getService().getVirtualLabInfomation(virtualLabId, locale);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLabStatus(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return getService().updateVirtualLabStatus(params);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLab(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListVirtualLab(params, locale);
	}

	public static int getCountVirtualLab(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getCountVirtualLab(params, locale);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLabInfomation(
		java.util.Map<java.lang.String, java.lang.String> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return getService().updateVirtualLabInfomation(params, locale);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLab updateVirtualLabDisable(
		long virtualLabId, java.lang.String disableFlag)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return getService().updateVirtualLabDisable(virtualLabId, disableFlag);
	}

	public static void transferVirtualLabOwner(long virtualLabId, long userId,
		long roleId, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		getService()
			.transferVirtualLabOwner(virtualLabId, userId, roleId, companyId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VirtualLabLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VirtualLabLocalService.class.getName());

			if (invokableLocalService instanceof VirtualLabLocalService) {
				_service = (VirtualLabLocalService)invokableLocalService;
			}
			else {
				_service = new VirtualLabLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VirtualLabLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VirtualLabLocalService service) {
	}

	private static VirtualLabLocalService _service;
}