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

package org.kisti.edison.science.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.science.model.DeveloperInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DeveloperInfo in entity cache.
 *
 * @author EDISON
 * @see DeveloperInfo
 * @generated
 */
public class DeveloperInfoCacheModel implements CacheModel<DeveloperInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", universityField=");
		sb.append(universityField);
		sb.append(", majorField=");
		sb.append(majorField);
		sb.append(", useStart=");
		sb.append(useStart);
		sb.append(", useEnd=");
		sb.append(useEnd);
		sb.append(", developerSort=");
		sb.append(developerSort);
		sb.append(", languageFortran=");
		sb.append(languageFortran);
		sb.append(", languageCpp=");
		sb.append(languageCpp);
		sb.append(", languagePython=");
		sb.append(languagePython);
		sb.append(", languageJava=");
		sb.append(languageJava);
		sb.append(", languageOther=");
		sb.append(languageOther);
		sb.append(", languageOtherDescription=");
		sb.append(languageOtherDescription);
		sb.append(", rem=");
		sb.append(rem);
		sb.append(", agreementYn=");
		sb.append(agreementYn);
		sb.append(", writtenOathLogical=");
		sb.append(writtenOathLogical);
		sb.append(", writtenOathPhysical=");
		sb.append(writtenOathPhysical);
		sb.append(", detailIp=");
		sb.append(detailIp);
		sb.append(", detailOs=");
		sb.append(detailOs);
		sb.append(", detailCpu=");
		sb.append(detailCpu);
		sb.append(", detailStorate=");
		sb.append(detailStorate);
		sb.append(", detailLibrary=");
		sb.append(detailLibrary);
		sb.append(", insertId=");
		sb.append(insertId);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append(", updateId=");
		sb.append(updateId);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", etc=");
		sb.append(etc);
		sb.append(", developerId=");
		sb.append(developerId);
		sb.append(", developerPassword=");
		sb.append(developerPassword);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DeveloperInfo toEntityModel() {
		DeveloperInfoImpl developerInfoImpl = new DeveloperInfoImpl();

		developerInfoImpl.setUserId(userId);
		developerInfoImpl.setGroupId(groupId);

		if (screenName == null) {
			developerInfoImpl.setScreenName(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setScreenName(screenName);
		}

		if (firstName == null) {
			developerInfoImpl.setFirstName(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setFirstName(firstName);
		}

		if (emailAddress == null) {
			developerInfoImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setEmailAddress(emailAddress);
		}

		if (universityField == null) {
			developerInfoImpl.setUniversityField(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setUniversityField(universityField);
		}

		if (majorField == null) {
			developerInfoImpl.setMajorField(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setMajorField(majorField);
		}

		if (useStart == null) {
			developerInfoImpl.setUseStart(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setUseStart(useStart);
		}

		if (useEnd == null) {
			developerInfoImpl.setUseEnd(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setUseEnd(useEnd);
		}

		if (developerSort == null) {
			developerInfoImpl.setDeveloperSort(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDeveloperSort(developerSort);
		}

		developerInfoImpl.setLanguageFortran(languageFortran);
		developerInfoImpl.setLanguageCpp(languageCpp);
		developerInfoImpl.setLanguagePython(languagePython);
		developerInfoImpl.setLanguageJava(languageJava);
		developerInfoImpl.setLanguageOther(languageOther);

		if (languageOtherDescription == null) {
			developerInfoImpl.setLanguageOtherDescription(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setLanguageOtherDescription(languageOtherDescription);
		}

		if (rem == null) {
			developerInfoImpl.setRem(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setRem(rem);
		}

		developerInfoImpl.setAgreementYn(agreementYn);

		if (writtenOathLogical == null) {
			developerInfoImpl.setWrittenOathLogical(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setWrittenOathLogical(writtenOathLogical);
		}

		if (writtenOathPhysical == null) {
			developerInfoImpl.setWrittenOathPhysical(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setWrittenOathPhysical(writtenOathPhysical);
		}

		if (detailIp == null) {
			developerInfoImpl.setDetailIp(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDetailIp(detailIp);
		}

		if (detailOs == null) {
			developerInfoImpl.setDetailOs(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDetailOs(detailOs);
		}

		if (detailCpu == null) {
			developerInfoImpl.setDetailCpu(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDetailCpu(detailCpu);
		}

		if (detailStorate == null) {
			developerInfoImpl.setDetailStorate(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDetailStorate(detailStorate);
		}

		if (detailLibrary == null) {
			developerInfoImpl.setDetailLibrary(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDetailLibrary(detailLibrary);
		}

		developerInfoImpl.setInsertId(insertId);

		if (insertDate == Long.MIN_VALUE) {
			developerInfoImpl.setInsertDate(null);
		}
		else {
			developerInfoImpl.setInsertDate(new Date(insertDate));
		}

		developerInfoImpl.setUpdateId(updateId);

		if (updateDate == Long.MIN_VALUE) {
			developerInfoImpl.setUpdateDate(null);
		}
		else {
			developerInfoImpl.setUpdateDate(new Date(updateDate));
		}

		if (etc == null) {
			developerInfoImpl.setEtc(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setEtc(etc);
		}

		if (developerId == null) {
			developerInfoImpl.setDeveloperId(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDeveloperId(developerId);
		}

		if (developerPassword == null) {
			developerInfoImpl.setDeveloperPassword(StringPool.BLANK);
		}
		else {
			developerInfoImpl.setDeveloperPassword(developerPassword);
		}

		developerInfoImpl.resetOriginalValues();

		return developerInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		screenName = objectInput.readUTF();
		firstName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		universityField = objectInput.readUTF();
		majorField = objectInput.readUTF();
		useStart = objectInput.readUTF();
		useEnd = objectInput.readUTF();
		developerSort = objectInput.readUTF();
		languageFortran = objectInput.readBoolean();
		languageCpp = objectInput.readBoolean();
		languagePython = objectInput.readBoolean();
		languageJava = objectInput.readBoolean();
		languageOther = objectInput.readBoolean();
		languageOtherDescription = objectInput.readUTF();
		rem = objectInput.readUTF();
		agreementYn = objectInput.readBoolean();
		writtenOathLogical = objectInput.readUTF();
		writtenOathPhysical = objectInput.readUTF();
		detailIp = objectInput.readUTF();
		detailOs = objectInput.readUTF();
		detailCpu = objectInput.readUTF();
		detailStorate = objectInput.readUTF();
		detailLibrary = objectInput.readUTF();
		insertId = objectInput.readLong();
		insertDate = objectInput.readLong();
		updateId = objectInput.readLong();
		updateDate = objectInput.readLong();
		etc = objectInput.readUTF();
		developerId = objectInput.readUTF();
		developerPassword = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);

		if (screenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (universityField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(universityField);
		}

		if (majorField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(majorField);
		}

		if (useStart == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(useStart);
		}

		if (useEnd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(useEnd);
		}

		if (developerSort == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(developerSort);
		}

		objectOutput.writeBoolean(languageFortran);
		objectOutput.writeBoolean(languageCpp);
		objectOutput.writeBoolean(languagePython);
		objectOutput.writeBoolean(languageJava);
		objectOutput.writeBoolean(languageOther);

		if (languageOtherDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageOtherDescription);
		}

		if (rem == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rem);
		}

		objectOutput.writeBoolean(agreementYn);

		if (writtenOathLogical == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(writtenOathLogical);
		}

		if (writtenOathPhysical == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(writtenOathPhysical);
		}

		if (detailIp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(detailIp);
		}

		if (detailOs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(detailOs);
		}

		if (detailCpu == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(detailCpu);
		}

		if (detailStorate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(detailStorate);
		}

		if (detailLibrary == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(detailLibrary);
		}

		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDate);

		if (etc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(etc);
		}

		if (developerId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(developerId);
		}

		if (developerPassword == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(developerPassword);
		}
	}

	public long userId;
	public long groupId;
	public String screenName;
	public String firstName;
	public String emailAddress;
	public String universityField;
	public String majorField;
	public String useStart;
	public String useEnd;
	public String developerSort;
	public boolean languageFortran;
	public boolean languageCpp;
	public boolean languagePython;
	public boolean languageJava;
	public boolean languageOther;
	public String languageOtherDescription;
	public String rem;
	public boolean agreementYn;
	public String writtenOathLogical;
	public String writtenOathPhysical;
	public String detailIp;
	public String detailOs;
	public String detailCpu;
	public String detailStorate;
	public String detailLibrary;
	public long insertId;
	public long insertDate;
	public long updateId;
	public long updateDate;
	public String etc;
	public String developerId;
	public String developerPassword;
}