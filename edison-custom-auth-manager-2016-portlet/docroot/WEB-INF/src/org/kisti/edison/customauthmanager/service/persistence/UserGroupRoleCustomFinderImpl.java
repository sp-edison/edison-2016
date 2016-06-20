package org.kisti.edison.customauthmanager.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class UserGroupRoleCustomFinderImpl extends BasePersistenceImpl<UserGroupRoleCustom> implements UserGroupRoleCustomFinder{

	public Long getClassVirtualLabId(long classId) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.getClassVirtualLabId");
			
			sql.append(sqlSelect); 

			session=openSession();

			Map params = new HashMap();
			
			params.put("classId", classId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("virtualLabId", Type.LONG);
			
			return (Long) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object[] getSiteLeaveOwnerTotalCnt(long userId, long labRoleId, long groupId, long classRoleId) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.getSiteLeaveOwnerTotalCnt");
			
			sql.append(sqlSelect); 
			
			session=openSession();
			
			Map params = new HashMap();
			
			params.put("userId", userId);
			params.put("labRoleId", labRoleId);
			params.put("groupId", groupId);
			params.put("classRoleId", classRoleId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("appOwnerCnt", Type.INTEGER);
			query.addScalar("contentOwnerCnt", Type.INTEGER);
			query.addScalar("labOwnerCnt", Type.INTEGER);
			query.addScalar("classOwnerCnt", Type.INTEGER);
			
			return (Object[]) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Object[]> getContentOwnerList(long userId, long roleId, long groupId, String languageId){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.getContentAuthJoinSelect");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.getAuthWhere");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("userId", userId);
			params.put("roleId", roleId);
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());

			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("userId", Type.LONG); 
			query.addScalar("groupId", Type.LONG); 
			query.addScalar("contentSeq", Type.LONG); 
			query.addScalar("contentDiv", Type.LONG); 
			query.addScalar("title", Type.STRING); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getVirtualLabOwnerList(long userId, long roleId, long groupId, String languageId){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.getVirtualLabAuthJoinSelect");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.getAuthWhere");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("userId", userId);
			params.put("roleId", roleId);
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());

			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("userId", Type.LONG); 
			query.addScalar("groupId", Type.LONG); 
			query.addScalar("virtualLabPersonName", Type.STRING); 
			query.addScalar("virtualLabTitle", Type.STRING); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	public List<Object[]> getVirtaulClassOwnerList(long userId, long roleId, long groupId, String languageId){
		Session session=openSession();
		try{
			String sqlQuerySelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.getVirtualClassAuthJoinSelect");
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.getAuthWhere");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuerySelect);
			sql.append(sqlQuery);
			
			Map params = new HashMap();
			
			params.put("userId", userId);
			params.put("roleId", roleId);
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());

			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("userId", Type.LONG); 
			query.addScalar("groupId", Type.LONG); 
			query.addScalar("classTitle", Type.STRING); 
			
			return (List<Object[]>) query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return null;
	}
	
	
}