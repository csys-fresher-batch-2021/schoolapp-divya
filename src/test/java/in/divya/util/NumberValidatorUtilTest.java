/**
 * 
 */
package in.divya.util;
import static org.junit.Assert.assertEquals;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.junit.Test;

import in.divya.exceptions.InvalidNumberException;

/**
 * @author divy2624
 *
 */
public class NumberValidatorUtilTest 
{
	/**
	 * To check given input is valid.
	 * @throws ParseException
	 * @throws InvalidNumberException
	 */
	
	@Test
	public void validNumberIsTestedWithoutAnyAlphabets() throws ParseException, InvalidNumberException 
	{
		String number = "90";
		int isValidNumber = NumberValidatorUtil.isValidNumberOnly(number,"Marks number cannot contain alphabets");
		assertEquals(90, isValidNumber);
	}

	/**
	 * To check given input is invalid.
	 * @throws ParseException
	 * @throws InvalidNumberException
	 */
	
	@Test
	public void invalidNumberIsTestedWithAlphabet() 
	{
		try 
		{
			String number = "8o";
			int isInValidNumber = NumberValidatorUtil.isValidNumberOnly(number,"Marks cannot contain alphabets");
			assertEquals(80, isInValidNumber);
		}
		catch (Exception e) 
		{
			assertEquals("Marks cannot contain alphabets", e.getMessage());
		}
	}
}
