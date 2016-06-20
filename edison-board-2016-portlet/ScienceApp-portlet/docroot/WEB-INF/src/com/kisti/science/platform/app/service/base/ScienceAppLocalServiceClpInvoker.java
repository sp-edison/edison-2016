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

import com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class ScienceAppLocalServiceClpInvoker {
	public ScienceAppLocalServiceClpInvoker() {
		_methodName0 = "addScienceApp";

		_methodParameterTypes0 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp"
			};

		_methodName1 = "createScienceApp";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteScienceApp";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteScienceApp";

		_methodParameterTypes3 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp"
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

		_methodName10 = "fetchScienceApp";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "fetchScienceAppByUuidAndCompanyId";

		_methodParameterTypes11 = new String[] { "java.lang.String", "long" };

		_methodName12 = "fetchScienceAppByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getScienceApp";

		_methodParameterTypes13 = new String[] { "long" };

		_methodName14 = "getPersistedModel";

		_methodParameterTypes14 = new String[] { "java.io.Serializable" };

		_methodName15 = "getScienceAppByUuidAndCompanyId";

		_methodParameterTypes15 = new String[] { "java.lang.String", "long" };

		_methodName16 = "getScienceAppByUuidAndGroupId";

		_methodParameterTypes16 = new String[] { "java.lang.String", "long" };

		_methodName17 = "getScienceApps";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getScienceAppsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateScienceApp";

		_methodParameterTypes19 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp"
			};

		_methodName116 = "getBeanIdentifier";

		_methodParameterTypes116 = new String[] {  };

		_methodName117 = "setBeanIdentifier";

		_methodParameterTypes117 = new String[] { "java.lang.String" };

		_methodName122 = "createScienceApp";

		_methodParameterTypes122 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName123 = "copyScienceApp";

		_methodParameterTypes123 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName124 = "addScienceApp";

		_methodParameterTypes124 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName125 = "setScienceAppInputPorts";

		_methodParameterTypes125 = new String[] { "long", "java.lang.String" };

		_methodName126 = "getScienceAppInputPorts";

		_methodParameterTypes126 = new String[] { "long" };

		_methodName127 = "setScienceAppOutputPorts";

		_methodParameterTypes127 = new String[] { "long", "java.lang.String" };

		_methodName128 = "getScienceAppOutputPorts";

		_methodParameterTypes128 = new String[] { "long" };

		_methodName129 = "verifyScienceAppName";

		_methodParameterTypes129 = new String[] { "java.lang.String" };

		_methodName130 = "existAppName";

		_methodParameterTypes130 = new String[] { "java.lang.String" };

		_methodName131 = "existApp";

		_methodParameterTypes131 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName132 = "getLatestVersion";

		_methodParameterTypes132 = new String[] { "java.lang.String" };

		_methodName133 = "verifyVersionNumber";

		_methodParameterTypes133 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName134 = "deleteScienceApp";

		_methodParameterTypes134 = new String[] { "long" };

		_methodName135 = "deleteScienceApp";

		_methodParameterTypes135 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp"
			};

		_methodName136 = "deleteAllScienceApps";

		_methodParameterTypes136 = new String[] {  };

		_methodName137 = "updateScienceApp";

		_methodParameterTypes137 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName138 = "getAll";

		_methodParameterTypes138 = new String[] {  };

		_methodName139 = "countAll";

		_methodParameterTypes139 = new String[] {  };

		_methodName140 = "getAll";

		_methodParameterTypes140 = new String[] { "java.lang.String" };

		_methodName141 = "countAll";

		_methodParameterTypes141 = new String[] { "java.lang.String" };

		_methodName142 = "getAll";

		_methodParameterTypes142 = new String[] { "int", "int" };

		_methodName143 = "getAll";

		_methodParameterTypes143 = new String[] { "int", "int", "java.lang.String" };

		_methodName144 = "getScienceAppListByStatus";

		_methodParameterTypes144 = new String[] { "int" };

		_methodName145 = "countScienceAppsByStatus";

		_methodParameterTypes145 = new String[] { "int" };

		_methodName146 = "getScienceAppListByStage";

		_methodParameterTypes146 = new String[] { "java.lang.String" };

		_methodName147 = "countScienceAppsByStage";

		_methodParameterTypes147 = new String[] { "java.lang.String" };

		_methodName148 = "getScienceAppListByStage";

		_methodParameterTypes148 = new String[] { "java.lang.String", "int", "int" };

		_methodName149 = "getScienceAppListByAuthorIdAppType";

		_methodParameterTypes149 = new String[] { "long", "java.lang.String" };

		_methodName150 = "getScienceAppListByAppType";

		_methodParameterTypes150 = new String[] { "java.lang.String" };

		_methodName151 = "getScienceAppListByAppType";

		_methodParameterTypes151 = new String[] { "java.lang.String", "int", "int" };

		_methodName152 = "getScienceAppListByAppType";

		_methodParameterTypes152 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName153 = "getScienceAppListByAppType";

		_methodParameterTypes153 = new String[] {
				"java.lang.String", "int", "int", "java.lang.String"
			};

		_methodName154 = "countScienceAppsByAppType";

		_methodParameterTypes154 = new String[] { "java.lang.String" };

		_methodName155 = "countScienceAppsByAppType";

		_methodParameterTypes155 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName156 = "getScienceAppListByAuthorIdAppType";

		_methodParameterTypes156 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName157 = "getScienceAppListByAuthorId";

		_methodParameterTypes157 = new String[] { "long" };

		_methodName158 = "getScienceAppListByAuthorId";

		_methodParameterTypes158 = new String[] { "long", "int", "int" };

		_methodName159 = "countScienceAppsByAuthorId";

		_methodParameterTypes159 = new String[] { "long" };

		_methodName160 = "getScienceAppListByOpenLevel";

		_methodParameterTypes160 = new String[] { "java.lang.String" };

		_methodName161 = "getScienceAppListByOpenLevel";

		_methodParameterTypes161 = new String[] { "java.lang.String", "int", "int" };

		_methodName162 = "getScienceAppListByManagerId";

		_methodParameterTypes162 = new String[] { "long" };

		_methodName163 = "getScienceAppListByManagerId";

		_methodParameterTypes163 = new String[] { "long", "int", "int" };

		_methodName164 = "countScienceAppsByManagerId";

		_methodParameterTypes164 = new String[] { "long" };

		_methodName165 = "getScienceAppManagerIds";

		_methodParameterTypes165 = new String[] { "long" };

		_methodName166 = "getScienceAppManagerIds";

		_methodParameterTypes166 = new String[] { "long", "int", "int" };

		_methodName167 = "countScienceAppManagers";

		_methodParameterTypes167 = new String[] { "long" };

		_methodName168 = "getScienceAppListByCategoryId";

		_methodParameterTypes168 = new String[] { "long" };

		_methodName169 = "getScienceAppListByCategoryId";

		_methodParameterTypes169 = new String[] { "long", "int", "int" };

		_methodName170 = "getScienceAppCategoryIds";

		_methodParameterTypes170 = new String[] { "long" };

		_methodName171 = "getScienceAppCategoryIds";

		_methodParameterTypes171 = new String[] { "long", "int", "int" };

		_methodName172 = "countScienceAppCategories";

		_methodParameterTypes172 = new String[] { "long" };

		_methodName173 = "assignScienceAppToCategories";

		_methodParameterTypes173 = new String[] { "long", "long[][]" };

		_methodName174 = "assignScienceAppToCategory";

		_methodParameterTypes174 = new String[] { "long", "long" };

		_methodName175 = "assignManagersToScienceApp";

		_methodParameterTypes175 = new String[] { "long", "long[][]" };

		_methodName176 = "assignManagerToScienceApp";

		_methodParameterTypes176 = new String[] { "long", "long" };

		_methodName177 = "getScienceAppBinPath";

		_methodParameterTypes177 = new String[] { "long" };

		_methodName178 = "getScienceAppSrcPath";

		_methodParameterTypes178 = new String[] { "long" };

		_methodName179 = "countAllScienceApps";

		_methodParameterTypes179 = new String[] {  };

		_methodName180 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes180 = new String[] { "java.lang.String", "int", "int" };

		_methodName181 = "countScienceAppsOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes181 = new String[] { "java.lang.String" };

		_methodName182 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes182 = new String[] { "java.lang.String" };

		_methodName183 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage";

		_methodParameterTypes183 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName184 = "countScienceAppsOnNameTitleScreenNameAffiliationNameByStage";

		_methodParameterTypes184 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName185 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage";

		_methodParameterTypes185 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName186 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget";

		_methodParameterTypes186 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName187 = "countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget";

		_methodParameterTypes187 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName188 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget";

		_methodParameterTypes188 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName189 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget";

		_methodParameterTypes189 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName190 = "countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget";

		_methodParameterTypes190 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName191 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget";

		_methodParameterTypes191 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName192 = "retrieveScienceAppsOnScreenName";

		_methodParameterTypes192 = new String[] { "java.lang.String", "int", "int" };

		_methodName193 = "countScienceAppsOnScreenName";

		_methodParameterTypes193 = new String[] { "java.lang.String" };

		_methodName194 = "retrieveScienceAppsOnScreenName";

		_methodParameterTypes194 = new String[] { "java.lang.String" };

		_methodName195 = "retrieveScienceAppsOnScreenNameByStage";

		_methodParameterTypes195 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName196 = "countScienceAppsOnScreenNameByStage";

		_methodParameterTypes196 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName197 = "retrieveScienceAppsOnScreenNameByStage";

		_methodParameterTypes197 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName198 = "retrieveScienceAppsOnScreenNameByTarget";

		_methodParameterTypes198 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName199 = "countScienceAppsOnScreenNameByTarget";

		_methodParameterTypes199 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName200 = "retrieveScienceAppsOnScreenNameByTarget";

		_methodParameterTypes200 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName201 = "retrieveScienceAppsOnScreenNameByStageTarget";

		_methodParameterTypes201 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName202 = "countScienceAppsOnScreenNameByStageTarget";

		_methodParameterTypes202 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName203 = "retrieveScienceAppsOnScreenNameByStageTarget";

		_methodParameterTypes203 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName204 = "retrieveScienceAppsOnAffiliationName";

		_methodParameterTypes204 = new String[] { "java.lang.String", "int", "int" };

		_methodName205 = "countScienceAppsOnAffiliationName";

		_methodParameterTypes205 = new String[] { "java.lang.String" };

		_methodName206 = "retrieveScienceAppsOnAffiliationName";

		_methodParameterTypes206 = new String[] { "java.lang.String" };

		_methodName207 = "retrieveScienceAppsOnAffiliationNameByStage";

		_methodParameterTypes207 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName208 = "countScienceAppsOnAffiliationNameByStage";

		_methodParameterTypes208 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName209 = "retrieveScienceAppsOnAffiliationNameByStage";

		_methodParameterTypes209 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName210 = "retrieveScienceAppsOnAffiliationNameByTarget";

		_methodParameterTypes210 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName211 = "countScienceAppsOnAffiliationNameByTarget";

		_methodParameterTypes211 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName212 = "retrieveScienceAppsOnAffiliationNameByTarget";

		_methodParameterTypes212 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName213 = "retrieveScienceAppsOnAffiliationNameByStageTarget";

		_methodParameterTypes213 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName214 = "countScienceAppsOnAffiliationNameByStageTarget";

		_methodParameterTypes214 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName215 = "retrieveScienceAppsOnAffiliationNameByStageTarget";

		_methodParameterTypes215 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName216 = "retrieveScienceAppsByVocabularyId";

		_methodParameterTypes216 = new String[] { "long", "int", "int" };

		_methodName217 = "countScienceAppsByVocabularyId";

		_methodParameterTypes217 = new String[] { "long" };

		_methodName218 = "retrieveScienceAppsByVocabularyId";

		_methodParameterTypes218 = new String[] { "long" };

		_methodName219 = "retrieveScienceAppsByVocabularyIdStage";

		_methodParameterTypes219 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName220 = "countScienceAppsByVocabularyIdStage";

		_methodParameterTypes220 = new String[] { "long", "java.lang.String" };

		_methodName221 = "retrieveScienceAppsByVocabularyIdStage";

		_methodParameterTypes221 = new String[] { "long", "java.lang.String" };

		_methodName222 = "retrieveScienceAppsByVocabularyIdTarget";

		_methodParameterTypes222 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName223 = "countScienceAppsByVocabularyIdTarget";

		_methodParameterTypes223 = new String[] { "long", "java.lang.String" };

		_methodName224 = "retrieveScienceAppsByVocabularyIdTarget";

		_methodParameterTypes224 = new String[] { "long", "java.lang.String" };

		_methodName225 = "retrieveScienceAppsByVocabularyIdStageTarget";

		_methodParameterTypes225 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName226 = "countScienceAppsByVocabularyIdStageTarget";

		_methodParameterTypes226 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName227 = "retrieveScienceAppsByVocabularyIdStageTarget";

		_methodParameterTypes227 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName228 = "retrieveScienceAppsByCategoryId";

		_methodParameterTypes228 = new String[] { "long", "int", "int" };

		_methodName229 = "countScienceAppsByCategoryId";

		_methodParameterTypes229 = new String[] { "long" };

		_methodName230 = "retrieveScienceAppsByCategoryId";

		_methodParameterTypes230 = new String[] { "long" };

		_methodName231 = "retrieveScienceAppsByCategoryIdStage";

		_methodParameterTypes231 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName232 = "countScienceAppsByCategoryIdStage";

		_methodParameterTypes232 = new String[] { "long", "java.lang.String" };

		_methodName233 = "retrieveScienceAppsByCategoryIdStage";

		_methodParameterTypes233 = new String[] { "long", "java.lang.String" };

		_methodName234 = "retrieveScienceAppsByCategoryIdTarget";

		_methodParameterTypes234 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName235 = "countScienceAppsByCategoryIdTarget";

		_methodParameterTypes235 = new String[] { "long", "java.lang.String" };

		_methodName236 = "retrieveScienceAppsByCategoryIdTarget";

		_methodParameterTypes236 = new String[] { "long", "java.lang.String" };

		_methodName237 = "retrieveScienceAppsByCategoryIdStageTarget";

		_methodParameterTypes237 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName238 = "countScienceAppsByCategoryIdStageTarget";

		_methodParameterTypes238 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName239 = "retrieveScienceAppsByCategoryIdStageTarget";

		_methodParameterTypes239 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName242 = "existScienceAppPath";

		_methodParameterTypes242 = new String[] { "java.lang.String" };

		_methodName243 = "deleteScienceAppDir";

		_methodParameterTypes243 = new String[] { "java.lang.String" };

		_methodName244 = "makeScienceAppDir";

		_methodParameterTypes244 = new String[] { "java.lang.String" };

		_methodName245 = "saveToScienceAppStorage";

		_methodParameterTypes245 = new String[] {
				"java.lang.String", "java.lang.String", "java.io.InputStream"
			};

		_methodName247 = "unzipScienceAppZipFile";

		_methodParameterTypes247 = new String[] {
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ScienceAppLocalServiceUtil.addScienceApp((com.kisti.science.platform.app.model.ScienceApp)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ScienceAppLocalServiceUtil.createScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ScienceAppLocalServiceUtil.deleteScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ScienceAppLocalServiceUtil.deleteScienceApp((com.kisti.science.platform.app.model.ScienceApp)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ScienceAppLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ScienceAppLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ScienceAppLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ScienceAppLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ScienceAppLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ScienceAppLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ScienceAppLocalServiceUtil.fetchScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ScienceAppLocalServiceUtil.fetchScienceAppByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ScienceAppLocalServiceUtil.fetchScienceAppByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppByUuidAndCompanyId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceApps(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ScienceAppLocalServiceUtil.updateScienceApp((com.kisti.science.platform.app.model.ScienceApp)arguments[0]);
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			ScienceAppLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return ScienceAppLocalServiceUtil.createScienceApp((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			return ScienceAppLocalServiceUtil.copyScienceApp(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return ScienceAppLocalServiceUtil.addScienceApp((com.kisti.science.platform.app.model.ScienceApp)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			ScienceAppLocalServiceUtil.setScienceAppInputPorts(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppInputPorts(((Long)arguments[0]).longValue());
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			ScienceAppLocalServiceUtil.setScienceAppOutputPorts(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppOutputPorts(((Long)arguments[0]).longValue());
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			return ScienceAppLocalServiceUtil.verifyScienceAppName((java.lang.String)arguments[0]);
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return ScienceAppLocalServiceUtil.existAppName((java.lang.String)arguments[0]);
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			return ScienceAppLocalServiceUtil.existApp((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getLatestVersion((java.lang.String)arguments[0]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return ScienceAppLocalServiceUtil.verifyVersionNumber((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return ScienceAppLocalServiceUtil.deleteScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return ScienceAppLocalServiceUtil.deleteScienceApp((com.kisti.science.platform.app.model.ScienceApp)arguments[0]);
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			ScienceAppLocalServiceUtil.deleteAllScienceApps();

			return null;
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return ScienceAppLocalServiceUtil.updateScienceApp((com.kisti.science.platform.app.model.ScienceApp)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getAll();
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countAll();
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getAll((java.lang.String)arguments[0]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countAll((java.lang.String)arguments[0]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(java.lang.String)arguments[2]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByStage((java.lang.String)arguments[0]);
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByStage((java.lang.String)arguments[0]);
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByStage((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorIdAppType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAppType((java.lang.String)arguments[0]);
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAppType((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAppType((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAppType((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3]);
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByAppType((java.lang.String)arguments[0]);
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByAppType((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorIdAppType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorId(((Long)arguments[0]).longValue());
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByAuthorId(((Long)arguments[0]).longValue());
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByOpenLevel((java.lang.String)arguments[0]);
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByOpenLevel((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByManagerId(((Long)arguments[0]).longValue());
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByManagerId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByManagerId(((Long)arguments[0]).longValue());
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppManagerIds(((Long)arguments[0]).longValue());
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppManagerIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppManagers(((Long)arguments[0]).longValue());
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppCategoryIds(((Long)arguments[0]).longValue());
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppCategoryIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppCategories(((Long)arguments[0]).longValue());
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignScienceAppToCategories(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignScienceAppToCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignManagersToScienceApp(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignManagerToScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppBinPath(((Long)arguments[0]).longValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppSrcPath(((Long)arguments[0]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countAllScienceApps();
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationName((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnNameTitleScreenNameAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnNameTitleScreenNameAffiliationNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenName((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnScreenName((java.lang.String)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenName((java.lang.String)arguments[0]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnScreenNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnScreenNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnScreenNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnScreenNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationName((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnAffiliationNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationNameByStage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnAffiliationNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationNameByTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsOnAffiliationNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsOnAffiliationNameByStageTarget((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByVocabularyId(((Long)arguments[0]).longValue());
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyId(((Long)arguments[0]).longValue());
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyIdStage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByVocabularyIdStage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyIdStage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyIdTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByVocabularyIdTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyIdTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyIdStageTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByVocabularyIdStageTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByVocabularyIdStageTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName228.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes228, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName229.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes229, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName230.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes230, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName231.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes231, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryIdStage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName232.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes232, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByCategoryIdStage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName233.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes233, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryIdStage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName234.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes234, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryIdTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName235.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes235, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByCategoryIdTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName236.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes236, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryIdTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName237.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes237, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryIdStageTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName238.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes238, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByCategoryIdStageTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName239.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes239, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppsByCategoryIdStageTarget(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName242.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes242, parameterTypes)) {
			return ScienceAppLocalServiceUtil.existScienceAppPath((java.lang.String)arguments[0]);
		}

		if (_methodName243.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes243, parameterTypes)) {
			ScienceAppLocalServiceUtil.deleteScienceAppDir((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName244.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes244, parameterTypes)) {
			ScienceAppLocalServiceUtil.makeScienceAppDir((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName245.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes245, parameterTypes)) {
			return ScienceAppLocalServiceUtil.saveToScienceAppStorage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(java.io.InputStream)arguments[2]);
		}

		if (_methodName247.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes247, parameterTypes)) {
			ScienceAppLocalServiceUtil.unzipScienceAppZipFile((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);

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
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
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
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
	private String _methodName142;
	private String[] _methodParameterTypes142;
	private String _methodName143;
	private String[] _methodParameterTypes143;
	private String _methodName144;
	private String[] _methodParameterTypes144;
	private String _methodName145;
	private String[] _methodParameterTypes145;
	private String _methodName146;
	private String[] _methodParameterTypes146;
	private String _methodName147;
	private String[] _methodParameterTypes147;
	private String _methodName148;
	private String[] _methodParameterTypes148;
	private String _methodName149;
	private String[] _methodParameterTypes149;
	private String _methodName150;
	private String[] _methodParameterTypes150;
	private String _methodName151;
	private String[] _methodParameterTypes151;
	private String _methodName152;
	private String[] _methodParameterTypes152;
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName154;
	private String[] _methodParameterTypes154;
	private String _methodName155;
	private String[] _methodParameterTypes155;
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName157;
	private String[] _methodParameterTypes157;
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
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
	private String _methodName204;
	private String[] _methodParameterTypes204;
	private String _methodName205;
	private String[] _methodParameterTypes205;
	private String _methodName206;
	private String[] _methodParameterTypes206;
	private String _methodName207;
	private String[] _methodParameterTypes207;
	private String _methodName208;
	private String[] _methodParameterTypes208;
	private String _methodName209;
	private String[] _methodParameterTypes209;
	private String _methodName210;
	private String[] _methodParameterTypes210;
	private String _methodName211;
	private String[] _methodParameterTypes211;
	private String _methodName212;
	private String[] _methodParameterTypes212;
	private String _methodName213;
	private String[] _methodParameterTypes213;
	private String _methodName214;
	private String[] _methodParameterTypes214;
	private String _methodName215;
	private String[] _methodParameterTypes215;
	private String _methodName216;
	private String[] _methodParameterTypes216;
	private String _methodName217;
	private String[] _methodParameterTypes217;
	private String _methodName218;
	private String[] _methodParameterTypes218;
	private String _methodName219;
	private String[] _methodParameterTypes219;
	private String _methodName220;
	private String[] _methodParameterTypes220;
	private String _methodName221;
	private String[] _methodParameterTypes221;
	private String _methodName222;
	private String[] _methodParameterTypes222;
	private String _methodName223;
	private String[] _methodParameterTypes223;
	private String _methodName224;
	private String[] _methodParameterTypes224;
	private String _methodName225;
	private String[] _methodParameterTypes225;
	private String _methodName226;
	private String[] _methodParameterTypes226;
	private String _methodName227;
	private String[] _methodParameterTypes227;
	private String _methodName228;
	private String[] _methodParameterTypes228;
	private String _methodName229;
	private String[] _methodParameterTypes229;
	private String _methodName230;
	private String[] _methodParameterTypes230;
	private String _methodName231;
	private String[] _methodParameterTypes231;
	private String _methodName232;
	private String[] _methodParameterTypes232;
	private String _methodName233;
	private String[] _methodParameterTypes233;
	private String _methodName234;
	private String[] _methodParameterTypes234;
	private String _methodName235;
	private String[] _methodParameterTypes235;
	private String _methodName236;
	private String[] _methodParameterTypes236;
	private String _methodName237;
	private String[] _methodParameterTypes237;
	private String _methodName238;
	private String[] _methodParameterTypes238;
	private String _methodName239;
	private String[] _methodParameterTypes239;
	private String _methodName242;
	private String[] _methodParameterTypes242;
	private String _methodName243;
	private String[] _methodParameterTypes243;
	private String _methodName244;
	private String[] _methodParameterTypes244;
	private String _methodName245;
	private String[] _methodParameterTypes245;
	private String _methodName247;
	private String[] _methodParameterTypes247;
}