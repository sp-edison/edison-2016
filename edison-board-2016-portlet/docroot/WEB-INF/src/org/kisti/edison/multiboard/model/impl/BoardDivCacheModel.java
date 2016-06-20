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

package org.kisti.edison.multiboard.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.multiboard.model.BoardDiv;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BoardDiv in entity cache.
 *
 * @author mhkang
 * @see BoardDiv
 * @generated
 */
public class BoardDivCacheModel implements CacheModel<BoardDiv>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{divCd=");
		sb.append(divCd);
		sb.append(", titleNm=");
		sb.append(titleNm);
		sb.append(", ContentNm=");
		sb.append(ContentNm);
		sb.append(", divNm=");
		sb.append(divNm);
		sb.append(", fileUpLoadUseYn=");
		sb.append(fileUpLoadUseYn);
		sb.append(", popupYn=");
		sb.append(popupYn);
		sb.append(", replyYn=");
		sb.append(replyYn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BoardDiv toEntityModel() {
		BoardDivImpl boardDivImpl = new BoardDivImpl();

		boardDivImpl.setDivCd(divCd);

		if (titleNm == null) {
			boardDivImpl.setTitleNm(StringPool.BLANK);
		}
		else {
			boardDivImpl.setTitleNm(titleNm);
		}

		if (ContentNm == null) {
			boardDivImpl.setContentNm(StringPool.BLANK);
		}
		else {
			boardDivImpl.setContentNm(ContentNm);
		}

		if (divNm == null) {
			boardDivImpl.setDivNm(StringPool.BLANK);
		}
		else {
			boardDivImpl.setDivNm(divNm);
		}

		boardDivImpl.setFileUpLoadUseYn(fileUpLoadUseYn);
		boardDivImpl.setPopupYn(popupYn);
		boardDivImpl.setReplyYn(replyYn);

		boardDivImpl.resetOriginalValues();

		return boardDivImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		divCd = objectInput.readLong();
		titleNm = objectInput.readUTF();
		ContentNm = objectInput.readUTF();
		divNm = objectInput.readUTF();
		fileUpLoadUseYn = objectInput.readBoolean();
		popupYn = objectInput.readBoolean();
		replyYn = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(divCd);

		if (titleNm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(titleNm);
		}

		if (ContentNm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ContentNm);
		}

		if (divNm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(divNm);
		}

		objectOutput.writeBoolean(fileUpLoadUseYn);
		objectOutput.writeBoolean(popupYn);
		objectOutput.writeBoolean(replyYn);
	}

	public long divCd;
	public String titleNm;
	public String ContentNm;
	public String divNm;
	public boolean fileUpLoadUseYn;
	public boolean popupYn;
	public boolean replyYn;
}