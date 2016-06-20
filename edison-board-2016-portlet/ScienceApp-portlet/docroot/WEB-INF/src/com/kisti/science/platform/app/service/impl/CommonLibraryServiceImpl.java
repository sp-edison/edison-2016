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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;




//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelExec;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.Session;
import com.kisti.science.platform.app.model.CommonLibrary;
import com.kisti.science.platform.app.model.impl.CommonLibraryImpl;
import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.kisti.science.platform.app.service.base.CommonLibraryServiceBaseImpl;
import com.kisti.science.platform.app.service.persistence.CommonLibraryPK;
import com.liferay.portal.kernel.exception.SystemException;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * The implementation of the common library remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.CommonLibraryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Young K. Suh
 * @see com.kisti.science.platform.app.service.base.CommonLibraryServiceBaseImpl
 * @see com.kisti.science.platform.app.service.CommonLibraryServiceUtil
 */
public class CommonLibraryServiceImpl extends CommonLibraryServiceBaseImpl {
	
	/*****
	 * Update the library table if any new library is found.
	 * @param headNodeIp the IP address of the head computing node on EDISON (e.g, 150.183.247.11)
	 * @param headNodePort port number (e.g, 22002)
	 * @param headNodeUserId userName for login (e.g., ldconfig-edison)
	 * @param headNodePassword password for login (e.g., ldconfig-test)
	 */
	public void updateAllLibraries(String headNodeIp, int headNodePort, String headNodeUserId, String headNodePassword) {
//System.out.println("The installed library list has been requested!");
// CommonLibrary resLib = commonLibraryPersistence.;
// resLib = this.commonLibraryPersistence.findByLibName(name);
//		String command = "";
//if(!Constants.DEBUG_MODE){
//	command = "ldconfig -p"; 
///}else{
//command = "cat " + Constants.SAMPLE_LIBRARY_LIST_PATH;
// ssh ldconfig-edison@150.183.247.11 -p 22002 
//		command = "ssh " + Constants.COMPUTE_HEAD_NODE_USER_ID+"@"+Constants.COMPUTE_HEAD_NODE_IP_ADDR + " -p 22002 '" + ldconfigCommand+ "'";
////				String tempFileName = "/tmp/ldconfig_output";
////				command = "ssh " + Constants.COMPUTE_NODE_HEAD_USER_ID+"@"+Constants.COMPUTE_NODE_HEAD_IP_ADDR + " -p 22002 '" + ldconfigCommand+ "' > " + tempFileName;
//		//}
//System.out.println("cmd: " + command);
//System.out.println("retriving ...");
		
		/* A command for ldconfig */
		String ldconfigCommand = "/sbin/ldconfig -p";
		try {
//			Runtime rt = Runtime.getRuntime();
//			String[] commandAndArgs = new String[]{ "/bin/sh", "-c", command};
//			Process p1 = rt.exec(commandAndArgs);
//			InputStream instd = p1.getInputStream();
//			JSch jsch=new JSch();
//			Session session=jsch.getSession(Constants.COMPUTE_NODE_HEAD_USER_ID, Constants.COMPUTE_NODE_HEAD_IP_ADDR, 22002);
//			session.setPassword(Constants.COMPUTE_NODE_HEAD_USER_PASSWD);
//			Properties config = new Properties();
//			config.put("StrictHostKeyChecking", "no");
//			session.setConfig(config);
			//System.out.println("session connection try");
			//session.connect();
			//System.out.println("after session connect");
//			ChannelExec channel=(ChannelExec) session.openChannel("exec");
//			System.out.println("open channel");
//			BufferedReader buf_reader=new BufferedReader(new InputStreamReader(channel.getInputStream()));
//			channel.setCommand(ldconfigCommand);
//			System.out.println("channel connect");
//			channel.connect();
			
//			String msg=null;
//			while((msg=in.readLine())!=null){
//			  System.out.println(msg);
//			}
		
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
//				BufferedReader buf_reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(tempFileName))));
			String str = "";
			int lineCnt = 0;
//			Thread.sleep(1000);
//System.out.println("success after 1 sec");
System.out.println("waiting for ldconfig output ...");
			while ((str = buf_reader.readLine()) != null) {
				//System.out.println(str);
				lineCnt++;
				if(lineCnt == 1) continue;
//System.out.println(lineCnt+": " + str);
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
//									System.out.println(token);
					if(tokenIdx == 1){
						libName = token;
					}
//									i686 = 32-bit Intel x86 arch 
//									x86_64 = 64-bit Intel x86 arch
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
//								    				 libm.so.6 (libc6, hwcap: 0x0018000000000000, OS ABI: Linux 2.6.9) => /lib/i686/nosegneg/libm.so.6
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
//System.out.println(libName+"|"+linuxCLibVer+"|"+sysArch+"|"+kernelVer+"|"+libPath);
//					CommonLibraryImpl cl = new CommonLibraryImpl();
//					cl.setLibName(libName);
//					cl.setCLibVer(linuxCLibVer);
//					cl.setSysArch(sysArch);
//					cl.setKernelVer(kernelVer);
//					cl.setLibPath(libPath);
//					cl.persist();
					/****
					 * Create a library record based on parsed information.
					 * Store each library object into database.
					 */
					CommonLibraryPK clPK = new CommonLibraryPK();
					clPK.setLibName(libName);
					clPK.setLibPath(libPath);
					/* Check an existing entry matching an empty record. */
					CommonLibrary existingCL = commonLibraryPersistence.fetchByPrimaryKey(clPK);
					/* If an record is not found, */
					if(existingCL == null){
						/* Let's create a row for representing this record in the library table. */
						CommonLibrary cl = super.commonLibraryPersistence.create(clPK);
						/* Set the remaining column values. */
						cl.setCLibVer(linuxCLibVer);
						cl.setKernelVer(kernelVer);
						cl.setSysArch(sysArch);
						try{
							/* Let's update this library row. */
							super.commonLibraryPersistence.update(cl);
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
//				InputStream errstd = p1.getErrorStream();
//				BufferedReader buf_err_reader = new BufferedReader(
//						new InputStreamReader(errstd));
//				System.out.println("error");
//				while ((str = buf_err_reader.readLine()) != null) {
//					System.out.println(str);
//				}
//				buf_err_reader.close();
//			p1.waitFor();
//			channel.disconnect();
//			session.disconnect();
		} catch (Exception ex) {
			//ex.printStackTrace();
			//System.err.println(ex.getMessage());
		}		
	}
	
	/*****
	 * Retrieve all libraries installed on EDISON cluster.
	 * If there's a new library found, then database will be updated with that entry.
	 * @param libName library name, but not used
	 * @param headNodeIp the ip address of the head computing node
	 * @param headNodePort port number for access
	 * @param headNodeUserId user id for access
	 * @param headNodePassword password for access
	 * @return a list of all CommonLibrary objects
	 */
	public List<CommonLibrary> retrieveAllLibraries(String libName, String headNodeIp, int headNodePort, String headNodeUserId, String headNodePassword) {

		updateAllLibraries(headNodeIp, headNodePort, headNodeUserId, headNodePassword);
		
		List<CommonLibrary> resList = null;
		try {
			resList = super.commonLibraryPersistence.findAll();
System.out.println("The installed library list has been returned!");
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resList;
	}

//	public List<CommonLibrary> retrieveLibrary(String name) {
//		List<CommonLibrary> resLibList = new ArrayList<CommonLibrary>();
//		if(name == null || name == ""){ return resLibList; }
//		
//		try {
//			List<CommonLibrary> resList = this.commonLibraryPersistence.findAll();
//			// if there's no common lib found, then retrieve again.
//			if(resList.size() == 0){
//				retrieveAllLibraries();
//			}
//			for(int i=0;i<resList.size();i++){
//				CommonLibrary cl = (CommonLibrary)resList.get(i);
//				String libName = cl.getLibName();
//				if(libName.contains(name)){
//					resLibList.add(cl);
//				}
//			}
//System.out.println("The installed library list has been returned!:" + resLibList.size());
//		} catch (SystemException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//for(int i=0;i<resLibList.size();i++){
//	System.out.println(resLibList.get(i).getLibName());
//}
//		return resLibList;
//	}
	
	/*****
	 * Retrieve specific library records matching a given name.
	 * @param name library name
	 * @param headNodeIp the IP address of the head node
	 * @param headNodePort port number
	 * @param headNodeUserId user id for access
	 * @param headNodePassword password 
	 * @return a list of CommonLibrary objects matching the condition of a given name
	 */
	public List<CommonLibrary> retrieveLibrary(String name, String headNodeIp, int headNodePort, String headNodeUserId, String headNodePassword) {
		List<CommonLibrary> resLibList = null;
		if(name == null || name == ""){ return null; }
		
		try {
			resLibList = this.commonLibraryPersistence.findByLibName(name);
			// if there's no common lib found, then retrieve again.
//			if(resList.size() == 0){
//				resList = retrieveAllLibraries("", headNodeIp, headNodePort, headNodeUserId, headNodePassword);
//			}
//			for(int i=0;i<resList.size();i++){
//				CommonLibrary cl = (CommonLibrary)resList.get(i);
//				String libName = cl.getLibName();
//				if(libName.contains(name)){
//					resLibList.add(cl);
//				}
//			}
//System.out.println("The installed library list has been returned!:" + resLibList.size());
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resLibList;
	}
	
//	JSch jsch = new JSch();
//	Session session = null;
//	session = jsch.getSession("username","hostname",22);
//	session.setPassword("password");
//	session.setConfig("StrictHostKeyChecking", "no");
//	    session.connect();
//	ChannelSftp channel = null;
//	channel = (ChannelSftp)session.openChannel("sftp");
//	channel.connect();
//	    File localFile = new File("localfilepath");
//	    //If you want you can change the directory using the following line.
//	    channel.cd(RemoteDirectoryPath)
//	channel.put(new FileInputStream(localFile),localFile.getName());
//	    channel.disconnect();
//	session.disconnect();
}