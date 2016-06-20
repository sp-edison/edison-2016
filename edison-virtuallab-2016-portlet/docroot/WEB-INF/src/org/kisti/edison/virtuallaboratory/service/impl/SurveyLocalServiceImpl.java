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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.virtuallaboratory.model.Survey;
import org.kisti.edison.virtuallaboratory.model.VirtualLab;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClass;
import org.kisti.edison.virtuallaboratory.service.base.SurveyLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;

/**
 * The implementation of the survey local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.SurveyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.SurveyLocalServiceBaseImpl
 * @see org.kisti.edison.service.SurveyLocalServiceUtil
 */
public class SurveyLocalServiceImpl extends SurveyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.SurveyLocalServiceUtil} to access the survey local service.
	 */
	public List<Map<String, Object>> getListSurvey(Map<String, String> params, Locale locale) throws SystemException {
		int begin = Integer.parseInt(params.get("begin"));
		int end = Integer.parseInt(params.get("end"));
		
		List<Survey> surveyList = surveyPersistence.findAll(begin, end);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < surveyList.size(); i++) {
			
			Survey survey = surveyList.get(i);
			
			resultRow = new HashMap<String, Object>();
			if (survey != null) {
				resultRow.put("surveySeqNo", String.valueOf(survey.getSurveySeqNo()));
				resultRow.put("surveyCreateDate", new SimpleDateFormat("yyyy-MM-dd").format(survey.getSurveyCreateDate()));
				resultRow.put("surveyStatus", survey.getSurveyStatus());
				resultRow.put("surveyEndDate", survey.getSurveyEndDate());
				resultRow.put("surveyStartDate", survey.getSurveyStartDate());
				resultRow.put("surveyTitle", survey.getSurveyTitle(locale, true));
			}
			returnList.add(resultRow);
		}
		
		return returnList;
	}
	
	public List<Map<String, Object>> getListSurveyAll(Locale locale) throws SystemException {
		List<Survey> surveyList = surveyPersistence.findAll();
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < surveyList.size(); i++) {
			
			Survey survey = surveyList.get(i);
			
			resultRow = new HashMap<String, Object>();
			if (survey != null) {
				resultRow.put("surveySeqNo", String.valueOf(survey.getSurveySeqNo()));
				resultRow.put("surveyCreateDate", new SimpleDateFormat("yyyy-MM-dd").format(survey.getSurveyCreateDate()));
				resultRow.put("surveyStatus", survey.getSurveyStatus());
				resultRow.put("surveyEndDate", survey.getSurveyEndDate());
				resultRow.put("surveyStartDate", survey.getSurveyStartDate());
				resultRow.put("surveyTitle", survey.getSurveyTitle(locale, true));
			}
			returnList.add(resultRow);
		}
		
		return returnList;
	}
	
	public int getCountSurvey() throws SystemException {
		return surveyPersistence.countAll();
	}
	
	public int isExistsUseDate(String surveyDivCd, long surveySeqNo, String startDate, String endDate) {
		return surveyFinder.isExistsUseDate(surveyDivCd, surveySeqNo, startDate, endDate);
	}
	
	public Survey insertSurvey(Map<String, String> params, Locale locale) throws SystemException {
		long surveySeqNo = Long.parseLong(params.get("surveySeqNo"));
		
		
		
		Survey survey = null;
		if (surveySeqNo > 0) {
			survey = surveyPersistence.fetchByPrimaryKey(surveySeqNo);
			survey.setSurveyTitle(CustomUtil.strNull(params.get("surveyTitle")), locale, Locale.US);
		} else {
			survey = surveyPersistence.create(CounterLocalServiceUtil.increment(Survey.class.getName()));
			survey.setSurveyStatus(CustomUtil.strNull(params.get("surveyStatus")));
			

			if(locale == Locale.US){
				Locale[] availLocal = LanguageUtil.getAvailableLocales();
				for(int i=0;i<availLocal.length;i++){
					if(!availLocal[i].equals("en_US")){
						survey.setSurveyTitle(CustomUtil.strNull(params.get("surveyTitle")), availLocal[i]);
					}
				}
			}else{
				survey.setSurveyTitle(CustomUtil.strNull(params.get("surveyTitle")), locale);			
			}
			
			survey.setSurveyTitle(CustomUtil.strNull(params.get("surveyTitle")), Locale.US);
			
		}
		
		if (survey != null) {
			survey.setSurveyStartDate(CustomUtil.strNull(params.get("surveyStartDate")));
			survey.setSurveyEndDate(CustomUtil.strNull(params.get("surveyEndDate")));
			survey.setSurveyUseYn("Y");
			survey.setSurveyCreateDate(new Date());
			survey = surveyPersistence.update(survey);
		}
		return survey;
	}
	
	public Map<String, Object> getSurveyInfomation(long surveySeqNo, Locale locale) throws SystemException {
		Map<String, Object> result = null;
		Survey survey = surveyPersistence.fetchByPrimaryKey(surveySeqNo);
		if(survey != null) {
			result = new HashMap<String, Object>();
			result.put("surveySeqNo", survey.getSurveySeqNo());
			result.put("surveyCreateDate", survey.getSurveyCreateDate());
			result.put("surveyStatus", survey.getSurveyStatus());
			result.put("surveyEndDate", survey.getSurveyEndDate());
			result.put("surveyStartDate", survey.getSurveyStartDate());
			result.put("surveyTitle", survey.getSurveyTitle(locale));
		}
		return result;
	}
	
	public List<Map<String, Object>> getSurveyMappingCheckList(long virtualLabId, boolean checkDate, Locale locale) throws SystemException {
		
		List<Object[]> surveyMappingCheckList = surveyFinder.getSurveyMappingCheckList(virtualLabId, checkDate);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		if (surveyMappingCheckList != null) {
			for (int i = 0; i < surveyMappingCheckList.size(); i++) {
				Survey survey = (Survey) surveyMappingCheckList.get(i)[0];
				int checked = 0;
				if (surveyMappingCheckList.get(i)[1] != null) {
					checked = (Integer) surveyMappingCheckList.get(i)[1];
				}
				
				if (survey != null) {
					
				resultRow = new HashMap<String, Object>();
				if (survey != null) {
					resultRow.put("surveySeqNo", String.valueOf(survey.getSurveySeqNo()));
					resultRow.put("surveyCreateDate", new SimpleDateFormat("yyyy-MM-dd").format(survey.getSurveyCreateDate()));
					resultRow.put("surveyStatus", survey.getSurveyStatus());
					resultRow.put("surveyEndDate", survey.getSurveyEndDate());
					resultRow.put("surveyStartDate", survey.getSurveyStartDate());
					resultRow.put("surveyTitle", survey.getSurveyTitle(locale));
					resultRow.put("virtualLabId", checked);

					returnList.add(resultRow);
				}
				}
			}
		}
		
		return returnList;
	}
	
	public List<Map<String, Object>> getSurveyMappingList(long virtualLabId, boolean checkDate, Locale locale) throws SystemException {
		
		List<Survey> surveyList = surveyFinder.getSurveyMappingList(virtualLabId, checkDate);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < surveyList.size(); i++) {
			
			Survey survey = surveyList.get(i);
			
			resultRow = new HashMap<String, Object>();
			if (survey != null) {
				resultRow.put("surveySeqNo", String.valueOf(survey.getSurveySeqNo()));
				resultRow.put("surveyCreateDate", new SimpleDateFormat("yyyy-MM-dd").format(survey.getSurveyCreateDate()));
				resultRow.put("surveyStatus", survey.getSurveyStatus());
				resultRow.put("surveyEndDate", survey.getSurveyEndDate());
				resultRow.put("surveyStartDate", survey.getSurveyStartDate());
				resultRow.put("surveyTitle", survey.getSurveyTitle(locale));
			}
			returnList.add(resultRow);
		}
		
		return returnList;
	}
	
	public List<Map<String, Object>> getSurveyMappingVoteList(long virtualLabId, long classId, long userId, boolean checkDate, Locale locale) throws SystemException {
		
		List<Object[]> surveyList = surveyFinder.getSurveyMappingVoteList(virtualLabId, classId, userId, checkDate);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < surveyList.size(); i++) {
			
			Survey survey = (Survey) surveyList.get(i)[0];
			int surveyCheck = (Integer) surveyList.get(i)[1];
			
			resultRow = new HashMap<String, Object>();
			if (survey != null) {
				resultRow.put("surveySeqNo", String.valueOf(survey.getSurveySeqNo()));
				resultRow.put("surveyCreateDate", new SimpleDateFormat("yyyy-MM-dd").format(survey.getSurveyCreateDate()));
				resultRow.put("surveyStatus", survey.getSurveyStatus());
				resultRow.put("surveyEndDate", survey.getSurveyEndDate());
				resultRow.put("surveyStartDate", survey.getSurveyStartDate());
				resultRow.put("surveyTitle", survey.getSurveyTitle(locale));
				resultRow.put("surveyCheck", surveyCheck);
			}
			returnList.add(resultRow);
		}
		
		return returnList;
	}
	
	public List<Map<String, Object>> getSurveyResultList(long groupId, long surveySeqNo, String searchField, int begin, int end, Locale locale) throws SystemException {
		
		List<Object[]> surveyResultList = surveyFinder.getSurveyResultList(groupId, surveySeqNo, searchField, begin, end, locale);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < surveyResultList.size(); i++) {
			int answerCount = 0;
			int userTempCount = 0;
			int userCount = 0;
			int surveyCheck = 0;
			Date voteStartDate = null;
			Date voteEndDate = null;
			
			VirtualLab virtualLab = (VirtualLab) surveyResultList.get(i)[0];
			VirtualLabClass virtualLabClass = (VirtualLabClass) surveyResultList.get(i)[1];
			Survey survey = (Survey) surveyResultList.get(i)[2];
			answerCount = (Integer) surveyResultList.get(i)[3];
			surveyCheck = (Integer) surveyResultList.get(i)[4];
			userTempCount = (Integer) surveyResultList.get(i)[5];
			userCount = (Integer) surveyResultList.get(i)[6];
			voteStartDate = (Date) surveyResultList.get(i)[7];
			voteEndDate = (Date) surveyResultList.get(i)[8];
			
			resultRow = new HashMap<String, Object>();
			
			if(virtualLab != null) {
				resultRow.put("virtualLabId", String.valueOf(virtualLab.getVirtualLabId()));
				resultRow.put("userId", String.valueOf(virtualLab.getUserId()));
				resultRow.put("virtualLabTitle", virtualLab.getVirtualLabTitle(locale, true));
				resultRow.put("virtualLabPersonName", virtualLab.getVirtualLabPersonName(locale, true));
				resultRow.put("virtualLabConfirmDescription", virtualLab.getVirtualLabConfirmDescription());
				resultRow.put("virtualLabStatus", virtualLab.getVirtualLabStatus());
				resultRow.put("virtualLabRequestDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLab.getVirtualLabRequestDt()));
				resultRow.put("virtualLabUniversityField", virtualLab.getVirtualLabUniversityField());
				resultRow.put("virtualLabUniversityFieldNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(virtualLab.getVirtualLabUniversityField(), EdisonExpando.CDNM, locale));
			}
			
			if (survey != null) {
				resultRow.put("surveySeqNo", String.valueOf(survey.getSurveySeqNo()));
				resultRow.put("surveyCreateDate", new SimpleDateFormat("yyyy-MM-dd").format(survey.getSurveyCreateDate()));
				resultRow.put("surveyStatus", survey.getSurveyStatus());
				resultRow.put("surveyEndDate", survey.getSurveyEndDate());
				resultRow.put("surveyStartDate", survey.getSurveyStartDate());
				resultRow.put("surveyTitle", survey.getSurveyTitle(locale));
			}
			
			if (virtualLabClass != null) {
				resultRow.put("classTitle", virtualLabClass.getClassTitle(locale, true));
				resultRow.put("classId", String.valueOf(virtualLabClass.getClassId()));
				resultRow.put("classDescription", virtualLabClass.getClassDescription(locale, true));
				resultRow.put("classCreateDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLabClass.getClassCreateDt()));
				resultRow.put("classPersonnel", String.valueOf(virtualLabClass.getClassPersonnel()));
				resultRow.put("classStartDt", virtualLabClass.getClassStartDt());
				resultRow.put("classEndDt", virtualLabClass.getClassEndDt());
			}
			
			resultRow.put("answerCount", answerCount);
			resultRow.put("surveyCheck", surveyCheck);
			resultRow.put("userTempCount", userTempCount);
			resultRow.put("userCount", userCount);
			resultRow.put("userTotalCount", userTempCount + userCount);
			
			if (answerCount > 0) {
				resultRow.put("voteStartDate", new SimpleDateFormat("yyyy-MM-dd").format(voteStartDate));
				resultRow.put("voteEndDate", new SimpleDateFormat("yyyy-MM-dd").format(voteEndDate));
			}
			
			returnList.add(resultRow);
		}
		
		return returnList;
	}
	
	public int getCountSurveyResultList(long groupId, long surveySeqNo, String searchField, Locale locale) throws SystemException {
		return surveyFinder.getCountSurveyResultList(groupId, surveySeqNo, searchField, locale);
	}
	
	public int getCountSurveyCheck(long surveySeqNo, long userId, long classId) throws SystemException {
		return surveyFinder.getCountSurveyCheck(surveySeqNo, userId, classId);
	}
	
	public void deleteVirtualLabSurvey(long virtualLabId) throws SystemException {
		List<Survey> resultList = surveyFinder.getSurveyMappingList(virtualLabId, false);
		if (resultList != null && resultList.size() > 0) {
			virtualLabPersistence.removeSurveies(virtualLabId, resultList);
		}
	}
	
	public long getMaxQuestionSeq(long virtualLabId) throws SystemException {
		return surveyFinder.getMaxQuestionSeq(virtualLabId);
	}
}