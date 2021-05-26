/**
 * 
 */
package in.divya.util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.divya.exceptions.InValidPasswordFormatException;

/**
 * @author divy2624
 *
 */
public class PasswordValidatorUtilTestCase {

	/**
	 * To check Valid Password Format TestCase.
	 * 
	 * @throws InValidPasswordFormatException
	 */

	@Test
	public void validPasswordFormatIsTested() throws InValidPasswordFormatException {
		String password = "Divya@76";
		boolean isValidPassword = PasswordValidatorUtil.isValidPasswordFormat(password, "Invalid password format");
		assertTrue(isValidPassword);
	}

	/**
	 * To check InValid Password Format TestCase.
	 */

	@Test
	public void inValidPasswordFormatIsTested() {
		try {
			String password = "raja123";
			boolean isValidPassword = PasswordValidatorUtil.isValidPasswordFormat(password, "Invalid password format");
			assertFalse(isValidPassword);
		} catch (Exception e) {
			assertEquals("Invalid password format", e.getMessage());
		}
	}

}
