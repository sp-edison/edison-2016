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

package org.kisti.edison.virtuallaboratory.service.base;

import org.kisti.edison.virtuallaboratory.service.VirtualLabClassScienceAppLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class VirtualLabClassScienceAppLocalServiceClpInvoker {
	public VirtualLabClassScienceAppLocalServiceClpInvoker() {
		_methodName0 = "addVirtualLabClassScienceApp";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp"
			};

		_methodName1 = "createVirtualLabClassScienceApp";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVirtualLabClassScienceApp";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVirtualLabClassScienceApp";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp"
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

		_methodName10 = "fetchVirtualLabClassScienceApp";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getVirtualLabClassScienceApp";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getVirtualLabClassScienceApps";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getVirtualLabClassScienceAppsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateVirtualLabClassScienceApp";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp"
			};

		_methodName16 = "addVirtualLabClassVirtualLabClassScienceApp";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addVirtualLabClassVirtualLabClassScienceApp";

		_methodParameterTypes17 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp"
			};

		_methodName18 = "addVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteVirtualLabClassVirtualLabClassScienceApp";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteVirtualLabClassVirtualLabClassScienceApp";

		_methodParameterTypes22 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp"
			};

		_methodName23 = "deleteVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getVirtualLabClassVirtualLabClassScienceAppsCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasVirtualLabClassVirtualLabClassScienceApp";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setVirtualLabClassVirtualLabClassScienceApps";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName102 = "getBeanIdentifier";

		_methodParameterTypes102 = new String[] {  };

		_methodName103 = "setBeanIdentifier";

		_methodParameterTypes103 = new String[] { "java.lang.String" };

		_methodName108 = "getVirtualLabClassScienceAppList";

		_methodParameterTypes108 = new String[] {
				"long", "long", "long", "java.util.Locale"
			};

		_methodName109 = "getScienceAppList";

		_methodParameterTypes109 = new String[] {
				"long", "long", "long", "java.lang.String", "java.util.Locale"
			};

		_methodName110 = "insertVirtualLabClassScienceApp";

		_methodParameterTypes110 = new String[] { "long", "long" };

		_methodName111 = "insertVirtualLabClassScienceAppList";

		_methodParameterTypes111 = new String[] {
				"long", "long", "long", "java.lang.Object", "java.util.Locale"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.addVirtualLabClassScienceApp((org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.createVirtualLabClassScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.deleteVirtualLabClassScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.deleteVirtualLabClassScienceApp((org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.fetchVirtualLabClassScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassScienceApps(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassScienceAppsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.updateVirtualLabClassScienceApp((org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.addVirtualLabClassVirtualLabClassScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.addVirtualLabClassVirtualLabClassScienceApp(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.addVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.addVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.clearVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.deleteVirtualLabClassVirtualLabClassScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.deleteVirtualLabClassVirtualLabClassScienceApp(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.deleteVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.deleteVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassVirtualLabClassScienceAppsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.hasVirtualLabClassVirtualLabClassScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.hasVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.setVirtualLabClassVirtualLabClassScienceApps(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getVirtualLabClassScienceAppList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.util.Locale)arguments[3]);
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return VirtualLabClassScienceAppLocalServiceUtil.getScienceAppList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Locale)arguments[4]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.insertVirtualLabClassScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			VirtualLabClassScienceAppLocalServiceUtil.insertVirtualLabClassScienceAppList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.Object)arguments[3], (java.util.Locale)arguments[4]);

			return null;
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName108;
	private String[] _methodParameterTypes108;
	private String _methodName109;
	private String[] _methodParameterTypes109;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
}