package org.kisti.edison.project.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.project.model.HistoryContent;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class HistoryContentFinderImpl extends BasePersistenceImpl<HistoryContent> implements HistoryContentFinder{

	
	public List<Object[]> getContentCenterList(String projectYn, String propertyKey){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getRegistSwContentHeader");
			String sqlQueryJoin = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getRegistContentBody");
			String sqlQueryGroupBy = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getRegistSwContentFrom");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQueryJoin);
			sql.append(sqlQueryGroupBy);
			
			Map param = new HashMap();
			param.put("projectYn", projectYn);
			param.put("propertyKey", propertyKey);
			
			String gBatisQuery = GBatisUtil.getGBatis(param, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);


			query.addScalar("categoryId", Type.LONG); 
			query.addScalar("name", Type.STRING); 
			query.addScalar("key_", Type.STRING); 
			query.addScalar("value", Type.STRING); 
			query.addScalar("CONCNT", Type.INTEGER); 
			query.addScalar("HISCONCNT", Type.INTEGER); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	
	public List<Object[]> getContentDatailList(String projectYn, long columnId,long categoryId, String languageId){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.project.service.persistence.getContentDetail");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			
			Map param = new HashMap();
			param.put("languageId", languageId);
			param.put("projectYn", projectYn);
			param.put("columnId", columnId);
			
			if(categoryId != 0){
				param.put("categoryId", categoryId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(param, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("categoryId", Type.LONG); 
			query.addScalar("name", Type.STRING); 
			query.addScalar("key_", Type.STRING); 
			query.addScalar("value", Type.STRING); 
			query.addScalar("title", Type.STRING); 
			query.addScalar("screenName", Type.STRING); 
			query.addScalar("firstName", Type.STRING); 
			query.addScalar("insertId", Type.LONG); 
			query.addScalar("insertDate", Type.STRING); 
			query.addScalar("affiliation", Type.LONG); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
}
