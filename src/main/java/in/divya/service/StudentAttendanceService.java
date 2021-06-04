/**
 * 
 */
package in.divya.service;

import java.sql.SQLException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import in.divya.dao.StudentAttendanceDetailDAO;
import in.divya.exceptions.CannotAddDetailsException;
import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentAttendanceDetails;

/**
 * @author divy2624
 *
 */
public class StudentAttendanceService {
	public StudentAttendanceService() {
		// Default Constructor
	}

	/**
	 * To add student attendance details.
	 * 
	 * @param attendance
	 * @return
	 * @throws CannotAddDetailsException
	 */
	public boolean addAttendance(StudentAttendanceDetails attendance) throws CannotAddDetailsException {
		StudentAttendanceDetailDAO studentAttendanceDetailDAO = new StudentAttendanceDetailDAO();
		boolean isAddedAttendance = true;
		try {
			studentAttendanceDetailDAO.saveAttendance(attendance);
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
	public boolean updateAttendance(StudentAttendanceDetails attendance) throws InValidCredentialsException {
		StudentAttendanceDetailDAO studentAttendanceDetailDAO = new StudentAttendanceDetailDAO();
		boolean isUpdatedAttendance = true;
		try {
			studentAttendanceDetailDAO.updateStudentMarks(attendance);
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
	public boolean deleteStudentAttendance(LocalDate attendanceDate) throws InValidCredentialsException {
		StudentAttendanceDetailDAO studentAttendanceDetailDAO = new StudentAttendanceDetailDAO();
		boolean isDelete = true;
		try {
			studentAttendanceDetailDAO.romoveAttendanceFromTable(attendanceDate);
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
	 * @throws ClassNotFoundException
	 */
	public List<StudentAttendanceDetails> displayStudentAttendance(String studentRollNumber)
			throws ClassNotFoundException {
		StudentAttendanceDetailDAO studentAttendanceDetailDAO = new StudentAttendanceDetailDAO();
		return studentAttendanceDetailDAO.findStudentAttendance(studentRollNumber);

	}

	/**
	 * Display all student attendance.
	 * 
	 * @param date
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<StudentAttendanceDetails> displayAllStudentAttendance(LocalDate date) throws ClassNotFoundException {
		StudentAttendanceDetailDAO studentAttendanceDetailDAO = new StudentAttendanceDetailDAO();
		return studentAttendanceDetailDAO.findAllStudentAttendance(date);

	}

	/**
	 * To display the count of attendance status.
	 * 
	 * @param date
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Map<String, Integer> displayAttendanceStatusCount(LocalDate date) throws ClassNotFoundException {
		StudentAttendanceDetailDAO studentAttendanceDetailDAO = new StudentAttendanceDetailDAO();
		return studentAttendanceDetailDAO.findAttendanceStatusCount(date);

	}

	/**
	 * To display the count of students in attendance.
	 * 
	 * @param date
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int displayAttendanceCount(LocalDate date) throws ClassNotFoundException {
		StudentAttendanceDetailDAO studentAttendanceDetailDAO = new StudentAttendanceDetailDAO();
		return studentAttendanceDetailDAO.findAttendanceCount(date);

	}

}
