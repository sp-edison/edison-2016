package org.kisti.edison.virtuallaboratory.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.GBatisUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLab;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VirtualLabFinderImpl extends BasePersistenceImpl<VirtualLab> implements VirtualLabFinder{
	public static final String sqlPath2 = "org.kisti.edison.virtuallaboratory.service.persistence.virtualLab.";
	
	public List<Object[]> getVirtualLabAuthList(long groupId, long userId) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getVirtualLabAuthList");
			
			sqlSb.append(sqlQuery);
			
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);
			params.put("userId", userId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			query.addScalar("classCount", Type.INTEGER);
			
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
	
	public List<Object[]> getVirtualLabClassRegisterList(long groupId, long userId) {
		StringBuilder sqlSb = new StringBuilder();
		
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getVirtualLabClassRegisterList");
			
			sqlSb.append(sqlQuery);
			
			session = openSession();
			
			Map params = new HashMap();
			
			if(groupId > 0) {
				params.put("groupId", groupId);
			}
			params.put("userId", userId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			query.addEntity("EDVIR_VirtualLabUser", VirtualLabUserImpl.class);
			
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
	
	public Object[] getVirtualLabClassRegisterInfo(long classId, long userId, long groupId) {
		StringBuilder sqlSb = new StringBuilder();
		
		Session session = null;
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getVirtualLabClassRegisterInfo");
			
			sqlSb.append(sqlQuery);
			
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("groupId", groupId);
			params.put("userId", userId);
			params.put("classId", classId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			query.addEntity("EDVIR_VirtualLabUser", VirtualLabUserImpl.class);
			
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
	
	public List<Object[]> getListVirtualLab(Map<String, Object> params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String statusSort = CustomUtil.strNull(params.get("statusSort"));
		
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getListVirtualLab");
			
			sqlSb.append(sqlQuery);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
			params.put("languageId", locale.toString());
//			if (labIdList != null && labIdList.size() > 0) {
//				params.put("labIdList", labIdList.toString().replace("[", "(").replace("]", ")"));
//			}
			if(statusSort == null || statusSort.equals("0")) {
				params.remove("statusSort");
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addScalar("classCount", Type.INTEGER);
			
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

	public int getCountVirtualLab(Map<String, Object> params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String statusSort = CustomUtil.strNull(params.get("statusSort"));
		
		params.remove("begin");
		
		try {
			String sqlCountStart = CustomSQLUtil.get(sqlPath2 + "getCountVirtualLabStart");
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getListVirtualLab");
			String sqlCountEnd = CustomSQLUtil.get(sqlPath2 + "getCountVirtualLabEnd");
			
			sqlSb.append(sqlCountStart);
			sqlSb.append(sqlQuery);
			sqlSb.append(sqlCountEnd);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
			params.put("languageId", locale.toString());
//			if (labIdList != null && labIdList.size() > 0) {
//				params.put("labIdList", labIdList.toString().replace("[", "(").replace("]", ")"));
//			}
			if(statusSort == null || statusSort.equals("0")) {
				params.remove("statusSort");
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("totalCount", Type.INTEGER);
			
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
	
	public List<Object[]> getListVirtualLabClass(Map<String, Object> params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String statusSort = CustomUtil.strNull(params.get("statusSort"));
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClass");
			String sqlLimit = CustomSQLUtil.get(sqlPath2 + "limit");
			
			sqlSb.append(sqlQuery);
			sqlSb.append(sqlLimit);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
			params.put("languageId", locale.toString());
			if(statusSort == null || statusSort.equals("0")) {
				params.remove("statusSort");
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			query.addScalar("classCount", Type.INTEGER);
			query.addScalar("tempUserCount", Type.INTEGER);
			query.addScalar("userCount", Type.INTEGER);
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
	
	public List<Object[]> getListVirtualLabClass2(Map<String, Object> params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String statusSort = CustomUtil.strNull(params.get("statusSort"));
		
		try {
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClass2");
			
			sqlSb.append(sqlQuery);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
			params.put("languageId", locale.toString());
			if(statusSort == null || statusSort.equals("0")) {
				params.remove("statusSort");
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDVIR_VirtualLab", VirtualLabImpl.class);
			query.addEntity("EDVIR_VirtualLabClass", VirtualLabClassImpl.class);
			query.addScalar("classCount", Type.INTEGER);
			query.addScalar("tempUserCount", Type.INTEGER);
			query.addScalar("userCount", Type.INTEGER);
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
	
	public int getCountVirtualLabClass(Map<String, Object> params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String statusSort = CustomUtil.strNull(params.get("statusSort"));
		
		try {
			String sqlCountSelect = CustomSQLUtil.get(sqlPath2 + "getCountVirtualLabStart");
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClass");
			String sqlCountEnd = CustomSQLUtil.get(sqlPath2 + "getCountVirtualLabEnd");
			
			sqlSb.append(sqlCountSelect);
			sqlSb.append(sqlQuery);
			
//			if ((labIdList != null && labIdList.size() > 0) && (classIdList != null && classIdList.size() > 0)) {
//				String sqlClassWhere1 = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClassWhere1");
//				sqlSb.append(sqlClassWhere1);
//			} else if (labIdList != null && labIdList.size() > 0) {
//				String sqlClassWhere2 = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClassWhere2");
//				sqlSb.append(sqlClassWhere2);
//			} else if (classIdList != null && classIdList.size() > 0) {
//				String sqlClassWhere3 = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClassWhere3");
//				sqlSb.append(sqlClassWhere3);
//			}
			
			sqlSb.append(sqlCountEnd);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
			params.put("languageId", locale.toString());
			if(statusSort == null || statusSort.equals("0")) {
				params.remove("statusSort");
			}
//			if (labIdList != null && labIdList.size() > 0) {
//				params.put("labIdList", labIdList.toString().replace("[", "(").replace("]", ")"));
//			}
//			if (classIdList != null && classIdList.size() > 0) {
//				params.put("classIdList", classIdList.toString().replace("[", "(").replace("]", ")"));
//			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("totalCount", Type.INTEGER);
			
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
	
	public int getCountVirtualLabClass2(Map<String, Object> params, Locale locale) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String statusSort = CustomUtil.strNull(params.get("statusSort"));
		
		params.remove("begin");
		
		try {
			String sqlCountSelect = CustomSQLUtil.get(sqlPath2 + "getCountVirtualLabStart2");
			String sqlQuery = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClass2");
			String sqlCountEnd = CustomSQLUtil.get(sqlPath2 + "getCountVirtualLabEnd");
			
			sqlSb.append(sqlCountSelect);
			sqlSb.append(sqlQuery);
			
//			if ((labIdList != null && labIdList.size() > 0) && (classIdList != null && classIdList.size() > 0)) {
//				String sqlClassWhere1 = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClassWhere1");
//				sqlSb.append(sqlClassWhere1);
//			} else if (labIdList != null && labIdList.size() > 0) {
//				String sqlClassWhere2 = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClassWhere2");
//				sqlSb.append(sqlClassWhere2);
//			} else if (classIdList != null && classIdList.size() > 0) {
//				String sqlClassWhere3 = CustomSQLUtil.get(sqlPath2 + "getListVirtualLabClassWhere3");
//				sqlSb.append(sqlClassWhere3);
//			}
			
			sqlSb.append(sqlCountEnd);
			
			String sql = sqlSb.toString();
			
			session = openSession();
			
			params.put("languageId", locale.toString());
			if(statusSort == null || statusSort.equals("0")) {
				params.remove("statusSort");
			}
//			if (labIdList != null && labIdList.size() > 0) {
//				params.put("labIdList", labIdList.toString().replace("[", "(").replace("]", ")"));
//			}
//			if (classIdList != null && classIdList.size() > 0) {
//				params.put("classIdList", classIdList.toString().replace("[", "(").replace("]", ")"));
//			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("totalCount", Type.INTEGER);
			
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
	
}
