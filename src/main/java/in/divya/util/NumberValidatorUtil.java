/**
 * 
 */
package in.divya.util;

/**
 * @author divy2624
 *
 */
public class NumberValidatorUtil {
	private NumberValidatorUtil()
	{
		/**
		 * Default constructor
		 */
	}
	
	public static int isValidNumberOnly(String number, String errorMessage)
	{
		try 
		{
			return Integer.parseInt(number);
		} 
		catch (Exception e) 
		{
			throw new RuntimeException(errorMessage);
		}
	}

}
