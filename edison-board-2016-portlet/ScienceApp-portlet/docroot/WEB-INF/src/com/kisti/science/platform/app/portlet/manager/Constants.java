package com.kisti.science.platform.app.portlet.manager;

public class Constants {
	public static final String MYSQL_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String connectString 		   = "jdbc:mysql://150.183.246.46/EDISON";
	public static final String userName 		  	   = "root";
	public static final String password 		  	   = "root";
	
	public static String libKeySeparator = "/";
	/***
	 * Library String Separator
	 */
	public static String LIB_STR_SEPARATOR = "#";
	/***
	 * Message for failed file open
	 */
	public static String FILE_OPEN_FAILURE = "File Open Failure :(";
	/***
	 * Message for successful file open
	 */
	public static String FILE_OPEN_SUCCESS = "File Open Success!";
	public static String SCIENCE_APP_UNDER_TEST_FULL_PATH = "";
	public static String FILE_SEPARATOR = "/";
	public static String SCIENCE_APP_AXIS = "/html/scienceapp/";
	public static String SCIENCE_APP_MANAGER_AXIS = SCIENCE_APP_AXIS + "manager/";
	public static String COMPUTE_HEAD_NODE_USER_ID = "ldconfig-edison";
	public static String COMPUTE_HEAD_NODE_USER_PASSWD = "ldconfig-test";
	public static String COMPUTE_HEAD_NODE_IP_ADDR = "150.183.247.111";
	public static int    COMPUTE_HEAD_NODE_PORT = 22002;
	/***
	 * Science App Engine web service name
	 */
	public static final String SCIENCE_APP_ENGINE = "ScienceAppEngine";
	/***
	 * Tomcat Installation Directory on the development server
	 */
	//public static final String BASE_LOCATION="/usr/local/apache-tomcat-7.0.64/";
	public static final String BASE_LOCATION="/EDISON/SOLVERS/TEST/";
//	/***
//	 * Webapp Directory
//	 */
//	public static final String WEBAPP_LOCATION="webapps/";
	/***
	 * Log file directory name
	 */
	public static final String SAE_LOG_DIR_NAME = BASE_LOCATION + "log-files";
	/***
	 * Debugging model
	 */
	public static final boolean DEBUG_MODE = true;
	/***
	 * Upload File Directory
	 */
	public static final String UPLOAD_LOCATION="data/";
	/***
	 * Uploaded Science App directory
	 */
	public static final String SCIENCE_APP_PARENT_LOCATION = BASE_LOCATION + "sci_apps/";  
	/***
	 * Uploaded Science App Input File directory
	 */
	public static final String SCIENCE_APP_INPUT_FILE_LOCATION = SCIENCE_APP_PARENT_LOCATION;  
	/***
	 * Uploaded Science App Result Folder Name
	 */
	public static final String OUTPUT_DIRECTORY_NAME="result/";
	/***
	 * Uploaded Science App Result Axis Directory
	 */
	public static final String SCIENCE_APP_OUTPUT_FILE_LOCATION = SCIENCE_APP_INPUT_FILE_LOCATION + OUTPUT_DIRECTORY_NAME; 
	/****
	 * Sample module list 
	 */
	public static final String SAMPLE_MODULE_LIST_PATH = BASE_LOCATION + UPLOAD_LOCATION + "module_list";
	/***
	 * Sample an available module list
	 */
	public static final String SAMPLE_MODULE_AVAIL_PATH = BASE_LOCATION + UPLOAD_LOCATION + "module_avail"; 
	/***
	 * Sample library list
	 */
	public static final String SAMPLE_LIBRARY_LIST_PATH = BASE_LOCATION + UPLOAD_LOCATION + "lib_list"; 
	/****
	 * Temporary library deployment repository
	 */
	public static final String INSTALL_LIB_PATH = BASE_LOCATION + "libs/";
}
