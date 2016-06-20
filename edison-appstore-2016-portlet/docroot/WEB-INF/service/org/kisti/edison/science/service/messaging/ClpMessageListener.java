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

package org.kisti.edison.science.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.kisti.edison.science.service.ClpSerializer;
import org.kisti.edison.science.service.CommonLibLocalServiceUtil;
import org.kisti.edison.science.service.CommonLibServiceUtil;
import org.kisti.edison.science.service.CommonModuleLocalServiceUtil;
import org.kisti.edison.science.service.CommonModuleServiceUtil;
import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;
import org.kisti.edison.science.service.DeveloperInfoServiceUtil;
import org.kisti.edison.science.service.DeveloperIpLocalServiceUtil;
import org.kisti.edison.science.service.DeveloperIpServiceUtil;
import org.kisti.edison.science.service.DeveloperRequestLocalServiceUtil;
import org.kisti.edison.science.service.DeveloperRequestServiceUtil;
import org.kisti.edison.science.service.PortTypeAnalyzerLinkLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeAnalyzerLinkServiceUtil;
import org.kisti.edison.science.service.PortTypeEditorLinkLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeEditorLinkServiceUtil;
import org.kisti.edison.science.service.PortTypeInputdeckFormLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeLocalServiceUtil;
import org.kisti.edison.science.service.PortTypeServiceUtil;
import org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil;
import org.kisti.edison.science.service.RequiredLibConfirmServiceUtil;
import org.kisti.edison.science.service.RequiredLibLocalServiceUtil;
import org.kisti.edison.science.service.RequiredLibServiceUtil;
import org.kisti.edison.science.service.RequiredModuleLocalServiceUtil;
import org.kisti.edison.science.service.RequiredModuleServiceUtil;
import org.kisti.edison.science.service.ScienceAppCategoryLinkLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppCategoryLinkServiceUtil;
import org.kisti.edison.science.service.ScienceAppDescriptionLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppDescriptionServiceUtil;
import org.kisti.edison.science.service.ScienceAppFavoriteLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppFavoriteServiceUtil;
import org.kisti.edison.science.service.ScienceAppInputPortsLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppManagerLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppManagerServiceUtil;
import org.kisti.edison.science.service.ScienceAppOutputPortsLocalServiceUtil;
import org.kisti.edison.science.service.ScienceAppServiceUtil;

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
			CommonLibLocalServiceUtil.clearService();

			CommonLibServiceUtil.clearService();
			CommonModuleLocalServiceUtil.clearService();

			CommonModuleServiceUtil.clearService();
			DeveloperInfoLocalServiceUtil.clearService();

			DeveloperInfoServiceUtil.clearService();
			DeveloperIpLocalServiceUtil.clearService();

			DeveloperIpServiceUtil.clearService();
			DeveloperRequestLocalServiceUtil.clearService();

			DeveloperRequestServiceUtil.clearService();
			PortTypeLocalServiceUtil.clearService();

			PortTypeServiceUtil.clearService();
			PortTypeAnalyzerLinkLocalServiceUtil.clearService();

			PortTypeAnalyzerLinkServiceUtil.clearService();
			PortTypeEditorLinkLocalServiceUtil.clearService();

			PortTypeEditorLinkServiceUtil.clearService();
			PortTypeInputdeckFormLocalServiceUtil.clearService();

			RequiredLibLocalServiceUtil.clearService();

			RequiredLibServiceUtil.clearService();
			RequiredLibConfirmLocalServiceUtil.clearService();

			RequiredLibConfirmServiceUtil.clearService();
			RequiredModuleLocalServiceUtil.clearService();

			RequiredModuleServiceUtil.clearService();
			ScienceAppLocalServiceUtil.clearService();

			ScienceAppServiceUtil.clearService();
			ScienceAppCategoryLinkLocalServiceUtil.clearService();

			ScienceAppCategoryLinkServiceUtil.clearService();
			ScienceAppDescriptionLocalServiceUtil.clearService();

			ScienceAppDescriptionServiceUtil.clearService();
			ScienceAppFavoriteLocalServiceUtil.clearService();

			ScienceAppFavoriteServiceUtil.clearService();
			ScienceAppInputPortsLocalServiceUtil.clearService();

			ScienceAppManagerLocalServiceUtil.clearService();

			ScienceAppManagerServiceUtil.clearService();
			ScienceAppOutputPortsLocalServiceUtil.clearService();
		}
	}
}