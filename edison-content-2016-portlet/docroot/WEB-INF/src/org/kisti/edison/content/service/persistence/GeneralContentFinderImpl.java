package org.kisti.edison.content.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.content.model.GeneralContent;
import org.kisti.edison.content.model.impl.GeneralContentImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class GeneralContentFinderImpl extends BasePersistenceImpl<GeneralContent> implements GeneralContentFinder{
	
	public int getGeneralContentCount(long groupId, long contentDiv,String searchText,Locale locale){
		Session session = openSession();
		int cnt = 0;
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getCountGeneralHeader");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getCountGeneralContent");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);

			if(contentDiv != 0){
				params.put("contentDiv", contentDiv);
			}
			
			params.put("searchText", searchText);
			params.put("languageId", locale.toString());
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("totalCnt", Type.INTEGER);			
			
			cnt = (Integer) query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return cnt;
		
	}
	public List<Object[]> getGeneralContentList(long groupId,long contentDiv, String searchText, int start, int end,Locale locale){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getListGeneralHeader");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getCountGeneralContent");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);
			
			if(contentDiv != 0){
				params.put("contentDiv", contentDiv);
			}
			params.put("searchText", searchText);
			params.put("languageId", locale.toString());
			params.put("begin", start);
			params.put("end",end);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDMED_GeneralContent", GeneralContentImpl.class);
			query.addScalar("screenName", Type.STRING); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	public Object[] getGeneralContent(long groupId,long contentSeq, Locale locale){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getListGeneralHeader");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getCountGeneralContent");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);
			params.put("contentSeq", contentSeq);
			params.put("languageId", locale.toString());
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDMED_GeneralContent", GeneralContentImpl.class);
			
			return (Object[]) query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getGeneralContentForProjectList(long userId, String searchText , String projectCategoryId, String languageId, int start, int end){
		Session session=openSession();
		try{
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getListGeneralForProject");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			if(userId != 0){
				params.put("userId", userId);
			}
			if(!projectCategoryId.equals("0")){
				params.put("projectCategoryId", projectCategoryId);
				
			}
			
			params.put("languageId", languageId);
			params.put("searchText", searchText);
			params.put("begin", start);
			params.put("end",end);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDMED_GeneralContent", GeneralContentImpl.class);
			query.addScalar("screenName", Type.STRING); 
			query.addScalar("firstName", Type.STRING); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	public int getGeneralContentForProjectListCount(long userId, String searchText,  String projectCategoryId, String languageId){
		Session session = openSession();
		int cnt = 0;
		try{
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getListGeneralForProjectListCont");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			if(userId != 0){
				params.put("userId", userId);
			}

			if(!projectCategoryId.equals("0")){
				params.put("projectCategoryId", projectCategoryId);
				
			}
			params.put("languageId", languageId);
			params.put("searchText", searchText);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("totalCnt", Type.INTEGER);			
			
			cnt = (Integer) query.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return cnt;
		
	}
}
