/**
 * 
 */
package in.divya.util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.divya.exceptions.InValidEmailIDException;

/**
 * @author divy2624
 *
 */
public class EmailIDValidatorUtilTestCase {

	/**
	 * To check Valid EmailId Format TestCase.
	 * 
	 * @throws InValidEmailIDException
	 */

	@Test
	public void validEmailIdIsTested() throws InValidEmailIDException {
		String emailId = "divya@gmail.com";
		boolean isValidMail = EmailIDValidatorUtil.isValidEmailId(emailId, "InValid EmailId Format");
		assertTrue(isValidMail);
	}

	/**
	 * To check InValid EmailId Format TestCase.
	 */

	@Test
	public void inValidEmailIdIsTested() {
		try {
			String emailId = "divyagmail.com";
			boolean isValidMail = EmailIDValidatorUtil.isValidEmailId(emailId, "InValid EmailID Format");
			assertFalse(isValidMail);
		} catch (Exception e) {
			assertEquals("InValid EmailID Format", e.getMessage());

		}
	}

}
