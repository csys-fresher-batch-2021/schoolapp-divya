/**
 * 
 */
package in.divya.service;

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

}
