package org.kisti.edison.virtuallaboratory.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.util.GBatisUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserImpl;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VirtualLabUserFinderImpl extends BasePersistenceImpl<VirtualLabUser> implements VirtualLabUserFinder{
	public static final String sqlPath = "org.kisti.edison.service.persistence.virtualLabUser.";

	public List<Object[]> getVirtualClassStudentList(long virtualLabId, long classId, long questionSeqNo, String search_parameter, long groupId) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getListVirtualClassStudentList");
			
			sqlSb.append(sqlSelect);
			
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("virtualLabId", virtualLabId);
			params.put("classId", classId);
			params.put("questionSeqNo", questionSeqNo);
			params.put("groupId", groupId);
			if(search_parameter != null && !search_parameter.equals("")) {
				params.put("search_parameter", search_parameter);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("VirtualLabUser", VirtualLabUserImpl.class);
			query.addScalar("surveyCheck", Type.INTEGER);
			query.addScalar("executeCount", Type.STRING);
			
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
	
	public Object[] getCountVirtualClassRegisterUserList(long classId) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getCountVirtualClassRegisterUserList");
			
			sqlSb.append(sqlSelect);
			
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("classId", classId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("tempUserCount", Type.INTEGER);
			query.addScalar("userCount", Type.INTEGER);
			return (Object[]) query.uniqueResult();
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
	
	public VirtualLabUser getVirtualLabUserInfo(long classId, long userId) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getVirtualLabUserInfo");
			
			sqlSb.append(sqlSelect);
			
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("classId", classId);
			params.put("userId", userId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("VirtualLabUser", VirtualLabUserImpl.class);
			
			return (VirtualLabUser) query.uniqueResult();
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
	
	public int getStudentCount(long virtualLabId, long classId) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getStudentCount");
			
			sqlSb.append(sqlSelect);
			
			session = openSession();
			
			Map params = new HashMap();
			
			if(virtualLabId > 0) {
				params.put("virtualLabId", virtualLabId);
			}
			if(classId > 0) {
				params.put("classId", classId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("studentCount", Type.INTEGER);
			
			return (Integer) query.uniqueResult();
		}  catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return 0;
	}
	
	
	public List<Object[]> getUserGroupClassUser(long userId, long groupId) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getUserGroupClassUser");
			
			sqlSb.append(sqlSelect);
			
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("userId", userId);
			params.put("groupId", groupId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("virtualLabUserId", Type.STRING);
			query.addScalar("userId", Type.LONG);
			query.addScalar("groupId", Type.LONG);
			query.addScalar("classId", Type.LONG);
			
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
