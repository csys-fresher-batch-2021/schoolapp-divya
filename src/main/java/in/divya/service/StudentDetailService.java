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

	public StudentDetailService() {
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

	public boolean addStudent(StudentDetails student) {
		StudentDetailDAO studentDetailDAO = new StudentDetailDAO();
		boolean isAddedStudent = true;
		try {
			studentDetailDAO.saveStudent(student);
			return isAddedStudent;
		} catch (Exception e) {
			throw new CannotRegisterStudentException("ALREADY EXISTS");

		}
	}

	/**
	 * If it is true......Login sucessfully. otherwise it is failed
	 * 
	 * @throws InValidCredentialsException
	 */

	public boolean studentValidation(String studentName, String studentRollNumber, String studentPassword)
			throws InValidCredentialsException {
		StudentDetailDAO studentDetailDAO = new StudentDetailDAO();
		boolean isValidStudentCredentials = false;
		List<String> studentCredetials = studentDetailDAO.studentCredentialData();
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
	public List<StudentDetails> displayAllStudentInformation(String staffName)
			throws InValidCredentialsException {
		StudentDetailDAO studentDetailDAO = new StudentDetailDAO();
		return studentDetailDAO.findAllStudentInformation(staffName);

	}

	/**
	 * To display individual student information.
	 * 
	 * @param studentRollnumber
	 * @return
	 * @throws InValidCredentialsException
	 */
	public Map<String, StudentDetails> displayIndividualStudentData(String studentRollnumber)
			throws InValidCredentialsException {
		StudentDetailDAO studentDetailDAO = new StudentDetailDAO();
		return studentDetailDAO.findIndividualStudentData(studentRollnumber);
	}

	/**
	 * To delete student details.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws InValidCredentialsException
	 */

	public boolean deleteStudentFromTheDataBase(String studentRollNumber) throws InValidCredentialsException {
		StudentDetailDAO studentDetailDAO = new StudentDetailDAO();
		return studentDetailDAO.deleteStudentFromTable(studentRollNumber);

	}

}
