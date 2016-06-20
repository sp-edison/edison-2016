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

import org.kisti.edison.virtuallaboratory.model.SurveyAnswer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SurveyAnswer in entity cache.
 *
 * @author EDISON
 * @see SurveyAnswer
 * @generated
 */
public class SurveyAnswerCacheModel implements CacheModel<SurveyAnswer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{SurveyAnswerId=");
		sb.append(SurveyAnswerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", virtualLabId=");
		sb.append(virtualLabId);
		sb.append(", classId=");
		sb.append(classId);
		sb.append(", subjectivityAnswer=");
		sb.append(subjectivityAnswer);
		sb.append(", objecttivityAnswer=");
		sb.append(objecttivityAnswer);
		sb.append(", answerDate=");
		sb.append(answerDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyAnswer toEntityModel() {
		SurveyAnswerImpl surveyAnswerImpl = new SurveyAnswerImpl();

		surveyAnswerImpl.setSurveyAnswerId(SurveyAnswerId);
		surveyAnswerImpl.setUserId(userId);
		surveyAnswerImpl.setVirtualLabId(virtualLabId);
		surveyAnswerImpl.setClassId(classId);

		if (subjectivityAnswer == null) {
			surveyAnswerImpl.setSubjectivityAnswer(StringPool.BLANK);
		}
		else {
			surveyAnswerImpl.setSubjectivityAnswer(subjectivityAnswer);
		}

		if (objecttivityAnswer == null) {
			surveyAnswerImpl.setObjecttivityAnswer(StringPool.BLANK);
		}
		else {
			surveyAnswerImpl.setObjecttivityAnswer(objecttivityAnswer);
		}

		if (answerDate == Long.MIN_VALUE) {
			surveyAnswerImpl.setAnswerDate(null);
		}
		else {
			surveyAnswerImpl.setAnswerDate(new Date(answerDate));
		}

		surveyAnswerImpl.resetOriginalValues();

		return surveyAnswerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		SurveyAnswerId = objectInput.readLong();
		userId = objectInput.readLong();
		virtualLabId = objectInput.readLong();
		classId = objectInput.readLong();
		subjectivityAnswer = objectInput.readUTF();
		objecttivityAnswer = objectInput.readUTF();
		answerDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(SurveyAnswerId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(virtualLabId);
		objectOutput.writeLong(classId);

		if (subjectivityAnswer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectivityAnswer);
		}

		if (objecttivityAnswer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objecttivityAnswer);
		}

		objectOutput.writeLong(answerDate);
	}

	public long SurveyAnswerId;
	public long userId;
	public long virtualLabId;
	public long classId;
	public String subjectivityAnswer;
	public String objecttivityAnswer;
	public long answerDate;
}