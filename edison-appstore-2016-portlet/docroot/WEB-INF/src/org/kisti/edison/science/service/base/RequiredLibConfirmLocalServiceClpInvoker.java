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

package org.kisti.edison.science.service.base;

import org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class RequiredLibConfirmLocalServiceClpInvoker {
	public RequiredLibConfirmLocalServiceClpInvoker() {
		_methodName0 = "addRequiredLibConfirm";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.science.model.RequiredLibConfirm"
			};

		_methodName1 = "createRequiredLibConfirm";

		_methodParameterTypes1 = new String[] {
				"org.kisti.edison.science.service.persistence.RequiredLibConfirmPK"
			};

		_methodName2 = "deleteRequiredLibConfirm";

		_methodParameterTypes2 = new String[] {
				"org.kisti.edison.science.service.persistence.RequiredLibConfirmPK"
			};

		_methodName3 = "deleteRequiredLibConfirm";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.science.model.RequiredLibConfirm"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchRequiredLibConfirm";

		_methodParameterTypes10 = new String[] {
				"org.kisti.edison.science.service.persistence.RequiredLibConfirmPK"
			};

		_methodName11 = "getRequiredLibConfirm";

		_methodParameterTypes11 = new String[] {
				"org.kisti.edison.science.service.persistence.RequiredLibConfirmPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getRequiredLibConfirms";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getRequiredLibConfirmsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateRequiredLibConfirm";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.science.model.RequiredLibConfirm"
			};

		_methodName152 = "getBeanIdentifier";

		_methodParameterTypes152 = new String[] {  };

		_methodName153 = "setBeanIdentifier";

		_methodParameterTypes153 = new String[] { "java.lang.String" };

		_methodName158 = "countByScienceAppId";

		_methodParameterTypes158 = new String[] { "long" };

		_methodName159 = "findByScienceAppId";

		_methodParameterTypes159 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName160 = "getCountRequiredConfirm";

		_methodParameterTypes160 = new String[] { "java.util.Map" };

		_methodName161 = "getRequiredLibConfirmList";

		_methodParameterTypes161 = new String[] { "java.util.Map", "int", "int" };

		_methodName162 = "getRequiredLibConfirmMap";

		_methodParameterTypes162 = new String[] { "java.util.Map" };

		_methodName163 = "getRequiredLibConfirmObject";

		_methodParameterTypes163 = new String[] { "java.util.Map" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.addRequiredLibConfirm((org.kisti.edison.science.model.RequiredLibConfirm)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.createRequiredLibConfirm((org.kisti.edison.science.service.persistence.RequiredLibConfirmPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.deleteRequiredLibConfirm((org.kisti.edison.science.service.persistence.RequiredLibConfirmPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.deleteRequiredLibConfirm((org.kisti.edison.science.model.RequiredLibConfirm)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.fetchRequiredLibConfirm((org.kisti.edison.science.service.persistence.RequiredLibConfirmPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirm((org.kisti.edison.science.service.persistence.RequiredLibConfirmPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirms(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.updateRequiredLibConfirm((org.kisti.edison.science.model.RequiredLibConfirm)arguments[0]);
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			RequiredLibConfirmLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.countByScienceAppId(((Long)arguments[0]).longValue());
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.findByScienceAppId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getCountRequiredConfirm((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmList((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmMap((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return RequiredLibConfirmLocalServiceUtil.getRequiredLibConfirmObject((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName152;
	private String[] _methodParameterTypes152;
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName159;
	private String[] _methodParameterTypes159;
	private String _methodName160;
	private String[] _methodParameterTypes160;
	private String _methodName161;
	private String[] _methodParameterTypes161;
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
}