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
 * Provides a wrapper for {@link VirtualLabUserLocalService}.
 *
 * @author EDISON
 * @see VirtualLabUserLocalService
 * @generated
 */
public class VirtualLabUserLocalServiceWrapper
	implements VirtualLabUserLocalService,
		ServiceWrapper<VirtualLabUserLocalService> {
	public VirtualLabUserLocalServiceWrapper(
		VirtualLabUserLocalService virtualLabUserLocalService) {
		_virtualLabUserLocalService = virtualLabUserLocalService;
	}

	/**
	* Adds the virtual lab user to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUser the virtual lab user
	* @return the virtual lab user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser addVirtualLabUser(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.addVirtualLabUser(virtualLabUser);
	}

	/**
	* Creates a new virtual lab user with the primary key. Does not add the virtual lab user to the database.
	*
	* @param virtualLabUserId the primary key for the new virtual lab user
	* @return the new virtual lab user
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser createVirtualLabUser(
		long virtualLabUserId) {
		return _virtualLabUserLocalService.createVirtualLabUser(virtualLabUserId);
	}

	/**
	* Deletes the virtual lab user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserId the primary key of the virtual lab user
	* @return the virtual lab user that was removed
	* @throws PortalException if a virtual lab user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser deleteVirtualLabUser(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.deleteVirtualLabUser(virtualLabUserId);
	}

	/**
	* Deletes the virtual lab user from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUser the virtual lab user
	* @return the virtual lab user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser deleteVirtualLabUser(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.deleteVirtualLabUser(virtualLabUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _virtualLabUserLocalService.dynamicQuery();
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
		return _virtualLabUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _virtualLabUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _virtualLabUserLocalService.dynamicQuery(dynamicQuery, start,
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
		return _virtualLabUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _virtualLabUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser fetchVirtualLabUser(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.fetchVirtualLabUser(virtualLabUserId);
	}

	/**
	* Returns the virtual lab user with the primary key.
	*
	* @param virtualLabUserId the primary key of the virtual lab user
	* @return the virtual lab user
	* @throws PortalException if a virtual lab user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser getVirtualLabUser(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getVirtualLabUser(virtualLabUserId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the virtual lab users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab users
	* @param end the upper bound of the range of virtual lab users (not inclusive)
	* @return the range of virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getVirtualLabUsers(start, end);
	}

	/**
	* Returns the number of virtual lab users.
	*
	* @return the number of virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getVirtualLabUsersCount();
	}

	/**
	* Updates the virtual lab user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUser the virtual lab user
	* @return the virtual lab user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser updateVirtualLabUser(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.updateVirtualLabUser(virtualLabUser);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabUser(long classId,
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.addVirtualLabClassVirtualLabUser(classId,
			virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabUser(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.addVirtualLabClassVirtualLabUser(classId,
			virtualLabUser);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabUsers(long classId,
		long[] virtualLabUserIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.addVirtualLabClassVirtualLabUsers(classId,
			virtualLabUserIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabUsers(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> VirtualLabUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.addVirtualLabClassVirtualLabUsers(classId,
			VirtualLabUsers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearVirtualLabClassVirtualLabUsers(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.clearVirtualLabClassVirtualLabUsers(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabUser(long classId,
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.deleteVirtualLabClassVirtualLabUser(classId,
			virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabUser(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.deleteVirtualLabClassVirtualLabUser(classId,
			virtualLabUser);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabUsers(long classId,
		long[] virtualLabUserIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.deleteVirtualLabClassVirtualLabUsers(classId,
			virtualLabUserIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabUsers(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> VirtualLabUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.deleteVirtualLabClassVirtualLabUsers(classId,
			VirtualLabUsers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabClassVirtualLabUsers(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getVirtualLabClassVirtualLabUsers(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabClassVirtualLabUsers(
		long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getVirtualLabClassVirtualLabUsers(classId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabClassVirtualLabUsers(
		long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getVirtualLabClassVirtualLabUsers(classId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabClassVirtualLabUsersCount(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.getVirtualLabClassVirtualLabUsersCount(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassVirtualLabUser(long classId,
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.hasVirtualLabClassVirtualLabUser(classId,
			virtualLabUserId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassVirtualLabUsers(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.hasVirtualLabClassVirtualLabUsers(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setVirtualLabClassVirtualLabUsers(long classId,
		long[] virtualLabUserIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.setVirtualLabClassVirtualLabUsers(classId,
			virtualLabUserIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _virtualLabUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_virtualLabUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _virtualLabUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser addVirtualLabUser(
		long classId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.addVirtualLabUser(classId, userId);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser addTempUser(
		long classId, long userId, java.lang.String studentNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.addTempUser(classId, userId,
			studentNumber);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassStudentList(
		long virtualLabId, long classId, long questionSeqNo,
		java.lang.String search_parameter, long groupId) {
		return _virtualLabUserLocalService.getVirtualClassStudentList(virtualLabId,
			classId, questionSeqNo, search_parameter, groupId);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser updateVirtualLabUser(
		long virtualLabUserId, java.lang.String requestSort)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.updateVirtualLabUser(virtualLabUserId,
			requestSort);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser updateVirtualLabUserProcessNote(
		java.util.Map params)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserLocalService.updateVirtualLabUserProcessNote(params);
	}

	@Override
	public void removeVirtualLabUser(long classId, long virtualUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserLocalService.removeVirtualLabUser(classId, virtualUserId);
	}

	@Override
	public java.lang.Object[] getCountVirtualClassRegisterUserList(long classId) {
		return _virtualLabUserLocalService.getCountVirtualClassRegisterUserList(classId);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser getVirtualLabUserInfo(
		long classId, long userId) {
		return _virtualLabUserLocalService.getVirtualLabUserInfo(classId, userId);
	}

	@Override
	public int getStudentCount(long virtualLabId, long classId) {
		return _virtualLabUserLocalService.getStudentCount(virtualLabId, classId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getUserGroupClassUser(
		long userId, long groupId) {
		return _virtualLabUserLocalService.getUserGroupClassUser(userId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VirtualLabUserLocalService getWrappedVirtualLabUserLocalService() {
		return _virtualLabUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVirtualLabUserLocalService(
		VirtualLabUserLocalService virtualLabUserLocalService) {
		_virtualLabUserLocalService = virtualLabUserLocalService;
	}

	@Override
	public VirtualLabUserLocalService getWrappedService() {
		return _virtualLabUserLocalService;
	}

	@Override
	public void setWrappedService(
		VirtualLabUserLocalService virtualLabUserLocalService) {
		_virtualLabUserLocalService = virtualLabUserLocalService;
	}

	private VirtualLabUserLocalService _virtualLabUserLocalService;
}