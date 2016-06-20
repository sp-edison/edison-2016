package org.kisti.edison.bestsimulation.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.bestsimulation.model.SimulationJob;
import org.kisti.edison.bestsimulation.model.impl.SimulationImpl;
import org.kisti.edison.bestsimulation.model.impl.SimulationJobImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SimulationJobFinderImpl extends BasePersistenceImpl<SimulationJob> implements SimulationJobFinder{
	public static final String MONITORING_SQLPATH = "org.kisti.edison.bestsimulation.service.persistence.Monitoring.";
	
	
	public long getMaxJobSeqNoSimulationJob(long groupId, String simulationUuid) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationJob.getMaxJobSeqNoSimulationJob");

            sql.append(sqlSelect);

            Map params = new HashMap();

            params.put("groupId", groupId);
            params.put("simulationUuid", simulationUuid);
            
            session=openSession();
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            SQLQuery query = session.createSQLQuery(gBatisQuery);
            
            query.addScalar("maxJobSeqNo", Type.LONG);
                 
            return (Long) query.uniqueResult();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public int deleteSimulationJob(long groupId, String simulationUuid, long jobPhase, long jobSeqNo) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {

			String sqlDelete = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationJob.deleteSimulationJob");

            sql.append(sqlDelete);

            Map params = new HashMap();
            
            params.put("groupId", groupId);
            params.put("simulationUuid", simulationUuid);
            params.put("jobPhase", jobPhase);
            params.put("jobSeqNo", jobSeqNo);
            
            session=openSession();

            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            SQLQuery query = session.createSQLQuery(gBatisQuery);
       
            return query.executeUpdate();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteSimulationCommandOption(long groupId, String simulationUuid, long optionSeq) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {

			String sqlDelete = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationCommandOption.deleteSimulationCommandOption");

            sql.append(sqlDelete);

            Map params = new HashMap();
            
            params.put("groupId", groupId);
            params.put("simulationUuid", simulationUuid);
            params.put("optionSeq", optionSeq);
            
            session=openSession();

            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            SQLQuery query = session.createSQLQuery(gBatisQuery);
       
            return query.executeUpdate();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int deleteSimulationParameter(long groupId, String simulationUuid, long jobSeqNo) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {

			String sqlDelete = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationParameter.deleteSimulationParameter");

            sql.append(sqlDelete);

            Map params = new HashMap();
            
            params.put("groupId", groupId);
            params.put("simulationUuid", simulationUuid);
            params.put("jobSeqNo", jobSeqNo);
            
            session=openSession();

            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            SQLQuery query = session.createSQLQuery(gBatisQuery);
       
            return query.executeUpdate();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public List<SimulationJob> getListSimulationJob(long groupId, String simulationUuid, long jobPhase, long jobSeqNo) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationJob.getListSimulationJob");
			
            sql.append(sqlSelect); 
            
            session=openSession();
            
            Map params = new HashMap();
            
            params.put("groupId", groupId);
            params.put("simulationUuid", simulationUuid);
            params.put("jobPhase", jobPhase);
            if(jobSeqNo > 0) {
            	params.put("jobSeqNo", jobSeqNo);
            }
            
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            
            SQLQuery query = session.createSQLQuery(gBatisQuery);
            
            query.addEntity("EDSIM_SimulationJob", SimulationJobImpl.class);
            
            return (List<SimulationJob>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//모니터링 리스트 조회
	public List<Object[]> getMonitoringList(long groupId, long userId,long jobVirtualLabId,long jobClassId,String searchValue, long jobStatus, int begin, int end) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlQuerySelect = CustomSQLUtil.get(MONITORING_SQLPATH + "getListMonitoringHeader");
			String sqlQuery = CustomSQLUtil.get(MONITORING_SQLPATH + "getMonitoringBody");
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			if(userId > 0) {
				params.put("userId", userId);
			}
			if(jobVirtualLabId > 0) {
				params.put("jobVirtualLabId", jobVirtualLabId);
			}
			params.put("jobClassId", jobClassId);
			params.put("searchValue", searchValue);
			if(jobStatus > 0) {
				params.put("jobStatus", jobStatus);
			}
			params.put("begin", begin);
			params.put("end", end);
//			params.put("jobSeqNo", 1);
			params.put("groupList", "Y");
			
			
			//관리자 및 가상실험실에서 조회 할 경우 userId값이 0.
			//검색 값이 있을 경우에는 admin 조회로 변경
			if(userId==0 &&!searchValue.equals("")){
				params.put("searchValue", "");
				params.put("searchValueAndUserId", searchValue);
			}
			
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDSIM_Simulation", SimulationImpl.class);
			query.addEntity("EDSIM_SimulationJob", SimulationJobImpl.class);
			query.addScalar("stayDt", Type.STRING);
			query.addScalar("executeDt", Type.STRING);
			query.addScalar("jobCnt", Type.STRING);
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	//모니터링 카운트 조회
	public int getMonitoringCount(long groupId, long userId,long jobVirtualLabId,long jobClassId, String searchValue, long jobStatus)throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		int cnt = 0;
		try{
			String sqlQuerySelect = CustomSQLUtil.get(MONITORING_SQLPATH + "getCountMonitoringHeader");
			String sqlQuery = CustomSQLUtil.get(MONITORING_SQLPATH + "getMonitoringBody");
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			if(userId > 0) {
				params.put("userId", userId);
			}
			if(jobVirtualLabId > 0) {
				params.put("jobVirtualLabId", jobVirtualLabId);
			}
			if(jobClassId > 0) {
				params.put("jobClassId", jobClassId);
			}
			params.put("searchValue", searchValue);
			if(jobStatus > 0) {
				params.put("jobStatus", jobStatus);
			}
			params.put("jobSeqNo", 1);
			
			//관리자 및 가상실험실에서 조회 할 경우 userId값이 0.
			//검색 값이 있을 경우에는 admin 조회로 변경
			if(userId==0 &&!searchValue.equals("")){
				params.put("searchValue", "");
				params.put("searchValueAndUserId", searchValue);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addScalar("totalCnt", Type.INTEGER);
			
			cnt = (Integer) query.uniqueResult();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		return cnt;
	}
	
	//모니터링 시뮬레이션 JOB 조회
	public List<Object[]> getMonitoringJobList(long groupId,String simulationUuid,long jobSeqNo) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlQuerySelect = CustomSQLUtil.get(MONITORING_SQLPATH + "getListMonitoringHeader");
			String sqlQuery = CustomSQLUtil.get(MONITORING_SQLPATH + "getMonitoringBody");
			sqlSb.append(sqlQuerySelect);
			sqlSb.append(sqlQuery);
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("simulationUuid", simulationUuid);
			if(jobSeqNo > 0) {
				params.put("jobSeqNo", jobSeqNo);
			}
			params.put("jobListSearch", "Y");
			
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			query.addEntity("EDSIM_Simulation", SimulationImpl.class);
			query.addEntity("EDSIM_SimulationJob", SimulationJobImpl.class);
			query.addScalar("stayDt", Type.STRING);
			query.addScalar("executeDt", Type.STRING);
			query.addScalar("jobCnt", Type.STRING);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	//시뮬레이션 JobSeqNo - Update
	public int updateSimulationJobSetJobSeqNo(long V_jobSeqNo,long jobSeqNo, String simulationUuid, long groupId) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String updateSql = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationJob.updateJobSeqNoSimulationJob");
			sqlSb.append(updateSql);
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("V_jobSeqNo", V_jobSeqNo);
			params.put("jobSeqNo", jobSeqNo);
			params.put("simulationUuid", simulationUuid);
			params.put("groupId", groupId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			return query.executeUpdate();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	//SimulationJob > jobStatus Update
	public Long getJobSeqNoSimulationJob(long groupId, String simulationUuid, String jobUuid) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String updateSql = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationJob.getJobSeqNoSimulationJob");
			sqlSb.append(updateSql);
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("simulationUuid", simulationUuid);
			params.put("jobUuid", jobUuid);

			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("jobSeqNo", Type.LONG);
			
			Object result = query.uniqueResult();
			
			if(result == null){
				return 0L;
			}else{
				return (Long) query.uniqueResult();
			}
			
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}


	public long getStatusSimulationJobStatus(long groupId,  String simulationUuid, String jobUuid){
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String updateSql = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationJob.getStatusSimulationJobStatus");
			sqlSb.append(updateSql);
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("simulationUuid", simulationUuid);
			params.put("jobUuid", jobUuid);

			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("jobStatus", Type.LONG);
			
			Object result = query.uniqueResult();
			
			if(result == null){
				return 0L;
			}else{
				return (Long) query.uniqueResult();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return 0;
	}
	

	public long getMaxStatusSeqSimulationJobStatus(long groupId, String simulationUuid, String jobUuid) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.SimulationJob.getMaxStatusSeqSimulationJobStatus");

            sql.append(sqlSelect);

            Map params = new HashMap();

            params.put("groupId", groupId);
            params.put("simulationUuid", simulationUuid);
			params.put("jobUuid", jobUuid);
            
            session=openSession();
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            SQLQuery query = session.createSQLQuery(gBatisQuery);
            
            query.addScalar("maxStatusSeq", Type.LONG);
                 
            return (Long) query.uniqueResult();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	
	
	
	/**
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ##### 통계 Service #########################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 */

	//기관 정보에 따른 실험실 목록
	public List<Object[]> getListVirtualLabSearchUni(long groupId, String languageId, long jobUniversityField) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getListVirtualLabSearchUni");
			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			if (jobUniversityField > 0) {
				params.put("jobUniversityField", jobUniversityField);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("virtualLabId", Type.BIG_INTEGER);
			query.addScalar("virtualLabTitle", Type.STRING);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	//실험실정보에 따른 수업목록
	public List<Object[]> getListVirtualClassSearchLab(long groupId, String languageId, long jobVirtualLabId) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getListVirtualClassSearchLab");
			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			params.put("jobVirtualLabId", jobVirtualLabId);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("classId", Type.BIG_INTEGER);
			query.addScalar("classTitle", Type.STRING);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
		
	
	
	
	/**
	 * ##### 1. EXE START ###################################################################################################################################################
	 */	
	//시뮬레이션 실행현황 표 데이터
	public List<Object[]> getStatisticsExecTableOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsExecTableOrganigation");

			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(jobUniversityField > 0) {
				params.put("jobUniversityField", jobUniversityField);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("affiliation", Type.STRING);
			query.addScalar("userCnt", Type.INTEGER);
			query.addScalar("averageRuntime", Type.BIG_INTEGER);
			query.addScalar("jobCnt", Type.INTEGER);
			query.addScalar("cputime", Type.BIG_INTEGER);
			query.addScalar("topString", Type.STRING);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	//시뮬레이션 실행현황 파이 챠트 - 기관, 랩, 클래스
	public List<Object[]> getStatisticsExecPieChartOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{			
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsExecPieChartOrganigation");

			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if (jobUniversityField > 0){
				params.put("jobUniversityField", jobUniversityField);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("count", Type.INTEGER);
			query.addScalar("affiliation", Type.STRING);

			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	

	//시뮬레이션 실행현황 바 챠트 - 월별
	public List<Object[]> getStatisticsExecBarChartDate(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsExecBarChartDate");
			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(jobUniversityField > 0) {
				params.put("jobUniversityField", jobUniversityField);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("month", Type.STRING);
			query.addScalar("monthCnt", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	/**
	 * ##### 1. EXE END ###################################################################################################################################################
	 */	
	
	/**
	 * ##### 2. Sw START ###################################################################################################################################################
	 */
	public List<Object[]> getStatisticsSwTableOrganigation(long entryId, long vocabularyId, long columnId, String languageId, String startDt, String endDt, long universityId) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsSwTableOrganigation");

			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("languageId", languageId);
			params.put("entryId", entryId);
			params.put("vocabularyId", vocabularyId);
			params.put("columnId", columnId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(universityId > 0) {
				params.put("universityId", universityId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());

			SQLQuery query = session.createSQLQuery(gBatisQuery);
			
			query.addScalar("universityId", Type.BIG_INTEGER);
			query.addScalar("universityNm", Type.STRING);
			query.addScalar("cnt", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Object[]> getStatisticsSwBarChartDate(long entryId, long vocabularyId, long columnId, String startDt, String endDt, long universityId) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsSwBarChartDate");
			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("entryId", entryId);
			params.put("vocabularyId", vocabularyId);
			params.put("columnId", columnId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(universityId > 0) {
				params.put("universityId", universityId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("month", Type.STRING);
			query.addScalar("monthCnt", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	/**
	 * ##### 2. Sw END ###################################################################################################################################################
	 */	

	/**
	 * ##### 3. SwExe START ###################################################################################################################################################
	 */	
	public List<Object[]> getStatisticsSwExeTableOrganigation(long groupId, String languageId, long columnId, String startDt, String endDt, long scienceAppId) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsSwExeTableOrganigation");

			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			params.put("columnId", columnId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(scienceAppId > 0) {
				params.put("scienceAppId", scienceAppId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("scienceApp_name", Type.STRING);
			query.addScalar("user_count", Type.INTEGER);
			query.addScalar("averageRuntime", Type.INTEGER);
			query.addScalar("exe_count", Type.INTEGER);
			
			query.addScalar("scienceApp_affiliation_name", Type.STRING);
			query.addScalar("mgtName", Type.STRING);
			query.addScalar("mgtDate", Type.STRING);
			query.addScalar("scienceApp_version", Type.STRING);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<Object[]> getStatisticsSwExeBarChartDate(long groupId, long columnId, String startDt, String endDt, long scienceAppId) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsSwExeBarChartDate");
			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("columnId", columnId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(scienceAppId > 0) {
				params.put("scienceAppId", scienceAppId);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("month", Type.STRING);
			query.addScalar("monthCnt", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	/**
	 * ##### 3. SwExe END ###################################################################################################################################################
	 */
	
	/**
	 * ##### 4. Time START ###################################################################################################################################################
	 */	
	public List<Object[]> getStatisticsTimeTableOrganigation(long groupId, String startDt, String endDt) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsTimeTableOrganigation");

			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("averageRuntime", Type.INTEGER);
			query.addScalar("averageStandbyTime", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	/**
	 * ##### 4. Time END ###################################################################################################################################################
	 */
	
	/**
	 * ##### 5. User START ###################################################################################################################################################
	 */	
	public List<Object[]> getStatisticsUserTableOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsUserTableOrganigation");

			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(jobUniversityField > 0) {
				params.put("jobUniversityField", jobUniversityField);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("affiliation", Type.STRING);
			query.addScalar("virtualLabTitle", Type.STRING);
			query.addScalar("classTitle", Type.STRING);
			query.addScalar("user_count", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<Object[]> getStatisticsUserPieChartOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{			
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsUserPieChartOrganigation");

			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("languageId", languageId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(jobUniversityField > 0){
				params.put("jobUniversityField", jobUniversityField);
			}
			
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("affiliation", Type.STRING);
			query.addScalar("user_count", Type.INTEGER);
			if(jobUniversityField > 0){
				query.addScalar("virtualLabTitle", Type.STRING);
				query.addScalar("classTitle", Type.STRING);
			}

			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	public List<Object[]> getStatisticsUserBarChartDate(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException{
		StringBuilder sqlSb = new StringBuilder();
		Session session = null;
		try{
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.statistics.getStatisticsUserBarChartDate");
			sqlSb.append(sqlSelect);			
			
			session = openSession();
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("groupId", groupId);
			params.put("startDt", startDt);
			params.put("endDt", endDt);
			if(jobUniversityField > 0){
				params.put("jobUniversityField", jobUniversityField);
			}
			String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
			SQLQuery query = session.createSQLQuery(gBatisQuery);

			query.addScalar("month", Type.STRING);
			query.addScalar("user_count", Type.INTEGER);
			
			return (List<Object[]>) query.list();
		}catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	/**
	 * ##### 5. User END ###################################################################################################################################################
	 */
	


	
}