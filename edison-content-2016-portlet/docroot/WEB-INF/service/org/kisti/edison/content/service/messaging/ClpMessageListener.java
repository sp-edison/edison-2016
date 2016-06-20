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

package org.kisti.edison.content.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.kisti.edison.content.service.AdvancedContentLocalServiceUtil;
import org.kisti.edison.content.service.AdvancedContentServiceUtil;
import org.kisti.edison.content.service.ClpSerializer;
import org.kisti.edison.content.service.GeneralContentLocalServiceUtil;
import org.kisti.edison.content.service.GeneralContentServiceUtil;
import org.kisti.edison.content.service.OrgImgContentLocalServiceUtil;
import org.kisti.edison.content.service.OrgImgContentServiceUtil;

/**
 * @author EDISON
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AdvancedContentLocalServiceUtil.clearService();

			AdvancedContentServiceUtil.clearService();
			GeneralContentLocalServiceUtil.clearService();

			GeneralContentServiceUtil.clearService();
			OrgImgContentLocalServiceUtil.clearService();

			OrgImgContentServiceUtil.clearService();
		}
	}
}