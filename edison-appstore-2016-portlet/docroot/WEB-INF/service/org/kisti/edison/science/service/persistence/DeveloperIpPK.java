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
public class DeveloperIpPK implements Comparable<DeveloperIpPK>, Serializable {
	public long ipSeq;
	public long userId;
	public long groupId;

	public DeveloperIpPK() {
	}

	public DeveloperIpPK(long ipSeq, long userId, long groupId) {
		this.ipSeq = ipSeq;
		this.userId = userId;
		this.groupId = groupId;
	}

	public long getIpSeq() {
		return ipSeq;
	}

	public void setIpSeq(long ipSeq) {
		this.ipSeq = ipSeq;
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
	public int compareTo(DeveloperIpPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (ipSeq < pk.ipSeq) {
			value = -1;
		}
		else if (ipSeq > pk.ipSeq) {
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

		if (!(obj instanceof DeveloperIpPK)) {
			return false;
		}

		DeveloperIpPK pk = (DeveloperIpPK)obj;

		if ((ipSeq == pk.ipSeq) && (userId == pk.userId) &&
				(groupId == pk.groupId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(ipSeq) + String.valueOf(userId) +
		String.valueOf(groupId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("ipSeq");
		sb.append(StringPool.EQUAL);
		sb.append(ipSeq);

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