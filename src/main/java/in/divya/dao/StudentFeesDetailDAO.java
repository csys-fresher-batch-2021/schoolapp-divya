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

}
