package org.kisti.edison.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

public  class EdisonFileUtil{

	private static Log logger = LogFactoryUtil.getLog(EdisonFileUtil.class);
	
	/**
	 * 파일 저장
	 * @return void
	 * @throws SQLException
	 * @throws IOException 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static List<FileEntry> insertEdisonFile(PortletRequest request, UploadPortletRequest upload, long userId, long groupId, String preFix, String fileGroupSeq, String fileFormName, String fileCategory) throws SQLException, PortalException, SystemException, IOException{
		
		String filePath = String.valueOf(groupId);
		List<FileEntry> returnFileList = new ArrayList<FileEntry>();
		
		
		if(!preFix.equals("")) filePath += "_"+preFix;
		if(!fileGroupSeq.equals("")) filePath += "_"+fileGroupSeq;
		
		//사이트별 파일 폴더 생성
		DLFolder edisonFolder=null;
		try {
			edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE");
			
		}catch (NoSuchFolderException nsfe) {
			//권한
			//Guest와 User에게 View 권한을 주기 위한 Setting
			ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			sctx.setAddGroupPermissions(true);
			sctx.setAddGuestPermissions(true);
			edisonFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE", "", false,sctx);
		}
		
		//카테고리 폴더 생성 ex) NOTICE, CONTEST
		DLFolder categoryFolder=null;
		try {
			categoryFolder = DLFolderLocalServiceUtil.getFolder(groupId, edisonFolder.getFolderId(), fileCategory);
			
		}catch (NoSuchFolderException nsfe) {
			//권한
			//Guest와 User에게 View 권한을 주기 위한 Setting
			ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			sctx.setAddGroupPermissions(true);
			sctx.setAddGuestPermissions(true);
			categoryFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, edisonFolder.getFolderId(), fileCategory, "", false,sctx);
		}
		
		//폴더 생성
		DLFolder folder=null;
		try {
			folder = DLFolderLocalServiceUtil.getFolder(groupId, categoryFolder.getFolderId(), filePath);
			
		}catch (NoSuchFolderException nsfe) {
			//권한
			//Guest와 User에게 View 권한을 주기 위한 Setting
			ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			sctx.setAddGroupPermissions(true);
			sctx.setAddGuestPermissions(true);
			folder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, categoryFolder.getFolderId(), filePath, "", false,sctx);
		}
		 
		String[] fileNames = upload.getFileNames(fileFormName);
 		if(fileNames != null){
 			File[] files = upload.getFiles(fileFormName);
 			//upload.getFiels 사용시 1KB 미만의 파일은 temp 디렉토리에 파일이 생성되지 않기 때문에 inputStream을 읽어와서 temp에 파일 생성
 			InputStream[] inputStream = upload.getFilesAsStream(fileFormName,false);
 			
 			String contentType = upload.getContentType(fileFormName);
 			FileEntry fe = null;
 			
			for(int i=0;i<fileNames.length;i++){				
				if (Validator.isNotNull(fileNames[i])) {
					
					InputStream fileObj = inputStream[i];
 					File tempfile = FileUtil.createTempFile(fileObj);
 					files[i] = tempfile;
					
					
					ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
					sctx.setAddGroupPermissions(true);
					sctx.setAddGuestPermissions(true);
					
					//파일 등록시 INDEXING을 하지 않도록 변경
					sctx.setIndexingEnabled(false);
					
					try {
						fe = DLAppLocalServiceUtil.addFileEntry( 
															userId,	groupId,	folder.getFolderId(),
															fileNames[i], contentType, fileNames[i], 
															fileNames[i], "", FileUtil.getBytes(files[i]), 
															sctx
															);
						
						returnFileList.add(fe);
						
					} catch (DuplicateFileException e) {
						//중복파일명 입력 시 파일명 변경처리
						Random rand = new Random();
				        Integer suffix = new Integer(rand.nextInt(10000));
						
						int index = fileNames[i].lastIndexOf("."); 

				        String onlyFileName = fileNames[i].substring(0, index);
						String ext = fileNames[i].substring(index);
				        
						fe = DLAppLocalServiceUtil.addFileEntry(
															userId,	groupId,	folder.getFolderId(),
															fileNames[i], contentType, onlyFileName+"_"+CustomUtil.getRandomString(3)+ext, 
															fileNames[i], "", FileUtil.getBytes(files[i]), 
															sctx
															);

						returnFileList.add(fe);						
					}
					
					fileObj.close();
				}
				
				//1KB 미만의 파일을 upload시 temp 디렉토리에서 자동으로 삭제가 안되기 때문에 
				//파일이 남아 있을 경우 temp에서 임의 삭제
				if(files[i]!=null){if(files[i].exists()){files[i].delete();}}
			}	
		}
 		
 		
 		return returnFileList;
 		
	}
	
	/**
	 * 보안서약서 파일 저장
	 * @return void
	 * @throws SQLException
	 * @throws IOException 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static List insertWorkspaceDocFile(ActionRequest request, UploadPortletRequest upload, long userId, long groupId, String preFix, String fileGroupSeq, String fileFormName, String screenName) throws SQLException, PortalException, SystemException, IOException{
		
		List returnFileList = new ArrayList();
		
		//사이트별 파일 폴더 생성
		DLFolder edisonFolder=null;
		try {
			edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE");
			
		}catch (NoSuchFolderException nsfe) {
			//권한
			//Guest와 User에게 View 권한을 주기 위한 Setting
			ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			sctx.setAddGroupPermissions(true);
			sctx.setAddGuestPermissions(true);
			edisonFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE", "", false,sctx);
		}
		
		//보안서약서 파일 폴더 생성
		DLFolder folder=null;
		try {
			folder = DLFolderLocalServiceUtil.getFolder(groupId, edisonFolder.getFolderId(), preFix);
			
		}catch (NoSuchFolderException nsfe) {
			//권한
			//Guest와 User에게 View 권한을 주기 위한 Setting
			ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			sctx.setAddGroupPermissions(true);
			sctx.setAddGuestPermissions(true);
			folder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, edisonFolder.getFolderId(), preFix, "", false,sctx);
		}
		
		String[] fileNames = upload.getFileNames(fileFormName);
		if(fileNames != null){
			File[] files = upload.getFiles(fileFormName);
			//upload.getFiels 사용시 1KB 미만의 파일은 temp 디렉토리에 파일이 생성되지 않기 때문에 inputStream을 읽어와서 temp에 파일 생성
			InputStream[] inputStream = upload.getFilesAsStream(fileFormName,false);
			
			String contentType = upload.getContentType(fileFormName);
			FileEntry fe = null;
			
			for(int i=0;i<fileNames.length;i++){				
				if (Validator.isNotNull(fileNames[i])) {
					
					InputStream fileObj = inputStream[i];
					File tempfile = FileUtil.createTempFile(fileObj);
					files[i] = tempfile;
					
					
					ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
					sctx.setAddGroupPermissions(true);
					sctx.setAddGuestPermissions(true);
					//파일 등록시 INDEXING을 하지 않도록 변경
					sctx.setIndexingEnabled(false);
					String editFileName = "";
					String fileNameNonExtension = "";
					String fileExtension = "";
					
					int dotIndex = fileNames[i].indexOf(".");
					fileNameNonExtension = fileNames[i].substring(0, dotIndex);
					fileExtension = fileNames[i].substring(dotIndex, fileNames[i].length());
					editFileName = fileNameNonExtension+"_"+screenName+fileExtension;
					
					try {
						fe = DLAppLocalServiceUtil.addFileEntry( 
								userId,	groupId,	folder.getFolderId(),
								editFileName, contentType, editFileName, 
								editFileName, "", FileUtil.getBytes(files[i]), 
								sctx
								);
						
						returnFileList.add(fe);
						
					} catch (DuplicateFileException e) {
						//중복파일명 입력 시 파일명 변경처리
						Random rand = new Random();
						Integer suffix = new Integer(rand.nextInt(10000));
						
						int index = fileNames[i].lastIndexOf("."); 
						
						String onlyFileName = fileNames[i].substring(0, index);
						String ext = fileNames[i].substring(index);
						
						fe = DLAppLocalServiceUtil.addFileEntry(
								userId,	groupId,	folder.getFolderId(),
								editFileName, contentType, onlyFileName+"_"+screenName+"_"+CustomUtil.getRandomString(3)+ext, 
								editFileName, "", FileUtil.getBytes(files[i]), 
								sctx
								);
						
						returnFileList.add(fe);						
					}
					
					fileObj.close();
				}
				
				//1KB 미만의 파일을 upload시 temp 디렉토리에서 자동으로 삭제가 안되기 때문에 
				//파일이 남아 있을 경우 temp에서 임의 삭제
				if(files[i]!=null){if(files[i].exists()){files[i].delete();}}
			}	
		}
		
		
		return returnFileList;
		
	}

	/**
	 * Sample 파일 저장
	 * @return void
	 * @throws SQLException
	 * @throws IOException 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static List<FileEntry> insertEdisonSampleFile(PortletRequest request, UploadPortletRequest upload, long userId, long groupId, String fileFormName, String folderName) throws SQLException, PortalException, SystemException, IOException{
		
		List<FileEntry> returnFileList = new ArrayList<FileEntry>();
		
		//폴더 생성
		DLFolder folder=null;
		try {
			folder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, folderName);
			
		}catch (NoSuchFolderException nsfe) {
			//권한
			//Guest와 User에게 View 권한을 주기 위한 Setting
			ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
			sctx.setAddGroupPermissions(true);
			folder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, folderName, "", false,sctx);
		}
		 
		String[] fileNames = upload.getFileNames(fileFormName);
 		if(fileNames != null){
 			File[] files = upload.getFiles(fileFormName);
 			//upload.getFiels 사용시 1KB 미만의 파일은 temp 디렉토리에 파일이 생성되지 않기 때문에 inputStream을 읽어와서 temp에 파일 생성
 			InputStream[] inputStream = upload.getFilesAsStream(fileFormName,false);
 			
 			String contentType = upload.getContentType(fileFormName);
 			FileEntry fe = null;
 			
			for(int i=0;i<fileNames.length;i++){				
				if (Validator.isNotNull(fileNames[i])) {
					
					InputStream fileObj = inputStream[i];
 					File tempfile = FileUtil.createTempFile(fileObj);
 					files[i] = tempfile;
					
					
					ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
					sctx.setAddGroupPermissions(true);
					sctx.setAddGuestPermissions(true);
					
					//파일 등록시 INDEXING을 하지 않도록 변경
					sctx.setIndexingEnabled(false);
					
					try {
						fe = DLAppLocalServiceUtil.addFileEntry( 
															userId,	groupId,	folder.getFolderId(),
															fileNames[i], contentType, fileNames[i], 
															fileNames[i], "", FileUtil.getBytes(files[i]), 
															sctx
															);
						
						returnFileList.add(fe);
						
					} catch (DuplicateFileException e) {
						//중복파일명 입력 시 파일명 변경처리
						Random rand = new Random();
				        Integer suffix = new Integer(rand.nextInt(10000));
						
						int index = fileNames[i].lastIndexOf("."); 

				        String onlyFileName = fileNames[i].substring(0, index);
						String ext = fileNames[i].substring(index);
				        
						fe = DLAppLocalServiceUtil.addFileEntry(
															userId,	groupId,	folder.getFolderId(),
															fileNames[i], contentType, onlyFileName+"_"+CustomUtil.getRandomString(3)+ext, 
															fileNames[i], "", FileUtil.getBytes(files[i]), 
															sctx
															);

						returnFileList.add(fe);						
					}
					
					fileObj.close();
				}
				
				//1KB 미만의 파일을 upload시 temp 디렉토리에서 자동으로 삭제가 안되기 때문에 
				//파일이 남아 있을 경우 temp에서 임의 삭제
				if(files[i]!=null){if(files[i].exists()){files[i].delete();}}
			}	
		}
 		
 		
 		return returnFileList;
 		
	}	

	/**
	 * 단일 파일 삭제 deleteSingleEdisonFile
	 */
	public static boolean deleteSingleEdisonFile(long fileEntryId){
		
		boolean result = false;
		
		try {
			DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntryId);
			result = true;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}
	

