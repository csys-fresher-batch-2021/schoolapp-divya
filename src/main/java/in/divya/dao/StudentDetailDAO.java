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

	public static void addStudent(StudentDetails student) throws InValidCredentialsException, SQLException {
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

	public static List<StudentDetails> displayAllStudentInformation(String staffName)
			throws InValidCredentialsException {

		List<StudentDetails> allStudentInformationDisplay = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "select * from student_data where student_staff_name=?";
			pst = connection.prepareStatement(str);
			pst.setString(1, staffName);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentDetails studentInfo = new StudentDetails();

				String studentName = rs.getString("student_name");
				String fatherName = rs.getString("father_name");
				String motherName = rs.getString("mother_name");
				String studentEmailID = rs.getString("student_email_id");
				String studentPassword = rs.getString("student_password");
				String studentRollNumber = rs.getString("student_roll_number");
				String gender = rs.getString("gender");
				String studentAddress = rs.getString("address");
				String studentCity = rs.getString("city");
				String occupation = rs.getString("parent_occupation");
				String studentBloodGroup = rs.getString("student_blood_group");
				String studentStandard = rs.getString("student_standard");
				String staffname = rs.getString("student_staff_name");
				Long parentMobileNumber = Long.parseLong(rs.getString("parent_mobile_number"));
				LocalDate DateOfBirth = LocalDate.parse(rs.getString("date_of_birth"));

				/**
				 * Store the data in model
				 */

				studentInfo.setStudentName(studentName);
				studentInfo.setFatherName(fatherName);
				studentInfo.setMotherName(motherName);
				studentInfo.setStudentEmailId(studentEmailID);
				studentInfo.setStudentPassword(studentPassword);
				studentInfo.setStudentRollNumber(studentRollNumber);
				studentInfo.setGender(gender);
				studentInfo.setStudentAddress(studentAddress);
				studentInfo.setStudentCity(studentCity);
				studentInfo.setOccupation(occupation);
				studentInfo.setStudentBloodGroup(studentBloodGroup);
				studentInfo.setStudentStandard(studentStandard);
				studentInfo.setStaffName(staffname);
				studentInfo.setParentMobileNumber(parentMobileNumber);
				studentInfo.setDateOfBirth(DateOfBirth);

				/**
				 * StoreInformation in list.
				 */

				allStudentInformationDisplay.add(studentInfo);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return allStudentInformationDisplay;
	}

	/**
	 * To delte student details from the database.
	 */
	public static boolean deleteStudentFromTable(String studentRollNumber) throws InValidCredentialsException {
		Connection connection = null;
		PreparedStatement pst = null;

		boolean isDeleted = false;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "delete from student_data where student_roll_number=?";
			pst = connection.prepareStatement(str);
			pst.setString(1, studentRollNumber);
			pst.executeUpdate();
			isDeleted = true;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return isDeleted;
	}

}
