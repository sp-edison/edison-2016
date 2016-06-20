/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package org.kisti.edison.multiboard.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.multiboard.service.http.BoardServiceSoap}.
 *
 * @author mhkang
 * @see org.kisti.edison.multiboard.service.http.BoardServiceSoap
 * @generated
 */
public class BoardSoap implements Serializable {
	public static BoardSoap toSoapModel(Board model) {
		BoardSoap soapModel = new BoardSoap();

		soapModel.setBoardSeq(model.getBoardSeq());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCustomId(model.getCustomId());
		soapModel.setWriterId(model.getWriterId());
		soapModel.setWriterDate(model.getWriterDate());
		soapModel.setReadCnt(model.getReadCnt());
		soapModel.setGroupBoardSeq(model.getGroupBoardSeq());
		soapModel.setGroupBoardTurn(model.getGroupBoardTurn());
		soapModel.setReplyDepth(model.getReplyDepth());
		soapModel.setSiteGroup(model.getSiteGroup());
		soapModel.setPopupYn(model.getPopupYn());
		soapModel.setPopupStartDt(model.getPopupStartDt());
		soapModel.setPopupEndDt(model.getPopupEndDt());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDt(model.getInsertDt());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDt(model.getUpdateDt());

		return soapModel;
	}

	public static BoardSoap[] toSoapModels(Board[] models) {
		BoardSoap[] soapModels = new BoardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BoardSoap[][] toSoapModels(Board[][] models) {
		BoardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BoardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BoardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BoardSoap[] toSoapModels(List<Board> models) {
		List<BoardSoap> soapModels = new ArrayList<BoardSoap>(models.size());

		for (Board model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BoardSoap[soapModels.size()]);
	}

	public BoardSoap() {
	}

	public long getPrimaryKey() {
		return _boardSeq;
	}

	public void setPrimaryKey(long pk) {
		setBoardSeq(pk);
	}

	public long getBoardSeq() {
		return _boardSeq;
	}

	public void setBoardSeq(long boardSeq) {
		_boardSeq = boardSeq;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getCustomId() {
		return _customId;
	}

	public void setCustomId(String customId) {
		_customId = customId;
	}

	public long getWriterId() {
		return _writerId;
	}

	public void setWriterId(long writerId) {
		_writerId = writerId;
	}

	public Date getWriterDate() {
		return _writerDate;
	}

	public void setWriterDate(Date writerDate) {
		_writerDate = writerDate;
	}

	public int getReadCnt() {
		return _readCnt;
	}

	public void setReadCnt(int readCnt) {
		_readCnt = readCnt;
	}

	public int getGroupBoardSeq() {
		return _groupBoardSeq;
	}

	public void setGroupBoardSeq(int groupBoardSeq) {
		_groupBoardSeq = groupBoardSeq;
	}

	public int getGroupBoardTurn() {
		return _groupBoardTurn;
	}

	public void setGroupBoardTurn(int groupBoardTurn) {
		_groupBoardTurn = groupBoardTurn;
	}

	public int getReplyDepth() {
		return _replyDepth;
	}

	public void setReplyDepth(int replyDepth) {
		_replyDepth = replyDepth;
	}

	public String getSiteGroup() {
		return _siteGroup;
	}

	public void setSiteGroup(String siteGroup) {
		_siteGroup = siteGroup;
	}

	public boolean getPopupYn() {
		return _popupYn;
	}

	public boolean isPopupYn() {
		return _popupYn;
	}

	public void setPopupYn(boolean popupYn) {
		_popupYn = popupYn;
	}

	public Date getPopupStartDt() {
		return _popupStartDt;
	}

	public void setPopupStartDt(Date popupStartDt) {
		_popupStartDt = popupStartDt;
	}

	public Date getPopupEndDt() {
		return _popupEndDt;
	}

	public void setPopupEndDt(Date popupEndDt) {
		_popupEndDt = popupEndDt;
	}

	public long getInsertId() {
		return _insertId;
	}

	public void setInsertId(long insertId) {
		_insertId = insertId;
	}

	public Date getInsertDt() {
		return _insertDt;
	}

	public void setInsertDt(Date insertDt) {
		_insertDt = insertDt;
	}

	public long getUpdateId() {
		return _updateId;
	}

	public void setUpdateId(long updateId) {
		_updateId = updateId;
	}

	public Date getUpdateDt() {
		return _updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		_updateDt = updateDt;
	}

	private long _boardSeq;
	private String _title;
	private String _content;
	private long _groupId;
	private String _customId;
	private long _writerId;
	private Date _writerDate;
	private int _readCnt;
	private int _groupBoardSeq;
	private int _groupBoardTurn;
	private int _replyDepth;
	private String _siteGroup;
	private boolean _popupYn;
	private Date _popupStartDt;
	private Date _popupEndDt;
	private long _insertId;
	private Date _insertDt;
	private long _updateId;
	private Date _updateDt;
}