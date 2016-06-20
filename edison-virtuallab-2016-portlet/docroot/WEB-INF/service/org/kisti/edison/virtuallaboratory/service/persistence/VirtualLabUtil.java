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

import org.kisti.edison.virtuallaboratory.model.VirtualLab;

import java.util.List;

/**
 * The persistence utility for the virtual lab service. This utility wraps {@link VirtualLabPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabPersistence
 * @see VirtualLabPersistenceImpl
 * @generated
 */
public class VirtualLabUtil {
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
	public static void clearCache(VirtualLab virtualLab) {
		getPersistence().clearCache(virtualLab);
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
	public static List<VirtualLab> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VirtualLab> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VirtualLab> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VirtualLab update(VirtualLab virtualLab)
		throws SystemException {
		return getPersistence().update(virtualLab);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VirtualLab update(VirtualLab virtualLab,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(virtualLab, serviceContext);
	}

	/**
	* Caches the virtual lab in the entity cache if it is enabled.
	*
	* @param virtualLab the virtual lab
	*/
	public static void cacheResult(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab) {
		getPersistence().cacheResult(virtualLab);
	}

	/**
	* Caches the virtual labs in the entity cache if it is enabled.
	*
	* @param virtualLabs the virtual labs
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs) {
		getPersistence().cacheResult(virtualLabs);
	}

	/**
	* Creates a new virtual lab with the primary key. Does not add the virtual lab to the database.
	*
	* @param virtualLabId the primary key for the new virtual lab
	* @return the new virtual lab
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab create(
		long virtualLabId) {
		return getPersistence().create(virtualLabId);
	}

	/**
	* Removes the virtual lab with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabId the primary key of the virtual lab
	* @return the virtual lab that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException if a virtual lab with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab remove(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return getPersistence().remove(virtualLabId);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLab updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(virtualLab);
	}

	/**
	* Returns the virtual lab with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException} if it could not be found.
	*
	* @param virtualLabId the primary key of the virtual lab
	* @return the virtual lab
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException if a virtual lab with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab findByPrimaryKey(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException {
		return getPersistence().findByPrimaryKey(virtualLabId);
	}

	/**
	* Returns the virtual lab with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param virtualLabId the primary key of the virtual lab
	* @return the virtual lab, or <code>null</code> if a virtual lab with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLab fetchByPrimaryKey(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(virtualLabId);
	}

	/**
	* Returns all the virtual labs.
	*
	* @return the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the virtual labs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual labs
	* @param end the upper bound of the range of virtual labs (not inclusive)
	* @return the range of virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the virtual labs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual labs
	* @param end the upper bound of the range of virtual labs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the virtual labs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of virtual labs.
	*
	* @return the number of virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the virtual lab classes associated with the virtual lab.
	*
	* @param pk the primary key of the virtual lab
	* @return the virtual lab classes associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClasses(pk);
	}

	/**
	* Returns a range of all the virtual lab classes associated with the virtual lab.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab
	* @param start the lower bound of the range of virtual labs
	* @param end the upper bound of the range of virtual labs (not inclusive)
	* @return the range of virtual lab classes associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClasses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab classes associated with the virtual lab.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab
	* @param start the lower bound of the range of virtual labs
	* @param end the upper bound of the range of virtual labs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab classes associated with the virtual lab
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
	* Returns the number of virtual lab classes associated with the virtual lab.
	*
	* @param pk the primary key of the virtual lab
	* @return the number of virtual lab classes associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClassesSize(pk);
	}

	/**
	* Returns <code>true</code> if the virtual lab class is associated with the virtual lab.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @return <code>true</code> if the virtual lab class is associated with the virtual lab; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVirtualLabClass(long pk,
		long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Returns <code>true</code> if the virtual lab has any virtual lab classes associated with it.
	*
	* @param pk the primary key of the virtual lab to check for associations with virtual lab classes
	* @return <code>true</code> if the virtual lab has any virtual lab classes associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVirtualLabClasses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVirtualLabClasses(pk);
	}

	/**
	* Adds an association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClass(long pk, long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Adds an association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClass the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClass(pk, virtualLabClass);
	}

	/**
	* Adds an association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClassPKs the primary keys of the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Adds an association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClasses the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClasses(pk, virtualLabClasses);
	}

	/**
	* Clears all associations between the virtual lab and its virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab to clear the associated virtual lab classes from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabClasses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearVirtualLabClasses(pk);
	}

	/**
	* Removes the association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClass(long pk, long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Removes the association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClass the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClass(pk, virtualLabClass);
	}

	/**
	* Removes the association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClassPKs the primary keys of the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClasses(long pk,
		long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Removes the association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClasses the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClasses(pk, virtualLabClasses);
	}

	/**
	* Sets the virtual lab classes associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClassPKs the primary keys of the virtual lab classes to be associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Sets the virtual lab classes associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param virtualLabClasses the virtual lab classes to be associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setVirtualLabClasses(pk, virtualLabClasses);
	}

	/**
	* Returns all the surveies associated with the virtual lab.
	*
	* @param pk the primary key of the virtual lab
	* @return the surveies associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveies(pk);
	}

	/**
	* Returns a range of all the surveies associated with the virtual lab.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab
	* @param start the lower bound of the range of virtual labs
	* @param end the upper bound of the range of virtual labs (not inclusive)
	* @return the range of surveies associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveies(pk, start, end);
	}

	/**
	* Returns an ordered range of all the surveies associated with the virtual lab.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab
	* @param start the lower bound of the range of virtual labs
	* @param end the upper bound of the range of virtual labs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of surveies associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveies(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of surveies associated with the virtual lab.
	*
	* @param pk the primary key of the virtual lab
	* @return the number of surveies associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveiesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveiesSize(pk);
	}

	/**
	* Returns <code>true</code> if the survey is associated with the virtual lab.
	*
	* @param pk the primary key of the virtual lab
	* @param surveyPK the primary key of the survey
	* @return <code>true</code> if the survey is associated with the virtual lab; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurvey(pk, surveyPK);
	}

	/**
	* Returns <code>true</code> if the virtual lab has any surveies associated with it.
	*
	* @param pk the primary key of the virtual lab to check for associations with surveies
	* @return <code>true</code> if the virtual lab has any surveies associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurveies(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurveies(pk);
	}

	/**
	* Adds an association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveyPK the primary key of the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurvey(pk, surveyPK);
	}

	/**
	* Adds an association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param survey the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurvey(pk, survey);
	}

	/**
	* Adds an association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveyPKs the primary keys of the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveies(pk, surveyPKs);
	}

	/**
	* Adds an association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveies the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveies(pk, surveies);
	}

	/**
	* Clears all associations between the virtual lab and its surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab to clear the associated surveies from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveies(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearSurveies(pk);
	}

	/**
	* Removes the association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveyPK the primary key of the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurvey(pk, surveyPK);
	}

	/**
	* Removes the association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param survey the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurvey(pk, survey);
	}

	/**
	* Removes the association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveyPKs the primary keys of the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveies(pk, surveyPKs);
	}

	/**
	* Removes the association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveies the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveies(pk, surveies);
	}

	/**
	* Sets the surveies associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveyPKs the primary keys of the surveies to be associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveies(pk, surveyPKs);
	}

	/**
	* Sets the surveies associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab
	* @param surveies the surveies to be associated with the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveies(pk, surveies);
	}

	public static VirtualLabPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VirtualLabPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabPersistence.class.getName());

			ReferenceRegistry.registerReference(VirtualLabUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VirtualLabPersistence persistence) {
	}

	private static VirtualLabPersistence _persistence;
}