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

import org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp;

import java.util.List;

/**
 * The persistence utility for the virtual lab class science app service. This utility wraps {@link VirtualLabClassScienceAppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClassScienceAppPersistence
 * @see VirtualLabClassScienceAppPersistenceImpl
 * @generated
 */
public class VirtualLabClassScienceAppUtil {
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
	public static void clearCache(
		VirtualLabClassScienceApp virtualLabClassScienceApp) {
		getPersistence().clearCache(virtualLabClassScienceApp);
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
	public static List<VirtualLabClassScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VirtualLabClassScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VirtualLabClassScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VirtualLabClassScienceApp update(
		VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws SystemException {
		return getPersistence().update(virtualLabClassScienceApp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VirtualLabClassScienceApp update(
		VirtualLabClassScienceApp virtualLabClassScienceApp,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(virtualLabClassScienceApp, serviceContext);
	}

	/**
	* Caches the virtual lab class science app in the entity cache if it is enabled.
	*
	* @param virtualLabClassScienceApp the virtual lab class science app
	*/
	public static void cacheResult(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp) {
		getPersistence().cacheResult(virtualLabClassScienceApp);
	}

	/**
	* Caches the virtual lab class science apps in the entity cache if it is enabled.
	*
	* @param virtualLabClassScienceApps the virtual lab class science apps
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassScienceApps) {
		getPersistence().cacheResult(virtualLabClassScienceApps);
	}

	/**
	* Creates a new virtual lab class science app with the primary key. Does not add the virtual lab class science app to the database.
	*
	* @param scienceAppSeqNo the primary key for the new virtual lab class science app
	* @return the new virtual lab class science app
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp create(
		long scienceAppSeqNo) {
		return getPersistence().create(scienceAppSeqNo);
	}

	/**
	* Removes the virtual lab class science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab class science app
	* @return the virtual lab class science app that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException if a virtual lab class science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp remove(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException {
		return getPersistence().remove(scienceAppSeqNo);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(virtualLabClassScienceApp);
	}

	/**
	* Returns the virtual lab class science app with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException} if it could not be found.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab class science app
	* @return the virtual lab class science app
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException if a virtual lab class science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp findByPrimaryKey(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException {
		return getPersistence().findByPrimaryKey(scienceAppSeqNo);
	}

	/**
	* Returns the virtual lab class science app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab class science app
	* @return the virtual lab class science app, or <code>null</code> if a virtual lab class science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp fetchByPrimaryKey(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scienceAppSeqNo);
	}

	/**
	* Returns all the virtual lab class science apps.
	*
	* @return the virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the virtual lab class science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab class science apps
	* @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	* @return the range of virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab class science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab class science apps
	* @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the virtual lab class science apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of virtual lab class science apps.
	*
	* @return the number of virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the virtual lab classes associated with the virtual lab class science app.
	*
	* @param pk the primary key of the virtual lab class science app
	* @return the virtual lab classes associated with the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClasses(pk);
	}

	/**
	* Returns a range of all the virtual lab classes associated with the virtual lab class science app.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class science app
	* @param start the lower bound of the range of virtual lab class science apps
	* @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	* @return the range of virtual lab classes associated with the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClasses(pk, start, end);
	}

	/**
	* Returns an ordered range of all the virtual lab classes associated with the virtual lab class science app.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class science app
	* @param start the lower bound of the range of virtual lab class science apps
	* @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab classes associated with the virtual lab class science app
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
	* Returns the number of virtual lab classes associated with the virtual lab class science app.
	*
	* @param pk the primary key of the virtual lab class science app
	* @return the number of virtual lab classes associated with the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getVirtualLabClassesSize(pk);
	}

	/**
	* Returns <code>true</code> if the virtual lab class is associated with the virtual lab class science app.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @return <code>true</code> if the virtual lab class is associated with the virtual lab class science app; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVirtualLabClass(long pk,
		long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Returns <code>true</code> if the virtual lab class science app has any virtual lab classes associated with it.
	*
	* @param pk the primary key of the virtual lab class science app to check for associations with virtual lab classes
	* @return <code>true</code> if the virtual lab class science app has any virtual lab classes associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsVirtualLabClasses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsVirtualLabClasses(pk);
	}

	/**
	* Adds an association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClass(long pk, long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Adds an association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClass the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClass(pk, virtualLabClass);
	}

	/**
	* Adds an association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClassPKs the primary keys of the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Adds an association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClasses the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addVirtualLabClasses(pk, virtualLabClasses);
	}

	/**
	* Clears all associations between the virtual lab class science app and its virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app to clear the associated virtual lab classes from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabClasses(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearVirtualLabClasses(pk);
	}

	/**
	* Removes the association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClassPK the primary key of the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClass(long pk, long virtualLabClassPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClass(pk, virtualLabClassPK);
	}

	/**
	* Removes the association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClass the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClass(pk, virtualLabClass);
	}

	/**
	* Removes the association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClassPKs the primary keys of the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClasses(long pk,
		long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Removes the association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClasses the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public static void removeVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeVirtualLabClasses(pk, virtualLabClasses);
	}

	/**
	* Sets the virtual lab classes associated with the virtual lab class science app, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClassPKs the primary keys of the virtual lab classes to be associated with the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setVirtualLabClasses(pk, virtualLabClassPKs);
	}

	/**
	* Sets the virtual lab classes associated with the virtual lab class science app, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class science app
	* @param virtualLabClasses the virtual lab classes to be associated with the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClasses(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setVirtualLabClasses(pk, virtualLabClasses);
	}

	public static VirtualLabClassScienceAppPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VirtualLabClassScienceAppPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabClassScienceAppPersistence.class.getName());

			ReferenceRegistry.registerReference(VirtualLabClassScienceAppUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VirtualLabClassScienceAppPersistence persistence) {
	}

	private static VirtualLabClassScienceAppPersistence _persistence;
}