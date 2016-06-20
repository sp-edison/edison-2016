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

package org.kisti.edison.project.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author EDISON
 * @generated
 */
public class HistoryScienceAppPK implements Comparable<HistoryScienceAppPK>,
	Serializable {
	public long scienceAppId;
	public long groupId;
	public long projectCategoryId;

	public HistoryScienceAppPK() {
	}

	public HistoryScienceAppPK(long scienceAppId, long groupId,
		long projectCategoryId) {
		this.scienceAppId = scienceAppId;
		this.groupId = groupId;
		this.projectCategoryId = projectCategoryId;
	}

	public long getScienceAppId() {
		return scienceAppId;
	}

	public void setScienceAppId(long scienceAppId) {
		this.scienceAppId = scienceAppId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(long projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	@Override
	public int compareTo(HistoryScienceAppPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (scienceAppId < pk.scienceAppId) {
			value = -1;
		}
		else if (scienceAppId > pk.scienceAppId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (groupId < pk.groupId) {
			value = -1;
		}
		else if (groupId > pk.groupId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (projectCategoryId < pk.projectCategoryId) {
			value = -1;
		}
		else if (projectCategoryId > pk.projectCategoryId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryScienceAppPK)) {
			return false;
		}

		HistoryScienceAppPK pk = (HistoryScienceAppPK)obj;

		if ((scienceAppId == pk.scienceAppId) && (groupId == pk.groupId) &&
				(projectCategoryId == pk.projectCategoryId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(scienceAppId) + String.valueOf(groupId) +
		String.valueOf(projectCategoryId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("scienceAppId");
		sb.append(StringPool.EQUAL);
		sb.append(scienceAppId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("groupId");
		sb.append(StringPool.EQUAL);
		sb.append(groupId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("projectCategoryId");
		sb.append(StringPool.EQUAL);
		sb.append(projectCategoryId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}