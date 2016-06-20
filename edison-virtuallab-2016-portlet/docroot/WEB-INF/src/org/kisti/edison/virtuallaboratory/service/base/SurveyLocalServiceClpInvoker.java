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

import org.kisti.edison.virtuallaboratory.service.SurveyLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class SurveyLocalServiceClpInvoker {
	public SurveyLocalServiceClpInvoker() {
		_methodName0 = "addSurvey";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.Survey"
			};

		_methodName1 = "createSurvey";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSurvey";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSurvey";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.Survey"
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

		_methodName10 = "fetchSurvey";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSurvey";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSurveies";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSurveiesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSurvey";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.Survey"
			};

		_methodName16 = "addVirtualLabSurvey";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addVirtualLabSurvey";

		_methodParameterTypes17 = new String[] {
				"long", "org.kisti.edison.virtuallaboratory.model.Survey"
			};

		_methodName18 = "addVirtualLabSurveies";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addVirtualLabSurveies";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearVirtualLabSurveies";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteVirtualLabSurvey";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteVirtualLabSurvey";

		_methodParameterTypes22 = new String[] {
				"long", "org.kisti.edison.virtuallaboratory.model.Survey"
			};

		_methodName23 = "deleteVirtualLabSurveies";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteVirtualLabSurveies";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getVirtualLabSurveies";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getVirtualLabSurveies";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getVirtualLabSurveies";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getVirtualLabSurveiesCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasVirtualLabSurvey";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasVirtualLabSurveies";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setVirtualLabSurveies";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName32 = "addSurveyQuestionSurvey";

		_methodParameterTypes32 = new String[] { "long", "long" };

		_methodName33 = "addSurveyQuestionSurvey";

		_methodParameterTypes33 = new String[] {
				"long", "org.kisti.edison.virtuallaboratory.model.Survey"
			};

		_methodName34 = "addSurveyQuestionSurveies";

		_methodParameterTypes34 = new String[] { "long", "long[][]" };

		_methodName35 = "addSurveyQuestionSurveies";

		_methodParameterTypes35 = new String[] { "long", "java.util.List" };

		_methodName36 = "clearSurveyQuestionSurveies";

		_methodParameterTypes36 = new String[] { "long" };

		_methodName37 = "deleteSurveyQuestionSurvey";

		_methodParameterTypes37 = new String[] { "long", "long" };

		_methodName38 = "deleteSurveyQuestionSurvey";

		_methodParameterTypes38 = new String[] {
				"long", "org.kisti.edison.virtuallaboratory.model.Survey"
			};

		_methodName39 = "deleteSurveyQuestionSurveies";

		_methodParameterTypes39 = new String[] { "long", "long[][]" };

		_methodName40 = "deleteSurveyQuestionSurveies";

		_methodParameterTypes40 = new String[] { "long", "java.util.List" };

		_methodName41 = "getSurveyQuestionSurveies";

		_methodParameterTypes41 = new String[] { "long" };

		_methodName42 = "getSurveyQuestionSurveies";

		_methodParameterTypes42 = new String[] { "long", "int", "int" };

		_methodName43 = "getSurveyQuestionSurveies";

		_methodParameterTypes43 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName44 = "getSurveyQuestionSurveiesCount";

		_methodParameterTypes44 = new String[] { "long" };

		_methodName45 = "hasSurveyQuestionSurvey";

		_methodParameterTypes45 = new String[] { "long", "long" };

		_methodName46 = "hasSurveyQuestionSurveies";

		_methodParameterTypes46 = new String[] { "long" };

		_methodName47 = "setSurveyQuestionSurveies";

		_methodParameterTypes47 = new String[] { "long", "long[][]" };

		_methodName118 = "getBeanIdentifier";

		_methodParameterTypes118 = new String[] {  };

		_methodName119 = "setBeanIdentifier";

		_methodParameterTypes119 = new String[] { "java.lang.String" };

		_methodName124 = "getListSurvey";

		_methodParameterTypes124 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName125 = "getListSurveyAll";

		_methodParameterTypes125 = new String[] { "java.util.Locale" };

		_methodName126 = "getCountSurvey";

		_methodParameterTypes126 = new String[] {  };

		_methodName127 = "isExistsUseDate";

		_methodParameterTypes127 = new String[] {
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName128 = "insertSurvey";

		_methodParameterTypes128 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName129 = "getSurveyInfomation";

		_methodParameterTypes129 = new String[] { "long", "java.util.Locale" };

		_methodName130 = "getSurveyMappingCheckList";

		_methodParameterTypes130 = new String[] {
				"long", "boolean", "java.util.Locale"
			};

		_methodName131 = "getSurveyMappingList";

		_methodParameterTypes131 = new String[] {
				"long", "boolean", "java.util.Locale"
			};

		_methodName132 = "getSurveyMappingVoteList";

		_methodParameterTypes132 = new String[] {
				"long", "long", "long", "boolean", "java.util.Locale"
			};

		_methodName133 = "getSurveyResultList";

		_methodParameterTypes133 = new String[] {
				"long", "long", "java.lang.String", "int", "int",
				"java.util.Locale"
			};

		_methodName134 = "getCountSurveyResultList";

		_methodParameterTypes134 = new String[] {
				"long", "long", "java.lang.String", "java.util.Locale"
			};

		_methodName135 = "getCountSurveyCheck";

		_methodParameterTypes135 = new String[] { "long", "long", "long" };

		_methodName136 = "deleteVirtualLabSurvey";

		_methodParameterTypes136 = new String[] { "long" };

		_methodName137 = "getMaxQuestionSeq";

		_methodParameterTypes137 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SurveyLocalServiceUtil.addSurvey((org.kisti.edison.virtuallaboratory.model.Survey)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SurveyLocalServiceUtil.createSurvey(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SurveyLocalServiceUtil.deleteSurvey(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SurveyLocalServiceUtil.deleteSurvey((org.kisti.edison.virtuallaboratory.model.Survey)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SurveyLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SurveyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SurveyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SurveyLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SurveyLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SurveyLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SurveyLocalServiceUtil.fetchSurvey(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurvey(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SurveyLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveies(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveiesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SurveyLocalServiceUtil.updateSurvey((org.kisti.edison.virtuallaboratory.model.Survey)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			SurveyLocalServiceUtil.addVirtualLabSurvey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SurveyLocalServiceUtil.addVirtualLabSurvey(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.Survey)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			SurveyLocalServiceUtil.addVirtualLabSurveies(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			SurveyLocalServiceUtil.addVirtualLabSurveies(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.Survey>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			SurveyLocalServiceUtil.clearVirtualLabSurveies(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			SurveyLocalServiceUtil.deleteVirtualLabSurvey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			SurveyLocalServiceUtil.deleteVirtualLabSurvey(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.Survey)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			SurveyLocalServiceUtil.deleteVirtualLabSurveies(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			SurveyLocalServiceUtil.deleteVirtualLabSurveies(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.Survey>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SurveyLocalServiceUtil.getVirtualLabSurveies(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SurveyLocalServiceUtil.getVirtualLabSurveies(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SurveyLocalServiceUtil.getVirtualLabSurveies(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SurveyLocalServiceUtil.getVirtualLabSurveiesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SurveyLocalServiceUtil.hasVirtualLabSurvey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SurveyLocalServiceUtil.hasVirtualLabSurveies(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			SurveyLocalServiceUtil.setVirtualLabSurveies(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			SurveyLocalServiceUtil.addSurveyQuestionSurvey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			SurveyLocalServiceUtil.addSurveyQuestionSurvey(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.Survey)arguments[1]);

			return null;
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			SurveyLocalServiceUtil.addSurveyQuestionSurveies(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			SurveyLocalServiceUtil.addSurveyQuestionSurveies(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.Survey>)arguments[1]);

			return null;
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			SurveyLocalServiceUtil.clearSurveyQuestionSurveies(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			SurveyLocalServiceUtil.deleteSurveyQuestionSurvey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			SurveyLocalServiceUtil.deleteSurveyQuestionSurvey(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.Survey)arguments[1]);

			return null;
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			SurveyLocalServiceUtil.deleteSurveyQuestionSurveies(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			SurveyLocalServiceUtil.deleteSurveyQuestionSurveies(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.Survey>)arguments[1]);

			return null;
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyQuestionSurveies(((Long)arguments[0]).longValue());
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyQuestionSurveies(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyQuestionSurveies(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyQuestionSurveiesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return SurveyLocalServiceUtil.hasSurveyQuestionSurvey(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return SurveyLocalServiceUtil.hasSurveyQuestionSurveies(((Long)arguments[0]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			SurveyLocalServiceUtil.setSurveyQuestionSurveies(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return SurveyLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			SurveyLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return SurveyLocalServiceUtil.getListSurvey((java.util.Map<java.lang.String, java.lang.String>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return SurveyLocalServiceUtil.getListSurveyAll((java.util.Locale)arguments[0]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return SurveyLocalServiceUtil.getCountSurvey();
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return SurveyLocalServiceUtil.isExistsUseDate((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return SurveyLocalServiceUtil.insertSurvey((java.util.Map<java.lang.String, java.lang.String>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyInfomation(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyMappingCheckList(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.util.Locale)arguments[2]);
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyMappingList(((Long)arguments[0]).longValue(),
				((Boolean)arguments[1]).booleanValue(),
				(java.util.Locale)arguments[2]);
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyMappingVoteList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue(),
				(java.util.Locale)arguments[4]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return SurveyLocalServiceUtil.getSurveyResultList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue(),
				(java.util.Locale)arguments[5]);
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return SurveyLocalServiceUtil.getCountSurveyResultList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.util.Locale)arguments[3]);
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return SurveyLocalServiceUtil.getCountSurveyCheck(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			SurveyLocalServiceUtil.deleteVirtualLabSurvey(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return SurveyLocalServiceUtil.getMaxQuestionSeq(((Long)arguments[0]).longValue());
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
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
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
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName129;
	private String[] _methodParameterTypes129;
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
}