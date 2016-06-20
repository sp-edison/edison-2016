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
 * Provides the local service interface for VirtualLabUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author EDISON
 * @see VirtualLabUserLocalServiceUtil
 * @see org.kisti.edison.virtuallaboratory.service.base.VirtualLabUserLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.impl.VirtualLabUserLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VirtualLabUserLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VirtualLabUserLocalServiceUtil} to access the virtual lab user local service. Add custom service methods to {@link org.kisti.edison.virtuallaboratory.service.impl.VirtualLabUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the virtual lab user to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUser the virtual lab user
	* @return the virtual lab user that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser addVirtualLabUser(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new virtual lab user with the primary key. Does not add the virtual lab user to the database.
	*
	* @param virtualLabUserId the primary key for the new virtual lab user
	* @return the new virtual lab user
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser createVirtualLabUser(
		long virtualLabUserId);

	/**
	* Deletes the virtual lab user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserId the primary key of the virtual lab user
	* @return the virtual lab user that was removed
	* @throws PortalException if a virtual lab user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser deleteVirtualLabUser(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the virtual lab user from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUser the virtual lab user
	* @return the virtual lab user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser deleteVirtualLabUser(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser fetchVirtualLabUser(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the virtual lab user with the primary key.
	*
	* @param virtualLabUserId the primary key of the virtual lab user
	* @return the virtual lab user
	* @throws PortalException if a virtual lab user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser getVirtualLabUser(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual lab users.
	*
	* @return the number of virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVirtualLabUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the virtual lab user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUser the virtual lab user
	* @return the virtual lab user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser updateVirtualLabUser(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassVirtualLabUser(long classId,
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassVirtualLabUser(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassVirtualLabUsers(long classId,
		long[] virtualLabUserIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassVirtualLabUsers(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> VirtualLabUsers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void clearVirtualLabClassVirtualLabUsers(long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVirtualLabClassVirtualLabUser(long classId,
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVirtualLabClassVirtualLabUser(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVirtualLabClassVirtualLabUsers(long classId,
		long[] virtualLabUserIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVirtualLabClassVirtualLabUsers(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> VirtualLabUsers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabClassVirtualLabUsers(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabClassVirtualLabUsers(
		long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabClassVirtualLabUsers(
		long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVirtualLabClassVirtualLabUsersCount(long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasVirtualLabClassVirtualLabUser(long classId,
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasVirtualLabClassVirtualLabUsers(long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabClassVirtualLabUsers(long classId,
		long[] virtualLabUserIds)
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

	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser addVirtualLabUser(
		long classId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser addTempUser(
		long classId, long userId, java.lang.String studentNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualClassStudentList(
		long virtualLabId, long classId, long questionSeqNo,
		java.lang.String search_parameter, long groupId);

	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser updateVirtualLabUser(
		long virtualLabUserId, java.lang.String requestSort)
		throws com.liferay.portal.kernel.exception.SystemException;

	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser updateVirtualLabUserProcessNote(
		java.util.Map params)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void removeVirtualLabUser(long classId, long virtualUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.Object[] getCountVirtualClassRegisterUserList(long classId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser getVirtualLabUserInfo(
		long classId, long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStudentCount(long virtualLabId, long classId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getUserGroupClassUser(
		long userId, long groupId);
}