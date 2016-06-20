package org.kisti.edison.project.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.project.model.HistoryScienceApp;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class HistoryScienceAppFinderImpl extends BasePersistenceImpl<HistoryScienceApp> implements HistoryScienceAppFinder{
	
	public List<Object[]> getMajorAchievementsList(String projectYn, String key){
		Session session=openSession();
		try{
			String select = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getMajorAchievementsSelectHeader");
			
			StringBuffer sql = new StringBuffer();
			sql.append(select);
			
			Map param = new HashMap();

			param.put("projectYn", projectYn);
			param.put("propertyKey", key);
			
			String gBatisQuery = GBatisUtil.getGBatis(param, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("categoryId", Type.LONG); 
			query.addScalar("name", Type.STRING); 
			query.addScalar("key_", Type.STRING); 
			query.addScalar("value", Type.STRING); 
			query.addScalar("CONCNT", Type.INTEGER); 
			query.addScalar("HISCONCNT", Type.INTEGER); 
			query.addScalar("APPCNT", Type.INTEGER); 
			query.addScalar("HISAPPCNT", Type.INTEGER); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	public List<Object[]> getScienceAppCenterList(String propertyKey){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getRegistSwContentHeader");
			String sqlQueryJoin = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getRegistSwBody");
			String sqlQueryGroupBy = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getRegistSwContentFrom");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQueryJoin);
			sql.append(sqlQueryGroupBy);
			

			Map param = new HashMap();
			param.put("propertyKey", propertyKey);
			
			String gBatisQuery = GBatisUtil.getGBatis(param, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("categoryId", Type.LONG); 
			query.addScalar("name", Type.STRING); 
			query.addScalar("key_", Type.STRING); 
			query.addScalar("value", Type.STRING); 
			query.addScalar("APPCNT", Type.INTEGER); 
			query.addScalar("HISAPPCNT", Type.INTEGER); 
			
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	
	public List<Object[]> getAppDetailList(long jobPhase, long columnId, long categoryId, String languageId){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getAppDetail");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			
			Map params = new HashMap();
			
			params.put("jobPhase", jobPhase);
			params.put("columnId", columnId);
			params.put("languageId", languageId);
			
			if(categoryId != 0){
				params.put("categoryId", categoryId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("scienceAppId", Type.LONG); 
			query.addScalar("groupId", Type.LONG); 
			query.addScalar("categoryId", Type.LONG); 
			query.addScalar("name", Type.STRING); 
			query.addScalar("key_", Type.STRING); 
			query.addScalar("value", Type.STRING); 
			query.addScalar("title", Type.STRING); 
			query.addScalar("data_", Type.LONG); 
			query.addScalar("authorId", Type.LONG); 
			query.addScalar("firstName", Type.STRING); 
			query.addScalar("screenName", Type.STRING); 
			query.addScalar("version", Type.STRING); 
			query.addScalar("runtime", Type.LONG); 
			query.addScalar("executeCount", Type.INTEGER); 
			query.addScalar("averageRuntime", Type.LONG); 
			query.addScalar("userCount", Type.INTEGER); 
			query.addScalar("createDate", Type.STRING); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
}
