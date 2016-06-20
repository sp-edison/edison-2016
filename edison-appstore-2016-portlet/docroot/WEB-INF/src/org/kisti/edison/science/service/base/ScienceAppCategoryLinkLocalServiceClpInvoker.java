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

import org.kisti.edison.science.service.ScienceAppCategoryLinkLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class ScienceAppCategoryLinkLocalServiceClpInvoker {
	public ScienceAppCategoryLinkLocalServiceClpInvoker() {
		_methodName0 = "addScienceAppCategoryLink";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.science.model.ScienceAppCategoryLink"
			};

		_methodName1 = "createScienceAppCategoryLink";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteScienceAppCategoryLink";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteScienceAppCategoryLink";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.science.model.ScienceAppCategoryLink"
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

		_methodName10 = "fetchScienceAppCategoryLink";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchScienceAppCategoryLinkByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchScienceAppCategoryLinkByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getScienceAppCategoryLink";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getScienceAppCategoryLinkByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getScienceAppCategoryLinkByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getScienceAppCategoryLinks";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getScienceAppCategoryLinksCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateScienceAppCategoryLink";

		_methodParameterTypes19 = new String[] {
				"org.kisti.edison.science.model.ScienceAppCategoryLink"
			};

		_methodName156 = "getBeanIdentifier";

		_methodParameterTypes156 = new String[] {  };

		_methodName157 = "setBeanIdentifier";

		_methodParameterTypes157 = new String[] { "java.lang.String" };

		_methodName162 = "addScienceAppCategory";

		_methodParameterTypes162 = new String[] { "long", "long" };

		_methodName163 = "removeByCategoryId";

		_methodParameterTypes163 = new String[] { "long" };

		_methodName164 = "removeByScienceAppId";

		_methodParameterTypes164 = new String[] { "long" };

		_methodName165 = "update";

		_methodParameterTypes165 = new String[] {
				"org.kisti.edison.science.model.ScienceAppCategoryLink"
			};

		_methodName166 = "getScienceAppIdsByCategoryId";

		_methodParameterTypes166 = new String[] { "long" };

		_methodName167 = "getScienceAppIdsByCategoryId";

		_methodParameterTypes167 = new String[] { "long", "int", "int" };

		_methodName168 = "countScienceAppsByCategoryId";

		_methodParameterTypes168 = new String[] { "long" };

		_methodName169 = "getCategoryIdsByScienceAppId";

		_methodParameterTypes169 = new String[] { "long" };

		_methodName170 = "getCategoryIdsByScienceAppId";

		_methodParameterTypes170 = new String[] { "long", "int", "int" };

		_methodName171 = "countCategoriesByScienceAppId";

		_methodParameterTypes171 = new String[] { "long" };

		_methodName172 = "getScienceAppCategorysByscienceAppId";

		_methodParameterTypes172 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.addScienceAppCategoryLink((org.kisti.edison.science.model.ScienceAppCategoryLink)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.createScienceAppCategoryLink(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.deleteScienceAppCategoryLink(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.deleteScienceAppCategoryLink((org.kisti.edison.science.model.ScienceAppCategoryLink)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.fetchScienceAppCategoryLink(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.fetchScienceAppCategoryLinkByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.fetchScienceAppCategoryLinkByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategoryLink(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategoryLinkByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategoryLinkByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategoryLinks(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategoryLinksCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.updateScienceAppCategoryLink((org.kisti.edison.science.model.ScienceAppCategoryLink)arguments[0]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			ScienceAppCategoryLinkLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.addScienceAppCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			ScienceAppCategoryLinkLocalServiceUtil.removeByCategoryId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			ScienceAppCategoryLinkLocalServiceUtil.removeByScienceAppId(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			ScienceAppCategoryLinkLocalServiceUtil.update((org.kisti.edison.science.model.ScienceAppCategoryLink)arguments[0]);

			return null;
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppIdsByCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppIdsByCategoryId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.countScienceAppsByCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getCategoryIdsByScienceAppId(((Long)arguments[0]).longValue());
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getCategoryIdsByScienceAppId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.countCategoriesByScienceAppId(((Long)arguments[0]).longValue());
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ScienceAppCategoryLinkLocalServiceUtil.getScienceAppCategorysByscienceAppId(((Long)arguments[0]).longValue());
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
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName157;
	private String[] _methodParameterTypes157;
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName164;
	private String[] _methodParameterTypes164;
	private String _methodName165;
	private String[] _methodParameterTypes165;
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
	private String _methodName172;
	private String[] _methodParameterTypes172;
}