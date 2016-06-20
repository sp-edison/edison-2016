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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp;

/**
 * The persistence interface for the virtual lab user temp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserTempPersistenceImpl
 * @see VirtualLabUserTempUtil
 * @generated
 */
public interface VirtualLabUserTempPersistence extends BasePersistence<VirtualLabUserTemp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VirtualLabUserTempUtil} to access the virtual lab user temp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @return the matching virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findBygetListTempUser(
		long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findBygetListTempUser(
		long virtualLabId, long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findBygetListTempUser(
		long virtualLabId, long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp findBygetListTempUser_First(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException;

	/**
	* Returns the first virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching virtual lab user temp, or <code>null</code> if a matching virtual lab user temp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp fetchBygetListTempUser_First(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp findBygetListTempUser_Last(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException;

	/**
	* Returns the last virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching virtual lab user temp, or <code>null</code> if a matching virtual lab user temp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp fetchBygetListTempUser_Last(
		long virtualLabId, long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp[] findBygetListTempUser_PrevAndNext(
		VirtualLabUserTempPK virtualLabUserTempPK, long virtualLabId,
		long classId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException;

	/**
	* Removes all the virtual lab user temps where virtualLabId = &#63; and classId = &#63; from the database.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygetListTempUser(long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	*
	* @param virtualLabId the virtual lab ID
	* @param classId the class ID
	* @return the number of matching virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public int countBygetListTempUser(long virtualLabId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the virtual lab user temp in the entity cache if it is enabled.
	*
	* @param virtualLabUserTemp the virtual lab user temp
	*/
	public void cacheResult(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp);

	/**
	* Caches the virtual lab user temps in the entity cache if it is enabled.
	*
	* @param virtualLabUserTemps the virtual lab user temps
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> virtualLabUserTemps);

	/**
	* Creates a new virtual lab user temp with the primary key. Does not add the virtual lab user temp to the database.
	*
	* @param virtualLabUserTempPK the primary key for the new virtual lab user temp
	* @return the new virtual lab user temp
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp create(
		VirtualLabUserTempPK virtualLabUserTempPK);

	/**
	* Removes the virtual lab user temp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp remove(
		VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException;

	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the virtual lab user temp with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException} if it could not be found.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp findByPrimaryKey(
		VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException;

	/**
	* Returns the virtual lab user temp with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp, or <code>null</code> if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp fetchByPrimaryKey(
		VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the virtual lab user temps.
	*
	* @return the virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the virtual lab user temps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual lab user temps.
	*
	* @return the number of virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}