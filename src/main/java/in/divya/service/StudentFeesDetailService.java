/**
 * 
 */
package in.divya.service;

import in.divya.dao.StudentFeesDetailDAO;
import in.divya.exceptions.CannotAddDetailsException;
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

}
