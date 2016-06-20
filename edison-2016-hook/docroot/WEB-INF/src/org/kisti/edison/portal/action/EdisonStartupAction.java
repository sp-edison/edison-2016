package org.kisti.edison.portal.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonPropskeys;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.ExcelFileFilter;
import org.kisti.edison.util.ExcelUtil;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.xml.simple.Element;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.PortalPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.expando.DuplicateColumnNameException;
import com.liferay.portlet.expando.DuplicateTableNameException;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
import com.liferay.portlet.expando.model.ExpandoRow;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoRowLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

public class EdisonStartupAction extends SimpleAction{
  private static Log _log = LogFactoryUtil.getLog(EdisonStartupAction.class);

  /*
   * (non-Java-doc)
   * 
   * @see com.liferay.portal.kernel.events.SimpleAction#SimpleAction()
   */
  public EdisonStartupAction(){
    super();
  }
  
  
  /*
   * (non-Java-doc)
   * 
   * @see com.liferay.portal.kernel.events.SimpleAction#run(String[] arg0)
   */
  public void run(String[] arg0) throws ActionException{
    try{
      initSysCommonCd();
      initPreprences();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  protected void initPreprences()
      throws SystemException, ReadOnlyException, ValidatorException, IOException, PortalException{
    long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();
    long ownerId = companyId;
    int ownerType = PortletKeys.PREFS_OWNER_TYPE_COMPANY;

    PortletPreferences portletPreferences = PortalPreferencesLocalServiceUtil
        .getPreferences(ownerId, ownerType);
    
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_REQUEST_SUBJECT);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_REQUEST_BODY);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_CONFIRM_SUBJECT);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_CONFIRM_BODY);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_SUBJECT);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_BODY);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_SUBJECT);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_BODY);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_ERROR_REPORT_SUBJECT);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_ADMIN_ERROR_REPORT_BODY);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_FORGOT_ID_SUBJECT);
    putPreperences(portletPreferences, EdisonPropskeys.EDISON_FORGOT_ID_BODY);
    
    PortalPreferencesLocalServiceUtil
        .updatePreferences(ownerId, ownerType, toXML(portletPreferences));
  }

  /**
   * EDISON 공통 코드 데이터 등록
   */
  protected void initSysCommonCd() throws SystemException, PortalException{
    String ExcelPath = PropsUtil.get(PropsKeys.LIFERAY_HOME) + "/code";
    File dirFile = new File(ExcelPath);

    // 파일 경로가 없을 경우 생성
    if(!dirFile.exists()){
      dirFile.mkdir();
    }

    if(dirFile.isDirectory()){
      ExcelFileFilter excelFileFilter = new ExcelFileFilter();
      File[] fileList = dirFile.listFiles(excelFileFilter);
      if(fileList.length != 0){
        ExpandoTable table = null;
        long companyId = CompanyLocalServiceUtil.getCompanies().get(0).getCompanyId();

        try{
          table = ExpandoTableLocalServiceUtil.addTable(companyId, ExpandoTable.class.getName(),
              EdisonExpando.TALBE_NAME);
          _log.info("SysCommon Table Create");
        }catch (DuplicateTableNameException dtne){
          table = ExpandoTableLocalServiceUtil.getTable(companyId, ExpandoTable.class.getName(),
              EdisonExpando.TALBE_NAME);
          _log.info("SysCommon Table Exist");
          deleteExpandoSysCommonCd(table);
        }

        // ColumnCreate
        HashMap<String, ExpandoColumn> columnMap = createSysCommonCdColumn(table);

        /*
         * ExcelFileRead
         */
        for(File tempfile : fileList){
          List<HashMap> dataRowList = new ArrayList();
          String fileName = tempfile.getName();
          FileInputStream fs = null;
          try{
            fs = new FileInputStream(tempfile);
          }catch (FileNotFoundException e1){
            e1.printStackTrace();
          }
          _log.info(fileName + "<-- SysCommonCd File Read");

          Workbook workbook = null;
          if(fileName.toLowerCase().endsWith("xlsx")){
            try{
              workbook = new XSSFWorkbook(fs);
            }catch (IOException e){
              e.printStackTrace();
            }
          }else{
            try{
              workbook = new HSSFWorkbook(fs);
            }catch (IOException e){
              e.printStackTrace();
            }
          }

          Sheet sheet = workbook.getSheetAt(0);
          Iterator<Row> rowIterator = sheet.iterator();

          HashMap<String, Object> dataRowMap = null;
          List<String> cellMapKey = new ArrayList<String>();

          while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            if(row.getRowNum() == 0){
              root1: for(int i = 0; i < row.getLastCellNum(); i++){
                String cellKey = CustomUtil.strNull(ExcelUtil.getCellValue(row.getCell(i)));
                if(!cellKey.equals("")){
                  cellMapKey.add(i, ExcelUtil.getCellValue(row.getCell(i)));
                }else{
                  break root1;
                }
              }
            }

            int rowCeltIndex = 0;
            if(row.getRowNum() > 0){
              dataRowMap = new HashMap<String, Object>();
              for(String rowMapKey : cellMapKey){
                dataRowMap.put(rowMapKey, ExcelUtil.getCellValue(row.getCell(rowCeltIndex++)));
              }
              dataRowList.add(dataRowMap);
            }
          }

          insertSysCommonData(table, columnMap, dataRowList);
          tempfile.delete();

        }// end for
        _log.info("SyscommonData Create END");
      }else{
        _log.info("EDISON_SysCommonCd Data File Not Exist");
      }
    }else{
      _log.error("Dir Not Exist");
    }
  }

  // ColumnData
  protected HashMap<String, ExpandoColumn> createSysCommonCdColumn(ExpandoTable table)
      throws PortalException, SystemException{
    ExpandoColumn cdNmColumn = null;
    try{
      cdNmColumn = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), EdisonExpando.CDNM,
          ExpandoColumnConstants.STRING_LOCALIZED);
    }catch (DuplicateColumnNameException dcne){
      cdNmColumn = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.CDNM);
    }

    ExpandoColumn regionColumn = null;
    try{
      regionColumn = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(),
          EdisonExpando.REGION, ExpandoColumnConstants.STRING);
    }catch (DuplicateColumnNameException dcne){
      regionColumn = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(),
          EdisonExpando.REGION);
    }

    ExpandoColumn option1Column = null;
    try{
      option1Column = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(),
          EdisonExpando.OPTION1, ExpandoColumnConstants.STRING);
    }catch (DuplicateColumnNameException dcne){
      option1Column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(),
          EdisonExpando.OPTION1);
    }

    ExpandoColumn option2Column = null;
    try{
      option2Column = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(),
          EdisonExpando.OPTION2, ExpandoColumnConstants.STRING);
    }catch (DuplicateColumnNameException dcne){
      option2Column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(),
          EdisonExpando.OPTION2);
    }

    ExpandoColumn option3Column = null;
    try{
      option3Column = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(),
          EdisonExpando.OPTION3, ExpandoColumnConstants.STRING);
    }catch (DuplicateColumnNameException dcne){
      option3Column = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(),
          EdisonExpando.OPTION3);
    }

    HashMap<String, ExpandoColumn> columnMap = new HashMap<String, ExpandoColumn>();
    columnMap.put("cdNmColumn", cdNmColumn);
    columnMap.put("regionColumn", regionColumn);
    columnMap.put("option1Column", option1Column);
    columnMap.put("option2Column", option2Column);
    columnMap.put("option3Column", option3Column);
    return columnMap;
  }

  protected void insertSysCommonData(ExpandoTable table, HashMap<String, ExpandoColumn> columnMap,
      List<HashMap> rowDataList) throws PortalException, SystemException{

    for(HashMap<String, String> rowMap : rowDataList){
      _log.info("CODE_EXCEL_READ_ROW-->" + rowMap);
      Long classPk = Long.parseLong(CustomUtil.strNull(rowMap.get("classPK")));

      ExpandoColumn cdNmColumn = columnMap.get("cdNmColumn");
      Map<java.util.Locale, String> localeMap = new HashMap<java.util.Locale, String>();

      for(Locale locale : LanguageUtil.getAvailableLocales()){
        localeMap.put(locale, CustomUtil.strNull(rowMap.get(locale.toString())));
      }

      ExpandoValueLocalServiceUtil.addValue(table.getCompanyId(), table.getClassName(),
          table.getName(), cdNmColumn.getName(), classPk, localeMap, LocaleUtil.getDefault());

      ExpandoColumn regionColumn = columnMap.get("regionColumn");
      ExpandoValueLocalServiceUtil.addValue(table.getClassNameId(), table.getTableId(),
          regionColumn.getColumnId(), classPk, CustomUtil.strNull(rowMap.get("region")));

      ExpandoColumn option1Column = columnMap.get("option1Column");
      ExpandoValueLocalServiceUtil.addValue(table.getClassNameId(), table.getTableId(),
          option1Column.getColumnId(), classPk, CustomUtil.strNull(rowMap.get("option1")));

      ExpandoColumn option2Column = columnMap.get("option2Column");
      ExpandoValueLocalServiceUtil.addValue(table.getClassNameId(), table.getTableId(),
          option2Column.getColumnId(), classPk, CustomUtil.strNull(rowMap.get("option2")));

      ExpandoColumn option3Column = columnMap.get("option3Column");
      ExpandoValueLocalServiceUtil.addValue(table.getClassNameId(), table.getTableId(),
          option3Column.getColumnId(), classPk, CustomUtil.strNull(rowMap.get("option3")));
    }
  }

  protected void deleteExpandoSysCommonCd(ExpandoTable table)
      throws PortalException, SystemException{
    // DELETE Row
    List<ExpandoRow> rowList = ExpandoRowLocalServiceUtil.getRows(table.getCompanyId(),
        table.getClassNameId(), table.getName(), 0,
        ExpandoRowLocalServiceUtil.getRowsCount(table.getTableId()));
    for(ExpandoRow row : rowList){
      ExpandoValueLocalServiceUtil.deleteValues(table.getClassNameId(), row.getClassPK());
      ExpandoRowLocalServiceUtil.deleteRows(row.getClassPK());
    }

    // DELETE Column
    List<ExpandoColumn> columnList = ExpandoColumnLocalServiceUtil.getColumns(table.getTableId());
    for(ExpandoColumn column : columnList){
      ExpandoColumnLocalServiceUtil.deleteColumn(column);
    }
  }
  
  
  private void putPreperences(PortletPreferences portletPreferences, String key)
      throws ReadOnlyException{
    Map<String, String[]> preferenceMap = portletPreferences.getMap();
    if(preferenceMap == null || !preferenceMap.containsKey(key)){
      if(!portletPreferences.isReadOnly(key)){
        portletPreferences.setValue(key, getHookEmailContent(key));
      }
    }
  }

  private String toXML(PortletPreferences portletPreferences){
    Element portletPreferencesElement = new Element("portlet-preferences", false);
    Enumeration<String> portletPreferenceNames = portletPreferences.getNames();

    while(portletPreferenceNames.hasMoreElements()){
      String key = portletPreferenceNames.nextElement();
      String value = portletPreferences.getValue(key, StringPool.BLANK);
      Element preferenceElement = portletPreferencesElement.addElement("preference");
      preferenceElement.addElement("name", key);
      preferenceElement.addElement("value", value);
      if(portletPreferences.isReadOnly(key)){
        preferenceElement.addElement("read-only", Boolean.TRUE);
      }
    }
    return portletPreferencesElement.toXMLString();
  }
  
  private String getHookEmailContent(String name){
    return emailMap.get(name);
  }
  
  private final static Map<String, String> emailMap = new HashMap<String, String>();
  static{
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_ERROR_REPORT_BODY, " EDISON ERROR LOG<br /><br />\n  \n  에러내용:<br />\n [$ERROR_MESSAGE$]<br />\n");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_ERROR_REPORT_SUBJECT, "EDISON 에러 Log");
    emailMap.put(EdisonPropskeys.EDISON_FORGOT_ID_BODY, "Dear [$TO_NAME$],<br /><br />\n\n EDISON 에서 요청 하신 ID를 확인 하였습니다.<br /><br />\n \n  이메일 : [$USER_ADDR$]<br /><br />\n 이름 : [$USER_NAME$]<br /><br />\n  아이디 : [$USER_ID$]<br /><br />\n\nSincerely,<br />\n[$FROM_NAME$]<br />\n[$FROM_ADDRESS$]<br />\n[$PORTAL_URL$]<br />");
    emailMap.put(EdisonPropskeys.EDISON_FORGOT_ID_SUBJECT, "EDISON ID 안내");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_CONFIRM_BODY, "Dear [$TO_NAME$],<br /><br />\n\n EDISON - [$GROUP_SITE_NAME$]에서 가상실험실에 대하여 안내합니다.<br /><br />\n  \n  처리내역 : [$PROCESSNOTE$]<br /><br />\n  \nSincerely,<br />\n[$FROM_NAME$]<br />\n[$FROM_ADDRESS$]<br />\n[$PORTAL_URL$]<br />");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_CONFIRM_SUBJECT, "EDISON 가상실험실 안내.");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_REQUEST_BODY, "Dear [$TO_NAME$],<br /><br />\n\n EDISON - [$GROUP_SITE_NAME$]에서 해당 가상실험실을 신청합니다.<br /><br />\n \n  사용자 아이디 : [$USER_SCREENNAME$]<br /><br />\n \n  소속기관 :[$USER_ORG$]<br /><br />\n  \nSincerely,<br />\n[$FROM_NAME$]<br />\n[$FROM_ADDRESS$]<br />\n[$PORTAL_URL$]<br />");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_LAB_REQUEST_SUBJECT, "EDISON 가상실험실 신청.");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_BODY, "Dear [$TO_NAME$],<br /><br />\n\n EDISON - [$GROUP_SITE_NAME$]에서 워크스페이스 관련하여 안내합니다.<br /><br />\n \n  처리내역 : [$PROCESSNOTE$]<br /><br />\n\nSincerely,<br />\n[$FROM_NAME$]<br />\n[$FROM_ADDRESS$]<br />\n[$PORTAL_URL$]<br />");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_CONFIRM_SUBJECT, "EDISON 워크스페이스 신청 안내");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_BODY, "Dear [$TO_NAME$],<br /><br />\n\n EDISON - [$GROUP_SITE_NAME$]에서 워크스페이스를 신청합니다.<br /><br />\n \n  사용자 아이디 : [$USER_SCREENNAME$]<br /><br />\n \n  소속기관 :[$USER_ORG$]<br /><br />\n\nSincerely,\n[$FROM_NAME$]<br />\n[$FROM_ADDRESS$]<br />\n[$PORTAL_URL$]<br />");
    emailMap.put(EdisonPropskeys.EDISON_ADMIN_EMAIL_WORKSPACE_REQUEST_SUBJECT, "EDISON 워크스페이스 신청.");
  }
}