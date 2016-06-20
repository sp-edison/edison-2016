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

package com.kisti.science.platform.app.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the ScienceApp service. Represents a row in the &quot;ScienceApp_ScienceApp&quot; database table, with each column mapped to a property of this class.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppModel
 * @see com.kisti.science.platform.app.model.impl.ScienceAppImpl
 * @see com.kisti.science.platform.app.model.impl.ScienceAppModelImpl
 * @generated
 */
public interface ScienceApp extends ScienceAppModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.kisti.science.platform.app.model.impl.ScienceAppImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Test if  a science app is being serviced,
	*
	* @return true if stage is ScienceAppConstant.IN_SERVICE.
	false, otherwise.
	* @see com.kisti.science.platform.model.ScienceApp#isApproved()
	*/
	public boolean isApproved();

	/**
	* Get the binary file path of the science app.
	*
	* @param scienceAppId
	* @return String - path to binary file
	*/
	public java.lang.String getBinPath();

	/**
	* Get the source file path of the science app.
	*
	* @param scienceAppId
	* @return String - path to source file
	*/
	public java.lang.String getSrcPath();
}