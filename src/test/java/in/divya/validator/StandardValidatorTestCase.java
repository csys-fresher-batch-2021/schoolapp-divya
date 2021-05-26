/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import in.divya.exceptions.InValidStandardFormatException;

/**
 * @author divy2624
 *
 */
public class StandardValidatorTestCase {

	/**
	 * To check Standard TestCase.
	 * 
	 * @throws InValidStandardFormatException
	 */

	@Test
	public void validStandardFormatIsTested() throws InValidStandardFormatException {
		String standard = "XII";
		boolean isValidRollNumber = StandardValidator.isValidStandardValidation(standard, "InValid standard format");
		assertTrue(isValidRollNumber);
	}

	/**
	 * To check Invalid Standard TestCase.
	 */

	@Test
	public void inValidStandardFormatIsTested1() {
		try {
			String standard = "X&7";
			boolean isValidRollNumber = StandardValidator.isValidStandardValidation(standard,
					"InValid standard format");
			assertFalse(isValidRollNumber);
		} catch (Exception e) {
			assertEquals("InValid standard format", e.getMessage());
		}
	}
}
