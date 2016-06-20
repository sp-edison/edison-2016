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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.science.model.ScienceAppDescription;

/**
 * The persistence interface for the science app description service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see ScienceAppDescriptionPersistenceImpl
 * @see ScienceAppDescriptionUtil
 * @generated
 */
public interface ScienceAppDescriptionPersistence extends BasePersistence<ScienceAppDescription> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppDescriptionUtil} to access the science app description persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the science app description in the entity cache if it is enabled.
	*
	* @param scienceAppDescription the science app description
	*/
	public void cacheResult(
		org.kisti.edison.science.model.ScienceAppDescription scienceAppDescription);

	/**
	* Caches the science app descriptions in the entity cache if it is enabled.
	*
	* @param scienceAppDescriptions the science app descriptions
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.ScienceAppDescription> scienceAppDescriptions);

	/**
	* Creates a new science app description with the primary key. Does not add the science app description to the database.
	*
	* @param descriptionId the primary key for the new science app description
	* @return the new science app description
	*/
	public org.kisti.edison.science.model.ScienceAppDescription create(
		long descriptionId);

	/**
	* Removes the science app description with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param descriptionId the primary key of the science app description
	* @return the science app description that was removed
	* @throws org.kisti.edison.science.NoSuchScienceAppDescriptionException if a science app description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppDescription remove(
		long descriptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppDescriptionException;

	public org.kisti.edison.science.model.ScienceAppDescription updateImpl(
		org.kisti.edison.science.model.ScienceAppDescription scienceAppDescription)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app description with the primary key or throws a {@link org.kisti.edison.science.NoSuchScienceAppDescriptionException} if it could not be found.
	*
	* @param descriptionId the primary key of the science app description
	* @return the science app description
	* @throws org.kisti.edison.science.NoSuchScienceAppDescriptionException if a science app description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppDescription findByPrimaryKey(
		long descriptionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppDescriptionException;

	/**
	* Returns the science app description with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param descriptionId the primary key of the science app description
	* @return the science app description, or <code>null</code> if a science app description with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppDescription fetchByPrimaryKey(
		long descriptionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app descriptions.
	*
	* @return the science app descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppDescription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app descriptions
	* @param end the upper bound of the range of science app descriptions (not inclusive)
	* @return the range of science app descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppDescription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app descriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app descriptions
	* @param end the upper bound of the range of science app descriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of science app descriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppDescription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app descriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app descriptions.
	*
	* @return the number of science app descriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}