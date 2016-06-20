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

package org.kisti.edison.virtuallaboratory.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;

import java.util.List;

/**
 * The persistence utility for the virtual lab user service. This utility wraps {@link VirtualLabUserPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserPersistence
 * @see VirtualLabUserPersistenceImpl
 * @generated
 */
public class VirtualLabUserUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(VirtualLabUser virtualLabUser) {
		getPersistence().clearCache(virtualLabUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VirtualLabUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VirtualLabUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VirtualLabUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VirtualLabUser update(VirtualLabUser virtualLabUser)
		throws SystemException {
		return getPersistence().update(virtualLabUser);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VirtualLabUser update(VirtualLabUser virtualLabUser,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(virtualLabUser, serviceContext);
	}

	/**
	* Caches the virtual lab user in the entity cache if it is enabled.
	*
	* @param virtualLabUser the virtual lab user
	*/
	public static void cacheResult(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser) {
		getPersistence().cacheResult(virtualLabUser);
	}

	/**
	* Caches the virtual lab users in the entity cache if it is enabled.
	*
	* @param virtualLabUsers the virtual lab users
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabUsers) {
		getPersistence().cacheResult(virtualLabUsers);
	}

	/**
	* Creates a new virtual lab user with the primary key. Does not add the virtual lab user to the database.
	*
	* @param virtualLabUserId the primary key for the new virtual lab user
	* @return the new virtual lab user
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUser create(
		long virtualLabUserId) {
		return getPersistence().create(virtualLabUserId);
	}

	/**
	* Removes the virtual lab user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserId the primary key of the virtual lab user
	* @return the virtual lab user that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException if a virtual lab user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUser remove(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException {
		return getPersistence().remove(virtualLabUserId);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUser updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(virtualLabUser);
	}

	/**
	* Returns the virtual lab user with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException} if it could not be found.
	*
	* @param virtualLabUserId the primary key of the virtual lab user
	* @return the virtual lab user
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException if a virtual lab user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUser findByPrimaryKey(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException {
		return getPersistence().findByPrimaryKey(virtualLabUserId);
	}

	/**
	* Returns the virtual lab user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param virtualLabUserId the primary key of the virtual lab user
	* @return the virtual lab user, or <code>null</code> if a virtual lab user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUser fetchByPrimaryKey(
		long virtualLabUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(virtualLabUserId);
	}

	/**
	* Returns all the virtual lab users.
	*
	* @return the virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab users
	* @param end the upper bound of the range of virtual lab users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the virtual lab users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of virtual lab users.
	*
	* @return the number of virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the virtual lab classes associated with the virtual lab user.
	*
	* @param pk the primary key of the virtual lab user
	* @return the virtual lab classes associated with the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClasses(pk);
	}

	/**
	* Returns a range of all the virtual lab classes associated with the virtual lab user.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab user
	* @param start the lower bound of the range of virtual lab users
	* @param end the upper bound of the range of virtual lab users (not inclusive)
	* @return the range of virtual lab classes associated with the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClasses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab classes associated with the virtual lab user.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab user
	* @param start the lower bound of the range of virtual lab users
	* @param end the upper bound of the range of virtual lab users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab classes associated with the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getVirtualLabClasses(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of virtual lab classes associated with the virtual lab user.
	*
	* @param pk the primary key of the virtual lab user
	* @return the number of virtual lab classes associated with the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClassesSize(pk);
	}

	/**
	* Returns <code>true</code> if the virtual lab class is associated with the virtual lab user.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @return <code>true</code> if the virtual lab class is associated with the virtual lab user; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVirtualLabClass(long pk,
		long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Returns <code>true</code> if the virtual lab user has any virtual lab classes associated with it.
	*
	* @param pk the primary key of the virtual lab user to check for associations with virtual lab classes
	* @return <code>true</code> if the virtual lab user has any virtual lab classes associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVirtualLabClasses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVirtualLabClasses(pk);
	}

	/**
	* Adds an association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClass(long pk, long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Adds an association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClass the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClass(pk, virtualLabClass);
	}

	/**
	* Adds an association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClassPKs the primary keys of the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Adds an association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClasses the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClasses(pk, virtualLabClasses);
	}

	/**
	* Clears all associations between the virtual lab user and its virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user to clear the associated virtual lab classes from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabClasses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearVirtualLabClasses(pk);
	}

	/**
	* Removes the association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClass(long pk, long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Removes the association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClass the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClass(pk, virtualLabClass);
	}

	/**
	* Removes the association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClassPKs the primary keys of the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClasses(long pk,
		long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Removes the association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClasses the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClasses(pk, virtualLabClasses);
	}

	/**
	* Sets the virtual lab classes associated with the virtual lab user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClassPKs the primary keys of the virtual lab classes to be associated with the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Sets the virtual lab classes associated with the virtual lab user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab user
	* @param virtualLabClasses the virtual lab classes to be associated with the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setVirtualLabClasses(pk, virtualLabClasses);
	}

	public static VirtualLabUserPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VirtualLabUserPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabUserPersistence.class.getName());

			ReferenceRegistry.registerReference(VirtualLabUserUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VirtualLabUserPersistence persistence) {
	}

	private static VirtualLabUserPersistence _persistence;
}