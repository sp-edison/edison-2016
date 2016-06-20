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

package org.kisti.edison.content.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author EDISON
 * @generated
 */
public class GeneralContentPK implements Comparable<GeneralContentPK>,
	Serializable {
	public long contentSeq;
	public long groupId;

	public GeneralContentPK() {
	}

	public GeneralContentPK(long contentSeq, long groupId) {
		this.contentSeq = contentSeq;
		this.groupId = groupId;
	}

	public long getContentSeq() {
		return contentSeq;
	}

	public void setContentSeq(long contentSeq) {
		this.contentSeq = contentSeq;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Override
	public int compareTo(GeneralContentPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (contentSeq < pk.contentSeq) {
			value = -1;
		}
		else if (contentSeq > pk.contentSeq) {
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

		if (!(obj instanceof GeneralContentPK)) {
			return false;
		}

		GeneralContentPK pk = (GeneralContentPK)obj;

		if ((contentSeq == pk.contentSeq) && (groupId == pk.groupId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(contentSeq) + String.valueOf(groupId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("contentSeq");
		sb.append(StringPool.EQUAL);
		sb.append(contentSeq);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("groupId");
		sb.append(StringPool.EQUAL);
		sb.append(groupId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}