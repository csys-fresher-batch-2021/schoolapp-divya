/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import in.divya.service.StudentDetailService;

/**
 * @author divy2624
 *
 */
public class StudentLoginValidationTest
{

	/**
	 * All are Valid
	 */
	
	@Test
	public void studentValidationTestBothValid() 
	{ 
		String studentName = "K.DIVYA";
		String studentRollNumber =  "AA22BB1111";
		String studentPassword = "Divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertTrue(inValidCredentials);	
	}
	
	/**
	 * Invalid Rollnumber and password
	 */
	
	@Test
	public void nameValid() 
	{ 
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA2B1111";
		String studentPassword = "divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * InValid Name and Invalid password
	 */
	
	@Test
	public void isRollNumberValid() 
	{ 
		String studentName = "V.RAMYA";
		String studentRollNumber = "AA22BB1111" ;
		String studentPassword =  "Divya";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * Invalid Name and Password
	 */
	
	@Test
	public void passwordValid() 
	{ 
		String studentName = "M.KAVITHA";
		String studentRollNumber = "B1111" ;
		String studentPassword =  "Divya@76" ;
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * All are Invalid
	 */
	
	@Test
	public void bothInValid() 
	{ 
		String studentName = "M.RAM";
		String studentRollNumber = "AA2111";
		String studentPassword =  "ramyuu76" ;
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}
	

}
