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

package org.kisti.edison.customauthmanager.service.base;

import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class UserGroupRoleCustomLocalServiceClpInvoker {
	public UserGroupRoleCustomLocalServiceClpInvoker() {
		_methodName0 = "addUserGroupRoleCustom";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.customauthmanager.model.UserGroupRoleCustom"
			};

		_methodName1 = "createUserGroupRoleCustom";

		_methodParameterTypes1 = new String[] {
				"org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK"
			};

		_methodName2 = "deleteUserGroupRoleCustom";

		_methodParameterTypes2 = new String[] {
				"org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK"
			};

		_methodName3 = "deleteUserGroupRoleCustom";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.customauthmanager.model.UserGroupRoleCustom"
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

		_methodName10 = "fetchUserGroupRoleCustom";

		_methodParameterTypes10 = new String[] {
				"org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK"
			};

		_methodName11 = "getUserGroupRoleCustom";

		_methodParameterTypes11 = new String[] {
				"org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getUserGroupRoleCustoms";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getUserGroupRoleCustomsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateUserGroupRoleCustom";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.customauthmanager.model.UserGroupRoleCustom"
			};

		_methodName36 = "getBeanIdentifier";

		_methodParameterTypes36 = new String[] {  };

		_methodName37 = "setBeanIdentifier";

		_methodParameterTypes37 = new String[] { "java.lang.String" };

		_methodName42 = "isRoleCustom";

		_methodParameterTypes42 = new String[] { "long", "long", "long", "long" };

		_methodName43 = "getUserGroupRoleCustom";

		_methodParameterTypes43 = new String[] { "long", "long", "long", "long" };

		_methodName44 = "addUserGroupRoleCustom";

		_methodParameterTypes44 = new String[] { "long", "long", "long", "long" };

		_methodName45 = "removeUserGroupRoleCustom";

		_methodParameterTypes45 = new String[] { "long", "long", "long", "long" };

		_methodName46 = "getUserCustomList";

		_methodParameterTypes46 = new String[] { "long", "long" };

		_methodName47 = "getCustomList";

		_methodParameterTypes47 = new String[] { "long", "long", "long" };

		_methodName48 = "getCustomIdList";

		_methodParameterTypes48 = new String[] { "long", "long", "long" };

		_methodName49 = "getUserList";

		_methodParameterTypes49 = new String[] { "long", "long", "long" };

		_methodName50 = "getUserIdList";

		_methodParameterTypes50 = new String[] { "long", "long", "long" };

		_methodName51 = "checkRoleVirtualLabClass";

		_methodParameterTypes51 = new String[] {
				"long", "long", "long", "long", "long"
			};

		_methodName52 = "isAdminRoleSolver";

		_methodParameterTypes52 = new String[] { "long", "long", "long", "long" };

		_methodName53 = "isAdminRoleVirtualLabClass";

		_methodParameterTypes53 = new String[] { "long", "long", "long", "long" };

		_methodName54 = "getSiteLeaveOwnerTotalCnt";

		_methodParameterTypes54 = new String[] { "long", "long", "long", "long" };

		_methodName55 = "getContentOwnerList";

		_methodParameterTypes55 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName56 = "getVirtualLabOwnerList";

		_methodParameterTypes56 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName57 = "getVirtaulClassOwnerList";

		_methodParameterTypes57 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName58 = "deleteUserGroupRoleCustomManager";

		_methodParameterTypes58 = new String[] { "long", "long", "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom((org.kisti.edison.customauthmanager.model.UserGroupRoleCustom)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.createUserGroupRoleCustom((org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.deleteUserGroupRoleCustom((org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.deleteUserGroupRoleCustom((org.kisti.edison.customauthmanager.model.UserGroupRoleCustom)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.fetchUserGroupRoleCustom((org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getUserGroupRoleCustom((org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getUserGroupRoleCustoms(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getUserGroupRoleCustomsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.updateUserGroupRoleCustom((org.kisti.edison.customauthmanager.model.UserGroupRoleCustom)arguments[0]);
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			UserGroupRoleCustomLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.isRoleCustom(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getUserGroupRoleCustom(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getUserCustomList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getCustomList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getCustomIdList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getUserList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getUserIdList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.checkRoleVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.isAdminRoleSolver(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.isAdminRoleVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getSiteLeaveOwnerTotalCnt(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getContentOwnerList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getVirtualLabOwnerList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.getVirtaulClassOwnerList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return UserGroupRoleCustomLocalServiceUtil.deleteUserGroupRoleCustomManager(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
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
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
}