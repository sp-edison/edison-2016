package org.kisti.edison.virtuallaboratory.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.GBatisUtil;
import org.kisti.edison.virtuallaboratory.model.Survey;
import org.kisti.edison.virtuallaboratory.model.SurveyAnswer;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerImpl;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyImpl;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabImpl;
import org.springframework.jca.cci.object.EisOperation;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SurveyFinderImpl extends BasePersistenceImpl<Survey> implements SurveyFinder{
	public Integer isExistsUseDate(String surveyDivCd, long surveySeqNo, String startDate, String endDate) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.isExistsUseDate");
			
            sql.append(sqlQuery); 
            
            session=openSession();
            
            Map params = new HashMap();
            
            params.put("divCd", surveyDivCd);
            params.put("begin", surveySeqNo);
            params.put("end", startDate);
            params.put("listSize", endDate);
            
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            
            SQLQuery query = session.createSQLQuery(gBatisQuery);
            query.addScalar("validCount", Type.INTEGER);
            
            return (Integer) query.uniqueResult();
		}  catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }
		return null;
	}
	
	public List<Object[]> getSurveyQuestion(long surveySeqNo) {
		Session session=openSession();

		try {
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyQuestion");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			
			Map params = new HashMap();
			
			params.put("surveySeqNo", surveySeqNo);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDVIR_SurveyQuestion", SurveyQuestionImpl.class);
			query.addScalar("questionCnt", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}  catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        } catch (SystemException se) {
	            se.printStackTrace();
	        }
	    } finally {
	        closeSession(session);
	    }
		return null;
	}
	
	public List<Object[]> getSurveyQuestion(long surveySeqNo, long virtualLabId, long classId, long groupId) {
		Session session=openSession();
		
		try {
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyQuestionResult");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map params = new HashMap();
			
			params.put("surveySeqNo", surveySeqNo);
			if(virtualLabId > 0) {
				params.put("virtualLabId", virtualLabId);
			}
			if(classId > 0) {
				params.put("classId", classId);
			}
			
			if(groupId > 0) {
				params.put("groupId", groupId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDVIR_SurveyQuestion", SurveyQuestionImpl.class);
			query.addScalar("questionCnt", Type.INTEGER);
			query.addScalar("question1Cnt", Type.INTEGER);
			query.addScalar("question2Cnt", Type.INTEGER);
			query.addScalar("question3Cnt", Type.INTEGER);
			query.addScalar("question4Cnt", Type.INTEGER);
			query.addScalar("question5Cnt", Type.INTEGER);
			query.addScalar("question6Cnt", Type.INTEGER);
			query.addScalar("question7Cnt", Type.INTEGER);
			query.addScalar("question8Cnt", Type.INTEGER);
			query.addScalar("question9Cnt", Type.INTEGER);
			query.addScalar("question10Cnt", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}  catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<SurveyAnswer> getSurveyQuestionSubject(long surveySeqNo, long virtualLabId, long classId, String questionDivCd, long questionSeqNo,long groupId) {
		Session session=openSession();
		
		try {
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyQuestionSubject");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map <String, Object> params = new HashMap<String, Object>();
			
			params.put("surveySeqNo", surveySeqNo);
			params.put("questionDivCd", questionDivCd);
			if(virtualLabId > 0) {
				params.put("virtualLabId", virtualLabId);
			}
			params.put("questionSeqNo", questionSeqNo);
			if(classId > 0) {
				params.put("classId", classId);
			}
			
			if(groupId > 0) {
				params.put("groupId", groupId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDVIR_SurveyAnswer", SurveyAnswerImpl.class);
			
			return (List<SurveyAnswer>) query.list();
		}  catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getSurveyMappingCheckList(long virtualLabId, boolean checkDate) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyMappingCheckList");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map params = new HashMap();
			
			params.put("virtualLabId", virtualLabId);
			if(checkDate) {
				params.put("checkDate", 1);
			}
			
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_Survey", SurveyImpl.class);
			query.addScalar("virtualLabId", Type.INTEGER);
			return (List<Object[]>) query.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Survey> getSurveyMappingList(long virtualLabId, boolean checkDate) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyMappingList");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map params = new HashMap();
			
			params.put("virtualLabId", virtualLabId);
			if(checkDate) {
				params.put("checkDate", 1);
			}
			
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_Survey", SurveyImpl.class);
			return (List<Survey>) query.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getSurveyMappingVoteList(long virtualLabId, long classId, long userId, boolean checkDate) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyMappingVoteList");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map params = new HashMap();
			
			params.put("virtualLabId", virtualLabId);
			params.put("userId", userId);
			if(classId > 0) {
				params.put("classId", classId);
			}
			if(checkDate) {
				params.put("checkDate", "1");
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_Survey", SurveyImpl.class);
			query.addScalar("surveyCheck", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getSurveyResultList(long groupId, long surveySeqNo, String searchField, int begin, int end, Locale locale) {
		Session session=openSession();
		
		try {
			
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyResultListSelect");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyResultListFrom");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);
			params.put("surveySeqNo", surveySeqNo);
			params.put("searchField", searchField);
			params.put("begin", begin);
			params.put("end", end);
			params.put("languageId", locale.toString());
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			query.addEntity("EDVIR_Survey", SurveyImpl.class);
			query.addScalar("answerCount", Type.INTEGER);
			query.addScalar("surveyCheck", Type.INTEGER);
			query.addScalar("userTempCount", Type.INTEGER);
			query.addScalar("userCount", Type.INTEGER);
			query.addScalar("voteStartDate", Type.DATE);
			query.addScalar("voteEndDate", Type.DATE);
			
			return (List<Object[]>) query.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public Integer getCountSurveyResultList(long groupId, long surveySeqNo, String searchField, Locale locale) {
		Session session=openSession();
		
		try {
			
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyResultListSelectCount");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getSurveyResultListFrom");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);
			params.put("surveySeqNo", surveySeqNo);
			params.put("searchField", searchField);
			params.put("languageId", locale.toString());
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("totalCnt", Type.INTEGER);
			
			return (Integer) query.uniqueResult();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getExcelResult(long surveySeqNo, long virtualLabId, long classId,long groupId,String languageId) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getExcelResult");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("surveySeqNo", surveySeqNo);
			if(virtualLabId > 0) {
				params.put("virtualLabId", virtualLabId);
			}
			if(classId > 0) {
				params.put("classId", classId);
			}
			
			if(groupId > 0) {
				params.put("groupId", groupId);
			}
			
			if(!CustomUtil.strNull(languageId).equals("")) {
				params.put("languageId", languageId);
			}
			
			
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("classId", Type.STRING);
			query.addScalar("row1", Type.STRING);
			query.addScalar("row2", Type.STRING);
			
			return (List<Object[]>) query.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public int getCountAnswerResult(long surveySeqNo, long virtualLabId, long classId) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getCountAnswerResult");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("surveySeqNo", surveySeqNo);
			if(virtualLabId > 0) {
				params.put("virtualLabId", virtualLabId);
			}
			if(classId > 0) {
				params.put("classId", classId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("answerCnt", Type.INTEGER);
			
			return (Integer) query.uniqueResult();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public int getCountSurveyCheck(long surveySeqNo, long userId, long classId) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getCountSurveyCheck");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("surveySeqNo", surveySeqNo);
			params.put("userId", userId);
			if(classId > 0) {
				params.put("classId", classId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("surveyCheck", Type.INTEGER);
			
			return (Integer) query.uniqueResult();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	public List<Long> getQuestionSeqList(long surveySeqNo) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getQuestionSeqList");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("surveySeqNo", surveySeqNo);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("questionSeqNo", Type.LONG);
			
			return (List<Long>) query.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public Long getMaxQuestionSeq(long virtualLabId) {
		Session session=openSession();
		
		try {
			
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.Survey.getMaxQuestionSeq");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("virtualLabId", virtualLabId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("questionSeqNo", Type.LONG);
			
			return (Long) query.uniqueResult();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
}
