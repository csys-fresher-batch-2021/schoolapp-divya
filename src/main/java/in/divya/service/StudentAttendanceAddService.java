/**
 * 
 */
package in.divya.service;

import in.divya.dao.StudentAttendanceDetailDAO;
import in.divya.exceptions.CannotAddDetailsException;
import in.divya.model.StudentAttendanceDetails;

/**
 * @author divy2624
 *
 */
public class StudentAttendanceAddService {
	private StudentAttendanceAddService() {
		// Default Constructor
	}

	/**
	 * To add student attendance details.
	 * 
	 * @param attendance
	 * @return
	 * @throws CannotAddDetailsException
	 */
	public static boolean addAttendance(StudentAttendanceDetails attendance) throws CannotAddDetailsException {
		boolean isAddedAttendance = true;
		try {
			StudentAttendanceDetailDAO.saveAttendance(attendance);
			return isAddedAttendance;
		} catch (Exception e) {
			throw new CannotAddDetailsException("Cannot Add Attendance");

		}
	}

}
