/**
 * Copyright (c) 2016-present EDISON, KISTI. All rights reserved.
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

package com.kisti.science.platform.app.model.impl;

import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * The extended model implementation for the ScienceApp service. Represents a row in the &quot;ScienceApp_ScienceApp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.model.ScienceApp} interface.
 * </p>
 *
 * @author Jerry H. Seo
 */
public class ScienceAppImpl extends ScienceAppBaseImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3363982637471638384L;

	public ScienceAppImpl() {
	}
	
	/**
	 * Test if  a science app is being serviced,
	 * 
	 * @return
	 * 		true if stage is ScienceAppConstant.IN_SERVICE.
	 * 		false, otherwise.
	 *
	 * @see com.kisti.science.platform.model.ScienceApp#isApproved()
	 */
	public boolean isApproved(){
		if(super.getStage().equalsIgnoreCase(ScienceAppConstants.IN_SERVICE))
			return true;
		else	return false;
	}
	
	/**
	 * Get the binary file path of the science app.
	 * 
	 * @param scienceAppId
	 * @return
	 * 		String - path to binary file
	 */
	public String getBinPath(){
		return this.getName()+"/"+this.getVersion()+"/"+ScienceAppConstants.DEFAULT_BIN_DIR+"/"+this.getExeFileName();
	}
	
	/**
	 * Get the source file path of the science app.
	 * 
	 * @param scienceAppId
	 * @return
	 * 		String - path to source file
	 */
	public String getSrcPath(){
		return this.getName()+"/"+this.getVersion()+"/"+ScienceAppConstants.DEFAULT_SRC_DIR+"/"+this.getSrcFileName();
	}
}