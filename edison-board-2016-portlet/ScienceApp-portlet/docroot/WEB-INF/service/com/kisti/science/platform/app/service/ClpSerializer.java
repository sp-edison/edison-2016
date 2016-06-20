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

import com.kisti.science.platform.app.model.CommonLibraryClp;
import com.kisti.science.platform.app.model.CommonModuleClp;
import com.kisti.science.platform.app.model.CommonPackageClp;
import com.kisti.science.platform.app.model.PortTypeAnalyzerLinkClp;
import com.kisti.science.platform.app.model.PortTypeClp;
import com.kisti.science.platform.app.model.PortTypeEditorLinkClp;
import com.kisti.science.platform.app.model.PortTypeInputdeckFormClp;
import com.kisti.science.platform.app.model.PortTypeInputdeckUserFormClp;
import com.kisti.science.platform.app.model.ScienceAppCategoryLinkClp;
import com.kisti.science.platform.app.model.ScienceAppClp;
import com.kisti.science.platform.app.model.ScienceAppInputPortsClp;
import com.kisti.science.platform.app.model.ScienceAppManagerClp;
import com.kisti.science.platform.app.model.ScienceAppOutputPortsClp;

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

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry H. Seo & Young Suh
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
						"ScienceApp-portlet-deployment-context");

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
							"ScienceApp-portlet-deployment-context");

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
				_servletContextName = "ScienceApp-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CommonLibraryClp.class.getName())) {
			return translateInputCommonLibrary(oldModel);
		}

		if (oldModelClassName.equals(CommonModuleClp.class.getName())) {
			return translateInputCommonModule(oldModel);
		}

		if (oldModelClassName.equals(CommonPackageClp.class.getName())) {
			return translateInputCommonPackage(oldModel);
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

		if (oldModelClassName.equals(
					PortTypeInputdeckUserFormClp.class.getName())) {
			return translateInputPortTypeInputdeckUserForm(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppClp.class.getName())) {
			return translateInputScienceApp(oldModel);
		}

		if (oldModelClassName.equals(ScienceAppCategoryLinkClp.class.getName())) {
			return translateInputScienceAppCategoryLink(oldModel);
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

	public static Object translateInputCommonLibrary(BaseModel<?> oldModel) {
		CommonLibraryClp oldClpModel = (CommonLibraryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommonLibraryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCommonModule(BaseModel<?> oldModel) {
		CommonModuleClp oldClpModel = (CommonModuleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommonModuleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCommonPackage(BaseModel<?> oldModel) {
		CommonPackageClp oldClpModel = (CommonPackageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommonPackageRemoteModel();

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

	public static Object translateInputPortTypeInputdeckUserForm(
		BaseModel<?> oldModel) {
		PortTypeInputdeckUserFormClp oldClpModel = (PortTypeInputdeckUserFormClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPortTypeInputdeckUserFormRemoteModel();

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
					"com.kisti.science.platform.app.model.impl.CommonLibraryImpl")) {
			return translateOutputCommonLibrary(oldModel);
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
					"com.kisti.science.platform.app.model.impl.CommonModuleImpl")) {
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
					"com.kisti.science.platform.app.model.impl.CommonPackageImpl")) {
			return translateOutputCommonPackage(oldModel);
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
					"com.kisti.science.platform.app.model.impl.PortTypeImpl")) {
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
					"com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkImpl")) {
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
					"com.kisti.science.platform.app.model.impl.PortTypeEditorLinkImpl")) {
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
					"com.kisti.science.platform.app.model.impl.PortTypeInputdeckFormImpl")) {
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
					"com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormImpl")) {
			return translateOutputPortTypeInputdeckUserForm(oldModel);
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
					"com.kisti.science.platform.app.model.impl.ScienceAppImpl")) {
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
					"com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkImpl")) {
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
					"com.kisti.science.platform.app.model.impl.ScienceAppInputPortsImpl")) {
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
					"com.kisti.science.platform.app.model.impl.ScienceAppManagerImpl")) {
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
					"com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsImpl")) {
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
					"com.kisti.science.platform.app.NoSuchCommonLibraryException")) {
			return new com.kisti.science.platform.app.NoSuchCommonLibraryException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchCommonModuleException")) {
			return new com.kisti.science.platform.app.NoSuchCommonModuleException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchCommonPackageException")) {
			return new com.kisti.science.platform.app.NoSuchCommonPackageException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchPortTypeException")) {
			return new com.kisti.science.platform.app.NoSuchPortTypeException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException")) {
			return new com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException")) {
			return new com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException")) {
			return new com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException")) {
			return new com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchScienceAppException")) {
			return new com.kisti.science.platform.app.NoSuchScienceAppException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchCategoryLinkException")) {
			return new com.kisti.science.platform.app.NoSuchCategoryLinkException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchInputPortsException")) {
			return new com.kisti.science.platform.app.NoSuchInputPortsException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchManagerException")) {
			return new com.kisti.science.platform.app.NoSuchManagerException();
		}

		if (className.equals(
					"com.kisti.science.platform.app.NoSuchOutputPortsException")) {
			return new com.kisti.science.platform.app.NoSuchOutputPortsException();
		}

		return throwable;
	}

	public static Object translateOutputCommonLibrary(BaseModel<?> oldModel) {
		CommonLibraryClp newModel = new CommonLibraryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommonLibraryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCommonModule(BaseModel<?> oldModel) {
		CommonModuleClp newModel = new CommonModuleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommonModuleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCommonPackage(BaseModel<?> oldModel) {
		CommonPackageClp newModel = new CommonPackageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommonPackageRemoteModel(oldModel);

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

	public static Object translateOutputPortTypeInputdeckUserForm(
		BaseModel<?> oldModel) {
		PortTypeInputdeckUserFormClp newModel = new PortTypeInputdeckUserFormClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPortTypeInputdeckUserFormRemoteModel(oldModel);

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