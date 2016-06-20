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

import com.kisti.science.platform.app.model.PortTypeAnalyzerLink;
import com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public abstract class PortTypeAnalyzerLinkActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public PortTypeAnalyzerLinkActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(PortTypeAnalyzerLinkLocalServiceUtil.getService());
		setClass(PortTypeAnalyzerLink.class);

		setClassLoader(com.kisti.science.platform.app.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("portTypeAnalyzerLinkId");
	}
}