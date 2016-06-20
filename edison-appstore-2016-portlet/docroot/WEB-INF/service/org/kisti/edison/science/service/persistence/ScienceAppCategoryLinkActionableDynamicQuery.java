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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.science.model.ScienceAppCategoryLink;
import org.kisti.edison.science.service.ScienceAppCategoryLinkLocalServiceUtil;

/**
 * @author EDISON
 * @generated
 */
public abstract class ScienceAppCategoryLinkActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ScienceAppCategoryLinkActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(ScienceAppCategoryLinkLocalServiceUtil.getService());
		setClass(ScienceAppCategoryLink.class);

		setClassLoader(org.kisti.edison.science.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("scienceAppCategoryLinkId");
	}
}