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
	static StaffDetailService staffDetailService = new StaffDetailService();

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
		String staffEmailId = "laksram@gmail.com";
		String staffPassword = "Rlakshmi@123";
		boolean inValidCredentials = staffDetailService.staffValidation(staffName, staffEmailId, staffPassword);
		assertTrue(inValidCredentials);
	}

	/**
	 * Invalid staffName and valid emailId,password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isNameInValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String staffName = "SELVA";
		String staffEmailId = "laksram@gmail.com";
		String staffPassword = "Rlakshmi@123";
		boolean inValidCredentials = staffDetailService.staffValidation(staffName, staffEmailId, staffPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Valid staffName,emailID and Invalid password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isPasswordInValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String staffName = "M.LAKSHMI";
		String staffEmailId = "laksram@gmail.com";
		String staffPassword = "RLaks@123";
		boolean inValidCredentials = staffDetailService.staffValidation(staffName, staffEmailId, staffPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Both are Invalid
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isBothStaffInvalidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String staffName = "RAMYA";
		String staffEmailId = "laks@gmail.com";
		String staffPassword = "Ramya@56";
		boolean inValidCredentials = staffDetailService.staffValidation(staffName, staffEmailId, staffPassword);
		assertFalse(inValidCredentials);
	}

}
