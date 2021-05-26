/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.StudentDetailService;

/**
 * @author divy2624
 *
 */
public class StudentLoginValidationTest {

	/**
	 * All are Valid
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isStudentBothValidTestCase() throws SQLException, InValidCredentialsException, ClassNotFoundException {
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA22BB1111";
		String studentPassword = "Divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName, studentRollNumber,
				studentPassword);
		assertTrue(inValidCredentials);
	}

	/**
	 * InValid Rollnumber and password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isRollNumberInValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA2B1111";
		String studentPassword = "divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName, studentRollNumber,
				studentPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * InValid Name and Invalid password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isPasswordInValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String studentName = "K.DIVYA";
		String studentRollNumber = "AA22BB1111";
		String studentPassword = "Divya";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName, studentRollNumber,
				studentPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Invalid Name and Password
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isNameInValidTestCase() throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String studentName = "M.KAVITHA";
		String studentRollNumber = "AA22BB1111";
		String studentPassword = "Divya@76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName, studentRollNumber,
				studentPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * All are Invalid
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	@Test
	public void isBothStudentInValidTestCase()
			throws ClassNotFoundException, SQLException, InValidCredentialsException {
		String studentName = "M.RAM";
		String studentRollNumber = "AA28NN0911";
		String studentPassword = "Ramyuu76";
		boolean inValidCredentials = StudentDetailService.studentValidation(studentName, studentRollNumber,
				studentPassword);
		assertFalse(inValidCredentials);
	}

}
