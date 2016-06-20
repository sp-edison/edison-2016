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

package com.kisti.science.platform.app.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class CommonLibraryPK implements Comparable<CommonLibraryPK>,
	Serializable {
	public String libName;
	public String libPath;

	public CommonLibraryPK() {
	}

	public CommonLibraryPK(String libName, String libPath) {
		this.libName = libName;
		this.libPath = libPath;
	}

	public String getLibName() {
		return libName;
	}

	public void setLibName(String libName) {
		this.libName = libName;
	}

	public String getLibPath() {
		return libPath;
	}

	public void setLibPath(String libPath) {
		this.libPath = libPath;
	}

	@Override
	public int compareTo(CommonLibraryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = libName.compareTo(pk.libName);

		if (value != 0) {
			return value;
		}

		value = libPath.compareTo(pk.libPath);

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

		if (!(obj instanceof CommonLibraryPK)) {
			return false;
		}

		CommonLibraryPK pk = (CommonLibraryPK)obj;

		if ((libName.equals(pk.libName)) && (libPath.equals(pk.libPath))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(libName) + String.valueOf(libPath)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("libName");
		sb.append(StringPool.EQUAL);
		sb.append(libName);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("libPath");
		sb.append(StringPool.EQUAL);
		sb.append(libPath);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}