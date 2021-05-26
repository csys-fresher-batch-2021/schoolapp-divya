/**
 * 
 */
package in.divya.service;

import java.sql.SQLException;

import java.util.Map;

import in.divya.dao.MarkCalculationDAO;
import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentMarksDetails;

/**
 * @author divy2624
 *
 */
public class MarkCalculationService {
	private MarkCalculationService() {
		/**
		 * Default constructor
		 */
	}

	/**
	 * To add the student marks.
	 * 
	 * @param mark
	 * @return
	 */

	public static int addMarks(StudentMarksDetails mark) {

		int tamil = mark.getTamilMark();
		int english = mark.getEnglishMark();
		int maths = mark.getMathamaticsMark();
		int science = mark.getScienceMark();
		int social = mark.getSocialMark();
		return tamil + english + maths + science + social;
	}

	/**
	 * Find average from total.
	 * 
	 * @param total
	 * @return
	 */

	public static float averageMarks(int total) {
		return ((float) total / 5);
	}

	/**
	 * Find grade from average
	 * 
	 * @param average
	 * @return
	 */

	public static String gradeRank(float average) {
		String grade = null;
		if (average > 90) {
			grade = "A";
		} else if (average <= 90 && average >= 70) {
			grade = "B";
		} else {
			grade = "C";
		}
		return grade;

	}

	/**
	 * Find comments from grade.
	 * 
	 * @param grade
	 * @return
	 */

	public static String gradeComment(String grade) {
		String result;
		if (grade.equals("A")) {
			result = "EXCELLENT";

		} else if (grade.equals("B")) {
			result = "GOOD";
		} else {
			result = "BAD";
		}

		return result;
	}

	/**
	 * To add all student mark details into map.
	 * 
	 * @param mark
	 * @return
	 * @throws InValidCredentialsException
	 */
	public static boolean addStudentMarks(StudentMarksDetails mark) throws InValidCredentialsException {
		boolean isAddedStudent = true;
		try {
			MarkCalculationDAO.addStudentMarks(mark);
			return isAddedStudent;
		} catch (Exception e) {
			throw new InValidCredentialsException("Cannot add marks");

		}

	}

	/**
	 * This Method displays the list that stores the student marks data
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public static Map<String, StudentMarksDetails> displayStudentMarks(String studentRollNumber)
			throws ClassNotFoundException, SQLException {

		return MarkCalculationDAO.getMarksData(studentRollNumber);

	}

}
