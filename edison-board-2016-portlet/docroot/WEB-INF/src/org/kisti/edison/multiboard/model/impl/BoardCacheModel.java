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

import org.kisti.edison.multiboard.model.Board;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Board in entity cache.
 *
 * @author mhkang
 * @see Board
 * @generated
 */
public class BoardCacheModel implements CacheModel<Board>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{boardSeq=");
		sb.append(boardSeq);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", customId=");
		sb.append(customId);
		sb.append(", writerId=");
		sb.append(writerId);
		sb.append(", writerDate=");
		sb.append(writerDate);
		sb.append(", readCnt=");
		sb.append(readCnt);
		sb.append(", groupBoardSeq=");
		sb.append(groupBoardSeq);
		sb.append(", groupBoardTurn=");
		sb.append(groupBoardTurn);
		sb.append(", replyDepth=");
		sb.append(replyDepth);
		sb.append(", siteGroup=");
		sb.append(siteGroup);
		sb.append(", popupYn=");
		sb.append(popupYn);
		sb.append(", popupStartDt=");
		sb.append(popupStartDt);
		sb.append(", popupEndDt=");
		sb.append(popupEndDt);
		sb.append(", insertId=");
		sb.append(insertId);
		sb.append(", insertDt=");
		sb.append(insertDt);
		sb.append(", updateId=");
		sb.append(updateId);
		sb.append(", updateDt=");
		sb.append(updateDt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Board toEntityModel() {
		BoardImpl boardImpl = new BoardImpl();

		boardImpl.setBoardSeq(boardSeq);

		if (title == null) {
			boardImpl.setTitle(StringPool.BLANK);
		}
		else {
			boardImpl.setTitle(title);
		}

		if (content == null) {
			boardImpl.setContent(StringPool.BLANK);
		}
		else {
			boardImpl.setContent(content);
		}

		boardImpl.setGroupId(groupId);

		if (customId == null) {
			boardImpl.setCustomId(StringPool.BLANK);
		}
		else {
			boardImpl.setCustomId(customId);
		}

		boardImpl.setWriterId(writerId);

		if (writerDate == Long.MIN_VALUE) {
			boardImpl.setWriterDate(null);
		}
		else {
			boardImpl.setWriterDate(new Date(writerDate));
		}

		boardImpl.setReadCnt(readCnt);
		boardImpl.setGroupBoardSeq(groupBoardSeq);
		boardImpl.setGroupBoardTurn(groupBoardTurn);
		boardImpl.setReplyDepth(replyDepth);

		if (siteGroup == null) {
			boardImpl.setSiteGroup(StringPool.BLANK);
		}
		else {
			boardImpl.setSiteGroup(siteGroup);
		}

		boardImpl.setPopupYn(popupYn);

		if (popupStartDt == Long.MIN_VALUE) {
			boardImpl.setPopupStartDt(null);
		}
		else {
			boardImpl.setPopupStartDt(new Date(popupStartDt));
		}

		if (popupEndDt == Long.MIN_VALUE) {
			boardImpl.setPopupEndDt(null);
		}
		else {
			boardImpl.setPopupEndDt(new Date(popupEndDt));
		}

		boardImpl.setInsertId(insertId);

		if (insertDt == Long.MIN_VALUE) {
			boardImpl.setInsertDt(null);
		}
		else {
			boardImpl.setInsertDt(new Date(insertDt));
		}

		boardImpl.setUpdateId(updateId);

		if (updateDt == Long.MIN_VALUE) {
			boardImpl.setUpdateDt(null);
		}
		else {
			boardImpl.setUpdateDt(new Date(updateDt));
		}

		boardImpl.resetOriginalValues();

		return boardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		boardSeq = objectInput.readLong();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		groupId = objectInput.readLong();
		customId = objectInput.readUTF();
		writerId = objectInput.readLong();
		writerDate = objectInput.readLong();
		readCnt = objectInput.readInt();
		groupBoardSeq = objectInput.readInt();
		groupBoardTurn = objectInput.readInt();
		replyDepth = objectInput.readInt();
		siteGroup = objectInput.readUTF();
		popupYn = objectInput.readBoolean();
		popupStartDt = objectInput.readLong();
		popupEndDt = objectInput.readLong();
		insertId = objectInput.readLong();
		insertDt = objectInput.readLong();
		updateId = objectInput.readLong();
		updateDt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(boardSeq);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(groupId);

		if (customId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customId);
		}

		objectOutput.writeLong(writerId);
		objectOutput.writeLong(writerDate);
		objectOutput.writeInt(readCnt);
		objectOutput.writeInt(groupBoardSeq);
		objectOutput.writeInt(groupBoardTurn);
		objectOutput.writeInt(replyDepth);

		if (siteGroup == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(siteGroup);
		}

		objectOutput.writeBoolean(popupYn);
		objectOutput.writeLong(popupStartDt);
		objectOutput.writeLong(popupEndDt);
		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDt);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDt);
	}

	public long boardSeq;
	public String title;
	public String content;
	public long groupId;
	public String customId;
	public long writerId;
	public long writerDate;
	public int readCnt;
	public int groupBoardSeq;
	public int groupBoardTurn;
	public int replyDepth;
	public String siteGroup;
	public boolean popupYn;
	public long popupStartDt;
	public long popupEndDt;
	public long insertId;
	public long insertDt;
	public long updateId;
	public long updateDt;
}