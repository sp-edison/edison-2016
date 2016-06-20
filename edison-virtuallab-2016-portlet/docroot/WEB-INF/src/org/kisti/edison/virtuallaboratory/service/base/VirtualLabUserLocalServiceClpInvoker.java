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

import org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class VirtualLabUserLocalServiceClpInvoker {
	public VirtualLabUserLocalServiceClpInvoker() {
		_methodName0 = "addVirtualLabUser";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabUser"
			};

		_methodName1 = "createVirtualLabUser";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVirtualLabUser";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVirtualLabUser";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabUser"
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

		_methodName10 = "fetchVirtualLabUser";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getVirtualLabUser";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getVirtualLabUsers";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getVirtualLabUsersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateVirtualLabUser";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabUser"
			};

		_methodName16 = "addVirtualLabClassVirtualLabUser";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addVirtualLabClassVirtualLabUser";

		_methodParameterTypes17 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabUser"
			};

		_methodName18 = "addVirtualLabClassVirtualLabUsers";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addVirtualLabClassVirtualLabUsers";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearVirtualLabClassVirtualLabUsers";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteVirtualLabClassVirtualLabUser";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteVirtualLabClassVirtualLabUser";

		_methodParameterTypes22 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabUser"
			};

		_methodName23 = "deleteVirtualLabClassVirtualLabUsers";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteVirtualLabClassVirtualLabUsers";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getVirtualLabClassVirtualLabUsers";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getVirtualLabClassVirtualLabUsers";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getVirtualLabClassVirtualLabUsers";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getVirtualLabClassVirtualLabUsersCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasVirtualLabClassVirtualLabUser";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasVirtualLabClassVirtualLabUsers";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setVirtualLabClassVirtualLabUsers";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName102 = "getBeanIdentifier";

		_methodParameterTypes102 = new String[] {  };

		_methodName103 = "setBeanIdentifier";

		_methodParameterTypes103 = new String[] { "java.lang.String" };

		_methodName108 = "addVirtualLabUser";

		_methodParameterTypes108 = new String[] { "long", "long" };

		_methodName109 = "addTempUser";

		_methodParameterTypes109 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName110 = "getVirtualClassStudentList";

		_methodParameterTypes110 = new String[] {
				"long", "long", "long", "java.lang.String", "long"
			};

		_methodName111 = "updateVirtualLabUser";

		_methodParameterTypes111 = new String[] { "long", "java.lang.String" };

		_methodName112 = "updateVirtualLabUserProcessNote";

		_methodParameterTypes112 = new String[] { "java.util.Map" };

		_methodName113 = "removeVirtualLabUser";

		_methodParameterTypes113 = new String[] { "long", "long" };

		_methodName114 = "getCountVirtualClassRegisterUserList";

		_methodParameterTypes114 = new String[] { "long" };

		_methodName115 = "getVirtualLabUserInfo";

		_methodParameterTypes115 = new String[] { "long", "long" };

		_methodName116 = "getStudentCount";

		_methodParameterTypes116 = new String[] { "long", "long" };

		_methodName117 = "getUserGroupClassUser";

		_methodParameterTypes117 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.addVirtualLabUser((org.kisti.edison.virtuallaboratory.model.VirtualLabUser)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.createVirtualLabUser(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.deleteVirtualLabUser(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.deleteVirtualLabUser((org.kisti.edison.virtuallaboratory.model.VirtualLabUser)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.fetchVirtualLabUser(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabUser(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabUsers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabUsersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.updateVirtualLabUser((org.kisti.edison.virtuallaboratory.model.VirtualLabUser)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.addVirtualLabClassVirtualLabUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.addVirtualLabClassVirtualLabUser(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabUser)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.addVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.addVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.clearVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.deleteVirtualLabClassVirtualLabUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.deleteVirtualLabClassVirtualLabUser(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabUser)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.deleteVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.deleteVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabClassVirtualLabUsersCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.hasVirtualLabClassVirtualLabUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.hasVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.setVirtualLabClassVirtualLabUsers(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.addVirtualLabUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.addTempUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualClassStudentList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.updateVirtualLabUser(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName112.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes112, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.updateVirtualLabUserProcessNote((java.util.Map)arguments[0]);
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			VirtualLabUserLocalServiceUtil.removeVirtualLabUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getCountVirtualClassRegisterUserList(((Long)arguments[0]).longValue());
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getVirtualLabUserInfo(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getStudentCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return VirtualLabUserLocalServiceUtil.getUserGroupClassUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
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
	private String _methodName112;
	private String[] _methodParameterTypes112;
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
}