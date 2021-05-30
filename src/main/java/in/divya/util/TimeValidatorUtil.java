/**
 * 
 */
package in.divya.util;

import java.time.LocalTime;



import in.divya.exceptions.InValidTimeFormatException;

/**
 * @author divy2624
 *
 */
public class TimeValidatorUtil {
	private TimeValidatorUtil() {
		// Default Constructor
	}



	public static LocalTime isTimeFormatOrNot(String date, String errorMessage) throws InValidTimeFormatException {
		try {
			return LocalTime.parse(date);
		} catch (Exception e) {
			throw new InValidTimeFormatException(errorMessage);
		}
	}

}
