/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.divya.model.StudentMarksDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class MarkCalculationDAO {
	/**
	 * To insert student marks into the database.
	 * 
	 * @param mark
	 * @throws SQLException
	 */

	public static void addStudentMarks(StudentMarksDetails mark) throws SQLException {
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
	 * To display student marks.
	 * 
	 * @param rollNumber
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Map<String, StudentMarksDetails> getMarksData(String rollNumber)
			throws ClassNotFoundException, SQLException {

		Map<String, StudentMarksDetails> studentMarksData = new HashMap<>();
		StudentMarksDetails markDB = new StudentMarksDetails();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();
			System.out.println(rollNumber);

			String sql = "select * from student_mark where student_roll_number=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, rollNumber);
			rs = pst.executeQuery();
			System.out.println("bds");

			while (rs.next()) {
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
				 * Store all products in list
				 */

				studentMarksData.put(markDB.getStudentRollNumber(), markDB);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentMarksData;
	}

}
