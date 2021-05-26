package in.divya.service;

import java.sql.SQLException;

import java.util.List;

import in.divya.dao.StudentDetailDAO;
import in.divya.exceptions.CannotRegisterStudentException;
import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentDetails;

/**
 * 
 * @author divy2624
 *
 */

public class StudentDetailService {

	private StudentDetailService() {
		/**
		 * Default constructor
		 */
	}

	/**
	 * Feature1: Registration-Add the student details To check it is successfully
	 * add or not.
	 */

	/**
	 * 
	 * @param student
	 * @return
	 * @throws EmptyStringException
	 * @throws InValidEmailIDException
	 * @throws InValidPasswordFormatException
	 * @throws InValidRollNumberFormatException
	 * @throws InValidBloodGroupFormatException
	 * @throws InValidStandardFormatException
	 * @throws InValidMobileNumberException
	 * @throws InValidDateException
	 */

	public static boolean addStudent(StudentDetails student) {
		boolean isAddedStudent = true;
		try {
			StudentDetailDAO.addStudent(student);
			return isAddedStudent;
		} catch (Exception e) {
			throw new CannotRegisterStudentException("Cannot add employee");

		}
	}

	/**
	 * If it is true......Login sucessfully. otherwise it is failed
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException 
	 */
	public static boolean studentValidation(String studentName, String studentRollNumber, String studentPassword)
			throws ClassNotFoundException, SQLException, InValidCredentialsException {
		boolean isValidStudentCredentials = false;
		List<String> studentCredetials = StudentDetailDAO.studentCredentialData();
		/**
		 * If it is true......Login sucessfully. otherwise it is failed
		 */
		if (studentCredetials.contains(studentName) && studentCredetials.contains(studentRollNumber)
				&& studentCredetials.contains(studentPassword)) {
			isValidStudentCredentials = true;
		}
		return isValidStudentCredentials;
	}

}
