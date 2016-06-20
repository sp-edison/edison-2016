package org.kisti.edison.util;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonExpando;

import com.liferay.portal.kernel.util.StringUtil;

public final class HtmlFormUtils {

	/**
	 * 기본코드에 의한 하위 코드를 HTML 콤보박스 문자열로 반환
	 * @param _codeCd 기초코드
	 * @param selectCode String : 선택된 코드
	 * @return String : HTML 콤보박스 문자열
	 */
	public static String makeCombo(List codeList, String selectedValue){
		StringBuffer sb = new StringBuffer(512);
		String selected = null;

		Map<String, String> codeMap = null;
		if(codeList != null){
			if(codeList.size()>0){
				for(int i = 0; i < codeList.size(); i++){
					codeMap = (Map<String, String>) codeList.get(i);
					if(selectedValue != null && selectedValue.length() > 0) {
						selected = selectedValue.equals(codeMap.get(EdisonExpando.CD)) ? " selected " : " ";
					}

					sb.append("<option ");
					sb.append(" value='").append(codeMap.get(EdisonExpando.CD)).append("'");
					if(selected!=null){
						sb.append(selected);
					}
					sb.append(">");
					sb.append(codeMap.get(EdisonExpando.CDNM));
					sb.append("</option>\r\n");
				}
			}
		}
		return sb.toString();
	}
	
	public static String makeCombo(String[] strArray, String selectedValue){
		StringBuffer sb = new StringBuffer(512);
		String selected = null;
		
		if(strArray != null){
			if(strArray.length>0){
				for(String str : strArray){
					if(selectedValue != null && selectedValue.length() > 0) {
						selected = StringUtil.equalsIgnoreCase(str, selectedValue) ? " selected " : " ";
					}
					
					sb.append("<option ");
					sb.append(" value='").append(str).append("'");
					if(selected!=null){
						sb.append(selected);
					}
					
					sb.append(">");
					sb.append(str);
					sb.append("</option>\r\n");
					
				}
			}
		}
		return sb.toString();
	}

	public static String makeCombo(String[] strArray, String[] strTextArray,String selectedValue){
		StringBuffer sb = new StringBuffer(512);
		String selected = null;
		
		int index = 0;
		if(strArray != null){
			if(strArray.length>0){
				for(String str : strArray){
					String valueText = strTextArray[index];
					if(selectedValue != null && selectedValue.length() > 0) {
						selected = StringUtil.equalsIgnoreCase(str, selectedValue) ? " selected " : " ";
					}
					
					sb.append("<option ");
					sb.append(" value='").append(str).append("'");
					if(selected!=null){
						sb.append(selected);
					}
					
					sb.append(">");
					sb.append(valueText);
					sb.append("</option>\r\n");
					
					index++;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 리스트 사용시 체크박스 id 중복 제거 (공통 코드를 체크박스 문자열로 반환)
	 */
	private static String idSeq = "";

	public static String makeCheckBox(String name, List codeList, String [] checkCodes, String p_idSeq, Locale locale){
		idSeq = p_idSeq; 
		return makeCheckBox(name, codeList, checkCodes, locale);
	}


	/**
	 * 공통 코드를 체크박스 문자열로 반환
	 */
	public static String makeCheckBox(String name, List codeList, String [] checkCodes, Locale locale){

		Map param = new HashMap();
		if( checkCodes != null ){
			for(int i = 0; i < checkCodes.length; i++){
				param.put(checkCodes[i], "1");
			}
		}

		StringBuffer sb = new StringBuffer(512);
		String checked = null;

		Map<String, Map<String,String>> codeMap = null;
		String idName = null;
		if(codeList != null && codeList.size()>0){
			for(int i = 0; i < codeList.size(); i++){
				codeMap = (Map<String, Map<String,String>>) codeList.get(i);
				for (Map.Entry<String, Map<String,String>> entry : codeMap.entrySet()) {
					checked = param.containsKey(entry.getKey()) ? " checked='checked' " : " ";
					idName = idSeq+ name + "_"+ i;
					sb.append("<input");
					sb.append(" type='checkbox' ");
					sb.append(" id='").append(idName).append("'");
					sb.append(" name='").append(name).append("'");
					sb.append(" value='").append(entry.getKey()).append("'");
					sb.append(checked);
					sb.append("/>");
					sb.append("<label for='").append(idName).append("'>");
					sb.append(entry.getValue().get("cdNm_" + locale));
					sb.append("</label>");
					sb.append("&nbsp;&nbsp;");
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 공통 코드를 라디오박스 문자열로 반환
	 */
	public static String makeRadioBox(String name, List codeList, String checkedValue, Locale locale){

		StringBuffer sb = new StringBuffer(512);
		String checked = null;

		Map<String, Map<String,String>> codeMap = null;
		String idName = null;
		if(codeList != null && codeList.size()>0){
			for(int i = 0; i < codeList.size(); i++){
				codeMap = (Map<String, Map<String,String>>) codeList.get(i);
				for (Map.Entry<String, Map<String,String>> entry : codeMap.entrySet()) {
					checked = checkedValue.equals(entry.getKey()) ? " checked='checked' " : " " ;
					idName = name + "_"+ i;
					sb.append("<input");
					sb.append(" type='radio' ");
					sb.append(" id='").append(idName).append("'");
					sb.append(" name='").append(name).append("'");
					sb.append(" value='").append(entry.getKey()).append("'");
					sb.append(checked);
					sb.append("/>");
					sb.append("<label for='").append(idName).append("'>");
					sb.append(entry.getValue().get("cdNm_" + locale));
					sb.append("</label>");
					sb.append("&nbsp;&nbsp;");
				}
			}
		}
		return sb.toString();
	}	

}
