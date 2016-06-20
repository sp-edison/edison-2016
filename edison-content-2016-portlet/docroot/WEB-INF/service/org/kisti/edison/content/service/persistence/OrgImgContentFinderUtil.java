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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class OrgImgContentFinderUtil {
	public static java.util.List<org.kisti.edison.content.model.OrgImgContent> getOrderOrgImgContentList(
		long groupId, long order) {
		return getFinder().getOrderOrgImgContentList(groupId, order);
	}

	public static OrgImgContentFinder getFinder() {
		if (_finder == null) {
			_finder = (OrgImgContentFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.content.service.ClpSerializer.getServletContextName(),
					OrgImgContentFinder.class.getName());

			ReferenceRegistry.registerReference(OrgImgContentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(OrgImgContentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(OrgImgContentFinderUtil.class,
			"_finder");
	}

	private static OrgImgContentFinder _finder;
}