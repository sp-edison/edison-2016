/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package org.kisti.edison.virtuallaboratory.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.virtuallaboratory.model.SurveyAnswer;
import org.kisti.edison.virtuallaboratory.service.base.SurveyAnswerLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the survey answer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.SurveyAnswerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.SurveyAnswerLocalServiceBaseImpl
 * @see org.kisti.edison.service.SurveyAnswerLocalServiceUtil
 */
public class SurveyAnswerLocalServiceImpl
	extends SurveyAnswerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.SurveyAnswerLocalServiceUtil} to access the survey answer local service.
	 */
	
	public SurveyAnswer insertSurveyAnswer(Map<String, String> params) throws SystemException {
		SurveyAnswer surveyAnswer = surveyAnswerPersistence.create(CounterLocalServiceUtil.increment(SurveyAnswer.class.getName()));
		
		surveyAnswer.setVirtualLabId(Long.parseLong(params.get("virtualLabId")));
		surveyAnswer.setClassId(Long.parseLong(params.get("classId")));
		surveyAnswer.setUserId(Long.parseLong(params.get("userId")));
		surveyAnswer.setObjecttivityAnswer(params.get("objecttivityAnswer"));
		surveyAnswer.setSubjectivityAnswer(params.get("subjectivityAnswer"));
		surveyAnswer.setAnswerDate(new Date());
		
		surveyAnswerPersistence.update(surveyAnswer);
		surveyAnswerPersistence.addSurveyQuestion(surveyAnswer.getPrimaryKey(), Long.parseLong(params.get("questionSeqNo")));
		return null;
	}
	
	public List<Map<String, Object>> getExcelResult(long surveySeqNo, long virtualLabId, long classId, long groupId,String languageId) {
		List<Object[]> surveyExcelList = surveyFinder.getExcelResult(surveySeqNo, virtualLabId, classId, groupId,languageId);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		for(int i = 0; i < surveyExcelList.size(); i++) {
			String classIdStr = CustomUtil.strNull(surveyExcelList.get(i)[0]);
			String row1 = CustomUtil.strNull(surveyExcelList.get(i)[1]);
			String row2 = CustomUtil.strNull(surveyExcelList.get(i)[2]);
			
			resultRow = new HashMap<String, Object>();
			resultRow.put("classId", classIdStr);
			resultRow.put("row1", row1);
			resultRow.put("row2", row2);
			
			returnList.add(resultRow);
		}
		
		return returnList;
	}
	
	public int getCountAnswerResult(long surveySeqNo, long virtualLabId, long classId) {
		return surveyFinder.getCountAnswerResult(surveySeqNo, virtualLabId, classId);
	}
}