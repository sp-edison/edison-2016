/**
 * Copyright (c) 2015-present KISTI. All rights reserved.
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.model.impl.ScienceAppImpl;
import com.kisti.science.platform.app.service.base.ScienceAppLocalServiceBaseImpl;
import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.kisti.science.platform.app.service.persistence.ScienceAppFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the science app local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.service.ScienceAppLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.service.base.ScienceAppLocalServiceBaseImpl
 * @see com.kisti.science.platform.service.ScienceAppLocalServiceUtil
 */
public class ScienceAppLocalServiceImpl extends ScienceAppLocalServiceBaseImpl {
	
	/**
	 * Creates a ScienceApp instance with specified name and version.
	 * The new instance created is not yet saved in the database.
	 * Use addScienceApp() to save the instance.
	 * 
	 * @param appName: ScienceApp name to be created
	 * @param appVersion: ScienceApp version to be created
	 * @param sc: ServiceContext instance for ScienceApp
	 * @return
	 * 		If appName is not follows naming rules or already exists in the database, returns null.
	 * 		If appVersion is not follows versioning rules, returns null.
	 * 		Otherwise returns a ScienceApp instance with initialized data.
	 * 
	 * 		Some attributes of the returned instance are set initial value as followings:
	 * 		-stage: ScienceAppConstants.EMPTY
	 * 		-authorId: current user id of service context instance
	 * 		-createDate: date created of service context instance
	 * 		-modifiedDate: date created of service context instance
	 * 		-userId: current user id of service context instance
	 * 		-recentModifierId: current user id of service context instance
	 * 		-groupId: scope group id of service context instance
	 * 		-companyId: company id of service context instance
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#createScienceApp(java.lang.String, java.lang.String, com.liferay.portal.service.ServiceContext)
	 */
	public ScienceApp createScienceApp(String appName, String appVersion, ServiceContext sc) throws SystemException{
		if( !this.verifyScienceAppName(appName) )
			return null;
		if( this.existAppName(appName)){
			if( !this.verifyVersionNumber(appName, appVersion) )	return null;
		}
		
		ScienceApp newApp = null;
		long newAppId = super.counterLocalService.increment();
		newApp = super.scienceAppPersistence.create(newAppId);
		
		newApp.setName(appName);
		newApp.setVersion(appVersion);
		newApp.setStage(ScienceAppConstants.EMPTY);
		newApp.setAuthorId(sc.getUserId());
		newApp.setCreateDate(sc.getCreateDate());
		newApp.setModifiedDate(sc.getModifiedDate());
		newApp.setUserId(sc.getUserId());
		newApp.setRecentModifierId(sc.getUserId());
		newApp.setGroupId(sc.getScopeGroupId());
		newApp.setCompanyId(sc.getCompanyId());
		
		return newApp;
	}
	
	/**
	 * Copies ScienceApp instance to another.
	 * The instance is not yet saved in the database.
	 * Use addScienceApp() to save the instance.
	 * 
	 * @param scienceAppId: original ScienceApp id to be copied
	 * @param sc: service context for ScienceApp
	 * @return
	 * 		new ScienceApp instance.
	 * 		Each attribute of the returned instance has exactly same value with original instance
	 * 		except some attributes.
	 * 
	 * 		Some attributes of the returned instance are initialized as followings:
	 * 		-stage: ScienceAppConstants.EMPTY
	 * 		-createDate: date created of service context instance
	 * 		-modifiedDate: date created of service context instance
	 * 		-userId: current user id of service context instance
	 * 		-recentModifierId: current user id of service context instance
	 * 		-groupId: scope group id of service context instance
	 * 		-companyId: company id of service context instance
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#copyScienceApp(long, com.liferay.portal.service.ServiceContext)
	 */
	public ScienceApp copyScienceApp(long scienceAppId, ServiceContext sc) throws SystemException{
		ScienceApp orgApp = super.fetchScienceApp(scienceAppId);
		long copyAppId = super.counterLocalService.increment();
		
		ScienceApp copyApp = (ScienceApp)orgApp.clone();
		copyApp.setStage(ScienceAppConstants.EMPTY);
		copyApp.setScienceAppId(copyAppId);
		copyApp.setCreateDate(sc.getCreateDate());
		copyApp.setModifiedDate(sc.getModifiedDate());
		copyApp.setUserId(sc.getUserId());
		copyApp.setRecentModifierId(sc.getUserId());
		copyApp.setGroupId(sc.getScopeGroupId());
		copyApp.setCompanyId(sc.getCompanyId());
		
		return copyApp;
	}
	
