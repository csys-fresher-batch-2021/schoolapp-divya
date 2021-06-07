/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	 * @throws ClassNotFoundException
	 */
	public void saveFees(StudentFeesDetails fees) throws InValidCredentialsException, ClassNotFoundException {
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
	 * @throws ClassNotFoundException
	 */
	public void updateFees(StudentFeesDetails fees) throws InValidCredentialsException, ClassNotFoundException {
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
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * To delete fees.
	 * 
	 * @param attendanceDate
	 * @throws InValidCredentialsException
	 * @throws ClassNotFoundException
	 */
	public void romoveFees(String month) throws InValidCredentialsException, ClassNotFoundException {

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

	/**
	 * To display student fees details.
	 * 
	 * @param rollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentFeesDetails> findStudentFees(String rollNumber) throws ClassNotFoundException {

		List<StudentFeesDetails> studentFeesData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from student_fees where student_roll_number=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, rollNumber);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentFeesDetails fees = new StudentFeesDetails();
				
				String studentRollNumber=rs.getString("student_roll_number");
				String feesMonth = rs.getString("month");
				int studentFees = rs.getInt("student_fees");
				LocalDate date = LocalDate.parse(rs.getString("receive_date"));

				/**
				 * Store the data in model
				 */
				fees.setStudentRollNumber(studentRollNumber);
				fees.setMonth(feesMonth);
				fees.setStudentFees(studentFees);
				fees.setDate(date);
				/**
				 * Store fees in list
				 */

				studentFeesData.add(fees);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentFeesData;
	}
	
	/**
	 * All fees details display.
	 * 
	 * @param rollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<StudentFeesDetails> findAllStudentFees() throws ClassNotFoundException {

		List<StudentFeesDetails> allFeesData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from student_fees";

			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentFeesDetails allFees = new StudentFeesDetails();
				
				String studentRollNumber=rs.getString("student_roll_number");
				String feesMonth = rs.getString("month");
				int studentFees = rs.getInt("student_fees");
				LocalDate date = LocalDate.parse(rs.getString("receive_date"));

				/**
				 * Store the data in model
				 */
				allFees.setStudentRollNumber(studentRollNumber);
				allFees.setMonth(feesMonth);
				allFees.setStudentFees(studentFees);
				allFees.setDate(date);
				/**
				 * Store fees in list
				 */

				allFeesData.add(allFees);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return allFeesData;
	}

}
