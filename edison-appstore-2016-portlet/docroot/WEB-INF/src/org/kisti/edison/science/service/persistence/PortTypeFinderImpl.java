package org.kisti.edison.science.service.persistence;

import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.PortType;
import org.kisti.edison.science.model.impl.PortTypeImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class PortTypeFinderImpl extends BasePersistenceImpl<PortType> implements PortTypeFinder {
	public static final String GET_PORTTYPE_COUNT_HEADER =
			PortTypeFinder.class.getName() +
			".countPortType.header";
	
	public static final String GET_PORTTYPE_HEADER =
			PortTypeFinder.class.getName() +
		        ".retrieveListPortType.header";
	
	public static final String GET_PORTTYPE_WHERE =
			PortTypeFinder.class.getName() +
		        ".portType.where";
	
	public int countPortType(Map<String,Object> searchParam) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		int cnt = 0;
		
		try{
			String sqlSelect = CustomSQLUtil.get(GET_PORTTYPE_COUNT_HEADER);
			String sqlWhere = CustomSQLUtil.get(GET_PORTTYPE_WHERE);
			sqlSb.append(sqlSelect);
		    sqlSb.append(sqlWhere);
			
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
	
	public List<Object[]> retrieveListPortType(Map<String,Object> searchParam) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		try{
			String sqlSelect = CustomSQLUtil.get(GET_PORTTYPE_HEADER);
			String sqlWhere = CustomSQLUtil.get(GET_PORTTYPE_WHERE);
			sqlSb.append(sqlSelect);
		    sqlSb.append(sqlWhere);
		    
		    searchParam.put("selectPortType", "select");
			
			session = openSession();
			String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDAPP_PortType", PortTypeImpl.class);
			query.addScalar("editorCnt", Type.INTEGER);
			query.addScalar("analyzerCnt", Type.INTEGER);
			query.addScalar("inputdeckCnt", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
}
