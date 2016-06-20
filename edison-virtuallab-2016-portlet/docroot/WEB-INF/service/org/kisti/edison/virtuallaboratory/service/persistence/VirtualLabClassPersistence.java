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

import org.kisti.edison.virtuallaboratory.model.VirtualLabClass;

/**
 * The persistence interface for the virtual lab class service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClassPersistenceImpl
 * @see VirtualLabClassUtil
 * @generated
 */
public interface VirtualLabClassPersistence extends BasePersistence<VirtualLabClass> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VirtualLabClassUtil} to access the virtual lab class persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the virtual lab class in the entity cache if it is enabled.
	*
	* @param virtualLabClass the virtual lab class
	*/
	public void cacheResult(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass);

	/**
	* Caches the virtual lab classes in the entity cache if it is enabled.
	*
	* @param virtualLabClasses the virtual lab classes
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses);

	/**
	* Creates a new virtual lab class with the primary key. Does not add the virtual lab class to the database.
	*
	* @param classId the primary key for the new virtual lab class
	* @return the new virtual lab class
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass create(
		long classId);

	/**
	* Removes the virtual lab class with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param classId the primary key of the virtual lab class
	* @return the virtual lab class that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException if a virtual lab class with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass remove(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException;

	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the virtual lab class with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException} if it could not be found.
	*
	* @param classId the primary key of the virtual lab class
	* @return the virtual lab class
	* @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException if a virtual lab class with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass findByPrimaryKey(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException;

	/**
	* Returns the virtual lab class with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param classId the primary key of the virtual lab class
	* @return the virtual lab class, or <code>null</code> if a virtual lab class with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass fetchByPrimaryKey(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the virtual lab classes.
	*
	* @return the virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the virtual lab classes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @return the range of virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the virtual lab classes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the virtual lab classes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual lab classes.
	*
	* @return the number of virtual lab classes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the virtual labs associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @return the virtual labs associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the virtual labs associated with the virtual lab class.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @return the range of virtual labs associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the virtual labs associated with the virtual lab class.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual labs associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual labs associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @return the number of virtual labs associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public int getVirtualLabsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the virtual lab is associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabPK the primary key of the virtual lab
	* @return <code>true</code> if the virtual lab is associated with the virtual lab class; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLab(long pk, long virtualLabPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the virtual lab class has any virtual labs associated with it.
	*
	* @param pk the primary key of the virtual lab class to check for associations with virtual labs
	* @return <code>true</code> if the virtual lab class has any virtual labs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLabs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabPK the primary key of the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLab(long pk, long virtualLabPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLab the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabPKs the primary keys of the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabs(long pk, long[] virtualLabPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabs the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabs(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the virtual lab class and its virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class to clear the associated virtual labs from
	* @throws SystemException if a system exception occurred
	*/
	public void clearVirtualLabs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabPK the primary key of the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLab(long pk, long virtualLabPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLab the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabPKs the primary keys of the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabs(long pk, long[] virtualLabPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabs the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabs(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual labs associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabPKs the primary keys of the virtual labs to be associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabs(long pk, long[] virtualLabPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual labs associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabs the virtual labs to be associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabs(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the virtual lab class science apps associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @return the virtual lab class science apps associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the virtual lab class science apps associated with the virtual lab class.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @return the range of virtual lab class science apps associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the virtual lab class science apps associated with the virtual lab class.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab class science apps associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual lab class science apps associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @return the number of virtual lab class science apps associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public int getVirtualLabClassScienceAppsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the virtual lab class science app is associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceAppPK the primary key of the virtual lab class science app
	* @return <code>true</code> if the virtual lab class science app is associated with the virtual lab class; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLabClassScienceApp(long pk,
		long virtualLabClassScienceAppPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the virtual lab class has any virtual lab class science apps associated with it.
	*
	* @param pk the primary key of the virtual lab class to check for associations with virtual lab class science apps
	* @return <code>true</code> if the virtual lab class has any virtual lab class science apps associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLabClassScienceApps(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceAppPK the primary key of the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassScienceApp(long pk,
		long virtualLabClassScienceAppPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassScienceApp(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceAppPKs the primary keys of the virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassScienceApps(long pk,
		long[] virtualLabClassScienceAppPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceApps the virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabClassScienceApps(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassScienceApps)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the virtual lab class and its virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class to clear the associated virtual lab class science apps from
	* @throws SystemException if a system exception occurred
	*/
	public void clearVirtualLabClassScienceApps(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceAppPK the primary key of the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabClassScienceApp(long pk,
		long virtualLabClassScienceAppPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabClassScienceApp(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceAppPKs the primary keys of the virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabClassScienceApps(long pk,
		long[] virtualLabClassScienceAppPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceApps the virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabClassScienceApps(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassScienceApps)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual lab class science apps associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceAppPKs the primary keys of the virtual lab class science apps to be associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabClassScienceApps(long pk,
		long[] virtualLabClassScienceAppPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual lab class science apps associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabClassScienceApps the virtual lab class science apps to be associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabClassScienceApps(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassScienceApps)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the virtual lab users associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @return the virtual lab users associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the virtual lab users associated with the virtual lab class.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @return the range of virtual lab users associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the virtual lab users associated with the virtual lab class.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the virtual lab class
	* @param start the lower bound of the range of virtual lab classes
	* @param end the upper bound of the range of virtual lab classes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual lab users associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual lab users associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @return the number of virtual lab users associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public int getVirtualLabUsersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the virtual lab user is associated with the virtual lab class.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUserPK the primary key of the virtual lab user
	* @return <code>true</code> if the virtual lab user is associated with the virtual lab class; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLabUser(long pk, long virtualLabUserPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the virtual lab class has any virtual lab users associated with it.
	*
	* @param pk the primary key of the virtual lab class to check for associations with virtual lab users
	* @return <code>true</code> if the virtual lab class has any virtual lab users associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLabUsers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUserPK the primary key of the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabUser(long pk, long virtualLabUserPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUser the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabUser(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUserPKs the primary keys of the virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabUsers(long pk, long[] virtualLabUserPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUsers the virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabUsers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabUsers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the virtual lab class and its virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class to clear the associated virtual lab users from
	* @throws SystemException if a system exception occurred
	*/
	public void clearVirtualLabUsers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUserPK the primary key of the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabUser(long pk, long virtualLabUserPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUser the virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabUser(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUserPKs the primary keys of the virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabUsers(long pk, long[] virtualLabUserPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUsers the virtual lab users
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabUsers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabUsers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual lab users associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUserPKs the primary keys of the virtual lab users to be associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabUsers(long pk, long[] virtualLabUserPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual lab users associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the virtual lab class
	* @param virtualLabUsers the virtual lab users to be associated with the virtual lab class
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabUsers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabUsers)
		throws com.liferay.portal.kernel.exception.SystemException;
}