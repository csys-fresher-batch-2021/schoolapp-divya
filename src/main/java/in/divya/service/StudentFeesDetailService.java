/**
 * 
 */
package in.divya.service;

import java.util.List;

import in.divya.dao.StudentFeesDetailDAO;
import in.divya.exceptions.CannotAddDetailsException;
import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentFeesDetails;

/**
 * @author divy2624
 *
 */
public class StudentFeesDetailService {

	public StudentFeesDetailService() {
		// Default Constructor
	}

	/**
	 * To add student fees details.
	 * 
	 * @param fees
	 * @return
	 * @throws CannotAddDetailsException
	 */
	public boolean addFees(StudentFeesDetails fees) throws CannotAddDetailsException {
		StudentFeesDetailDAO studentFeesDetailDAO = new StudentFeesDetailDAO();
		boolean isAddedFees = true;
		try {
			studentFeesDetailDAO.saveFees(fees);
			return isAddedFees;
		} catch (Exception e) {
			throw new CannotAddDetailsException(
					"ALREADY EXISTS  (OR) ILLEGAL STUDENT FEES ENTRY(BECAUSE ITS ONLY ALLOW FOR REGISTERED STUDENTS)");

		}
	}

	/**
	 * To update student fees details.
	 * 
	 * @param fees
	 * @return
	 * @throws InValidCredentialsException
	 */
	public boolean updateFees(StudentFeesDetails fees) throws InValidCredentialsException {
		StudentFeesDetailDAO studentFeesDetailDAO = new StudentFeesDetailDAO();
		boolean isUpdatedFees = true;
		try {
			studentFeesDetailDAO.updateFees(fees);
			return isUpdatedFees;
		} catch (Exception e) {
			throw new InValidCredentialsException(
					"CANNOT UPDATE( FEES RECORD NOT FOUND (OR) ILLEGAL STUDENT FEES ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");

		}

	}

	/**
	 * To delete fees.
	 * 
	 * @param month
	 * @return
	 * @throws InValidCredentialsException
	 */
	public boolean deleteFees(String month) throws InValidCredentialsException {
		StudentFeesDetailDAO studentFeesDetailDAO = new StudentFeesDetailDAO();
		boolean isDelete = true;
		try {
			studentFeesDetailDAO.romoveFees(month);
			return isDelete;
		} catch (Exception e) {
			throw new InValidCredentialsException("FEES NOT FOUND");
		}
	}

	/**
	 * To display student fees details.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentFeesDetails> displayStudentFees(String studentRollNumber) throws ClassNotFoundException {
		StudentFeesDetailDAO studentFeesDetailDAO = new StudentFeesDetailDAO();
		return studentFeesDetailDAO.findStudentFees(studentRollNumber);

	}

	/**
	 * To display all student fees details.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentFeesDetails> displayAllStudentFees() throws ClassNotFoundException {
		StudentFeesDetailDAO studentFeesDetailDAO = new StudentFeesDetailDAO();
		return studentFeesDetailDAO.findAllStudentFees();

	}

}
