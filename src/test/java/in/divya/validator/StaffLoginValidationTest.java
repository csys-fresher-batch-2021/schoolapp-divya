/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import in.divya.service.StaffDetailService;

/**
 * @author divy2624
 *
 */
public class StaffLoginValidationTest 
{
	/**
	 * Both are Valid
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void isStaffBothValidTestCase() throws ClassNotFoundException, SQLException 
	{ 
		String staffName = "M.LAKSHMI";
		String staffPassword =  "Rlakshmi@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertTrue(inValidCredentials);	
	}
	
	/**
	 * Invalid staffName and valid password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void isStaffValidNameTestCase() throws ClassNotFoundException, SQLException 
	{ 
		String staffName = "SELVA";
		String staffPassword = "Rlakshmi@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);
	}	
	
	/**
	 * Valid staffName and Invalid password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void isStaffValidPasswordTestCase() throws ClassNotFoundException, SQLException
	{ 
		String staffName = "M.LAKSHMI";
		String staffPassword =  "RLaks@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * Invalid staff name and Invalid password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void isStaffBothInvalidTestCase() throws ClassNotFoundException, SQLException 
	{ 
		String staffName = "RAMYA";
		String staffPassword =  "Ramya@56";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);	
	}	

	
}
