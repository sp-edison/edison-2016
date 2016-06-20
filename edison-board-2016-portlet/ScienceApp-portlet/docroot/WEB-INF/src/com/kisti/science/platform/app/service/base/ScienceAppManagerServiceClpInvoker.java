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

package com.kisti.science.platform.app.service.base;

import com.kisti.science.platform.app.service.ScienceAppManagerServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class ScienceAppManagerServiceClpInvoker {
	public ScienceAppManagerServiceClpInvoker() {
		_methodName86 = "getBeanIdentifier";

		_methodParameterTypes86 = new String[] {  };

		_methodName87 = "setBeanIdentifier";

		_methodParameterTypes87 = new String[] { "java.lang.String" };

		_methodName92 = "addScienceAppManager";

		_methodParameterTypes92 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName93 = "removeSicenceAppManager";

		_methodParameterTypes93 = new String[] { "long" };

		_methodName94 = "removeScienceAppManagerByManagerId";

		_methodParameterTypes94 = new String[] { "long" };

		_methodName95 = "removeScienceAppManagerByScienceAppId";

		_methodParameterTypes95 = new String[] { "long" };

		_methodName96 = "updateScienceAppManager";

		_methodParameterTypes96 = new String[] {
				"com.kisti.science.platform.app.model.ScienceAppManager"
			};

		_methodName97 = "getScienceAppIdsByManagerId";

		_methodParameterTypes97 = new String[] { "long" };

		_methodName98 = "getManagetIdsByScienceAppId";

		_methodParameterTypes98 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return ScienceAppManagerServiceUtil.getBeanIdentifier();
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			ScienceAppManagerServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return ScienceAppManagerServiceUtil.addScienceAppManager(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			ScienceAppManagerServiceUtil.removeSicenceAppManager(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			ScienceAppManagerServiceUtil.removeScienceAppManagerByManagerId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			ScienceAppManagerServiceUtil.removeScienceAppManagerByScienceAppId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			ScienceAppManagerServiceUtil.updateScienceAppManager((com.kisti.science.platform.app.model.ScienceAppManager)arguments[0]);

			return null;
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return ScienceAppManagerServiceUtil.getScienceAppIdsByManagerId(((Long)arguments[0]).longValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return ScienceAppManagerServiceUtil.getManagetIdsByScienceAppId(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
}