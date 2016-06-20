package com.kisti.science.platform.app.service.constants;

import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

public class ScienceAppConstants {
	public final static String APP_TYPE_EDITOR = "Editor";
	public final static String APP_TYPE_STATIC_SOLVER = "Static Solver";
	public final static String APP_TYPE_DYNAMIC_SOLVER = "Dynamic Solver";
	public final static String APP_TYPE_STATIC_CONVERTER = "Static Converter";
	public final static String APP_TYPE_DYNAMIC_CONVERTER = "Dynamic Converter";
	public final static String APP_TYPE_ANALYZER = "Analyzer";
	
	public final static String APP_RUNTYPE_SEQUENTIAL= "Sequential";
	public final static String APP_RUNTYPE_PARALLEL = "Parallel";
	
	public final static String EMPTY= "EMPTY";
	public final static String GENERAL_INFO_READY = "GENERAL_INFO_READY";
	public final static String INPUT_PORT_READY = "INPUT_PORT_READY";
	public final static String OUTPUT_PORT_READY = "OUTPUT_PORT_READY";
	public final static String EXECUTION_INFO_READY = "EXECUTION_INFO_READY";
	public final static String TEST_OK = "TEST_OK";
	public final static String IN_SERVICE = "IN_SERVICE";
	public final static String DEACTIVATED= "DEACTIVATED";
	public final static String RETURNED_TO_MAKEUP = "RETURNED_TO_MAKEUP";
	public final static String TEST_FAILED = "TEST_FAILED";
	public final static String WITHDRAWN = "WITHDRAWN";
	public final static String ORPHANIZED="ORPHANIZED";
	
	public final static String OPENLEVEL_SRC="OPEN_SOURCE";
	public final static String OPENLEVEL_BIN="OPEN_BINARY";
	public final static String OPENLEVEL_RUN="OPEN_RUN_ONLY";
	
	public final static String INPUT_PORT_ATTR_NAME="name";
	public final static String INPUT_PORT_ATTR_PORTTYPE_ID="port-type-id";
	public final static String INPUT_PORT_ATTR_EDITOR_ID="default-editor-id";
	public final static String INPUT_PORT_ATTR_MANDATORY="mandatory";
	public final static String OUTPUT_PORT_ATTR_NAME=INPUT_PORT_ATTR_NAME;
	public final static String OUTPUT_PORT_ATTR_PORTTYPE_ID=INPUT_PORT_ATTR_PORTTYPE_ID;
	public final static String OUTPUT_PORT_ATTR_ANALYZER_ID="default-analyzer-id";
	public final static String OUTPUT_PORT_ATTR_FILENAME="filename";
	
	public final static String DEFAULT_SRC_DIR="src";
	public final static String DEFAULT_BIN_DIR="bin";

	public final static String SCIENCEAPP_VALID_NAME_EXPR = "[a-zA-Z][a-zA-Z0-9\\-\\.\\+\\_]+";
	public final static String SCIENCEAPP_VALID_VERSION_EXPR = "[1-9][0-9]*\\.(0|[1-9][0-9]*)\\.(0|[1-9][0-9]*)";
	public final static String SCIENCEAPP_VALID_PORT_NAME_EXPR = "[a-zA-Z][a-zA-Z0-9\\_]+";
	
	public final static String[] getScienceAppTypes(){
		String[] types = {
				APP_TYPE_EDITOR,
				APP_TYPE_STATIC_SOLVER,
				APP_TYPE_DYNAMIC_SOLVER,
				APP_TYPE_STATIC_CONVERTER,
				APP_TYPE_DYNAMIC_CONVERTER,
				APP_TYPE_ANALYZER
		};
		return types;
	}
	
	public final static String[] getScienceAppRunTypes(){
		String[] types = {
				APP_RUNTYPE_SEQUENTIAL,
				APP_RUNTYPE_PARALLEL
		};
		
		return types;
	}
	
	public final static String[] getScienceAppStages(){
		String[] stages = {
				EMPTY,
				GENERAL_INFO_READY,
				INPUT_PORT_READY,
				OUTPUT_PORT_READY,
				EXECUTION_INFO_READY,
				TEST_OK,
				IN_SERVICE,
				DEACTIVATED,
				RETURNED_TO_MAKEUP,
				TEST_FAILED,
				WITHDRAWN,
				ORPHANIZED
		};
		
		return stages;
	}
	
	public final static String[] getScienceAppOpenLevels(){
		String[] openLevels = {
				OPENLEVEL_SRC,
				OPENLEVEL_BIN,
				OPENLEVEL_RUN
		};
		
		return openLevels;
	}
	
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
	public static String MODULE_CMD = "/usr/bin/modulecmd bash";
	public final static String AUTH_FAILURE = "Authenication Failed";
	public final static String NO_MODULE_UPLOAD = "No Modulefiles Currently Loaded";
	public final static String SUCCESS = "Success";
	/***
	 * Science App Engine web service name
	 */
	public static final String SCIENCE_APP_ENGINE = "ScienceAppEngine";
	/***
	 * Tomcat Installation Directory on the development server
	 */
	//public static final String BASE_LOCATION="/usr/local/apache-tomcat-7.0.64/";
//	public static final String BASE_LOCATION="/EDISON/SOLVERS/TEST/";
	public static final String BASE_LOCATION="/EDISON/SOLVERS/";
	public static final String APP_TEST_DIR_NAME_SEPARATOR="/";
	public static final String APP_VER_PREFIX="v";
	public static final String APP_TEST_BIN_DIR="bin/";
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
