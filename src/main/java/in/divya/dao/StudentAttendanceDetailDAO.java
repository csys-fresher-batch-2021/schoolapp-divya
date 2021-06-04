/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentAttendanceDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class StudentAttendanceDetailDAO {

	public StudentAttendanceDetailDAO() {
		// Default Constructor
	}

	/**
	 * To Save the student attendance details in database.
	 * 
	 * @param attendance
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */
	public void saveAttendance(StudentAttendanceDetails attendance)
			throws ClassNotFoundException, InValidCredentialsException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into attendance_data(student_roll_number,attendance_date,attendance_status,in_time,out_time,reason)values(?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setString(1, attendance.getStudentRollNumber());
			pst.setObject(2, attendance.getDate());
			pst.setString(3, attendance.getStudentAttendance());
			pst.setObject(4, attendance.getInTime());
			pst.setObject(5, attendance.getOutTime());
			pst.setString(6, attendance.getReason());

			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InValidCredentialsException(
					"ALREADY EXISTS  (OR) ILLEGAL STUDENT ATTENDANCE ENTRY(BECAUSE ITS ONLY ALLOW FOR REGISTERED STUDENTS)");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * To update student Attendance in database.
	 * 
	 * @param attendance
	 * @throws InValidCredentialsException
	 * @throws ClassNotFoundException
	 */
	public void updateStudentMarks(StudentAttendanceDetails attendance)
			throws InValidCredentialsException, ClassNotFoundException {
		PreparedStatement pst = null;
		Connection connection = null;
		int rs = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update attendance_data set attendance_status=?,in_time=?,out_time=?,reason=? where student_roll_number=? and attendance_date=?";

			pst = connection.prepareStatement(sql);

			pst.setString(1, attendance.getStudentAttendance());
			pst.setObject(2, attendance.getInTime());
			pst.setObject(3, attendance.getOutTime());
			pst.setString(4, attendance.getReason());
			pst.setString(5, attendance.getStudentRollNumber());
			pst.setObject(6, attendance.getDate());
			rs = pst.executeUpdate();
			if (rs == 0) {
				throw new InValidCredentialsException(
						"CANNOT UPDATE (ATTENDANCE RECORD NOT FOUND (OR) ILLEGAL STUDENT ATTENDANCE ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * To remove attendance
	 * 
	 * @param attendance_date
	 * @throws InValidCredentialsException
	 * @throws ClassNotFoundException
	 */
	public void romoveAttendanceFromTable(LocalDate attendanceDate)
			throws InValidCredentialsException, ClassNotFoundException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String str = "delete from attendance_data where attendance_date=?";
			pst = connection.prepareStatement(str);
			pst.setObject(1, attendanceDate);
			rs = pst.executeUpdate();
			if (rs == 0) {
				throw new InValidCredentialsException("DATE OF ATTENDANCE NOT FOUND");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * To display student attendance.
	 * 
	 * @param rollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentAttendanceDetails> findStudentAttendance(String rollNumber) throws ClassNotFoundException {

		List<StudentAttendanceDetails> studentAttendanceData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from attendance_data where student_roll_number=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, rollNumber);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentAttendanceDetails attendance = new StudentAttendanceDetails();

				String studentRollNumber = rs.getString("student_roll_number");
				LocalDate attendanceDate = LocalDate.parse(rs.getString("attendance_date"));
				String attendanceStatus = rs.getString("attendance_status");
				LocalTime inTime = LocalTime.parse(rs.getString("in_time"));
				LocalTime outTime = LocalTime.parse(rs.getString("out_time"));
				String reason = rs.getString("reason");

				/**
				 * Store the data in model
				 */
				attendance.setStudentRollNumber(studentRollNumber);
				attendance.setDate(attendanceDate);
				attendance.setStudentAttendance(attendanceStatus);
				attendance.setInTime(inTime);
				attendance.setOutTime(outTime);
				attendance.setReason(reason);

				/**
				 * Store attendance in list
				 */

				studentAttendanceData.add(attendance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentAttendanceData;
	}

	/**
	 * Display all student Attendance.
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentAttendanceDetails> findAllStudentAttendance(LocalDate date) throws ClassNotFoundException {
		List<StudentAttendanceDetails> studentAttendanceData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from attendance_data where attendance_date=? order by student_roll_number asc";

			pst = connection.prepareStatement(sql);
			pst.setObject(1, date);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentAttendanceDetails attendance = new StudentAttendanceDetails();

				String studentRollNumber = rs.getString("student_roll_number");
				LocalDate attendanceDate = LocalDate.parse(rs.getString("attendance_date"));
				String attendanceStatus = rs.getString("attendance_status");
				LocalTime inTime = LocalTime.parse(rs.getString("in_time"));
				LocalTime outTime = LocalTime.parse(rs.getString("out_time"));
				String reason = rs.getString("reason");

				/**
				 * Store the data in model
				 */
				attendance.setStudentRollNumber(studentRollNumber);
				attendance.setDate(attendanceDate);
				attendance.setStudentAttendance(attendanceStatus);
				attendance.setInTime(inTime);
				attendance.setOutTime(outTime);
				attendance.setReason(reason);

				/**
				 * Store attendance in List
				 */

				studentAttendanceData.add(attendance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentAttendanceData;
	}

	/**
	 * Display Attendance Status Count.
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Map<String, Integer> findAttendanceStatusCount(LocalDate date) throws ClassNotFoundException {
		Map<String, Integer> studentAttendanceCount = new HashMap<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select attendance_status, count(*) as cnt from attendance_data where attendance_date=? group by attendance_status";

			pst = connection.prepareStatement(sql);
			pst.setObject(1, date);
			rs = pst.executeQuery();

			while (rs.next()) {
				String status = rs.getString("attendance_status");
				Integer cnt = rs.getInt("cnt");
				studentAttendanceCount.put(status, cnt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentAttendanceCount;

	}

	/**
	 * Display Number Of Students
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 */
	public int findAttendanceCount(LocalDate date) throws ClassNotFoundException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select count(*) from attendance_data where attendance_date=?";

			pst = connection.prepareStatement(sql);
			pst.setObject(1, date);
			rs = pst.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return count;
	}
}
