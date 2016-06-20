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

import org.kisti.edison.virtuallaboratory.model.SurveyQuestion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SurveyQuestion in entity cache.
 *
 * @author EDISON
 * @see SurveyQuestion
 * @generated
 */
public class SurveyQuestionCacheModel implements CacheModel<SurveyQuestion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{questionSeqNo=");
		sb.append(questionSeqNo);
		sb.append(", questionDivCd=");
		sb.append(questionDivCd);
		sb.append(", questionTitle=");
		sb.append(questionTitle);
		sb.append(", question1=");
		sb.append(question1);
		sb.append(", question2=");
		sb.append(question2);
		sb.append(", question3=");
		sb.append(question3);
		sb.append(", question4=");
		sb.append(question4);
		sb.append(", question5=");
		sb.append(question5);
		sb.append(", question6=");
		sb.append(question6);
		sb.append(", question7=");
		sb.append(question7);
		sb.append(", question8=");
		sb.append(question8);
		sb.append(", question9=");
		sb.append(question9);
		sb.append(", question10=");
		sb.append(question10);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SurveyQuestion toEntityModel() {
		SurveyQuestionImpl surveyQuestionImpl = new SurveyQuestionImpl();

		surveyQuestionImpl.setQuestionSeqNo(questionSeqNo);

		if (questionDivCd == null) {
			surveyQuestionImpl.setQuestionDivCd(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestionDivCd(questionDivCd);
		}

		if (questionTitle == null) {
			surveyQuestionImpl.setQuestionTitle(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestionTitle(questionTitle);
		}

		if (question1 == null) {
			surveyQuestionImpl.setQuestion1(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion1(question1);
		}

		if (question2 == null) {
			surveyQuestionImpl.setQuestion2(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion2(question2);
		}

		if (question3 == null) {
			surveyQuestionImpl.setQuestion3(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion3(question3);
		}

		if (question4 == null) {
			surveyQuestionImpl.setQuestion4(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion4(question4);
		}

		if (question5 == null) {
			surveyQuestionImpl.setQuestion5(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion5(question5);
		}

		if (question6 == null) {
			surveyQuestionImpl.setQuestion6(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion6(question6);
		}

		if (question7 == null) {
			surveyQuestionImpl.setQuestion7(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion7(question7);
		}

		if (question8 == null) {
			surveyQuestionImpl.setQuestion8(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion8(question8);
		}

		if (question9 == null) {
			surveyQuestionImpl.setQuestion9(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion9(question9);
		}

		if (question10 == null) {
			surveyQuestionImpl.setQuestion10(StringPool.BLANK);
		}
		else {
			surveyQuestionImpl.setQuestion10(question10);
		}

		surveyQuestionImpl.resetOriginalValues();

		return surveyQuestionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		questionSeqNo = objectInput.readLong();
		questionDivCd = objectInput.readUTF();
		questionTitle = objectInput.readUTF();
		question1 = objectInput.readUTF();
		question2 = objectInput.readUTF();
		question3 = objectInput.readUTF();
		question4 = objectInput.readUTF();
		question5 = objectInput.readUTF();
		question6 = objectInput.readUTF();
		question7 = objectInput.readUTF();
		question8 = objectInput.readUTF();
		question9 = objectInput.readUTF();
		question10 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(questionSeqNo);

		if (questionDivCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(questionDivCd);
		}

		if (questionTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(questionTitle);
		}

		if (question1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question1);
		}

		if (question2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question2);
		}

		if (question3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question3);
		}

		if (question4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question4);
		}

		if (question5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question5);
		}

		if (question6 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question6);
		}

		if (question7 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question7);
		}

		if (question8 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question8);
		}

		if (question9 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question9);
		}

		if (question10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question10);
		}
	}

	public long questionSeqNo;
	public String questionDivCd;
	public String questionTitle;
	public String question1;
	public String question2;
	public String question3;
	public String question4;
	public String question5;
	public String question6;
	public String question7;
	public String question8;
	public String question9;
	public String question10;
}