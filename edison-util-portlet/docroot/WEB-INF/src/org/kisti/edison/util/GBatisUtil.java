package org.kisti.edison.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.kisti.edison.util.CustomUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;


public final class GBatisUtil {

	private static Log logger = LogFactoryUtil.getLog(GBatisUtil.class);
	
    static class XmlParseNode{
    	String property;
    	String propertyValue;
    	String textValue;
    	
    	public XmlParseNode(){
    	}
    	
		public String getTextValue() {
			return textValue;
		}
		public void setTextValue(String textValue) {
			this.textValue = textValue;
		}
		public String getProperty() {
			return property;
		}
		public void setProperty(String property) {
			this.property = property;
		}
		public String getPropertyValue() {
			return propertyValue;
		}
		public void setPropertyValue(String propertyValue) {
			this.propertyValue = propertyValue;
		}
    }
    

    /**
     * 
     * @param xmlString <isNotEmpty> AND a = b </isNotEmpty>
     * @param searchTag isNotEmpty or isEqual
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private static XmlParseNode getNodeInfo(String xmlString, String searchTag) throws ParserConfigurationException, SAXException, IOException{
    	
    	XmlParseNode xmlNodeParseValue = new XmlParseNode();
		
		DocumentBuilderFactory factory  =  DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =  factory.newDocumentBuilder();    		
		Document document	=	builder.parse(new InputSource(new StringReader(xmlString)));
		   
		NodeList taglist	=  document.getElementsByTagName(searchTag);//isNotEmpty, isEqual
		xmlNodeParseValue.setTextValue(CustomUtil.strNull(taglist.item(0).getTextContent()));
		
		Node propertyNode       =  taglist.item(0).getAttributes().getNamedItem("property");
		xmlNodeParseValue.setProperty(CustomUtil.strNull(propertyNode.getNodeValue()));
		
		Node propertyValueNode       =  taglist.item(0).getAttributes().getNamedItem("propertyValue");
		if(propertyValueNode != null){
			xmlNodeParseValue.setPropertyValue(CustomUtil.strNull(propertyValueNode.getNodeValue()));
		}
		
		return xmlNodeParseValue;		
    }
    
    private static String getTagConvertQuery(Map params, String query, String tag) throws ParserConfigurationException, SAXException, IOException{
    	
    	Pattern tagPattern = Pattern.compile("<"+tag+"(.+?)"+tag+">", Pattern.DOTALL);
    	
    	Matcher matches = tagPattern.matcher(query);
    	
    	String tagText = "";
    	String nodeTextValue = "";
    	String nodeProperty = "";
    	String nodePropertyValue = "";
    	
    	while(matches.find()){
    		
    		tagText = matches.group();
    		
    		XmlParseNode xmlParseNode = getNodeInfo(tagText, tag); //<isNotEmpty property="ccc">  and b = <param>ccc</param> and f = <param>fff</param>  </isNotEmpty> 

    		nodeTextValue = xmlParseNode.getTextValue();
    		nodeProperty = xmlParseNode.getProperty();
    		nodePropertyValue = xmlParseNode.getPropertyValue();
    		
    		if(params.get(nodeProperty) instanceof Long && CustomUtil.strNull(params.get(nodeProperty)).equals("0")){
    			params.put(nodeProperty,"");
    		}else{
    			if(
        				(tag.equals("isNotEmpty") && !CustomUtil.strNull(params.get(nodeProperty)).equals(""))
        				||
        				(tag.equals("isEqual") && !nodeProperty.equals("") && CustomUtil.strNull(params.get(nodeProperty)).equals(nodePropertyValue))
        			){
            		
       	    		nodeTextValue = getSharpReplace(params, nodeTextValue);    			
            		
       	    		nodeTextValue = getAtReplace(params, nodeTextValue);
        	    	
        			query = CustomUtil.replace(query, tagText, nodeTextValue);    			
        		}else{
        			query = CustomUtil.replace(query, tagText, "");
        		}
    		}
    	}//while(matches.find()){
    	
    	return query;
    }
    
    private static String getSharpReplace(Map params, String query){

    	Pattern sharpPattern = Pattern.compile("#(.+?)#", Pattern.DOTALL);
    	
    	Matcher sharpMatches = sharpPattern.matcher(query);
    	    	
    	String sharpText = "";
    	String sharpStripText = "";
    	String sharpKeyValue = "";
    	
    	while(sharpMatches.find()){    
    		
    		sharpText = "";
    		sharpKeyValue = "";
    		
    		sharpText = sharpMatches.group();
	    	    	    		
	    	sharpStripText = CustomUtil.replace(sharpText, "#", "");	    	
	    	
	    	if(params.get(sharpStripText) instanceof String || params.get(sharpStripText) == null){        	    		
	    		sharpKeyValue = CustomUtil.replace(CustomUtil.strNull(params.get(sharpStripText)), "'", "");
	    		sharpKeyValue = CustomUtil.replace(CustomUtil.strNull(params.get(sharpStripText)), "\"", "");
	    		
	    		sharpKeyValue = "'" + CustomUtil.strNull(params.get(sharpStripText)) +"'";
	    	}else{
	    		if(params.get(sharpStripText) instanceof long[]){
	    			long[] arrayValue = (long[]) params.get(sharpStripText);
	    			sharpKeyValue = merge(arrayValue, StringPool.COMMA);
	    		}else{
	    			sharpKeyValue = CustomUtil.strNull(params.get(sharpStripText));
	    		}
	    		        	    		
	    	}
	    	
	    	query = CustomUtil.replace(query, sharpText, sharpKeyValue); 
    		
    	}    			

    	return query;
    }
    

    private static String getAtReplace(Map params, String query){
    	Pattern dollarPattern = Pattern.compile("@@(.+?)@@", Pattern.DOTALL);
    	
    	Matcher dollarMatches = dollarPattern.matcher(query);
    	
		String dollarText = "";
		String dollarStripText = "";
		String dollarKeyValue = "";
    	
    	while(dollarMatches.find()){    
    		
    		dollarText = "";
    		dollarStripText = "";
    		dollarKeyValue = "";
    		
    		dollarText = dollarMatches.group();
	    	    	    		
	    	dollarStripText = CustomUtil.replace(dollarText, "@@", "");
	    	
	    	dollarKeyValue = CustomUtil.strNull(params.get(dollarStripText));        	    		
	    	
	    	query = CustomUtil.replace(query, dollarText, dollarKeyValue); 
    		
    	}
    	return query;
    }
    
    
    public static String getGBatis(Map params, String query) throws ParserConfigurationException, SAXException, IOException{
    	query = getTagConvertQuery(params, query, "isNotEmpty");
    	query = getTagConvertQuery(params, query, "isEqual");
    	query = getSharpReplace(params, query);
    	query = getAtReplace(params, query);

    	logger.debug(query);
    	
    	return query;
    }
    
    public static String merge(long[] arrayValue, String delimiter) {
		if (arrayValue == null) {
			return null;
		}

		if (arrayValue.length == 0) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(2 * arrayValue.length - 1);

		for (int i = 0; i < arrayValue.length; i++) {
			sb.append("'"+String.valueOf(arrayValue[i]).trim()+"'");

			if ((i + 1) != arrayValue.length) {
				sb.append(delimiter);
			}
		}

		return sb.toString();
	}
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, JAXBException{
    	
    	String	query  = "select \n";
    			query += "	a, b, c	\n";
    			query += "from \n";
    			query += "	table \n";
    			query += "where \n";
    			query += "		a=b \n";
    			query += "	<isNotEmpty property=\"stringValue\"> ";
    			query += "		and stringValue = #stringValue# \n";
    			query += "		and stringValue2 = #stringValue2#\n";    			
    			query += "	</isNotEmpty> ";
    			query += "	<isNotEmpty property=\"intValue\"> ";
    			query += "		and intValue = #intValue# \n";
    			query += "	</isNotEmpty> ";
    			query += "	<isNotEmpty property=\"longValue\"> ";
    			query += "		and longValue = #longValue# \n";
    			query += "	</isNotEmpty> ";
    			query += "	<isNotEmpty property=\"floatValue\"> ";
    			query += "		and floatValue = #floatValue# \n";
    			query += "	</isNotEmpty> ";
    			query += "	<isNotEmpty property=\"booleanValue\"> ";
    			query += "		and booleanValue = #booleanValue# \n";
    			query += "	</isNotEmpty> ";
    			query += "	<isNotEmpty property=\"dollarValue\"> ";
    			query += "		and dollarValue = '%@dollarValue@%' \n";
    			query += "	</isNotEmpty> ";
    			query += "	<isNotEmpty property=\"test\"> ";
    			query += "		and dollarValue = #test# \n";
    			query += "	</isNotEmpty> ";
    			query += "	<isEqual property=\"isEqualPropertyValue\" propertyValue=\"OK\"> ";
    			query += "		and dollarValue = #isEqualValue# \n";
    			query += "	</isEqual> ";    	    			
    			query += "	and	abc=#abc# \n";
    			query += "	and	def=#def# \n";    			

//    			query = "ExtractValue(CODE.universityFieldNm, 'root/Data[@language-id=\"@@languageId@@\"]') AS virtualLabUniversityFieldSearchField,";
    			
    			
    	Map params = new HashMap();
    	params.put("stringValue", "stringValue");
    	params.put("stringValue2", "stringValue222222222222");
    	//params.put("intValue", Integer.parseInt("5"));
    	params.put("longValue", Long.parseLong("13245679"));
    	params.put("floatValue", Float.parseFloat("6.5"));
    	params.put("booleanValue", true);
    	params.put("dollarValue", "like");	
    	params.put("isEqualPropertyValue", "OKKKK");	
    	params.put("isEqualValue", "abc");	
    	params.put("abc", "abcValue");	
    	params.put("def", 0);	
    	params.put("languageId", "languageIdValue");
    	
    	
    	long[] test =StringUtil.split("123,123,123", 0l);
    	params.put("test", test);	

		System.out.println(getGBatis(params, query));
    	
		
		
		Map testMap = new HashMap();
		
		testMap.put("tst", 0L);
		
		
		String tstString = CustomUtil.strNull(testMap.get("tst"));
		
		
		System.out.println("tstString : "+tstString);
		
		if(tstString.equals("")){
			System.out.println("long null checked");
		}else{

			System.out.println("long is not null");
		}
		
		
		
    }
    
}
