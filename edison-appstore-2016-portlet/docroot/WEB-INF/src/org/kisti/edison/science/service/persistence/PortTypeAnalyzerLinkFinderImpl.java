package org.kisti.edison.science.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.PortTypeAnalyzerLink;
import org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class PortTypeAnalyzerLinkFinderImpl extends BasePersistenceImpl<PortTypeAnalyzerLink>
  implements PortTypeAnalyzerLinkFinder{

	
	public static final String GET_PORTTYPE_ANALYZERLINK =
			PortTypeAnalyzerLinkFinder.class.getName() +
		            ".retrieveListPortTypeAnalyzerLink";
	
	public List<Object[]> retrieveListPortTypeAnalyzerLinkWithAppName(long companyId, long portTypeId){
		Session session = openSession();
		try{
			String sqlQuery = CustomSQLUtil.get(GET_PORTTYPE_ANALYZERLINK);
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("companyId", companyId);
			params.put("portTypeId", portTypeId);
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDAPP_PortTypeAnalyzerLink", PortTypeAnalyzerLinkImpl.class);
			query.addScalar("name", Type.STRING);
			
			return (List<Object[]>)query.list();
				
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}
}
