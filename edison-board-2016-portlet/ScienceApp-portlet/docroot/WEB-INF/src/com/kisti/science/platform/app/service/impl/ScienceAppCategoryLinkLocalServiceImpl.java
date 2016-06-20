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

import com.kisti.science.platform.app.model.ScienceAppCategoryLink;
import com.kisti.science.platform.app.service.base.ScienceAppCategoryLinkLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;

/**
 * The implementation of the science app category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.ScienceAppCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.app.service.base.ScienceAppCategoryLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.ScienceAppCategoryLocalServiceUtil
 */
public class ScienceAppCategoryLinkLocalServiceImpl
	extends ScienceAppCategoryLinkLocalServiceBaseImpl {
	public ScienceAppCategoryLink addScienceAppCategory(
			long categoryId,
			long scienceAppId) throws SystemException{
		long appCategoryLinkId = super.counterLocalService.increment();
		ScienceAppCategoryLink appCategory = super.scienceAppCategoryLinkPersistence.create(appCategoryLinkId);
		
		appCategory.setCategoryId(categoryId);
		appCategory.setScienceAppId(scienceAppId);
		
		super.addScienceAppCategoryLink(appCategory);
		
		return appCategory;
	}
	
	public void removeByCategoryId(long categoryId) throws SystemException{
		List<AssetCategory> childCategories =  AssetCategoryLocalServiceUtil.getChildCategories(categoryId);
		for(AssetCategory category : childCategories){
			this.removeByCategoryId(category.getCategoryId());
		}
		
		super.scienceAppCategoryLinkPersistence.removeByCategoryId(categoryId);
	}
	
	public void removeByScienceAppId(long scienceAppId) throws SystemException{
		super.scienceAppCategoryLinkPersistence.removeByAppId(scienceAppId);
	}
	
	public void removeAllLinks() throws SystemException{
		super.scienceAppCategoryLinkPersistence.removeAll();
	}
	
	public void update(ScienceAppCategoryLink appCategory) throws SystemException{
		super.scienceAppCategoryLinkPersistence.update(appCategory);
	}
	
	public long[] getScienceAppIdsByCategoryId(long categoryId) throws SystemException{
		
		List<ScienceAppCategoryLink> appCategories = super.scienceAppCategoryLinkPersistence.findByCategoryId(categoryId);
		final int size = appCategories.size();
		long[] scienceAppIds = null; 
		
		scienceAppIds = new long[size];
		int index = 0;
		for(ScienceAppCategoryLink category : appCategories){
			scienceAppIds[index] = category.getScienceAppId();
			index++;
		}
		return scienceAppIds;
	}
	
	public long[] getScienceAppIdsByCategoryId(long categoryId, int start, int end) throws SystemException{
		
		List<ScienceAppCategoryLink> appCategories = super.scienceAppCategoryLinkPersistence.findByCategoryId(categoryId, start, end);
		final int size = appCategories.size();
		long[] scienceAppIds = null; 
		
		scienceAppIds = new long[size];
		int index = 0;
		for(ScienceAppCategoryLink category : appCategories){
			scienceAppIds[index] = category.getScienceAppId();
			index++;
		}

		return scienceAppIds;
	}
	
	public int countScienceAppsByCategoryId(long categoryId) throws SystemException{
		return super.scienceAppCategoryLinkPersistence.countByCategoryId(categoryId);
	}

	public long[] getCategoryIdsByScienceAppId(long scienceAppId) throws SystemException{
		List<ScienceAppCategoryLink> appCategories = super.scienceAppCategoryLinkPersistence.findByCategoryId(scienceAppId);
		final int size = appCategories.size();
		long[] categoryIds = new long[size];
		int index = 0;
		for(ScienceAppCategoryLink category : appCategories){
			categoryIds[index] = category.getCategoryId();
			index++;
		}
		return categoryIds;
	}
	
	public long[] getCategoryIdsByScienceAppId(long scienceAppId, int start, int end) throws SystemException{
		List<ScienceAppCategoryLink> appCategories = super.scienceAppCategoryLinkPersistence.findByCategoryId(scienceAppId, start, end);
		final int size = appCategories.size();
		long[] categoryIds = new long[size];
		int index = 0;
		for(ScienceAppCategoryLink category : appCategories){
			categoryIds[index] = category.getScienceAppId();
			index++;
		}
		return categoryIds;
	}
	
	public int countCategoriesByScienceAppId(long scienceAppId) throws SystemException{
		return super.scienceAppCategoryLinkPersistence.countByAppId(scienceAppId);
	}
}