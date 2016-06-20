package org.kisti.edison.science.service.persistence;

import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.CommonLib;
import org.kisti.edison.science.model.impl.CommonLibImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CommonLibFinderImpl extends BasePersistenceImpl<CommonLib> implements CommonLibFinder{
	public static final String GET_COMMONLIB_COUNT_HEADER =
			PortTypeFinder.class.getName() +
			".countCommonLibHeader";
	public static final String GET_COMMONLIB_HEADER =
			PortTypeFinder.class.getName() +
			".retrieveListCommonLibHeader";
	public static final String GET_COMMONLIB_WHERE =
			PortTypeFinder.class.getName() +
			".retrieveListCommonLibWhere";
	
	
	public int countCommonLib(Map<String,Object> searchParam) throws SystemException {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		int cnt = 0;
		
		try{
			String sqlQuerySelect = CustomSQLUtil.get(GET_COMMONLIB_COUNT_HEADER);
			String sqlQuery = CustomSQLUtil.get(GET_COMMONLIB_WHERE);
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			
			session = openSession();
			String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("totalCnt", Type.INTEGER);
			
			cnt = (Integer) query.uniqueResult();
		}catch(Exception e){
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return cnt;
	}
	
	
	public List<CommonLib> retrieveListCommonLib(Map<String,Object> searchParam) throws SystemException {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		try{
			String sqlQuerySelect = CustomSQLUtil.get(GET_COMMONLIB_HEADER);
			String sqlQuery = CustomSQLUtil.get(GET_COMMONLIB_WHERE);
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			
			session = openSession();
			String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDAPP_CommonLib", CommonLibImpl.class);
			
			return (List<CommonLib>) query.list();
		}catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
}
