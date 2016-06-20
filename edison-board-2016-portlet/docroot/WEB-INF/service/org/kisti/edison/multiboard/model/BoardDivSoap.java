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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.multiboard.service.http.BoardDivServiceSoap}.
 *
 * @author mhkang
 * @see org.kisti.edison.multiboard.service.http.BoardDivServiceSoap
 * @generated
 */
public class BoardDivSoap implements Serializable {
	public static BoardDivSoap toSoapModel(BoardDiv model) {
		BoardDivSoap soapModel = new BoardDivSoap();

		soapModel.setDivCd(model.getDivCd());
		soapModel.setTitleNm(model.getTitleNm());
		soapModel.setContentNm(model.getContentNm());
		soapModel.setDivNm(model.getDivNm());
		soapModel.setFileUpLoadUseYn(model.getFileUpLoadUseYn());
		soapModel.setPopupYn(model.getPopupYn());
		soapModel.setReplyYn(model.getReplyYn());

		return soapModel;
	}

	public static BoardDivSoap[] toSoapModels(BoardDiv[] models) {
		BoardDivSoap[] soapModels = new BoardDivSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BoardDivSoap[][] toSoapModels(BoardDiv[][] models) {
		BoardDivSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BoardDivSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BoardDivSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BoardDivSoap[] toSoapModels(List<BoardDiv> models) {
		List<BoardDivSoap> soapModels = new ArrayList<BoardDivSoap>(models.size());

		for (BoardDiv model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BoardDivSoap[soapModels.size()]);
	}

	public BoardDivSoap() {
	}

	public long getPrimaryKey() {
		return _divCd;
	}

	public void setPrimaryKey(long pk) {
		setDivCd(pk);
	}

	public long getDivCd() {
		return _divCd;
	}

	public void setDivCd(long divCd) {
		_divCd = divCd;
	}

	public String getTitleNm() {
		return _titleNm;
	}

	public void setTitleNm(String titleNm) {
		_titleNm = titleNm;
	}

	public String getContentNm() {
		return _ContentNm;
	}

	public void setContentNm(String ContentNm) {
		_ContentNm = ContentNm;
	}

	public String getDivNm() {
		return _divNm;
	}

	public void setDivNm(String divNm) {
		_divNm = divNm;
	}

	public boolean getFileUpLoadUseYn() {
		return _fileUpLoadUseYn;
	}

	public boolean isFileUpLoadUseYn() {
		return _fileUpLoadUseYn;
	}

	public void setFileUpLoadUseYn(boolean fileUpLoadUseYn) {
		_fileUpLoadUseYn = fileUpLoadUseYn;
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

	public boolean getReplyYn() {
		return _replyYn;
	}

	public boolean isReplyYn() {
		return _replyYn;
	}

	public void setReplyYn(boolean replyYn) {
		_replyYn = replyYn;
	}

	private long _divCd;
	private String _titleNm;
	private String _ContentNm;
	private String _divNm;
	private boolean _fileUpLoadUseYn;
	private boolean _popupYn;
	private boolean _replyYn;
}