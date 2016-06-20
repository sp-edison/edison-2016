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

import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class ScienceAppLocalServiceClpInvoker {
	public ScienceAppLocalServiceClpInvoker() {
		_methodName0 = "addScienceApp";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.science.model.ScienceApp"
			};

		_methodName1 = "createScienceApp";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteScienceApp";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteScienceApp";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.science.model.ScienceApp"
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
				"org.kisti.edison.science.model.ScienceApp"
			};

		_methodName166 = "getBeanIdentifier";

		_methodParameterTypes166 = new String[] {  };

		_methodName167 = "setBeanIdentifier";

		_methodParameterTypes167 = new String[] { "java.lang.String" };

		_methodName172 = "createScienceApp";

		_methodParameterTypes172 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName173 = "copyScienceApp";

		_methodParameterTypes173 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName174 = "addScienceApp";

		_methodParameterTypes174 = new String[] {
				"org.kisti.edison.science.model.ScienceApp",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName175 = "setScienceAppInputPorts";

		_methodParameterTypes175 = new String[] { "long", "java.lang.String" };

		_methodName176 = "getScienceAppInputPorts";

		_methodParameterTypes176 = new String[] { "long" };

		_methodName177 = "setScienceAppOutputPorts";

		_methodParameterTypes177 = new String[] { "long", "java.lang.String" };

		_methodName178 = "getScienceAppOutputPorts";

		_methodParameterTypes178 = new String[] { "long" };

		_methodName179 = "verifyScienceAppName";

		_methodParameterTypes179 = new String[] { "java.lang.String" };

		_methodName180 = "existAppName";

		_methodParameterTypes180 = new String[] { "java.lang.String" };

		_methodName181 = "existApp";

		_methodParameterTypes181 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName182 = "getLatestVersion";

		_methodParameterTypes182 = new String[] { "java.lang.String" };

		_methodName183 = "verifyVersionNumber";

		_methodParameterTypes183 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName184 = "deleteScienceApp";

		_methodParameterTypes184 = new String[] { "long" };

		_methodName185 = "deleteScienceApp";

		_methodParameterTypes185 = new String[] {
				"org.kisti.edison.science.model.ScienceApp"
			};

		_methodName186 = "deleteAllScienceApps";

		_methodParameterTypes186 = new String[] {  };

		_methodName187 = "updateScienceApp";

		_methodParameterTypes187 = new String[] {
				"org.kisti.edison.science.model.ScienceApp",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName188 = "getScienceAppListByStatus";

		_methodParameterTypes188 = new String[] { "int" };

		_methodName189 = "getScienceAppListByStage";

		_methodParameterTypes189 = new String[] { "java.lang.String" };

		_methodName190 = "getScienceAppListByAuthorIdStatus";

		_methodParameterTypes190 = new String[] { "long", "int" };

		_methodName191 = "getScienceAppListByAuthorIdStatus";

		_methodParameterTypes191 = new String[] { "long", "int", "int", "int" };

		_methodName192 = "getScienceAppListByAuthorIdAppType";

		_methodParameterTypes192 = new String[] { "long", "java.lang.String" };

		_methodName193 = "getScienceAppListByAuthorIdAppType";

		_methodParameterTypes193 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName194 = "getScienceAppListByAuthorId";

		_methodParameterTypes194 = new String[] { "long" };

		_methodName195 = "getScienceAppListByAuthorId";

		_methodParameterTypes195 = new String[] { "long", "int", "int" };

		_methodName196 = "countScienceAppsByAuthorId";

		_methodParameterTypes196 = new String[] { "long" };

		_methodName197 = "getScienceAppListByOpenLevel";

		_methodParameterTypes197 = new String[] { "java.lang.String" };

		_methodName198 = "getScienceAppListByOpenLevel";

		_methodParameterTypes198 = new String[] { "java.lang.String", "int", "int" };

		_methodName199 = "getScienceAppListByManagerId";

		_methodParameterTypes199 = new String[] { "long" };

		_methodName200 = "getScienceAppListByManagerId";

		_methodParameterTypes200 = new String[] { "long", "int", "int" };

		_methodName201 = "countScienceAppsByManagerId";

		_methodParameterTypes201 = new String[] { "long" };

		_methodName202 = "getScienceAppManagerIds";

		_methodParameterTypes202 = new String[] { "long" };

		_methodName203 = "getScienceAppManagerIds";

		_methodParameterTypes203 = new String[] { "long", "int", "int" };

		_methodName204 = "countScienceAppManagers";

		_methodParameterTypes204 = new String[] { "long" };

		_methodName205 = "getScienceAppListByCategoryId";

		_methodParameterTypes205 = new String[] { "long" };

		_methodName206 = "getScienceAppListByCategoryId";

		_methodParameterTypes206 = new String[] { "long", "int", "int" };

		_methodName207 = "countScienceAppsByCategoryId";

		_methodParameterTypes207 = new String[] { "long" };

		_methodName208 = "getScienceAppCategoryIds";

		_methodParameterTypes208 = new String[] { "long" };

		_methodName209 = "getScienceAppCategoryIds";

		_methodParameterTypes209 = new String[] { "long", "int", "int" };

		_methodName210 = "countScienceAppCategories";

		_methodParameterTypes210 = new String[] { "long" };

		_methodName211 = "assignScienceAppToCategories";

		_methodParameterTypes211 = new String[] { "long", "long[][]" };

		_methodName212 = "assignScienceAppToCategory";

		_methodParameterTypes212 = new String[] { "long", "long" };

		_methodName213 = "assignManagersToScienceApp";

		_methodParameterTypes213 = new String[] { "long", "long[][]" };

		_methodName214 = "assignManagerToScienceApp";

		_methodParameterTypes214 = new String[] { "long", "long" };

		_methodName215 = "getScienceAppBinPath";

		_methodParameterTypes215 = new String[] { "long" };

		_methodName216 = "getScienceAppSrcPath";

		_methodParameterTypes216 = new String[] { "long" };

		_methodName217 = "countAllScienceApps";

		_methodParameterTypes217 = new String[] {  };

		_methodName218 = "retrieveScienceAppOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes218 = new String[] { "java.lang.String", "int", "int" };

		_methodName219 = "countScienceAppOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes219 = new String[] { "java.lang.String" };

		_methodName220 = "retrieveAllScienceAppOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes220 = new String[] { "java.lang.String" };

		_methodName221 = "retrieveScienceAppOnScreenName";

		_methodParameterTypes221 = new String[] { "java.lang.String", "int", "int" };

		_methodName222 = "countScienceAppOnScreenName";

		_methodParameterTypes222 = new String[] { "java.lang.String" };

		_methodName223 = "retrieveAllScienceAppOnScreenName";

		_methodParameterTypes223 = new String[] { "java.lang.String" };

		_methodName224 = "retrieveScienceAppOnAffiliationName";

		_methodParameterTypes224 = new String[] { "java.lang.String", "int", "int" };

		_methodName225 = "countScienceAppOnAffiliationName";

		_methodParameterTypes225 = new String[] { "java.lang.String" };

		_methodName226 = "retrieveAllScienceAppOnAffiliationName";

		_methodParameterTypes226 = new String[] { "java.lang.String" };

		_methodName229 = "existScienceAppPath";

		_methodParameterTypes229 = new String[] { "java.lang.String" };

		_methodName230 = "deleteScienceAppDir";

		_methodParameterTypes230 = new String[] { "java.lang.String" };

		_methodName231 = "makeScienceAppDir";

		_methodParameterTypes231 = new String[] { "java.lang.String" };

		_methodName232 = "saveToScienceAppStorage";

		_methodParameterTypes232 = new String[] {
				"java.lang.String", "java.lang.String", "java.io.InputStream"
			};

		_methodName233 = "unzipScienceAppZipFile";

		_methodParameterTypes233 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName235 = "getScienceAppListByCategoryId";

		_methodParameterTypes235 = new String[] { "long", "java.util.Locale" };

		_methodName236 = "getScienceAppListByCategoryId";

		_methodParameterTypes236 = new String[] {
				"long", "java.util.Locale", "int", "int"
			};

		_methodName237 = "getScienceAppListByScienceAppIdsAndLocale";

		_methodParameterTypes237 = new String[] { "long[][]", "java.util.Locale" };

		_methodName238 = "getLanguageSpecificAssetCategories";

		_methodParameterTypes238 = new String[] {
				"java.util.List", "long", "java.util.Locale"
			};

		_methodName239 = "getScienceAppListByScienceAppIdsAndLocale";

		_methodParameterTypes239 = new String[] {
				"long[][]", "java.util.Locale", "int", "int"
			};

		_methodName240 = "createScienceApp";

		_methodParameterTypes240 = new String[] {
				"com.liferay.portal.service.ServiceContext", "java.util.Map"
			};

		_methodName241 = "updateScienceApp";

		_methodParameterTypes241 = new String[] {
				"com.liferay.portal.service.ServiceContext", "java.util.Map",
				"long"
			};

		_methodName242 = "countScienceApp";

		_methodParameterTypes242 = new String[] {
				"long", "long", "long", "java.util.Locale", "java.util.Map"
			};

		_methodName243 = "retrieveListScienceEditorApp";

		_methodParameterTypes243 = new String[] {
				"long", "java.util.Locale", "java.util.Map"
			};

		_methodName244 = "retrieveListScienceApp";

		_methodParameterTypes244 = new String[] {
				"long", "long", "long", "java.util.Locale", "java.util.Map",
				"int", "int", "boolean"
			};

		_methodName245 = "getScienceAppReturnObject";

		_methodParameterTypes245 = new String[] { "long", "java.util.Locale" };

		_methodName246 = "retrieveListScienceAppWithOutExpando";

		_methodParameterTypes246 = new String[] {
				"long", "long", "java.util.Locale", "java.util.Map", "int",
				"int"
			};

		_methodName247 = "updateExeInfomaionScienceApp";

		_methodParameterTypes247 = new String[] {
				"com.liferay.portal.service.ServiceContext", "java.util.Map",
				"long"
			};

		_methodName250 = "getScienceAppExeSts";

		_methodParameterTypes250 = new String[] { "java.lang.String", "long" };

		_methodName251 = "getMyAppListWithQna";

		_methodParameterTypes251 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName252 = "getListMyAppQna";

		_methodParameterTypes252 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName253 = "deleteScienceAppRelation";

		_methodParameterTypes253 = new String[] { "long" };

		_methodName254 = "getMyAppListForProject";

		_methodParameterTypes254 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName255 = "getMyAppListForProjectCount";

		_methodParameterTypes255 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName256 = "countAppTest";

		_methodParameterTypes256 = new String[] { "long" };

		_methodName257 = "retrieveListAppTest";

		_methodParameterTypes257 = new String[] { "java.util.Map" };

		_methodName258 = "getAll";

		_methodParameterTypes258 = new String[] {  };

		_methodName259 = "addScienceAppFile";

		_methodParameterTypes259 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.io.InputStream"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ScienceAppLocalServiceUtil.addScienceApp((org.kisti.edison.science.model.ScienceApp)arguments[0]);
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
			return ScienceAppLocalServiceUtil.deleteScienceApp((org.kisti.edison.science.model.ScienceApp)arguments[0]);
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
			return ScienceAppLocalServiceUtil.updateScienceApp((org.kisti.edison.science.model.ScienceApp)arguments[0]);
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			ScienceAppLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return ScienceAppLocalServiceUtil.createScienceApp((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return ScienceAppLocalServiceUtil.copyScienceApp(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return ScienceAppLocalServiceUtil.addScienceApp((org.kisti.edison.science.model.ScienceApp)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			ScienceAppLocalServiceUtil.setScienceAppInputPorts(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppInputPorts(((Long)arguments[0]).longValue());
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			ScienceAppLocalServiceUtil.setScienceAppOutputPorts(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppOutputPorts(((Long)arguments[0]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return ScienceAppLocalServiceUtil.verifyScienceAppName((java.lang.String)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return ScienceAppLocalServiceUtil.existAppName((java.lang.String)arguments[0]);
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return ScienceAppLocalServiceUtil.existApp((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getLatestVersion((java.lang.String)arguments[0]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return ScienceAppLocalServiceUtil.verifyVersionNumber((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return ScienceAppLocalServiceUtil.deleteScienceApp(((Long)arguments[0]).longValue());
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return ScienceAppLocalServiceUtil.deleteScienceApp((org.kisti.edison.science.model.ScienceApp)arguments[0]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			ScienceAppLocalServiceUtil.deleteAllScienceApps();

			return null;
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return ScienceAppLocalServiceUtil.updateScienceApp((org.kisti.edison.science.model.ScienceApp)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByStage((java.lang.String)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorIdStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorIdStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorIdAppType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorIdAppType(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorId(((Long)arguments[0]).longValue());
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByAuthorId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByAuthorId(((Long)arguments[0]).longValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByOpenLevel((java.lang.String)arguments[0]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByOpenLevel((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByManagerId(((Long)arguments[0]).longValue());
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByManagerId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByManagerId(((Long)arguments[0]).longValue());
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppManagerIds(((Long)arguments[0]).longValue());
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppManagerIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppManagers(((Long)arguments[0]).longValue());
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppsByCategoryId(((Long)arguments[0]).longValue());
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppCategoryIds(((Long)arguments[0]).longValue());
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppCategoryIds(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppCategories(((Long)arguments[0]).longValue());
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignScienceAppToCategories(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignScienceAppToCategory(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignManagersToScienceApp(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			ScienceAppLocalServiceUtil.assignManagerToScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppBinPath(((Long)arguments[0]).longValue());
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppSrcPath(((Long)arguments[0]).longValue());
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countAllScienceApps();
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppOnNameTitleScreenNameAffiliationName((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppOnNameTitleScreenNameAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveAllScienceAppOnNameTitleScreenNameAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppOnScreenName((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppOnScreenName((java.lang.String)arguments[0]);
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveAllScienceAppOnScreenName((java.lang.String)arguments[0]);
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveScienceAppOnAffiliationName((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceAppOnAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveAllScienceAppOnAffiliationName((java.lang.String)arguments[0]);
		}

		if (_methodName229.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes229, parameterTypes)) {
			return ScienceAppLocalServiceUtil.existScienceAppPath((java.lang.String)arguments[0]);
		}

		if (_methodName230.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes230, parameterTypes)) {
			ScienceAppLocalServiceUtil.deleteScienceAppDir((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName231.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes231, parameterTypes)) {
			ScienceAppLocalServiceUtil.makeScienceAppDir((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName232.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes232, parameterTypes)) {
			return ScienceAppLocalServiceUtil.saveToScienceAppStorage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(java.io.InputStream)arguments[2]);
		}

		if (_methodName233.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes233, parameterTypes)) {
			ScienceAppLocalServiceUtil.unzipScienceAppZipFile((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName235.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes235, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName236.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes236, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByCategoryId(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName237.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes237, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByScienceAppIdsAndLocale((long[])arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName238.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes238, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getLanguageSpecificAssetCategories((java.util.List<com.liferay.portlet.asset.model.AssetCategory>)arguments[0],
				((Long)arguments[1]).longValue(), (java.util.Locale)arguments[2]);
		}

		if (_methodName239.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes239, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppListByScienceAppIdsAndLocale((long[])arguments[0],
				(java.util.Locale)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName240.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes240, parameterTypes)) {
			return ScienceAppLocalServiceUtil.createScienceApp((com.liferay.portal.service.ServiceContext)arguments[0],
				(java.util.Map)arguments[1]);
		}

		if (_methodName241.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes241, parameterTypes)) {
			ScienceAppLocalServiceUtil.updateScienceApp((com.liferay.portal.service.ServiceContext)arguments[0],
				(java.util.Map)arguments[1], ((Long)arguments[2]).longValue());

			return null;
		}

		if (_methodName242.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes242, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.util.Locale)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[4]);
		}

		if (_methodName243.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes243, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveListScienceEditorApp(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[2]);
		}

		if (_methodName244.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes244, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveListScienceApp(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.util.Locale)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[4],
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue(),
				((Boolean)arguments[7]).booleanValue());
		}

		if (_methodName245.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes245, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppReturnObject(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName246.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes246, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveListScienceAppWithOutExpando(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.util.Locale)arguments[2],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName247.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes247, parameterTypes)) {
			return ScienceAppLocalServiceUtil.updateExeInfomaionScienceApp((com.liferay.portal.service.ServiceContext)arguments[0],
				(java.util.Map)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName250.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes250, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getScienceAppExeSts((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName251.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes251, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getMyAppListWithQna((java.util.Map)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName252.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes252, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getListMyAppQna((java.util.Map)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName253.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes253, parameterTypes)) {
			ScienceAppLocalServiceUtil.deleteScienceAppRelation(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName254.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes254, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getMyAppListForProject((java.util.Map)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName255.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes255, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getMyAppListForProjectCount((java.util.Map)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName256.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes256, parameterTypes)) {
			return ScienceAppLocalServiceUtil.countAppTest(((Long)arguments[0]).longValue());
		}

		if (_methodName257.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes257, parameterTypes)) {
			return ScienceAppLocalServiceUtil.retrieveListAppTest((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName258.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes258, parameterTypes)) {
			return ScienceAppLocalServiceUtil.getAll();
		}

		if (_methodName259.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes259, parameterTypes)) {
			ScienceAppLocalServiceUtil.addScienceAppFile(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(java.io.InputStream)arguments[4]);

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
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
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
	private String _methodName240;
	private String[] _methodParameterTypes240;
	private String _methodName241;
	private String[] _methodParameterTypes241;
	private String _methodName242;
	private String[] _methodParameterTypes242;
	private String _methodName243;
	private String[] _methodParameterTypes243;
	private String _methodName244;
	private String[] _methodParameterTypes244;
	private String _methodName245;
	private String[] _methodParameterTypes245;
	private String _methodName246;
	private String[] _methodParameterTypes246;
	private String _methodName247;
	private String[] _methodParameterTypes247;
	private String _methodName250;
	private String[] _methodParameterTypes250;
	private String _methodName251;
	private String[] _methodParameterTypes251;
	private String _methodName252;
	private String[] _methodParameterTypes252;
	private String _methodName253;
	private String[] _methodParameterTypes253;
	private String _methodName254;
	private String[] _methodParameterTypes254;
	private String _methodName255;
	private String[] _methodParameterTypes255;
	private String _methodName256;
	private String[] _methodParameterTypes256;
	private String _methodName257;
	private String[] _methodParameterTypes257;
	private String _methodName258;
	private String[] _methodParameterTypes258;
	private String _methodName259;
	private String[] _methodParameterTypes259;
}