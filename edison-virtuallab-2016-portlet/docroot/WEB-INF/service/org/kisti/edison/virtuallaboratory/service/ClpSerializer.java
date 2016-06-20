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

package org.kisti.edison.virtuallaboratory.service;

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

import org.kisti.edison.virtuallaboratory.model.SurveyAnswerClp;
import org.kisti.edison.virtuallaboratory.model.SurveyClp;
import org.kisti.edison.virtuallaboratory.model.SurveyQuestionClp;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClassClp;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceAppClp;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClp;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUserClp;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTempClp;

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
						"edison-virtuallab-2016-portlet-deployment-context");

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
							"edison-virtuallab-2016-portlet-deployment-context");

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
				_servletContextName = "edison-virtuallab-2016-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(SurveyClp.class.getName())) {
			return translateInputSurvey(oldModel);
		}

		if (oldModelClassName.equals(SurveyAnswerClp.class.getName())) {
			return translateInputSurveyAnswer(oldModel);
		}

		if (oldModelClassName.equals(SurveyQuestionClp.class.getName())) {
			return translateInputSurveyQuestion(oldModel);
		}

		if (oldModelClassName.equals(VirtualLabClp.class.getName())) {
			return translateInputVirtualLab(oldModel);
		}

		if (oldModelClassName.equals(VirtualLabClassClp.class.getName())) {
			return translateInputVirtualLabClass(oldModel);
		}

		if (oldModelClassName.equals(
					VirtualLabClassScienceAppClp.class.getName())) {
			return translateInputVirtualLabClassScienceApp(oldModel);
		}

		if (oldModelClassName.equals(VirtualLabUserClp.class.getName())) {
			return translateInputVirtualLabUser(oldModel);
		}

		if (oldModelClassName.equals(VirtualLabUserTempClp.class.getName())) {
			return translateInputVirtualLabUserTemp(oldModel);
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

	public static Object translateInputSurvey(BaseModel<?> oldModel) {
		SurveyClp oldClpModel = (SurveyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyAnswer(BaseModel<?> oldModel) {
		SurveyAnswerClp oldClpModel = (SurveyAnswerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyAnswerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSurveyQuestion(BaseModel<?> oldModel) {
		SurveyQuestionClp oldClpModel = (SurveyQuestionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSurveyQuestionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVirtualLab(BaseModel<?> oldModel) {
		VirtualLabClp oldClpModel = (VirtualLabClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVirtualLabRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVirtualLabClass(BaseModel<?> oldModel) {
		VirtualLabClassClp oldClpModel = (VirtualLabClassClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVirtualLabClassRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVirtualLabClassScienceApp(
		BaseModel<?> oldModel) {
		VirtualLabClassScienceAppClp oldClpModel = (VirtualLabClassScienceAppClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVirtualLabClassScienceAppRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVirtualLabUser(BaseModel<?> oldModel) {
		VirtualLabUserClp oldClpModel = (VirtualLabUserClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVirtualLabUserRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVirtualLabUserTemp(BaseModel<?> oldModel) {
		VirtualLabUserTempClp oldClpModel = (VirtualLabUserTempClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVirtualLabUserTempRemoteModel();

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
					"org.kisti.edison.virtuallaboratory.model.impl.SurveyImpl")) {
			return translateOutputSurvey(oldModel);
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
					"org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerImpl")) {
			return translateOutputSurveyAnswer(oldModel);
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
					"org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionImpl")) {
			return translateOutputSurveyQuestion(oldModel);
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
					"org.kisti.edison.virtuallaboratory.model.impl.VirtualLabImpl")) {
			return translateOutputVirtualLab(oldModel);
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
					"org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassImpl")) {
			return translateOutputVirtualLabClass(oldModel);
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
					"org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppImpl")) {
			return translateOutputVirtualLabClassScienceApp(oldModel);
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
					"org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserImpl")) {
			return translateOutputVirtualLabUser(oldModel);
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
					"org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempImpl")) {
			return translateOutputVirtualLabUserTemp(oldModel);
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
					"org.kisti.edison.virtuallaboratory.NoSuchSurveyException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchSurveyException();
		}

		if (className.equals(
					"org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException();
		}

		if (className.equals(
					"org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException();
		}

		if (className.equals(
					"org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException();
		}

		if (className.equals(
					"org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException();
		}

		if (className.equals(
					"org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException();
		}

		if (className.equals(
					"org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException();
		}

		if (className.equals(
					"org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException")) {
			return new org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException();
		}

		return throwable;
	}

	public static Object translateOutputSurvey(BaseModel<?> oldModel) {
		SurveyClp newModel = new SurveyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyAnswer(BaseModel<?> oldModel) {
		SurveyAnswerClp newModel = new SurveyAnswerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyAnswerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSurveyQuestion(BaseModel<?> oldModel) {
		SurveyQuestionClp newModel = new SurveyQuestionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSurveyQuestionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVirtualLab(BaseModel<?> oldModel) {
		VirtualLabClp newModel = new VirtualLabClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVirtualLabRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVirtualLabClass(BaseModel<?> oldModel) {
		VirtualLabClassClp newModel = new VirtualLabClassClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVirtualLabClassRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVirtualLabClassScienceApp(
		BaseModel<?> oldModel) {
		VirtualLabClassScienceAppClp newModel = new VirtualLabClassScienceAppClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVirtualLabClassScienceAppRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVirtualLabUser(BaseModel<?> oldModel) {
		VirtualLabUserClp newModel = new VirtualLabUserClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVirtualLabUserRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVirtualLabUserTemp(
		BaseModel<?> oldModel) {
		VirtualLabUserTempClp newModel = new VirtualLabUserTempClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVirtualLabUserTempRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}