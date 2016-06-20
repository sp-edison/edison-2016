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

package com.kisti.science.platform.app.service.impl;

import java.util.List;

import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.service.base.ScienceAppServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the science app remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.ScienceAppService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.app.service.base.ScienceAppServiceBaseImpl
 * @see com.kisti.science.platform.app.service.ScienceAppServiceUtil
 */
public class ScienceAppServiceImpl extends ScienceAppServiceBaseImpl {
	
	/*
	 * @param authorId
	 * @param appClass
	 * @return
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#getScienceAppByClass(long, java.lang.String)
	 */
	public List<ScienceApp> getScienceAppByAppType(long authorId, String appType) throws SystemException {
		return super.scienceAppLocalService.getScienceAppListByAuthorIdAppType(authorId, appType);
	}
	
	/*
	 * @param authorId
	 * @param appClass
	 * @param start
	 * @param end
	 * @return
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#getScienceAppByClass(long, java.lang.String, int, int)
	 */
	public List<ScienceApp> getScienceAppByAppType(long authorId, String appType, int start, int end) throws SystemException {
		return super.scienceAppLocalService.getScienceAppListByAuthorIdAppType(authorId, appType, start, end);
	}
	
	/*
	 * @param authorId
	 * @param start
	 * @param end
	 * @return
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#getScienceApps(long, int, int)
	 */
	public List<ScienceApp> getScienceApps(long authorId, int start, int end) throws SystemException{
		return super.scienceAppLocalService.getScienceAppListByAuthorId(authorId, start, end);
	}
	
	/*
	 * @param authorId
	 * @return
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#getScienceAppsCount(long)
	 */
	public int countByAuthorId(long authorId) throws SystemException{
		return super.scienceAppLocalService.countScienceAppsByAuthorId(authorId);
	}
	
	public int getCountAll() throws SystemException{
		return super.scienceAppLocalService.countAllScienceApps();
	}
	
	public String getBinPath(long scienceAppId) throws PortalException, SystemException{
		return super.scienceAppLocalService.getScienceAppBinPath(scienceAppId);
	}
	
	public String getSrcPath(long scienceAppId) throws PortalException, SystemException{
		return super.scienceAppLocalService.getScienceAppSrcPath(scienceAppId);
	}
}