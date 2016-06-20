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
 * Provides a wrapper for {@link VirtualLabClassLocalService}.
 *
 * @author EDISON
 * @see VirtualLabClassLocalService
 * @generated
 */
public class VirtualLabClassLocalServiceWrapper
	implements VirtualLabClassLocalService,
		ServiceWrapper<VirtualLabClassLocalService> {
	public VirtualLabClassLocalServiceWrapper(
		VirtualLabClassLocalService virtualLabClassLocalService) {
		_virtualLabClassLocalService = virtualLabClassLocalService;
	}

	/**
	* Adds the virtual lab class to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClass the virtual lab class
	* @return the virtual lab class that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass addVirtualLabClass(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.addVirtualLabClass(virtualLabClass);
	}

	/**
	* Creates a new virtual lab class with the primary key. Does not add the virtual lab class to the database.
	*
	* @param classId the primary key for the new virtual lab class
	* @return the new virtual lab class
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass createVirtualLabClass(
		long classId) {
		return _virtualLabClassLocalService.createVirtualLabClass(classId);
	}

	/**
	* Deletes the virtual lab class with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classId the primary key of the virtual lab class
	* @return the virtual lab class that was removed
	* @throws PortalException if a virtual lab class with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass deleteVirtualLabClass(
		long classId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.deleteVirtualLabClass(classId);
	}

	/**
	* Deletes the virtual lab class from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClass the virtual lab class
	* @return the virtual lab class that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass deleteVirtualLabClass(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.deleteVirtualLabClass(virtualLabClass);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _virtualLabClassLocalService.dynamicQuery();
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
		return _virtualLabClassLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.dynamicQuery(dynamicQuery, start,
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
		return _virtualLabClassLocalService.dynamicQueryCount(dynamicQuery);
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
		return _virtualLabClassLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass fetchVirtualLabClass(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.fetchVirtualLabClass(classId);
	}

	/**
	* Returns the virtual lab class with the primary key.
	*
	* @param classId the primary key of the virtual lab class
	* @return the virtual lab class
	* @throws PortalException if a virtual lab class with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass getVirtualLabClass(
		long classId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabClass(classId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabClasses(start, end);
	}

	/**
	* Returns the number of virtual lab classes.
	*
	* @return the number of virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabClassesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabClassesCount();
	}

	/**
	* Updates the virtual lab class in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClass the virtual lab class
	* @return the virtual lab class that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass updateVirtualLabClass(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.updateVirtualLabClass(virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabVirtualLabClass(long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabVirtualLabClass(virtualLabId,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabVirtualLabClass(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabVirtualLabClass(virtualLabId,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabVirtualLabClasses(long virtualLabId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabVirtualLabClasses(virtualLabId,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabVirtualLabClasses(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabVirtualLabClasses(virtualLabId,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearVirtualLabVirtualLabClasses(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.clearVirtualLabVirtualLabClasses(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabVirtualLabClass(long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabVirtualLabClass(virtualLabId,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabVirtualLabClass(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabVirtualLabClass(virtualLabId,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabVirtualLabClasses(long virtualLabId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabVirtualLabClasses(virtualLabId,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabVirtualLabClasses(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabVirtualLabClasses(virtualLabId,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabVirtualLabClasses(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabVirtualLabClasses(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabVirtualLabClasses(
		long virtualLabId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabVirtualLabClasses(virtualLabId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabVirtualLabClasses(
		long virtualLabId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabVirtualLabClasses(virtualLabId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabVirtualLabClassesCount(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabVirtualLabClassesCount(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabVirtualLabClass(long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.hasVirtualLabVirtualLabClass(virtualLabId,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabVirtualLabClasses(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.hasVirtualLabVirtualLabClasses(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setVirtualLabVirtualLabClasses(long virtualLabId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.setVirtualLabVirtualLabClasses(virtualLabId,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.clearVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabClassScienceAppVirtualLabClassesCount(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabClassScienceAppVirtualLabClassesCount(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassScienceAppVirtualLabClass(
		long scienceAppSeqNo, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.hasVirtualLabClassScienceAppVirtualLabClass(scienceAppSeqNo,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.hasVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setVirtualLabClassScienceAppVirtualLabClasses(
		long scienceAppSeqNo, long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.setVirtualLabClassScienceAppVirtualLabClasses(scienceAppSeqNo,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabUserVirtualLabClass(long virtualLabUserId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabUserVirtualLabClass(virtualLabUserId,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabUserVirtualLabClass(long virtualLabUserId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabUserVirtualLabClass(virtualLabUserId,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabUserVirtualLabClasses(long virtualLabUserId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabUserVirtualLabClasses(virtualLabUserId,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabUserVirtualLabClasses(long virtualLabUserId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.addVirtualLabUserVirtualLabClasses(virtualLabUserId,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearVirtualLabUserVirtualLabClasses(long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.clearVirtualLabUserVirtualLabClasses(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabUserVirtualLabClass(long virtualLabUserId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabUserVirtualLabClass(virtualLabUserId,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabUserVirtualLabClass(long virtualLabUserId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabUserVirtualLabClass(virtualLabUserId,
			virtualLabClass);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabUserVirtualLabClasses(long virtualLabUserId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabUserVirtualLabClasses(virtualLabUserId,
			classIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabUserVirtualLabClasses(long virtualLabUserId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> VirtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.deleteVirtualLabUserVirtualLabClasses(virtualLabUserId,
			VirtualLabClasses);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabUserVirtualLabClasses(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabUserVirtualLabClasses(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabUserVirtualLabClasses(
		long virtualLabUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabUserVirtualLabClasses(virtualLabUserId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabUserVirtualLabClasses(
		long virtualLabUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabUserVirtualLabClasses(virtualLabUserId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabUserVirtualLabClassesCount(long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getVirtualLabUserVirtualLabClassesCount(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabUserVirtualLabClass(long virtualLabUserId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.hasVirtualLabUserVirtualLabClass(virtualLabUserId,
			classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabUserVirtualLabClasses(long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.hasVirtualLabUserVirtualLabClasses(virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setVirtualLabUserVirtualLabClasses(long virtualLabUserId,
		long[] classIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassLocalService.setVirtualLabUserVirtualLabClasses(virtualLabUserId,
			classIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _virtualLabClassLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_virtualLabClassLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _virtualLabClassLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getVirtualClassMainVisual(
		long classId, java.util.Locale locale) {
		return _virtualLabClassLocalService.getVirtualClassMainVisual(classId,
			locale);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getVirtualLabClassInfo(
		long classId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException {
		return _virtualLabClassLocalService.getVirtualLabClassInfo(classId,
			locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassList(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _virtualLabClassLocalService.getVirtualClassList(params, locale);
	}

	@Override
	public int getVirtualClassListCount(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return _virtualLabClassLocalService.getVirtualClassListCount(params);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass insertVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.insertVirtualLabClass(params, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getListVirtualLabClass(params,
			locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLabClass2(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassLocalService.getListVirtualLabClass2(params,
			locale);
	}

	@Override
	public int getCountVirtualLabClass(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _virtualLabClassLocalService.getCountVirtualLabClass(params,
			locale);
	}

	@Override
	public int getCountVirtualLabClass2(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _virtualLabClassLocalService.getCountVirtualLabClass2(params,
			locale);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass updateVirtualLabClassDisable(
		long classId, java.lang.String disableFlag)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return _virtualLabClassLocalService.updateVirtualLabClassDisable(classId,
			disableFlag);
	}

	@Override
	public java.util.List<java.lang.Long> getVirtualClassBoardSeqList(
		long groupId, long classId) {
		return _virtualLabClassLocalService.getVirtualClassBoardSeqList(groupId,
			classId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassStatisticsList(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _virtualLabClassLocalService.getVirtualClassStatisticsList(params,
			locale);
	}

	@Override
	public int getCountVirtualClassStatistics(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _virtualLabClassLocalService.getCountVirtualClassStatistics(params,
			locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassStatisticsExcelList(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _virtualLabClassLocalService.getVirtualClassStatisticsExcelList(params,
			locale);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VirtualLabClassLocalService getWrappedVirtualLabClassLocalService() {
		return _virtualLabClassLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVirtualLabClassLocalService(
		VirtualLabClassLocalService virtualLabClassLocalService) {
		_virtualLabClassLocalService = virtualLabClassLocalService;
	}

	@Override
	public VirtualLabClassLocalService getWrappedService() {
		return _virtualLabClassLocalService;
	}

	@Override
	public void setWrappedService(
		VirtualLabClassLocalService virtualLabClassLocalService) {
		_virtualLabClassLocalService = virtualLabClassLocalService;
	}

	private VirtualLabClassLocalService _virtualLabClassLocalService;
}