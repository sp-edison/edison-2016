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

package org.kisti.edison.project.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.kisti.edison.project.service.ClpSerializer;
import org.kisti.edison.project.service.HistoryAppSimulationLocalServiceUtil;
import org.kisti.edison.project.service.HistoryAppSimulationServiceUtil;
import org.kisti.edison.project.service.HistoryContentLocalServiceUtil;
import org.kisti.edison.project.service.HistoryContentServiceUtil;
import org.kisti.edison.project.service.HistoryScienceAppLocalServiceUtil;
import org.kisti.edison.project.service.HistoryScienceAppServiceUtil;

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
			HistoryAppSimulationLocalServiceUtil.clearService();

			HistoryAppSimulationServiceUtil.clearService();
			HistoryContentLocalServiceUtil.clearService();

			HistoryContentServiceUtil.clearService();
			HistoryScienceAppLocalServiceUtil.clearService();

			HistoryScienceAppServiceUtil.clearService();
		}
	}
}