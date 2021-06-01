/**
 * 
 */
package in.divya.service;

import java.sql.SQLException;

import java.time.LocalDate;
import java.util.List;

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
			throw new CannotAddDetailsException(
					"ALREADY EXISTS  (OR) ILLEGAL STUDENT ATTENDANCE ENTRY(BECAUSE ITS ONLY ALLOW FOR REGISTERED STUDENTS)");

		}
	}

	/**
	 * To update student attendance details.
	 * 
	 * @param mark
	 * @return
	 * @throws InValidCredentialsException
	 */
	public static boolean updateAttendance(StudentAttendanceDetails attendance) throws InValidCredentialsException {
		boolean isUpdatedAttendance = true;
		try {
			StudentAttendanceDetailDAO.updateStudentMarks(attendance);
			return isUpdatedAttendance;
		} catch (Exception e) {
			throw new InValidCredentialsException(
					"CANNOT UPDATE (ATTENDANCE RECORD NOT FOUND (OR) ILLEGAL STUDENT ATTENDANCE ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");

		}

	}

	/**
	 * To delete Attendance
	 * 
	 * @param attendanceDate
	 * @return
	 * @throws InValidCredentialsException
	 */
	public static boolean deleteStudentAttendance(LocalDate attendanceDate) throws InValidCredentialsException {
		boolean isDelete = true;
		try {
			StudentAttendanceDetailDAO.romoveAttendanceFromTable(attendanceDate);
			return isDelete;
		} catch (Exception e) {
			throw new InValidCredentialsException("DATE OF ATTENDANCE NOT FOUND");
		}
	}

	/**
	 * To display attendance list
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws SQLException
	 * @throws InValidCredentialsException
	 */
	public static List<StudentAttendanceDetails> displayStudentAttendance(String studentRollNumber)
			throws SQLException, InValidCredentialsException {

		return StudentAttendanceDetailDAO.findStudentAttendance(studentRollNumber);

	}

}
