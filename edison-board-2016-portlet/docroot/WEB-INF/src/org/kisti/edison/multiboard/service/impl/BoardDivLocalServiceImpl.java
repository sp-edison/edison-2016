/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.kisti.edison.multiboard.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.chainsaw.Main;
import org.kisti.edison.multiboard.model.Board;
import org.kisti.edison.multiboard.model.BoardDiv;
import org.kisti.edison.multiboard.service.base.BoardDivLocalServiceBaseImpl;
import org.kisti.edison.util.CustomUtil;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;

/**
 * The implementation of the board div local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.BoardDivLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.BoardDivLocalServiceBaseImpl
 * @see org.kisti.edison.service.BoardDivLocalServiceUtil
 */
public class BoardDivLocalServiceImpl extends BoardDivLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.BoardDivLocalServiceUtil} to access the board div local service.
	 */

	protected static Logger logger = Logger.getLogger(Main.class.getName());
	
	public List getCustomListBoard(long divCd, int start, int listSize, long groupId, String customId, String searchValue, Locale locale, long groupBoardSeq, boolean popupYn, String siteGroup ) throws SystemException, NoSuchUserException  {
			
		List<Object[]> boardList = boardFinder.getCustomListBoard(divCd, start, listSize, groupId, customId, searchValue, groupBoardSeq, popupYn, siteGroup);
		
		List returnList = new ArrayList();
		Map map = null;
		String contentMain = "";
		if(boardList != null && boardList.size() > 0){
			for(int i=0; i<boardList.size();i++){

				Board board = (Board)boardList.get(i)[0];
				
				map = new HashMap();

				map.put("boardSeq", String.valueOf(board.getBoardSeq()));
				map.put("content", board.getContent(locale));
				
				contentMain = board.getContent(locale).replaceAll("<[^>]*>", "").replaceAll("\n", "");
				if(contentMain.length() > 200){
					contentMain = contentMain.substring(0, 200)+"...";
				}
				map.put("customId", board.getCustomId());
				map.put("contentMain", contentMain);
				map.put("groupBoardSeq", String.valueOf(board.getGroupBoardSeq()));
				map.put("groupBoardTurn", String.valueOf(board.getGroupBoardTurn()));
				map.put("popupStartDt", CustomUtil.dateToStringFormat(board.getPopupStartDt(), "yyyy-MM-dd"));
				map.put("popupEndDt", CustomUtil.dateToStringFormat(board.getPopupEndDt(), "yyyy-MM-dd"));
				map.put("popupYn", String.valueOf(board.getPopupYn()));
				map.put("readCnt", String.valueOf(board.getReadCnt()));
				map.put("replyDepth", String.valueOf(board.getReplyDepth()));
				map.put("title", board.getTitle(locale));
				map.put("writerId", String.valueOf(board.getWriterId()));
				map.put("writerDate", CustomUtil.dateToStringFormat(board.getWriterDate(), "yyyy-MM-dd"));
				map.put("writerName", userPersistence.findByPrimaryKey(board.getWriterId()).getFirstName());
				map.put("replyCount", (Integer)boardList.get(i)[2]);
				returnList.add(map);
			}
		}
		return returnList;
	}	
	
	public int getCustomCountBoard(long divCd, long groupId, String customId, String searchValue, long groupBoardSeq, String siteGroup) throws SystemException, NoSuchUserException  {
			
		int boardCount = boardFinder.getCustomCountBoard(divCd, groupId, customId, searchValue, groupBoardSeq, siteGroup);

		return boardCount;
	}
	
	public List<Map<String,Object>> getAllBoardDivs() throws SystemException {
		List<Map<String,Object>> returnList = new ArrayList<Map<String,Object>>();
		List<BoardDiv> boardDivList = boardDivPersistence.findAll();
		
		
		Locale[] locale = LanguageUtil.getAvailableLocales();
		
		
		for (BoardDiv boardDiv : boardDivList) {
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("divCd", boardDiv.getDivCd());
			

			for(int i=0;i<locale.length;i++){
				returnMap.put("titleNm"+(i+1), boardDiv.getTitleNm(locale[i]));
			}
			
//			returnMap.put("titleNmKor", boardDiv.getTitleNm("ko_KR"));
//			returnMap.put("titleNmEng", boardDiv.getTitleNm("en_US"));
			returnMap.put("contentNm", boardDiv.getContentNm());
			returnMap.put("divNm", boardDiv.getDivNm());
			returnMap.put("fileUpLoadUseYn", boardDiv.getFileUpLoadUseYn());
			returnMap.put("popupYn", boardDiv.getPopupYn());
			returnMap.put("replyYn", boardDiv.getReplyYn());
			returnList.add(returnMap);
		}
		return returnList;
	}
	
	public void removeAll() throws SystemException {
		boardDivPersistence.removeAll();
	}
	
	public void insertBoardDiv(long divCd, String titleNmFirst, String titleNmSecond, String contentNm, String divNm, boolean fileUpLoadUseYn, boolean popupYn, boolean replyYn) throws SystemException {
		BoardDiv boardDiv = boardDivPersistence.fetchByPrimaryKey(divCd);
		if(boardDiv == null) {
			boardDiv = boardDivPersistence.create(divCd);
		}
		
		/*Locale[] locale = LanguageUtil.getAvailableLocales();
		
		boardDiv.setTitleNm(titleNmFirst, Locale.US);
		
		for(int i=0;i<locale.length;i++){
			if(!locale[i].equals(Locale.US)){
				boardDiv.setTitleNm(titleNmSecond, locale[i]);
			}
		}*/
		
		boardDiv.setTitleNm(titleNmFirst, Locale.US);
		boardDiv.setTitleNm(titleNmSecond, Locale.KOREA);
		boardDiv.setContentNm(contentNm);
		boardDiv.setDivNm(divNm);
		boardDiv.setFileUpLoadUseYn(fileUpLoadUseYn);
		boardDiv.setPopupYn(popupYn);
		boardDiv.setReplyYn(replyYn);
		boardDivPersistence.update(boardDiv);
	}
}