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

package org.kisti.edison.service.base;

import org.kisti.edison.service.WorkflowLocalServiceUtil;

import java.util.Arrays;

/**
 * @author EDISON
 * @generated
 */
public class WorkflowLocalServiceClpInvoker {
	public WorkflowLocalServiceClpInvoker() {
		_methodName0 = "addWorkflow";

		_methodParameterTypes0 = new String[] { "org.kisti.edison.model.Workflow" };

		_methodName1 = "createWorkflow";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteWorkflow";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteWorkflow";

		_methodParameterTypes3 = new String[] { "org.kisti.edison.model.Workflow" };

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

		_methodName10 = "fetchWorkflow";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getWorkflow";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getWorkflows";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getWorkflowsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateWorkflow";

		_methodParameterTypes15 = new String[] { "org.kisti.edison.model.Workflow" };

		_methodName16 = "addWorkflowInstanceWorkflow";

		_methodParameterTypes16 = new String[] { "long", "long" };

		_methodName17 = "addWorkflowInstanceWorkflow";

		_methodParameterTypes17 = new String[] {
				"long", "org.kisti.edison.model.Workflow"
			};

		_methodName18 = "addWorkflowInstanceWorkflows";

		_methodParameterTypes18 = new String[] { "long", "long[][]" };

		_methodName19 = "addWorkflowInstanceWorkflows";

		_methodParameterTypes19 = new String[] { "long", "java.util.List" };

		_methodName20 = "clearWorkflowInstanceWorkflows";

		_methodParameterTypes20 = new String[] { "long" };

		_methodName21 = "deleteWorkflowInstanceWorkflow";

		_methodParameterTypes21 = new String[] { "long", "long" };

		_methodName22 = "deleteWorkflowInstanceWorkflow";

		_methodParameterTypes22 = new String[] {
				"long", "org.kisti.edison.model.Workflow"
			};

		_methodName23 = "deleteWorkflowInstanceWorkflows";

		_methodParameterTypes23 = new String[] { "long", "long[][]" };

		_methodName24 = "deleteWorkflowInstanceWorkflows";

		_methodParameterTypes24 = new String[] { "long", "java.util.List" };

		_methodName25 = "getWorkflowInstanceWorkflows";

		_methodParameterTypes25 = new String[] { "long" };

		_methodName26 = "getWorkflowInstanceWorkflows";

		_methodParameterTypes26 = new String[] { "long", "int", "int" };

		_methodName27 = "getWorkflowInstanceWorkflows";

		_methodParameterTypes27 = new String[] {
				"long", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName28 = "getWorkflowInstanceWorkflowsCount";

		_methodParameterTypes28 = new String[] { "long" };

		_methodName29 = "hasWorkflowInstanceWorkflow";

		_methodParameterTypes29 = new String[] { "long", "long" };

		_methodName30 = "hasWorkflowInstanceWorkflows";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "setWorkflowInstanceWorkflows";

		_methodParameterTypes31 = new String[] { "long", "long[][]" };

		_methodName54 = "getBeanIdentifier";

		_methodParameterTypes54 = new String[] {  };

		_methodName55 = "setBeanIdentifier";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName60 = "createWorkflow";

		_methodParameterTypes60 = new String[] {
				"java.lang.String", "java.lang.String",
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName61 = "createWorkflow";

		_methodParameterTypes61 = new String[] {  };

		_methodName62 = "copyWorkflow";

		_methodParameterTypes62 = new String[] {
				"long", "javax.servlet.http.HttpServletRequest"
			};

		_methodName63 = "updateWorkflow";

		_methodParameterTypes63 = new String[] { "long", "java.util.Map" };

		_methodName64 = "retrieveWorkflows";

		_methodParameterTypes64 = new String[] { "java.util.Map" };

		_methodName65 = "runWorkflow";

		_methodParameterTypes65 = new String[] {
				"long", "java.util.Map", "javax.servlet.http.HttpServletRequest"
			};

		_methodName66 = "createWorkflow";

		_methodParameterTypes66 = new String[] {
				"long", "java.util.Map", "javax.servlet.http.HttpServletRequest"
			};

		_methodName69 = "uploadFileToWorkflowEngine";

		_methodParameterTypes69 = new String[] { "java.lang.String" };

		_methodName70 = "getIceBreakAccessToken";

		_methodParameterTypes70 = new String[] {
				"javax.servlet.http.HttpServletRequest"
			};

		_methodName71 = "getWorkflowsByLikeSearch";

		_methodParameterTypes71 = new String[] { "java.util.Map" };

		_methodName72 = "getCountWorkflowsByLikeSearch";

		_methodParameterTypes72 = new String[] { "java.util.Map" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return WorkflowLocalServiceUtil.addWorkflow((org.kisti.edison.model.Workflow)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return WorkflowLocalServiceUtil.createWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return WorkflowLocalServiceUtil.deleteWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return WorkflowLocalServiceUtil.deleteWorkflow((org.kisti.edison.model.Workflow)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return WorkflowLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return WorkflowLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return WorkflowLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return WorkflowLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return WorkflowLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return WorkflowLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return WorkflowLocalServiceUtil.fetchWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return WorkflowLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflows(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflowsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return WorkflowLocalServiceUtil.updateWorkflow((org.kisti.edison.model.Workflow)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			WorkflowLocalServiceUtil.addWorkflowInstanceWorkflow(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			WorkflowLocalServiceUtil.addWorkflowInstanceWorkflow(((Long)arguments[0]).longValue(),
				(org.kisti.edison.model.Workflow)arguments[1]);

			return null;
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			WorkflowLocalServiceUtil.addWorkflowInstanceWorkflows(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			WorkflowLocalServiceUtil.addWorkflowInstanceWorkflows(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.model.Workflow>)arguments[1]);

			return null;
		}

		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			WorkflowLocalServiceUtil.clearWorkflowInstanceWorkflows(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			WorkflowLocalServiceUtil.deleteWorkflowInstanceWorkflow(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			WorkflowLocalServiceUtil.deleteWorkflowInstanceWorkflow(((Long)arguments[0]).longValue(),
				(org.kisti.edison.model.Workflow)arguments[1]);

			return null;
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			WorkflowLocalServiceUtil.deleteWorkflowInstanceWorkflows(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName24.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
			WorkflowLocalServiceUtil.deleteWorkflowInstanceWorkflows(((Long)arguments[0]).longValue(),
				(java.util.List<org.kisti.edison.model.Workflow>)arguments[1]);

			return null;
		}

		if (_methodName25.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflowInstanceWorkflows(((Long)arguments[0]).longValue());
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflowInstanceWorkflows(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflowInstanceWorkflows(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflowInstanceWorkflowsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return WorkflowLocalServiceUtil.hasWorkflowInstanceWorkflow(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return WorkflowLocalServiceUtil.hasWorkflowInstanceWorkflows(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			WorkflowLocalServiceUtil.setWorkflowInstanceWorkflows(((Long)arguments[0]).longValue(),
				(long[])arguments[1]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return WorkflowLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			WorkflowLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return WorkflowLocalServiceUtil.createWorkflow((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(javax.servlet.http.HttpServletRequest)arguments[2]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return WorkflowLocalServiceUtil.createWorkflow();
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return WorkflowLocalServiceUtil.copyWorkflow(((Long)arguments[0]).longValue(),
				(javax.servlet.http.HttpServletRequest)arguments[1]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return WorkflowLocalServiceUtil.updateWorkflow(((Long)arguments[0]).longValue(),
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return WorkflowLocalServiceUtil.retrieveWorkflows((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return WorkflowLocalServiceUtil.runWorkflow(((Long)arguments[0]).longValue(),
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(javax.servlet.http.HttpServletRequest)arguments[2]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return WorkflowLocalServiceUtil.createWorkflow(((Long)arguments[0]).longValue(),
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(javax.servlet.http.HttpServletRequest)arguments[2]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return WorkflowLocalServiceUtil.uploadFileToWorkflowEngine((java.lang.String)arguments[0]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return WorkflowLocalServiceUtil.getIceBreakAccessToken((javax.servlet.http.HttpServletRequest)arguments[0]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return WorkflowLocalServiceUtil.getWorkflowsByLikeSearch((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return WorkflowLocalServiceUtil.getCountWorkflowsByLikeSearch((java.util.Map<java.lang.String, java.lang.Object>)arguments[0]);
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
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
}