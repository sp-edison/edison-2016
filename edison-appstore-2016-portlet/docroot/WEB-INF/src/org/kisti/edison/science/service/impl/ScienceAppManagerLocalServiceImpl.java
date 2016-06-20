/**
 * Copyright (c) 2016-EDISON, KISTI. All rights reserved.
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

package org.kisti.edison.science.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.ScienceAppManager;
import org.kisti.edison.science.service.base.ScienceAppManagerLocalServiceBaseImpl;
import org.kisti.edison.science.service.persistence.ScienceAppManagerFinderImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the science app manager local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.science.service.ScienceAppManagerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.base.ScienceAppManagerLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.ScienceAppManagerLocalServiceUtil
 */
public class ScienceAppManagerLocalServiceImpl
	extends ScienceAppManagerLocalServiceBaseImpl {

	public ScienceAppManager addScienceAppManager(
			long managerId,
			long scienceAppId ) throws SystemException{
		if( this.existScienceAppManager(managerId, scienceAppId) )
			return null;
		long appManagerId = super.counterLocalService.increment();
		ScienceAppManager manager = super.scienceAppManagerPersistence.create(appManagerId);
		
		manager.setManagerId(managerId);
		manager.setScienceAppId(scienceAppId);
		
		return manager;
	}
	
	public void removeScienceAppManagerByManagerId(long managerId)  throws SystemException{
		super.scienceAppManagerPersistence.removeByManagerId(managerId);
	}
	
	public void removeScienceAppManagerByScienceAppId(long scienceAppId) throws SystemException{
		super.scienceAppManagerPersistence.removeByAppId(scienceAppId);
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
	
	public long[] getScienceAppIdsByManagerId(long managerId, int start, int end) throws SystemException{
		List<ScienceAppManager> appManagers = super.scienceAppManagerPersistence.findByManagerId(managerId, start, end);
		final int size = appManagers.size();
		long[] scienceAppIds = new long[size];
		int index = 0;
		for(ScienceAppManager appManager : appManagers){
			scienceAppIds[index] = appManager.getScienceAppId();
			index++;
		}
		
		return scienceAppIds;
	}
	
	public int countScienceAppIdsByManagerId(long managerId) throws SystemException{
		return super.scienceAppManagerPersistence.countByManagerId(managerId);
	}
	
	public long[] getManagerIdsByScienceAppId(long scienceAppId) throws SystemException{
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

	public long[] getManagerIdsByScienceAppId(long scienceAppId, int start, int end) throws SystemException{
		List<ScienceAppManager> appManagers = super.scienceAppManagerPersistence.findByAppId(scienceAppId, start, end);
		final int size = appManagers.size();
		long[] managerIds = new long[size];
		
		int index = 0;
		for(ScienceAppManager appManager : appManagers){
			managerIds[index] = appManager.getManagerId();
			index++;
		}
		
		return managerIds;
	}
	
	public int countManagersByScienceAppId(long scienceAppId) throws SystemException{
		return super.scienceAppManagerPersistence.countByAppId(scienceAppId);
	}

	
	/*
	 * @param managerId
	 * @param scienceAppId
	 * @return
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppManagerLocalService#existScienceAppManager(long, long)
	 */
	public boolean existScienceAppManager(long managerId, long scienceAppId) throws SystemException{
		if( super.scienceAppManagerPersistence.countByAppIdManagerId(scienceAppId, managerId) > 0)	return true;
		else	return false;
	}
	
	
	
	/**********************************   ADD GPLUS SERVICE   ******************************/
	
	public List<ScienceAppManager> getManagersByScienceAppId(long scienceAppId) throws SystemException{
		List<ScienceAppManager> appManagers = super.scienceAppManagerPersistence.findByAppId(scienceAppId);
		return appManagers;
	}
	
	public List<ScienceAppManager> findByAppIdAndUserId(long scienceAppId,long userId) throws SystemException{
		return super.scienceAppManagerPersistence.findByAppIdAndUserId(scienceAppId, userId);
	}
	
	
	public int countByUserId(long userId) throws SystemException{
		return super.scienceAppManagerPersistence.countByUserId(userId);
	}
	
	public int countByAppIdAndUserId(long scienceAppId, long userId) throws SystemException{
		return super.scienceAppManagerPersistence.countByAppIdAndUserId(scienceAppId, userId);
	}
	
	public void removeByAppIdAndUserId(long scienceAppId, long userId) throws SystemException{
		scienceAppManagerPersistence.removeByAppIdAndUserId(scienceAppId, userId);
	}
	
	public List<Map<String, Object>> getScienceAppManagerList(long userId, long groupId) throws SystemException{
		List<Object[]> scienceAppManagerList = scienceAppManagerFinder.getScienceAppManagerList(userId, groupId);

		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		if(scienceAppManagerList != null && scienceAppManagerList.size() > 0){
			for(int i=0 ;i < scienceAppManagerList.size() ; i++){
				Object[] scienceAppManager = scienceAppManagerList.get(i);
				
				resultRow = new HashMap<String, Object>();
				
				resultRow.put("scienceAppManagerId", String.valueOf(scienceAppManager[0]));
				resultRow.put("scienceAppId", String.valueOf(scienceAppManager[1]));
				resultRow.put("groupId", String.valueOf(scienceAppManager[2]));
				resultRow.put("userId", String.valueOf(scienceAppManager[3]));

				returnList.add(resultRow);
			}
		}
		return returnList;
	}
}