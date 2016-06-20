/**
 * 
 */
package org.kisti.edison.science.service.constants;

/**
 * @author Main
 *
 */
public class InputdeckConstants {
	public final static String VECTOR_FORM = "vector-form";
	public final static String BRACE_CHAR="brace-char";
	public final static String SPACE="space";
	public final static String DELIMITER="delimiter";
	public final static String SAMPLE="sample";
	public final static String LINE_FORM = "line-form";
	public final static String VALUE_DELIMITER="value-delimiter";
	public final static String LINE_DELIMITER="line-delimiter";
	public final static String COMMENT_CHAR="comment-char";
	public final static String AVAILABLE_LANGUAGE_IDS="available-language-ids";
	public final static String DEFAULT_LANGUAGE_ID="default-language-id";
	public final static String VARIABLE_MAP = "variable-map";
	public final static String VARIABLE_NAME = "variable-name";
	public final static String NAME="name";
	public final static String TYPE="type";
	public final static String CONTAINER="container";
	public final static String ACTIVATE_CONDITION_CONTAINER="activate-condition-container";
	public final static String VALUE="value";
	public final static String DOMAIN="domain";
	public final static String VALUE_DOMAIN="value-domain";
	public final static String LOWER_LIMIT="lower-limit";
	public final static String UPPER_LIMIT="upper-limit";
	public final static String OPERAND="operand";
	public final static String LIST_MAP="list-map";
	public final static String LOCALIZED_TEXT_MAP="localized-text-map";
	public final static String LIST_ITEM_VALUE="list-item-value";
	public final static String SWEEP_DOMAIN="sweep-domain";
	public final static String ORDER="order";
	public final static String DESCRIPTION_MAP="description-map";
	public final static String NAME_TEXT_MAP="name-text-map";
	public final static String DIMENSION="dimension";
	public final static String UNIT="unit";
	public final static String TYPE_NUMERIC="numeric";
	public final static String TYPE_STRING="string";
	public final static String TYPE_LIST="list";
	public final static String TYPE_VECTOR="vector";
	public final static String TYPE_GROUP="group";
	public final static String TYPE_COMMENT="comment";
	
	public final static String VALID_INPUTDECK_VARIABLE_NAME_EXPR = "[a-zA-Z][a-zA-Z0-9\\_]*";
	public final static String VALID_INPUTDECK_DOMAIN_OPERAND_EXPR = "[=<][=>]";
	
	public final static String[] getInputdeckVariableTypes(){
		String[] types = {
				TYPE_NUMERIC,
				TYPE_LIST,
				TYPE_VECTOR,
				TYPE_GROUP,
				TYPE_COMMENT
		};
		
		return types;
	}
	
}
