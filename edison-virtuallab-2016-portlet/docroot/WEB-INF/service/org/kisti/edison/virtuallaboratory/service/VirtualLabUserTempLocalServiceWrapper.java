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

package org.kisti.edison.virtuallaboratory.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VirtualLabUserTempLocalService}.
 *
 * @author EDISON
 * @see VirtualLabUserTempLocalService
 * @generated
 */
public class VirtualLabUserTempLocalServiceWrapper
	implements VirtualLabUserTempLocalService,
		ServiceWrapper<VirtualLabUserTempLocalService> {
	public VirtualLabUserTempLocalServiceWrapper(
		VirtualLabUserTempLocalService virtualLabUserTempLocalService) {
		_virtualLabUserTempLocalService = virtualLabUserTempLocalService;
	}

	/**
	* Adds the virtual lab user temp to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserTemp the virtual lab user temp
	* @return the virtual lab user temp that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp addVirtualLabUserTemp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.addVirtualLabUserTemp(virtualLabUserTemp);
	}

	/**
	* Creates a new virtual lab user temp with the primary key. Does not add the virtual lab user temp to the database.
	*
	* @param virtualLabUserTempPK the primary key for the new virtual lab user temp
	* @return the new virtual lab user temp
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp createVirtualLabUserTemp(
		org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK virtualLabUserTempPK) {
		return _virtualLabUserTempLocalService.createVirtualLabUserTemp(virtualLabUserTempPK);
	}

	/**
	* Deletes the virtual lab user temp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp that was removed
	* @throws PortalException if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp deleteVirtualLabUserTemp(
		org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.deleteVirtualLabUserTemp(virtualLabUserTempPK);
	}

	/**
	* Deletes the virtual lab user temp from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserTemp the virtual lab user temp
	* @return the virtual lab user temp that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp deleteVirtualLabUserTemp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.deleteVirtualLabUserTemp(virtualLabUserTemp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _virtualLabUserTempLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp fetchVirtualLabUserTemp(
		org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.fetchVirtualLabUserTemp(virtualLabUserTempPK);
	}

	/**
	* Returns the virtual lab user temp with the primary key.
	*
	* @param virtualLabUserTempPK the primary key of the virtual lab user temp
	* @return the virtual lab user temp
	* @throws PortalException if a virtual lab user temp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp getVirtualLabUserTemp(
		org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK virtualLabUserTempPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.getVirtualLabUserTemp(virtualLabUserTempPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> getVirtualLabUserTemps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.getVirtualLabUserTemps(start, end);
	}

	/**
	* Returns the number of virtual lab user temps.
	*
	* @return the number of virtual lab user temps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabUserTempsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.getVirtualLabUserTempsCount();
	}

	/**
	* Updates the virtual lab user temp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLabUserTemp the virtual lab user temp
	* @return the virtual lab user temp that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp updateVirtualLabUserTemp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.updateVirtualLabUserTemp(virtualLabUserTemp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _virtualLabUserTempLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_virtualLabUserTempLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _virtualLabUserTempLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp addVirtualLabUserTemp(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.addVirtualLabUserTemp(params);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp removeVirtualLabUserTemp(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException {
		return _virtualLabUserTempLocalService.removeVirtualLabUserTemp(params);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListVirtualLabUserTemp(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _virtualLabUserTempLocalService.getListVirtualLabUserTemp(params);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getVirtualLabUserTemp(
		java.lang.Long seqNo, java.lang.Long virtualLabId,
		java.lang.Long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUserTempLocalService.getVirtualLabUserTemp(seqNo,
			virtualLabId, classId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VirtualLabUserTempLocalService getWrappedVirtualLabUserTempLocalService() {
		return _virtualLabUserTempLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVirtualLabUserTempLocalService(
		VirtualLabUserTempLocalService virtualLabUserTempLocalService) {
		_virtualLabUserTempLocalService = virtualLabUserTempLocalService;
	}

	@Override
	public VirtualLabUserTempLocalService getWrappedService() {
		return _virtualLabUserTempLocalService;
	}

	@Override
	public void setWrappedService(
		VirtualLabUserTempLocalService virtualLabUserTempLocalService) {
		_virtualLabUserTempLocalService = virtualLabUserTempLocalService;
	}

	private VirtualLabUserTempLocalService _virtualLabUserTempLocalService;
}