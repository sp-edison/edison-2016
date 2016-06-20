package org.kisti.edison.science.service.constants;

public class ScienceAppConstants {
	public final static String APP_TYPE_SOLVER = "Solver";
	public final static String APP_TYPE_CONVERTER = "Converter";
	
	public final static String APP_TYPE_EDITOR = "Editor";
	public final static String APP_TYPE_ANALYZER = "Analyzer";
	public final static String APP_TYPE_DYNAMIC_SOLVER = "Dynamic Solver";
	public final static String APP_TYPE_DYNAMIC_CONVERTER = "Dynamic Converter";
	public final static String APP_TYPE_OPTIMAL_SOLVER = "Optimal Solver";
	
	public final static String EDITOR_TYPE_STRING = "String";
	public final static String EDITOR_TYPE_INPUT_DECK = "Inputdeck";
	public final static String EDITOR_TYPE_FILE = "File";
	
	public final static String APP_RUNTYPE_SEQUENTIAL= "Sequential";
	public final static String APP_RUNTYPE_PARALLEL = "Parallel";
	
	public final static String PARALLER_MODULE_GAMESS_PARALLEL	= "Gamess_parallel";  
	public final static String PARALLER_MODULE_GNU_OPENMP_MPI	= "Gnu_openmp_mpi";     
	public final static String PARALLER_MODULE_GNU_MPICH_1		= "Gnu_mpich_1";        
	public final static String PARALLER_MODULE_GNU_MPICH_2		= "Gnu_mpich_2";        
	public final static String PARALLER_MODULE_GNU_OPENMPI_1_4	= "Gnu_openmpi_1_4";    
	public final static String PARALLER_MODULE_GNU_OPENMP		= "Gnu_openmp";         
	public final static String PARALLER_MODULE_INTEL_OPENMP_MPI	= "Intel_openmp_mpi";   
	public final static String PARALLER_MODULE_INTEL_MPICH_1	= "Intel_mpich_1";      
	public final static String PARALLER_MODULE_INTEL_MPICH_2	= "Intel_mpich_2";      
	public final static String PARALLER_MODULE_INTEL_OPENMPI_1_4	= "Intel_openmpi_1_4";  
	public final static String PARALLER_MODULE_INTEL_OPENMP		= "Intel_openmp";
	
	
	
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
	
	public final static String[] getScienceAppSwTypes(){
		String[] types = {
				APP_TYPE_SOLVER,
				APP_TYPE_CONVERTER
		};
		return types;
	}
	
	
	public final static String[] getScienceAppEditorTypes(){
		String[] types = {
				APP_TYPE_EDITOR,
				APP_TYPE_ANALYZER,
				APP_TYPE_DYNAMIC_SOLVER,
				APP_TYPE_DYNAMIC_CONVERTER,
				APP_TYPE_OPTIMAL_SOLVER
		};
		return types;
	}
	
	public final static String[] getEditorTypes(){
		String[] types = {
				EDITOR_TYPE_STRING,
				EDITOR_TYPE_INPUT_DECK,
				EDITOR_TYPE_FILE
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
				OPENLEVEL_RUN,
				OPENLEVEL_SRC,
				OPENLEVEL_BIN
		};
		
		return openLevels;
	}
	
	public final static String[] getScienceAppParallerModule(){
		String[] parallerModules = {
				PARALLER_MODULE_GAMESS_PARALLEL,
				PARALLER_MODULE_GNU_OPENMP_MPI,	
				PARALLER_MODULE_GNU_MPICH_1,		
				PARALLER_MODULE_GNU_MPICH_2,		
				PARALLER_MODULE_GNU_OPENMPI_1_4,	
				PARALLER_MODULE_GNU_OPENMP,		
				PARALLER_MODULE_INTEL_OPENMP_MPI,	
				PARALLER_MODULE_INTEL_MPICH_1,	
				PARALLER_MODULE_INTEL_MPICH_2,	
				PARALLER_MODULE_INTEL_OPENMPI_1_4,	
				PARALLER_MODULE_INTEL_OPENMP
		};
		
		return parallerModules;
	}
	
	/*************************************************************************************/
	/************************************GPLUS ADD****************************************/
	/*************************************************************************************/
}
