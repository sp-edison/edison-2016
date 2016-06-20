package org.kisti.edison.science.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.impl.ScienceAppCategoryLinkImpl;
import org.kisti.edison.science.model.impl.ScienceAppImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ScienceAppFinderImpl extends BasePersistenceImpl<ScienceApp> implements ScienceAppFinder {
  public static final String RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME =
        ScienceAppFinder.class.getName() +
            ".retrieveScienceAppOnNameTitleScreenNameAffiliationName";
  public static final String RETRIEVE_ON_SCREENNAME =
        ScienceAppFinder.class.getName() +
            ".retrieveScienceAppOnScreenName";
  public static final String RETRIEVE_ON_AFFILIATIONNAME =
        ScienceAppFinder.class.getName() +
            ".retrieveScienceAppOnAffiliationName";
  public static final String GET_FAVORITE_APPLIST =
      ScienceAppFinder.class.getName() +
      ".getFavoriteAppList";

  public static final String GET_APPLIST_HEADER =
      ScienceAppFinder.class.getName() +
      ".retrieveListScienceApp.header";

  public static final String GET_APP_COUNT_HEADER =
      ScienceAppFinder.class.getName() +
      ".countScienceApp.header";

  public static final String GET_MY_MANAGER_APPLIST_HEADER =
      ScienceAppFinder.class.getName() +
      ".retrieveListMyManagerScienceApp.header";

  public static final String GET_MY_MANAGER_APP_COUNT_HEADER =
      ScienceAppFinder.class.getName() +
      ".countMyManagerScienceApp.header";


  public static final String GET_APPLIST_WHERE =
      ScienceAppFinder.class.getName() +
      ".ScienceApp.where";

  public static final String GET_APP_EXESTS =
      ScienceAppFinder.class.getName()
      +".getScienceAppExeSts";

  public static final String GET_MY_APP_LIST =
      ScienceAppFinder.class.getName() +
      ".getListMyAppQna";

  public static final String GET_MY_APP_LIST_WITH_QNA =
      ScienceAppFinder.class.getName() +
      ".getMyAppListWithQna";

  public static final String GET_APPEDITORLIST_HEADER =
      ScienceAppFinder.class.getName() +
      ".retrieveListScienceAppEditor.header";

  public static final String GET_MY_MANAGER_APPEDITORLIST_HEADER =
      ScienceAppFinder.class.getName() +
      ".retrieveListMyManagerScienceAppEditor.header";

  public static final String GET_APPEDITORLIST_WHERE =
      ScienceAppFinder.class.getName() +
      ".retrieveListScienceAppEditor.where";

  public static final String GET_MY_APP_LIST_FOR_PROJECT =
      ScienceAppFinder.class.getName() +
      ".getMyAppListForProject";

  public static final String GET_TARGET_LANGUAGE_SCIENCE_APP_CATEGORY =
      ScienceAppFinder.class.getName() +
      ".getTargetLanguageScienceAppCategory";

  public static final String GET_MY_APP_LIST_FOR_PROJECT_COUNT =
      ScienceAppFinder.class.getName() +
      ".getMyAppListForProjectCount";
  
  
  public static final String GET_APP_TEST_LIST =
	      ScienceAppFinder.class.getName() +
	      ".retrieveListAppTest";
  
  public static final String GET_APP_TEST_COUNT =
	      ScienceAppFinder.class.getName() +
	      ".countAppTest";  

  public List<ScienceApp> retrieveScienceAppOnNameTitleScreenNameAffiliationName(
        String searchTerm,  int start, int end) {
      Session session = null;

      try{
        session = super.openSession();

          String sql = CustomSQLUtil.get(
              RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME);

          SQLQuery query = session.createSQLQuery(sql);
          query.setCacheable(false);
          query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

          QueryPos qPos = QueryPos.getInstance(query);
          qPos.add(searchTerm);
          qPos.add(searchTerm);
          qPos.add(searchTerm);
          qPos.add(searchTerm);

          return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
      } finally{
        super.closeSession(session);
      }
  }

  public int countScienceAppOnNameTitleScreenNameAffiliationName(
        String searchTerm ) {
      Session session = null;

      try{
        session = super.openSession();

        String sql = CustomSQLUtil.get(
                RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME);
        if(sql == null){
          return 0;
        }
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(searchTerm);
        qPos.add(searchTerm);
        qPos.add(searchTerm);
        qPos.add(searchTerm);
        return  query.list().size();
      } finally {
        super.closeSession(session);
      }
  }

  public List<ScienceApp> retrieveAllScienceAppOnNameTitleScreenNameAffiliationName(
        String searchTerm ) {
      Session session = null;

      try{
        session = super.openSession();

        String sql = CustomSQLUtil.get(
            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME);
        if(sql == null){
          return null;
        }
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(searchTerm);
        qPos.add(searchTerm);
        qPos.add(searchTerm);
        qPos.add(searchTerm);

        return  (List<ScienceApp>)query.list();
      } finally {
        super.closeSession(session);
      }
  }

  public List<ScienceApp> retrieveScienceAppOnScreenName(
        String searchTerm,  int start, int end) {
      Session session = null;

      try{
        session = super.openSession();

          String sql = CustomSQLUtil.get(RETRIEVE_ON_SCREENNAME);

          SQLQuery query = session.createSQLQuery(sql);
          query.setCacheable(false);
          query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

          QueryPos qPos = QueryPos.getInstance(query);
          qPos.add(searchTerm);

        return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
      } finally {
          super.closeSession(session);
      }
  }

  public int countScienceAppOnScreenName(String searchTerm ) {
      Session session = null;

      try{
        session = super.openSession();

        String sql = CustomSQLUtil.get(
                RETRIEVE_ON_SCREENNAME);
        if(sql == null){
          return 0;
        }
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(searchTerm);

        return  query.list().size();
      } finally{
        super.closeSession(session);
      }
  }

  public List<ScienceApp> retrieveAllScienceAppOnScreenName(
        String searchTerm ) {
      Session session = null;

      try{
        session = super.openSession();

        String sql = CustomSQLUtil.get(
                RETRIEVE_ON_SCREENNAME);
        if(sql == null){
          return null;
        }
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(searchTerm);

        return  (List<ScienceApp>) query.list();
      } finally{
        super.closeSession(session);
      }
  }

  public List<ScienceApp> retrieveScienceAppOnAffiliationName(
        String searchTerm,  int start, int end) {
      Session session = null;

      try{
        session = super.openSession();

          String sql = CustomSQLUtil.get(RETRIEVE_ON_AFFILIATIONNAME);

          SQLQuery query = session.createSQLQuery(sql);
          query.setCacheable(false);
          query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

          QueryPos qPos = QueryPos.getInstance(query);
          qPos.add(searchTerm);

        return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
      } finally {
          super.closeSession(session);
      }
  }

  public int countScienceAppOnAffiliationName(String searchTerm ) {
      Session session = null;

      try{
        session = super.openSession();

        String sql = CustomSQLUtil.get(
                RETRIEVE_ON_AFFILIATIONNAME);
        if(sql == null){
          return 0;
        }
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(searchTerm);

        return  query.list().size();
      } finally{
        super.closeSession(session);
      }
  }

  public List<ScienceApp> retrieveAllScienceAppOnAffiliationName(
        String searchTerm ) {
      Session session = null;

      try{
        session = super.openSession();

        String sql = CustomSQLUtil.get(
                RETRIEVE_ON_AFFILIATIONNAME);
        if(sql == null){
          return null;
        }
        SQLQuery query = session.createSQLQuery(sql);
        query.setCacheable(false);
        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);

        QueryPos qPos = QueryPos.getInstance(query);
        qPos.add(searchTerm);

        return  (List<ScienceApp>) query.list();
      } finally{
        super.closeSession(session);
      }
  }

  /*즐겨찾기 앱 목록 조회 */
  public List<Object[]> getFavoriteAppList(long entryId,long vocabularyId,long columnId,long userId, Locale locale) {
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;
    try {
      String getFavoriteAppList = CustomSQLUtil.get(GET_FAVORITE_APPLIST);

      sqlSb.append(getFavoriteAppList);
      session = openSession();

      Map<String, Object> params = new HashMap<String, Object>();

      if(entryId > 0) {
        params.put("entryId", entryId);
      }
      if(locale != null) {
        params.put("languageId", locale.toString());
      }
      params.put("vocabularyId", vocabularyId);
      params.put("columnId", columnId);
      params.put("userId", userId);

      String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());

      SQLQuery query = session.createSQLQuery(gBatisQuery);

      query.addEntity("EDAPP_ScienceApp", ScienceAppImpl.class);
      query.addScalar("universityld", Type.LONG);

      return (List<Object[]>)query.list();
    }  catch (Exception e) {
          try {
              throw new SystemException(e);
          } catch (SystemException se) {
              se.printStackTrace();
          }
      } finally {
          super.closeSession(session);
      }
    return null;
  }

  public int countScienceApp(Map<String,Object> searchParam) throws SystemException{
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;
    int cnt = 0;

    try{
      String sqlQuerySelect = "";
      //MyManagerApp 조회 일 경우
      boolean myAppSearchStatus = GetterUtil.getBoolean(searchParam.get("myManagerAppSearch"),false);

      if(myAppSearchStatus){
        sqlQuerySelect = CustomSQLUtil.get(GET_MY_MANAGER_APP_COUNT_HEADER );
      }else{
        sqlQuerySelect = CustomSQLUtil.get(GET_APP_COUNT_HEADER);
      }

      String sqlQuery = CustomSQLUtil.get(GET_APPLIST_WHERE);
      sqlSb.append(sqlQuerySelect);
      sqlSb.append(sqlQuery);

      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
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

  public List<ScienceApp> retrieveListScienceEditorApp(Map<String,Object> searchParam) throws SystemException{
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;


    try{
      String sqlQuerySelect = "";
      //MyManagerApp 조회 일 경우
      boolean myAppSearchStatus = GetterUtil.getBoolean(searchParam.get("myManagerAppSearch"),false);

      if(myAppSearchStatus){
        sqlQuerySelect = CustomSQLUtil.get(GET_MY_MANAGER_APPEDITORLIST_HEADER);
      }else{
        sqlQuerySelect = CustomSQLUtil.get(GET_APPEDITORLIST_HEADER);
      }

      String sqlQuery = CustomSQLUtil.get(GET_APPEDITORLIST_WHERE);
      sqlSb.append(sqlQuerySelect);
      sqlSb.append(sqlQuery);

      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addEntity("EDAPP_ScienceApp", ScienceAppImpl.class);

      return (List<ScienceApp>) query.list();

    }catch (Exception e) {
      e.printStackTrace();
      throw new SystemException(e);
    } finally {
      closeSession(session);
    }
  }

  public List<Object[]> retrieveListScienceApp(Map<String,Object> searchParam) throws SystemException{
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;

    //DB Cache Clear
    CacheRegistryUtil.clear();
    try{
      searchParam.put("listsearch", true);

      String sqlQuerySelect = "";
      //MyManagerApp 조회 일 경우
      boolean myAppSearchStatus = GetterUtil.getBoolean(searchParam.get("myManagerAppSearch"),false);

      if(myAppSearchStatus){
        sqlQuerySelect = CustomSQLUtil.get(GET_MY_MANAGER_APPLIST_HEADER);
      }else{
        sqlQuerySelect = CustomSQLUtil.get(GET_APPLIST_HEADER);
      }

      String sqlQuery = CustomSQLUtil.get(GET_APPLIST_WHERE);
      sqlSb.append(sqlQuerySelect);
      sqlSb.append(sqlQuery);

      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addEntity("EDAPP_ScienceAppCategoryLink", ScienceAppCategoryLinkImpl.class);
      query.addEntity("EDAPP_ScienceApp", ScienceAppImpl.class);

      return (List<Object[]>) query.list();

    }catch (Exception e) {
      e.printStackTrace();
      throw new SystemException(e);
    } finally {
      closeSession(session);
    }
  }

  /*ScienceApp별 실행 통계 */
  public List<Object[]> getScienceAppExeSts(String scienceAppId,long groupId) {
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;

    try {
      String sqlQuerySelect = CustomSQLUtil.get(GET_APP_EXESTS);
      sqlSb.append(sqlQuerySelect);


      session = openSession();
      Map params = new HashMap();
      params.put("groupId", groupId);
      params.put("scienceAppId", scienceAppId);

      String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());

      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addScalar("month", Type.STRING);
      query.addScalar("monthCnt", Type.INTEGER);
      query.addScalar("preMonthCnt", Type.INTEGER);

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

  /*나의 앱 리스트 and QNA 개수 */
  public List<Object[]> getMyAppListWithQna(Map<String, Object> params) {
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;

    try {
      String getMyAppQnaList = CustomSQLUtil.get(GET_MY_APP_LIST_WITH_QNA);

      sqlSb.append(getMyAppQnaList);

      session = openSession();

      String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());

      SQLQuery query = session.createSQLQuery(gBatisQuery);

      query.addEntity("EDAPP_ScienceApp", ScienceAppImpl.class);
      query.addScalar("answerCount", Type.INTEGER);

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

  /*나의 앱 QNA 리스트 */
  public List<Object[]> getListMyAppQna(Map<String, Object> params) {
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;

    try {
      String getMyAppQnaList = CustomSQLUtil.get(GET_MY_APP_LIST);

      sqlSb.append(getMyAppQnaList);

      session = openSession();

      String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());

      SQLQuery query = session.createSQLQuery(gBatisQuery);

      query.addScalar("boardSeq", Type.LONG);
      query.addScalar("title", Type.STRING);
      query.addScalar("content", Type.STRING);
      query.addScalar("writerId", Type.LONG);
      query.addScalar("writerDate", Type.DATE);
      query.addScalar("readCnt", Type.INTEGER);
      query.addScalar("replyCount", Type.INTEGER);
      query.addScalar("groupId", Type.LONG);

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

  /*프로젝트 앱 목록 */
  public List<ScienceApp> getMyAppListForProject(Map<String, Object> params) {
    StringBuilder sqlSb = new StringBuilder();
    Session session = null;

    try {
      String getMyAppForList = CustomSQLUtil.get(GET_MY_APP_LIST_FOR_PROJECT);

      sqlSb.append(getMyAppForList);

      session = openSession();

      String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());

      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addEntity("EDAPP_ScienceApp", ScienceAppImpl.class);

      return (List<ScienceApp>)query.list();
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

  public Map<Long, Long> getLanguageSpecificCategories(Map<String, Object> params){
    Session session = null;
    try{
      String sql = CustomSQLUtil.get(GET_TARGET_LANGUAGE_SCIENCE_APP_CATEGORY);
      session = openSession();
      String gBatisQuery = GBatisUtil.getGBatis(params, sql);
      SQLQuery query = session.createSQLQuery(gBatisQuery);

      query.addScalar("categoryId", Type.LONG);
      query.addScalar("appCnt", Type.LONG);

      List<Object[]> rows = (List<Object[]>) query.list();
      Map<Long, Long> categories = new HashMap<Long, Long>();
      for(Object[] columns : rows){
        categories.put(GetterUtil.getLong(columns[0]), GetterUtil.getLong(columns[1]));
      }
      return categories;
    }catch (Exception e){
      try{
        throw new SystemException(e);
      }catch (SystemException se){
        se.printStackTrace();
      }
    }finally{
      closeSession(session);
    }
    return null;
  }

  public int getMyAppListForProjectCount(Map params, Locale locale){
    Session session = openSession();
    int cnt = 0;
    try{
      String sqlQuery = CustomSQLUtil.get(GET_MY_APP_LIST_FOR_PROJECT_COUNT);

      StringBuffer sql = new StringBuffer();
      sql.append(sqlQuery);

      String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
      SQLQuery query = session.createSQLQuery(gBatisQuery);
      query.addScalar("totalCnt", Type.INTEGER);

      cnt = (Integer) query.uniqueResult();
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      closeSession(session);
    }
    return cnt;
  }
  
  
  public List<Object[]> retrieveListAppTest(Map<String, Object> params) {
	    StringBuilder sqlSb = new StringBuilder();
	    Session session = null;

	    try {
	      String getMyAppQnaList = CustomSQLUtil.get(GET_APP_TEST_LIST );

	      sqlSb.append(getMyAppQnaList);
	      session = openSession();
	      String gBatisQuery = GBatisUtil.getGBatis(params, sqlSb.toString());
	      SQLQuery query = session.createSQLQuery(gBatisQuery);
	      
	      query.addScalar("simulationCreateDt", Type.STRING);
	      query.addScalar("TOTAL_CNT", Type.INTEGER);
	      query.addScalar("QUEUED_CNT", Type.INTEGER);
	      query.addScalar("RUN_CNT", Type.INTEGER);
	      query.addScalar("SUCCESS_CNT", Type.INTEGER);
	      query.addScalar("FAILED_CNT", Type.INTEGER);
	      query.addScalar("jobUuid", Type.STRING);

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
  
  
  public int countAppTest(Map<String,Object> params){
	    Session session = openSession();
	    int cnt = 0;
	    try{
	      String sqlQuery = CustomSQLUtil.get(GET_APP_TEST_COUNT);

	      StringBuffer sql = new StringBuffer();
	      sql.append(sqlQuery);

	      String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
	      SQLQuery query = session.createSQLQuery(gBatisQuery);
	      query.addScalar("totalCnt", Type.INTEGER);

	      cnt = (Integer) query.uniqueResult();
	    }catch(Exception e){
	      e.printStackTrace();
	    }finally{
	      closeSession(session);
	    }
	    return cnt;
	  }
}
