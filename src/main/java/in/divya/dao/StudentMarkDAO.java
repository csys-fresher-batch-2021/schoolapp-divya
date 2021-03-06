/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentMarksDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class StudentMarkDAO {
	public StudentMarkDAO() {
		// Default Constructor
	}

	/**
	 * To insert student marks into the database.
	 * 
	 * @param mark
	 * @throws SQLException
	 * @throws InValidCredentialsException
	 * @throws ClassNotFoundException
	 */

	public void saveStudentMarks(StudentMarksDetails mark)
			throws SQLException, InValidCredentialsException, ClassNotFoundException {
		PreparedStatement pst = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into student_mark(student_roll_number,test_number,tamil_mark,english_mark,mathamatics_mark,science_mark,social_mark,total_mark,average_mark,grade_mark,grade_comment)values (?,?,?,?,?,?,?,?,?,?,?)";

			pst = connection.prepareStatement(sql);
			pst.setString(1, mark.getStudentRollNumber());
			pst.setInt(2, mark.getTestNumber());
			pst.setInt(3, mark.getTamilMark());
			pst.setInt(4, mark.getEnglishMark());
			pst.setInt(5, mark.getMathamaticsMark());
			pst.setInt(6, mark.getScienceMark());
			pst.setInt(7, mark.getSocialMark());
			pst.setInt(8, mark.getTotalMark());
			pst.setFloat(9, mark.getAverageMark());
			pst.setString(10, mark.getGrade());
			pst.setString(11, mark.getGradeComment());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InValidCredentialsException(
					"ALREADY EXISTS  (OR) ILLEGAL STUDENT MARK ENTRY(BECAUSE ITS ONLY ALLOW FOR REGISTERED STUDENTS))");

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
	 * To update student marks into the database.
	 * 
	 * @param mark
	 * @throws SQLException
	 * @throws InValidCredentialsException
	 * @throws ClassNotFoundException
	 */

	public void updateStudentMarks(StudentMarksDetails mark)
			throws SQLException, InValidCredentialsException, ClassNotFoundException {
		PreparedStatement pst = null;
		Connection connection = null;
		int rs = 0;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "update student_mark set test_number=?,tamil_mark=?,english_mark=?,mathamatics_mark=?,science_mark=?,social_mark=?,total_mark=?,average_mark=?,grade_mark=?,grade_comment=? where student_roll_number=?";

			pst = connection.prepareStatement(sql);

			pst.setInt(1, mark.getTestNumber());
			pst.setInt(2, mark.getTamilMark());
			pst.setInt(3, mark.getEnglishMark());
			pst.setInt(4, mark.getMathamaticsMark());
			pst.setInt(5, mark.getScienceMark());
			pst.setInt(6, mark.getSocialMark());
			pst.setInt(7, mark.getTotalMark());
			pst.setFloat(8, mark.getAverageMark());
			pst.setString(9, mark.getGrade());
			pst.setString(10, mark.getGradeComment());
			pst.setString(11, mark.getStudentRollNumber());

			rs = pst.executeUpdate();
			if (rs == 0) {
				throw new InValidCredentialsException(
						"CANNOT UPDATE (MARK RECORD NOT FOUND (OR) ILLEGAL STUDENT MARK ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
	 * To display student marks.
	 * 
	 * @param rollNumber
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public Map<String, StudentMarksDetails> findStudentMarks(String rollNumber)
			throws SQLException, ClassNotFoundException {

		Map<String, StudentMarksDetails> studentMarksData = new HashMap<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from student_mark where student_roll_number=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, rollNumber);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentMarksDetails markDB = new StudentMarksDetails();
				String studentRollNumber = rs.getString("student_roll_number");
				int testNumber = rs.getInt("test_number");
				int tamilMark = rs.getInt("tamil_mark");
				int englishMark = rs.getInt("english_mark");
				int mathamaticsMark = rs.getInt("mathamatics_mark");
				int scienceMark = rs.getInt("science_mark");
				int socialMark = rs.getInt("social_mark");
				int totalMark = rs.getInt("total_mark");
				float averageMark = rs.getFloat("average_mark");
				String grade = rs.getString("grade_mark");
				String gradeComment = rs.getString("grade_comment");

				/**
				 * Store the data in model
				 */

				markDB.setStudentRollNumber(studentRollNumber);
				markDB.setTestNumber(testNumber);
				markDB.setTamilMark(tamilMark);
				markDB.setEnglishMark(englishMark);
				markDB.setMathamaticsMark(mathamaticsMark);
				markDB.setScienceMark(scienceMark);
				markDB.setSocialMark(socialMark);
				markDB.setTotalMark(totalMark);
				markDB.setAverageMark(averageMark);
				markDB.setGrade(grade);
				markDB.setGradeComment(gradeComment);

				/**
				 * Store marks in map
				 */

				studentMarksData.put(markDB.getStudentRollNumber(), markDB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentMarksData;
	}

	/**
	 * Delete student marks in database table.
	 * 
	 * @param testNo
	 * @return
	 * @throws InValidCredentialsException
	 * @throws ClassNotFoundException
	 */
	public void deleteTestMarkFromTable(int testNo) throws InValidCredentialsException, ClassNotFoundException {

		Connection connection = null;
		PreparedStatement pst = null;
		int rs = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String str = "delete from student_mark where test_number=?";
			pst = connection.prepareStatement(str);
			pst.setInt(1, testNo);
			rs = pst.executeUpdate();
			if (rs == 0) {
				throw new InValidCredentialsException("TEST MARKS NOT EXISTS");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	/**
	 * To diaplay all student marks.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<StudentMarksDetails> findAllStudentMarks() throws SQLException, ClassNotFoundException {

		List<StudentMarksDetails> allStudentMarksToDisplay = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();

			String str = "select * from student_mark order by student_roll_number asc";
			pst = connection.prepareStatement(str);
			rs = pst.executeQuery();

			while (rs.next()) {
				StudentMarksDetails allMark = new StudentMarksDetails();

				String studentRollNumber = rs.getString("student_roll_number");
				int testNumber = rs.getInt("test_number");
				int tamilMark = rs.getInt("tamil_mark");
				int englishMark = rs.getInt("english_mark");
				int mathamaticsMark = rs.getInt("mathamatics_mark");
				int scienceMark = rs.getInt("science_mark");
				int socialMark = rs.getInt("social_mark");
				int totalMark = rs.getInt("total_mark");
				float averageMark = rs.getFloat("average_mark");
				String grade = rs.getString("grade_mark");
				String gradeComment = rs.getString("grade_comment");
				/**
				 * Store the data in model
				 */

				allMark.setStudentRollNumber(studentRollNumber);
				allMark.setTestNumber(testNumber);
				allMark.setTamilMark(tamilMark);
				allMark.setEnglishMark(englishMark);
				allMark.setMathamaticsMark(mathamaticsMark);
				allMark.setScienceMark(scienceMark);
				allMark.setSocialMark(socialMark);
				allMark.setTotalMark(totalMark);
				allMark.setAverageMark(averageMark);
				allMark.setGrade(grade);
				allMark.setGradeComment(gradeComment);

				/**
				 * Store marks in list.
				 */

				allStudentMarksToDisplay.add(allMark);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return allStudentMarksToDisplay;
	}

}
