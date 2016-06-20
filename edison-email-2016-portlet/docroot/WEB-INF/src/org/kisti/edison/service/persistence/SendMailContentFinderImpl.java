package org.kisti.edison.service.persistence;

import java.util.List;
import java.util.Map;

import org.kisti.edison.model.SendMailContent;
import org.kisti.edison.model.impl.SendMailContentImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class SendMailContentFinderImpl extends BasePersistenceImpl<SendMailContent> implements SendMailContentFinder {
  public static final String GET_SENT_MAIL_LIST_HEADER =
		  SendMailContentFinder.class.getName() +
      ".getListSentMail.header";

  public static final String GET_SENT_MAIL_COUNT_HEADER =
		  SendMailContentFinder.class.getName() +
      ".getCountSentMail.header";

  public static final String GET_SENT_MAIL_LIST_WHERE =
		  SendMailContentFinder.class.getName() +
      ".getListSentMail.where";

  public int retrieveCountSentMailContent(Map<String,Object> searchParam) throws SystemException{
	StringBuilder sqlSb = new StringBuilder();
	Session session = null;
	
	//DB Cache Clear
	CacheRegistryUtil.clear();
	try{
		
		String sqlQuerySelect = CustomSQLUtil.get(GET_SENT_MAIL_COUNT_HEADER);
		String sqlQuery = CustomSQLUtil.get(GET_SENT_MAIL_LIST_WHERE);
		sqlSb.append(sqlQuerySelect);
		sqlSb.append(sqlQuery);
		
		session = openSession();
		String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
		SQLQuery query = session.createSQLQuery(gBatisQuery);
		query.addScalar("totalCount", Type.INTEGER);
		
		return (Integer)query.uniqueResult();
		
	}catch (Exception e) {
		e.printStackTrace();
		throw new SystemException(e);
	} finally {
		closeSession(session);
	}
  }  
  
  public List<Object[]> retrieveSentMailContent(Map<String,Object> searchParam) throws SystemException{
	  StringBuilder sqlSb = new StringBuilder();
	  Session session = null;
	  
	  //DB Cache Clear
	  CacheRegistryUtil.clear();
	  try{
		  
		  String sqlQuerySelect = CustomSQLUtil.get(GET_SENT_MAIL_LIST_HEADER);
		  String sqlQuery = CustomSQLUtil.get(GET_SENT_MAIL_LIST_WHERE);
		  sqlSb.append(sqlQuerySelect);
		  sqlSb.append(sqlQuery);
		  
		  session = openSession();
		  String gBatisQuery = GBatisUtil.getGBatis(searchParam, sqlSb.toString());
		  SQLQuery query = session.createSQLQuery(gBatisQuery);
		  query.addEntity("EDAPP_SendMailContent", SendMailContentImpl.class);
		  query.addScalar("screenName", Type.STRING);
		  
		  return (List<Object[]>) query.list();
		  
	  }catch (Exception e) {
		  e.printStackTrace();
		  throw new SystemException(e);
	  } finally {
		  closeSession(session);
	  }
  }
 
}
