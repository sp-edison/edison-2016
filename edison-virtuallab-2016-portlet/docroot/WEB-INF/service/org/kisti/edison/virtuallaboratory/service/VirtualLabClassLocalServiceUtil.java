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
 * Provides the local service utility for VirtualLabClass. This utility wraps
 * {@link org.kisti.edison.virtuallaboratory.service.impl.VirtualLabClassLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see VirtualLabClassLocalService
 * @see org.kisti.edison.virtuallaboratory.service.base.VirtualLabClassLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.impl.VirtualLabClassLocalServiceImpl
 * @generated
 */
public class VirtualLabClassLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.virtuallaboratory.service.impl.VirtualLabClassLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the virtual lab class to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClass the virtual lab class
	* @return the virtual lab class that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass addVirtualLabClass(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVirtualLabClass(virtualLabClass);
	}

	/**
	* Creates a new virtual lab class with the primary key. Does not add the virtual lab class to the database.
	*
	* @param classId the primary key for the new virtual lab class
	* @return the new virtual lab class
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass createVirtualLabClass(
		long classId) {
		return getService().createVirtualLabClass(classId);
	}

	/**
	* Deletes the virtual lab class with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classId the primary key of the virtual lab class
	* @return the virtual lab class that was removed
	* @throws PortalException if a virtual lab class with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass deleteVirtualLabClass(
		long classId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVirtualLabClass(classId);
	}

	/**
	* Deletes the virtual lab class from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClass the virtual lab class
	* @return the virtual lab class that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass deleteVirtualLabClass(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVirtualLabClass(virtualLabClass);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass fetchVirtualLabClass(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVirtualLabClass(classId);
	}

	/**
	* Returns the virtual lab class with the primary key.
	*
	* @param classId the primary key of the virtual lab class
	* @return the virtual lab class
	* @throws PortalException if a virtual lab class with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass getVirtualLabClass(
		long classId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClass(classId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the virtual lab classes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @return the range of virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClasses(start, end);
	}

	/**
	* Returns the number of virtual lab classes.
	*
	* @return the number of virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassesCount();
	}

	/**
	* Updates the virtual lab class in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClass the virtual lab class
	* @return the virtual lab class that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass updateVirtualLabClass(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVirtualLabClass(virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabVirtualLabClass(long virtualLabId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabVirtualLabClass(virtualLabId, classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabVirtualLabClass(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabVirtualLabClass(virtualLabId, virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabVirtualLabClasses(long virtualLabId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabVirtualLabClasses(virtualLabId, classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabVirtualLabClasses(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabVirtualLabClasses(virtualLabId, VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabVirtualLabClasses(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearVirtualLabVirtualLabClasses(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabVirtualLabClass(long virtualLabId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabVirtualLabClass(virtualLabId, classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabVirtualLabClass(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabVirtualLabClass(virtualLabId, virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabVirtualLabClasses(long virtualLabId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabVirtualLabClasses(virtualLabId, classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabVirtualLabClasses(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabVirtualLabClasses(virtualLabId, VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabVirtualLabClasses(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabVirtualLabClasses(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabVirtualLabClasses(
		long virtualLabId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabVirtualLabClasses(virtualLabId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabVirtualLabClasses(
		long virtualLabId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabVirtualLabClasses(virtualLabId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabVirtualLabClassesCount(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabVirtualLabClassesCount(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabVirtualLabClass(long virtualLabId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabVirtualLabClass(virtualLabId, classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabVirtualLabClasses(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabVirtualLabClasses(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabVirtualLabClasses(long virtualLabId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setVirtualLabVirtualLabClasses(virtualLabId, classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.clearVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassScienceAppVirtualLabClassesCount(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassScienceAppVirtualLabClassesCount(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabUserVirtualLabClass(long virtualLabUserId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabUserVirtualLabClass(virtualLabUserId, classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabUserVirtualLabClass(long virtualLabUserId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabUserVirtualLabClass(virtualLabUserId, virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabUserVirtualLabClasses(
		long virtualLabUserId, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabUserVirtualLabClasses(virtualLabUserId, classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabUserVirtualLabClasses(
		long virtualLabUserId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabUserVirtualLabClasses(virtualLabUserId,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabUserVirtualLabClasses(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearVirtualLabUserVirtualLabClasses(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabUserVirtualLabClass(
		long virtualLabUserId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabUserVirtualLabClass(virtualLabUserId, classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabUserVirtualLabClass(
		long virtualLabUserId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabUserVirtualLabClass(virtualLabUserId,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabUserVirtualLabClasses(
		long virtualLabUserId, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabUserVirtualLabClasses(virtualLabUserId, classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabUserVirtualLabClasses(
		long virtualLabUserId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabUserVirtualLabClasses(virtualLabUserId,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabUserVirtualLabClasses(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabUserVirtualLabClasses(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabUserVirtualLabClasses(
		long virtualLabUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabUserVirtualLabClasses(virtualLabUserId, start,
			end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabUserVirtualLabClasses(
		long virtualLabUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabUserVirtualLabClasses(virtualLabUserId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabUserVirtualLabClassesCount(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabUserVirtualLabClassesCount(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabUserVirtualLabClass(
		long virtualLabUserId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasVirtualLabUserVirtualLabClass(virtualLabUserId, classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabUserVirtualLabClasses(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabUserVirtualLabClasses(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabUserVirtualLabClasses(
		long virtualLabUserId, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setVirtualLabUserVirtualLabClasses(virtualLabUserId, classIds);
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

	public static java.util.Map<java.lang.String, java.lang.String> getVirtualClassMainVisual(
		long classId, java.util.Locale locale) {
		return getService().getVirtualClassMainVisual(classId, locale);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getVirtualLabClassInfo(
		long classId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException {
		return getService().getVirtualLabClassInfo(classId, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassList(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getVirtualClassList(params, locale);
	}

	public static int getVirtualClassListCount(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getService().getVirtualClassListCount(params);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass insertVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().insertVirtualLabClass(params, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListVirtualLabClass(params, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLabClass2(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListVirtualLabClass2(params, locale);
	}

	public static int getCountVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getCountVirtualLabClass(params, locale);
	}

	public static int getCountVirtualLabClass2(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getCountVirtualLabClass2(params, locale);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClass updateVirtualLabClassDisable(
		long classId, java.lang.String disableFlag)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return getService().updateVirtualLabClassDisable(classId, disableFlag);
	}

	public static java.util.List<java.lang.Long> getVirtualClassBoardSeqList(
		long groupId, long classId) {
		return getService().getVirtualClassBoardSeqList(groupId, classId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassStatisticsList(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getVirtualClassStatisticsList(params, locale);
	}

	public static int getCountVirtualClassStatistics(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getCountVirtualClassStatistics(params, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassStatisticsExcelList(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getVirtualClassStatisticsExcelList(params, locale);
	}

	public static void clearService() {
		_service = null;
	}

	public static VirtualLabClassLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VirtualLabClassLocalService.class.getName());

			if (invokableLocalService instanceof VirtualLabClassLocalService) {
				_service = (VirtualLabClassLocalService)invokableLocalService;
			}
			else {
				_service = new VirtualLabClassLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VirtualLabClassLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VirtualLabClassLocalService service) {
	}

	private static VirtualLabClassLocalService _service;
}