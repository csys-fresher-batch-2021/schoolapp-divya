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
	public void isStudentBothValidTestCase() 
	{ 
		String studentName = "K.DIVYA";
		String studentRollNumber =  "AA22BB1111";
		String studentPassword = "Divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertTrue(inValidCredentials);	
	}
	
	/**
	 * InValid Rollnumber and password
	 */
	
	@Test
	public void studentValidationTest1() 
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
	public void studentValidationTest2() 
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
	public void studentValidationTest3() 
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
	public void isStudentBothInValidTestCase() 
	{ 
		String studentName = "M.RAM";
		String studentRollNumber = "AA2111";
		String studentPassword =  "ramyuu76" ;
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}
	

}
