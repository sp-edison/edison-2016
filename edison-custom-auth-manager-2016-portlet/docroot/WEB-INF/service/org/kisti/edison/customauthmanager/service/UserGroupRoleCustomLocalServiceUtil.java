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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserGroupRoleCustom. This utility wraps
 * {@link org.kisti.edison.customauthmanager.service.impl.UserGroupRoleCustomLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see UserGroupRoleCustomLocalService
 * @see org.kisti.edison.customauthmanager.service.base.UserGroupRoleCustomLocalServiceBaseImpl
 * @see org.kisti.edison.customauthmanager.service.impl.UserGroupRoleCustomLocalServiceImpl
 * @generated
 */
public class UserGroupRoleCustomLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.customauthmanager.service.impl.UserGroupRoleCustomLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user group role custom to the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustom the user group role custom
	* @return the user group role custom that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom addUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserGroupRoleCustom(userGroupRoleCustom);
	}

	/**
	* Creates a new user group role custom with the primary key. Does not add the user group role custom to the database.
	*
	* @param userGroupRoleCustomPK the primary key for the new user group role custom
	* @return the new user group role custom
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom createUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK) {
		return getService().createUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	/**
	* Deletes the user group role custom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom that was removed
	* @throws PortalException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom deleteUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	/**
	* Deletes the user group role custom from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustom the user group role custom
	* @return the user group role custom that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom deleteUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteUserGroupRoleCustom(userGroupRoleCustom);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	/**
	* Returns the user group role custom with the primary key.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom
	* @throws PortalException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom getUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRoleCustom(userGroupRoleCustomPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> getUserGroupRoleCustoms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRoleCustoms(start, end);
	}

	/**
	* Returns the number of user group role customs.
	*
	* @return the number of user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserGroupRoleCustomsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupRoleCustomsCount();
	}

	/**
	* Updates the user group role custom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustom the user group role custom
	* @return the user group role custom that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom updateUserGroupRoleCustom(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserGroupRoleCustom(userGroupRoleCustom);
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

	public static boolean isRoleCustom(long userId, long groupId, long roleId,
		long customId) {
		return getService().isRoleCustom(userId, groupId, roleId, customId);
	}

	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom getUserGroupRoleCustom(
		long userId, long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUserGroupRoleCustom(userId, groupId, roleId, customId);
	}

	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom addUserGroupRoleCustom(
		long userId, long groupId, long roleId, long customId) {
		return getService()
				   .addUserGroupRoleCustom(userId, groupId, roleId, customId);
	}

	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom removeUserGroupRoleCustom(
		long userId, long groupId, long roleId, long customId) {
		return getService()
				   .removeUserGroupRoleCustom(userId, groupId, roleId, customId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.String>> getUserCustomList(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserCustomList(groupId, roleId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.String>> getCustomList(
		long userId, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCustomList(userId, groupId, roleId);
	}

	public static java.util.List<java.lang.Long> getCustomIdList(long userId,
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCustomIdList(userId, groupId, roleId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.String>> getUserList(
		long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserList(groupId, roleId, customId);
	}

	public static java.util.List<java.lang.Long> getUserIdList(long groupId,
		long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserIdList(groupId, roleId, customId);
	}

	public static java.lang.String checkRoleVirtualLabClass(long companyId,
		long groupId, long userId, long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .checkRoleVirtualLabClass(companyId, groupId, userId,
			virtualLabId, classId);
	}

	public static boolean isAdminRoleSolver(long companyId, long groupId,
		long userId, long solverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .isAdminRoleSolver(companyId, groupId, userId, solverId);
	}

	public static boolean isAdminRoleVirtualLabClass(long companyId,
		long groupId, long userId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .isAdminRoleVirtualLabClass(companyId, groupId, userId,
			classId);
	}

	public static java.lang.Integer getSiteLeaveOwnerTotalCnt(long userId,
		long labRoleId, long groupId, long classRoleId) {
		return getService()
				   .getSiteLeaveOwnerTotalCnt(userId, labRoleId, groupId,
			classRoleId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.String>> getContentOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getContentOwnerList(userId, roleId, groupId, languageId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.String>> getVirtualLabOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabOwnerList(userId, roleId, groupId, languageId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.String>> getVirtaulClassOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtaulClassOwnerList(userId, roleId, groupId, languageId);
	}

	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom deleteUserGroupRoleCustomManager(
		long userId, long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getService()
				   .deleteUserGroupRoleCustomManager(userId, groupId, roleId,
			customId);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserGroupRoleCustomLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserGroupRoleCustomLocalService.class.getName());

			if (invokableLocalService instanceof UserGroupRoleCustomLocalService) {
				_service = (UserGroupRoleCustomLocalService)invokableLocalService;
			}
			else {
				_service = new UserGroupRoleCustomLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserGroupRoleCustomLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserGroupRoleCustomLocalService service) {
	}

	private static UserGroupRoleCustomLocalService _service;
}