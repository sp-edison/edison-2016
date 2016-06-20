package com.kisti.science.platform.app.service.persistence;

import java.util.List;

import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.model.impl.ScienceAppImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ScienceAppFinderImpl extends BasePersistenceImpl<ScienceApp> implements ScienceAppFinder {
	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
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
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationName(
		    String searchTerm ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
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
	
	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		    String searchTerm ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		    		RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
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

	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		    String searchTerm,  String stage, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(
	            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(searchTerm);
	        qPos.add(stage);

	        return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally{
	    	super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		    String searchTerm, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(searchTerm);
	        qPos.add(stage);
		    return  query.list().size();
	    } finally {
	    	super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		    String searchTerm, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		    		RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(searchTerm);
	        qPos.add(stage);
		    
		    return  (List<ScienceApp>)query.list();
	    } finally {
	    	super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		    String searchTerm, String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(
	            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);

	        return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally{
	    	super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		    String searchTerm, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
		    return  query.list().size();
	    } finally {
	    	super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		    String searchTerm, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		    		RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
		    
		    return  (List<ScienceApp>)query.list();
	    } finally {
	    	super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		    String searchTerm,  String stage, String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(
	            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);

	        return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally{
	    	super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		    String searchTerm, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
		    return  query.list().size();
	    } finally {
	    	super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		    String searchTerm, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		    		RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
		    
		    return  (List<ScienceApp>)query.list();
	    } finally {
	    	super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsOnScreenName(
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
	
	public int countScienceAppsOnScreenName(String searchTerm ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
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
	
	public List<ScienceApp> retrieveScienceAppsOnScreenName(
		    String searchTerm ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
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

	public List<ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		    String searchTerm,  String stage, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_ON_SCREENNAME_BY_STAGE);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(stage);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnScreenNameByStage(String searchTerm, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME_BY_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		    String searchTerm, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME_BY_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		    String searchTerm,  String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_ON_SCREENNAME_BY_TRAGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnScreenNameByTarget(String searchTerm, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME_BY_TRAGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		    String searchTerm, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME_BY_TRAGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		    String searchTerm,  String stage, String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_ON_SCREENNAME_BY_STAGE_TRAGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnScreenNameByStageTarget(String searchTerm, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME_BY_STAGE_TRAGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		    String searchTerm, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_SCREENNAME_BY_STAGE_TRAGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsOnAffiliationName(
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
	
	public int countScienceAppsOnAffiliationName(String searchTerm ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
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
	
	public List<ScienceApp> retrieveScienceAppsOnAffiliationName(
		    String searchTerm ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
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

	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		    String searchTerm,  String stage, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(stage);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnAffiliationNameByStage(String searchTerm, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		    String searchTerm, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		    String searchTerm,  String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_ON_AFFILIATIONNAME_BY_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnAffiliationNameByTarget(String searchTerm, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME_BY_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		    String searchTerm, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME_BY_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		    String searchTerm,  String stage, String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(searchTerm);
	        qPos.add(stage);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsOnAffiliationNameByStageTarget(String searchTerm, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		    String searchTerm, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(searchTerm);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByVocabularyId(
		    long vocabularyId,  int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_VOCABULARY_ID);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(vocabularyId);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByVocabularyId(long vocabularyId ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyId(
		    long vocabularyId ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		    long vocabularyId,  String stage, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_VOCABULARY_ID_STAGE);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(vocabularyId);
	        qPos.add(stage);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByVocabularyIdStage(long vocabularyId, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
		    qPos.add(stage);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		    long vocabularyId, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
		    qPos.add(stage);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		    long vocabularyId,  String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_VOCABULARY_ID_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(vocabularyId);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByVocabularyIdTarget(long vocabularyId, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		    long vocabularyId, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		    long vocabularyId,  String stage, String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_VOCABULARY_ID_STAGE_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(vocabularyId);
	        qPos.add(stage);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByVocabularyIdStageTarget(long vocabularyId, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID_STAGE_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		    long vocabularyId, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_VOCABULARY_ID_STAGE_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(vocabularyId);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryId(
		    long categoryId,  int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_CATEGORY_ID);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(categoryId);
	        qPos.add(categoryId);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByCategoryId(long categoryId ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryId(
		    long categoryId ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID);
		    
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryIdStage(
		    long categoryId,  String stage, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_CATEGORY_ID_STAGE);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(categoryId);
	        qPos.add(categoryId);
	        qPos.add(stage);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByCategoryIdStage(long categoryId, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID_STAGE);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
		    qPos.add(stage);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryIdStage(
		    long categoryId, String stage ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID_STAGE);
		    
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
		    qPos.add(stage);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		    long categoryId,  String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_CATEGORY_ID_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(categoryId);
	        qPos.add(categoryId);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByCategoryIdTarget(long categoryId, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		    long categoryId, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID_TARGET);
		    
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public List<ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		    long categoryId,  String stage, String targetLang, int start, int end) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
	        String sql = CustomSQLUtil.get(RETRIEVE_BY_CATEGORY_ID_STAGE_TARGET);
	
	        SQLQuery query = session.createSQLQuery(sql);
	        query.setCacheable(false);
	        query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
	        QueryPos qPos = QueryPos.getInstance(query);  
	        qPos.add(categoryId);
	        qPos.add(categoryId);
	        qPos.add(stage);
	        qPos.add(targetLang);
	
		    return (List<ScienceApp>) QueryUtil.list(query, getDialect(), start, end);
	    } finally {
	        super.closeSession(session);
	    }
	} 
	
	public int countScienceAppsByCategoryIdStageTarget(long categoryId, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID_STAGE_TARGET);
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return 0;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  query.list().size();
	    } finally{
		    super.closeSession(session);
	    }
	}
	
	public List<ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		    long categoryId, String stage, String targetLang ) {
	    Session session = null;
	    
	    try{
		    session = super.openSession();
	
		    String sql = CustomSQLUtil.get(
		            RETRIEVE_BY_CATEGORY_ID_STAGE_TARGET);
		    
		    if(sql == null){
		    	System.out.println("Finder: "+ ScienceAppFinder.class.getName());
		    	return null;
		    }
		    SQLQuery query = session.createSQLQuery(sql);
		    query.setCacheable(false);
		    query.addEntity("ScienceApp_ScienceApp", ScienceAppImpl.class);
	
		    QueryPos qPos = QueryPos.getInstance(query);  
		    qPos.add(categoryId);
		    qPos.add(categoryId);
		    qPos.add(stage);
		    qPos.add(targetLang);
	
		    return  (List<ScienceApp>) query.list();
	    } finally{
		    super.closeSession(session);
	    }
	}

	public static final String RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnNameTitleScreenNameAffiliationName";
	public static final String RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage";
	public static final String RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget";
	public static final String RETRIEVE_ON_NAME_TITLE_SCREENNAME_AFFILIATIONNAME_BY_STAGE_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget";
	public static final String RETRIEVE_ON_SCREENNAME =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnScreenName";
	public static final String RETRIEVE_ON_SCREENNAME_BY_STAGE =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnScreenNameByStage";
	public static final String RETRIEVE_ON_SCREENNAME_BY_TRAGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnScreenNameByTarget";
	public static final String RETRIEVE_ON_SCREENNAME_BY_STAGE_TRAGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnScreenNameByStageTarget";
	public static final String RETRIEVE_ON_AFFILIATIONNAME =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnAffiliationName";
	public static final String RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnAffiliationNameByStage";
	public static final String RETRIEVE_ON_AFFILIATIONNAME_BY_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnAffiliationNameByTarget";
	public static final String RETRIEVE_ON_AFFILIATIONNAME_BY_STAGE_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsOnAffiliationNameByStageTarget";
	public static final String RETRIEVE_BY_VOCABULARY_ID =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByVocabularyId";
	public static final String RETRIEVE_BY_VOCABULARY_ID_STAGE =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByVocabularyIdStage";
	public static final String RETRIEVE_BY_VOCABULARY_ID_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByVocabularyIdTarget";
	public static final String RETRIEVE_BY_VOCABULARY_ID_STAGE_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByVocabularyIdStageTarget";
	public static final String RETRIEVE_BY_CATEGORY_ID =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByCategoryId";
	public static final String RETRIEVE_BY_CATEGORY_ID_STAGE =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByCategoryIdStage";
	public static final String RETRIEVE_BY_CATEGORY_ID_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByCategoryIdTarget";
	public static final String RETRIEVE_BY_CATEGORY_ID_STAGE_TARGET =
		    ScienceAppFinder.class.getName() +
		        ".retrieveScienceAppsByCategoryIdStageTarget";
}
