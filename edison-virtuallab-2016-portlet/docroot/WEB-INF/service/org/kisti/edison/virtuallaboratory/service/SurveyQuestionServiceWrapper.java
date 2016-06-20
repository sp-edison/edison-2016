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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SurveyQuestionService}.
 *
 * @author EDISON
 * @see SurveyQuestionService
 * @generated
 */
public class SurveyQuestionServiceWrapper implements SurveyQuestionService,
	ServiceWrapper<SurveyQuestionService> {
	public SurveyQuestionServiceWrapper(
		SurveyQuestionService surveyQuestionService) {
		_surveyQuestionService = surveyQuestionService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyQuestionService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyQuestionService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyQuestionService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyQuestionService getWrappedSurveyQuestionService() {
		return _surveyQuestionService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyQuestionService(
		SurveyQuestionService surveyQuestionService) {
		_surveyQuestionService = surveyQuestionService;
	}

	@Override
	public SurveyQuestionService getWrappedService() {
		return _surveyQuestionService;
	}

	@Override
	public void setWrappedService(SurveyQuestionService surveyQuestionService) {
		_surveyQuestionService = surveyQuestionService;
	}

	private SurveyQuestionService _surveyQuestionService;
}