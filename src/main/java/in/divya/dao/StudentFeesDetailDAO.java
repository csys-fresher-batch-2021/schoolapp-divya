/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentFeesDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class StudentFeesDetailDAO {

	public StudentFeesDetailDAO() {
		// Default Constructor
	}

	/**
	 * To add student fees details.
	 * 
	 * @param fees
	 * @throws InValidCredentialsException
	 */
	public void saveFees(StudentFeesDetails fees) throws InValidCredentialsException {
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into student_fees(student_roll_number,month,student_fees,receive_date)values(?,?,?,?)";

			pst = connection.prepareStatement(sql);

			pst.setString(1, fees.getStudentRollNumber());
			pst.setString(2, fees.getMonth());
			pst.setInt(3, fees.getStudentFees());
			pst.setObject(4, fees.getDate());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new InValidCredentialsException(
					"ALREADY EXISTS  (OR) ILLEGAL STUDENT FEES ENTRY(BECAUSE ITS ONLY ALLOW FOR REGISTERED STUDENTS)");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * To update student fees details
	 * 
	 * @param fees
	 * @throws InValidCredentialsException
	 */
	public void updateFees(StudentFeesDetails fees) throws InValidCredentialsException {
		PreparedStatement pst = null;
		Connection connection = null;
		int rs = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update student_fees set student_fees=?,receive_date=? where student_roll_number=? and month=?";

			pst = connection.prepareStatement(sql);

			pst.setInt(1, fees.getStudentFees());
			pst.setObject(2, fees.getDate());
			pst.setString(3, fees.getStudentRollNumber());
			pst.setString(4, fees.getMonth());

			rs = pst.executeUpdate();
			if (rs == 0) {
				throw new InValidCredentialsException(
						"CANNOT UPDATE (FEES RECORD NOT FOUND (OR) ILLEGAL STUDENT FEES ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");
			}

		} catch (SQLException e) {
			e.getMessage();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * To delete fees.
	 * 
	 * @param attendanceDate
	 * @throws InValidCredentialsException
	 */
	public void romoveFees(String month) throws InValidCredentialsException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String str = "delete from student_fees where month=?";
			pst = connection.prepareStatement(str);
			pst.setObject(1, month);
			rs = pst.executeUpdate();
			if (rs == 0) {
				throw new InValidCredentialsException("FEES NOT FOUND");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

}
