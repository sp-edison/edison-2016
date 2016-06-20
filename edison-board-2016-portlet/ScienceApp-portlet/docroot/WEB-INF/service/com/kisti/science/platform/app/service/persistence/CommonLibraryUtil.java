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

package com.kisti.science.platform.app.service.persistence;

import com.kisti.science.platform.app.model.CommonLibrary;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the common library service. This utility wraps {@link CommonLibraryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonLibraryPersistence
 * @see CommonLibraryPersistenceImpl
 * @generated
 */
public class CommonLibraryUtil {
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
	public static void clearCache(CommonLibrary commonLibrary) {
		getPersistence().clearCache(commonLibrary);
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
	public static List<CommonLibrary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommonLibrary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommonLibrary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CommonLibrary update(CommonLibrary commonLibrary)
		throws SystemException {
		return getPersistence().update(commonLibrary);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CommonLibrary update(CommonLibrary commonLibrary,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(commonLibrary, serviceContext);
	}

	/**
	* Returns all the common libraries where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @return the matching common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.CommonLibrary> findByLibName(
		java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibName(libName);
	}

	/**
	* Returns a range of all the common libraries where libName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libName the lib name
	* @param start the lower bound of the range of common libraries
	* @param end the upper bound of the range of common libraries (not inclusive)
	* @return the range of matching common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.CommonLibrary> findByLibName(
		java.lang.String libName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibName(libName, start, end);
	}

	/**
	* Returns an ordered range of all the common libraries where libName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libName the lib name
	* @param start the lower bound of the range of common libraries
	* @param end the upper bound of the range of common libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.CommonLibrary> findByLibName(
		java.lang.String libName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibName(libName, start, end, orderByComparator);
	}

	/**
	* Returns the first common library in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching common library
	* @throws com.kisti.science.platform.app.NoSuchCommonLibraryException if a matching common library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary findByLibName_First(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCommonLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibName_First(libName, orderByComparator);
	}

	/**
	* Returns the first common library in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching common library, or <code>null</code> if a matching common library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary fetchByLibName_First(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLibName_First(libName, orderByComparator);
	}

	/**
	* Returns the last common library in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching common library
	* @throws com.kisti.science.platform.app.NoSuchCommonLibraryException if a matching common library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary findByLibName_Last(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCommonLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibName_Last(libName, orderByComparator);
	}

	/**
	* Returns the last common library in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching common library, or <code>null</code> if a matching common library could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary fetchByLibName_Last(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLibName_Last(libName, orderByComparator);
	}

	/**
	* Returns the common libraries before and after the current common library in the ordered set where libName LIKE &#63;.
	*
	* @param commonLibraryPK the primary key of the current common library
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next common library
	* @throws com.kisti.science.platform.app.NoSuchCommonLibraryException if a common library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary[] findByLibName_PrevAndNext(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK,
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCommonLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibName_PrevAndNext(commonLibraryPK, libName,
			orderByComparator);
	}

	/**
	* Removes all the common libraries where libName LIKE &#63; from the database.
	*
	* @param libName the lib name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLibName(java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLibName(libName);
	}

	/**
	* Returns the number of common libraries where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @return the number of matching common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibName(java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibName(libName);
	}

	/**
	* Caches the common library in the entity cache if it is enabled.
	*
	* @param commonLibrary the common library
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.CommonLibrary commonLibrary) {
		getPersistence().cacheResult(commonLibrary);
	}

	/**
	* Caches the common libraries in the entity cache if it is enabled.
	*
	* @param commonLibraries the common libraries
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.CommonLibrary> commonLibraries) {
		getPersistence().cacheResult(commonLibraries);
	}

	/**
	* Creates a new common library with the primary key. Does not add the common library to the database.
	*
	* @param commonLibraryPK the primary key for the new common library
	* @return the new common library
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary create(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK) {
		return getPersistence().create(commonLibraryPK);
	}

	/**
	* Removes the common library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonLibraryPK the primary key of the common library
	* @return the common library that was removed
	* @throws com.kisti.science.platform.app.NoSuchCommonLibraryException if a common library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary remove(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK)
		throws com.kisti.science.platform.app.NoSuchCommonLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(commonLibraryPK);
	}

	public static com.kisti.science.platform.app.model.CommonLibrary updateImpl(
		com.kisti.science.platform.app.model.CommonLibrary commonLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(commonLibrary);
	}

	/**
	* Returns the common library with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchCommonLibraryException} if it could not be found.
	*
	* @param commonLibraryPK the primary key of the common library
	* @return the common library
	* @throws com.kisti.science.platform.app.NoSuchCommonLibraryException if a common library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary findByPrimaryKey(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK)
		throws com.kisti.science.platform.app.NoSuchCommonLibraryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(commonLibraryPK);
	}

	/**
	* Returns the common library with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commonLibraryPK the primary key of the common library
	* @return the common library, or <code>null</code> if a common library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.CommonLibrary fetchByPrimaryKey(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(commonLibraryPK);
	}

	/**
	* Returns all the common libraries.
	*
	* @return the common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.CommonLibrary> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the common libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libraries
	* @param end the upper bound of the range of common libraries (not inclusive)
	* @return the range of common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.CommonLibrary> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the common libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libraries
	* @param end the upper bound of the range of common libraries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.CommonLibrary> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the common libraries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of common libraries.
	*
	* @return the number of common libraries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CommonLibraryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CommonLibraryPersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					CommonLibraryPersistence.class.getName());

			ReferenceRegistry.registerReference(CommonLibraryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CommonLibraryPersistence persistence) {
	}

	private static CommonLibraryPersistence _persistence;
}