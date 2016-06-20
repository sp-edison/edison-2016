package org.kisti.edison.util;

public class PagingUtil {

	public static String getPaging(String contextPath, String methodName, int totalCount, int currentPage, int listSize, int blockSize) {
		StringBuffer retStr = new StringBuffer();

		int totalPage = (int) Math.ceil( (double)totalCount/(double)listSize );
		int totalBlock = (int) Math.ceil( (double)totalPage/(double)blockSize );
		int curBlock = (int) Math.ceil( (double)currentPage/(double)blockSize );
		
		int startPage = (curBlock-1)*blockSize+1;
		int endPage = startPage + blockSize-1;
		
		if( endPage > totalPage ) endPage = totalPage;
		
		if( totalPage<=1 ) return "";
		
		String firstButton	= "<img src='"+contextPath+"/images/firstpage.png' width='30' height='30' />";
		String preButton	= "<img src='"+contextPath+"/images/prepage.png' width='30' height='30' />";
		String nextButton	= "<img src='"+contextPath+"/images/nextpage.png' width='30' height='30' />";
		String lastButton	= "<img src='"+contextPath+"/images/lastpage.png' width='30' height='30' />";
		
		
		/* 이전블록 가기 */
		if( curBlock > 1 ){
			retStr.append("<ul><li><a href='#' onclick=\'"+methodName+"(1);return false;\'>"+firstButton+"</a></li>");
			retStr.append("<li><a href='#' onclick=\'"+methodName+"("+(startPage-1)+");return false;\'>"+preButton+"</a></li>");
		} else {
			retStr.append("<ul><li>" + preButton + "</li>");
		}
		
		for(int i=startPage ; i<=endPage ; i++ ){
			if( i==currentPage ){
				retStr.append("<li class=\'select\'><b>"+i+"</b></li>");
			} else {
				retStr.append("<li><a href='#' onclick=\'"+methodName+"("+i+");return false;\'>"+i+"</a></li>");
			}
		}

		/* 다음블록 가기 */
		retStr.append("&nbsp;");
		if( curBlock < totalBlock ){
			retStr.append("<li><a href='#' onclick=\'"+methodName+"("+(endPage+1)+");return false;\'>"+nextButton+"</a></li>");
			retStr.append("<li><a href='#' onclick=\'"+methodName+"("+totalPage+");return false;\'>"+lastButton+"</a></li></ul>");			
		} else {
			retStr.append("<li>" + nextButton + "</li></ul>");
		}
		
		return retStr.toString();
	}

}
