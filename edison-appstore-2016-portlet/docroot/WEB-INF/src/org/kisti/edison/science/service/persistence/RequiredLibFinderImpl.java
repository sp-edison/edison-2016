package org.kisti.edison.science.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.science.model.RequiredLibConfirm;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.impl.RequiredLibConfirmImpl;
import org.kisti.edison.science.model.impl.ScienceAppCategoryLinkImpl;
import org.kisti.edison.science.model.impl.ScienceAppImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class RequiredLibFinderImpl extends BasePersistenceImpl<ScienceApp> implements RequiredLibFinder {
	
	public static final String GET_REQUIRED_LIB_HEADER =
			RequiredLibFinder.class.getName() +
			".getRequiredLib.header";

	public static final String GET_COUNT_REQUIRED_LIB_HEADER =
			RequiredLibFinder.class.getName() +
			".getCountRequiredLib.header";
	
	public static final String GET_REQUIRED_LIB_WHERE =
			RequiredLibFinder.class.getName() +
			".requiredLib.where";
	
	public static final String GET_REQUIRED_LIB_LIMIT =
			RequiredLibFinder.class.getName() +
			".requiredLib.limit";
	
	public int getCountRequiredLib(Map<String,Object> searchParam) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		//DB Cache Clear
		CacheRegistryUtil.clear();
		try{
			
			String sqlQuerySelect = CustomSQLUtil.get(GET_COUNT_REQUIRED_LIB_HEADER);
			String sqlQuery = CustomSQLUtil.get(GET_REQUIRED_LIB_WHERE);
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			
			session = openSession();
			String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("totalCount", Type.INTEGER);
			
			return (Integer)query.uniqueResult();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Object[]> getRequiredLibList(Map<String,Object> searchParam) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		//DB Cache Clear
		CacheRegistryUtil.clear();
		try{
			
			String sqlQuerySelect = CustomSQLUtil.get(GET_REQUIRED_LIB_HEADER);
			String sqlQuery = CustomSQLUtil.get(GET_REQUIRED_LIB_WHERE);
			String sqlQueryLimit = CustomSQLUtil.get(GET_REQUIRED_LIB_LIMIT);
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			sqlSb.append(sqlQueryLimit);
			
			session = openSession();
			String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDAPP_RequiredLibConfirm", RequiredLibConfirmImpl.class);
			query.addScalar("name", Type.STRING);
			
			return (List<Object[]>) query.list();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Object[]> getRequiredLib(Map<String,Object> searchParam) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		//DB Cache Clear
		CacheRegistryUtil.clear();
		try{
			
			String sqlQuerySelect = CustomSQLUtil.get(GET_REQUIRED_LIB_HEADER);
			String sqlQuery = CustomSQLUtil.get(GET_REQUIRED_LIB_WHERE);
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			
			session = openSession();
			String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDAPP_RequiredLibConfirm", RequiredLibConfirmImpl.class);
			query.addScalar("name", Type.STRING);
			
			return (List<Object[]>) query.list();
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	

}
