package org.kisti.edison.service.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.Workflow;
import org.kisti.edison.model.WorkflowInstance;
import org.kisti.edison.model.impl.WorkflowImpl;
import org.kisti.edison.model.impl.WorkflowInstanceImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class WorkflowFinderImpl extends BasePersistenceImpl<Workflow>
    implements WorkflowFinder{
  public static final String GET_WORKFLOWS_HEADER =
      WorkflowFinder.class.getName() +
            ".retrieveWorkflows.header";
  public static final String GET_WORKFLOWS_WHERE =
      WorkflowFinder.class.getName() +
            ".retrieveWorkflows.where";
  public static final String GET_WORKFLOW_INSTANCES_COUNT_HEADER =
      WorkflowFinder.class.getName() +
      ".countWorkflowInstances.header";
  public static final String GET_WORKFLOW_INSTANCES_HEADER =
      WorkflowFinder.class.getName() +
      ".retrieveWorkflowInstances.header";
  public static final String GET_WORKFLOW_INSTANCES_WHERE =
      WorkflowFinder.class.getName() +
      ".retrieveWorkflowInstances.where";
  
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> retrieveWorkflows(Map<String,Object> searchParam, Locale locale) throws SystemException{
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;
    try{
      String sqlQuerySelect = CustomSQLUtil.get(GET_WORKFLOWS_HEADER);
      String sqlQuery = CustomSQLUtil.get(GET_WORKFLOWS_WHERE);
      sqlSb.append(sqlQuerySelect);
      sqlSb.append(sqlQuery);
      
      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addEntity("EDWF_Workflow", WorkflowImpl.class);
      query.addScalar("parentTitle", Type.STRING);
      query.addScalar("parentIsPublic", Type.BOOLEAN);
      query.addScalar("parentUserId", Type.BOOLEAN);
      query.addScalar("screenName", Type.STRING);
      
      List<Object[]> rows = (List<Object[]>) query.list();
      List<Map<String, Object>> workflows = new ArrayList<>();
      
      for(Object[] columns : rows){
        Workflow workflow =  (Workflow)columns[0];
        Map<String, Object> workflowMap = workflow.getModelAttributes();
        workflowMap.put("title", workflow.getTitle(locale));
        workflowMap.put("titleMap", workflow.getTitle());
        workflowMap.put("description", workflow.getDescription(locale));
        workflowMap.put("descriptionMap", workflow.getDescription());
        workflowMap.put("parentTitle", LocalizationUtil
            .getLocalization(GetterUtil.getString(columns[1]), LocaleUtil.toLanguageId(locale)));
        workflowMap.put("parentIsPublic", columns[2]);
        
        if(workflow.getUserId() == GetterUtil.getLong(columns[3])){
          workflowMap.put("parentIsMine", true);
        }else{
          workflowMap.put("parentIsMine", false);
        }
        workflowMap.put("screenName", columns[4]);
        workflows.add(workflowMap);
      }
      
      return workflows;
    }catch (Exception e) {
      e.printStackTrace();
      throw new SystemException(e);
    } finally {
      closeSession(session);
    }
  }
  
  public long countWorkflowInstances(Map<String,Object> searchParam) throws SystemException{
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;
    try{
      String sqlQuerySelect = CustomSQLUtil.get(GET_WORKFLOW_INSTANCES_COUNT_HEADER);
      String sqlQuery = CustomSQLUtil.get(GET_WORKFLOW_INSTANCES_WHERE);
      sqlSb.append(sqlQuerySelect);
      sqlSb.append(sqlQuery);
      
      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addScalar("totalCnt", Type.LONG);
      return (Long) query.uniqueResult();
    }catch (Exception e) {
      e.printStackTrace();
      throw new SystemException(e);
    } finally {
      closeSession(session);
    }
  }
  
  @SuppressWarnings("unchecked")
  public List<Map<String, Object>> retrieveWorkflowInstances(Map<String,Object> searchParam, Locale locale) throws SystemException{
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;
    try{
      String sqlQuerySelect = CustomSQLUtil.get(GET_WORKFLOW_INSTANCES_HEADER);
      String sqlQuery = CustomSQLUtil.get(GET_WORKFLOW_INSTANCES_WHERE);
      sqlSb.append(sqlQuerySelect);
      sqlSb.append(sqlQuery);

      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addEntity("EDWF_WorkflowInstance", WorkflowInstanceImpl.class);
      query.addScalar("workflowTitle", Type.STRING);
      query.addScalar("screenName", Type.STRING);
      
      List<Object[]> rows = (List<Object[]>) query.list();
      List<Map<String, Object>> workflowInstances = new ArrayList<>();
      for(Object[] columns : rows){
        WorkflowInstance workflowInstance = (WorkflowInstance)columns[0];
        Map<String, Object> workflowInstanceMap = workflowInstance.getModelAttributes();
        if(workflowInstance.getStatus() != null){
          workflowInstanceMap.put("status", StringUtil.upperCaseFirstLetter(workflowInstance.getStatus().toLowerCase()));
        }
        String workflowTitle = LocalizationUtil.getLocalization(
            GetterUtil.getString(columns[1]),
            LocaleUtil.toLanguageId(locale));
        workflowInstanceMap.put("workflowTitle", workflowTitle);
        workflowInstanceMap.put("screenName", columns[2]);
        workflowInstances.add(workflowInstanceMap);
      }
      return workflowInstances;
    }catch (Exception e) {
      e.printStackTrace();
      throw new SystemException(e);
    } finally {
      closeSession(session);
    }
  }
}
