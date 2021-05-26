/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.divya.exceptions.InValidRollNumberFormatException;
import in.divya.exceptions.InValidStandardFormatException;

/**
 * @author divy2624
 *
 */
public class ValidationValidatorTest{
	
	/**
	 * To check Roll Number TestCase.
	 * @throws InValidRollNumberFormatException
	 */
	
	@Test
	public void validRollNumberFormatIsTested() throws InValidRollNumberFormatException { 
		String rollNumber = "AA23BB3456";
		boolean isValidRollNumber = RollNumberValidator.isValidRollNumberFormat(rollNumber, "InValid rollNumber format");
		assertTrue(isValidRollNumber);
	}	
	
	/**
	 * To check Invalid Roll Number TestCase.
	 */
	
	@Test
	public void inValidRollNumberFormatIsTested1() { 
		try {
			String rollNumber = "2345VV67AA";
			boolean isValidPassword = RollNumberValidator.isValidRollNumberFormat(rollNumber, "InValid RollNumber format");
			assertFalse(isValidPassword);
		} catch (Exception e) {
			assertEquals("InValid RollNumber format", e.getMessage());
		}
	}
	
	/**
	 * To check Standard TestCase.
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
			boolean isValidRollNumber = StandardValidator.isValidStandardValidation(standard, "InValid standard format");
			assertFalse(isValidRollNumber);
		} catch (Exception e) {
			assertEquals("InValid standard format", e.getMessage());
		}
	}
	
	
	
	

	

	

}
