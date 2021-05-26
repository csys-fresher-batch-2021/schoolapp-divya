/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.*;

import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.junit.Test;

import in.divya.exceptions.NumberCannotBeNegativeException;

/**
 * @author divy2624
 *
 */
public class MarkValidatorTestCase {

	@Test
	public void validNumberIsTestedWithoutAnyNegativeNumber() throws ParseException, NumberCannotBeNegativeException {
		int number = 90;
		boolean isValidNumber = MarkValidator.isNumberPositive(number);
		assertTrue(isValidNumber);
	}

	/**
	 * To check InValid MobileNumber Format TestCase.
	 * 
	 * @throws Exception
	 */

	@Test
	public void invalidNumberIsTestedWithNegativeNumber() throws Exception {
		try {
			int number = -9;
			boolean isValidNumber = MarkValidator.isNumberPositive(number);
			assertFalse(isValidNumber);
		} catch (Exception e) {
			assertEquals("Number Cannot be Negative", e.getMessage());
		}

	}

}
