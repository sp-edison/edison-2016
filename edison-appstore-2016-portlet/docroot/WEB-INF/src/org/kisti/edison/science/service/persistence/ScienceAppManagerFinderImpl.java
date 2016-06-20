package org.kisti.edison.science.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.ScienceAppManager;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ScienceAppManagerFinderImpl extends BasePersistenceImpl<ScienceAppManager> implements ScienceAppManagerFinder {
	
	public static final String GET_MY_APP_MANAGER_LIST = ScienceAppManagerFinder.class.getName() +".getAppManagerList";
	
	public List<Object[]> getScienceAppManagerList(long userId, long groupId) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	    	String sqlQuery = CustomSQLUtil.get(GET_MY_APP_MANAGER_LIST);
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("userId", userId);
			params.put("groupId", groupId);

			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
	        SQLQuery query = session.createSQLQuery(gBatisQuery);
	        query.addScalar("scienceAppManagerId", Type.LONG);
	        query.addScalar("scienceAppId", Type.LONG);
	        query.addScalar("groupId", Type.LONG);
	        query.addScalar("userId", Type.LONG);
	
			return (List<Object[]>) query.list();
	    }catch(Exception e){
			e.printStackTrace();
		} finally{
	    	super.closeSession(session);
	    }
	    return null;
	} 
	
}
