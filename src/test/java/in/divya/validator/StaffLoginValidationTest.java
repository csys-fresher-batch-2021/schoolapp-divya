/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	 */
	
	@Test
	public void staffValidationTestBothValid() 
	{ 
		String staffName = "M.LAKSHMI";
		String staffPassword =  "Rlakshmi@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertTrue(inValidCredentials);	
	}
	
	/**
	 * Invalid staffName and valid password
	 */
	
	@Test
	public void validPassword() 
	{ 
		String staffName = "SELVA";
		String staffPassword = "Rlakshmi@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);
	}	
	
	/**
	 * Valid staffName and Invalid password
	 */
	
	@Test
	public void testValidName()
	{ 
		String staffName = "M.LAKSHMI";
		String staffPassword =  "RLaks@123";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * Invalid staff name and Invalid password
	 */
	
	@Test
	public void bothInvalid() 
	{ 
		String staffName = "RAMYA";
		String staffPassword =  "Ramya@56";
		boolean inValidCredentials = StaffDetailService.staffValidation(staffName, staffPassword);
		assertFalse(inValidCredentials);	
	}	

	
}
