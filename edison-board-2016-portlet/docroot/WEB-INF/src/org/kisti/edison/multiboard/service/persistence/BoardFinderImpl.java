package org.kisti.edison.multiboard.service.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.multiboard.model.Board;
import org.kisti.edison.multiboard.model.impl.BoardDivImpl;
import org.kisti.edison.multiboard.model.impl.BoardImpl;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class BoardFinderImpl extends BasePersistenceImpl<Board> implements BoardFinder{

	public List<Object[]> getCustomListBoard(long divCd, int begin, int listSize, long groupId, String customId, String searchValue, long groupBoardSeq, boolean popupYn, String siteGroup) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.Board.getCustomListBoard");
			String sqlCommon = CustomSQLUtil.get("org.kisti.edison.service.persistence.Board.getBoardCommon");
			String sqlLimit = CustomSQLUtil.get("org.kisti.edison.service.persistence.Board.getBoardLimit");
			
            sql.append(sqlSelect); 
            sql.append(sqlCommon);
            sql.append(sqlLimit);
            
            session=openSession();
            
            Map params = new HashMap();
            params.put("divCd", divCd);
            params.put("begin", begin);
            params.put("end", listSize);
            params.put("listSize", listSize);
            params.put("groupId", groupId);
            if(!customId.equals("")) params.put("customId", customId);
            if(!searchValue.equals("")) params.put("searchValue", searchValue);
            params.put("groupBoardSeq", groupBoardSeq);
            if(popupYn) {
            	params.put("popupYn", 1);
            } else {
            	params.put("popupYn", 0);
            }
            if(!siteGroup.equals("")) {
            	params.put("siteGroup", siteGroup);
            }
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            SQLQuery query = session.createSQLQuery(gBatisQuery);
            query.addEntity("EDCON_Board", BoardImpl.class);
            query.addEntity("EDCON_BoardDiv", BoardDivImpl.class);
            query.addScalar("replyCount", Type.INTEGER);
            
            return (List<Object[]>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getCustomCountBoard(long divCd, long groupId, String customId, String searchValue, long groupBoardSeq, String siteGroup) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {

			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.Board.getCustomCountBoard");
			String sqlCommon = CustomSQLUtil.get("org.kisti.edison.service.persistence.Board.getBoardCommon");

            sql.append(sqlSelect); 
            sql.append(sqlCommon);

            Map params = new HashMap();
            
            params.put("divCd", divCd);
            params.put("groupId", groupId);
            if(!customId.equals("")) params.put("customId", customId);
            if(!searchValue.equals("")) params.put("searchValue", searchValue);
            params.put("groupBoardSeq", groupBoardSeq);
            
            if(!siteGroup.equals("")) {
            	params.put("siteGroup", siteGroup);
            } 
            
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());

            session=openSession();
            SQLQuery query = session.createSQLQuery(gBatisQuery);
            
            query.addScalar("totalCount", Type.INTEGER);
                 
            return (Integer) query.uniqueResult();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Object[] getBoard(long divCd, String customId, long boardSeq) {
		StringBuffer sql = new StringBuffer();
		Session session = null;
		try {
			String sqlSelect = CustomSQLUtil.get("org.kisti.edison.service.persistence.Board.getCustomListBoard");
			String sqlCommon = CustomSQLUtil.get("org.kisti.edison.service.persistence.Board.getBoard.where");
			
            sql.append(sqlSelect); 
            sql.append(sqlCommon);
            
            session=openSession();
            
            Map params = new HashMap();
            
//            params.put("groupId", groupId);
            if(!customId.equals("")){
            	params.put("customId", customId);
            }
            params.put("divCd", divCd);
            params.put("boardSeq", boardSeq);
            params.put("groupBoardSeq", 0);
            
            String gBatisQuery = GBatisUtil.getGBatis(params, sql.toString());
            SQLQuery query = session.createSQLQuery(gBatisQuery);
            query.addEntity("EDCON_Board", BoardImpl.class);
            query.addEntity("EDCON_BoardDiv", BoardDivImpl.class);
            query.addScalar("replyCount", Type.INTEGER);
            
            return (Object[]) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	
}