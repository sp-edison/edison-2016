/**
 * 
 */
package kisti.edison.cloud.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

import org.hibernate.type.TimestampType;

/**
 * @author root
 * 
 */
public class UtcTimestampType extends TimestampType {
	// private static final long serialVersionUID = 1132973341902870049L;
	// private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
	//
	// @Override
	// public Object get(ResultSet rs, String name) throws SQLException {
	// return rs.getTimestamp(name, Calendar.getInstance(UTC));
	// }
	//
	// @Override
	// public void set(PreparedStatement st, Object value, int index) throws
	// SQLException {
	// Timestamp ts;
	// if(value instanceof Timestamp) {
	// ts = (Timestamp) value;
	// } else {
	// ts = new Timestamp(((java.util.Date) value).getTime());
	// }
	// st.setTimestamp(index, ts, Calendar.getInstance(UTC));
	// }
}
