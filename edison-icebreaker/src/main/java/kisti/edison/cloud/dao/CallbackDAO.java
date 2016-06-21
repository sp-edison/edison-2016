package kisti.edison.cloud.dao;

import kisti.edison.cloud.model.Callback;

import org.hibernate.Session;

public interface CallbackDAO {
	
	public Callback getCallback(Session session, String uuid);

	public boolean deleteCallback(Session session, String uuid);

	public Callback updateCallback(Session session, Callback callback);

	public void addCallback(Session session, Callback callback);
	
	public Callback findCallbackByUUID(Session session, String uuid);

//	public List<Simulation> findSimulationsByUserId(Session session, String userId, String orderBy, String order);
//
//	public List<Simulation> querySimulations(Session session, String userId, String orderBy, String order, int startIndex, int maxResults);
//	
//	public List<Simulation> querySimulations(Session session, String orderBy, String order, int startIndex, int maxResults);


}
