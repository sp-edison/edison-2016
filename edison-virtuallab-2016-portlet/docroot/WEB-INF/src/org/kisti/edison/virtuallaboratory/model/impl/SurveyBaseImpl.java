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

package org.kisti.edison.virtuallaboratory.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.virtuallaboratory.model.Survey;
import org.kisti.edison.virtuallaboratory.service.SurveyLocalServiceUtil;

/**
 * The extended model base implementation for the Survey service. Represents a row in the &quot;EDVIR_Survey&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SurveyImpl}.
 * </p>
 *
 * @author EDISON
 * @see SurveyImpl
 * @see org.kisti.edison.virtuallaboratory.model.Survey
 * @generated
 */
public abstract class SurveyBaseImpl extends SurveyModelImpl implements Survey {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a survey model instance should use the {@link Survey} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyLocalServiceUtil.addSurvey(this);
		}
		else {
			SurveyLocalServiceUtil.updateSurvey(this);
		}
	}
}