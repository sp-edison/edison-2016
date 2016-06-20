package org.kisti.edison.content.portlet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

public class AdvancedFileUtil {
	
	public static String filePathCreate(HttpServletRequest request,String contentFilePath){
		String path = PropsUtil.get(PropsKeys.AUTO_DEPLOY_TOMCAT_DEST_DIR)+"/content";
		path +=contentFilePath+"/";
		return path;
	}
	
	/*
	 * 파일생성
	 */
	public static String createFile(ActionRequest request,UploadPortletRequest upload,String contentFilePath, String fileFormName) throws SystemException{
		String advancedFilePath = filePathCreate(PortalUtil.getHttpServletRequest(request), contentFilePath);
		
		File folderPath = new File(advancedFilePath);
		if(!folderPath.isDirectory()) {
			folderPath.mkdirs();
		}
		File[] uploadFiles = upload.getFiles(fileFormName);
		String[] fileNames = upload.getFileNames(fileFormName);
		
		File file = null;
		try{
			InputStream[] uploadInputStream = upload.getFilesAsStream(fileFormName,false);
			if(fileNames != null&&Validator.isNotNull(fileNames[0])){
				for(int i=0;i<uploadFiles.length;i++){
					byte[] bytes = FileUtil.getBytes(uploadFiles[i]);
					if(ArrayUtil.isNotEmpty(bytes)){
						file = FileUtil.createTempFile(bytes);
					}else{
						InputStream fileObj = uploadInputStream[i];
						file = FileUtil.createTempFile(fileObj);
					}
					
					FileOutputStream output = new FileOutputStream(advancedFilePath+fileNames[i]);
					FileInputStream inputStream = new FileInputStream(file);
					byte[] buffer = new byte[1024 * 8];
					int readcount = 0;
					while((readcount=inputStream.read(buffer)) != -1) {
						output.write(buffer, 0, readcount);
					}
					inputStream.close();
					output.close();
					FileUtil.delete(file);
				}
			}
		}catch(IOException ioe){
			if(file!=null){FileUtil.delete(file);}
			throw new SystemException("Unable to write temporary file", ioe);
		}
		return upload.getFileName(fileFormName);
	}
	
	public static String unzipFile(ActionRequest request,UploadPortletRequest upload,String contentFilePath, String fileFormName) throws SystemException{
		String advancedFilePath = filePathCreate(PortalUtil.getHttpServletRequest(request), contentFilePath);
		
		File folderPath = new File(advancedFilePath);
		if(!folderPath.isDirectory()) {
			folderPath.mkdirs();
		}
		File[] uploadFiles = upload.getFiles(fileFormName);
		String[] fileNames = upload.getFileNames(fileFormName);
		File file = null;
		try{
			InputStream[] uploadInputStream = upload.getFilesAsStream(fileFormName,false);
			if(fileNames != null&&Validator.isNotNull(fileNames[0])){
				for(int i=0;i<uploadFiles.length;i++){
					String folder = "";
					if(fileNames[i].contains(".zip")){
						 folder = fileNames[i].split(".zip")[0];
					}
//					System.out.println("Begin unzip "+ advancedFilePath+fileNames[i] + " into "+advancedFilePath);
			        ZipInputStream zis = new ZipInputStream(new FileInputStream(advancedFilePath+fileNames[i]));
			        ZipEntry ze = zis.getNextEntry();
			        while(ze!=null){
			            String entryName = ze.getName();
			            File f = new File(advancedFilePath+folder+File.separator +  entryName);
			            f.getParentFile().mkdirs();
			            FileOutputStream fos = new FileOutputStream(f);
			            int len;
			            byte buffer[] = new byte[1024];
			            while ((len = zis.read(buffer)) > 0) {
			                fos.write(buffer, 0, len);
			            }
			            fos.close();   
			            ze = zis.getNextEntry();
			        }
			        zis.closeEntry();
			        zis.close();
				}
			}
		}catch(IOException ioe){
			if(file!=null){FileUtil.delete(file);}
			throw new SystemException("Unable to write temporary file", ioe);
		}
		return upload.getFileName(fileFormName);
	}
	
	/*
	 * 파일목록
	 */
	public static List<HashMap<String,String>> getListFile(RenderRequest request,String contentFilePath,String contentFileNm){
		List<HashMap<String,String>> returnList = new ArrayList<HashMap<String,String>>();
		String advancedFilePath = filePathCreate(PortalUtil.getHttpServletRequest(request), contentFilePath);
		File dirFile = new File(advancedFilePath);
		
		File[] fileList = dirFile.listFiles();
		HashMap<String,String> fileMap = null;
		if(fileList!=null){
			for(File file: fileList){
				if(!file.getName().equals(contentFileNm)){
					fileMap = new HashMap<String,String>();
					fileMap.put("fileNm", file.getName());
					returnList.add(fileMap);
				}
			}
		}
		return returnList;
	}
	
	
	public static void deleteFile(ActionRequest request,String contentFilePath,String deleteFileNm){
		String advancedFilePath = filePathCreate(PortalUtil.getHttpServletRequest(request), contentFilePath);
		File file = new File(advancedFilePath+deleteFileNm);
		file.delete();
	}
	
	
	public static void deleteAllFile(ActionRequest request,String contentFilePath) throws SystemException{
		String advancedFilePath = filePathCreate(PortalUtil.getHttpServletRequest(request), contentFilePath);
		File file = new File(advancedFilePath);
		
		if(file!=null){
			if (file.isDirectory()) {
				removeDIR(file.getPath());
				file.delete();
			}else{
				throw new SystemException("AdvancedFileUtil.deleteAllFile is Not Dir"+advancedFilePath);
			}
		}
	}
	
	public static void removeDIR(String source){ 
		File[] listFile = new File(source).listFiles(); 
		try{
			if(listFile.length > 0){
				for(int i = 0 ; i < listFile.length ; i++){
					if(listFile[i].isFile()){
						listFile[i].delete(); 
					}else{
						removeDIR(listFile[i].getPath());
					}
					listFile[i].delete();
				}
			}
		}catch(Exception e){
			System.err.println(System.err);
			System.exit(-1); 
		}
			
	}
}
