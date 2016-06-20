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

import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class VirtualLabClassLocalServiceClpInvoker {
	public VirtualLabClassLocalServiceClpInvoker() {
		_methodName0 = "addVirtualLabClass";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName1 = "createVirtualLabClass";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteVirtualLabClass";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteVirtualLabClass";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
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

		_methodName10 = "fetchVirtualLabClass";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getVirtualLabClass";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getVirtualLabClasses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getVirtualLabClassesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateVirtualLabClass";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName16 = "addVirtualLabVirtualLabClass";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addVirtualLabVirtualLabClass";

		_methodParameterTypes17 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName18 = "addVirtualLabVirtualLabClasses";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addVirtualLabVirtualLabClasses";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearVirtualLabVirtualLabClasses";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteVirtualLabVirtualLabClass";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteVirtualLabVirtualLabClass";

		_methodParameterTypes22 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName23 = "deleteVirtualLabVirtualLabClasses";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteVirtualLabVirtualLabClasses";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getVirtualLabVirtualLabClasses";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getVirtualLabVirtualLabClasses";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getVirtualLabVirtualLabClasses";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getVirtualLabVirtualLabClassesCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasVirtualLabVirtualLabClass";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasVirtualLabVirtualLabClasses";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setVirtualLabVirtualLabClasses";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName32 = "addVirtualLabClassScienceAppVirtualLabClass";

		_methodParameterTypes32 = new String[] { "long", "long" };

		_methodName33 = "addVirtualLabClassScienceAppVirtualLabClass";

		_methodParameterTypes33 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName34 = "addVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes34 = new String[] { "long", "long[][]" };

		_methodName35 = "addVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes35 = new String[] { "long", "java.util.List" };

		_methodName36 = "clearVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes36 = new String[] { "long" };

		_methodName37 = "deleteVirtualLabClassScienceAppVirtualLabClass";

		_methodParameterTypes37 = new String[] { "long", "long" };

		_methodName38 = "deleteVirtualLabClassScienceAppVirtualLabClass";

		_methodParameterTypes38 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName39 = "deleteVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes39 = new String[] { "long", "long[][]" };

		_methodName40 = "deleteVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes40 = new String[] { "long", "java.util.List" };

		_methodName41 = "getVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes41 = new String[] { "long" };

		_methodName42 = "getVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes42 = new String[] { "long", "int", "int" };

		_methodName43 = "getVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes43 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName44 = "getVirtualLabClassScienceAppVirtualLabClassesCount";

		_methodParameterTypes44 = new String[] { "long" };

		_methodName45 = "hasVirtualLabClassScienceAppVirtualLabClass";

		_methodParameterTypes45 = new String[] { "long", "long" };

		_methodName46 = "hasVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes46 = new String[] { "long" };

		_methodName47 = "setVirtualLabClassScienceAppVirtualLabClasses";

		_methodParameterTypes47 = new String[] { "long", "long[][]" };

		_methodName48 = "addVirtualLabUserVirtualLabClass";

		_methodParameterTypes48 = new String[] { "long", "long" };

		_methodName49 = "addVirtualLabUserVirtualLabClass";

		_methodParameterTypes49 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName50 = "addVirtualLabUserVirtualLabClasses";

		_methodParameterTypes50 = new String[] { "long", "long[][]" };

		_methodName51 = "addVirtualLabUserVirtualLabClasses";

		_methodParameterTypes51 = new String[] { "long", "java.util.List" };

		_methodName52 = "clearVirtualLabUserVirtualLabClasses";

		_methodParameterTypes52 = new String[] { "long" };

		_methodName53 = "deleteVirtualLabUserVirtualLabClass";

		_methodParameterTypes53 = new String[] { "long", "long" };

		_methodName54 = "deleteVirtualLabUserVirtualLabClass";

		_methodParameterTypes54 = new String[] {
				"long",
				"org.kisti.edison.virtuallaboratory.model.VirtualLabClass"
			};

		_methodName55 = "deleteVirtualLabUserVirtualLabClasses";

		_methodParameterTypes55 = new String[] { "long", "long[][]" };

		_methodName56 = "deleteVirtualLabUserVirtualLabClasses";

		_methodParameterTypes56 = new String[] { "long", "java.util.List" };

		_methodName57 = "getVirtualLabUserVirtualLabClasses";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "getVirtualLabUserVirtualLabClasses";

		_methodParameterTypes58 = new String[] { "long", "int", "int" };

		_methodName59 = "getVirtualLabUserVirtualLabClasses";

		_methodParameterTypes59 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName60 = "getVirtualLabUserVirtualLabClassesCount";

		_methodParameterTypes60 = new String[] { "long" };

		_methodName61 = "hasVirtualLabUserVirtualLabClass";

		_methodParameterTypes61 = new String[] { "long", "long" };

		_methodName62 = "hasVirtualLabUserVirtualLabClasses";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "setVirtualLabUserVirtualLabClasses";

		_methodParameterTypes63 = new String[] { "long", "long[][]" };

		_methodName134 = "getBeanIdentifier";

		_methodParameterTypes134 = new String[] {  };

		_methodName135 = "setBeanIdentifier";

		_methodParameterTypes135 = new String[] { "java.lang.String" };

		_methodName140 = "getVirtualClassMainVisual";

		_methodParameterTypes140 = new String[] { "long", "java.util.Locale" };

		_methodName141 = "getVirtualLabClassInfo";

		_methodParameterTypes141 = new String[] { "long", "java.util.Locale" };

		_methodName142 = "getVirtualClassList";

		_methodParameterTypes142 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName143 = "getVirtualClassListCount";

		_methodParameterTypes143 = new String[] { "java.util.Map" };

		_methodName144 = "insertVirtualLabClass";

		_methodParameterTypes144 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName145 = "getListVirtualLabClass";

		_methodParameterTypes145 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName146 = "getListVirtualLabClass2";

		_methodParameterTypes146 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName147 = "getCountVirtualLabClass";

		_methodParameterTypes147 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName148 = "getCountVirtualLabClass2";

		_methodParameterTypes148 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName149 = "updateVirtualLabClassDisable";

		_methodParameterTypes149 = new String[] { "long", "java.lang.String" };

		_methodName150 = "getVirtualClassBoardSeqList";

		_methodParameterTypes150 = new String[] { "long", "long" };

		_methodName151 = "getVirtualClassStatisticsList";

		_methodParameterTypes151 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName152 = "getCountVirtualClassStatistics";

		_methodParameterTypes152 = new String[] {
				"java.util.Map", "java.util.Locale"
			};

		_methodName153 = "getVirtualClassStatisticsExcelList";

		_methodParameterTypes153 = new String[] {
				"java.util.Map", "java.util.Locale"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.addVirtualLabClass((org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.createVirtualLabClass(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.deleteVirtualLabClass(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.deleteVirtualLabClass((org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.fetchVirtualLabClass(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClass(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClasses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClassesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.updateVirtualLabClass((org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabVirtualLabClass(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.clearVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabVirtualLabClass(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabVirtualLabClassesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.hasVirtualLabVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.hasVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.setVirtualLabVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabClassScienceAppVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabClassScienceAppVirtualLabClass(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[1]);

			return null;
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass>)arguments[1]);

			return null;
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.clearVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabClassScienceAppVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabClassScienceAppVirtualLabClass(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[1]);

			return null;
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass>)arguments[1]);

			return null;
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue());
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClassScienceAppVirtualLabClassesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.hasVirtualLabClassScienceAppVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.hasVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.setVirtualLabClassScienceAppVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabUserVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabUserVirtualLabClass(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[1]);

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.addVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass>)arguments[1]);

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.clearVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabUserVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabUserVirtualLabClass(((Long)arguments[0]).longValue(),
				(org.kisti.edison.virtuallaboratory.model.VirtualLabClass)arguments[1]);

			return null;
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.deleteVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass>)arguments[1]);

			return null;
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabUserVirtualLabClassesCount(((Long)arguments[0]).longValue());
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.hasVirtualLabUserVirtualLabClass(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.hasVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.setVirtualLabUserVirtualLabClasses(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			VirtualLabClassLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualClassMainVisual(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualLabClassInfo(((Long)arguments[0]).longValue(),
				(java.util.Locale)arguments[1]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualClassList((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualClassListCount((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.insertVirtualLabClass((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getListVirtualLabClass((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getListVirtualLabClass2((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getCountVirtualLabClass((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getCountVirtualLabClass2((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.updateVirtualLabClassDisable(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualClassBoardSeqList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualClassStatisticsList((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getCountVirtualClassStatistics((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return VirtualLabClassLocalServiceUtil.getVirtualClassStatisticsExcelList((java.util.Map<java.lang.String, java.lang.Object>)arguments[0],
				(java.util.Locale)arguments[1]);
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
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
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
}