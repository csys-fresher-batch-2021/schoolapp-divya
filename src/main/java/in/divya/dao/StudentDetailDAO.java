/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class StudentDetailDAO {
	private StudentDetailDAO() {
		// Default Constructor
	}

	private static final String INSERT_STUDENT_DATA_QUERY = "insert into student_data(student_name,father_name,mother_name,student_email_id,student_password,student_roll_number,gender,address,city,parent_occupation,student_blood_group,student_standard,student_staff_name,parent_mobile_number,date_of_birth) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * This Method Registers a new student into a Database with their data.
	 * 
	 * @param student
	 * @throws InValidCredentialsException 
	 * @throws SQLException 
	 */

	public static void addStudent(StudentDetails student) throws InValidCredentialsException, SQLException{
		PreparedStatement pst = null;
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = INSERT_STUDENT_DATA_QUERY;

			pst = connection.prepareStatement(sql);

			pst.setString(1, student.getStudentName());
			pst.setString(2, student.getFatherName());
			pst.setString(3, student.getMotherName());
			pst.setString(4, student.getStudentEmailId());
			pst.setString(5, student.getStudentPassword());
			pst.setString(6, student.getStudentRollNumber());
			pst.setString(7, student.getGender());
			pst.setString(8, student.getStudentAddress());
			pst.setString(9, student.getStudentCity());
			pst.setString(10, student.getOccupation());
			pst.setString(11, student.getStudentBloodGroup());
			pst.setString(12, student.getStudentStandard());
			pst.setString(13, student.getStaffName());
			pst.setLong(14, student.getParentMobileNumber());
			pst.setObject(15, student.getDateOfBirth());

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

	/**
	 * This method returns a hashmap of student credentials required for the
	 * verification process
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InValidCredentialsException 
	 */

	public static List<String> studentCredentialData() throws SQLException, InValidCredentialsException {

		List<String> studentCredentials = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from student_data";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String studentName = rs.getString("student_name");
				String studentRollNumber = rs.getString("student_roll_number");
				String studentPassword = rs.getString("student_password");
				studentCredentials.add(studentName);
				studentCredentials.add(studentRollNumber);
				studentCredentials.add(studentPassword);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentCredentials;
	}

}
