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

import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp;

import java.util.List;

/**
 * The persistence utility for the virtual lab user temp service. This utility wraps {@link VirtualLabUserTempPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserTempPersistence
 * @see VirtualLabUserTempPersistenceImpl
 * @generated
 */
public class VirtualLabUserTempUtil {
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
	public static void clearCache(VirtualLabUserTemp virtualLabUserTemp) {
		getPersistence().clearCache(virtualLabUserTemp);
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
	public static List<VirtualLabUserTemp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VirtualLabUserTemp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VirtualLabUserTemp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VirtualLabUserTemp update(
		VirtualLabUserTemp virtualLabUserTemp) throws SystemException {
		return getPersistence().update(virtualLabUserTemp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VirtualLabUserTemp update(
		VirtualLabUserTemp virtualLabUserTemp, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(virtualLabUserTemp, serviceContext);
	}

	/**
	* Returns all the virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @return the matching virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findBygetListTempUser(
		long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBygetListTempUser(virtualLabId, classId);
	}

	/**
	* Returns a range of all the virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param start the lower bound of the range of virtual lab user temps
	* @param end the upper bound of the range of virtual lab user temps (not inclusive)
	* @return the range of matching virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findBygetListTempUser(
		long virtualLabId, long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygetListTempUser(virtualLabId, classId, start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param start the lower bound of the range of virtual lab user temps
	* @param end the upper bound of the range of virtual lab user temps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findBygetListTempUser(
		long virtualLabId, long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBygetListTempUser(virtualLabId, classId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching virtual lab user temp
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a matching virtual lab user temp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp findBygetListTempUser_First(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException {
		return getPersistence()
				   .findBygetListTempUser_First(virtualLabId, classId,
			orderByComparator);
	}

	/**
	* Returns the first virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching virtual lab user temp, or <code>null</code> if a matching virtual lab user temp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp fetchBygetListTempUser_First(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBygetListTempUser_First(virtualLabId, classId,
			orderByComparator);
	}

	/**
	* Returns the last virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching virtual lab user temp
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a matching virtual lab user temp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp findBygetListTempUser_Last(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException {
		return getPersistence()
				   .findBygetListTempUser_Last(virtualLabId, classId,
			orderByComparator);
	}

	/**
	* Returns the last virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching virtual lab user temp, or <code>null</code> if a matching virtual lab user temp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp fetchBygetListTempUser_Last(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBygetListTempUser_Last(virtualLabId, classId,
			orderByComparator);
	}

	/**
	* Returns the virtual lab user temps before and after the current virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabUserTempPK the primary key of the current virtual lab user temp
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next virtual lab user temp
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp[] findBygetListTempUser_PrevAndNext(
		VirtualLabUserTempPK virtualLabUserTempPK, long virtualLabId,
		long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException {
		return getPersistence()
				   .findBygetListTempUser_PrevAndNext(virtualLabUserTempPK,
			virtualLabId, classId, orderByComparator);
	}

	/**
	* Removes all the virtual lab user temps where virtualLabId = &#63; and classId = &#63; from the database.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBygetListTempUser(long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBygetListTempUser(virtualLabId, classId);
	}

	/**
	* Returns the number of virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @return the number of matching virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static int countBygetListTempUser(long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBygetListTempUser(virtualLabId, classId);
	}

	/**
	* Caches the virtual lab user temp in the entity cache if it is enabled.
	*
	* @param virtualLabUserTemp the virtual lab user temp
	*/
	public static void cacheResult(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp) {
		getPersistence().cacheResult(virtualLabUserTemp);
	}

	/**
	* Caches the virtual lab user temps in the entity cache if it is enabled.
	*
	* @param virtualLabUserTemps the virtual lab user temps
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> virtualLabUserTemps) {
		getPersistence().cacheResult(virtualLabUserTemps);
	}

	/**
	* Creates a new virtual lab user temp with the primary key. Does not add the virtual lab user temp to the database.
	*
	* @param virtualLabUserTempPK the primary key for the new virtual lab user temp
	* @return the new virtual lab user temp
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp create(
		VirtualLabUserTempPK virtualLabUserTempPK) {
		return getPersistence().create(virtualLabUserTempPK);
	}

	/**
	* Removes the virtual lab user temp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp remove(
		VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException {
		return getPersistence().remove(virtualLabUserTempPK);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(virtualLabUserTemp);
	}

	/**
	* Returns the virtual lab user temp with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException} if it could not be found.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp findByPrimaryKey(
		VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException {
		return getPersistence().findByPrimaryKey(virtualLabUserTempPK);
	}

	/**
	* Returns the virtual lab user temp with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp, or <code>null</code> if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp fetchByPrimaryKey(
		VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(virtualLabUserTempPK);
	}

	/**
	* Returns all the virtual lab user temps.
	*
	* @return the virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the virtual lab user temps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab user temps
	* @param end the upper bound of the range of virtual lab user temps (not inclusive)
	* @return the range of virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab user temps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab user temps
	* @param end the upper bound of the range of virtual lab user temps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the virtual lab user temps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of virtual lab user temps.
	*
	* @return the number of virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VirtualLabUserTempPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VirtualLabUserTempPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabUserTempPersistence.class.getName());

			ReferenceRegistry.registerReference(VirtualLabUserTempUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VirtualLabUserTempPersistence persistence) {
	}

	private static VirtualLabUserTempPersistence _persistence;
}