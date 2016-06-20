package org.kisti.edison.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderResponse;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExcelUtil{
	
	/**
	 * Excel Download
	 * @param response
	 * @param logical_name : 엑셀의 타이틀
	 * @param physical_name : List에서 get을 위한 필드명
	 * @param widths : 셀들의 너비
	 * @param downFileName : 다운로드 파일명 downFileName.xls
	 * @param excelDataList : DB 데이터
	 * @throws IOException
	 */
	public static String excelDownload(HttpServletResponse response, String[] logical_names, String[] physical_names, int[] widths, String downFileName, List excelDataList) throws IOException
    {
		String returnMsg = "";

		if(logical_names.length != physical_names.length){
			returnMsg =  "logical_name != physical_name";
		}else if(physical_names.length != widths.length){
			returnMsg =  "physical_name != widths";
		}else{
		
			HSSFWorkbook workbook = makeHSSFWorkbook(logical_names, physical_names, widths, downFileName, excelDataList);
			
			if(!workbook.equals(null)){
				response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(downFileName, "UTF-8")+".xls;");
				response.setHeader("Content-Description", "JSP Generated Data");
				response.setContentType("application/vnd.ms-excel");
				
				ServletOutputStream out = response.getOutputStream();
				workbook.write(out);
				out.close();
				
				returnMsg = "success";
			}else{
				returnMsg =  "지정한 파일을 찾을수 없습니다.";
			}
		}
		
		return returnMsg;
		
    }
	
	public static String surveyExcelDownload(ResourceResponse response, String surveyTitle,  List questionList, List answerList) throws IOException
	{
		String returnMsg = "";
			
			HSSFWorkbook workbook = makeHSSFWorkbook(surveyTitle, questionList, answerList);
			
			if(!workbook.equals(null)){
				response.setProperty("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode("설문", "UTF-8")+".xls;");
				response.setProperty("Content-Description", "JSP Generated Data");
				response.setContentType("application/vnd.ms-excel");
				
				OutputStream out = response.getPortletOutputStream();
				workbook.write(out);
				out.close();
				
				returnMsg = "success";
			}else{
				returnMsg =  "지정한 파일을 찾을수 없습니다.";
			}

		
		return returnMsg;
		
	}
	
	
	public static String surveyRowExcelDownload(ResourceResponse response, String surveyTitle,  List resultList) throws IOException
	{
		String returnMsg = "";
			
			HSSFWorkbook workbook = makeHSSFWorkbookRowData(surveyTitle, resultList);
			
			if(!workbook.equals(null)){
				response.setProperty("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode("설문조사", "UTF-8")+".xls;");
				response.setProperty("Content-Description", "JSP Generated Data");
				response.setContentType("application/vnd.ms-excel");
				
				OutputStream out = response.getPortletOutputStream();
				workbook.write(out);
				out.close();
				
				returnMsg = "success";
			}else{
				returnMsg =  "지정한 파일을 찾을수 없습니다.";
			}

		
		return returnMsg;
		
	}
    	
	/**
	 * excel 화면 설정
	 * @param params
	 * @return
	 */
    public static HSSFWorkbook makeHSSFWorkbook(String[] logical_names, String[] physical_names, int[] widths, String downFileName, List excelDataList) {    	

		try {
			// 엑셀 workBook 생성
			HSSFWorkbook workbook = new HSSFWorkbook();
			// sheet 생성
			HSSFSheet sheet = workbook.createSheet(downFileName);//sheet명을 다운로드 받는 파일명과 동일하게 작명
			for (int i = 0, n = widths.length; i < n; i++) {
				sheet.setColumnWidth(i, widths[i] * 300);
			}
			// Style 지정
			HSSFCellStyle titleStyle = workbook.createCellStyle();
			HSSFCellStyle subTitleStyle = workbook.createCellStyle();	

			HSSFCellStyle dataStyleGray = workbook.createCellStyle();
			HSSFCellStyle dataStyleNormal = workbook.createCellStyle();
			//HSSFCellStyle dataStyleLink = workbook.createCellStyle();
			
			// 제목
			titleStyle.setAlignment(CellStyle.ALIGN_LEFT);
			titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			titleStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
			titleStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			
			titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
		    titleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		    titleStyle.setBorderLeft(CellStyle.BORDER_THIN);
		    titleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		    titleStyle.setBorderRight(CellStyle.BORDER_THIN);
		    titleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    titleStyle.setBorderTop(CellStyle.BORDER_THIN);
		    titleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		    
			
			// 컬럼 제목
			subTitleStyle.setAlignment(CellStyle.ALIGN_CENTER);
			subTitleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			subTitleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			subTitleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			
			subTitleStyle.setBorderBottom(CellStyle.BORDER_THIN);
			subTitleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			subTitleStyle.setBorderLeft(CellStyle.BORDER_THIN);
		    subTitleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		    subTitleStyle.setBorderRight(CellStyle.BORDER_THIN);
		    subTitleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    subTitleStyle.setBorderTop(CellStyle.BORDER_THIN);
		    subTitleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		    
			// 데이터 셀 스타일 Grey_0 Percent 정렬 좌우/상하
		    dataStyleNormal.setAlignment(CellStyle.ALIGN_LEFT);
		    dataStyleNormal.setVerticalAlignment(CellStyle.ALIGN_CENTER);			
		    dataStyleNormal.setBorderBottom(CellStyle.BORDER_THIN);
		    dataStyleNormal.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		    dataStyleNormal.setBorderLeft(CellStyle.BORDER_THIN);
		    dataStyleNormal.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		    dataStyleNormal.setBorderRight(CellStyle.BORDER_THIN);
		    dataStyleNormal.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    dataStyleNormal.setBorderTop(CellStyle.BORDER_THIN);
		    dataStyleNormal.setTopBorderColor(IndexedColors.BLACK.getIndex());			


			// 데이터 셀 스타일 Grey_25 Percent 정렬 좌우/상하
			dataStyleGray.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());
			dataStyleGray.setFillPattern(CellStyle.SOLID_FOREGROUND);
		    dataStyleGray.setAlignment(CellStyle.ALIGN_LEFT);
		    dataStyleGray.setVerticalAlignment(CellStyle.ALIGN_CENTER);			
		    dataStyleGray.setBorderBottom(CellStyle.BORDER_THIN);
		    dataStyleGray.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		    dataStyleGray.setBorderLeft(CellStyle.BORDER_THIN);
		    dataStyleGray.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		    dataStyleGray.setBorderRight(CellStyle.BORDER_THIN);
		    dataStyleGray.setRightBorderColor(IndexedColors.BLACK.getIndex());
		    dataStyleGray.setBorderTop(CellStyle.BORDER_THIN);
		    dataStyleGray.setTopBorderColor(IndexedColors.BLACK.getIndex());			
		    			
			//TITLE 폰트 설정
			HSSFFont titleFont = workbook.createFont();
			titleFont.setFontName("맑은고딕");
			titleFont.setColor((short) Font.BOLDWEIGHT_BOLD);
			titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			titleFont.setFontHeightInPoints((short)16);
			titleStyle.setFont(titleFont);
			
			//SUB TITLE 폰트 설정
			HSSFFont subFont = workbook.createFont();
			subFont.setFontName("맑은고딕");
			subFont.setColor((short) Font.BOLDWEIGHT_BOLD);
			subFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			subTitleStyle.setFont(subFont);
			
			//DATA 폰트 설정
			HSSFFont font = workbook.createFont();
			font.setFontName("맑은고딕");
			font.setColor((short) Font.BOLDWEIGHT_NORMAL);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			dataStyleNormal.setFont(font);
			dataStyleGray.setFont(font);

			/**
			 *  첫행 제목 란 생성
			 **/
			int rowno = 0;
			
			HSSFRow row = sheet.createRow(rowno++);
			HSSFCell cell = null;

			row = sheet.createRow(rowno++);
			cell = row.createCell(0);
			
			cell.setCellStyle(titleStyle);
			cell.setCellValue(downFileName);			
			sheet.addMergedRegion(new Region(1, (short) 0, 1, (short) (logical_names.length-1))); // 가로병합
			
			//엑셀 상단 국문 컬럼명
			row = sheet.createRow(rowno++);
			for (int i = 0; i < logical_names.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(subTitleStyle);
				cell.setCellValue(CustomUtil.strNull(logical_names[i]));
			}
			
			Map dataMap = null;

			if(excelDataList.size() > 0){
				//데이터 쓰기
				for (int i = 0;i<excelDataList.size(); i++) {
					row = sheet.createRow(rowno++);
					dataMap = (Map)excelDataList.get(i);
					
					for (int i2 = 0; i2 < physical_names.length; i2++) {
						cell = row.createCell(i2);
						cell.setCellStyle(dataStyleNormal);
						cell.setCellValue(CustomUtil.strNull(dataMap.get(physical_names[i2])).toString());
					}
					
				}
			}else{
				row = sheet.createRow(rowno++);
				cell = row.createCell(0);
				cell.setCellStyle(dataStyleNormal);
				cell.setCellValue("자료가 없습니다.");
				//sheet.addMergedRegion(new Region(7, (short) 0, 7, (short)(trnColumnName.length-1))); // 가로병합
			}

			return workbook;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
    /**
	 * excel 설문조사 엑셀 설정 (New) - 2014-02-14 
	 * Row Data 형식으로 변경
     * @param params
     * @return
     */
    public static HSSFWorkbook makeHSSFWorkbookRowData(String surveyTitle, List resultList) {
    	try{
    		// 엑셀 workBook 생성
    		HSSFWorkbook workbook = new HSSFWorkbook();
    		
    		// sheet 생성
    		HSSFSheet sheet = workbook.createSheet("설문결과");//sheet명을 다운로드 받는 파일명과 동일하게 작명
    		
    		// Style 지정
    		HSSFCellStyle titleStyle = workbook.createCellStyle();
    		HSSFCellStyle subTitleStyle = workbook.createCellStyle();	
    		
    		HSSFCellStyle dataStyleGray = workbook.createCellStyle();
    		HSSFCellStyle dataStyleNormal = workbook.createCellStyle();
    		//HSSFCellStyle dataStyleLink = workbook.createCellStyle();
    		
    		// 제목
    		titleStyle.setAlignment(CellStyle.ALIGN_LEFT);
    		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    		titleStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
    		titleStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
    		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    		
    		titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
    		titleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		titleStyle.setBorderLeft(CellStyle.BORDER_THIN);
    		titleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		titleStyle.setBorderRight(CellStyle.BORDER_THIN);
    		titleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		titleStyle.setBorderTop(CellStyle.BORDER_THIN);
    		titleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
    		
    		
    		// 컬럼 제목
    		subTitleStyle.setAlignment(CellStyle.ALIGN_CENTER);
    		subTitleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    		subTitleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    		subTitleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    		
    		subTitleStyle.setBorderBottom(CellStyle.BORDER_THIN);
    		subTitleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		subTitleStyle.setBorderLeft(CellStyle.BORDER_THIN);
    		subTitleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		subTitleStyle.setBorderRight(CellStyle.BORDER_THIN);
    		subTitleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		subTitleStyle.setBorderTop(CellStyle.BORDER_THIN);
    		subTitleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
    		
    		// 데이터 셀 스타일 Grey_0 Percent 정렬 좌우/상하
    		dataStyleNormal.setAlignment(CellStyle.ALIGN_LEFT);
    		dataStyleNormal.setVerticalAlignment(CellStyle.ALIGN_CENTER);			
    		dataStyleNormal.setBorderBottom(CellStyle.BORDER_THIN);
    		dataStyleNormal.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleNormal.setBorderLeft(CellStyle.BORDER_THIN);
    		dataStyleNormal.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleNormal.setBorderRight(CellStyle.BORDER_THIN);
    		dataStyleNormal.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleNormal.setBorderTop(CellStyle.BORDER_THIN);
    		dataStyleNormal.setTopBorderColor(IndexedColors.BLACK.getIndex());			
    		
    		
    		// 데이터 셀 스타일 Grey_25 Percent 정렬 좌우/상하
    		dataStyleGray.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    		dataStyleGray.setFillPattern(CellStyle.SOLID_FOREGROUND);
    		dataStyleGray.setAlignment(CellStyle.ALIGN_LEFT);
    		dataStyleGray.setVerticalAlignment(CellStyle.ALIGN_CENTER);			
    		dataStyleGray.setBorderBottom(CellStyle.BORDER_THIN);
    		dataStyleGray.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleGray.setBorderLeft(CellStyle.BORDER_THIN);
    		dataStyleGray.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleGray.setBorderRight(CellStyle.BORDER_THIN);
    		dataStyleGray.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleGray.setBorderTop(CellStyle.BORDER_THIN);
    		dataStyleGray.setTopBorderColor(IndexedColors.BLACK.getIndex());			
    		
    		//TITLE 폰트 설정
    		HSSFFont titleFont = workbook.createFont();
    		titleFont.setFontName("맑은고딕");
    		titleFont.setColor((short) Font.BOLDWEIGHT_BOLD);
    		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    		titleFont.setFontHeightInPoints((short)16);
    		titleStyle.setFont(titleFont);
    		
    		//SUB TITLE 폰트 설정
    		HSSFFont subFont = workbook.createFont();
    		subFont.setFontName("맑은고딕");
    		subFont.setColor((short) Font.BOLDWEIGHT_BOLD);
    		subFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    		subTitleStyle.setFont(subFont);
    		
    		//DATA 폰트 설정
    		HSSFFont font = workbook.createFont();
    		font.setFontName("맑은고딕");
    		font.setColor((short) Font.BOLDWEIGHT_NORMAL);
    		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
    		dataStyleNormal.setFont(font);
    		dataStyleGray.setFont(font);
    		
    		
    		Map resultMap = (Map) resultList.get(0);
    		String[] subjectivitySplit = resultMap.get("row1").toString().split(",");
    		String[] objecttivitySplit = resultMap.get("row2").toString().split(",");
    		
    		int subjectivityCnt = subjectivitySplit.length;
    		int objecttivityCnt = objecttivitySplit.length;
    		
    		sheet.setColumnWidth(0, 10 * 300);//No
    		
    		int columnRowTotal = 1;
    		//객관식설문 넓이
    		for (int i = 0; i < subjectivityCnt; i++) {
    			sheet.setColumnWidth(columnRowTotal, 10 * 500);
    			columnRowTotal++;
			}
    		//주관식 설문 넓이
    		for (int i = 0; i < objecttivityCnt; i++) {
    			sheet.setColumnWidth(columnRowTotal, 10 * 900);
    			columnRowTotal++;
			}
    		
    		/**
    		 * 첫행 제목 란 생성
    		 */
    		int verticalNo = 0;
    		
    		HSSFRow row = sheet.createRow(verticalNo++);
    		
    		row = sheet.createRow(verticalNo++);
    		HSSFCell scell1 = row.createCell(0);
    		HSSFCell scell2 = row.createCell(1);
    		
    		scell1.setCellStyle(subTitleStyle);
    		scell1.setCellValue("설문조사명");			
    		scell2.setCellStyle(dataStyleNormal);
    		scell2.setCellValue(surveyTitle);
    		int mergeNo = columnRowTotal-1;
    		sheet.addMergedRegion(new Region(1, (short) 1, 1, (short) mergeNo)); // 설문조사명 병합
    		
    		for (int i = 0; i < resultList.size(); i++) {
    			Map dataResultMap = (Map) resultList.get(i);
    			
    			String[] subDataSplit = dataResultMap.get("row1").toString().split(",");
        		String[] objDataSplit = dataResultMap.get("row2").toString().split(",");
        		
    			HSSFCell cell = null;
    			row = sheet.createRow(verticalNo++);
    			
    			int dataNo = 0;
    			for(int j=0;j<columnRowTotal;j++){
    				cell = row.createCell(j);
    				if(i==0){
    					cell.setCellStyle(subTitleStyle);
    					cell.setCellStyle(dataStyleGray);
    				}else{
    					cell.setCellStyle(dataStyleNormal);
    				}
    				
    				if(j==0){
    					if(i==0){
    						cell.setCellValue("클래스");
    					}else{
    						cell.setCellValue(CustomUtil.strNull(dataResultMap.get("classId")));
    					}
    					
    				}else if(j<=subDataSplit.length){
    					cell.setCellValue(subDataSplit[dataNo]);
    					dataNo++;
    				}else{
    					if(j==subDataSplit.length+1){dataNo=0;}
    					cell.setCellValue(objDataSplit[dataNo]);
    					dataNo++;
    				}
    				
    			}
    		}
    		
    		return workbook;
    	}catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    
    /**
     * excel 설문조사 엑셀 설정
     * @param params
     * @return
     */
    public static HSSFWorkbook makeHSSFWorkbook(String surveyTitle, List questionList, List answerList) {    	
    	
    	try {
    		// 엑셀 workBook 생성
    		HSSFWorkbook workbook = new HSSFWorkbook();
    		// sheet 생성
    		HSSFSheet sheet = workbook.createSheet("객관식");//sheet명을 다운로드 받는 파일명과 동일하게 작명

    		sheet.setColumnWidth(0, 10 * 300);
    		sheet.setColumnWidth(1, 10 * 300);
    		sheet.setColumnWidth(2, 70 * 300);
    		sheet.setColumnWidth(3, 10 * 300);
    		
    		// Style 지정
    		HSSFCellStyle titleStyle = workbook.createCellStyle();
    		HSSFCellStyle subTitleStyle = workbook.createCellStyle();	
    		
    		HSSFCellStyle dataStyleGray = workbook.createCellStyle();
    		HSSFCellStyle dataStyleNormal = workbook.createCellStyle();
    		//HSSFCellStyle dataStyleLink = workbook.createCellStyle();
    		
    		// 제목
    		titleStyle.setAlignment(CellStyle.ALIGN_LEFT);
    		titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    		titleStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
    		titleStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
    		titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    		
    		titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
    		titleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		titleStyle.setBorderLeft(CellStyle.BORDER_THIN);
    		titleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		titleStyle.setBorderRight(CellStyle.BORDER_THIN);
    		titleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		titleStyle.setBorderTop(CellStyle.BORDER_THIN);
    		titleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
    		
    		
    		// 컬럼 제목
    		subTitleStyle.setAlignment(CellStyle.ALIGN_CENTER);
    		subTitleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    		subTitleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    		subTitleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    		
    		subTitleStyle.setBorderBottom(CellStyle.BORDER_THIN);
    		subTitleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		subTitleStyle.setBorderLeft(CellStyle.BORDER_THIN);
    		subTitleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		subTitleStyle.setBorderRight(CellStyle.BORDER_THIN);
    		subTitleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		subTitleStyle.setBorderTop(CellStyle.BORDER_THIN);
    		subTitleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
    		
    		// 데이터 셀 스타일 Grey_0 Percent 정렬 좌우/상하
    		dataStyleNormal.setAlignment(CellStyle.ALIGN_LEFT);
    		dataStyleNormal.setVerticalAlignment(CellStyle.ALIGN_CENTER);			
    		dataStyleNormal.setBorderBottom(CellStyle.BORDER_THIN);
    		dataStyleNormal.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleNormal.setBorderLeft(CellStyle.BORDER_THIN);
    		dataStyleNormal.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleNormal.setBorderRight(CellStyle.BORDER_THIN);
    		dataStyleNormal.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleNormal.setBorderTop(CellStyle.BORDER_THIN);
    		dataStyleNormal.setTopBorderColor(IndexedColors.BLACK.getIndex());			
    		
    		
    		// 데이터 셀 스타일 Grey_25 Percent 정렬 좌우/상하
    		dataStyleGray.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    		dataStyleGray.setFillPattern(CellStyle.SOLID_FOREGROUND);
    		dataStyleGray.setAlignment(CellStyle.ALIGN_LEFT);
    		dataStyleGray.setVerticalAlignment(CellStyle.ALIGN_CENTER);			
    		dataStyleGray.setBorderBottom(CellStyle.BORDER_THIN);
    		dataStyleGray.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleGray.setBorderLeft(CellStyle.BORDER_THIN);
    		dataStyleGray.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleGray.setBorderRight(CellStyle.BORDER_THIN);
    		dataStyleGray.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		dataStyleGray.setBorderTop(CellStyle.BORDER_THIN);
    		dataStyleGray.setTopBorderColor(IndexedColors.BLACK.getIndex());			
    		
    		//TITLE 폰트 설정
    		HSSFFont titleFont = workbook.createFont();
    		titleFont.setFontName("맑은고딕");
    		titleFont.setColor((short) Font.BOLDWEIGHT_BOLD);
    		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    		titleFont.setFontHeightInPoints((short)16);
    		titleStyle.setFont(titleFont);
    		
    		//SUB TITLE 폰트 설정
    		HSSFFont subFont = workbook.createFont();
    		subFont.setFontName("맑은고딕");
    		subFont.setColor((short) Font.BOLDWEIGHT_BOLD);
    		subFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
    		subTitleStyle.setFont(subFont);
    		
    		//DATA 폰트 설정
    		HSSFFont font = workbook.createFont();
    		font.setFontName("맑은고딕");
    		font.setColor((short) Font.BOLDWEIGHT_NORMAL);
    		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
    		dataStyleNormal.setFont(font);
    		dataStyleGray.setFont(font);
    		
    		/**
    		 *  첫행 제목 란 생성
    		 **/
    		int rowno = 0;
    		
    		HSSFRow row = sheet.createRow(rowno++);
    		
    		row = sheet.createRow(rowno++);
    		HSSFCell scell1 = row.createCell(0);
    		HSSFCell scell2 = row.createCell(1);
    		
    		scell1.setCellStyle(subTitleStyle);
    		scell1.setCellValue("설문조사명");			
    		scell2.setCellStyle(dataStyleNormal);
    		scell2.setCellValue(surveyTitle);			
    		sheet.addMergedRegion(new Region(1, (short) 1, 1, (short) 3)); // 설문조사명 병합
    		    		
    		int questionCnt = 1;
    		for (int i = 0; i < questionList.size(); i++) {
    			
    			HSSFCell qCell = null;
    			row = sheet.createRow(rowno++);
    			Map questionMap = (Map) questionList.get(i);
    			HSSFCell cell1 = row.createCell(0);
    			HSSFCell cell2 = row.createCell(1);
    			HSSFCell cell3 = row.createCell(2);    			
    			cell1.setCellStyle(subTitleStyle);
    			cell1.setCellValue("설문 "+questionCnt++);
    			cell2.setCellStyle(subTitleStyle);
    			cell2.setCellValue("질문명");
    			cell3.setCellStyle(dataStyleGray);
    			cell3.setCellValue(CustomUtil.strNull(questionMap.get("questionTitle")));
    			sheet.addMergedRegion(new Region(rowno-1, (short) 2, rowno-1, (short) 3)); // 질문명 조합
    			int startRow = rowno-1;
    			for(int j=1; j <=10; j++){
    				
	    			if(!CustomUtil.strNull(questionMap.get("question"+j)).equals("")){	    				
	    				row = sheet.createRow(rowno++);
	    				HSSFCell qcell1 = row.createCell(0);
	        			HSSFCell qcell2 = row.createCell(1);
	        			HSSFCell qcell3 = row.createCell(2);    
	        			HSSFCell qcell4 = row.createCell(3);    
	        			
	        			qcell1.setCellStyle(subTitleStyle);
	        			qcell1.setCellValue("");
	        			qcell2.setCellStyle(subTitleStyle);
	        			qcell2.setCellValue("보기 "+j);
	        			qcell3.setCellStyle(dataStyleNormal);
	        			qcell3.setCellValue(CustomUtil.strNull(questionMap.get("question"+j)));
	        			qcell4.setCellStyle(dataStyleNormal);
	        			qcell4.setCellValue(CustomUtil.strNull(questionMap.get("question"+j+"Cnt"))+"명");
	    			}	    		
    			}
    			int endRow = rowno-1;
    			sheet.addMergedRegion(new Region(startRow, (short) 0, endRow, (short) 0)); // 설문 번호 병합
    		}
    		

    		//주관식 응답처리
    		if(answerList.size() > 0 ){
    			HSSFSheet sheet2 = null;       
				int startRow = 0;
				int queCnt = 1;
				int endRow = 0;
				int tempSeqNo = 0;
				int rowno2 = 1;
    			for(int i=0; i < answerList.size(); i++ ){
    				
        			        			    				    				
    				Map answerMap = (Map) answerList.get(i);
    				int questionSeqNo = Integer.parseInt(CustomUtil.strNull(answerMap.get("questionSeqNo")));
    				    				
    				if(tempSeqNo != questionSeqNo){
    					if(tempSeqNo !=0){
    						sheet2.addMergedRegion(new Region(startRow, (short) 0, endRow, (short) 0)); // 설문 번호 병합
    					}    					    					
    	    			sheet2 = workbook.createSheet("주관식 "+queCnt++);
    	    			sheet2.setColumnWidth(0, 10 * 300);
    	    			sheet2.setColumnWidth(1, 10 * 300);
    	    			sheet2.setColumnWidth(2, 100 * 300);    	
    	    			rowno2 = 1;
    					tempSeqNo = 0;
    					startRow = 0;
    					endRow = 0;
    					startRow = rowno2;
    				}    				
      
    				row = sheet2.createRow(rowno2++);
        			if(tempSeqNo == 0){
            			HSSFCell acell1 = row.createCell(0);
            			HSSFCell acell2 = row.createCell(1);
            			HSSFCell acell3 = row.createCell(2);        
        				
        				acell1.setCellStyle(subTitleStyle);
            			acell1.setCellValue("설문 "+questionCnt++);
            			acell2.setCellStyle(subTitleStyle);
            			acell2.setCellValue("질문명");        
            			acell3.setCellStyle(dataStyleGray);
            			acell3.setCellValue(CustomUtil.strNull(answerMap.get("questionTitle")));
            			
            			row = sheet2.createRow(rowno2++);
            			acell1 = row.createCell(0);
            			acell2 = row.createCell(1);
            			acell3 = row.createCell(2);                
        				acell1.setCellStyle(subTitleStyle);
            			acell1.setCellValue("");
            			acell2.setCellStyle(subTitleStyle);
            			acell2.setCellValue("응답 1");
            			acell3.setCellStyle(dataStyleNormal);
            			acell3.setCellValue(CustomUtil.strNull(answerMap.get("subjectivityAnswer")));
            			
        			}else{
        				
            			HSSFCell acell1 = row.createCell(0);
            			HSSFCell acell2 = row.createCell(1);
            			HSSFCell acell3 = row.createCell(2);  
        				
        				acell1.setCellStyle(subTitleStyle);
            			acell1.setCellValue("");
            			acell2.setCellStyle(subTitleStyle);
            			acell2.setCellValue("응답 "+(rowno2-2));
            			acell3.setCellStyle(dataStyleNormal);
            			acell3.setCellValue(CustomUtil.strNull(answerMap.get("subjectivityAnswer")));
        				
        			}
        			endRow = rowno2-1;
        			if(tempSeqNo != questionSeqNo){
        				
        				if(tempSeqNo !=0){
        						
        				}
        				tempSeqNo = questionSeqNo;        				
        				
        			}    				
    				
    			}    			
    			sheet2.addMergedRegion(new Region(startRow, (short) 0, endRow, (short) 0)); // 설문 번호 병합
    			
    		}
    		
    		return workbook;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	
    }
}
