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

package org.kisti.edison.bestsimulation.service.base;

import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class SimulationJobLocalServiceClpInvoker {
	public SimulationJobLocalServiceClpInvoker() {
		_methodName0 = "addSimulationJob";

		_methodParameterTypes0 = new String[] {
				"org.kisti.edison.bestsimulation.model.SimulationJob"
			};

		_methodName1 = "createSimulationJob";

		_methodParameterTypes1 = new String[] {
				"org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK"
			};

		_methodName2 = "deleteSimulationJob";

		_methodParameterTypes2 = new String[] {
				"org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK"
			};

		_methodName3 = "deleteSimulationJob";

		_methodParameterTypes3 = new String[] {
				"org.kisti.edison.bestsimulation.model.SimulationJob"
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

		_methodName10 = "fetchSimulationJob";

		_methodParameterTypes10 = new String[] {
				"org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK"
			};

		_methodName11 = "getSimulationJob";

		_methodParameterTypes11 = new String[] {
				"org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getSimulationJobs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSimulationJobsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSimulationJob";

		_methodParameterTypes15 = new String[] {
				"org.kisti.edison.bestsimulation.model.SimulationJob"
			};

		_methodName54 = "getBeanIdentifier";

		_methodParameterTypes54 = new String[] {  };

		_methodName55 = "setBeanIdentifier";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName60 = "getMaxJobSeqNoSimulationJob";

		_methodParameterTypes60 = new String[] { "long", "java.lang.String" };

		_methodName61 = "deleteSimulationJob";

		_methodParameterTypes61 = new String[] {
				"long", "java.lang.String", "long", "long"
			};

		_methodName62 = "deleteSimulationParameter";

		_methodParameterTypes62 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName63 = "deleteSimulationCommandOption";

		_methodParameterTypes63 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName64 = "getListSimulationJob";

		_methodParameterTypes64 = new String[] {
				"long", "java.lang.String", "long", "long", "java.util.Locale"
			};

		_methodName65 = "getMonitoringList";

		_methodParameterTypes65 = new String[] {
				"long", "long", "long", "long", "java.lang.String", "long",
				"int", "int"
			};

		_methodName66 = "getMonitoringJobList";

		_methodParameterTypes66 = new String[] { "long", "java.lang.String" };

		_methodName67 = "getMonitoringJob";

		_methodParameterTypes67 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName69 = "getMonitoringCount";

		_methodParameterTypes69 = new String[] {
				"long", "long", "long", "long", "java.lang.String", "long"
			};

		_methodName70 = "deleteMonitoringByJobClassId";

		_methodParameterTypes70 = new String[] {
				"long", "long", "com.liferay.portal.model.User"
			};

		_methodName71 = "deleteMonitoring";

		_methodParameterTypes71 = new String[] {
				"java.lang.String", "long", "long",
				"com.liferay.portal.model.User"
			};

		_methodName73 = "getMaxStatusSeqSimulationJobStatus";

		_methodParameterTypes73 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName74 = "getStatusSimulationJobStatus";

		_methodParameterTypes74 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName75 = "getListVirtualLabSearchUni";

		_methodParameterTypes75 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName76 = "getListVirtualClassSearchLab";

		_methodParameterTypes76 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName77 = "getStatisticsExecTableOrganigation";

		_methodParameterTypes77 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName78 = "getStatisticsExecPieChartOrganigation";

		_methodParameterTypes78 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName79 = "getStatisticsExecBarChartDate";

		_methodParameterTypes79 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName80 = "getStatisticsSwTableOrganigation";

		_methodParameterTypes80 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName81 = "getStatisticsSwBarChartDate";

		_methodParameterTypes81 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"long"
			};

		_methodName82 = "getStatisticsSwExeTableOrganigation";

		_methodParameterTypes82 = new String[] {
				"long", "java.lang.String", "long", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName83 = "getStatisticsSwExeBarChartDate";

		_methodParameterTypes83 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "long"
			};

		_methodName84 = "getStatisticsTimeTableOrganigation";

		_methodParameterTypes84 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName85 = "getStatisticsUserTableOrganigation";

		_methodParameterTypes85 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName86 = "getStatisticsUserPieChartOrganigation";

		_methodParameterTypes86 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName87 = "getStatisticsUserBarChartDate";

		_methodParameterTypes87 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SimulationJobLocalServiceUtil.addSimulationJob((org.kisti.edison.bestsimulation.model.SimulationJob)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SimulationJobLocalServiceUtil.createSimulationJob((org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SimulationJobLocalServiceUtil.deleteSimulationJob((org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SimulationJobLocalServiceUtil.deleteSimulationJob((org.kisti.edison.bestsimulation.model.SimulationJob)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SimulationJobLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SimulationJobLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SimulationJobLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SimulationJobLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SimulationJobLocalServiceUtil.fetchSimulationJob((org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getSimulationJob((org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getSimulationJobs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getSimulationJobsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SimulationJobLocalServiceUtil.updateSimulationJob((org.kisti.edison.bestsimulation.model.SimulationJob)arguments[0]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			SimulationJobLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getMaxJobSeqNoSimulationJob(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return SimulationJobLocalServiceUtil.deleteSimulationJob(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return SimulationJobLocalServiceUtil.deleteSimulationParameter(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return SimulationJobLocalServiceUtil.deleteSimulationCommandOption(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getListSimulationJob(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(), (java.util.Locale)arguments[4]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getMonitoringList(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getMonitoringJobList(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getMonitoringJob(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getMonitoringCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], ((Long)arguments[5]).longValue());
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return SimulationJobLocalServiceUtil.deleteMonitoringByJobClassId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.model.User)arguments[2]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return SimulationJobLocalServiceUtil.deleteMonitoring((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.model.User)arguments[3]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getMaxStatusSeqSimulationJobStatus(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatusSimulationJobStatus(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getListVirtualLabSearchUni(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getListVirtualClassSearchLab(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsExecTableOrganigation(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsExecPieChartOrganigation(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsExecBarChartDate(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsSwTableOrganigation(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], ((Long)arguments[6]).longValue());
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsSwBarChartDate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Long)arguments[5]).longValue());
		}

		if (_methodName82.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes82, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsSwExeTableOrganigation(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Long)arguments[5]).longValue());
		}

		if (_methodName83.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes83, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsSwExeBarChartDate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Long)arguments[4]).longValue());
		}

		if (_methodName84.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes84, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsTimeTableOrganigation(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName85.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes85, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsUserTableOrganigation(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsUserPieChartOrganigation(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return SimulationJobLocalServiceUtil.getStatisticsUserBarChartDate(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
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
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
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
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
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
}