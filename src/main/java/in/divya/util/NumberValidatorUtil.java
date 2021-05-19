/**
 * 
 */
package in.divya.util;

import in.divya.exceptions.InvalidNumberException;

/**
 * @author divy2624
 *
 */
public class NumberValidatorUtil 
{
		private NumberValidatorUtil()
		{
			/**
			 * Default constructor
			 */
		}
		
		public static int isValidNumberOnly(String number, String errorMessage) throws InvalidNumberException
		{
			try 
			{
				return Integer.parseInt(number);
			} 
			catch (Exception e) 
			{
				throw new InvalidNumberException(errorMessage);
			}
		}

}
