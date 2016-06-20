package org.kisti.edison.science.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.DeveloperInfo;
import org.kisti.edison.science.model.impl.DeveloperInfoImpl;
import org.kisti.edison.science.model.impl.DeveloperRequestImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class DeveloperInfoFinderImpl extends BasePersistenceImpl<DeveloperInfo> implements DeveloperInfoFinder{
	public static final String sqlPath = "org.kisti.edison.service.persistence.DeveloperInfo.";
	
	public List<Object[]> getListCustomDeveloperInfo(Map<String, Object> params) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		int curPage = (Integer) params.get("curPage");
		int linePerPage = (Integer) params.get("linePerPage");
		
		long groupId = (Long) params.get("groupId");
		String select_status = (String) params.get("selectStatus");
		String search_field = (String) params.get("searchField");
		if(search_field == null) {
			search_field = "";
		}
		
		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getListCustomDeveloperInfoSelect");
			String sqlFrom = CustomSQLUtil.get(sqlPath + "getListCustomDeveloperInfoFrom");
			String sqlWhere1 = CustomSQLUtil.get(sqlPath + "getListCustomDeveloperInfoWhere1");
			String sqlWhere2 = CustomSQLUtil.get(sqlPath + "getListCustomDeveloperInfoWhere2");
			String sqlOrderBy = CustomSQLUtil.get(sqlPath + "getListCustomDeveloperInfoOrderBy");
			String sqlLimit = CustomSQLUtil.get(sqlPath + "getListCustomDeveloperInfoLimit");

			sqlSb.append(sqlSelect);
			sqlSb.append(sqlFrom);
			sqlSb.append(sqlWhere1);
			if(select_status != null && !select_status.equals("0")) {
				sqlSb.append(sqlWhere2);
			}
			sqlSb.append(sqlOrderBy);
			sqlSb.append(sqlLimit);
			
			session = openSession();
			SQLQuery query = session.createSQLQuery(sqlSb.toString());
            query.addEntity("EDAPP_DeveloperInfo", DeveloperInfoImpl.class);
            query.addEntity("EDAPP_DeveloperRequest", DeveloperRequestImpl.class);
            
            query.setInteger("begin", (curPage - 1) * linePerPage);
            query.setInteger("end", linePerPage);
            query.setString("search_field", "%" + search_field + "%");
            query.setLong("groupId", groupId);
			if(select_status != null && !select_status.equals("0")) {
				query.setString("select_status", select_status);
			}
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
	
	public int getCountCustomDeveloperInfo(Map<String, Object> params) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String select_status = (String) params.get("selectStatus");
		String search_field = (String) params.get("searchField");
		long groupId = (Long) params.get("groupId");

		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getCountCustomDeveloperInfo");
			String sqlWhere = CustomSQLUtil.get(sqlPath + "getCountCustomDeveloperInfoWhere1");
			String sqlWhere1 = CustomSQLUtil.get(sqlPath + "getCountCustomDeveloperInfoWhere2");
			
			sqlSb.append(sqlSelect);
			if(select_status != null && !select_status.equals("0")) {
				sqlSb.append(sqlWhere1);
			}
			if(search_field != null && search_field.length() > 0) {
				sqlSb.append(sqlWhere);
			}

			session = openSession();
			
			SQLQuery query = session.createSQLQuery(sqlSb.toString());
			query.addScalar("CNT", Type.INTEGER);
			
			query.setLong("groupId", groupId);
			
			if(search_field != null && search_field.length() > 0) {
				query.setString("search_field", "%" + search_field + "%");
			}
			if(select_status != null && !select_status.equals("0")) {
				query.setString("select_status", select_status);
			}
			
			return (Integer) query.uniqueResult();
		} catch (Exception e) {
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
	
	public Object[] getCustomDeveloperInfo(Map<String, Object> params) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		String userId = String.valueOf(params.get("userId"));
		long groupId = (Long) params.get("groupId");
		
		try {
			String sqlSelect = CustomSQLUtil.get(sqlPath + "getCustomDeveloperInfo");
			String sqlWhere = CustomSQLUtil.get(sqlPath + "getCustomDeveloperInfoWhere");
			
			sqlSb.append(sqlSelect);
			if(userId != null && userId.length() > 0) {
				sqlSb.append(sqlWhere);
			}
			
			session = openSession();
			
			SQLQuery query = session.createSQLQuery(sqlSb.toString());
			query.addEntity("EDAPP_DeveloperInfo", DeveloperInfoImpl.class);
			query.addEntity("EDAPP_DeveloperRequest", DeveloperRequestImpl.class);
			
			query.setLong("groupId", groupId);
			
			if(userId != null && userId.length() > 0) {
				query.setString("userId", userId);
			}
			
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
	
	/*개발자 요청 정보 조회 */
	public List<Object[]> getDeveloperRequestStatus(long groupId, long userId, String requestStatus[], int begin, int end) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		try {
			String getDeveloperRequestStatus = CustomSQLUtil.get(sqlPath + "getDeveloperRequestStatus");
			
			sqlSb.append(getDeveloperRequestStatus);
			session = openSession();
			
			Map params = new HashMap();
			
			if(requestStatus != null && requestStatus.length > 0) {
				for(int i=0;i<requestStatus.length;i++){
					params.put("requestStatus"+i, requestStatus[i]);
				}
			}
			if(groupId > 0) {
				params.put("groupId", groupId);
			}
			if(userId > 0) {
				params.put("userId", userId);
			}
			params.put("begin", begin);
			params.put("end", end);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());	
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addEntity("EDAPP_DeveloperInfo", DeveloperInfoImpl.class);
			query.addEntity("EDAPP_DeveloperRequest", DeveloperRequestImpl.class);
			
			return (List<Object[]>)query.list();
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
	
	/*개발자 요청 정보 조회 */
	public int getCountDeveloperRequestStatus(long groupId, long userId, String requestStatus[]) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		try {
			String getCountDeveloperRequestStatus = CustomSQLUtil.get(sqlPath + "getCountDeveloperRequestStatus");
			
			sqlSb.append(getCountDeveloperRequestStatus);
			session = openSession();
			
			Map params = new HashMap();

			if(requestStatus != null && requestStatus.length > 0) {
				for(int i=0;i<requestStatus.length;i++){
					params.put("requestStatus"+i, requestStatus[i]);
				}
			}
			
			if(groupId > 0) {
				params.put("groupId", groupId);
			}
			if(userId > 0) {
				params.put("userId", userId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());	
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("totalCount", Type.INTEGER);
			
			return (Integer)query.uniqueResult();
		} catch (Exception e) {
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
	
	/*개발자 요청 정보 조회 */
	public Object[] getCountRequestInfo(long groupId, String developerStatus, String virtualLabStatus,String libRequestStatus, String developerDeleteStatus) {
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		
		try {
			String getCountDeveloperRequestStatus = CustomSQLUtil.get(sqlPath + "getCountRequestInfo");
			
			sqlSb.append(getCountDeveloperRequestStatus);
			session = openSession();
			
			Map params = new HashMap();
			
			params.put("developerStatus", developerStatus);
			params.put("virtualLabStatus", virtualLabStatus);
			
			if(!libRequestStatus.equals("")){
				params.put("libRequestStatus", libRequestStatus);
			}
			params.put("developerDeleteStatus", developerDeleteStatus);
			
			if(groupId != 0) params.put("groupId", groupId);
			
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());	
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("developerRequestCount", Type.INTEGER);
			query.addScalar("virtualLabRequestCount", Type.INTEGER);
			
			if(!libRequestStatus.equals("")){
				query.addScalar("libRequestCount", Type.INTEGER);
			}
			query.addScalar("developerDeleteCount", Type.INTEGER); 
			return (Object[])query.uniqueResult();
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
