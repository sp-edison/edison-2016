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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.kisti.edison.science.model.CommonLib;
import org.kisti.edison.science.service.base.CommonLibLocalServiceBaseImpl;
import org.kisti.edison.science.service.persistence.CommonLibPK;
import org.kisti.edison.util.EdisonPropsUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * The implementation of the common lib local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.science.service.CommonLibLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.base.CommonLibLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.CommonLibLocalServiceUtil
 */
public class CommonLibLocalServiceImpl extends CommonLibLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.science.service.CommonLibLocalServiceUtil} to access the common lib local service.
	 */
	protected void updateAllLibraries(String headNodeIp, int headNodePort, String headNodeUserId, String headNodePassword) {
		String ldconfigCommand = "/sbin/ldconfig -p";
		try {
			/* Open an ssh connection */
			Connection conn = new Connection(headNodeIp, headNodePort);
			/* Let's try to connect to the host.*/
	        conn.connect();
	        /* Check to see if a user gets authenticated by the host.*/
		    boolean isAuthenticated = conn.authenticateWithPassword(headNodeUserId, headNodePassword);
	        if (isAuthenticated == false) {
	            return;
	        }

	        /* Open an ssh session*/
			Session sess = conn.openSession();
			/* Execute a command */
			sess.execCommand(ldconfigCommand);
	        InputStream instd = new StreamGobbler(sess.getStdout());
			BufferedReader buf_reader = new BufferedReader(new InputStreamReader(instd));
			
			String str = "";
			int lineCnt = 0;
			
			while ((str = buf_reader.readLine()) != null) {
				lineCnt++;
				if(lineCnt == 1) continue;
				
				String libName = "";
				String linuxCLibVer = "";
				String sysArch = "";
				String kernelVer = "";
				String libPath = "";
				int tokenIdx = 0;
				StringTokenizer st = new StringTokenizer(str, "=>|\\(|\\)");
				/****
				 * Parse ldconfig output.
				 */
				while(st.hasMoreTokens()){
					String token = (st.nextToken()).trim();
					if(token.equalsIgnoreCase("")) continue;
					tokenIdx++;
					if(tokenIdx == 1){
						libName = token;
					}
					else if(tokenIdx == 2){
						String[] result = token.split(",");
						int subTokenIdx = 0;
						for (int x=0; x<result.length; x++){
					    	 String temp = (result[x]).trim();
					    	 if(temp.equalsIgnoreCase("")){ continue; }
					    	 subTokenIdx++;
					    	 if(subTokenIdx == 1){
					    		 linuxCLibVer = temp;
					    		 sysArch = "x86";
					    	 }else if(subTokenIdx == 2){
					    		 if(temp.startsWith("x")){
				    				 sysArch = temp;
				    			 }
					    		 else if(temp.startsWith("h")){
				    				 sysArch = "i686";
				    			 }
					    		 else{
				    				 sysArch = "x86";
				    				 temp = (temp.replaceAll("OS ABI: Linux", "")).trim();
				    				 kernelVer = temp;
				    			 }
					    	 }else if(subTokenIdx == 3){
					    		 temp = (temp.replaceAll("OS ABI: Linux", "")).trim();
						    		 kernelVer = temp;
						    	 }
							}
						}else if(tokenIdx == 3){
							libPath = token;	
						}
					}
					/****
					 * Create a library record based on parsed information.
					 * Store each library object into database.
					 */
					CommonLibPK clPK = new CommonLibPK(libName, libPath);
					/* Check an existing entry matching an empty record. */
					CommonLib existingCL = commonLibPersistence.fetchByPrimaryKey(clPK);
					/* If an record is not found, */
					if(existingCL == null){
						/* Let's create a row for representing this record in the library table. */
						CommonLib cl = super.commonLibPersistence.create(clPK);
						/* Set the remaining column values. */
						cl.setCLibVer(linuxCLibVer);
						cl.setKernelVer(kernelVer);
						cl.setSysArch(sysArch);
						try{
							/* Let's update this library row. */
							super.commonLibPersistence.update(cl);
						}catch(Exception ex){
							String msg = ex.getMessage();
							if(msg.contains("Could not execute JDBC batch update")){
								/* If we find an existing record, then let's skip it. 
								 * But this won't happen as we will have already checked the duplicate above.*/
								continue;
							}else{
								buf_reader.close();
								throw new Exception(ex);
							}
						}
					}
			} // end while
			buf_reader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	
	public int countCommonLib(long companyId, String searchValue) throws SystemException {
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("searchValue", searchValue);
		int cnt = commonLibFinder.countCommonLib(searchParam);
		
		if(cnt==0){
			String headNodeIp = PrefsPropsUtil.getString(companyId, EdisonPropsUtil.LIBRARY_SEARCH_IP);
			int headNodePort = PrefsPropsUtil.getInteger(companyId, EdisonPropsUtil.LIBRARY_SEARCH_PORT);
			String headNodeUserId = PrefsPropsUtil.getString(companyId, EdisonPropsUtil.LIBRARY_SEARCH_ID);
			String headNodePassword = PrefsPropsUtil.getString(companyId, EdisonPropsUtil.LIBRARY_SEARCH_PW);
			
			this.updateAllLibraries(headNodeIp, headNodePort, headNodeUserId, headNodePassword);
			
			cnt = commonLibFinder.countCommonLib(searchParam);
		}
		return cnt;
	}
	
	public List<CommonLib> retrieveListCommonLib(String searchValue, int begin, int end) throws SystemException {
		Map<String,Object> searchParam = new HashMap<String,Object>();
		searchParam.put("searchValue", searchValue);
		searchParam.put("begin", begin);
		searchParam.put("end", end);
		return commonLibFinder.retrieveListCommonLib(searchParam);
	}
	
	
}