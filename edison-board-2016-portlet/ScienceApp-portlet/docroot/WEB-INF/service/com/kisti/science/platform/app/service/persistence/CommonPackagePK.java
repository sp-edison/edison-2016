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
public class CommonPackagePK implements Comparable<CommonPackagePK>,
	Serializable {
	public String pkgName;
	public String pkgVersion;

	public CommonPackagePK() {
	}

	public CommonPackagePK(String pkgName, String pkgVersion) {
		this.pkgName = pkgName;
		this.pkgVersion = pkgVersion;
	}

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public String getPkgVersion() {
		return pkgVersion;
	}

	public void setPkgVersion(String pkgVersion) {
		this.pkgVersion = pkgVersion;
	}

	@Override
	public int compareTo(CommonPackagePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = pkgName.compareTo(pk.pkgName);

		if (value != 0) {
			return value;
		}

		value = pkgVersion.compareTo(pk.pkgVersion);

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

		if (!(obj instanceof CommonPackagePK)) {
			return false;
		}

		CommonPackagePK pk = (CommonPackagePK)obj;

		if ((pkgName.equals(pk.pkgName)) && (pkgVersion.equals(pk.pkgVersion))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(pkgName) + String.valueOf(pkgVersion)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("pkgName");
		sb.append(StringPool.EQUAL);
		sb.append(pkgName);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("pkgVersion");
		sb.append(StringPool.EQUAL);
		sb.append(pkgVersion);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}