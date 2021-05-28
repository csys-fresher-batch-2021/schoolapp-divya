package in.divya.service;

import java.util.List;
import java.util.Map;

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
	 * Registration-Add the student details To check it is successfully
	 * 
	 * @param student
	 * @return
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
	 * @throws InValidCredentialsException
	 */
	
	public static boolean studentValidation(String studentName, String studentRollNumber, String studentPassword)
			throws InValidCredentialsException {
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
	 * @throws InValidCredentialsException
	 */
	public static List<StudentDetails> displayAllStudentInformation(String staffName)
			throws InValidCredentialsException {
		return StudentDetailDAO.displayAllStudentInformation(staffName);

	}

	/**
	 * To display individual student information.
	 * 
	 * @param studentRollnumber
	 * @return
	 * @throws InValidCredentialsException
	 */
	public static Map<String, StudentDetails> displayIndividualStudentData(String studentRollnumber)
			throws InValidCredentialsException {

		return StudentDetailDAO.displayIndividualStudentData(studentRollnumber);
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
