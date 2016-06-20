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

package org.kisti.edison.bestsimulation.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.kisti.edison.bestsimulation.service.ClpSerializer;
import org.kisti.edison.bestsimulation.service.SimulationJobDataLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationJobDataServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationJobServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationJobStatusServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationServiceUtil;

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
			SimulationLocalServiceUtil.clearService();

			SimulationServiceUtil.clearService();
			SimulationJobLocalServiceUtil.clearService();

			SimulationJobServiceUtil.clearService();
			SimulationJobDataLocalServiceUtil.clearService();

			SimulationJobDataServiceUtil.clearService();
			SimulationJobStatusLocalServiceUtil.clearService();

			SimulationJobStatusServiceUtil.clearService();
		}
	}
}