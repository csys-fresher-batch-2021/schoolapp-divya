/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void isStudentBothValidTestCase() throws ClassNotFoundException, SQLException 
	{ 
		String studentName = "K.DIVYA";
		String studentRollNumber =  "AA22BB1111";
		String studentPassword = "Divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertTrue(inValidCredentials);	
	}
	
	/**
	 * InValid Rollnumber and password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void studentValidationTest1() throws ClassNotFoundException, SQLException 
	{ 
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA2B1111";
		String studentPassword = "divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * InValid Name and Invalid password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void studentValidationTest2() throws ClassNotFoundException, SQLException 
	{ 
		String studentName = "V.RAMYA";
		String studentRollNumber = "AA22BB1111" ;
		String studentPassword =  "Divya";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * Invalid Name and Password
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void studentValidationTest3() throws ClassNotFoundException, SQLException 
	{ 
		String studentName = "M.KAVITHA";
		String studentRollNumber = "B1111" ;
		String studentPassword =  "Divya@76" ;
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}	
	
	/**
	 * All are Invalid
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	@Test
	public void isStudentBothInValidTestCase() throws ClassNotFoundException, SQLException 
	{ 
		String studentName = "M.RAM";
		String studentRollNumber = "AA2111";
		String studentPassword =  "ramyuu76" ;
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName,studentRollNumber,studentPassword);
		assertFalse(inValidCredentials);	
	}
	

}
