package org.kisti.edison.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonExpando;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

public class EdisonExpndoUtil {
private static Log _log = LogFactoryUtil.getLog(EdisonExpndoUtil.class);
	
	
	/**
	 * 필드에 대한 값 조회
	 * @param classPK - 조회할 ClassPK
	 * @param field   - 조회할 Field(EdisonExpando 참조)
	 * @param locale
	 * @return String - FieldValue
	 */
	public static String getCommonCdSearchFieldValue(long classPK,String field,Locale locale){
		return doGetFieldValue(classPK, field, locale);
	}
	
	public static String getCommonCdSearchFieldValue(String classPK,String field,Locale locale){
		return doGetFieldValue(Long.parseLong(classPK) , field, locale);
	}
	
	public static String getCommonCdSearchFieldValue(Object classPK,String field,Locale locale){
		return doGetFieldValue((Long) classPK, field, locale);
	}

	
	/**
	 * 필드에 대한 값 조회
	 * @param classPK - 조회할 ClassPK
	 * @param field   - 조회할 Field(EdisonExpando 참조)
	 * @return String - FieldValue
	 */
	public static String getCommonCdSearchFieldValue(long classPK,String field){
		return doGetFieldValue(classPK, field, null);
	}
	public static String getCommonCdSearchFieldValue(String classPK,String field){
		return doGetFieldValue(Long.parseLong(classPK) , field, null);
	}
	public static String getCommonCdSearchFieldValue(Object classPK,String field){
		return doGetFieldValue((Long) classPK, field, null);
	}
	
	

	
	
	/**
	 * upCode에 대한 리스트 조회
	 * @param upCode
	 * @param locale
	 * @return List<Map<String,String>>
	 */
	public static List<Map<String,String>> getCodeListByUpCode(long upCode,Locale locale){
		return doGetUpcodeMap(upCode,locale);
	}
	public static List<Map<String,String>> getCodeListByUpCode(String upCode,Locale locale){
		return doGetUpcodeMap(Long.parseLong(upCode),locale);
	}
	public static List<Map<String,String>> getCodeListByUpCode(Object upCode,Locale locale){
		return doGetUpcodeMap((Long) upCode,locale);
	}
	
	
	/**
	 * upCode에 대한 리스트 조회
	 * @param upCode
	 * @param field - 조회할 Field(EdisonExpando 참조)
	 * @param locale
	 * @return List<Map<String,String>>
	 */
	public static List<Map<String,String>> getCodeListByUpCodeAndField(long upCode,String field, Locale locale){
		return doGetUpcodeFieldValue(upCode, field, locale);
	}
	public static List<Map<String,String>> getCodeListByUpCodeAndField(String upCode,String field, Locale locale){
		return doGetUpcodeFieldValue(Long.parseLong(upCode), field, locale);
	}
	public static List<Map<String,String>> getCodeListByUpCodeAndField(Object upCode,String field, Locale locale){
		return doGetUpcodeFieldValue((Long)upCode, field, locale);
	}
	
	/**
	 * upCode에 대한 리스트 조회
	 * @param upCode
	 * @param field - 조회할 Field(EdisonExpando 참조)
	 * @return List<Map<String,String>>
	 */
	public static List<Map<String,String>> getCodeListByUpCodeAndField(long upCode,String field){
		return doGetUpcodeFieldValue(upCode, field, null);
	}
	public static List<Map<String,String>> getCodeListByUpCodeAndField(String upCode,String field){
		return doGetUpcodeFieldValue(Long.parseLong(upCode), field, null);
	}
	public static List<Map<String,String>> getCodeListByUpCodeAndField(Object upCode,String field){
		return doGetUpcodeFieldValue((Long)upCode, field, null);
	}
	
	
	
	protected static String doGetFieldValue(long classPK,String field,Locale locale){
		
		String returnStr = "";
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId,ExpandoTable.class.getName(),EdisonExpando.TALBE_NAME);
			
			ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(companyId, table.getClassNameId(), EdisonExpando.TALBE_NAME, field, classPK);
			
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(value.getColumnId());
			
			if(column.getType()==20){
				if(locale==null){
					throw new Exception("This Column is localization column");
				}
				returnStr = value.getString(locale);
			}else{
				returnStr = value.getData();
			}
		}catch(Exception e){
			_log.error(e);
		}
		return returnStr;
	}
	
	
	
	protected static List<Map<String, String>> doGetUpcodeMap(long upcode,Locale locale){
		List<Map<String, String>> upCodeList = new ArrayList<Map<String, String>>();
		try{
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId,ExpandoTable.class.getName(),EdisonExpando.TALBE_NAME);
			
			long startUpcode = Long.parseLong(String.valueOf(upcode)+"000");
			long endUpcode = Long.parseLong(String.valueOf(upcode)+"999");
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoRow.class);
			dynamicQuery.add(RestrictionsFactoryUtil.between("classPK", startUpcode, endUpcode));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("tableId", table.getTableId()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
			dynamicQuery.addOrder(OrderFactoryUtil.asc("classPK"));
			List<ExpandoRow> rowList = ExpandoRowLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			for(ExpandoRow row : rowList){
				List<ExpandoValue> valueList =  ExpandoValueLocalServiceUtil.getRowValues(row.getRowId());
				
				Map<String,String> rowMap =  new HashMap<String,String>();
				
				long classPK = 0;
				for(ExpandoValue value:valueList){
					if(value.getColumn().getType()==20){
						if(locale==null){
							throw new Exception("This Column is localization column");
						}
						rowMap.put(value.getColumn().getName(), value.getString(locale));
					}else{
						rowMap.put(value.getColumn().getName(), value.getData());
					}
					classPK = value.getClassPK();
				}
				rowMap.put(EdisonExpando.CD, String.valueOf(classPK));
				upCodeList.add(rowMap);
			}
		}catch(Exception e){
			_log.error(e);
		}
		
		return upCodeList;
	}
	
	
	
	protected static List<Map<String, String>> doGetUpcodeFieldValue(long upcode,String field,Locale locale){
		
		
		List<Map<String, String>> upCodeList = new ArrayList<Map<String, String>>();
		
		try{
			
			
			long startUpcode = Long.parseLong(String.valueOf(upcode)+"000");
			long endUpcode = Long.parseLong(String.valueOf(upcode)+"999");
			
			long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
			ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId,ExpandoTable.class.getName(),EdisonExpando.TALBE_NAME);
			ExpandoColumn column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), field);
			
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ExpandoValue.class);
			dynamicQuery.add(RestrictionsFactoryUtil.between("classPK", startUpcode, endUpcode));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("columnId", column.getColumnId()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("tableId", table.getTableId()));
			dynamicQuery.add(RestrictionsFactoryUtil.eq("companyId", companyId));
			dynamicQuery.addOrder(OrderFactoryUtil.asc("classPK"));
			List<ExpandoValue> valuesList = ExpandoValueLocalServiceUtil.dynamicQuery(dynamicQuery);
			
			for(ExpandoValue value : valuesList){
				Map<String,String> rowMap =  new HashMap<String,String>();
				
				if(column.getType()==20){
					if(locale==null){
						throw new Exception("This Column is localization column");
					}
					rowMap.put(field, value.getString(locale));
				}else{
					rowMap.put(field, value.getData());
				}
				
				rowMap.put(EdisonExpando.CD, String.valueOf(value.getClassPK()));
				upCodeList.add(rowMap);
			}
			
		}catch(Exception e){
			_log.error(e);
		}
		
		return upCodeList;
	}
	
}
