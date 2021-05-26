/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.StaffDetailService;

/**
 * @author divy2624
 *
 */
public class StaffLoginValidationTest {
	/**
	 * Both are Valid
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isStaffBothValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String staffName = "M.LAKSHMI";
		String staffPassword = "Rlakshmi@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertTrue(inValidCredentials);
	}

	/**
	 * Invalid staffName and valid password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isNameInValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String staffName = "SELVA";
		String staffPassword = "Rlakshmi@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Valid staffName and Invalid password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isPasswordInValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String staffName = "M.LAKSHMI";
		String staffPassword = "RLaks@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Invalid staff name and Invalid password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isBothStaffInvalidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String staffName = "RAMYA";
		String staffPassword = "Ramya@56";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);
	}

}
