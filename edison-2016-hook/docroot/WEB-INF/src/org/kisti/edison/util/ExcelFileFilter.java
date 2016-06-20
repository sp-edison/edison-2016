package org.kisti.edison.util;

import java.io.File;
import java.io.FilenameFilter;

public class ExcelFileFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		boolean isAccept = false;
		if(name.trim().toUpperCase().endsWith("XLX")==true){
			isAccept = true;
		}else if(name.toUpperCase().endsWith("XLSX")==true){
			isAccept = true;
		}else{
			isAccept = false;
		}
		return isAccept;
	}

}
