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

package org.kisti.edison.customauthmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserGroupRoleCustomLocalService}.
 *
 * @author EDISON
 * @see UserGroupRoleCustomLocalService
 * @generated
 */
public class UserGroupRoleCustomLocalServiceWrapper
	implements UserGroupRoleCustomLocalService,
		ServiceWrapper<UserGroupRoleCustomLocalService> {
	public UserGroupRoleCustomLocalServiceWrapper(
		UserGroupRoleCustomLocalService userGroupRoleCustomLocalService) {
		_userGroupRoleCustomLocalService = userGroupRoleCustomLocalService;
	}

	/**
	* Adds the user group role custom to the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustom the user group role custom
	* @return the user group role custom that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom addUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.addUserGroupRoleCustom(userGroupRoleCustom);
	}

	/**
	* Creates a new user group role custom with the primary key. Does not add the user group role custom to the database.
	*
	* @param userGroupRoleCustomPK the primary key for the new user group role custom
	* @return the new user group role custom
	*/
	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom createUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK) {
		return _userGroupRoleCustomLocalService.createUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	/**
	* Deletes the user group role custom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom that was removed
	* @throws PortalException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom deleteUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.deleteUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	/**
	* Deletes the user group role custom from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustom the user group role custom
	* @return the user group role custom that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom deleteUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.deleteUserGroupRoleCustom(userGroupRoleCustom);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userGroupRoleCustomLocalService.dynamicQuery();
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
		return _userGroupRoleCustomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userGroupRoleCustomLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userGroupRoleCustomLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _userGroupRoleCustomLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userGroupRoleCustomLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.fetchUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	/**
	* Returns the user group role custom with the primary key.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom
	* @throws PortalException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom getUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user group role customs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @return the range of user group role customs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> getUserGroupRoleCustoms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getUserGroupRoleCustoms(start,
			end);
	}

	/**
	* Returns the number of user group role customs.
	*
	* @return the number of user group role customs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserGroupRoleCustomsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getUserGroupRoleCustomsCount();
	}

	/**
	* Updates the user group role custom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustom the user group role custom
	* @return the user group role custom that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom updateUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.updateUserGroupRoleCustom(userGroupRoleCustom);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userGroupRoleCustomLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userGroupRoleCustomLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userGroupRoleCustomLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public boolean isRoleCustom(long userId, long groupId, long roleId,
		long customId) {
		return _userGroupRoleCustomLocalService.isRoleCustom(userId, groupId,
			roleId, customId);
	}

	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom getUserGroupRoleCustom(
		long userId, long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getUserGroupRoleCustom(userId,
			groupId, roleId, customId);
	}

	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom addUserGroupRoleCustom(
		long userId, long groupId, long roleId, long customId) {
		return _userGroupRoleCustomLocalService.addUserGroupRoleCustom(userId,
			groupId, roleId, customId);
	}

	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom removeUserGroupRoleCustom(
		long userId, long groupId, long roleId, long customId) {
		return _userGroupRoleCustomLocalService.removeUserGroupRoleCustom(userId,
			groupId, roleId, customId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.String>> getUserCustomList(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getUserCustomList(groupId,
			roleId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.String>> getCustomList(
		long userId, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getCustomList(userId, groupId,
			roleId);
	}

	@Override
	public java.util.List<java.lang.Long> getCustomIdList(long userId,
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getCustomIdList(userId,
			groupId, roleId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.String>> getUserList(
		long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getUserList(groupId, roleId,
			customId);
	}

	@Override
	public java.util.List<java.lang.Long> getUserIdList(long groupId,
		long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getUserIdList(groupId, roleId,
			customId);
	}

	@Override
	public java.lang.String checkRoleVirtualLabClass(long companyId,
		long groupId, long userId, long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.checkRoleVirtualLabClass(companyId,
			groupId, userId, virtualLabId, classId);
	}

	@Override
	public boolean isAdminRoleSolver(long companyId, long groupId, long userId,
		long solverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.isAdminRoleSolver(companyId,
			groupId, userId, solverId);
	}

	@Override
	public boolean isAdminRoleVirtualLabClass(long companyId, long groupId,
		long userId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.isAdminRoleVirtualLabClass(companyId,
			groupId, userId, classId);
	}

	@Override
	public java.lang.Integer getSiteLeaveOwnerTotalCnt(long userId,
		long labRoleId, long groupId, long classRoleId) {
		return _userGroupRoleCustomLocalService.getSiteLeaveOwnerTotalCnt(userId,
			labRoleId, groupId, classRoleId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.String>> getContentOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getContentOwnerList(userId,
			roleId, groupId, languageId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.String>> getVirtualLabOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getVirtualLabOwnerList(userId,
			roleId, groupId, languageId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.String>> getVirtaulClassOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustomLocalService.getVirtaulClassOwnerList(userId,
			roleId, groupId, languageId);
	}

	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom deleteUserGroupRoleCustomManager(
		long userId, long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return _userGroupRoleCustomLocalService.deleteUserGroupRoleCustomManager(userId,
			groupId, roleId, customId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserGroupRoleCustomLocalService getWrappedUserGroupRoleCustomLocalService() {
		return _userGroupRoleCustomLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserGroupRoleCustomLocalService(
		UserGroupRoleCustomLocalService userGroupRoleCustomLocalService) {
		_userGroupRoleCustomLocalService = userGroupRoleCustomLocalService;
	}

	@Override
	public UserGroupRoleCustomLocalService getWrappedService() {
		return _userGroupRoleCustomLocalService;
	}

	@Override
	public void setWrappedService(
		UserGroupRoleCustomLocalService userGroupRoleCustomLocalService) {
		_userGroupRoleCustomLocalService = userGroupRoleCustomLocalService;
	}

	private UserGroupRoleCustomLocalService _userGroupRoleCustomLocalService;
}