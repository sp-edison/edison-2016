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

import org.kisti.edison.virtuallaboratory.service.SurveyAnswerLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class SurveyAnswerLocalServiceClpInvoker {
	public SurveyAnswerLocalServiceClpInvoker() {
		_methodName0 = "addSurveyAnswer";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.SurveyAnswer"
			};

		_methodName1 = "createSurveyAnswer";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSurveyAnswer";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSurveyAnswer";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.SurveyAnswer"
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

		_methodName10 = "fetchSurveyAnswer";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getSurveyAnswer";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSurveyAnswers";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSurveyAnswersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSurveyAnswer";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.SurveyAnswer"
			};

		_methodName16 = "addSurveyQuestionSurveyAnswer";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addSurveyQuestionSurveyAnswer";

		_methodParameterTypes17 = new String[] {
				"long", "org.kisti.edison.virtuallaboratory.model.SurveyAnswer"
			};

		_methodName18 = "addSurveyQuestionSurveyAnswers";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addSurveyQuestionSurveyAnswers";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearSurveyQuestionSurveyAnswers";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteSurveyQuestionSurveyAnswer";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteSurveyQuestionSurveyAnswer";

		_methodParameterTypes22 = new String[] {
				"long", "org.kisti.edison.virtuallaboratory.model.SurveyAnswer"
			};

		_methodName23 = "deleteSurveyQuestionSurveyAnswers";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteSurveyQuestionSurveyAnswers";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getSurveyQuestionSurveyAnswers";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getSurveyQuestionSurveyAnswers";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getSurveyQuestionSurveyAnswers";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getSurveyQuestionSurveyAnswersCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasSurveyQuestionSurveyAnswer";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasSurveyQuestionSurveyAnswers";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setSurveyQuestionSurveyAnswers";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName102 = "getBeanIdentifier";

		_methodParameterTypes102 = new String[] {  };

		_methodName103 = "setBeanIdentifier";

		_methodParameterTypes103 = new String[] { "java.lang.String" };

		_methodName108 = "insertSurveyAnswer";

		_methodParameterTypes108 = new String[] { "java.util.Map" };

		_methodName109 = "getExcelResult";

		_methodParameterTypes109 = new String[] {
				"long", "long", "long", "long", "java.lang.String"
			};

		_methodName110 = "getCountAnswerResult";

		_methodParameterTypes110 = new String[] { "long", "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.addSurveyAnswer((org.kisti.edison.virtuallaboratory.model.SurveyAnswer)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.createSurveyAnswer(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.deleteSurveyAnswer(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.deleteSurveyAnswer((org.kisti.edison.virtuallaboratory.model.SurveyAnswer)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.fetchSurveyAnswer(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getSurveyAnswer(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getSurveyAnswers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getSurveyAnswersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.updateSurveyAnswer((org.kisti.edison.virtuallaboratory.model.SurveyAnswer)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.addSurveyQuestionSurveyAnswer(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.addSurveyQuestionSurveyAnswer(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.SurveyAnswer)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.addSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.addSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.clearSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.deleteSurveyQuestionSurveyAnswer(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.deleteSurveyQuestionSurveyAnswer(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.SurveyAnswer)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.deleteSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.deleteSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getSurveyQuestionSurveyAnswersCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.hasSurveyQuestionSurveyAnswer(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.hasSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.setSurveyQuestionSurveyAnswers(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			SurveyAnswerLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.insertSurveyAnswer((java.util.Map<java.lang.String, java.lang.String>)arguments[0]);
		}

		if (_methodName109.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes109, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getExcelResult(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return SurveyAnswerLocalServiceUtil.getCountAnswerResult(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
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
}