	/**
	 * Saves the specified ScienceApp instance to database.
	 *  
	 * @param scienceApp: ScienceApp instance to be saved.
	 * @param sc: service context of the ScienceApp class
	 * @return
	 * 		ScienceApp instance saved.
	 * @throws SystemException
	 * @throws PortalException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#addScienceApp(com.kisti.science.platform.model.ScienceApp, com.liferay.portal.service.ServiceContext)
	 */
	public ScienceApp addScienceApp(ScienceApp scienceApp, ServiceContext sc) throws SystemException, PortalException{
		super.resourceLocalService.addResources(
					scienceApp.getCompanyId(), 
					scienceApp.getGroupId(), 
					scienceApp.getUserId(), 
					ScienceApp.class.getName(),	
					scienceApp.getScienceAppId(), 
					false, true, true);
		
		AssetEntry assetEntry = super.assetEntryLocalService.updateEntry(
				scienceApp.getUserId(),
				scienceApp.getGroupId(), 
				scienceApp.getCreateDate(),
				scienceApp.getModifiedDate(), 
				ScienceApp.class.getName(),
				scienceApp.getScienceAppId(), 
				scienceApp.getUuid(), 
				0,
				sc.getAssetCategoryIds(),
				sc.getAssetTagNames(), 
				true, null, null, null,
				ContentTypes.TEXT_HTML, 
				scienceApp.getName(), 
				null, null, null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
				scienceApp.getUserId(), 
				assetEntry.getEntryId(),
				sc.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(ScienceApp.class);
		indexer.reindex(scienceApp);
		
		return super.addScienceApp(scienceApp);
	}
	
	public void setScienceAppInputPorts(long scienceAppId, String inputPorts) throws SystemException{
		super.scienceAppInputPortsLocalService.create(scienceAppId, inputPorts);
	}
	
	public String getScienceAppInputPorts(long scienceAppId) throws SystemException{
		return super.scienceAppInputPortsLocalService.getInputPortsJsonString(scienceAppId);
	}
	
	public void setScienceAppOutputPorts(long scienceAppId, String outputPorts) throws SystemException{
		super.scienceAppOutputPortsLocalService.create(scienceAppId, outputPorts);
	}
	
	public String getScienceAppOutputPorts(long scienceAppId) throws SystemException{
		return super.scienceAppOutputPortsLocalService.getOutputPortsJsonString(scienceAppId);
	}
	
	/**
	 * Verifies ScienceApp name if the name follows specified naming rules and there is no science app
	 * in the database already.
	 * 
	 * @param appName: science app name to be tesed.
	 * @return
	 * 		true if the name follows naming rules and brand new.
	 * 		false, Otherwise.
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#verifyScienceAppName(java.lang.String, long)
	 */
	public boolean verifyScienceAppName(String appName) throws SystemException{
		if( !appName.matches(ScienceAppConstants.SCIENCEAPP_VALID_NAME_EXPR) )
			return false;
		
		return !this.existAppName(appName);
	}
	
	/**  Test if there is a science app name in the database already.
	 * 
	 * @param appName: science app name to be tesed.
	 * @return 
	 * 		true if the app name already exist in the database, 
	 * 		false, otherwise
	 * @throws SystemException
	 * 
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#existAppName(java.lang.String)
	 */
	public boolean existAppName(String appName) throws SystemException{
		if( super.scienceAppPersistence.countByName(appName) > 0)	return true;
		else	return false;
	}
	
	/** Test if there is an science app with the specified name and version in the database.
	 * @param appName: science app name to be tesed.
	 * @param appVersion: science app version to be tesed.
	 * @return 
	 * 		true if a science app with the name and the version already exist in the database, 
	 * 		false, otherwise.
	 * @throws SystemException
	 * 
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#existApp(java.lang.String, java.lang.String)
	 */
	public boolean existApp(String appName, String appVersion) throws SystemException {
		if (super.scienceAppPersistence.countByNameVersion(appName, appVersion) > 0)	return true;
		else	return false;
	}
	
	/** Get the science app's latest version
	 * @param appName: science app name
	 * @return the latest version science app instance.
	 * @throws SystemException
	 * 
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#getLatestVersion(java.lang.String)
	 */
	public ScienceApp getLatestVersion(String appName) throws SystemException{
		ScienceApp app = null;
		OrderByComparator orderBy = OrderByComparatorFactoryUtil.create(ScienceAppImpl.TABLE_NAME, "createDate", false);
		app = super.scienceAppPersistence.fetchByName_First(appName, orderBy);
		return app;
	}
	
	/** 
	 * Verify version number of a science app. 
	 * Version number of a science app should be consisted of 3 sections, {major}.{sub}.{minor}.
	 * Major section number should be increased when a science app changes or added its architecture or major functions.
	 * Sub section number should be increased when the science app changes functionality.
	 * Minor section number should be increased when the science app fixes errors.
	 * Each section must be integer and be lager than before.   
	 * 
	 * @param appName: science app name to be verified.
	 * @param appVersion: science app version to be verified.
	 * @return 
	 * 		true if the version number follows naming rules and valid. 
	 * 		false, Otherwise.
	 * @throws SystemException
	 * 
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#verifyVersionNumber(java.lang.String, java.lang.String)
	 */
	public boolean verifyVersionNumber(String appName, String appVersion) throws SystemException{
		if( !appName.matches(ScienceAppConstants.SCIENCEAPP_VALID_VERSION_EXPR) )
			return false;
		
		ScienceApp app = this.getLatestVersion(appName);
		String[] newVersion = appVersion.split("\\.");
		//System.out.println("Saved version: "+app.getVersion());
		String[] version = app.getVersion().split("\\.");
		//System.out.println("version length: "+version.length+"-"+newVersion.length);
			
		for(int i=0; i<newVersion.length && i<version.length; i++){
			//System.out.println("Level["+i+"]: "+ newVersion[i]+":"+version[i]);
			if( Integer.parseInt(newVersion[i]) < Integer.parseInt(version[i]))				return false;
			else if( Integer.parseInt(newVersion[i]) > Integer.parseInt(version[i]))		return true;
		}
		//System.out.println("All verified failed.....");
		
		return false;
	}
	
	/** 
	 * Delete a science app by its id
	 * 
	 * @param scienceAppId: science app id to be deleted
	 * @return
	 * 		ScienceApp instance deleted.
	 * @throws SystemException
	 * @throws PortalException
	 *
	 * @see com.kisti.science.platform.service.base.ScienceAppLocalServiceBaseImpl#deleteScienceApp(long)
	 */
	public ScienceApp deleteScienceApp(long scienceAppId) throws SystemException, PortalException{
		return this.deleteScienceApp(super.getScienceApp(scienceAppId));
	}
	
	/**
	 * Delete a science app by its instance
	 * 
	 * @param scienceApp: science app instance to be tesed.
	 * @return
	 * 		ScienceApp instance deleted.
	 * @throws SystemException
	 * @throws PortalException
	 *
	 * @see com.kisti.science.platform.service.base.ScienceAppLocalServiceBaseImpl#deleteScienceApp(com.kisti.science.platform.model.ScienceApp)
	 */
	public ScienceApp deleteScienceApp(ScienceApp scienceApp) throws SystemException, PortalException{
		this.cleanIntegratedData(scienceApp.getScienceAppId());
		super.resourceLocalService.deleteResource(
				scienceApp.getCompanyId(), 
				ScienceApp.class.getName(), 
				ResourceConstants.SCOPE_INDIVIDUAL, 
				scienceApp.getScienceAppId()); 

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				ScienceApp.class.getName(), 
				scienceApp.getScienceAppId());
		
		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(
				ScienceApp.class.getName(),
				scienceApp.getScienceAppId());
		super.deleteScienceApp(scienceApp); 

		Indexer indexer = IndexerRegistryUtil.getIndexer(ScienceApp.class);
		indexer.reindex(scienceApp);
		
		return scienceApp;
	}
	
