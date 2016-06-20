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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import com.kisti.science.platform.app.model.CommonModule;
import com.kisti.science.platform.app.model.impl.CommonModuleImpl;
//import com.kisti.science.platform.app.portlet.manager.Constants;
import com.kisti.science.platform.app.service.base.CommonModuleServiceBaseImpl;
import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the common module remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.CommonModuleService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Young K. Suh
 * @see com.kisti.science.platform.app.service.base.CommonModuleServiceBaseImpl
 * @see com.kisti.science.platform.app.service.CommonModuleServiceUtil
 */
public class CommonModuleServiceImpl extends CommonModuleServiceBaseImpl {
	
	/*****
	 * Update the module table if any new module is found.
	 * @param headNodeIp the IP address of the head computing node on EDISON (e.g, 150.183.247.11)
	 * @param headNodePort port number (e.g, 22002)
	 * @param headNodeUserId userName for login (e.g., ldconfig-edison)
	 * @param headNodePassword password for login (e.g., ldconfig-test)
	 */
	public boolean updateModules(String headNodeIp, int headNodePort, String headNodeUserId, String headNodePassword) {
System.out.println("Let's update module table.");
		// The next two lines should be replaced by the next third line when
		// being in service.
		//String mod_list_path = moduleListPath;
		String command = "";
//		if (!debugMode) {
//			command = "module list";
//		} else {
//			command = "cat " + mod_list_path;
//		}
//		command = "module list";
		command = "/usr/bin/modulecmd bash avail";
		
		try {
//			// Create a Runtime instance.
//			Runtime rt = Runtime.getRuntime();
//			// Execute the command.
//			Process p1 = rt.exec(command);
//			// Read the input stream.
//			InputStream instd = p1.getInputStream();
//			// Create a buffered reader
//			BufferedReader buf_reader = new BufferedReader(
//					new InputStreamReader(instd));
			/* Open an ssh connection */
			Connection conn = new Connection(headNodeIp, headNodePort);
			/* Let's try to connect to the host.*/
	        conn.connect();
	        /* Check to see if a user gets authenticated by the host.*/
		    boolean isAuthenticated = conn.authenticateWithPassword(headNodeUserId, headNodePassword);
	        if (isAuthenticated == false) {
	            return false;
	        }
System.out.println(command);
	        /* Open an ssh session*/
			Session sess = conn.openSession();
			/* Execute a command */
			sess.execCommand(command);
			
//			InputStream err_instd = new StreamGobbler(sess.getStderr());
//			BufferedReader err_buf_reader = new BufferedReader(new InputStreamReader(err_instd));
//			String errMsg = "";
//			String errorLine = "";
//			while ((errorLine = err_buf_reader.readLine()) != null) {
//				//errorFlag = true;
//System.out.println(errorLine);	
//				errMsg += errorLine;
//			}
//			// Close the buffered reader instance.
//			err_buf_reader.close();
//			
//			if(errMsg.length() > 0){
//				 return errMsg;
//			}
//			
//			InputStream instd = new StreamGobbler(sess.getStdout());
//			BufferedReader buf_reader = new BufferedReader(new InputStreamReader(instd));
			InputStream instd = new StreamGobbler(sess.getStderr());
			BufferedReader buf_reader = new BufferedReader(new InputStreamReader(instd));
			// Declare a temporary variable to contain a line.
			String line = "";
			// Declare a temporary variable to store a line count.
			int lineCnt = 0;
			// Print out each line for a check
			// System.out.println(lineCnt+": " + line);
			// Declare a temp. var. for storing a module name.
			String modName = "";
			// Declare a temp. var. for storing a module path.
			String modPath = "";
			// Declare a temp. var. for indicating whether to have a root
			// directory for a module.
			boolean isNewModuleRootPath = false;
			
			/***
			 * Parse the module command's output.
			 * And then create a CommonModule object and insert it into database for future access.
			 */
			// Begin to read each line from given output (or given file).
			while ((line = buf_reader.readLine()) != null) {
System.out.println(line);
				// Trim this line.
				line = line.trim();
				// If there's nothing then skip this line.
				if (line.equalsIgnoreCase(""))
					continue;
				// Increment line count.
				lineCnt++;
				// If line count is one, then
				if (lineCnt % 2 == 1) {
					// Use tokenizer to parse a line.
					// An example of a line to be parsed:
					// ------------------------------------------------------------------------------------
					// /usr/share/Modules/modulefiles --------
					// , and so on.
					StringTokenizer st = new StringTokenizer(line, "-|\t| ");
					// Let's use a separator like ')'.
					while (st.hasMoreTokens()) {
						// Get a parsed token
						String token = (st.nextToken()).trim();
						// If this token doesn't have anything, then skip it.
						if (token.equalsIgnoreCase(""))
							continue;
						// Check if the current root path is not null, and token
						// starts with a directory name
						if (!isNewModuleRootPath && token.startsWith("/")) {
							// This will be a module parent path.
							modPath = token;
							// Set the flag to indicate we're in this root path.
							isNewModuleRootPath = true;
							// Let' get out this loop.
							break;
						}
					}
				} else {
					// Use tokenizer to parse a line.
					// An example of a line to be parsed:
					// dot module-git module-info modules null use.own
					StringTokenizer st = new StringTokenizer(line, "\t| ");
					// Let's use a separator like ')'.
					while (st.hasMoreTokens()) {
						// Get a parsed token
						String token = (st.nextToken()).trim();
						if (token.equalsIgnoreCase(""))
							continue;
						// Get the module name
						modName = token;
						// If the module name is equal to 'null', then we skip
						// it.
						if (modName.equalsIgnoreCase("null"))
							continue;
						// Let's print out the name of the parsed module.
						// System.out.println("module name: "+modName +
						// ", path: " + modPath);
						// Create an instance of Module.
						CommonModule mod = super.commonModulePersistence.create(modName);
						mod.setModuleRootDir(modPath);
System.out.println(modName+"|"+modPath);
						try{
							/* Let's update this library row. */
							super.commonModulePersistence.update(mod);
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
						// Add this module to the available vector
//									availModList.add(mod);
					}
					// Reset this flag for iterating the next root path.
					isNewModuleRootPath = false;
				}
			}		
			// Close the buffered reader instance.
			buf_reader.close();
			// Let's wait for the Runtime instance to be done.
//			p1.waitFor();
			sess.close();
			conn.close();
		} catch (Exception ex) {
			// ex.printStackTrace();
			// Print out any message when an error(s) occurs.
			System.err.println(ex.getMessage());
		}
		return true;
	}
	
	/****
	 *  Retrieve all modules already installed.
	 * @param headNodeIp the ip address of the head computing node
	 * @param headNodePort port number for access
	 * @param headNodeUserId user id for access
	 * @param headNodePassword password for access
	 * @return a list of all CommonModule objects
	 */
	public List<CommonModule> retrieveAllModules(String headNodeIp, int headNodePort, String headNodeUserId, String headNodePassword) {
		
		List<CommonModule> resList = new ArrayList<CommonModule>();
		try {
			resList = this.commonModulePersistence.findAll();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(resList.size() == 0){
			System.out.println("No modules retrieved.");
			// update module data
			boolean errMsg = updateModules(headNodeIp, headNodePort, headNodeUserId, headNodePassword);
			if(!errMsg){
				return null;
			}
//			else if(errMsg.contains(Constants.AUTH_FAILURE)){
//				
//			}
		}else{
			System.out.println("There are some modules retrieved from database.");
		}
		
		return resList;
	}

	/*****
	 *  Retrieve installed modules by keyword
	 * @param mod_name module name
	 * @param headNodeIp the ip address of the head computing node
	 * @param headNodePort port number for access
	 * @param headNodeUserId user id for access
	 * @param headNodePassword password for access
	 * @return a list of modules found
	 * @throws SystemException system exception thrown in this routine
	 */
	public List<CommonModule> retrieveModule(String mod_name, String headNodeIp, int headNodePort, String headNodeUserId, String headNodePassword) throws SystemException{
		// declare a vector of modules listed by the command.
//		List<CommonModule> foundModList = null;
		if (mod_name == null) {
			return null;
		}

		// We internally invoke retrieveAllModules() and
		// then search for a library(ies) to contain a given module name
		// (modname)
		//List<CommonModule> allList = retrieveAllModules(headNodeIp, headNodePort, headNodeUserId, headNodePassword);

		// If this list has some modules,
//		if (allList.size() > 0) {
//			// then let's iterate each element and add it to the list.
//			for (int i = 0; i < allList.size(); i++) {
//				// Let's get an indexed library item.
//				CommonModule mod = allList.get(i);
//				String modName = mod.getModuleName();
//				// If this module matches the given mod_name,
//				if (modName.contains(mod_name)) {
//					// then let's add this module.
//					foundModList.add(mod);
//				}
//			}
//		}
		
		return super.commonModulePersistence.findByModuleName(mod_name);
	}

//	public void locateAvailModules() {
//		// The next two lines should be replaced by the next third line when
//		// being in service.
////		String mod_list_path = sampleModuleAvailPath;
//		String command = "";
////		if (!debugMode) {
////			command = "module avail";
//		command = "/usr/bin/modulecmd bash avail";
////		} else {
////			command = "cat " + mod_list_path;
////		}
//		try {
////			// Create a Runtime instance.
////			Runtime rt = Runtime.getRuntime();
////			// Execute the command.
////			Process p1 = rt.exec(command);
////			// Read the input stream.
////			InputStream instd = p1.getInputStream();
//			
//			/* Open an ssh connection */
//			Connection conn = new Connection(Constants.COMPUTE_HEAD_NODE_IP_ADDR, Constants.COMPUTE_HEAD_NODE_PORT);
//			/* Let's try to connect to the host.*/
//	        conn.connect();
////System.out.println("before authentication check.");
//	        /* Check to see if a user gets authenticated by the host.*/
//		    boolean isAuthenticated = conn.authenticateWithPassword(Constants.COMPUTE_HEAD_NODE_USER_ID, Constants.COMPUTE_HEAD_NODE_USER_PASSWD);
//	        if (isAuthenticated == false) {
//	            return;
//	        }
////System.out.println("after authentication check.");
////System.out.println("before execute " + command);
//	        /* Open an ssh session*/
//			Session sess = conn.openSession();
//			/* Execute a command */
//			sess.execCommand(command);
////System.out.println("after execute " + command);			
//
////			InputStream err_instd = new StreamGobbler(sess.getStderr());
////			BufferedReader err_buf_reader = new BufferedReader(new InputStreamReader(err_instd));
////			String errMsg = "";
////			String errorLine = "";
////			while ((errorLine = err_buf_reader.readLine()) != null) {
////				//errorFlag = true;
////			System.out.print(errorLine);	
////				errMsg += errorLine;
////			}
////			// Close the buffered reader instance.
////			err_buf_reader.close();
////			
////			if(errMsg.length() > 0){
////System.err.println("after execute " + command);		
////			}
//	
////	        InputStream instd = new StreamGobbler(sess.getStdout());
//////			// Create a buffered reader
////	        BufferedReader buf_reader = new BufferedReader(new InputStreamReader(instd));
//			
//	        InputStream instd = new StreamGobbler(sess.getStderr());
////			// Create a buffered reader
//	        BufferedReader buf_reader = new BufferedReader(new InputStreamReader(instd));
//	        
//			// Close the buffered reader instance.
//			buf_reader.close();
//			// Let's wait for the Runtime instance to be done.
////			p1.waitFor();
//		} catch (Exception ex) {
//			// ex.printStackTrace();
//			// Print out any message when an error(s) occurs.
//			System.err.println(ex.getMessage());
//		}
//	}
	
//	/****
//	 * Retrieve available modules
//	 * 
//	 * @return a list of modules available
//	 */
//	public List<CommonModule> retrieveAvailModules() {
//System.out.println("Called available module.");
//		
//		// find all available modules.
//
//
//
//		// otherwise, populate module data.
//		locateAvailModules();
//		
//		// declare a vector of modules listed by the command.
//		List<CommonModule> availModList = new Vector<CommonModule>();
//			
//		// Have access database and return available modules.
//		return availModList;
//	}

//	/****
//	 * Unload all modules
//	 * @param mod_name module name to be loaded
//	 * @return result message
//	 */
//	public String unloadAllModules() {
//		String res = "";
//System.out.println("We start to unload all modules.");
////		if (debugMode) {
////			return "Loading '" + mod_name + "' Succeeded!";
////		} else {
//			try {
//				//String command = Constants.MODULE_CMD+" load " + mod_name;
////				String command = "module load " + mod_name;
//				String command = "perl -i -nle 'print unless /module/' .bashrc";
//System.out.println("command: " + command);
//				/* Open an ssh connection */
//				Connection conn = new Connection(Constants.COMPUTE_HEAD_NODE_IP_ADDR, Constants.COMPUTE_HEAD_NODE_PORT);
//				/* Let's try to connect to the host.*/
//				conn.connect();
//				/* Check to see if a user gets authenticated by the host.*/
//				boolean isAuthenticated = conn.authenticateWithPassword(Constants.COMPUTE_HEAD_NODE_USER_ID, Constants.COMPUTE_HEAD_NODE_USER_PASSWD);
//				if (isAuthenticated == false) {
//				    return null;
//				}
//				
//				/* Open an ssh session*/
//				Session sess = conn.openSession();
//				/* Execute a command */
//				sess.execCommand(command);
//				InputStream instd = new StreamGobbler(sess.getStdout());
//				//// Create a buffered reader
//				BufferedReader buf_reader = new BufferedReader(
//						new InputStreamReader(instd));
//				
//				String temp = null, tmp_data = "";
//				while ((temp = buf_reader.readLine()) != null) {
//					tmp_data += temp;
//				}
////				if (tmp_data.equalsIgnoreCase("")) {
////					res = "Unloading all modules succeeded!";
////				}
////System.out.println(tmp_data);
//				buf_reader.close();
//				
////				InputStream errstd = p0.getErrorStream();
////				BufferedReader buf_err_reader = new BufferedReader(
////						new InputStreamReader(errstd));
//				
//				/* Get error streams if any */
//				InputStream errstd = new StreamGobbler(sess.getStderr());
//				//// Create a buffered reader
//				BufferedReader buf_err_reader = new BufferedReader(
//						new InputStreamReader(errstd));
//				
//				String tmp_err_data = "";
//				temp = null;
//				while ((temp = buf_err_reader.readLine()) != null) {
//					tmp_err_data += temp;
//				}
////				if (!tmp_err_data.equalsIgnoreCase("")) {
////					res = "Loading '" + mod_name + "' Failed, due to "
////							+ tmp_data + "";
////				}
////System.err.println(tmp_err_data);
//				buf_err_reader.close();
//				//p0.waitFor();
//				
//				command = Constants.MODULE_CMD+" list";
//				command = "list";
//System.out.println("command: " + command);
//				/* Execute a command */
//				sess.execCommand(command);
//				instd = new StreamGobbler(sess.getStdout());
//				//// Create a buffered reader
//				buf_reader = new BufferedReader(
//						new InputStreamReader(instd));
//				
//				temp = null; tmp_data = "";
//				boolean error = false;
//				while ((temp = buf_reader.readLine()) != null) {
//					tmp_data += temp;
//					if(tmp_data.contains("Currently Loaded Modulefiles")){
//						error = true;
//						break;
//					}
//				}
//				buf_reader.close();
//				
//				if(error){
//					res = "Unloading all modules failed...";
//				}else{
//					instd = new StreamGobbler(sess.getStderr());
//					//// Create a buffered reader
//					buf_err_reader = new BufferedReader(
//							new InputStreamReader(instd));
//					while ((temp = buf_err_reader.readLine()) != null) {
//						tmp_err_data += temp;
//						if(tmp_err_data.contains("No Modulefiles Currently Loaded")){
//							error = false;
//							break;
//						}
//					}
//					buf_reader.close();
//					res = "Unloading all modules failed!";			
//				}
//				
//				sess.close();
//				conn.close();
//			} catch (Exception ex) {
//				ex.printStackTrace();
//			}
//System.out.println(res);
//			return res;
////		}		
//	}
	
	/****
	 * Unload a specific module
	 * @param mod_name module name to be loaded
	 * @return result message
	 */
	/*public String unloadModule(String mod_name) {
		String res = "";
System.out.println("We start to unload  module '" + mod_name + "'");
//		if (debugMode) {
//			return "Loading '" + mod_name + "' Succeeded!";
//		} else {
			try {
				//String command = Constants.MODULE_CMD+" load " + mod_name;
//				String command = "module load " + mod_name;
//				cmd = "perl -i -nle 'print unless /module.+modules/' .bashrc"
				String command = "";
				if(mod_name.equalsIgnoreCase("")){ // all modules
					command = "perl -i -nle 'print unless /module/' .bashrc";
				}else{ // a specific module
					command = "perl -i -nle 'print unless /module.+"+mod_name+"/' .bashrc";
				}
System.out.println("command: " + command);

				 Open an ssh connection 
				Connection conn = new Connection(ScienceAppConstants.COMPUTE_HEAD_NODE_IP_ADDR, ScienceAppConstants.COMPUTE_HEAD_NODE_PORT);
				 Let's try to connect to the host.
				conn.connect();
				 Check to see if a user gets authenticated by the host.
				boolean isAuthenticated = conn.authenticateWithPassword(ScienceAppConstants.COMPUTE_HEAD_NODE_USER_ID, ScienceAppConstants.COMPUTE_HEAD_NODE_USER_PASSWD);
				if (isAuthenticated == false) {
				    return null;
				}
				
				 Open an ssh session
				Session sess = conn.openSession();
				 Execute a command 
				sess.execCommand(command);
				InputStream instd = new StreamGobbler(sess.getStdout());
				//// Create a buffered reader
				BufferedReader buf_reader = new BufferedReader(
						new InputStreamReader(instd));
				
				String temp = null, tmp_data = "";
				while ((temp = buf_reader.readLine()) != null) {
					tmp_data += temp;
				}
				buf_reader.close();
				
				 Get error streams if any 
				InputStream errstd = new StreamGobbler(sess.getStderr());
				//// Create a buffered reader
				BufferedReader buf_err_reader = new BufferedReader(
						new InputStreamReader(errstd));
				
				String tmp_err_data = "";
				temp = null;
				while ((temp = buf_err_reader.readLine()) != null) {
					tmp_err_data += temp;
				}
				buf_err_reader.close();
				//p0.waitFor();
				
System.out.println("std out:"+tmp_data);
System.err.println("std err:"+tmp_data);
				// if no error is received
				if (tmp_err_data.equalsIgnoreCase("") && tmp_data.equalsIgnoreCase("")) {
					// check if it's still not found on the compute server
					command = ScienceAppConstants.MODULE_CMD+" list";
					sess = conn.openSession();
					 Execute a command 
					sess.execCommand(command);
					instd = new StreamGobbler(sess.getStdout());
					//// Create a buffered reader
					buf_err_reader = new BufferedReader(
							new InputStreamReader(instd));
					
					temp = null; tmp_data = "";
					boolean found = false;
					while ((temp = buf_err_reader.readLine()) != null) {
						tmp_data += temp;
						if(mod_name.equalsIgnoreCase("")){ // all modules
							if(!tmp_data.contains("No Modulefiles Currently Loaded")){
								found = true; 
							}
							break;
						}else{ // a specific module
							if(tmp_data.contains(mod_name)){
								found = true; // right behavior
								break;
							}
						}
					}
					buf_err_reader.close();
					
					if(!found){
						List<CommonModule> foundModList = null;
						if(mod_name.equalsIgnoreCase("")){
							foundModList = retrieveAllModules();
							for(int i=0;i<foundModList.size();i++){
								CommonModule cm = foundModList.get(i);
								cm.setIsLoaded(false);
								this.commonModulePersistence.update(cm);
							}
							res = "Unloading all modules succeeded!";
						}else{
							foundModList = retrieveModule(mod_name);
							if(foundModList.size() > 0){
								CommonModule cm = foundModList.get(0);
								cm.setIsLoaded(false);
								this.commonModulePersistence.update(cm);
							}else{
								
							}
						}
					}else{
						// A module seems still loaded...
						if(mod_name.equalsIgnoreCase(""))
							res = "Unloading all modules failed...";
						else
							res = "Unloading '" + mod_name + "' failed...";
					}
				}else{
					// A module seems still loaded...
					if(mod_name.equalsIgnoreCase(""))
						res = "Unloading all modules failed...";
					else
						res = "Unloading '" + mod_name + "' failed...";
				}
				sess.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
System.out.println(res);
			return res;
//		}
	}
*/	
	/****
	 * Loading a specific module
	 * @param mod_name module name to be loaded
	 * @return result message
	 */
/*	public String loadModule(String mod_name) {
		String res = "";
System.out.println("We start to install module '" + mod_name + "'");
//		if (debugMode) {
//			return "Loading '" + mod_name + "' Succeeded!";
//		} else {
			try {
				//String command = Constants.MODULE_CMD+" load " + mod_name;
//				String command = "module load " + mod_name;
//				cmd = "perl -i -nle 'print unless /module.+modules/' .bashrc"
				String command = "perl -i -nle 'print unless /module.+"+mod_name+"/' .bashrc" + ";echo \"module " + "load " + mod_name + "\" >> .bashrc";
System.out.println("command: " + command);
//				// Construct a command and its arguments
//				String[] commandAndArgs = new String[] { "/bin/sh", "-c",
//						command };
//				Runtime rt = Runtime.getRuntime();
//				Process p0 = rt.exec(commandAndArgs);
//				InputStream instd = p0.getInputStream();

				 Open an ssh connection 
				Connection conn = new Connection(ScienceAppConstants.COMPUTE_HEAD_NODE_IP_ADDR, ScienceAppConstants.COMPUTE_HEAD_NODE_PORT);
				 Let's try to connect to the host.
				conn.connect();
				 Check to see if a user gets authenticated by the host.
				boolean isAuthenticated = conn.authenticateWithPassword(ScienceAppConstants.COMPUTE_HEAD_NODE_USER_ID, ScienceAppConstants.COMPUTE_HEAD_NODE_USER_PASSWD);
				if (isAuthenticated == false) {
				    return null;
				}
				
				 Open an ssh session
				Session sess = conn.openSession();
				 Execute a command 
				sess.execCommand(command);
				InputStream instd = new StreamGobbler(sess.getStdout());
				//// Create a buffered reader
				BufferedReader buf_reader = new BufferedReader(
						new InputStreamReader(instd));
				
				String temp = null, tmp_data = "";
				while ((temp = buf_reader.readLine()) != null) {
					tmp_data += temp;
				}
				if (tmp_data.equalsIgnoreCase("")) {
					res = "Loading '" + mod_name + "' Succeeded!";
				}
System.out.println(tmp_data);
				buf_reader.close();
				
//				InputStream errstd = p0.getErrorStream();
//				BufferedReader buf_err_reader = new BufferedReader(
//						new InputStreamReader(errstd));
				
				 Get error streams if any 
				InputStream errstd = new StreamGobbler(sess.getStderr());
				//// Create a buffered reader
				BufferedReader buf_err_reader = new BufferedReader(
						new InputStreamReader(errstd));
				
				String tmp_err_data = "";
				temp = null;
				while ((temp = buf_err_reader.readLine()) != null) {
					tmp_err_data += temp;
				}
//				if (!tmp_err_data.equalsIgnoreCase("")) {
//					res = "Loading '" + mod_name + "' Failed, due to "
//							+ tmp_data + "";
//				}
//System.err.println(tmp_err_data);
				buf_err_reader.close();
				//p0.waitFor();
				
				command = ScienceAppConstants.MODULE_CMD+" list";
				 Execute a command 
				sess = conn.openSession();
				sess.execCommand(command);
				instd = new StreamGobbler(sess.getStdout());
				//// Create a buffered reader
				buf_reader = new BufferedReader(
						new InputStreamReader(instd));
				
				temp = null; tmp_data = "";
				boolean found = false;
				while ((temp = buf_reader.readLine()) != null) {
					tmp_data += temp;
					if(tmp_data.contains(mod_name)){
						res = "'" + mod_name + "' successfully installed!";
						found = true;
						break;
					}
				}
				buf_reader.close();
				
				if(found){
					List<CommonModule> foundModList = retrieveModule(mod_name);
					if(foundModList == null || foundModList.size() == 0){
						res = tmp_err_data;
System.out.println("Failed to load a requested module is done: " + mod_name);							
					}else{
						CommonModule cm = foundModList.get(0);
						if(!cm.isIsLoaded()){
							cm.setIsLoaded(true);
							this.commonModulePersistence.update(cm);
						}
					}
System.out.println("Loading a requested module is done: " + mod_name);	
				}else{
					res = tmp_err_data;
System.out.println("Failed to load a requested module is done: " + mod_name);					
				}
				
				sess.close();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
System.out.println(res);
			return res;
//		}
	}
	*/
}