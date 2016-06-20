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

import com.kisti.science.platform.app.NoSuchManagerException;
import com.kisti.science.platform.app.model.ScienceAppManager;
import com.kisti.science.platform.app.service.base.ScienceAppManagerServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the science app manager remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.ScienceAppManagerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.app.service.base.ScienceAppManagerServiceBaseImpl
 * @see com.kisti.science.platform.app.service.ScienceAppManagerServiceUtil
 */
public class ScienceAppManagerServiceImpl
	extends ScienceAppManagerServiceBaseImpl {
	public ScienceAppManager addScienceAppManager(
			long managerId,
			long scienceAppId,
			ServiceContext sc ) throws SystemException{
		long appManagerId = super.counterLocalService.increment();
		ScienceAppManager manager = super.scienceAppManagerPersistence.create(appManagerId);
		
		manager.setManagerId(managerId);
		manager.setScienceAppId(scienceAppId);
		
		manager.setCreateDate(sc.getCreateDate());
		manager.setUserId(sc.getUserId());
		
		return manager;
	}
	
	public void removeSicenceAppManager(long scienceAppManagerId) throws NoSuchManagerException, SystemException{
		super.scienceAppManagerPersistence.remove(scienceAppManagerId);
	}
	
	public void removeScienceAppManagerByManagerId(long managerId)  throws SystemException{
		super.scienceAppManagerPersistence.removeByManagerId(managerId);
	}
	
	public void removeScienceAppManagerByScienceAppId(long scienceAppId) throws SystemException{
		super.scienceAppManagerPersistence.removeByAppId(scienceAppId);
	}
	
	public void updateScienceAppManager(ScienceAppManager appManager) throws SystemException{
		super.scienceAppManagerPersistence.update(appManager);
	}
	
	public long[] getScienceAppIdsByManagerId(long managerId) throws SystemException{
		List<ScienceAppManager> appManagers = super.scienceAppManagerPersistence.findByManagerId(managerId);
		final int size = appManagers.size();
		long[] scienceAppIds = new long[size];
		
		int index = 0;
		for(ScienceAppManager appManager : appManagers){
			scienceAppIds[index] = appManager.getScienceAppId();
			index++;
		}
		
		return scienceAppIds;
	}
	
	public long[] getManagetIdsByScienceAppId(long scienceAppId) throws SystemException{
		List<ScienceAppManager> appManagers = super.scienceAppManagerPersistence.findByAppId(scienceAppId);
		final int size = appManagers.size();
		long[] managerIds = new long[size];
		
		int index = 0;
		for(ScienceAppManager appManager : appManagers){
			managerIds[index] = appManager.getManagerId();
			index++;
		}
		
		return managerIds;
	}

}