	public void deleteAllScienceApps() throws SystemException{
		super.scienceAppPersistence.removeAll();
		super.scienceAppInputPortsLocalService.removeAllInputPorts();
		super.scienceAppOutputPortsLocalService.removeAllOutputPorts();
		super.scienceAppCategoryLinkLocalService.removeAllLinks();
		super.scienceAppManagerPersistence.removeAll();
	}
	
	/** 
	 * Update a science app
	 * 
	 * @param scienceApp: science app instance to be updated.
	 * @param sc: ServiceContext instance for the ScienceApp class.
	 * @return
	 * 		ScienceApp instance updated.
	 * @throws SystemException
	 * @throws PortalException
	 *
	 * @see com.kisti.science.platform.service.ScienceAppLocalService#updateScienceApp(com.kisti.science.platform.model.ScienceApp, com.liferay.portal.service.ServiceContext)
	 */
	public ScienceApp updateScienceApp(ScienceApp scienceApp, ServiceContext sc) throws SystemException, PortalException{

		long userId = sc.getUserId();
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
				userId,
				scienceApp.getGroupId(), 
				scienceApp.getCreateDate(),
				scienceApp.getModifiedDate(), 
				ScienceApp.class.getName(),
				scienceApp.getScienceAppId(), 
				scienceApp.getUuid(), 
				0,
				sc.getAssetCategoryIds(),
				sc.getAssetTagNames(), 
				true, null, null, null,
				ContentTypes.TEXT_HTML, 
				scienceApp.getName(), 
				null, null, null, null, 0, 0, null, false);
		
