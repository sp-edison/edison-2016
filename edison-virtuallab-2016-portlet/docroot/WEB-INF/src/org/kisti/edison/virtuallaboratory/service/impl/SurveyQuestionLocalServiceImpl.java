/**
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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.virtuallaboratory.model.SurveyAnswer;
import org.kisti.edison.virtuallaboratory.model.SurveyQuestion;
import org.kisti.edison.virtuallaboratory.service.base.SurveyQuestionLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * The implementation of the survey question local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.SurveyQuestionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.SurveyQuestionLocalServiceBaseImpl
 * @see org.kisti.edison.service.SurveyQuestionLocalServiceUtil
 */
public class SurveyQuestionLocalServiceImpl
	extends SurveyQuestionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.SurveyQuestionLocalServiceUtil} to access the survey question local service.
	 */
	public SurveyQuestion insertSurveyQuestion (Map params, Locale locale) throws SystemException {
		long questionSeqNo = GetterUtil.get(params.get("questionSeqNo"), 0L);
		SurveyQuestion surveyQuestion = null;

		
		if(questionSeqNo > 0) {
			surveyQuestion = surveyQuestionPersistence.fetchByPrimaryKey(questionSeqNo);
			surveyQuestion.setQuestionTitle(CustomUtil.strNull(params.get("questionTitle")), locale);
//			surveyQuestion.setQuestionTitle(CustomUtil.strNull(params.get("questionTitle")), Locale.US);
			surveyQuestion.setQuestionDivCd(CustomUtil.strNull(params.get("questionDivCd")));
			
			
			if(surveyQuestion.getQuestion1().equals("")) {
				surveyQuestion.setQuestion1(CustomUtil.strNull(params.get("question1")), locale);
				surveyQuestion.setQuestion1(CustomUtil.strNull(params.get("question1")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question1")).equals("")) {
				surveyQuestion.setQuestion1("");
			} else {
				surveyQuestion.setQuestion1(CustomUtil.strNull(params.get("question1")), locale);
			}
			
			if(surveyQuestion.getQuestion2().equals("")) {
				surveyQuestion.setQuestion2(CustomUtil.strNull(params.get("question2")), locale);
				surveyQuestion.setQuestion2(CustomUtil.strNull(params.get("question2")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question2")).equals("")) {
				surveyQuestion.setQuestion2("");
			} else {
				surveyQuestion.setQuestion2(CustomUtil.strNull(params.get("question2")), locale);
			}
			
			if(surveyQuestion.getQuestion3().equals("")) {
				surveyQuestion.setQuestion3(CustomUtil.strNull(params.get("question3")), locale);
				surveyQuestion.setQuestion3(CustomUtil.strNull(params.get("question3")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question3")).equals("")) {
				surveyQuestion.setQuestion3("");
			} else {
				surveyQuestion.setQuestion3(CustomUtil.strNull(params.get("question3")), locale);
			}
			
			if(surveyQuestion.getQuestion4().equals("")) {
				surveyQuestion.setQuestion4(CustomUtil.strNull(params.get("question4")), locale);
				surveyQuestion.setQuestion4(CustomUtil.strNull(params.get("question4")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question4")).equals("")) {
				surveyQuestion.setQuestion4("");
			} else {
				surveyQuestion.setQuestion4(CustomUtil.strNull(params.get("question4")), locale);
			}
			
			if(surveyQuestion.getQuestion5().equals("")) {
				surveyQuestion.setQuestion5(CustomUtil.strNull(params.get("question5")), locale);
				surveyQuestion.setQuestion5(CustomUtil.strNull(params.get("question5")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question5")).equals("")) {
				surveyQuestion.setQuestion5("");
			} else {
				surveyQuestion.setQuestion5(CustomUtil.strNull(params.get("question5")), locale);
			}
			
			if(surveyQuestion.getQuestion6().equals("")) {
				surveyQuestion.setQuestion6(CustomUtil.strNull(params.get("question6")), locale);
				surveyQuestion.setQuestion6(CustomUtil.strNull(params.get("question6")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question6")).equals("")) {
				surveyQuestion.setQuestion6("");
			} else {
				surveyQuestion.setQuestion6(CustomUtil.strNull(params.get("question6")), locale);
			}
			
			if(surveyQuestion.getQuestion7().equals("")) {
				surveyQuestion.setQuestion7(CustomUtil.strNull(params.get("question7")), locale);
				surveyQuestion.setQuestion7(CustomUtil.strNull(params.get("question7")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question7")).equals("")) {
				surveyQuestion.setQuestion7("");
			} else {
				surveyQuestion.setQuestion7(CustomUtil.strNull(params.get("question7")), locale);
			}
			
			if(surveyQuestion.getQuestion8().equals("")) {
				surveyQuestion.setQuestion8(CustomUtil.strNull(params.get("question8")), locale);
				surveyQuestion.setQuestion8(CustomUtil.strNull(params.get("question8")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question8")).equals("")) {
				surveyQuestion.setQuestion8("");
			} else {
				surveyQuestion.setQuestion8(CustomUtil.strNull(params.get("question8")), locale);
			}
			
			if(surveyQuestion.getQuestion9().equals("")) {
				surveyQuestion.setQuestion9(CustomUtil.strNull(params.get("question9")), locale);
				surveyQuestion.setQuestion9(CustomUtil.strNull(params.get("question9")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question9")).equals("")) {
				surveyQuestion.setQuestion9("");
			} else {
				surveyQuestion.setQuestion9(CustomUtil.strNull(params.get("question9")), locale);
			}
			
			if(surveyQuestion.getQuestion10().equals("")) {
				surveyQuestion.setQuestion10(CustomUtil.strNull(params.get("question10")), locale);
				surveyQuestion.setQuestion10(CustomUtil.strNull(params.get("question10")), Locale.US);
			} else if(CustomUtil.strNull(params.get("question10")).equals("")) {
				surveyQuestion.setQuestion10("");
			} else {
				surveyQuestion.setQuestion10(CustomUtil.strNull(params.get("question10")), locale);
			}
		
		} else {
			
			surveyQuestion = surveyQuestionPersistence.create(CounterLocalServiceUtil.increment(SurveyQuestion.class.getName()));

			Locale[] availLocal = LanguageUtil.getAvailableLocales();
			
			for(int i=0;i<availLocal.length;i++){
				
				surveyQuestion.setQuestionTitle(CustomUtil.strNull(params.get("questionTitle")), availLocal[i]);
				surveyQuestion.setQuestion1(CustomUtil.strNull(params.get("question1")), availLocal[i]);
				surveyQuestion.setQuestion2(CustomUtil.strNull(params.get("question2")), availLocal[i]);
				surveyQuestion.setQuestion3(CustomUtil.strNull(params.get("question3")), availLocal[i]);
				surveyQuestion.setQuestion4(CustomUtil.strNull(params.get("question4")), availLocal[i]);
				surveyQuestion.setQuestion5(CustomUtil.strNull(params.get("question5")), availLocal[i]);
				surveyQuestion.setQuestion6(CustomUtil.strNull(params.get("question6")), availLocal[i]);
				surveyQuestion.setQuestion7(CustomUtil.strNull(params.get("question7")), availLocal[i]);
				surveyQuestion.setQuestion8(CustomUtil.strNull(params.get("question8")), availLocal[i]);
				surveyQuestion.setQuestion9(CustomUtil.strNull(params.get("question9")), availLocal[i]);
				surveyQuestion.setQuestion10(CustomUtil.strNull(params.get("question10")), availLocal[i]);
				
			}
			surveyQuestion.setQuestionDivCd(CustomUtil.strNull(params.get("questionDivCd")));

			
//			surveyQuestion.setQuestionTitle(CustomUtil.strNull(params.get("questionTitle")), locale);
//			surveyQuestion.setQuestionTitle(CustomUtil.strNull(params.get("questionTitle")), Locale.US);
//			surveyQuestion.setQuestionDivCd(CustomUtil.strNull(params.get("questionDivCd")));
//			surveyQuestion.setQuestion1(CustomUtil.strNull(params.get("question1")), locale);
//			surveyQuestion.setQuestion1(CustomUtil.strNull(params.get("question1")), Locale.US);
//			surveyQuestion.setQuestion2(CustomUtil.strNull(params.get("question2")), locale);
//			surveyQuestion.setQuestion2(CustomUtil.strNull(params.get("question2")), Locale.US);
//			surveyQuestion.setQuestion3(CustomUtil.strNull(params.get("question3")), locale);
//			surveyQuestion.setQuestion3(CustomUtil.strNull(params.get("question3")), Locale.US);
//			surveyQuestion.setQuestion4(CustomUtil.strNull(params.get("question4")), locale);
//			surveyQuestion.setQuestion4(CustomUtil.strNull(params.get("question4")), Locale.US);
//			surveyQuestion.setQuestion5(CustomUtil.strNull(params.get("question5")), locale);
//			surveyQuestion.setQuestion5(CustomUtil.strNull(params.get("question5")), Locale.US);
//			surveyQuestion.setQuestion6(CustomUtil.strNull(params.get("question6")), locale);
//			surveyQuestion.setQuestion6(CustomUtil.strNull(params.get("question6")), Locale.US);
//			surveyQuestion.setQuestion7(CustomUtil.strNull(params.get("question7")), locale);
//			surveyQuestion.setQuestion7(CustomUtil.strNull(params.get("question7")), Locale.US);
//			surveyQuestion.setQuestion8(CustomUtil.strNull(params.get("question8")), locale);
//			surveyQuestion.setQuestion8(CustomUtil.strNull(params.get("question8")), Locale.US);
//			surveyQuestion.setQuestion9(CustomUtil.strNull(params.get("question9")), locale);
//			surveyQuestion.setQuestion9(CustomUtil.strNull(params.get("question9")), Locale.US);
//			surveyQuestion.setQuestion10(CustomUtil.strNull(params.get("question10")), locale);
//			surveyQuestion.setQuestion10(CustomUtil.strNull(params.get("question10")), Locale.US);
			
			
		}
		
		
		surveyQuestion = surveyQuestionPersistence.update(surveyQuestion);
		surveyQuestionPersistence.addSurvey(surveyQuestion.getPrimaryKey(), (Long) params.get("surveySeqNo"));
		
		return surveyQuestion;
	}
	
	public List<Map<String, Object>> getSurveyQuestionInfomation(long surveySeqNo, Locale locale) {
		List<Map<String,Object>> returnList = new ArrayList<Map<String, Object>>();
		
		List<Object[]> resultList = surveyFinder.getSurveyQuestion(surveySeqNo);
		
		if(resultList != null) {
			for (Object[] objects : resultList) {
				SurveyQuestion surveyQuestion = (SurveyQuestion) objects[0];
				int questionCnt = (Integer) objects[1];
				
				if (surveyQuestion != null) {
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("questionTitle", surveyQuestion.getQuestionTitle(locale));
					result.put("questionSeqNo", surveyQuestion.getQuestionSeqNo());
					result.put("questionDivCd", surveyQuestion.getQuestionDivCd());
					result.put("question1", surveyQuestion.getQuestion1(locale));
					result.put("question2", surveyQuestion.getQuestion2(locale));
					result.put("question3", surveyQuestion.getQuestion3(locale));
					result.put("question4", surveyQuestion.getQuestion4(locale));
					result.put("question5", surveyQuestion.getQuestion5(locale));
					result.put("question6", surveyQuestion.getQuestion6(locale));
					result.put("question7", surveyQuestion.getQuestion7(locale));
					result.put("question8", surveyQuestion.getQuestion8(locale));
					result.put("question9", surveyQuestion.getQuestion9(locale));
					result.put("question10", surveyQuestion.getQuestion10(locale));
					result.put("questionCnt", questionCnt);
					
					returnList.add(result);
				}
			}
		}
		return returnList;
	}
	
	public List<Map<String, Object>> getSurveyQuestionResult(long surveySeqNo, long virtualLabId, long classId, long groupId, Locale locale) {
		List<Map<String,Object>> returnList = new ArrayList<Map<String, Object>>();
		
		List<Object[]> resultList = surveyFinder.getSurveyQuestion(surveySeqNo, virtualLabId, classId, groupId);
		
		if(resultList != null) {
			for (Object[] objects : resultList) {
				SurveyQuestion surveyQuestion = (SurveyQuestion) objects[0];
				int questionCnt = (Integer) objects[1];
				int question1Cnt = (Integer) objects[2];
				int question2Cnt = (Integer) objects[3];
				int question3Cnt = (Integer) objects[4];
				int question4Cnt = (Integer) objects[5];
				int question5Cnt = (Integer) objects[6];
				int question6Cnt = (Integer) objects[7];
				int question7Cnt = (Integer) objects[8];
				int question8Cnt = (Integer) objects[9];
				int question9Cnt = (Integer) objects[10];
				int question10Cnt = (Integer) objects[11];
				
				if (surveyQuestion != null) {
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("questionTitle", surveyQuestion.getQuestionTitle(locale));
					result.put("questionSeqNo", surveyQuestion.getQuestionSeqNo());
					result.put("questionDivCd", surveyQuestion.getQuestionDivCd());
					result.put("question1", surveyQuestion.getQuestion1(locale));
					result.put("question2", surveyQuestion.getQuestion2(locale));
					result.put("question3", surveyQuestion.getQuestion3(locale));
					result.put("question4", surveyQuestion.getQuestion4(locale));
					result.put("question5", surveyQuestion.getQuestion5(locale));
					result.put("question6", surveyQuestion.getQuestion6(locale));
					result.put("question7", surveyQuestion.getQuestion7(locale));
					result.put("question8", surveyQuestion.getQuestion8(locale));
					result.put("question9", surveyQuestion.getQuestion9(locale));
					result.put("question10", surveyQuestion.getQuestion10(locale));
					
					result.put("questionCnt", questionCnt);
					result.put("question1Cnt", question1Cnt);
					result.put("question2Cnt", question2Cnt);
					result.put("question3Cnt", question3Cnt);
					result.put("question4Cnt", question4Cnt);
					result.put("question5Cnt", question5Cnt);
					result.put("question6Cnt", question6Cnt);
					result.put("question7Cnt", question7Cnt);
					result.put("question8Cnt", question8Cnt);
					result.put("question9Cnt", question9Cnt);
					result.put("question10Cnt", question10Cnt);
					result.put("surveySeqNo", surveySeqNo);
					
					returnList.add(result);
				}
			}
		}
		return returnList;
	}
	
	public List<Map<String, Object>> getSurveyQuestionSubject(long surveySeqNo, long virtualLabId, long classId, String questionDivCd, long questionSeqNo, long groupId) {
		List<Map<String,Object>> returnList = new ArrayList<Map<String, Object>>();
		List<SurveyAnswer> resultList = surveyFinder.getSurveyQuestionSubject(surveySeqNo, virtualLabId, classId, questionDivCd, questionSeqNo, groupId);
		
		if(resultList != null) {
			for (SurveyAnswer surveyAnswer : resultList) {
				Map<String, Object> result = new HashMap<String, Object>();
				
				if (surveyAnswer != null) {
					result.put("subjectivityAnswer", surveyAnswer.getSubjectivityAnswer());
				}
				
				returnList.add(result);
			}
		}
		return returnList;
	}
	
	public void deleteSurveyQuestionList (long surveySeqNo) throws SystemException {
		List<Object[]> resultList = surveyFinder.getSurveyQuestion(surveySeqNo);
		for (Object[] objects : resultList) {
			SurveyQuestion surveyQuestion = (SurveyQuestion) objects[0];
			surveyQuestionPersistence.remove(surveyQuestion);
		}
	}
	
	public List<Long> getQuestionSeqList(long surveySeqNo) {
		List<Long> resultList = surveyFinder.getQuestionSeqList(surveySeqNo);
		return resultList;
	}
}