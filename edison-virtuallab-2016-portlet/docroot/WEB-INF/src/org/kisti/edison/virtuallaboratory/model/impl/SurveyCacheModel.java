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

package org.kisti.edison.virtuallaboratory.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.virtuallaboratory.model.Survey;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Survey in entity cache.
 *
 * @author EDISON
 * @see Survey
 * @generated
 */
public class SurveyCacheModel implements CacheModel<Survey>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{surveySeqNo=");
		sb.append(surveySeqNo);
		sb.append(", surveyUseYn=");
		sb.append(surveyUseYn);
		sb.append(", surveyTitle=");
		sb.append(surveyTitle);
		sb.append(", surveyStartDate=");
		sb.append(surveyStartDate);
		sb.append(", surveyEndDate=");
		sb.append(surveyEndDate);
		sb.append(", surveyStatus=");
		sb.append(surveyStatus);
		sb.append(", surveyCreateDate=");
		sb.append(surveyCreateDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Survey toEntityModel() {
		SurveyImpl surveyImpl = new SurveyImpl();

		surveyImpl.setSurveySeqNo(surveySeqNo);

		if (surveyUseYn == null) {
			surveyImpl.setSurveyUseYn(StringPool.BLANK);
		}
		else {
			surveyImpl.setSurveyUseYn(surveyUseYn);
		}

		if (surveyTitle == null) {
			surveyImpl.setSurveyTitle(StringPool.BLANK);
		}
		else {
			surveyImpl.setSurveyTitle(surveyTitle);
		}

		if (surveyStartDate == null) {
			surveyImpl.setSurveyStartDate(StringPool.BLANK);
		}
		else {
			surveyImpl.setSurveyStartDate(surveyStartDate);
		}

		if (surveyEndDate == null) {
			surveyImpl.setSurveyEndDate(StringPool.BLANK);
		}
		else {
			surveyImpl.setSurveyEndDate(surveyEndDate);
		}

		if (surveyStatus == null) {
			surveyImpl.setSurveyStatus(StringPool.BLANK);
		}
		else {
			surveyImpl.setSurveyStatus(surveyStatus);
		}

		if (surveyCreateDate == Long.MIN_VALUE) {
			surveyImpl.setSurveyCreateDate(null);
		}
		else {
			surveyImpl.setSurveyCreateDate(new Date(surveyCreateDate));
		}

		surveyImpl.resetOriginalValues();

		return surveyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveySeqNo = objectInput.readLong();
		surveyUseYn = objectInput.readUTF();
		surveyTitle = objectInput.readUTF();
		surveyStartDate = objectInput.readUTF();
		surveyEndDate = objectInput.readUTF();
		surveyStatus = objectInput.readUTF();
		surveyCreateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(surveySeqNo);

		if (surveyUseYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surveyUseYn);
		}

		if (surveyTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surveyTitle);
		}

		if (surveyStartDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surveyStartDate);
		}

		if (surveyEndDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surveyEndDate);
		}

		if (surveyStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(surveyStatus);
		}

		objectOutput.writeLong(surveyCreateDate);
	}

	public long surveySeqNo;
	public String surveyUseYn;
	public String surveyTitle;
	public String surveyStartDate;
	public String surveyEndDate;
	public String surveyStatus;
	public long surveyCreateDate;
}