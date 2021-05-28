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
			throw new CannotRegisterStudentException("Cannot add Student");

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
			throws SQLException, InValidCredentialsException {
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

	/**
	 * To display all student Information.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws InValidCredentialsException
	 */
	public static List<StudentDetails> displayAllStudentInformation(String staffName)
			throws SQLException, InValidCredentialsException {
		return StudentDetailDAO.displayAllStudentInformation(staffName);

	}

	/**
	 * To delete student details.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws InValidCredentialsException
	 */

	public static boolean deleteStudentFromTheDataBase(String studentRollNumber) throws InValidCredentialsException {
		return StudentDetailDAO.deleteStudentFromTable(studentRollNumber);

	}

}
