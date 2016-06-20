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

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.multiboard.model.Board;
import org.kisti.edison.multiboard.service.base.BoardLocalServiceBaseImpl;
import org.kisti.edison.util.CustomUtil;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.User;

/**
 * The implementation of the board local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.BoardLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.BoardLocalServiceBaseImpl
 * @see org.kisti.edison.service.BoardLocalServiceUtil
 */
public class BoardLocalServiceImpl extends BoardLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.BoardLocalServiceUtil} to access the board local service.
	 * long groupId, long divCd, String title, String content, long userId, Locale locale
	 */
	@Transactional
	public Board addBoard(Map<String, Object> params) throws SystemException, ParseException, NoSuchModelException  {
		User user = userPersistence.findByPrimaryKey((Long)params.get("userId"));
		long boardSeq = counterLocalService.increment(Board.class.getName());
	
		Locale locale = (Locale)params.get("locale");
		
		Date now = new Date();
		
		Board board = boardPersistence.create(boardSeq);
		
		board.setGroupId((Long)params.get("groupId"));
		board.setCustomId(CustomUtil.strNull(params.get("customId")));
		
		Locale[] availLocal = LanguageUtil.getAvailableLocales();
		
		
		for(int i=0;i<availLocal.length;i++){
			board.setTitle(CustomUtil.strNull(params.get("title")), availLocal[i], Locale.US);		
			board.setContent(CustomUtil.strNull(params.get("content")), availLocal[i], Locale.US);		
		}
		
		board.setWriterId(user.getUserId());
		board.setWriterDate(CustomUtil.StringToDateFormat(CustomUtil.strNull(params.get("writerDate")), "yyyy-MM-dd"));
		board.setGroupBoardSeq(Integer.parseInt(CustomUtil.strNull(params.get("groupBoardSeq"), String.valueOf(boardSeq))));
		board.setGroupBoardTurn(Integer.parseInt(CustomUtil.strNull(params.get("groupBoardTurn"), String.valueOf(boardSeq))));
		board.setReplyDepth(Integer.parseInt(CustomUtil.strNull(params.get("replyDepth"), String.valueOf(0))));
		board.setPopupYn((Boolean) params.get("popupYn"));
		board.setSiteGroup(CustomUtil.strNull(params.get("siteGroup")));
		board.setPopupStartDt(CustomUtil.StringToDateFormat(CustomUtil.strNull(params.get("popupStartDt")), "yyyy-MM-dd"));
		board.setPopupEndDt(CustomUtil.StringToDateFormat(CustomUtil.strNull(params.get("popupEndDt")), "yyyy-MM-dd"));
		board.setInsertId(user.getUserId());
		board.setInsertDt(now);
		board.setSiteGroup(CustomUtil.strNull(params.get("siteGroup")));
		
		super.addBoard(board);
		super.addBoardDivBoard((Long)params.get("divCd"), board);

		return board;
	}

	@Transactional
	public Board updateBoard(Map<String, Object> params) throws SystemException, ParseException, NoSuchModelException  {
		
		User user = userPersistence.findByPrimaryKey((Long)params.get("userId"));
		
		long boardSeq = (Long)params.get("boardSeq");
		Locale locale = (Locale)params.get("locale");		
		
		Board board = boardPersistence.findByPrimaryKey(boardSeq);
		Date now = new Date();
		
		board.setBoardSeq(boardSeq);
		
		if(params.get("title") != null)	board.setTitle(CustomUtil.strNull(params.get("title")), locale, Locale.US);
		if(params.get("content") != null)	board.setContent(CustomUtil.strNull(params.get("content")), locale, Locale.US);		
		if(params.get("siteGroup") != null)	board.setSiteGroup(CustomUtil.strNull(params.get("siteGroup")));
		if(params.get("popupYn") != null)	board.setPopupYn((Boolean) params.get("popupYn"));
		if(params.get("popupStartDt") != null)	board.setPopupStartDt(CustomUtil.StringToDateFormat(CustomUtil.strNull(params.get("popupStartDt")), "yyyy-MM-dd"));
		if(params.get("popupEndDt") != null)	board.setPopupEndDt(CustomUtil.StringToDateFormat(CustomUtil.strNull(params.get("popupEndDt")), "yyyy-MM-dd"));
		if(params.get("readCnt") != null)	board.setReadCnt(Integer.parseInt(CustomUtil.strNull(params.get("readCnt"))));
		if(params.get("siteGroup") != null)	board.setSiteGroup(CustomUtil.strNull(params.get("siteGroup")));
		
		board.setUpdateId(user.getUserId());
		board.setUpdateDt(now);
		
		super.updateBoard(board);

		return board;
	}
	
	public Map getBoard(long divCd, String customId, long boardSeq, Locale locale){
		
		Board brd;
		Map map = new HashMap();
		try {
			
			Object [] brdObject = boardFinder.getBoard(divCd, customId, boardSeq);
			
			brd = (Board)brdObject[0];
			
			map.put("boardSeq", String.valueOf(brd.getBoardSeq()));
			map.put("groupId", String.valueOf(brd.getGroupId()));
			map.put("content", brd.getContent(locale));
			map.put("groupBoardSeq", String.valueOf(brd.getGroupBoardSeq()));
			map.put("groupBoardTurn", String.valueOf(brd.getGroupBoardTurn()));
			map.put("popupStartDt", CustomUtil.dateToStringFormat(brd.getPopupStartDt(), "yyyy-MM-dd"));
			map.put("popupEndDt", CustomUtil.dateToStringFormat(brd.getPopupEndDt(), "yyyy-MM-dd"));
			map.put("popupYn", String.valueOf(brd.getPopupYn()));
			map.put("siteGroup", CustomUtil.strNull(brd.getSiteGroup()));
			map.put("readCnt", String.valueOf(brd.getReadCnt()));
			map.put("replyDepth", String.valueOf(brd.getReplyDepth()));
			map.put("title", brd.getTitle(locale));
			map.put("writerId", String.valueOf(brd.getWriterId()));
			map.put("writerDate", CustomUtil.dateToStringFormat(brd.getWriterDate(), "yyyy-MM-dd"));
			map.put("writerName", userPersistence.findByPrimaryKey(brd.getWriterId()).getFirstName());
			map.put("replyCount", (Integer)brdObject[2]);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	
	
	
}

