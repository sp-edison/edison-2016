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

package org.kisti.edison.science.model;

import org.kisti.edison.science.service.persistence.ScienceAppFavoritePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.ScienceAppFavoriteServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.ScienceAppFavoriteServiceSoap
 * @generated
 */
public class ScienceAppFavoriteSoap implements Serializable {
	public static ScienceAppFavoriteSoap toSoapModel(ScienceAppFavorite model) {
		ScienceAppFavoriteSoap soapModel = new ScienceAppFavoriteSoap();

		soapModel.setScienceAppId(model.getScienceAppId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static ScienceAppFavoriteSoap[] toSoapModels(
		ScienceAppFavorite[] models) {
		ScienceAppFavoriteSoap[] soapModels = new ScienceAppFavoriteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppFavoriteSoap[][] toSoapModels(
		ScienceAppFavorite[][] models) {
		ScienceAppFavoriteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScienceAppFavoriteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScienceAppFavoriteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppFavoriteSoap[] toSoapModels(
		List<ScienceAppFavorite> models) {
		List<ScienceAppFavoriteSoap> soapModels = new ArrayList<ScienceAppFavoriteSoap>(models.size());

		for (ScienceAppFavorite model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScienceAppFavoriteSoap[soapModels.size()]);
	}

	public ScienceAppFavoriteSoap() {
	}

	public ScienceAppFavoritePK getPrimaryKey() {
		return new ScienceAppFavoritePK(_scienceAppId, _userId);
	}

	public void setPrimaryKey(ScienceAppFavoritePK pk) {
		setScienceAppId(pk.scienceAppId);
		setUserId(pk.userId);
	}

	public long getScienceAppId() {
		return _scienceAppId;
	}

	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private long _scienceAppId;
	private long _userId;
	private long _groupId;
}