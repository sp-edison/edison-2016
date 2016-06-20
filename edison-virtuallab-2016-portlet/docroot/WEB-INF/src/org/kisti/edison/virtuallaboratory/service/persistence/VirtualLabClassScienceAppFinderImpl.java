package org.kisti.edison.virtuallaboratory.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.util.GBatisUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VirtualLabClassScienceAppFinderImpl extends BasePersistenceImpl<VirtualLabClassScienceApp> implements VirtualLabClassScienceAppFinder {
	public List<Object[]> getVirtualLabClassScienceAppList(long entryId, long vocabularyId, long columnId, long classId, Locale locale) {
		Session session=openSession();
		
		try {
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.VirtualLabClassScienceApp.getVirtualLabClassScienceAppList");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map params = new HashMap();
			
			params.put("entryId", entryId);
			params.put("vocabularyId", vocabularyId);
			params.put("columnId", columnId);
			params.put("classId", classId);
			params.put("languageId", locale.toString());
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("scienceAppId", Type.LONG);
			query.addScalar("name", Type.STRING);
			query.addScalar("title", Type.STRING);
			query.addScalar("version", Type.STRING);
			query.addScalar("userId", Type.LONG);
			query.addScalar("universityNm", Type.STRING);
			query.addScalar("scienceAppSeqNo", Type.LONG);
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
	
	public List<Object[]> getScienceAppList(long entryId, long vocabularyId, long columnId, long classId, String searchField, Locale locale) {
		Session session=openSession();
		
		try {
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.VirtualLabClassScienceApp.getScienceAppList");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map params = new HashMap();
			
			params.put("entryId", entryId);
			params.put("vocabularyId", vocabularyId);
			params.put("columnId", columnId);
			params.put("classId", classId);
			if(searchField != null && !searchField.equals("")) {
				params.put("searchField", searchField);
			}
			params.put("languageId", locale.toString());
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("scienceAppId", Type.LONG);
			query.addScalar("name", Type.STRING);
			query.addScalar("version", Type.STRING);
			query.addScalar("userId", Type.LONG);
			query.addScalar("scienceAppTitleSearchField", Type.STRING);
			query.addScalar("scienceAppCheck", Type.INTEGER);
			
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
}
