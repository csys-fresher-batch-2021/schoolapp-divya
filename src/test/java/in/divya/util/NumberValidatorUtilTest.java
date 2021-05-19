/**
 * 
 */
package in.divya.util;

import static org.junit.Assert.assertEquals;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.junit.jupiter.api.Test;

import in.divya.exceptions.InvalidNumberException;
import in.divya.util.NumberValidatorUtil;

/**
 * @author divy2624
 *
 */
@SuppressWarnings("unused")
public class NumberValidatorUtilTest {
	
	@Test
	public void validNumberIsTestedWithoutAnyAlphabets() throws ParseException, InvalidNumberException 
	{
		String number = "90";
		int isValidNumber = NumberValidatorUtil.isValidNumberOnly(number,"Marks number cannot contain alphabets");
		assertEquals(90, isValidNumber);
	}

	@Test
	public void invalidNumberIsTestedWithAlphabet() 
	{
		try 
		{
			String number = "8o";
			int isValidNumber = NumberValidatorUtil.isValidNumberOnly(number,"Marks cannot contain alphabets");
			assertEquals("80", isValidNumber);
		}
		catch (Exception e) 
		{
			assertEquals("Marks cannot contain alphabets", e.getMessage());
		}
	}

}
