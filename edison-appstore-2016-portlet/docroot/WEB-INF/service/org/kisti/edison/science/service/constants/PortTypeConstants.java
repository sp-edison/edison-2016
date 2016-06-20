/**
 * 
 */
package org.kisti.edison.science.service.constants;

/**
 * @author Main
 *
 */
public class PortTypeConstants {
	public final static String DATA_TYPE_FILE="FILE";
	public final static String DATA_TYPE_FOLDER="FOLDER";
	public final static String DATA_TYPE_EXTENSION="EXTENSION";
	public final static String DATA_TYPE_STRING="STRING";
	
	public final static String VALID_PORT_TYPE_NAME_EXPR = "[a-zA-Z][a-zA-Z0-9\\_]+";
	
	public static String[] getDataTypes(){
		String[] types = {
				PortTypeConstants.DATA_TYPE_STRING,
				PortTypeConstants.DATA_TYPE_FILE,
				PortTypeConstants.DATA_TYPE_FOLDER,
				PortTypeConstants.DATA_TYPE_EXTENSION
		};
		
		return types;
	}
}
