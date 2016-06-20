package org.kisti.edison.science.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.PortTypeEditorLink;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.impl.PortTypeEditorLinkImpl;
import org.kisti.edison.science.model.impl.ScienceAppImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class PortTypeEditorLinkFinderImpl extends BasePersistenceImpl<PortTypeEditorLink>
    implements PortTypeEditorLinkFinder{
  
  private Log log = LogFactoryUtil.getLog(getClass());
  
  public static final String GET_PORTTYPE_EDITORLINK_HEADER =
      PortTypeEditorLinkFinder.class.getName() +
            ".retrieveListPortTypeEditorLink.header";
  
  public static final String GET_PORTTYPE_EDITORLINK_WHERE =
      PortTypeEditorLinkFinder.class.getName() +
            ".retrieveListPortTypeEditorLink.where";
  
  public static final String GET_PORTTYPE_EDITORLINK =
	      PortTypeEditorLinkFinder.class.getName() +
	            ".retrieveListPortTypeEditorLink";

  @SuppressWarnings("unchecked")
  public List<Object[]> retrieveListPortTypeEditorLink(final long portTypeId)
      throws SystemException{
    StringBuilder sb = new StringBuilder();
    Session session = null;
    
    try{
      String sqlQuerySelect = CustomSQLUtil.get(GET_PORTTYPE_EDITORLINK_HEADER);
      String sqlQuery = CustomSQLUtil.get(GET_PORTTYPE_EDITORLINK_WHERE);
      sb.append(sqlQuerySelect);
      sb.append(sqlQuery);
      
      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(new HashMap<String, Object>(){
        private static final long serialVersionUID = 1L; {
        put("portTypeId", portTypeId);
      }}, sb.toString());
      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addEntity("EDAPP_PortTypeEditorLink", PortTypeEditorLinkImpl.class);
      query.addEntity("EDAPP_ScienceApp", ScienceAppImpl.class);
      
      return (List<Object[]>)query.list();
    }catch(Exception e){
      log.error(e);
      throw new SystemException(e);
    }finally {
      closeSession(session);
    }
  }
  
	public List<Object[]> retrieveListPortTypeEditorLinkWithAppName(long companyId, long portTypeId){
		Session session = openSession();
		try{
			String sqlQuery = CustomSQLUtil.get(GET_PORTTYPE_EDITORLINK);
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery);
			
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("companyId", companyId);
			params.put("portTypeId", portTypeId);
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDAPP_PortTypeEditorLink", PortTypeEditorLinkImpl.class);
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
