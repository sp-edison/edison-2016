package org.kisti.edison.util;


import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;


public class ExcelUtil {
	//EXCEL TYPE 따른 VALUE 가지고 오기
	public static String getCellValue(Cell cell) {
		if(cell==null){
			return"";
		}else{
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (HSSFDateUtil.isCellDateFormatted(cell)){
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
						return String.valueOf( formatter.format(cell.getDateCellValue()));
					}else{
						return String.valueOf((long)cell.getNumericCellValue()).trim();
					}
				case Cell.CELL_TYPE_BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue()).trim();
				case Cell.CELL_TYPE_FORMULA:
					switch (cell.getCachedFormulaResultType()) {
		            case Cell.CELL_TYPE_NUMERIC:
		            	if(cell.getCellStyle().getDataFormatString().contains("%")) { 
		            		return roundOff(((double)cell.getNumericCellValue() * 100),2)+"%";
		            	}else{
		            		return String.valueOf((long)cell.getNumericCellValue()).trim();
		            	}
		            	
		            case Cell.CELL_TYPE_STRING: return cell.getStringCellValue().replaceAll("'", "").trim();
		        }
				default:
					return cell.getStringCellValue().trim();
			}
		}
	}
	
	
	
	public static String roundOff(double num, int point){
		return String.valueOf(Math.floor(num * Math.pow(10, point) + 0.5) / Math.pow(10, point));
	}
}
