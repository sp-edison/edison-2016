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

package org.kisti.edison.science.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.science.NoSuchScienceAppException;
import org.kisti.edison.science.NoSuchScienceAppInputPortsException;
import org.kisti.edison.science.NoSuchScienceAppOutputPortsException;
import org.kisti.edison.science.Exception.ScienceAppException;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.ScienceAppCategoryLink;
import org.kisti.edison.science.model.ScienceAppDescription;
import org.kisti.edison.science.model.ScienceAppManager;
import org.kisti.edison.science.model.impl.ScienceAppImpl;
import org.kisti.edison.science.service.ScienceAppCategoryLinkLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppDescriptionLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppManagerLocalServiceUtil;
import org.kisti.edison.science.service.base.ScienceAppLocalServiceBaseImpl;
import org.kisti.edison.science.service.constants.ScienceAppConstants;
import org.kisti.edison.science.service.persistence.ScienceAppFinderUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonPropsUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

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
 * @author EDISON
 * @see org.kisti.edison.science.service.base.ScienceAppLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.ScienceAppLocalServiceUtil
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
		this.cleanIntegratedData(scienceAppId);
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
	public List<ScienceApp> getScienceAppListByStatus(int status) throws SystemException{
		return super.scienceAppPersistence.findByStatus(status);
	}
	
	public List<ScienceApp> getScienceAppListByStage(String stage) throws SystemException{
		return super.scienceAppPersistence.findByStage(stage);
	}
	
	public List<ScienceApp> getScienceAppListByAuthorIdStatus(long authorId, int appStatus) throws SystemException{
		return super.scienceAppPersistence.findByAuthorIdStatus(authorId, appStatus);
	}
	
	public List<ScienceApp> getScienceAppListByAuthorIdStatus(long authorId, int appStatus, int start, int end) throws SystemException{
		return super.scienceAppPersistence.findByAuthorIdStatus(authorId, appStatus, start, end);
	}
	
	public List<ScienceApp> getScienceAppListByAuthorIdAppType(long authorId, String appType) throws SystemException {
		return super.scienceAppPersistence.findByAuthorIdAppType(authorId, appType);
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
	
	public int countScienceAppsByCategoryId(long categoryId) throws SystemException{
		return super.scienceAppCategoryLinkLocalService.countScienceAppsByCategoryId(categoryId);
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
	
	public List<ScienceApp> retrieveScienceAppOnNameTitleScreenNameAffiliationName(
			String searchTerm, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppOnNameTitleScreenNameAffiliationName(searchTerm, start, end);
	}
	
	public int countScienceAppOnNameTitleScreenNameAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.countScienceAppOnNameTitleScreenNameAffiliationName(searchTerm);
	}
	
	public  List<ScienceApp> retrieveAllScienceAppOnNameTitleScreenNameAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.retrieveAllScienceAppOnNameTitleScreenNameAffiliationName(searchTerm);
	}
	
	public List<ScienceApp> retrieveScienceAppOnScreenName(
			String searchTerm, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppOnScreenName(searchTerm, start, end);
	}
	
	public int countScienceAppOnScreenName(
			String searchTerm){
		return ScienceAppFinderUtil.countScienceAppOnScreenName(searchTerm);
	}
	
	public  List<ScienceApp> retrieveAllScienceAppOnScreenName(
			String searchTerm){
		return ScienceAppFinderUtil.retrieveAllScienceAppOnScreenName(searchTerm);
	}

	public List<ScienceApp> retrieveScienceAppOnAffiliationName(
			String searchTerm, int start, int end){
		return ScienceAppFinderUtil.retrieveScienceAppOnAffiliationName(searchTerm, start, end);
	}
	
	public int countScienceAppOnAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.countScienceAppOnAffiliationName(searchTerm);
	}
	
	public  List<ScienceApp> retrieveAllScienceAppOnAffiliationName(
			String searchTerm){
		return ScienceAppFinderUtil.retrieveAllScienceAppOnAffiliationName(searchTerm);
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
		File newFile = new File(targetPath);
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
	
	/*****
	 * Unzip an uploaded file into a specified directory.
	 * @param strUnzipDirPath the directory into which unzipped files go.
	 * @param zipFile zip file 
	 * @return process output message
	 * @throws SystemException system exception
	 * @throws IOException io exception 
	 * @throws InterruptedException interrupted exception
	 */
	public void unzipScienceAppZipFile(String sourceFile, String targetDir) throws SystemException, IOException, InterruptedException {
		// Zip file name
		if(this.existScienceAppPath(targetDir))
			this.deleteScienceAppDir(targetDir);
		
		File zipFile = new File(sourceFile);
			
		// make directory first
		this.makeScienceAppDir(targetDir);
			
		String zipFileName = zipFile.getName().trim();
		String command = "";
		if(zipFileName.endsWith("gz")){
			command = "tar -xvfz " + sourceFile + " " + targetDir;
		}else if(zipFileName.endsWith("tar")){
			command = "tar -xvf " + sourceFile + " " + targetDir;
		}else if(zipFileName.endsWith("zip")){
			command = "unzip -o " + sourceFile + " -d " + targetDir;
		}else{
			throw new SystemException("file extension not ending with *.gz or *.zip");
		}
		
		//execute unzipping
		this.executeCommand(command);
		
		this.executeCommand("chmod 755 "+targetDir+File.separator+"*");
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
		BufferedReader buf_reader = new BufferedReader(new InputStreamReader(instd));
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
		BufferedReader buf_err_reader = new BufferedReader(new InputStreamReader(stderr));
		// Initialize a temporary variable.
		temp = "";
		// Until there's no more error message,
		while ((temp = buf_err_reader.readLine()) != null) {
				// Append a current error message to the error message
				// container.
			report += temp + "\n";
		}
			// Close buffered error reader.
		buf_err_reader.close();
		// Let's wait p0 for completion.
		process.waitFor();
	}
	/**********************************   ADD GPLUS SERVICE 	 ******************************/
	
  public List<ScienceApp> getScienceAppListByCategoryId(long categoryId, Locale locale)
      throws SystemException, PortalException{
    long[] scienceAppIds = super.scienceAppCategoryLinkLocalService
        .getScienceAppIdsByCategoryId(categoryId);
    return this.getScienceAppListByScienceAppIdsAndLocale(scienceAppIds, locale);
  }

  public List<ScienceApp> getScienceAppListByCategoryId(long categoryId, Locale locale, int start, int end) 
      throws SystemException, PortalException{
    long[] scienceAppIds = super.scienceAppCategoryLinkLocalService
        .getScienceAppIdsByCategoryId(categoryId);
    return this.getScienceAppListByScienceAppIdsAndLocale(scienceAppIds, locale, start, end);
  }

  public List<ScienceApp> getScienceAppListByScienceAppIdsAndLocale(long[] scienceAppIds, Locale locale)
      throws PortalException, SystemException{
    return getScienceAppListByScienceAppIdsAndLocale(scienceAppIds, locale, -1, -1);
  }
  
  public List<Map<String, Object>> getLanguageSpecificAssetCategories(List<AssetCategory> categories, long parentCategoryId, Locale locale){
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("parentCategoryId", parentCategoryId);
    params.put("targetLanguage", LocaleUtil.toLanguageId(locale));
    Map<Long, Long> targetLanguageCategories = scienceAppFinder.getLanguageSpecificCategories(params);
    List<Map<String, Object>> resultCategories = new ArrayList<Map<String, Object>>();
    for(AssetCategory category : categories){
      long id = category.getCategoryId();
      if(targetLanguageCategories.containsKey(id)){
        Map<String, Object> categoryMap = category.getModelAttributes();
        categoryMap.put("appCnt", targetLanguageCategories.get(id));
        categoryMap.put("data", new HashMap<String, Object>(categoryMap));
        categoryMap.put("id", category.getCategoryId());
        categoryMap.put("text", category.getTitle(locale));
        if(category.getParentCategoryId() == 0){
          categoryMap.put("type", "category");
        }else{
          categoryMap.put("type", "subCategory");
        }
        resultCategories.add(categoryMap);
      }
    }
    return resultCategories;
  }
  
  @SuppressWarnings("unchecked")
  public List<ScienceApp> getScienceAppListByScienceAppIdsAndLocale(
      long[] scienceAppIds, Locale locale, int start, int end)
      throws PortalException, SystemException{
    DynamicQuery query = DynamicQueryFactoryUtil.forClass(ScienceApp.class);
    query.add(RestrictionsFactoryUtil.in("scienceAppId", ArrayUtils.toObject(scienceAppIds)));
    query.add(RestrictionsFactoryUtil.like("targetLanguage", "%" + LocaleUtil.toLanguageId(locale) + "%"));
    query.add(RestrictionsFactoryUtil.eq("status", 1901004));
    query.addOrder(OrderFactoryUtil.desc("createDate"));
    query.addOrder(OrderFactoryUtil.desc("version"));
    return (List<ScienceApp>) super.getScienceAppLocalService().dynamicQuery(query, start, end);
  }
	
	/**
	 * 
	 * @param appName
	 * @param appVersion
	 * @param userId
	 * @param sc
	 * @return
	 * @throws ScienceAppException 
	 * @throws SystemException 
	 */
	public ScienceApp createScienceApp(ServiceContext sc, Map params) throws SystemException{
		ScienceApp newApp = null;
		long newAppId = CounterLocalServiceUtil.increment(ScienceApp.class.getName());
		newApp = super.scienceAppPersistence.create(newAppId);
		
		newApp.setGroupId(sc.getScopeGroupId());
		newApp.setCompanyId(sc.getCompanyId());
		newApp.setUserId(sc.getUserId());
		newApp.setCreateDate(new Date());
		newApp.setModifiedDate(new Date());
		newApp.setName(CustomUtil.strNull(params.get("name")));
		newApp.setVersion(CustomUtil.strNull(params.get("version")));
		newApp.setTitleMap(CustomUtil.getLocalizationNotSetLocaleMap(params,"title"));
//		newApp.setPreviousVersionId(previousVersionId);
		newApp.setAuthorId(sc.getUserId());
		newApp.setStage(ScienceAppConstants.EMPTY);
		newApp.setRecentModifierId(sc.getUserId());
		newApp.setLicense(CustomUtil.strNull(params.get("license")));
		
		if(CustomUtil.strNull(params.get("targetLanguage")).equals("")){
			String localeStr="";
			for(Locale locale:LanguageUtil.getAvailableLocales()){
				if(localeStr.equals("")){
					localeStr = LocaleUtil.toLanguageId(locale);
				}else{
					localeStr +=","+LocaleUtil.toLanguageId(locale);
				}
			}
			newApp.setTargetLanguage(localeStr);
		}else{
			newApp.setTargetLanguage(CustomUtil.strNull(params.get("targetLanguage")));
		}
		
		
		newApp.setStatus(1901001);
		
		//확인
		newApp.setDevelopersMap(CustomUtil.getLocalizationNotSetLocaleMap(params,"developers"));
		newApp.setSwTest(GetterUtil.getBoolean(params.get("swTest"),false));
		
		
		
		try{
			//Description 등록
			long descriptionId = CounterLocalServiceUtil.increment(ScienceAppDescription.class.getName());
			ScienceAppDescription scienceAppDescription = ScienceAppDescriptionLocalServiceUtil.createScienceAppDescription(descriptionId);
			Locale[] locales = LanguageUtil.getAvailableLocales();
			for(Locale aLocale : locales){
				String languageId = LocaleUtil.toLanguageId(aLocale);
				String description = CustomUtil.strNull(params.get("description_"+languageId));
				if(!description.equals("")){
					scienceAppDescription.setContent(description, aLocale);
				}
			}
			scienceAppDescription.setInsertDt(new Date());
			scienceAppDescription.setInsertId(sc.getUserId());
			ScienceAppDescriptionLocalServiceUtil.updateScienceAppDescription(scienceAppDescription);
			
			
			newApp.setDescriptionId(descriptionId);
			
			
			UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(sc.getLiferayPortletRequest());
			//icon 등록
			String appIconStr = CustomUtil.strNull(upload.getFileName("app_icon"),"");
			if(!appIconStr.equals("")){ //아이콘이 있는경우
				List<FileEntry> appIcons = EdisonFileUtil.insertEdisonFile(
												sc.getLiferayPortletRequest(), upload,
												sc.getUserId(), sc.getScopeGroupId(), 
												"", String.valueOf(newAppId), "app_icon", EdisonFileConstants.SCIENCE_APPS
												);
				FileEntry appEntry = appIcons.get(0);
				newApp.setIconId(appEntry.getFileEntryId());
			}
			
			
			//Manual 등록
			for(Locale locale:locales){
				String languageId = LocaleUtil.toLanguageId(locale);
				String fileParamsNm = "app_manual"+languageId;
				String manualStr = CustomUtil.strNull(upload.getFileName(fileParamsNm),"");
				
				if(!manualStr.equals("")){
					List<FileEntry> manuals = EdisonFileUtil.insertEdisonFile(
													sc.getLiferayPortletRequest(), upload,
													sc.getUserId(), sc.getScopeGroupId(), 
													"", String.valueOf(newAppId), fileParamsNm, EdisonFileConstants.SCIENCE_APPS
													);
					FileEntry manualsEntry = manuals.get(0);
					newApp.setManualId(String.valueOf(manualsEntry.getFileEntryId()), locale);
				}else{
					newApp.setManualId("0", locale);
				}
			}
			newApp.setProjectCategoryId(0);
			
			
			//카테고리 등록
			List<String[]> categoryList = new ArrayList<String[]>(); 
			if(params.get("childrenCategoryCheckbox") instanceof String[]){
				String[] childrenCategoryArray = (String[]) params.get("childrenCategoryCheckbox");
				for(String childrenCategory:childrenCategoryArray){
					String[] childrenCategoryValue = childrenCategory.split("_");
					categoryList.add(childrenCategoryValue);
				}
			}else if(params.get("childrenCategoryCheckbox") instanceof String){
				String[] childrenCategoryValue = CustomUtil.strNull(params.get("childrenCategoryCheckbox")).split("_");
				categoryList.add(childrenCategoryValue);
			}
			
			for(String[] categoryArray:categoryList){
				long parentCategoryId = GetterUtil.getLong(categoryArray[0],0l);
				long categoryId = GetterUtil.getLong(categoryArray[1],0l);
				ScienceAppCategoryLink appCategory = ScienceAppCategoryLinkLocalServiceUtil.addScienceAppCategory(categoryId, newAppId);
				appCategory.setGroupId(sc.getScopeGroupId());
				appCategory.setParentCategoryId(parentCategoryId);
				appCategory.setCompanyId(sc.getCompanyId());
				appCategory.setUserId(sc.getUserId());
				appCategory.setCreateDate(new Date());
				ScienceAppCategoryLinkLocalServiceUtil.update(appCategory);
			}
			
		}catch(Exception e){
			throw new SystemException(e);
		}
		scienceAppLocalService.updateScienceApp(newApp);
		
		return newApp;
	}
	
	public void updateScienceApp(ServiceContext sc, Map params, long scienceAppId) throws NoSuchScienceAppException, SystemException{
		ScienceApp scienceApp = super.scienceAppPersistence.findByPrimaryKey(scienceAppId);
		scienceApp.setModifiedDate(new Date());
		scienceApp.setVersion(CustomUtil.strNull(params.get("version")));
		scienceApp.setTitleMap(CustomUtil.getLocalizationNotSetLocaleMap(params,"title"));
		String duplicationCheck = CustomUtil.strNull(params.get("duplicationCheck"));
		if(!duplicationCheck.equals("")){
			scienceApp.setPreviousVersionId(GetterUtil.getLong(params.get("previousVersion"),0));
		}
		scienceApp.setRecentModifierId(sc.getUserId());
		scienceApp.setLicense(CustomUtil.strNull(params.get("license")));
		
		if(CustomUtil.strNull(params.get("targetLanguage")).equals("")){
			String localeStr="";
			for(Locale locale:LanguageUtil.getAvailableLocales()){
				if(localeStr.equals("")){
					localeStr = LocaleUtil.toLanguageId(locale);
				}else{
					localeStr +=","+LocaleUtil.toLanguageId(locale);
				}
			}
			scienceApp.setTargetLanguage(localeStr);
		}else{
			scienceApp.setTargetLanguage(CustomUtil.strNull(params.get("targetLanguage")));
		}
		
		scienceApp.setDevelopersMap(CustomUtil.getLocalizationNotSetLocaleMap(params,"developers"));
		
		try{
			//Description 수정
			ScienceAppDescription scienceAppDescription = ScienceAppDescriptionLocalServiceUtil.getScienceAppDescription(scienceApp.getDescriptionId());
			Locale[] locales = LanguageUtil.getAvailableLocales();
			for(Locale aLocale : locales){
				String languageId = LocaleUtil.toLanguageId(aLocale);
				String description = CustomUtil.strNull(params.get("description_"+languageId));
				if(!description.equals("")){
					scienceAppDescription.setContent(description, aLocale);
				}
			}
			scienceAppDescription.setUpdateDt(new Date());
			scienceAppDescription.setUpdateId(sc.getUserId());
			ScienceAppDescriptionLocalServiceUtil.updateScienceAppDescription(scienceAppDescription);
			
			
			UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(sc.getLiferayPortletRequest());
			//icon 등록
			String appIconStr = CustomUtil.strNull(upload.getFileName("app_icon"),"");
			if(!appIconStr.equals("")){ //아이콘이 있는경우
				long iconId = scienceApp.getIconId();
				if(iconId!=0){
					//기존 파일 삭제
					DLFileEntryLocalServiceUtil.deleteDLFileEntry(iconId);
				}
				
				//카테고리 별로 APP 이 관리 되기 때문에 ScienceApp 등록시 등록한 분야의 GROUPID 사용
				List<FileEntry> appIcons = EdisonFileUtil.insertEdisonFile(
												sc.getLiferayPortletRequest(), upload,
												sc.getUserId(),
												scienceApp.getGroupId(),
												"", String.valueOf(scienceAppId), "app_icon", EdisonFileConstants.SCIENCE_APPS
												);
				FileEntry appEntry = appIcons.get(0);
				scienceApp.setIconId(appEntry.getFileEntryId());
			}
			
			//Manual 등록
			for(Locale locale:locales){
				String languageId = LocaleUtil.toLanguageId(locale);
				String fileParamsNm = "app_manual"+languageId;
				String manualStr = CustomUtil.strNull(upload.getFileName(fileParamsNm),"");
				
				if(!manualStr.equals("")){ //Manual 있는경우
					long manualId = GetterUtil.getLong(scienceApp.getManualId(locale),0);
					if(manualId!=0){
						//기존 파일 삭제
						DLFileEntryLocalServiceUtil.deleteDLFileEntry(manualId);
					}
					
					List<FileEntry> manuals = EdisonFileUtil.insertEdisonFile(
													sc.getLiferayPortletRequest(), upload,
													sc.getUserId(), 
													scienceApp.getGroupId(), 
													"", String.valueOf(scienceAppId), fileParamsNm, EdisonFileConstants.SCIENCE_APPS
													);
					FileEntry manualsEntry = manuals.get(0);
					scienceApp.setManualId(String.valueOf(manualsEntry.getFileEntryId()), locale);
				}else{
					long manualId = GetterUtil.getLong(scienceApp.getManualId(locale),0);
					if(manualId==0){
						scienceApp.setManualId("0", locale);
					}
				}
			}
			
			//기존 카테고리 삭제
			List<ScienceAppCategoryLink> categoryDataList =  ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategorysByscienceAppId(scienceAppId);
			for(ScienceAppCategoryLink scienceAppCategoryLink : categoryDataList){
				ScienceAppCategoryLinkLocalServiceUtil.deleteScienceAppCategoryLink(scienceAppCategoryLink);
			}
			
			//카테고리 등록
			List<String[]> categoryList = new ArrayList<String[]>(); 
			if(params.get("childrenCategoryCheckbox") instanceof String[]){
				String[] childrenCategoryArray = (String[]) params.get("childrenCategoryCheckbox");
				for(String childrenCategory:childrenCategoryArray){
					String[] childrenCategoryValue = childrenCategory.split("_");
					categoryList.add(childrenCategoryValue);
				}
			}else if(params.get("childrenCategoryCheckbox") instanceof String){
				String[] childrenCategoryValue = CustomUtil.strNull(params.get("childrenCategoryCheckbox")).split("_");
				categoryList.add(childrenCategoryValue);
			}
			
			for(String[] categoryArray:categoryList){
				long parentCategoryId = GetterUtil.getLong(categoryArray[0],0l);
				long categoryId = GetterUtil.getLong(categoryArray[1],0l);
				ScienceAppCategoryLink appCategory = ScienceAppCategoryLinkLocalServiceUtil.addScienceAppCategory(categoryId, scienceAppId);
				appCategory.setGroupId(sc.getScopeGroupId());
				appCategory.setParentCategoryId(parentCategoryId);
				appCategory.setCompanyId(sc.getCompanyId());
				appCategory.setUserId(sc.getUserId());
				appCategory.setCreateDate(new Date());
				ScienceAppCategoryLinkLocalServiceUtil.update(appCategory);
			}
			
			
		}catch(Exception e){
			throw new SystemException(e);
		}
		
		scienceAppLocalService.updateScienceApp(scienceApp);
	}
	
	public int countScienceApp(long companyGroupId, long groupId,long categoryId,Locale locale, Map<String,Object> searchParam) throws SystemException, PortalException{
		Map<String,Object> search = settingScienceAppParameter(companyGroupId, groupId, categoryId, locale, searchParam, 0, 0);
		return scienceAppFinder.countScienceApp(search);
	}
	
	/**
	 * 카테고리에 속하지 않은 APP 목록 조회(EX_EDITOR)
	 * @param groupId
	 * @param locale
	 * @param searchParam
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<Map<String, Object>> retrieveListScienceEditorApp(long companyId,Locale locale, Map<String,Object> searchParam) throws PortalException, SystemException{
		
		String targetLanguage = LocaleUtil.toLanguageId(locale);
		searchParam.put("targetLanguage", targetLanguage);
		searchParam.put("companyId", companyId);
		
		//User 확장 필드 조회
		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
		ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY);
		searchParam.put("columnId", column.getColumnId());
		
		
		//전체 검색 및 기관 검색이 있을 경우
		String searchOption = CustomUtil.strNull(searchParam.get("searchOption"));
		
		if(!searchOption.equals("")){
			searchParam.put(searchOption, "Y");
				
			if(StringUtil.equalsIgnoreCase(searchOption, "APP_MANAGER_SEARCH_ALL")){
				String searchValue = CustomUtil.strNull(searchParam.get("searchValue"));
				String searchOrgCodeStr = "";
				//공통코드에서 Like 조회
				List<Map<String, String>> commonCodeList = EdisonExpndoUtil.getCodeListByUpCode(1501, locale);
				for(Map<String,String> codeMap : commonCodeList){
					String codeName = codeMap.get(EdisonExpando.CDNM);
					if(codeName.indexOf(searchValue)>-1){
						String codeValue = codeMap.get(EdisonExpando.CD);
						
						if(searchOrgCodeStr.equals("")){
							searchOrgCodeStr += codeValue;
						}else{
							searchOrgCodeStr += ","+codeValue;
						}
					}
				}
				
				if(searchOrgCodeStr.equals("")){
					searchParam.put("searchOrgCode", searchValue);
				}else{
					long[] searchOrgCode = StringUtil.split(searchOrgCodeStr,0l);
					searchParam.put("searchOrgCode", searchOrgCode);
				}
				
			}
		}
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		try{
			List<ScienceApp> scienceAppList = scienceAppFinder.retrieveListScienceEditorApp(searchParam);
			for(ScienceApp scienceApp : scienceAppList){
				Map<String, Object> resultRow = new HashMap<String, Object>();
				User user = UserLocalServiceUtil.getUser(scienceApp.getAuthorId());
				
				resultRow.put("scienceAppId", scienceApp.getScienceAppId());
			    resultRow.put("createDate", scienceApp.getCreateDate());
			    resultRow.put("name", scienceApp.getName());
			    resultRow.put("version", scienceApp.getVersion());
			    resultRow.put("title", scienceApp.getTitle(locale));
			    resultRow.put("status", scienceApp.getStatus());
			    resultRow.put("modifiedDate", CustomUtil.StringToDateFormat(CustomUtil.strNull(scienceApp.getModifiedDate()), "yyyy-MM-dd HH:mm:ss"));
			    resultRow.put("developers", StringUtil.split(scienceApp.getDevelopers(locale), StringPool.NEW_LINE));
			    resultRow.put("appType", scienceApp.getAppType());
			    resultRow.put("editorType", scienceApp.getEditorType());
			    
			    resultRow.put("firstName", user.getFirstName());
			    resultRow.put("screenName", user.getScreenName());
			    resultRow.put("userId", user.getUserId());
			    
			    long classPK = GetterUtil.getLong(user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY),0);
				String affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(classPK, EdisonExpando.CDNM, locale);
				resultRow.put("affiliation", affiliation);
				
				returnList.add(resultRow);
			}
		}catch(Exception e){
			throw new SystemException(e);
		}
		
		
		return returnList;
	}
	
	/**
	 * ScienceApp List 조회
	 * @param companyGroupId
	 * @param groupId
	 * @param categoryId - 0일 경우 groupId를 통하여 전체 카테고리를 조회
	 * @param locale
	 * @param searchParam - 조회할 parameter Map
	 * @param begin - 시작 0 LIMIT를 사용
	 * @param end
	 * @param widthFile - 목록에서 파일이 필요 할 경우 true
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<Map<String, Object>> retrieveListScienceApp(long companyGroupId, long groupId, long categoryId, Locale locale, Map<String,Object> searchParam,int begin, int end, boolean widthFile) throws PortalException, SystemException{
		
		Map<String,Object> search = settingScienceAppParameter(companyGroupId, groupId, categoryId, locale, searchParam, begin, end);
		List<Object[]> scienceAppList = scienceAppFinder.retrieveListScienceApp(search);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try{
			for (int i = 0; i < scienceAppList.size(); i++) {
				Object[] resultArray = scienceAppList.get(i);
				ScienceAppCategoryLink sAppCategoryLink = (ScienceAppCategoryLink) resultArray[0];
				ScienceApp scienceApp = (ScienceApp) resultArray[1];
				User user = UserLocalServiceUtil.getUser(scienceApp.getAuthorId());
				Map<String, Object> resultRow = getScienceAppMap(locale, sAppCategoryLink, scienceApp, user);

				long classPK = GetterUtil.getLong(user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY),0);
				String affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(classPK, EdisonExpando.CDNM, locale);
				resultRow.put("affiliation", affiliation);
				
				if(widthFile){
					//파일 - icon
					if(scienceApp.getIconId()!=0){
						resultRow.put("iconId", scienceApp.getIconId());
						DLFileEntry iconDl =  DLFileEntryLocalServiceUtil.getDLFileEntry(scienceApp.getIconId());
						resultRow.put("iconRepositoryId", iconDl.getRepositoryId());
						resultRow.put("iconUuid", iconDl.getUuid());
						resultRow.put("iconTitle", iconDl.getTitle());
					}
					
					//메뉴얼
					long manualId = GetterUtil.getLong(scienceApp.getManualId(locale),0l);
					if(manualId !=0){
						resultRow.put("manualId", manualId);
						DLFileEntry manualDl =DLFileEntryLocalServiceUtil.getDLFileEntry(manualId);
						resultRow.put("manualRepositoryId", manualDl.getRepositoryId());
						resultRow.put("manualUuid", manualDl.getUuid());
						resultRow.put("manualTitle", manualDl.getTitle());
					}
				}
				
				
				returnList.add(resultRow);
			}
		}catch(Exception e){
			throw new SystemException(e);
		}
		
		return returnList;
	}
	
	
	public Map<String,Object> getScienceAppReturnObject(long scienceAppId,Locale locale) throws PortalException, SystemException, ParseException{
		Map<String,Object> returnMap = new HashMap<String,Object>();
		ScienceApp scienceApp =  super.getScienceApp(scienceAppId);
		
		returnMap.put("scienceAppId", scienceApp.getScienceAppId());
		returnMap.put("name", scienceApp.getName());
		returnMap.put("version", scienceApp.getVersion());
		returnMap.put("title", scienceApp.getTitle());
		returnMap.put("currentTitle", scienceApp.getTitle(locale));
		returnMap.put("swTest", scienceApp.getSwTest());
		returnMap.put("targetLanguage", scienceApp.getTargetLanguage());
		returnMap.put("license", scienceApp.getLicense());
		returnMap.put("groupId", scienceApp.getGroupId());
		returnMap.put("authorId", scienceApp.getAuthorId());
		returnMap.put("srcFileName", scienceApp.getSrcFileName());
		returnMap.put("openLevel", scienceApp.getOpenLevel());
		returnMap.put("status", scienceApp.getStatus());
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZoneUtil.getDefault());
		returnMap.put("createDate", df.format(scienceApp.getCreateDate()));
		returnMap.put("descriptionId", scienceApp.getDescriptionId());
		
		//프로젝트
		boolean project = false;
		if(scienceApp.getProjectCategoryId()!=0){
			project = true;
		}
		
		returnMap.put("project", project);
		
		//카테고리 & 프로젝트
		List<ScienceAppCategoryLink> categoryList = ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategorysByscienceAppId(scienceAppId);
		
		String parentCategory = "";
		String childrenCategory = "";
		for(ScienceAppCategoryLink categoryLink: categoryList){
			if(childrenCategory.equals("")){
				childrenCategory += categoryLink.getParentCategoryId()+"_"+categoryLink.getCategoryId();
			}else{
				childrenCategory += ","+categoryLink.getParentCategoryId()+"_"+categoryLink.getCategoryId();
			}
			
			if(parentCategory.equals("")){
				parentCategory += categoryLink.getParentCategoryId();
			}else{
				parentCategory += ","+categoryLink.getParentCategoryId();
			}
		}
		
		returnMap.put("childrenCategory", childrenCategory);
		returnMap.put("parentCategory", parentCategory);
		
		
		//User 정보 조회
		User appUser = UserLocalServiceUtil.getUser(scienceApp.getAuthorId());
		returnMap.put("userId", appUser.getUserId());
		returnMap.put("userName", appUser.getFirstName());
		returnMap.put("userScreenName", appUser.getScreenName());
		
		long classPK = GetterUtil.getLong(appUser.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY),0);
		String affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(classPK, EdisonExpando.CDNM, locale);
		returnMap.put("affiliation", affiliation);
		
		returnMap.put("developers", StringUtil.split(scienceApp.getDevelopers(locale), StringPool.NEW_LINE));
		returnMap.put("developersTextArea",scienceApp.getDevelopers());

		//파일 - icon
		if(scienceApp.getIconId()!=0){
			returnMap.put("iconId", scienceApp.getIconId());
			DLFileEntry iconDl =  DLFileEntryLocalServiceUtil.getDLFileEntry(scienceApp.getIconId());
			returnMap.put("iconRepositoryId", iconDl.getRepositoryId());
			returnMap.put("iconUuid", iconDl.getUuid());
			returnMap.put("iconTitle", iconDl.getTitle());
		}
		
		//메뉴얼
		for(Locale aLocale:LanguageUtil.getAvailableLocales()){
			long manualId = GetterUtil.getLong(scienceApp.getManualId(aLocale),0l);
			String languageId = LocaleUtil.toLanguageId(aLocale);
			if(manualId!=0){
				returnMap.put("manualId_"+languageId, manualId);
				DLFileEntry manualDl =DLFileEntryLocalServiceUtil.getDLFileEntry(manualId);
				returnMap.put("manualRepositoryId_"+languageId, manualDl.getRepositoryId());
				returnMap.put("manualUuid_"+languageId, 		manualDl.getUuid());
				returnMap.put("manualTitle_"+languageId, 		manualDl.getTitle());
			}
		}
		
		returnMap.put("manualIds", scienceApp.getManualId());

		//소스파일
		long srcFileId = Long.parseLong(CustomUtil.strNull(scienceApp.getSrcFileName(),"0"));
		if( srcFileId != 0){
			returnMap.put("srcFileId", srcFileId);
			DLFileEntry srcFileDl =  DLFileEntryLocalServiceUtil.getDLFileEntry(srcFileId);
			returnMap.put("srcFileTitle", srcFileDl.getTitle());
		}
		
		ScienceAppDescription description = ScienceAppDescriptionLocalServiceUtil.getScienceAppDescription(scienceApp.getDescriptionId()); 
		
		Locale[] availableLocales = LanguageUtil.getAvailableLocales();
		String selectLocaleId = LocaleUtil.toLanguageId(locale);
		Map<String, Object> descriptionMap = new HashMap<String, Object>();
		for(Locale alocale : availableLocales){
			String languageId = LocaleUtil.toLanguageId(alocale);
			descriptionMap.put("description_"+languageId, description.getContent(alocale));
		}
		returnMap.put("description", descriptionMap);
		returnMap.put("selectLocaleId", selectLocaleId);

		
		//ScienceApp 관리자
		List<ScienceAppManager> mList = ScienceAppManagerLocalServiceUtil.getManagersByScienceAppId(scienceAppId);
		List<Map<String,Object>> managerList = new ArrayList<Map<String,Object>>();
		for(ScienceAppManager manager:mList){
			Map<String,Object> managerMap = new HashMap<String,Object>();
			User managerUser = UserLocalServiceUtil.getUser(manager.getUserId());
			
			managerMap.put("screenName", managerUser.getScreenName());
			managerMap.put("firstName", managerUser.getFirstName());
			managerMap.put("email", managerUser.getEmailAddress());
			managerMap.put("createDate", manager.getCreateDate());
			managerList.add(managerMap);
		}
		
		returnMap.put("managerList", managerList);
		
		return returnMap;
	}
	
	
	public List<Map<String, Object>> retrieveListScienceAppWithOutExpando(long companyGroupId,
		      long groupId, Locale locale, Map<String, Object> searchParam, int begin, int end)
		      throws PortalException, SystemException{
		    
		  Map<String,Object> search = settingScienceAppParameter(companyGroupId, groupId, 0, locale, searchParam, begin, end);
		  List<Object[]> scienceAppList = scienceAppFinder.retrieveListScienceApp(search);
		  List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		  try{
		    for (int i = 0; i < scienceAppList.size(); i++) {
		      Object[] resultArray = scienceAppList.get(i);
	        ScienceAppCategoryLink sAppCategoryLink = (ScienceAppCategoryLink) resultArray[0];
	        ScienceApp scienceApp = (ScienceApp) resultArray[1];
	        User user = UserLocalServiceUtil.getUser(scienceApp.getAuthorId());
		      Map<String, Object> resultRow = getScienceAppMap(locale, sAppCategoryLink, scienceApp, user);
		      
		      returnList.add(resultRow);
		    }
		  }catch(Exception e){
		    throw new SystemException(e);
		  }
		  return returnList;
		}
		
	public ScienceApp updateExeInfomaionScienceApp(ServiceContext sc, Map params, long scienceAppId) throws PortalException, SystemException{
		ScienceApp scienceApp = super.getScienceApp(scienceAppId);
		
		scienceApp.setExeFileName(CustomUtil.strNull(params.get("exeFileName")));
		scienceApp.setOpenLevel(CustomUtil.strNull(params.get("openLevel")));
		scienceApp.setAppType(CustomUtil.strNull(params.get("appType")));
		scienceApp.setRunType(CustomUtil.strNull(params.get("runType")));
		scienceApp.setParallelModule(CustomUtil.strNull(params.get("parallelModule")));
		scienceApp.setEditorType(CustomUtil.strNull(params.get("editorType")));
		scienceApp.setMaxCpus(GetterUtil.getInteger(params.get("maxCpus"),0));
		scienceApp.setDefaultCpus(GetterUtil.getInteger(params.get("defaultCpus"),0));
		scienceApp.setModifiedDate(new Date());
		scienceApp.setRecentModifierId(sc.getUserId());
		
		
		UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(sc.getLiferayPortletRequest());
		
		//Source File Upload
		String appSoruceFileStr = CustomUtil.strNull(upload.getFileName("sourceFile"),"");
		if(!appSoruceFileStr.equals("")){
			long srcFileId = GetterUtil.getLong(scienceApp.getSrcFileName(),0);
			if(srcFileId!=0){
				//기존 파일 삭제
				DLFileEntryLocalServiceUtil.deleteDLFileEntry(srcFileId);
			}
			
			try {
				List<FileEntry> srcFiles = EdisonFileUtil.insertEdisonFile(
											sc.getLiferayPortletRequest(), upload,
											sc.getUserId(), 
											scienceApp.getGroupId(),
											"", String.valueOf(scienceAppId), "sourceFile", EdisonFileConstants.SCIENCE_APPS
											);
				
				FileEntry appEntry = srcFiles.get(0);
				scienceApp.setSrcFileName(String.valueOf(appEntry.getFileEntryId()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new SystemException(e);
				
			}
		}
		//실행파일 및 파일 업로드 기능 개발
		
		
		
		super.updateScienceApp(scienceApp);
		
		
		
		return scienceApp;
	}
	
	
	
	protected Map<String,Object> settingScienceAppParameter(long companyGroupId, long groupId,long categoryId, Locale locale,Map<String,Object> searchParam,int begin, int end) throws PortalException, SystemException {
		//categoryId가 0일 경우 해당 groupId의 상위 카테고리를 조회 해서 parentCategoryId에 셋팅 한다.
		if(categoryId==0){
			//카테고리
			AssetVocabulary aVocabulary =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(companyGroupId,EdisonAssetCategory.GLOBAL_DOMAIN);
			
			AssetEntry aEntry = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), groupId);
			List<AssetCategory> aCategoryList = AssetCategoryLocalServiceUtil.getAssetEntryAssetCategories(aEntry.getEntryId());
			
			String categoryStr = "";
			for(AssetCategory aCategory : aCategoryList){
				if(aCategory.getVocabularyId()==aVocabulary.getVocabularyId()&&aCategory.getParentCategoryId()==0){
					if(categoryStr.equals("")){
						categoryStr += aCategory.getCategoryId();
					}else{
						categoryStr += ","+aCategory.getCategoryId();
					}
				}
			}
			
			long[] parentCategoryId = StringUtil.split(categoryStr,0l);
			searchParam.put("parentCategoryId", parentCategoryId);
		}else{
			searchParam.put("categoryId", categoryId);
		}
		
		
		String targetLanguage = LocaleUtil.toLanguageId(locale);
		searchParam.put("targetLanguage", targetLanguage);
		searchParam.put("companyId", GroupLocalServiceUtil.getGroup(companyGroupId).getCompanyId());
		
		
		
		//User 확장 필드 조회
		Group group = GroupLocalServiceUtil.getGroup(groupId);
		ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(group.getCompanyId(), User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
		ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY);
		searchParam.put("columnId", column.getColumnId());
		
		
		
		//전체 검색 및 기관 검색이 있을 경우
		String searchOption = CustomUtil.strNull(searchParam.get("searchOption"));
		
		if(!searchOption.equals("")){
			searchParam.put(searchOption, "Y");
				
			if(StringUtil.equalsIgnoreCase(searchOption, "APP_MANAGER_SEARCH_ALL")||StringUtil.equalsIgnoreCase(searchOption, "NOFILTERSEARCH_SCIENCEAPPSTORE")||StringUtil.equalsIgnoreCase(searchOption, "SWORGNM")){
				String searchValue = CustomUtil.strNull(searchParam.get("searchValue"));
				String searchOrgCodeStr = "";
				//공통코드에서 Like 조회
				List<Map<String, String>> commonCodeList = EdisonExpndoUtil.getCodeListByUpCode(1501, locale);
				for(Map<String,String> codeMap : commonCodeList){
					String codeName = codeMap.get(EdisonExpando.CDNM);
					if(codeName.indexOf(searchValue)>-1){
						String codeValue = codeMap.get(EdisonExpando.CD);
						
						if(searchOrgCodeStr.equals("")){
							searchOrgCodeStr += codeValue;
						}else{
							searchOrgCodeStr += ","+codeValue;
						}
					}
				}
				
				if(searchOrgCodeStr.equals("")){
					searchParam.put("searchOrgCode", searchValue);
				}else{
					long[] searchOrgCode = StringUtil.split(searchOrgCodeStr,0l);
					searchParam.put("searchOrgCode", searchOrgCode);
				}
				
				
			}
		}
		
		//페이징
		if(end!=0){
			searchParam.put("begin", begin);
			searchParam.put("end", end);
		}
		
		return searchParam;
	}
	
	
	protected Map<String, Object> getScienceAppMap(
		      Locale locale, ScienceAppCategoryLink sAppCategoryLink, ScienceApp scienceApp, User user
		      ) 
		      throws ParseException, PortalException, SystemException{
		    
		Map<String, Object> resultRow = new HashMap<String, Object>();
	    resultRow.put("groupId", sAppCategoryLink.getGroupId());
	    resultRow.put("companyId", sAppCategoryLink.getCompanyId());
	    resultRow.put("categoryId", sAppCategoryLink.getCategoryId());
	    resultRow.put("parentCategoryId", sAppCategoryLink.getParentCategoryId());
	    
	    resultRow.put("scienceAppId", scienceApp.getScienceAppId());
	    resultRow.put("createDate", scienceApp.getCreateDate());
	    resultRow.put("name", scienceApp.getName());
	    resultRow.put("version", scienceApp.getVersion());
	    resultRow.put("title", scienceApp.getTitle(locale));
	    resultRow.put("status", scienceApp.getStatus());
	    resultRow.put("modifiedDate", CustomUtil.StringToDateFormat(CustomUtil.strNull(scienceApp.getModifiedDate()), "yyyy-MM-dd HH:mm:ss"));
	    resultRow.put("developers", StringUtil.split(scienceApp.getDevelopers(locale), StringPool.NEW_LINE));
	    resultRow.put("appType", scienceApp.getAppType());
	    
	    resultRow.put("firstName", user.getFirstName());
	    resultRow.put("screenName", user.getScreenName());
	    resultRow.put("userId", user.getUserId());
	    
	    return resultRow;
	}
	
	public List<Map<String, Object>> getScienceAppExeSts(String scienceAppId,long groupId){
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		List<Object[]> scienceAppStsList =ScienceAppFinderUtil.getScienceAppExeSts(scienceAppId, groupId);
		
		Map <String, Object> resultRow = null;
		for (int i = 0; i < scienceAppStsList.size(); i++) {
			Object[] resultArray = scienceAppStsList.get(i);
			String month = CustomUtil.strNull(resultArray[0]);
			int monthCnt = GetterUtil.getInteger(resultArray[1]);
			int preMonthCnt = GetterUtil.getInteger(resultArray[2]);
			
			resultRow = new HashMap<String, Object>();
			resultRow.put("month", month);
			resultRow.put("monthCnt", monthCnt);
			resultRow.put("preMonthCnt", preMonthCnt);
			
			returnList.add(resultRow);
		}
				
		return returnList;
	}
	
	public List<Map<String, Object>> getMyAppListWithQna(Map params, Locale locale) throws PortalException, SystemException{
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		String isPortal = CustomUtil.strNull(params.get("isPortal"));
		if(isPortal.equals("false")){
			long companyGroupId = Long.parseLong(CustomUtil.strNull(params.get("companyGroupId")));
			long groupId = Long.parseLong(CustomUtil.strNull(params.get("groupId")));;
			//카테고리
			AssetVocabulary aVocabulary =  AssetVocabularyLocalServiceUtil.getGroupVocabulary(companyGroupId,EdisonAssetCategory.GLOBAL_DOMAIN);
			
			AssetEntry aEntry = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), groupId);
			List<AssetCategory> aCategoryList = AssetCategoryLocalServiceUtil.getAssetEntryAssetCategories(aEntry.getEntryId());
			
			String categoryStr = "";
			for(AssetCategory aCategory : aCategoryList){
				if(aCategory.getVocabularyId()==aVocabulary.getVocabularyId()&&aCategory.getParentCategoryId()==0){
					if(categoryStr.equals("")){
						categoryStr += aCategory.getCategoryId();
					}else{
						categoryStr += ","+aCategory.getCategoryId();
					}
				}
			}
			
			long[] parentCategoryId = StringUtil.split(categoryStr,0l);
			params.put("parentCategoryId", parentCategoryId);
		}
		
		List<Object[]> resultList = scienceAppFinder.getMyAppListWithQna(params);
		
		if(resultList != null) {
			try{
				for (Object[] result : resultList) {
					ScienceApp scienceApp = (ScienceApp) result[0];
					
					Map<String, Object> resultRow = new HashMap<String, Object>();
					
					resultRow.put("scienceAppId", scienceApp.getScienceAppId());
					resultRow.put("groupId", scienceApp.getGroupId());
					resultRow.put("userId", scienceApp.getAuthorId());
					resultRow.put("title", scienceApp.getTitle(locale));
					resultRow.put("version", scienceApp.getVersion());
					resultRow.put("name", scienceApp.getName());
					resultRow.put("answerCount", GetterUtil.get(CustomUtil.strNull(result[1]), 0));
					
					User appUser = UserLocalServiceUtil.getUser(scienceApp.getAuthorId());
					resultRow.put("userFirstName", appUser.getFirstName());
					
					long classPK = GetterUtil.getLong(appUser.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY),0);
					String affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(classPK, EdisonExpando.CDNM, locale);
					resultRow.put("affiliation", affiliation);
					
					long appManagerPlid = PortalUtil.getPlidFromPortletId(GetterUtil.get(CustomUtil.strNull(scienceApp.getGroupId()),0L), false, "scienceappmanager_WAR_edisonappstore2016portlet");
					resultRow.put("appManagerPlid", appManagerPlid);
					
					long manualId = GetterUtil.getLong(scienceApp.getManualId(locale),0l);
					if(manualId !=0){
						resultRow.put("manualId", manualId);
						DLFileEntry manualDl =DLFileEntryLocalServiceUtil.getDLFileEntry(manualId);
						resultRow.put("manualRepositoryId", manualDl.getRepositoryId());
						resultRow.put("manualUuid", manualDl.getUuid());
						resultRow.put("manualTitle", manualDl.getTitle());
					}
					
					returnList.add(resultRow);
				}
			} catch (Exception e) {
				throw new SystemException(e);
			}
		}
		return returnList;
	}
	
	public List<Map<String, Object>> getListMyAppQna(Map params, Locale locale) {
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		List<Object[]> resultList = scienceAppFinder.getListMyAppQna(params);
		if(resultList != null) {
			
			for (Object[] result : resultList) {
				
				Map<String, Object> resultRow = new HashMap<String, Object>();
				
				resultRow.put("boardSeq", CustomUtil.strNull(result[0]));
				resultRow.put("title", CustomUtil.strNull(LocalizationUtil.getLocalization(CustomUtil.strNull(result[1]), LanguageUtil.getLanguageId(locale))));
				resultRow.put("content", CustomUtil.strNull(LocalizationUtil.getLocalization(CustomUtil.strNull(result[2]), LanguageUtil.getLanguageId(locale))));
				resultRow.put("writerId", CustomUtil.strNull(result[3]));
				resultRow.put("writerDate", new SimpleDateFormat("yyyy-MM-dd").format((Date) result[4]));
				resultRow.put("readCnt", CustomUtil.strNull(result[5]));
				resultRow.put("replyCount", CustomUtil.strNull(result[6]));
				resultRow.put("groupId", CustomUtil.strNull(result[7]));
				
				try {
					User writerUser = userPersistence.fetchByPrimaryKey(GetterUtil.get(CustomUtil.strNull(result[3]), 0L));
					resultRow.put("writerUserFirstName", writerUser.getFirstName());
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				returnList.add(resultRow);
			}
		}
		return returnList;
	}
	
	
	public void deleteScienceAppRelation(long scienceAppId) throws PortalException, SystemException{
		ScienceApp scienceApp = scienceAppLocalService.getScienceApp(scienceAppId);
		
		//INPUT PORT
		try{
			scienceAppInputPortsLocalService.deleteScienceAppInputPorts(scienceAppId);
		}catch(NoSuchScienceAppInputPortsException e){
			
		}
		
		
		//OUTPUT PORT
		try{
			scienceAppOutputPortsLocalService.deleteScienceAppOutputPorts(scienceAppId);
		}catch(NoSuchScienceAppOutputPortsException e){
			
		}
		
		
		//APP MANAGER
		List<ScienceAppManager> scienceAppManagers= scienceAppManagerLocalService.getManagersByScienceAppId(scienceAppId);
		for(ScienceAppManager scienceAppManager:scienceAppManagers){
			scienceAppManagerLocalService.deleteScienceAppManager(scienceAppManager);
		}
		
		//APP Description
		if(scienceApp.getDescriptionId()!=0){
			scienceAppDescriptionLocalService.deleteScienceAppDescription(scienceApp.getDescriptionId());
		}
		
		//Category
		List<ScienceAppCategoryLink> scienceAppCategoryLinks = scienceAppCategoryLinkLocalService.getScienceAppCategorysByscienceAppId(scienceAppId);
		for(ScienceAppCategoryLink scienceAppCategoryLink : scienceAppCategoryLinks){
			scienceAppCategoryLinkLocalService.deleteScienceAppCategoryLink(scienceAppCategoryLink);
		}
		
		//FILE FOLDER
		String folderSeq = scienceApp.getGroupId()+"_"+scienceAppId;
		try{
			EdisonFileUtil.deleteGroupEdisonFile(scienceApp.getGroupId(), EdisonFileConstants.SCIENCE_APPS, folderSeq);
		}catch(NoSuchFolderException e){
			
		}
		
		//APP FAVORITE
		scienceAppFavoriteLocalService.deleteFavoriteApp(scienceAppId);
		
		//SCIENCEAPP
		//NoSuchScienceAppInputPortsException - 처리 못함
		//NoSuchScienceAppOutputPortsException - 처리 못함
//		scienceAppLocalService.deleteScienceApp(scienceApp);
		super.deleteScienceApp(scienceApp);
	}
	
	
	public List<Map<String, Object>> getMyAppListForProject(Map params, Locale locale) throws PortalException, SystemException{
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		List<ScienceApp> resultList = scienceAppFinder.getMyAppListForProject(params);
		
		if(resultList != null) {
			try{
				for (ScienceApp scienceApp : resultList) {
					Map<String, Object> resultRow = new HashMap<String, Object>();
					
					resultRow.put("scienceAppId", scienceApp.getScienceAppId());
					resultRow.put("groupId", scienceApp.getGroupId());
					resultRow.put("userId", scienceApp.getAuthorId());
					resultRow.put("title", scienceApp.getTitle(locale));
					resultRow.put("version", scienceApp.getVersion());
					resultRow.put("name", scienceApp.getName());
					resultRow.put("projectCategoryId", scienceApp.getProjectCategoryId());
					
					User appUser = UserLocalServiceUtil.getUser(scienceApp.getAuthorId());
					resultRow.put("userFirstName", appUser.getFirstName());
					
					long classPK = GetterUtil.getLong(appUser.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY),0);
					String affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(classPK, EdisonExpando.CDNM, locale);
					resultRow.put("affiliation", affiliation);
					
					returnList.add(resultRow);
				}
			} catch (Exception e) {
				throw new SystemException(e);
			}
		}
		return returnList;
	}
	
	public int getMyAppListForProjectCount(Map params, Locale locale){
		return scienceAppFinder.getMyAppListForProjectCount(params, locale);
	}
	
	public int countAppTest(long scienceAppId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("scienceAppId", scienceAppId);
		return scienceAppFinder.countAppTest(params);
	}
	
	public List<Map<String, Object>> retrieveListAppTest(Map<String,Object> params) throws PortalException, SystemException{
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		List<Object[]> resultList = scienceAppFinder.retrieveListAppTest(params);
		
		if(resultList != null) {
			try{
				
				for (Object[] result : resultList) {
					Map<String, Object> resultRow = new HashMap<String, Object>();
					resultRow.put("simulationCreateDt", 		CustomUtil.strNull(result[0]));
					resultRow.put("totalCnt", 		CustomUtil.strNull(result[1]));
					resultRow.put("queuedCnt", 		CustomUtil.strNull(result[2]));
					resultRow.put("runCnt", 		CustomUtil.strNull(result[3]));
					resultRow.put("successCnt", 	CustomUtil.strNull(result[4]));
					resultRow.put("failedCnt", 		CustomUtil.strNull(result[5]));
					resultRow.put("jobUuid", 		CustomUtil.strNull(result[6]));
					
					returnList.add(resultRow);
				}
			} catch (Exception e) {
				throw new SystemException(e);
			}
		}
		return returnList;
	}
	
	public List<ScienceApp> getAll() throws SystemException{
		return super.scienceAppPersistence.findAll();
	}
	
	
	public void addScienceAppFile(long companyId, String appName, String appVersion, String fileName, InputStream uploadedInputStream) throws SystemException{
		try{
			String appBasePath = PrefsPropsUtil.getString(companyId, EdisonPropsUtil.SCIENCEAPP_BASE_PATH)+appName+File.separator+appVersion;
			String srcPath = appBasePath+File.separator+"src";
			String binPath = appBasePath+File.separator+"bin";
			this.saveToScienceAppStorage(srcPath, fileName, uploadedInputStream);
			
			this.unzipScienceAppZipFile(srcPath+File.separator+fileName, binPath);
			
		}catch(Exception e){
			throw new SystemException(e);
		}
	} 
}