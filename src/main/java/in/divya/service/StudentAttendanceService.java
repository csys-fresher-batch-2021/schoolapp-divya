/**
 * 
 */
package in.divya.service;


import in.divya.dao.StudentAttendanceDetailDAO;
import in.divya.exceptions.CannotAddDetailsException;
import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentAttendanceDetails;

/**
 * @author divy2624
 *
 */
public class StudentAttendanceService {
	private StudentAttendanceService() {
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
			throw new CannotAddDetailsException("ALREADY EXISTS  (OR) ILLEGAL STUDENT ATTENDANCE ENTRY(BECAUSE ITS ONLY ALLOW FOR REGISTERED STUDENTS)");

		}
	}

	/**
	 * To update student attendance details.
	 * 
	 * @param mark
	 * @return
	 * @throws InValidCredentialsException
	 */
	public static boolean updateAttendance(StudentAttendanceDetails attendance) throws  InValidCredentialsException {
		boolean isUpdatedAttendance = true;
		try {
			StudentAttendanceDetailDAO.updateStudentMarks(attendance);
			return isUpdatedAttendance;
		} catch (Exception e) {
			throw new InValidCredentialsException("CANNOT UPDATE (ATTENDANCE RECORD NOT FOUND (OR) ILLEGAL STUDENT MARK ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");

		}

	}
}
