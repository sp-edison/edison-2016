package org.kisti.edison.virtuallaboratory.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.util.GBatisUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClass;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabImpl;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VirtualLabClassFinderImpl extends BasePersistenceImpl<VirtualLabClass> implements VirtualLabClassFinder{
	public static final String sqlPath = "org.kisti.edison.service.persistence.virtualLabClass.";

	public Object[] getVirtualClassInfo(long classId) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath + "getVirtualClassInfo");
			
			sqlSb.append(sqlQuery);
			
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("classId", classId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			
			return (Object[]) query.uniqueResult();
		} catch (Exception e) {
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

	public List<Object[]> getVirtualClassList(Map params) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath + "getVirtualClassList");
			
			sqlSb.append(sqlQuery);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
//			Map params = new HashMap();
//			
//			params.put("groupId", groupId);
//			params.put("virtualLabId", virtualLabId);
//			params.put("begin", begin);
//			params.put("end", end);
//			
//			if (classIdList != null && classIdList.size() > 0) {
//				params.put("classIdList", classIdList.toString().replace("[", "(").replace("]", ")"));
//			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			query.addScalar("tempUserCount", Type.INTEGER);
			query.addScalar("userCount", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		} catch (Exception e) {
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
	
	public int getVirtualClassListCount(Map params) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath + "getVirtualClassListCount");
			
			sqlSb.append(sqlQuery);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
//			Map params = new HashMap();
//			params.put("groupId", groupId);
//			params.put("virtualLabId", virtualLabId);
//			
//			if (classIdList != null && classIdList.size() > 0) {
//				params.put("classIdList", classIdList.toString().replace("[", "(").replace("]", ")"));
//			}
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("TotalCnt", Type.INTEGER);
			
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
	
	public List<Long> getVirtualClassBoardSeqList(long groupId, long classId) {
		Session session=openSession();
		
		try {
			String sqlQuery = CustomSQLUtil.get("org.kisti.edison.service.persistence.virtualLabClass.getVirtualClassBoardSeqList");
			
			StringBuffer sql = new StringBuffer();
			sql.append(sqlQuery); 
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);
			params.put("virtualClassCustomId", "class_" + classId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("boardSeq", Type.LONG);
			
			return (List<Long>) query.list();
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
	
	public List<Object[]> getVirtualClassStatisticsList(Map params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath + "getVirtualClassStatisticsList");
			
			sqlSb.append(sqlQuery);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			params.put("languageId", locale.toString());
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("groupId", Type.INTEGER);//0
			query.addScalar("university", Type.STRING);//0
			query.addScalar("classTitle", Type.STRING);//1
			query.addScalar("virtualLabPersonName", Type.STRING);//2
			query.addScalar("registerStudentCnt", Type.INTEGER);//3
			query.addScalar("classId", Type.STRING);//4
			query.addScalar("executeCount", Type.INTEGER);//5
			query.addScalar("executeStudentcount", Type.INTEGER);//6
			query.addScalar("scienceAppTitle", Type.STRING);//7
			query.addScalar("avgerageRuntime", Type.INTEGER);//8
			
			return (List<Object[]>) query.list();
		} catch (Exception e) {
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
	
	
	public int getCountVirtualClassStatistics(Map params , Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath + "getCountVirtualClassStatistics");
			
			sqlSb.append(sqlQuery);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("TotalCnt", Type.INTEGER);
			
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
	
	public List<Object[]> getVirtualClassStatisticsExcelList(Map params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath + "getVirtualClassStatisticsExcelList");
			
			sqlSb.append(sqlQuery);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("university", Type.STRING);//0
			query.addScalar("classTitle", Type.STRING);//1
			query.addScalar("virtualLabPersonName", Type.STRING);//2
			query.addScalar("scienceAppTitle", Type.STRING);//7
			query.addScalar("registerStudentCnt", Type.INTEGER);//3
			query.addScalar("executeCount", Type.INTEGER);//5
			query.addScalar("classId", Type.STRING);//4
			query.addScalar("executeStudentcount", Type.INTEGER);//6
			query.addScalar("avgerageRuntime", Type.INTEGER);//8

			return (List<Object[]>) query.list();
		} catch (Exception e) {
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
