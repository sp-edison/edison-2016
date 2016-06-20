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

package com.kisti.science.platform.app.service;

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class ScienceAppLocalServiceClp implements ScienceAppLocalService {
	public ScienceAppLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

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

		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName23 = "createScienceApp";

		_methodParameterTypes23 = new String[] {
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName24 = "copyScienceApp";

		_methodParameterTypes24 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName25 = "addScienceApp";

		_methodParameterTypes25 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName26 = "setScienceAppInputPorts";

		_methodParameterTypes26 = new String[] { "long", "java.lang.String" };

		_methodName27 = "getScienceAppInputPorts";

		_methodParameterTypes27 = new String[] { "long" };

		_methodName28 = "setScienceAppOutputPorts";

		_methodParameterTypes28 = new String[] { "long", "java.lang.String" };

		_methodName29 = "getScienceAppOutputPorts";

		_methodParameterTypes29 = new String[] { "long" };

		_methodName30 = "verifyScienceAppName";

		_methodParameterTypes30 = new String[] { "java.lang.String" };

		_methodName31 = "existAppName";

		_methodParameterTypes31 = new String[] { "java.lang.String" };

		_methodName32 = "existApp";

		_methodParameterTypes32 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName33 = "getLatestVersion";

		_methodParameterTypes33 = new String[] { "java.lang.String" };

		_methodName34 = "verifyVersionNumber";

		_methodParameterTypes34 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName35 = "deleteAllScienceApps";

		_methodParameterTypes35 = new String[] {  };

		_methodName36 = "updateScienceApp";

		_methodParameterTypes36 = new String[] {
				"com.kisti.science.platform.app.model.ScienceApp",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName37 = "getAll";

		_methodParameterTypes37 = new String[] {  };

		_methodName38 = "countAll";

		_methodParameterTypes38 = new String[] {  };

		_methodName39 = "getAll";

		_methodParameterTypes39 = new String[] { "java.lang.String" };

		_methodName40 = "countAll";

		_methodParameterTypes40 = new String[] { "java.lang.String" };

		_methodName41 = "getAll";

		_methodParameterTypes41 = new String[] { "int", "int" };

		_methodName42 = "getAll";

		_methodParameterTypes42 = new String[] { "int", "int", "java.lang.String" };

		_methodName43 = "getScienceAppListByStatus";

		_methodParameterTypes43 = new String[] { "int" };

		_methodName44 = "countScienceAppsByStatus";

		_methodParameterTypes44 = new String[] { "int" };

		_methodName45 = "getScienceAppListByStage";

		_methodParameterTypes45 = new String[] { "java.lang.String" };

		_methodName46 = "countScienceAppsByStage";

		_methodParameterTypes46 = new String[] { "java.lang.String" };

		_methodName47 = "getScienceAppListByStage";

		_methodParameterTypes47 = new String[] { "java.lang.String", "int", "int" };

		_methodName48 = "getScienceAppListByAuthorIdAppType";

		_methodParameterTypes48 = new String[] { "long", "java.lang.String" };

		_methodName49 = "getScienceAppListByAppType";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName50 = "getScienceAppListByAppType";

		_methodParameterTypes50 = new String[] { "java.lang.String", "int", "int" };

		_methodName51 = "getScienceAppListByAppType";

		_methodParameterTypes51 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName52 = "getScienceAppListByAppType";

		_methodParameterTypes52 = new String[] {
				"java.lang.String", "int", "int", "java.lang.String"
			};

		_methodName53 = "countScienceAppsByAppType";

		_methodParameterTypes53 = new String[] { "java.lang.String" };

		_methodName54 = "countScienceAppsByAppType";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName55 = "getScienceAppListByAuthorIdAppType";

		_methodParameterTypes55 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName56 = "getScienceAppListByAuthorId";

		_methodParameterTypes56 = new String[] { "long" };

		_methodName57 = "getScienceAppListByAuthorId";

		_methodParameterTypes57 = new String[] { "long", "int", "int" };

		_methodName58 = "countScienceAppsByAuthorId";

		_methodParameterTypes58 = new String[] { "long" };

		_methodName59 = "getScienceAppListByOpenLevel";

		_methodParameterTypes59 = new String[] { "java.lang.String" };

		_methodName60 = "getScienceAppListByOpenLevel";

		_methodParameterTypes60 = new String[] { "java.lang.String", "int", "int" };

		_methodName61 = "getScienceAppListByManagerId";

		_methodParameterTypes61 = new String[] { "long" };

		_methodName62 = "getScienceAppListByManagerId";

		_methodParameterTypes62 = new String[] { "long", "int", "int" };

		_methodName63 = "countScienceAppsByManagerId";

		_methodParameterTypes63 = new String[] { "long" };

		_methodName64 = "getScienceAppManagerIds";

		_methodParameterTypes64 = new String[] { "long" };

		_methodName65 = "getScienceAppManagerIds";

		_methodParameterTypes65 = new String[] { "long", "int", "int" };

		_methodName66 = "countScienceAppManagers";

		_methodParameterTypes66 = new String[] { "long" };

		_methodName67 = "getScienceAppListByCategoryId";

		_methodParameterTypes67 = new String[] { "long" };

		_methodName68 = "getScienceAppListByCategoryId";

		_methodParameterTypes68 = new String[] { "long", "int", "int" };

		_methodName69 = "getScienceAppCategoryIds";

		_methodParameterTypes69 = new String[] { "long" };

		_methodName70 = "getScienceAppCategoryIds";

		_methodParameterTypes70 = new String[] { "long", "int", "int" };

		_methodName71 = "countScienceAppCategories";

		_methodParameterTypes71 = new String[] { "long" };

		_methodName72 = "assignScienceAppToCategories";

		_methodParameterTypes72 = new String[] { "long", "long[][]" };

		_methodName73 = "assignScienceAppToCategory";

		_methodParameterTypes73 = new String[] { "long", "long" };

		_methodName74 = "assignManagersToScienceApp";

		_methodParameterTypes74 = new String[] { "long", "long[][]" };

		_methodName75 = "assignManagerToScienceApp";

		_methodParameterTypes75 = new String[] { "long", "long" };

		_methodName76 = "getScienceAppBinPath";

		_methodParameterTypes76 = new String[] { "long" };

		_methodName77 = "getScienceAppSrcPath";

		_methodParameterTypes77 = new String[] { "long" };

		_methodName78 = "countAllScienceApps";

		_methodParameterTypes78 = new String[] {  };

		_methodName79 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes79 = new String[] { "java.lang.String", "int", "int" };

		_methodName80 = "countScienceAppsOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes80 = new String[] { "java.lang.String" };

		_methodName81 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationName";

		_methodParameterTypes81 = new String[] { "java.lang.String" };

		_methodName82 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage";

		_methodParameterTypes82 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName83 = "countScienceAppsOnNameTitleScreenNameAffiliationNameByStage";

		_methodParameterTypes83 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName84 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage";

		_methodParameterTypes84 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName85 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget";

		_methodParameterTypes85 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName86 = "countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget";

		_methodParameterTypes86 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName87 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget";

		_methodParameterTypes87 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName88 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget";

		_methodParameterTypes88 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName89 = "countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget";

		_methodParameterTypes89 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName90 = "retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget";

		_methodParameterTypes90 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName91 = "retrieveScienceAppsOnScreenName";

		_methodParameterTypes91 = new String[] { "java.lang.String", "int", "int" };

		_methodName92 = "countScienceAppsOnScreenName";

		_methodParameterTypes92 = new String[] { "java.lang.String" };

		_methodName93 = "retrieveScienceAppsOnScreenName";

		_methodParameterTypes93 = new String[] { "java.lang.String" };

		_methodName94 = "retrieveScienceAppsOnScreenNameByStage";

		_methodParameterTypes94 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName95 = "countScienceAppsOnScreenNameByStage";

		_methodParameterTypes95 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName96 = "retrieveScienceAppsOnScreenNameByStage";

		_methodParameterTypes96 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName97 = "retrieveScienceAppsOnScreenNameByTarget";

		_methodParameterTypes97 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName98 = "countScienceAppsOnScreenNameByTarget";

		_methodParameterTypes98 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName99 = "retrieveScienceAppsOnScreenNameByTarget";

		_methodParameterTypes99 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName100 = "retrieveScienceAppsOnScreenNameByStageTarget";

		_methodParameterTypes100 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName101 = "countScienceAppsOnScreenNameByStageTarget";

		_methodParameterTypes101 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName102 = "retrieveScienceAppsOnScreenNameByStageTarget";

		_methodParameterTypes102 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName103 = "retrieveScienceAppsOnAffiliationName";

		_methodParameterTypes103 = new String[] { "java.lang.String", "int", "int" };

		_methodName104 = "countScienceAppsOnAffiliationName";

		_methodParameterTypes104 = new String[] { "java.lang.String" };

		_methodName105 = "retrieveScienceAppsOnAffiliationName";

		_methodParameterTypes105 = new String[] { "java.lang.String" };

		_methodName106 = "retrieveScienceAppsOnAffiliationNameByStage";

		_methodParameterTypes106 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName107 = "countScienceAppsOnAffiliationNameByStage";

		_methodParameterTypes107 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName108 = "retrieveScienceAppsOnAffiliationNameByStage";

		_methodParameterTypes108 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName109 = "retrieveScienceAppsOnAffiliationNameByTarget";

		_methodParameterTypes109 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName110 = "countScienceAppsOnAffiliationNameByTarget";

		_methodParameterTypes110 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName111 = "retrieveScienceAppsOnAffiliationNameByTarget";

		_methodParameterTypes111 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName112 = "retrieveScienceAppsOnAffiliationNameByStageTarget";

		_methodParameterTypes112 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName113 = "countScienceAppsOnAffiliationNameByStageTarget";

		_methodParameterTypes113 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName114 = "retrieveScienceAppsOnAffiliationNameByStageTarget";

		_methodParameterTypes114 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName115 = "retrieveScienceAppsByVocabularyId";

		_methodParameterTypes115 = new String[] { "long", "int", "int" };

		_methodName116 = "countScienceAppsByVocabularyId";

		_methodParameterTypes116 = new String[] { "long" };

		_methodName117 = "retrieveScienceAppsByVocabularyId";

		_methodParameterTypes117 = new String[] { "long" };

		_methodName118 = "retrieveScienceAppsByVocabularyIdStage";

		_methodParameterTypes118 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName119 = "countScienceAppsByVocabularyIdStage";

		_methodParameterTypes119 = new String[] { "long", "java.lang.String" };

		_methodName120 = "retrieveScienceAppsByVocabularyIdStage";

		_methodParameterTypes120 = new String[] { "long", "java.lang.String" };

		_methodName121 = "retrieveScienceAppsByVocabularyIdTarget";

		_methodParameterTypes121 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName122 = "countScienceAppsByVocabularyIdTarget";

		_methodParameterTypes122 = new String[] { "long", "java.lang.String" };

		_methodName123 = "retrieveScienceAppsByVocabularyIdTarget";

		_methodParameterTypes123 = new String[] { "long", "java.lang.String" };

		_methodName124 = "retrieveScienceAppsByVocabularyIdStageTarget";

		_methodParameterTypes124 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName125 = "countScienceAppsByVocabularyIdStageTarget";

		_methodParameterTypes125 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName126 = "retrieveScienceAppsByVocabularyIdStageTarget";

		_methodParameterTypes126 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName127 = "retrieveScienceAppsByCategoryId";

		_methodParameterTypes127 = new String[] { "long", "int", "int" };

		_methodName128 = "countScienceAppsByCategoryId";

		_methodParameterTypes128 = new String[] { "long" };

		_methodName129 = "retrieveScienceAppsByCategoryId";

		_methodParameterTypes129 = new String[] { "long" };

		_methodName130 = "retrieveScienceAppsByCategoryIdStage";

		_methodParameterTypes130 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName131 = "countScienceAppsByCategoryIdStage";

		_methodParameterTypes131 = new String[] { "long", "java.lang.String" };

		_methodName132 = "retrieveScienceAppsByCategoryIdStage";

		_methodParameterTypes132 = new String[] { "long", "java.lang.String" };

		_methodName133 = "retrieveScienceAppsByCategoryIdTarget";

		_methodParameterTypes133 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName134 = "countScienceAppsByCategoryIdTarget";

		_methodParameterTypes134 = new String[] { "long", "java.lang.String" };

		_methodName135 = "retrieveScienceAppsByCategoryIdTarget";

		_methodParameterTypes135 = new String[] { "long", "java.lang.String" };

		_methodName136 = "retrieveScienceAppsByCategoryIdStageTarget";

		_methodParameterTypes136 = new String[] {
				"long", "java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName137 = "countScienceAppsByCategoryIdStageTarget";

		_methodParameterTypes137 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName138 = "retrieveScienceAppsByCategoryIdStageTarget";

		_methodParameterTypes138 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName139 = "existScienceAppPath";

		_methodParameterTypes139 = new String[] { "java.lang.String" };

		_methodName140 = "deleteScienceAppDir";

		_methodParameterTypes140 = new String[] { "java.lang.String" };

		_methodName141 = "makeScienceAppDir";

		_methodParameterTypes141 = new String[] { "java.lang.String" };

		_methodName142 = "saveToScienceAppStorage";

		_methodParameterTypes142 = new String[] {
				"java.lang.String", "java.lang.String", "java.io.InputStream"
			};

		_methodName143 = "unzipScienceAppZipFile";

		_methodParameterTypes143 = new String[] {
				"java.lang.String", "java.lang.String"
			};
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp addScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(scienceApp) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp createScienceApp(
		long scienceAppId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp deleteScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp deleteScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(scienceApp) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp fetchScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp fetchScienceAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp fetchScienceAppByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp getScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp getScienceAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(uuid), companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp getScienceAppByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16,
					new Object[] { ClpSerializer.translateInput(uuid), groupId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceApps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName17,
					_methodParameterTypes17, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getScienceAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName18,
					_methodParameterTypes18, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp updateScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] { ClpSerializer.translateInput(scienceApp) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName21,
				_methodParameterTypes21,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp createScienceApp(
		java.lang.String appName, java.lang.String appVersion,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
					new Object[] {
						ClpSerializer.translateInput(appName),
						
					ClpSerializer.translateInput(appVersion),
						
					ClpSerializer.translateInput(sc)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp copyScienceApp(
		long scienceAppId, com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] { scienceAppId, ClpSerializer.translateInput(
							sc) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp addScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						ClpSerializer.translateInput(scienceApp),
						
					ClpSerializer.translateInput(sc)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setScienceAppInputPorts(long scienceAppId,
		java.lang.String inputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName26,
				_methodParameterTypes26,
				new Object[] {
					scienceAppId,
					
				ClpSerializer.translateInput(inputPorts)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.String getScienceAppInputPorts(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setScienceAppOutputPorts(long scienceAppId,
		java.lang.String outputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName28,
				_methodParameterTypes28,
				new Object[] {
					scienceAppId,
					
				ClpSerializer.translateInput(outputPorts)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.String getScienceAppOutputPorts(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean verifyScienceAppName(java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] { ClpSerializer.translateInput(appName) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean existAppName(java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] { ClpSerializer.translateInput(appName) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean existApp(java.lang.String appName,
		java.lang.String appVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] {
						ClpSerializer.translateInput(appName),
						
					ClpSerializer.translateInput(appVersion)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp getLatestVersion(
		java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] { ClpSerializer.translateInput(appName) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean verifyVersionNumber(java.lang.String appName,
		java.lang.String appVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						ClpSerializer.translateInput(appName),
						
					ClpSerializer.translateInput(appVersion)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void deleteAllScienceApps()
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName35,
				_methodParameterTypes35, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceApp updateScienceApp(
		com.kisti.science.platform.app.model.ScienceApp scienceApp,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36,
					new Object[] {
						ClpSerializer.translateInput(scienceApp),
						
					ClpSerializer.translateInput(sc)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.kisti.science.platform.app.model.ScienceApp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll(
		java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] { ClpSerializer.translateInput(targetLang) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countAll(java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] { ClpSerializer.translateInput(targetLang) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getAll(
		int start, int end, java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
					new Object[] {
						start,
						
					end,
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43, new Object[] { status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44, new Object[] { status });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByStage(
		java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] { ClpSerializer.translateInput(stage) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByStage(java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] { ClpSerializer.translateInput(stage) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByStage(
		java.lang.String stage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] { ClpSerializer.translateInput(stage), start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorIdAppType(
		long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName48,
					_methodParameterTypes48,
					new Object[] { authorId, ClpSerializer.translateInput(
							appType) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName49,
					_methodParameterTypes49,
					new Object[] { ClpSerializer.translateInput(appType) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName50,
					_methodParameterTypes50,
					new Object[] {
						ClpSerializer.translateInput(appType),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType, java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName51,
					_methodParameterTypes51,
					new Object[] {
						ClpSerializer.translateInput(appType),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAppType(
		java.lang.String appType, int start, int end,
		java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName52,
					_methodParameterTypes52,
					new Object[] {
						ClpSerializer.translateInput(appType),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByAppType(java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName53,
					_methodParameterTypes53,
					new Object[] { ClpSerializer.translateInput(appType) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int countScienceAppsByAppType(java.lang.String appType,
		java.lang.String targetLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName54,
					_methodParameterTypes54,
					new Object[] {
						ClpSerializer.translateInput(appType),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorIdAppType(
		long authorId, java.lang.String appClass, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName55,
					_methodParameterTypes55,
					new Object[] {
						authorId,
						
					ClpSerializer.translateInput(appClass),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorId(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName56,
					_methodParameterTypes56, new Object[] { authorId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByAuthorId(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName57,
					_methodParameterTypes57,
					new Object[] { authorId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName58,
					_methodParameterTypes58, new Object[] { authorId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByOpenLevel(
		java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName59,
					_methodParameterTypes59,
					new Object[] { ClpSerializer.translateInput(openLevel) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByOpenLevel(
		java.lang.String openLevel, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName60,
					_methodParameterTypes60,
					new Object[] {
						ClpSerializer.translateInput(openLevel),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByManagerId(
		long managerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName61,
					_methodParameterTypes61, new Object[] { managerId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByManagerId(
		long managerId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName62,
					_methodParameterTypes62,
					new Object[] { managerId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName63,
					_methodParameterTypes63, new Object[] { managerId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public long[] getScienceAppManagerIds(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName64,
					_methodParameterTypes64, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long[] getScienceAppManagerIds(long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName65,
					_methodParameterTypes65,
					new Object[] { scienceAppId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppManagers(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName66,
					_methodParameterTypes66, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName67,
					_methodParameterTypes67, new Object[] { categoryId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName68,
					_methodParameterTypes68,
					new Object[] { categoryId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long[] getScienceAppCategoryIds(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName69,
					_methodParameterTypes69, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long[] getScienceAppCategoryIds(long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName70,
					_methodParameterTypes70,
					new Object[] { scienceAppId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (long[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppCategories(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName71,
					_methodParameterTypes71, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public void assignScienceAppToCategories(long scienceAppId,
		long[] categoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName72,
				_methodParameterTypes72,
				new Object[] {
					scienceAppId,
					
				ClpSerializer.translateInput(categoryIds)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void assignScienceAppToCategory(long scienceAppId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName73,
				_methodParameterTypes73,
				new Object[] { scienceAppId, categoryId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void assignManagersToScienceApp(long scienceAppId, long[] managerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName74,
				_methodParameterTypes74,
				new Object[] {
					scienceAppId,
					
				ClpSerializer.translateInput(managerIds)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void assignManagerToScienceApp(long scienceAppId, long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		try {
			_invokableLocalService.invokeMethod(_methodName75,
				_methodParameterTypes75,
				new Object[] { scienceAppId, managerId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.String getScienceAppBinPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName76,
					_methodParameterTypes76, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getScienceAppSrcPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName77,
					_methodParameterTypes77, new Object[] { scienceAppId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countAllScienceApps()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName78,
					_methodParameterTypes78, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName79,
					_methodParameterTypes79,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName80,
					_methodParameterTypes80,
					new Object[] { ClpSerializer.translateInput(searchTerm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName81,
					_methodParameterTypes81,
					new Object[] { ClpSerializer.translateInput(searchTerm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName82,
					_methodParameterTypes82,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName83,
					_methodParameterTypes83,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName84,
					_methodParameterTypes84,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName85,
					_methodParameterTypes85,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName86,
					_methodParameterTypes86,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName87,
					_methodParameterTypes87,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName88,
					_methodParameterTypes88,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName89,
					_methodParameterTypes89,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName90,
					_methodParameterTypes90,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName91,
					_methodParameterTypes91,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnScreenName(java.lang.String searchTerm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName92,
					_methodParameterTypes92,
					new Object[] { ClpSerializer.translateInput(searchTerm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName93,
					_methodParameterTypes93,
					new Object[] { ClpSerializer.translateInput(searchTerm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName94,
					_methodParameterTypes94,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName95,
					_methodParameterTypes95,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName96,
					_methodParameterTypes96,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName97,
					_methodParameterTypes97,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName98,
					_methodParameterTypes98,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName99,
					_methodParameterTypes99,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName100,
					_methodParameterTypes100,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName101,
					_methodParameterTypes101,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName102,
					_methodParameterTypes102,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName103,
					_methodParameterTypes103,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnAffiliationName(java.lang.String searchTerm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName104,
					_methodParameterTypes104,
					new Object[] { ClpSerializer.translateInput(searchTerm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName105,
					_methodParameterTypes105,
					new Object[] { ClpSerializer.translateInput(searchTerm) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName106,
					_methodParameterTypes106,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName107,
					_methodParameterTypes107,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName108,
					_methodParameterTypes108,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName109,
					_methodParameterTypes109,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName110,
					_methodParameterTypes110,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName111,
					_methodParameterTypes111,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName112,
					_methodParameterTypes112,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName113,
					_methodParameterTypes113,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName114,
					_methodParameterTypes114,
					new Object[] {
						ClpSerializer.translateInput(searchTerm),
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName115,
					_methodParameterTypes115,
					new Object[] { vocabularyId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByVocabularyId(long vocabularyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName116,
					_methodParameterTypes116, new Object[] { vocabularyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName117,
					_methodParameterTypes117, new Object[] { vocabularyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName118,
					_methodParameterTypes118,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(stage),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByVocabularyIdStage(long vocabularyId,
		java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName119,
					_methodParameterTypes119,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName120,
					_methodParameterTypes120,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(stage)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName121,
					_methodParameterTypes121,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByVocabularyIdTarget(long vocabularyId,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName122,
					_methodParameterTypes122,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName123,
					_methodParameterTypes123,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang,
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName124,
					_methodParameterTypes124,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByVocabularyIdStageTarget(long vocabularyId,
		java.lang.String stage, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName125,
					_methodParameterTypes125,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName126,
					_methodParameterTypes126,
					new Object[] {
						vocabularyId,
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName127,
					_methodParameterTypes127,
					new Object[] { categoryId, start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByCategoryId(long categoryId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName128,
					_methodParameterTypes128, new Object[] { categoryId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName129,
					_methodParameterTypes129, new Object[] { categoryId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName130,
					_methodParameterTypes130,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(stage),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByCategoryIdStage(long categoryId,
		java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName131,
					_methodParameterTypes131,
					new Object[] { categoryId, ClpSerializer.translateInput(
							stage) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName132,
					_methodParameterTypes132,
					new Object[] { categoryId, ClpSerializer.translateInput(
							stage) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName133,
					_methodParameterTypes133,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByCategoryIdTarget(long categoryId,
		java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName134,
					_methodParameterTypes134,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName135,
					_methodParameterTypes135,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang,
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName136,
					_methodParameterTypes136,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countScienceAppsByCategoryIdStageTarget(long categoryId,
		java.lang.String stage, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName137,
					_methodParameterTypes137,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName138,
					_methodParameterTypes138,
					new Object[] {
						categoryId,
						
					ClpSerializer.translateInput(stage),
						
					ClpSerializer.translateInput(targetLang)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.kisti.science.platform.app.model.ScienceApp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean existScienceAppPath(java.lang.String targetPath)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName139,
					_methodParameterTypes139,
					new Object[] { ClpSerializer.translateInput(targetPath) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.io.IOException) {
				throw (java.io.IOException)t;
			}

			if (t instanceof java.lang.InterruptedException) {
				throw (java.lang.InterruptedException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void deleteScienceAppDir(java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		try {
			_invokableLocalService.invokeMethod(_methodName140,
				_methodParameterTypes140,
				new Object[] { ClpSerializer.translateInput(targetDir) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.io.IOException) {
				throw (java.io.IOException)t;
			}

			if (t instanceof java.lang.InterruptedException) {
				throw (java.lang.InterruptedException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void makeScienceAppDir(java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		try {
			_invokableLocalService.invokeMethod(_methodName141,
				_methodParameterTypes141,
				new Object[] { ClpSerializer.translateInput(targetDir) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.io.IOException) {
				throw (java.io.IOException)t;
			}

			if (t instanceof java.lang.InterruptedException) {
				throw (java.lang.InterruptedException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.io.File saveToScienceAppStorage(java.lang.String targetDir,
		java.lang.String fileName, java.io.InputStream uploadedInputStream)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName142,
					_methodParameterTypes142,
					new Object[] {
						ClpSerializer.translateInput(targetDir),
						
					ClpSerializer.translateInput(fileName),
						
					ClpSerializer.translateInput(uploadedInputStream)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.io.IOException) {
				throw (java.io.IOException)t;
			}

			if (t instanceof java.lang.InterruptedException) {
				throw (java.lang.InterruptedException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.io.File)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void unzipScienceAppZipFile(java.lang.String sourcePath,
		java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException {
		try {
			_invokableLocalService.invokeMethod(_methodName143,
				_methodParameterTypes143,
				new Object[] {
					ClpSerializer.translateInput(sourcePath),
					
				ClpSerializer.translateInput(targetDir)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.io.IOException) {
				throw (java.io.IOException)t;
			}

			if (t instanceof java.lang.InterruptedException) {
				throw (java.lang.InterruptedException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableLocalService _invokableLocalService;
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
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
	private String _methodName83;
	private String[] _methodParameterTypes83;
	private String _methodName84;
	private String[] _methodParameterTypes84;
	private String _methodName85;
	private String[] _methodParameterTypes85;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
	private String _methodName89;
	private String[] _methodParameterTypes89;
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
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
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
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
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
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
}