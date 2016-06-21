/**
 * 
 */
package kisti.edison.cloud.util;

import java.util.Date;

import org.joda.time.DateTimeZone;

/**
 * @author root
 * 
 */
public class DateUtil {

	public static long getUTCTime() {
		Date local = new Date();
		DateTimeZone zone = DateTimeZone.getDefault();
		return zone.convertLocalToUTC(local.getTime(), false);
	}

	public static long getLocalTime(long utc) {
		DateTimeZone zone = DateTimeZone.getDefault();
		return zone.convertUTCToLocal(utc);
	}
}