		assetLinkLocalService.updateLinks(
				userId, 
				assetEntry.getEntryId(),
				sc.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);
		
		Indexer indexer = IndexerRegistryUtil.getIndexer(ScienceApp.class);
		indexer.reindex(scienceApp);
		
		return super.updateScienceApp(scienceApp);
	}
	
	/*
	 * From this line, the APIs are just call persistence APIs for convenience.
	 */
	public List<ScienceApp> getAll() throws SystemException{
		return super.scienceAppPersistence.findAll();
	}
	public int countAll() throws SystemException{
		return super.scienceAppPersistence.countAll();
	}
	
	public List<ScienceApp> getAll(String targetLang) throws SystemException{
		return super.scienceAppPersistence.findByTargetLanguage(targetLang);
	}

	public int countAll(String targetLang) throws SystemException{
		return super.scienceAppPersistence.countByTargetLanguage(targetLang);
	}

	public List<ScienceApp> getAll(int start, int end) throws SystemException{
		return super.scienceAppPersistence.findAll(start, end);
	}
	
	public List<ScienceApp> getAll(int start, int end, String targetLang) throws SystemException{
		return super.scienceAppPersistence.findByTargetLanguage(targetLang, start, end);
	}

	public List<ScienceApp> getScienceAppListByStatus(int status) throws SystemException{
		return super.scienceAppPersistence.findByStatus(status);
	}
	
	public int countScienceAppsByStatus(int status) throws SystemException{
		return super.scienceAppPersistence.countByStatus(status);
	}
	
	public List<ScienceApp> getScienceAppListByStage(String stage) throws SystemException{
		return super.scienceAppPersistence.findByStage(stage);
	}

	public int countScienceAppsByStage(String stage) throws SystemException{
		return super.scienceAppPersistence.countByStage(stage);
	}

	public List<ScienceApp> getScienceAppListByStage(String stage, int start, int end) throws SystemException{
		return super.scienceAppPersistence.findByStage(stage, start, end);
	}

	public List<ScienceApp> getScienceAppListByAuthorIdAppType(long authorId, String appType) throws SystemException {
		return super.scienceAppPersistence.findByAuthorIdAppType(authorId, appType);
	}
	
	public List<ScienceApp> getScienceAppListByAppType(String appType) throws SystemException {
		return super.scienceAppPersistence.findByAppType(appType);
	}
	
	public List<ScienceApp> getScienceAppListByAppType(String appType, int start, int end) throws SystemException {
		return super.scienceAppPersistence.findByAppType(appType, start, end);
	}
	
	public List<ScienceApp> getScienceAppListByAppType(String appType, String targetLang) throws SystemException {
		return super.scienceAppPersistence.findByAppTypeWithTarget(appType, targetLang);
	}
	
	public List<ScienceApp> getScienceAppListByAppType(String appType, int start, int end, String targetLang) throws SystemException {
		return super.scienceAppPersistence.findByAppTypeWithTarget(appType, targetLang, start, end);
	}
	
	public int countScienceAppsByAppType(String appType) throws SystemException {
		return super.scienceAppPersistence.countByAppType(appType);
	}

	public int countScienceAppsByAppType(String appType, String targetLang) throws SystemException {
		return super.scienceAppPersistence.countByAppTypeWithTarget(appType, targetLang);
	}

	public List<ScienceApp> getScienceAppListByAuthorIdAppType(long authorId, String appClass, int start, int end) throws SystemException {
		return super.scienceAppPersistence.findByAuthorIdAppType(authorId, appClass, start, end);
	}
	
	public List<ScienceApp> getScienceAppListByAuthorId(long authorId) throws SystemException{
		return super.scienceAppPersistence.findByAuthorId(authorId);
	}
	
	public List<ScienceApp> getScienceAppListByAuthorId(long authorId, int start, int end) throws SystemException{
		return super.scienceAppPersistence.findByAuthorId(authorId, start, end);
	}
	
	public int countScienceAppsByAuthorId(long authorId) throws SystemException{
		return super.scienceAppPersistence.countByAuthorId(authorId);
	}
	
	public List<ScienceApp> getScienceAppListByOpenLevel(String openLevel) throws SystemException{
		return super.scienceAppPersistence.findByOpenLevel(openLevel);
	}
	
	public List<ScienceApp> getScienceAppListByOpenLevel(String openLevel, int start, int end) throws SystemException{
		return super.scienceAppPersistence.findByOpenLevel(openLevel, start, end);
	}
	
	public List<ScienceApp> getScienceAppListByManagerId(long managerId) throws SystemException, PortalException{
		long[] scienceAppIds = super.scienceAppManagerLocalService.getScienceAppIdsByManagerId(managerId);
		return this.getScienceAppListByScienceAppIds(scienceAppIds);
	}
	
	public List<ScienceApp> getScienceAppListByManagerId(long managerId, int start, int end) throws SystemException, PortalException{
		long[] scienceAppIds = super.scienceAppManagerLocalService.getScienceAppIdsByManagerId(managerId, start, end);
		return this.getScienceAppListByScienceAppIds(scienceAppIds);
	}
	
	public int countScienceAppsByManagerId(long managerId) throws SystemException{
		return super.scienceAppManagerLocalService.countScienceAppIdsByManagerId(managerId);
	}
	
	public long[] getScienceAppManagerIds(long scienceAppId) throws SystemException{
		return super.scienceAppManagerLocalService.getManagerIdsByScienceAppId(scienceAppId);
	}
	
	public long[] getScienceAppManagerIds(long scienceAppId, int start, int end) throws SystemException{
		return super.scienceAppManagerLocalService.getManagerIdsByScienceAppId(scienceAppId, start, end);
	}
	
	public int countScienceAppManagers(long scienceAppId) throws SystemException{
		return super.scienceAppManagerLocalService.countManagersByScienceAppId(scienceAppId);
	}
	
	public List<ScienceApp> getScienceAppListByCategoryId(long categoryId) throws SystemException, PortalException{
		long[] scienceAppIds = super.scienceAppCategoryLinkLocalService.getScienceAppIdsByCategoryId(categoryId);
		return this.getScienceAppListByScienceAppIds(scienceAppIds);
	}
	
	public List<ScienceApp> getScienceAppListByCategoryId(long categoryId, int start, int end) throws SystemException, PortalException{
		long[] scienceAppIds = super.scienceAppCategoryLinkLocalService.getScienceAppIdsByCategoryId(categoryId, start, end);
		return this.getScienceAppListByScienceAppIds(scienceAppIds);
	}
	
	public long[] getScienceAppCategoryIds(long scienceAppId) throws SystemException{
		return super.scienceAppCategoryLinkLocalService.getCategoryIdsByScienceAppId(scienceAppId);
	}
	
	public long[] getScienceAppCategoryIds(long scienceAppId, int start, int end) throws SystemException{
		return super.scienceAppCategoryLinkLocalService.getCategoryIdsByScienceAppId(scienceAppId, start, end);
	}
	
	public int countScienceAppCategories(long scienceAppId) throws SystemException{
		return super.scienceAppCategoryLinkLocalService.countCategoriesByScienceAppId(scienceAppId);
	}
	
	public void assignScienceAppToCategories(long scienceAppId, long[] categoryIds) throws SystemException{
		for( long categoryId : categoryIds ){
			this.assignScienceAppToCategory(scienceAppId, categoryId);
		}
	}
	
	public void assignScienceAppToCategory(long scienceAppId, long categoryId)  throws SystemException{
		super.scienceAppCategoryLinkLocalService.addScienceAppCategory(categoryId, scienceAppId);
	}
	
	public void assignManagersToScienceApp(long scienceAppId, long[] managerIds) throws SystemException{
		for( long managerId : managerIds ){
			this.assignManagerToScienceApp(scienceAppId, managerId);
		}
	}
	
	public void assignManagerToScienceApp(long scienceAppId, long managerId) throws SystemException{
		super.scienceAppManagerLocalService.addScienceAppManager(managerId, scienceAppId);
	}

	/**
	 * Get path of the executable binary file. 
	 * The full path can be obtained by adding base directory for science apps.
	 * 
	 * @param scienceAppId
	 * @return
	 * 		String of the path.
	 * @throws PortalException
	 * @throws SystemException
	 */
	public String getScienceAppBinPath(long scienceAppId) throws PortalException, SystemException{
		ScienceApp scienceApp = super.getScienceApp(scienceAppId);
		return scienceApp.getBinPath();
	}
	
	/**
	 * Get path of the source file. 
	 * The full path can be obtained by adding base directory for science apps.
	 * 
	 * @param scienceAppId
	 * @return
	 * 		String of the path.
	 * @throws PortalException
	 * @throws SystemException
	 */
	public String getScienceAppSrcPath(long scienceAppId) throws PortalException, SystemException{
		ScienceApp scienceApp = super.getScienceApp(scienceAppId);
		return scienceApp.getSrcPath();
	}
	
	/**
	 * Counts all science apps in the database.
	 * @return
	 * 		int - count
	 */
	public int countAllScienceApps() throws SystemException {
		return super.scienceAppPersistence.countAll();
	}
	
	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
			String searchTerm, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm, start, end);
	}
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.countScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm);
	}

	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
			String searchTerm, String stage, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm, stage, start, end);
	}
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
			String searchTerm, String stage){
		return ScienceAppFinderUtil.countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm, stage);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
			String searchTerm, String stage){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm, stage);
	}

	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
			String searchTerm, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm, targetLang, start, end);
	}
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
			String searchTerm, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm, targetLang);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
			String searchTerm, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
			String searchTerm, String stage, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm, stage, targetLang, start, end);
	}
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
			String searchTerm, String stage, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm, stage, targetLang);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
			String searchTerm, String stage, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm, stage, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsOnScreenName(
			String searchTerm, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenName(searchTerm, start, end);
	}
	
	public int countScienceAppsOnScreenName(
			String searchTerm){
		return ScienceAppFinderUtil.countScienceAppsOnScreenName(searchTerm);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnScreenName(
			String searchTerm){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenName(searchTerm);
	}

	public List<ScienceApp> retrieveScienceAppsOnScreenNameByStage(
			String searchTerm, String stage, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenNameByStage(searchTerm, stage, start, end);
	}
	
	public int countScienceAppsOnScreenNameByStage(
			String searchTerm, String stage){
		return ScienceAppFinderUtil.countScienceAppsOnScreenNameByStage(searchTerm, stage);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnScreenNameByStage(
			String searchTerm, String stage){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenNameByStage(searchTerm, stage);
	}

	public List<ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
			String searchTerm, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenNameByTarget(searchTerm, targetLang, start, end);
	}
	
	public int countScienceAppsOnScreenNameByTarget(
			String searchTerm, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsOnScreenNameByTarget(searchTerm, targetLang);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
			String searchTerm, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenNameByTarget(searchTerm, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
			String searchTerm, String stage, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenNameByStageTarget(searchTerm, stage, targetLang, start, end);
	}
	
	public int countScienceAppsOnScreenNameByStageTarget(
			String searchTerm, String stage, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsOnScreenNameByStageTarget(searchTerm, stage, targetLang);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
			String searchTerm, String stage, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsOnScreenNameByStageTarget(searchTerm, stage, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsOnAffiliationName(
			String searchTerm, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationName(searchTerm, start, end);
	}
	
	public int countScienceAppsOnAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.countScienceAppsOnAffiliationName(searchTerm);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationName(searchTerm);
	}

	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
			String searchTerm, String stage, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationNameByStage(searchTerm, stage, start, end);
	}
	
	public int countScienceAppsOnAffiliationNameByStage(
			String searchTerm, String stage){
		return ScienceAppFinderUtil.countScienceAppsOnAffiliationNameByStage(searchTerm, stage);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
			String searchTerm, String stage){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationNameByStage(searchTerm, stage);
	}

	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
			String searchTerm, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationNameByTarget(searchTerm, targetLang, start, end);
	}
	
	public int countScienceAppsOnAffiliationNameByTarget(
			String searchTerm, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsOnAffiliationNameByTarget(searchTerm, targetLang);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
			String searchTerm, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationNameByTarget(searchTerm, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
			String searchTerm, String stage, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationNameByStageTarget(searchTerm, stage, targetLang, start, end);
	}
	
	public int countScienceAppsOnAffiliationNameByStageTarget(
			String searchTerm, String stage, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsOnAffiliationNameByStageTarget(searchTerm, stage, targetLang);
	}
	
	public  List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
			String searchTerm, String stage, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsOnAffiliationNameByStageTarget(searchTerm, stage, targetLang);
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyId(long vocabularyId, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyId(vocabularyId, start, end);
	}
	
	public int countScienceAppsByVocabularyId(long vocabularyId){
		return ScienceAppFinderUtil.countScienceAppsByVocabularyId(vocabularyId);
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyId(long vocabularyId){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyId(vocabularyId);
	}

	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStage(long vocabularyId, String stage, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyIdStage(vocabularyId, stage, start, end);
	}
	
	public int countScienceAppsByVocabularyIdStage(long vocabularyId, String stage){
		return ScienceAppFinderUtil.countScienceAppsByVocabularyIdStage(vocabularyId, stage);
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStage(long vocabularyId, String stage){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyIdStage(vocabularyId, stage);
	}

	public List<ScienceApp> retrieveScienceAppsByVocabularyIdTarget(long vocabularyId, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyIdTarget(vocabularyId, targetLang, start, end);
	}
	
	public int countScienceAppsByVocabularyIdTarget(long vocabularyId, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsByVocabularyIdTarget(vocabularyId, targetLang);
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyIdTarget(long vocabularyId, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyIdTarget(vocabularyId, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(long vocabularyId, String stage, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyIdStageTarget(vocabularyId, stage, targetLang, start, end);
	}
	
	public int countScienceAppsByVocabularyIdStageTarget(long vocabularyId, String stage, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsByVocabularyIdStageTarget(vocabularyId, stage, targetLang);
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(long vocabularyId, String stage, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsByVocabularyIdStageTarget(vocabularyId, stage, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryId(long categoryId, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryId(categoryId, start, end);
	}
	
	public int countScienceAppsByCategoryId(long categoryId){
		return ScienceAppFinderUtil.countScienceAppsByCategoryId(categoryId);
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryId(long categoryId){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryId(categoryId);
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryIdStage(long categoryId, String stage, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryIdStage(categoryId, stage, start, end);
	}
	
	public int countScienceAppsByCategoryIdStage(long categoryId, String stage){
		return ScienceAppFinderUtil.countScienceAppsByCategoryIdStage(categoryId, stage);
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryIdStage(long categoryId, String stage){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryIdStage(categoryId, stage);
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryIdTarget(long categoryId, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryIdTarget(categoryId, targetLang, start, end);
	}
	
	public int countScienceAppsByCategoryIdTarget(long categoryId, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsByCategoryIdTarget(categoryId, targetLang);
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryIdTarget(long categoryId, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryIdTarget(categoryId, targetLang);
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(long categoryId, String stage, String targetLang, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryIdStageTarget(categoryId, stage, targetLang, start, end);
	}
	
	public int countScienceAppsByCategoryIdStageTarget(long categoryId, String stage, String targetLang){
		return ScienceAppFinderUtil.countScienceAppsByCategoryIdStageTarget(categoryId, stage, targetLang);
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(long categoryId, String stage, String targetLang){
		return ScienceAppFinderUtil.retrieveScienceAppsByCategoryIdStageTarget(categoryId, stage, targetLang);
	}

	/**
	 * For reserving data integration
	 *
	 * @param scienceAppId the science app id
	 * @throws SystemException the system exception
	 * @throws PortalException 
	 */
	protected void cleanIntegratedData(long scienceAppId) throws SystemException, PortalException{
		super.scienceAppInputPortsLocalService.deleteScienceAppInputPorts(scienceAppId);
		super.scienceAppOutputPortsLocalService.deleteScienceAppOutputPorts(scienceAppId);
		super.scienceAppCategoryLinkLocalService.removeByScienceAppId(scienceAppId);
		super.scienceAppManagerPersistence.removeByAppId(scienceAppId);
	}
	
	private List<ScienceApp> getScienceAppListByScienceAppIds(long[] scienceAppIds) throws PortalException, SystemException{
		List<ScienceApp> apps = new ArrayList<ScienceApp>();
		for(int i=0; i<scienceAppIds.length; i++){
			apps.add(this.getScienceApp(scienceAppIds[i]));
		}
		
		return apps;
	}

	public boolean existScienceAppPath(String targetPath) throws SystemException, IOException, InterruptedException{
		File dir = new File(targetPath);
		
		return dir.exists();
	}

	public void deleteScienceAppDir(String targetDir) throws SystemException, IOException, InterruptedException{
		this.executeCommand("rm -df "+targetDir);
	}
	
	public void makeScienceAppDir(String targetDir) throws SystemException, IOException, InterruptedException{
		File dir = new File(targetDir);
		if( dir.exists() ){
			this.deleteScienceAppDir(targetDir);
		}
		
		this.executeCommand("mkdir -p " + targetDir);
	}
	
	/***
	 * Save uploaded file to new location
	 * @param uploadedInputStream
	 * @return
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws SystemException 
	 */
	public File saveToScienceAppStorage(String targetDir, String fileName, InputStream uploadedInputStream) throws SystemException, IOException, InterruptedException {
		
		//Delete existed file first!
		if(this.existScienceAppPath(targetDir))
			this.executeCommand("rm -rf " + targetDir + "/*" );
		
		this.makeScienceAppDir(targetDir);
		
		String targetPath = targetDir + "/" + fileName;
		// Declare an output stream.
		File newFile = new File(targetPath);;
		OutputStream out = new FileOutputStream(newFile);
		// number of bytes read
		int read = 0;
		// 1024-byte buffer
		byte[] bytes = new byte[1024];
		
		// Read the file until no more bytes are read.
		while ((read = uploadedInputStream.read(bytes)) != -1) {
			// Write these bytes.
			out.write(bytes, 0, read);
		}
		// Flush it.
		out.flush();
		// Close it.
		out.close();
		
		// allow for write and execute
		//executeCommand("sudo chmod 777 " + path);
		return newFile;
	}
	
	/****
	 * Execute a given command
	 * @param command a given command
	 * @return install message
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	private void executeCommand(String command) throws SystemException, IOException, InterruptedException {
		String[] commandAndArgs = new String[]{ "/bin/sh", "-c", command};
		//System.out.println(commandAndArgs);
		// Get Runtime instance.
		String report = "";
		Runtime runTime = Runtime.getRuntime();
		// Declare a process.
		Process process = null;
		// Let's execute the command.
		process = runTime.exec(commandAndArgs);
		// Get any input stream.
		InputStream instd = process.getInputStream();
		// Let's get it through buffered reader.
		BufferedReader buf_reader = new BufferedReader(
					new InputStreamReader(instd));
		String temp = "";
		// System.out.println("new line executed command: " + command);
		while ((temp = buf_reader.readLine()) != null) {
				// System.out.println("temp: " + temp);
			report += temp + "\n";
		}
		// Let's close buffered reader
		buf_reader.close();

		// Get any error stream.
		InputStream stderr = process.getErrorStream();
		// Let's get it through buffered reader.
		BufferedReader buf_err_reader = new BufferedReader(
					new InputStreamReader(stderr));
		// Initialize a temporary variable.
		temp = "";
		// Until there's no more error message,
		while ((temp = buf_err_reader.readLine()) != null) {
				// Append a current error message to the error message
				// container.
			report += temp + "\n";
		}
			// Report an error.
		System.err.println(report);
			// Close buffered error reader.
		buf_err_reader.close();
		// Let's wait p0 for completion.
		process.waitFor();
	}

	/*****
	 * Unzip an uploaded file into a specified directory.
	 * @param strUnzipDirPath the directory into which unzipped files go.
	 * @param zipFile zip file 
	 * @return process output message
	 * @throws SystemException system exception
	 * @throws IOException io exception 
	 * @throws InterruptedException interrupted exception
	 */
	public void unzipScienceAppZipFile(String sourcePath, String targetDir) throws SystemException, IOException, InterruptedException {
		// Zip file name
		if(this.existScienceAppPath(targetDir))
			this.deleteScienceAppDir(targetDir);
		
		File zipFile = new File(sourcePath);
System.out.println("src file name: "+ zipFile.getName());
System.out.println("src file size bytes:" + zipFile.length());
System.out.println("src file name:" + zipFile.getName());
			
		// make directory first
		this.makeScienceAppDir(targetDir);
			
		String zipFileName = zipFile.getName();
		String command = "";
		if(zipFileName.endsWith("gz")){
			command = "tar -xvfz " + sourcePath + " " + targetDir;
		}else if(zipFileName.endsWith("tar")){
			command = "tar -xvf " + sourcePath + " " + targetDir;
		}else if(zipFileName.endsWith("zip")){
			command = "unzip -o " + sourcePath + " -d " + targetDir;
		}else{
			throw new SystemException("file extension not ending with *.gz or *.zip");
		}
System.out.println(command);
		//execute unzipping
		this.executeCommand(command);
	}

	/****
	 * Create a directory
	 * @param givenPath a given path
	 * @return install message
	 * @throws IOException io exception
	 * @throws InterruptedException interrupted exception
	 * @throws SystemException system exception
	 */
	/*
	public String makeLocalDir(String givenPath) throws IOException, InterruptedException, SystemException {
		String res = "";
		// make the command
		String command = "sudo mkdir -p " + givenPath;
	System.out.println(givenPath);
		String[] commandAndArgs = new String[]{ "/bin/sh", "-c", command};
		// Get Runtime instance.
		Runtime rt = Runtime.getRuntime();
		// Declare a process.
		Process p0 = null;
		// Let's execute the command.
		p0 = rt.exec(commandAndArgs);
		// Get any input stream.
		InputStream instd = p0.getInputStream();
		// Let's get it through buffered reader.
		BufferedReader buf_reader = new BufferedReader(
				new InputStreamReader(instd));
		String temp = "";
		// wait for the output
		// System.out.println("new line executed command: " + command);
		while ((temp = buf_reader.readLine()) != null) {
				// System.out.println("temp: " + temp);
				res += temp + "\n";
		}
		// Let's close buffered reader
		buf_reader.close();
	
		// Get any error stream.
		InputStream errstd = p0.getErrorStream();
		// Let's get it through buffered reader.
		BufferedReader buf_err_reader = new BufferedReader(
					new InputStreamReader(errstd));
		// Initialize a temporary variable.
		temp = "";
		// Until there's no more error message,
		while ((temp = buf_err_reader.readLine()) != null) {
			// Append a current error message to the error message
			// container.
			return res;
		}
		// Close buffered error reader.
		buf_err_reader.close();
		// Let's wait p0 for completion.
		p0.waitFor();
		
		// allow for write
		res += executeCommand("sudo chmod 777 " + givenPath);
		
		return res;
	}
	*/
}