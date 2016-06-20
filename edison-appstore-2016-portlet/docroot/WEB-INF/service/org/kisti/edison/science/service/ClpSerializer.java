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

package org.kisti.edison.science.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.kisti.edison.science.model.CommonLibClp;
import org.kisti.edison.science.model.CommonModuleClp;
import org.kisti.edison.science.model.DeveloperInfoClp;
import org.kisti.edison.science.model.DeveloperIpClp;
import org.kisti.edison.science.model.DeveloperRequestClp;
import org.kisti.edison.science.model.PortTypeAnalyzerLinkClp;
import org.kisti.edison.science.model.PortTypeClp;
import org.kisti.edison.science.model.PortTypeEditorLinkClp;
import org.kisti.edison.science.model.PortTypeInputdeckFormClp;
import org.kisti.edison.science.model.RequiredLibClp;
import org.kisti.edison.science.model.RequiredLibConfirmClp;
import org.kisti.edison.science.model.RequiredModuleClp;
import org.kisti.edison.science.model.ScienceAppCategoryLinkClp;
import org.kisti.edison.science.model.ScienceAppClp;
import org.kisti.edison.science.model.ScienceAppDescriptionClp;
import org.kisti.edison.science.model.ScienceAppFavoriteClp;
import org.kisti.edison.science.model.ScienceAppInputPortsClp;
import org.kisti.edison.science.model.ScienceAppManagerClp;
import org.kisti.edison.science.model.ScienceAppOutputPortsClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EDISON
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"edison-appstore-2016-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"edison-appstore-2016-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "edison-appstore-2016-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CommonLibClp.class.getName())) {
			return translateInputCommonLib(oldModel);
		}

		if (oldModelClassName.equals(CommonModuleClp.class.getName())) {
			return translateInputCommonModule(oldModel);
		}

		if (oldModelClassName.equals(DeveloperInfoClp.class.getName())) {
			return translateInputDeveloperInfo(oldModel);
		}

		if (oldModelClassName.equals(DeveloperIpClp.class.getName())) {
			return translateInputDeveloperIp(oldModel);
		}

		if (oldModelClassName.equals(DeveloperRequestClp.class.getName())) {
			return translateInputDeveloperRequest(oldModel);
		}

		if (oldModelClassName.equals(PortTypeClp.class.getName())) {
			return translateInputPortType(oldModel);
		}

		if (oldModelClassName.equals(PortTypeAnalyzerLinkClp.class.getName())) {
			return translateInputPortTypeAnalyzerLink(oldModel);
		}

		if (oldModelClassName.equals(PortTypeEditorLinkClp.class.getName())) {
			return translateInputPortTypeEditorLink(oldModel);
		}

		if (oldModelClassName.equals(PortTypeInputdeckFormClp.class.getName())) {
			return translateInputPortTypeInputdeckForm(oldModel);
		}

		if (oldModelClassName.equals(RequiredLibClp.class.getName())) {
			return translateInputRequiredLib(oldModel);
		}

		if (oldModelClassName.equals(RequiredLibConfirmClp.class.getName())) {
			return translateInputRequiredLibConfirm(oldModel);
		}

		if (oldModelClassName.equals(RequiredModuleClp.class.getName())) {
			return translateInputRequiredModule(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppClp.class.getName())) {
			return translateInputScienceApp(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppCategoryLinkClp.class.getName())) {
			return translateInputScienceAppCategoryLink(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppDescriptionClp.class.getName())) {
			return translateInputScienceAppDescription(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppFavoriteClp.class.getName())) {
			return translateInputScienceAppFavorite(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppInputPortsClp.class.getName())) {
			return translateInputScienceAppInputPorts(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppManagerClp.class.getName())) {
			return translateInputScienceAppManager(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppOutputPortsClp.class.getName())) {
			return translateInputScienceAppOutputPorts(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCommonLib(BaseModel<?> oldModel) {
		CommonLibClp oldClpModel = (CommonLibClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommonLibRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCommonModule(BaseModel<?> oldModel) {
		CommonModuleClp oldClpModel = (CommonModuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommonModuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDeveloperInfo(BaseModel<?> oldModel) {
		DeveloperInfoClp oldClpModel = (DeveloperInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDeveloperInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDeveloperIp(BaseModel<?> oldModel) {
		DeveloperIpClp oldClpModel = (DeveloperIpClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDeveloperIpRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDeveloperRequest(BaseModel<?> oldModel) {
		DeveloperRequestClp oldClpModel = (DeveloperRequestClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDeveloperRequestRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPortType(BaseModel<?> oldModel) {
		PortTypeClp oldClpModel = (PortTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPortTypeAnalyzerLink(
		BaseModel<?> oldModel) {
		PortTypeAnalyzerLinkClp oldClpModel = (PortTypeAnalyzerLinkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortTypeAnalyzerLinkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPortTypeEditorLink(BaseModel<?> oldModel) {
		PortTypeEditorLinkClp oldClpModel = (PortTypeEditorLinkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortTypeEditorLinkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPortTypeInputdeckForm(
		BaseModel<?> oldModel) {
		PortTypeInputdeckFormClp oldClpModel = (PortTypeInputdeckFormClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortTypeInputdeckFormRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRequiredLib(BaseModel<?> oldModel) {
		RequiredLibClp oldClpModel = (RequiredLibClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRequiredLibRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRequiredLibConfirm(BaseModel<?> oldModel) {
		RequiredLibConfirmClp oldClpModel = (RequiredLibConfirmClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRequiredLibConfirmRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRequiredModule(BaseModel<?> oldModel) {
		RequiredModuleClp oldClpModel = (RequiredModuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRequiredModuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScienceApp(BaseModel<?> oldModel) {
		ScienceAppClp oldClpModel = (ScienceAppClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScienceAppRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScienceAppCategoryLink(
		BaseModel<?> oldModel) {
		ScienceAppCategoryLinkClp oldClpModel = (ScienceAppCategoryLinkClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScienceAppCategoryLinkRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScienceAppDescription(
		BaseModel<?> oldModel) {
		ScienceAppDescriptionClp oldClpModel = (ScienceAppDescriptionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScienceAppDescriptionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScienceAppFavorite(BaseModel<?> oldModel) {
		ScienceAppFavoriteClp oldClpModel = (ScienceAppFavoriteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScienceAppFavoriteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScienceAppInputPorts(
		BaseModel<?> oldModel) {
		ScienceAppInputPortsClp oldClpModel = (ScienceAppInputPortsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScienceAppInputPortsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScienceAppManager(BaseModel<?> oldModel) {
		ScienceAppManagerClp oldClpModel = (ScienceAppManagerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScienceAppManagerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputScienceAppOutputPorts(
		BaseModel<?> oldModel) {
		ScienceAppOutputPortsClp oldClpModel = (ScienceAppOutputPortsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getScienceAppOutputPortsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.CommonLibImpl")) {
			return translateOutputCommonLib(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.CommonModuleImpl")) {
			return translateOutputCommonModule(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.DeveloperInfoImpl")) {
			return translateOutputDeveloperInfo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.DeveloperIpImpl")) {
			return translateOutputDeveloperIp(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.DeveloperRequestImpl")) {
			return translateOutputDeveloperRequest(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.PortTypeImpl")) {
			return translateOutputPortType(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkImpl")) {
			return translateOutputPortTypeAnalyzerLink(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.PortTypeEditorLinkImpl")) {
			return translateOutputPortTypeEditorLink(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.PortTypeInputdeckFormImpl")) {
			return translateOutputPortTypeInputdeckForm(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.RequiredLibImpl")) {
			return translateOutputRequiredLib(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.RequiredLibConfirmImpl")) {
			return translateOutputRequiredLibConfirm(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.RequiredModuleImpl")) {
			return translateOutputRequiredModule(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.ScienceAppImpl")) {
			return translateOutputScienceApp(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.ScienceAppCategoryLinkImpl")) {
			return translateOutputScienceAppCategoryLink(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.ScienceAppDescriptionImpl")) {
			return translateOutputScienceAppDescription(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.ScienceAppFavoriteImpl")) {
			return translateOutputScienceAppFavorite(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.ScienceAppInputPortsImpl")) {
			return translateOutputScienceAppInputPorts(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.ScienceAppManagerImpl")) {
			return translateOutputScienceAppManager(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"org.kisti.edison.science.model.impl.ScienceAppOutputPortsImpl")) {
			return translateOutputScienceAppOutputPorts(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchCommonLibException")) {
			return new org.kisti.edison.science.NoSuchCommonLibException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchCommonModuleException")) {
			return new org.kisti.edison.science.NoSuchCommonModuleException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchDeveloperInfoException")) {
			return new org.kisti.edison.science.NoSuchDeveloperInfoException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchDeveloperIpException")) {
			return new org.kisti.edison.science.NoSuchDeveloperIpException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchDeveloperRequestException")) {
			return new org.kisti.edison.science.NoSuchDeveloperRequestException();
		}

		if (className.equals("org.kisti.edison.science.NoSuchPortTypeException")) {
			return new org.kisti.edison.science.NoSuchPortTypeException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException")) {
			return new org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchPortTypeEditorLinkException")) {
			return new org.kisti.edison.science.NoSuchPortTypeEditorLinkException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchPortTypeInputdeckFormException")) {
			return new org.kisti.edison.science.NoSuchPortTypeInputdeckFormException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchRequiredLibException")) {
			return new org.kisti.edison.science.NoSuchRequiredLibException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchRequiredLibConfirmException")) {
			return new org.kisti.edison.science.NoSuchRequiredLibConfirmException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchRequiredModuleException")) {
			return new org.kisti.edison.science.NoSuchRequiredModuleException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchScienceAppException")) {
			return new org.kisti.edison.science.NoSuchScienceAppException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchScienceAppCategoryLinkException")) {
			return new org.kisti.edison.science.NoSuchScienceAppCategoryLinkException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchScienceAppDescriptionException")) {
			return new org.kisti.edison.science.NoSuchScienceAppDescriptionException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchScienceAppFavoriteException")) {
			return new org.kisti.edison.science.NoSuchScienceAppFavoriteException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchScienceAppInputPortsException")) {
			return new org.kisti.edison.science.NoSuchScienceAppInputPortsException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchScienceAppManagerException")) {
			return new org.kisti.edison.science.NoSuchScienceAppManagerException();
		}

		if (className.equals(
					"org.kisti.edison.science.NoSuchScienceAppOutputPortsException")) {
			return new org.kisti.edison.science.NoSuchScienceAppOutputPortsException();
		}

		return throwable;
	}

	public static Object translateOutputCommonLib(BaseModel<?> oldModel) {
		CommonLibClp newModel = new CommonLibClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommonLibRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCommonModule(BaseModel<?> oldModel) {
		CommonModuleClp newModel = new CommonModuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommonModuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDeveloperInfo(BaseModel<?> oldModel) {
		DeveloperInfoClp newModel = new DeveloperInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDeveloperInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDeveloperIp(BaseModel<?> oldModel) {
		DeveloperIpClp newModel = new DeveloperIpClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDeveloperIpRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDeveloperRequest(BaseModel<?> oldModel) {
		DeveloperRequestClp newModel = new DeveloperRequestClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDeveloperRequestRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPortType(BaseModel<?> oldModel) {
		PortTypeClp newModel = new PortTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPortTypeAnalyzerLink(
		BaseModel<?> oldModel) {
		PortTypeAnalyzerLinkClp newModel = new PortTypeAnalyzerLinkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortTypeAnalyzerLinkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPortTypeEditorLink(
		BaseModel<?> oldModel) {
		PortTypeEditorLinkClp newModel = new PortTypeEditorLinkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortTypeEditorLinkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPortTypeInputdeckForm(
		BaseModel<?> oldModel) {
		PortTypeInputdeckFormClp newModel = new PortTypeInputdeckFormClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortTypeInputdeckFormRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRequiredLib(BaseModel<?> oldModel) {
		RequiredLibClp newModel = new RequiredLibClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRequiredLibRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRequiredLibConfirm(
		BaseModel<?> oldModel) {
		RequiredLibConfirmClp newModel = new RequiredLibConfirmClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRequiredLibConfirmRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRequiredModule(BaseModel<?> oldModel) {
		RequiredModuleClp newModel = new RequiredModuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRequiredModuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputScienceApp(BaseModel<?> oldModel) {
		ScienceAppClp newModel = new ScienceAppClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScienceAppRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputScienceAppCategoryLink(
		BaseModel<?> oldModel) {
		ScienceAppCategoryLinkClp newModel = new ScienceAppCategoryLinkClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScienceAppCategoryLinkRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputScienceAppDescription(
		BaseModel<?> oldModel) {
		ScienceAppDescriptionClp newModel = new ScienceAppDescriptionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScienceAppDescriptionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputScienceAppFavorite(
		BaseModel<?> oldModel) {
		ScienceAppFavoriteClp newModel = new ScienceAppFavoriteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScienceAppFavoriteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputScienceAppInputPorts(
		BaseModel<?> oldModel) {
		ScienceAppInputPortsClp newModel = new ScienceAppInputPortsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScienceAppInputPortsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputScienceAppManager(BaseModel<?> oldModel) {
		ScienceAppManagerClp newModel = new ScienceAppManagerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScienceAppManagerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputScienceAppOutputPorts(
		BaseModel<?> oldModel) {
		ScienceAppOutputPortsClp newModel = new ScienceAppOutputPortsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setScienceAppOutputPortsRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}