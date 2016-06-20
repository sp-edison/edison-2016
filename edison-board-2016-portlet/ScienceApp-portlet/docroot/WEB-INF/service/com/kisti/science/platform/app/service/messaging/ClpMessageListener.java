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

package com.kisti.science.platform.app.service.messaging;

import com.kisti.science.platform.app.service.AppTestHistoryLocalServiceUtil;
import com.kisti.science.platform.app.service.AppTestHistoryServiceUtil;
import com.kisti.science.platform.app.service.ClpSerializer;
import com.kisti.science.platform.app.service.CommonLibraryLocalServiceUtil;
import com.kisti.science.platform.app.service.CommonLibraryServiceUtil;
import com.kisti.science.platform.app.service.CommonModuleServiceUtil;
import com.kisti.science.platform.app.service.CommonPackageLocalServiceUtil;
import com.kisti.science.platform.app.service.CommonPackageServiceUtil;
import com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalServiceUtil;
import com.kisti.science.platform.app.service.PortTypeAnalyzerLinkServiceUtil;
import com.kisti.science.platform.app.service.PortTypeEditorLinkLocalServiceUtil;
import com.kisti.science.platform.app.service.PortTypeEditorLinkServiceUtil;
import com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalServiceUtil;
import com.kisti.science.platform.app.service.PortTypeInputdeckUserFormLocalServiceUtil;
import com.kisti.science.platform.app.service.PortTypeLocalServiceUtil;
import com.kisti.science.platform.app.service.PortTypeServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppCategoryLinkLocalServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppCategoryLinkServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppInputPortsLocalServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppManagerLocalServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppManagerServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppOutputPortsLocalServiceUtil;
import com.kisti.science.platform.app.service.ScienceAppServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Jerry H. Seo & Young Suh
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
			AppTestHistoryLocalServiceUtil.clearService();

			AppTestHistoryServiceUtil.clearService();
			CommonLibraryLocalServiceUtil.clearService();

			CommonLibraryServiceUtil.clearService();

			CommonModuleServiceUtil.clearService();
			CommonPackageLocalServiceUtil.clearService();

			CommonPackageServiceUtil.clearService();
			PortTypeLocalServiceUtil.clearService();

			PortTypeServiceUtil.clearService();
			PortTypeAnalyzerLinkLocalServiceUtil.clearService();

			PortTypeAnalyzerLinkServiceUtil.clearService();
			PortTypeEditorLinkLocalServiceUtil.clearService();

			PortTypeEditorLinkServiceUtil.clearService();
			PortTypeInputdeckFormLocalServiceUtil.clearService();

			PortTypeInputdeckUserFormLocalServiceUtil.clearService();

			ScienceAppLocalServiceUtil.clearService();

			ScienceAppServiceUtil.clearService();
			ScienceAppCategoryLinkLocalServiceUtil.clearService();

			ScienceAppCategoryLinkServiceUtil.clearService();
			ScienceAppInputPortsLocalServiceUtil.clearService();

			ScienceAppManagerLocalServiceUtil.clearService();

			ScienceAppManagerServiceUtil.clearService();
			ScienceAppOutputPortsLocalServiceUtil.clearService();
		}
	}
}