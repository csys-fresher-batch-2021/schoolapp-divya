/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentAttendanceDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class StudentAttendanceDetailDAO {
	private StudentAttendanceDetailDAO() {
		// Default Constructor
	}

	/**
	 * To Save the student attendance details in database.
	 * 
	 * @param attendance
	 * @throws SQLException
	 * @throws InValidCredentialsException
	 */
	public static void saveAttendance(StudentAttendanceDetails attendance)
			throws SQLException, InValidCredentialsException {
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
			e.getMessage();
		} finally {
			if (pst != null) {
				pst.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}
}
