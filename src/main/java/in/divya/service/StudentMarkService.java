/**
 * 
 */
package in.divya.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import in.divya.dao.StudentMarkDAO;
import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.StudentMarksDetails;

/**
 * @author divy2624
 *
 */
public class StudentMarkService {
	public StudentMarkService() {
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

	public int addMarks(StudentMarksDetails mark) {

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

	public float averageMarks(int total) {
		return ((float) total / 5);
	}

	/**
	 * Find grade from average
	 * 
	 * @param average
	 * @return
	 */

	public String gradeRank(float average) {
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

	public String gradeComment(String grade) {
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
	 * To add student mark details(only for registered students) into db.
	 * 
	 * @param mark
	 * @return
	 * @throws InValidCredentialsException
	 */
	public boolean addStudentMarks(StudentMarksDetails mark) throws InValidCredentialsException {
		StudentMarkDAO studentMarkDAO = new StudentMarkDAO();
		boolean isAddedStudent = true;
		try {
			studentMarkDAO.saveStudentMarks(mark);
			return isAddedStudent;
		} catch (Exception e) {
			throw new InValidCredentialsException(
					"ALREADY EXISTS  (OR) ILLEGAL STUDENT MARK ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");

		}

	}

	/**
	 * To update student mark details into db.
	 * 
	 * @param mark
	 * @return
	 * @throws InValidCredentialsException
	 */
	public boolean updateStudentMarks(StudentMarksDetails mark) throws InValidCredentialsException {
		StudentMarkDAO studentMarkDAO = new StudentMarkDAO();
		boolean isUpdatedStudent = true;
		try {
			studentMarkDAO.updateStudentMarks(mark);
			return isUpdatedStudent;
		} catch (Exception e) {
			throw new InValidCredentialsException(
					"CANNOT UPDATE (MARK RECORD NOT FOUND (OR) ILLEGAL STUDENT MARK ENTRY(BECAUSE ITS ONLY FOR REGISTERED STUDENTS))");

		}

	}

	/**
	 * This Method displays the list that stores the student marks data
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public Map<String, StudentMarksDetails> displayStudentMarks(String studentRollNumber)
			throws SQLException, ClassNotFoundException {
		StudentMarkDAO studentMarkDAO = new StudentMarkDAO();
		return studentMarkDAO.findStudentMarks(studentRollNumber);

	}

	/**
	 * Delete Test
	 * 
	 * @param testNo
	 * @return
	 * @throws InValidCredentialsException
	 */
	public boolean deleteStudentMarks(int testNo) throws InValidCredentialsException {
		StudentMarkDAO studentMarkDAO = new StudentMarkDAO();
		boolean isDeleteTest = true;
		try {
			studentMarkDAO.deleteTestMarkFromTable(testNo);
			return isDeleteTest;
		} catch (Exception e) {
			throw new InValidCredentialsException("TEST MARKS NOT EXISTS");
		}
	}

	/**
	 * To display all student marks.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public List<StudentMarksDetails> displayAllStudentMarks() throws SQLException, ClassNotFoundException {
		StudentMarkDAO studentMarkDAO = new StudentMarkDAO();
		return studentMarkDAO.findAllStudentMarks();

	}
}
