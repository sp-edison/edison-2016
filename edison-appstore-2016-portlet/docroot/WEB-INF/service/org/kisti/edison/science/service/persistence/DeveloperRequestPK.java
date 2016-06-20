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

package org.kisti.edison.science.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author EDISON
 * @generated
 */
public class DeveloperRequestPK implements Comparable<DeveloperRequestPK>,
	Serializable {
	public long requestSeq;
	public long userId;
	public long groupId;

	public DeveloperRequestPK() {
	}

	public DeveloperRequestPK(long requestSeq, long userId, long groupId) {
		this.requestSeq = requestSeq;
		this.userId = userId;
		this.groupId = groupId;
	}

	public long getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(long requestSeq) {
		this.requestSeq = requestSeq;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Override
	public int compareTo(DeveloperRequestPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (requestSeq < pk.requestSeq) {
			value = -1;
		}
		else if (requestSeq > pk.requestSeq) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeveloperRequestPK)) {
			return false;
		}

		DeveloperRequestPK pk = (DeveloperRequestPK)obj;

		if ((requestSeq == pk.requestSeq) && (userId == pk.userId) &&
				(groupId == pk.groupId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(requestSeq) + String.valueOf(userId) +
		String.valueOf(groupId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("requestSeq");
		sb.append(StringPool.EQUAL);
		sb.append(requestSeq);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("groupId");
		sb.append(StringPool.EQUAL);
		sb.append(groupId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}