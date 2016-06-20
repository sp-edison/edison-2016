package org.kisti.edison.content.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.content.model.OrgImgContent;
import org.kisti.edison.content.model.impl.OrgImgContentImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class OrgImgContentFinderImpl extends BasePersistenceImpl<OrgImgContent> implements OrgImgContentFinder{
	
	public List<OrgImgContent> getOrderOrgImgContentList(long groupId, long order){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.content.service.persistence.getListOrderOrgImgContent");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			
			Map params = new HashMap();
			params.put("groupId", groupId);
			params.put("order", order);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDMED_OrgImgContent", OrgImgContentImpl.class);
			
			return (List<OrgImgContent>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
}