	/**
	 * 그룹 파일 삭제 deleteGroupEdisonFile
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static void deleteGroupEdisonFile(long groupId, String categoryFolderNm, String folderSeq) throws PortalException, SystemException{
		DLFolder edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, 
					DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, 
					String.valueOf(groupId)+"_EDISON_FILE");
				
		DLFolder categoryFolder = DLFolderLocalServiceUtil.getFolder(groupId, edisonFolder.getFolderId(), categoryFolderNm);
		
		DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId,categoryFolder.getFolderId(),folderSeq);
		
		DLFolderLocalServiceUtil.deleteFolder(folder, true);
	}
	
	/**
	 * 보안서약서 파일삭제 deleteWorkspaceDocFile
	 */
	public static boolean deleteWorkspaceDocFile(long groupId, String preFix, String userId) throws SQLException, IOException, PortalException, SystemException{
		
		List fileList = new ArrayList();
		Map urlMap = null;
		
		boolean result = false;
		
//		String filePath = String.valueOf(groupId);
//		
//		if(!preFix.equals("")) filePath += "_"+preFix;
//		if(!userId.equals("")) filePath += "_"+userId;
		
		DLFolder edisonFolder=null;
		try {
			edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE");
		}catch (NoSuchFolderException nsfe) {
		}
		
		DLFolder folder=null;
		boolean noSearchFolderException = false;
		try {
			folder = DLFolderLocalServiceUtil.getFolder(groupId, edisonFolder.getFolderId(), preFix);
		}catch (NoSuchFolderException nsfe) {
			noSearchFolderException = true;
		}
		
		if(!noSearchFolderException){
			try {
				List<DLFileEntry> dfeList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());
				
				if(dfeList != null && dfeList.size() > 0){
					for(int f=0;f < dfeList.size();f++){
						DLFileEntry dfe = dfeList.get(f);
						if(userId.equals(String.valueOf(dfe.getUserId()))){	
							result = deleteSingleEdisonFile(dfe.getFileEntryId());
						}
					}				
				}else{	
					result = true;
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * Sample 파일 삭제 deleteEdisonSampleFile
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static void deleteEdisonSampleFile(long groupId, String folderName) throws PortalException, SystemException{
		try {
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, 
					DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, 
					folderName);
		
			DLFolderLocalServiceUtil.deleteFolder(folder, true);
			
		}catch (NoSuchFolderException nsfe) {
			
		}
		
	}
	
	
	/**
	 * 파일 목록
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static List getListEdisonFile(long groupId, String preFix, String fileGroupSeq, String fileCategory ) throws SystemException{
			
		List fileList = new ArrayList();
		Map urlMap = null;
		
		String filePath = String.valueOf(groupId);
		
		if(!preFix.equals("")) filePath += "_"+preFix;
		if(!fileGroupSeq.equals("")) filePath += "_"+fileGroupSeq;
				
		try{
			DLFolder edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE");
			
			DLFolder categoryFolder = DLFolderLocalServiceUtil.getFolder(groupId, edisonFolder.getFolderId(), fileCategory);
			
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, categoryFolder.getFolderId(), filePath);

			List<DLFileEntry> dfeList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());
			
			if(dfeList != null && dfeList.size() > 0){
				for(int f=0;f < dfeList.size();f++){
					DLFileEntry dfe = dfeList.get(f);					
					urlMap = new HashMap();
					urlMap.put("fileEntryId", String.valueOf(dfe.getFileEntryId()));
					urlMap.put("fileRepositoryId", String.valueOf(dfe.getRepositoryId()));
					urlMap.put("fileUuid", String.valueOf(dfe.getUuid()));
					urlMap.put("fileTitle", dfe.getTitle());
					urlMap.put("fileUserId", String.valueOf(dfe.getUserId()));
					urlMap.put("fileExtension", String.valueOf(dfe.getExtension()));
					fileList.add(urlMap);					
				}				
			}			
		}catch (  NoSuchFolderException nsfe) {
			logger.debug(nsfe.toString());
		} catch (PortalException nsfe) {	
			logger.debug(nsfe.toString());
		}
				
		return fileList;
	}
	
	/**
	 * 보안서약서 파일 목록
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static List getListWorkspaceDocFile(long groupId, String preFix, String fileGroupSeq) throws SystemException{
		
		List fileList = new ArrayList();
		Map urlMap = null;
		
		String userId = fileGroupSeq;

		try{
			DLFolder edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE");
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, edisonFolder.getFolderId(), preFix);
			
			List<DLFileEntry> dfeList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());
			
			if(dfeList != null && dfeList.size() > 0){
				for(int f=0;f < dfeList.size();f++){
					DLFileEntry dfe = dfeList.get(f);
					if(userId.endsWith(String.valueOf(dfe.getUserId()))){
						urlMap = new HashMap();
						urlMap.put("fileEntryId", String.valueOf(dfe.getFileEntryId()));
						urlMap.put("fileRepositoryId", String.valueOf(dfe.getRepositoryId()));
						urlMap.put("fileUuid", String.valueOf(dfe.getUuid()));
						urlMap.put("fileTitle", dfe.getTitle());
						urlMap.put("fileUserId", String.valueOf(dfe.getUserId()));
						urlMap.put("fileExtension", String.valueOf(dfe.getExtension()));
						fileList.add(urlMap);
					}
				}				
			}			
		}catch (  NoSuchFolderException nsfe) {
			logger.debug(nsfe.toString());
		} catch (PortalException nsfe) {	
			logger.debug(nsfe.toString());
		}
		
		return fileList;
	}
	
	/**
	 * Sample 파일 목록
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static List getListEdisonSampleFile(long groupId, String folderName ) throws SystemException{
			
		List fileList = new ArrayList();
		Map urlMap = null;
		
		try{
			DLFolder folder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, folderName);
			
			List<DLFileEntry> dfeList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folder.getFolderId());
			
			if(dfeList != null && dfeList.size() > 0){
				for(int f=0;f < dfeList.size();f++){
					DLFileEntry dfe = dfeList.get(f);					
					urlMap = new HashMap();
					urlMap.put("fileEntryId", String.valueOf(dfe.getFileEntryId()));
					urlMap.put("fileRepositoryId", String.valueOf(dfe.getRepositoryId()));
					urlMap.put("fileUuid", String.valueOf(dfe.getUuid()));
					urlMap.put("fileTitle", dfe.getTitle());
					urlMap.put("fileUserId", String.valueOf(dfe.getUserId()));
					urlMap.put("fileExtension", String.valueOf(dfe.getExtension()));
					fileList.add(urlMap);					
				}				
			}			
		}catch (  NoSuchFolderException nsfe) {
			logger.debug(nsfe.toString());
		} catch (PortalException nsfe) {	
			logger.debug(nsfe.toString());
		}
				
		return fileList;
	}	
	
	/**
	 * 파일 다운로드
	 * @throws SystemException 
	 * @throws PortalException 
	 * @throws IOException 
	 */
	public static void edisonFileDownload(ResourceResponse response, long fileEntryId) throws PortalException, SystemException, IOException{
		
		DLFileEntry dfe = DLFileEntryLocalServiceUtil.getDLFileEntry(fileEntryId);
		String fileName = dfe.getTitle();
		
		InputStream inputStream = null;
		inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(dfe.getUserId(), dfe.getFileEntryId(), dfe.getVersion());
		
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		response.setContentType("application/octet-stream");
		
		fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
		response.setProperty("Content-Disposition", "attachment;filename="+fileName);
		
		int readBytes = 0;
		byte data[] = new byte[8192];
		OutputStream out = response.getPortletOutputStream();
		
		while ((readBytes = bis.read(data)) != -1) {
			out.write(data, 0, readBytes);
		}
		out.flush(); 
		out.close();
		bis.close();
	}
	
	
	 public static File createCustomFile(String folderPath, String fileName, String fileContents) throws IOException, InterruptedException {
		 //폴더가 없으면 폴더 생성
		 File folder = new File(folderPath);		 
		 if(!folder.isDirectory()) folder.mkdirs();

		 //파일이 없으면 파일 생성
		 File f = new File(folderPath + "/" + fileName);
		 if(!f.exists())	f.createNewFile();
		 
		 //파일 내용 쓰기
		 FileWriter fileWriter = new FileWriter(f);
		 fileWriter.write(fileContents);
		 fileWriter.close();

		 return f;
	 }
	 /*
	  * 유저 폴더 생성
	  */
	 public static void checkUserFolder(PortletRequest request, long userId, long groupId ,String fileCategory) throws SQLException, PortalException, SystemException, IOException{
			
			String filePath = String.valueOf(userId);
			
			//사이트별 파일 폴더 생성
			DLFolder edisonFolder=null;
			try {
				edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE");
				
			}catch (NoSuchFolderException nsfe) {
				//권한
				//Guest와 User에게 View 권한을 주기 위한 Setting
				ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
				sctx.setAddGroupPermissions(true);
				sctx.setAddGuestPermissions(true);
				edisonFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE", "", false,sctx);
			}
			
			//카테고리 폴더 생성 ex) NOTICE, CONTEST
			DLFolder categoryFolder=null;
			try {
				categoryFolder = DLFolderLocalServiceUtil.getFolder(groupId, edisonFolder.getFolderId(), fileCategory);
				
			}catch (NoSuchFolderException nsfe) {
				//권한
				//Guest와 User에게 View 권한을 주기 위한 Setting
				ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
				sctx.setAddGroupPermissions(true);
				sctx.setAddGuestPermissions(true);
				categoryFolder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, edisonFolder.getFolderId(), fileCategory, "", false,sctx);
			}
			
			//폴더 생성 폴더명 : userId
			DLFolder folder=null;
			try {
				folder = DLFolderLocalServiceUtil.getFolder(groupId, categoryFolder.getFolderId(), filePath);
				
			}catch (NoSuchFolderException nsfe) {
				//권한
				//Guest와 User에게 View 권한을 주기 위한 Setting
				ServiceContext sctx = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), request);
				sctx.setAddGroupPermissions(true);
				sctx.setAddGuestPermissions(true);
				folder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, categoryFolder.getFolderId(), filePath, "", false,sctx);
			}
	 }
	
}
