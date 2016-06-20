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

package org.kisti.edison.science.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.science.model.CommonLib;

import java.util.List;

/**
 * The persistence utility for the common lib service. This utility wraps {@link CommonLibPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see CommonLibPersistence
 * @see CommonLibPersistenceImpl
 * @generated
 */
public class CommonLibUtil {
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
	public static void clearCache(CommonLib commonLib) {
		getPersistence().clearCache(commonLib);
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
	public static List<CommonLib> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CommonLib> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CommonLib> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CommonLib update(CommonLib commonLib)
		throws SystemException {
		return getPersistence().update(commonLib);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CommonLib update(CommonLib commonLib,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(commonLib, serviceContext);
	}

	/**
	* Returns all the common libs where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @return the matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.CommonLib> findByLibName(
		java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibName(libName);
	}

	/**
	* Returns a range of all the common libs where libName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libName the lib name
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @return the range of matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.CommonLib> findByLibName(
		java.lang.String libName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLibName(libName, start, end);
	}

	/**
	* Returns an ordered range of all the common libs where libName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libName the lib name
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.CommonLib> findByLibName(
		java.lang.String libName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLibName(libName, start, end, orderByComparator);
	}

	/**
	* Returns the first common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib findByLibName_First(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException {
		return getPersistence().findByLibName_First(libName, orderByComparator);
	}

	/**
	* Returns the first common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching common lib, or <code>null</code> if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib fetchByLibName_First(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLibName_First(libName, orderByComparator);
	}

	/**
	* Returns the last common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib findByLibName_Last(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException {
		return getPersistence().findByLibName_Last(libName, orderByComparator);
	}

	/**
	* Returns the last common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching common lib, or <code>null</code> if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib fetchByLibName_Last(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLibName_Last(libName, orderByComparator);
	}

	/**
	* Returns the common libs before and after the current common lib in the ordered set where libName LIKE &#63;.
	*
	* @param commonLibPK the primary key of the current common lib
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib[] findByLibName_PrevAndNext(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK,
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException {
		return getPersistence()
				   .findByLibName_PrevAndNext(commonLibPK, libName,
			orderByComparator);
	}

	/**
	* Removes all the common libs where libName LIKE &#63; from the database.
	*
	* @param libName the lib name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLibName(java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLibName(libName);
	}

	/**
	* Returns the number of common libs where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @return the number of matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLibName(java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLibName(libName);
	}

	/**
	* Caches the common lib in the entity cache if it is enabled.
	*
	* @param commonLib the common lib
	*/
	public static void cacheResult(
		org.kisti.edison.science.model.CommonLib commonLib) {
		getPersistence().cacheResult(commonLib);
	}

	/**
	* Caches the common libs in the entity cache if it is enabled.
	*
	* @param commonLibs the common libs
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.science.model.CommonLib> commonLibs) {
		getPersistence().cacheResult(commonLibs);
	}

	/**
	* Creates a new common lib with the primary key. Does not add the common lib to the database.
	*
	* @param commonLibPK the primary key for the new common lib
	* @return the new common lib
	*/
	public static org.kisti.edison.science.model.CommonLib create(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK) {
		return getPersistence().create(commonLibPK);
	}

	/**
	* Removes the common lib with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib that was removed
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib remove(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException {
		return getPersistence().remove(commonLibPK);
	}

	public static org.kisti.edison.science.model.CommonLib updateImpl(
		org.kisti.edison.science.model.CommonLib commonLib)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(commonLib);
	}

	/**
	* Returns the common lib with the primary key or throws a {@link org.kisti.edison.science.NoSuchCommonLibException} if it could not be found.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib findByPrimaryKey(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException {
		return getPersistence().findByPrimaryKey(commonLibPK);
	}

	/**
	* Returns the common lib with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib, or <code>null</code> if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.CommonLib fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(commonLibPK);
	}

	/**
	* Returns all the common libs.
	*
	* @return the common libs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.CommonLib> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the common libs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @return the range of common libs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.CommonLib> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the common libs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of common libs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.CommonLib> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the common libs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of common libs.
	*
	* @return the number of common libs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CommonLibPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CommonLibPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					CommonLibPersistence.class.getName());

			ReferenceRegistry.registerReference(CommonLibUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CommonLibPersistence persistence) {
	}

	private static CommonLibPersistence _persistence;
}