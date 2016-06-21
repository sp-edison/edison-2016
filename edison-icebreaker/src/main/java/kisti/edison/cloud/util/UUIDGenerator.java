/**
 * 
 */
package kisti.edison.cloud.util;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * @author root
 * 
 */
public class UUIDGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SessionImplementor session, Object parent)
			throws HibernateException {
		UUID u = UUID.randomUUID();
		return u;
	}
}
