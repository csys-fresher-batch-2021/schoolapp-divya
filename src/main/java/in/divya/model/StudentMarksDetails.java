/**
 * 
 */
package in.divya.model;

/**
 * @author divy2624
 *
 */
public class StudentMarksDetails {
	private String studentRollNumber;
	private int testNumber;
	private int tamilMark;
	private int englishMark;
	private int mathamaticsMark;
	private int scienceMark;
	private int socialMark;
	private int totalMark;
	private float averageMark;
	private String grade;
	private String gradeComment;

	/**
	 * @return the studentRollNumber
	 */

	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	/**
	 * @param studentRollNumber the studentRollNumber to set
	 */

	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	/**
	 * @return the testNumber
	 */

	public int getTestNumber() {
		return testNumber;
	}

	/**
	 * @param testNumber the testNumber to set
	 */

	public void setTestNumber(int testNumber) {
		this.testNumber = testNumber;
	}

	/**
	 * @return the tamilMark
	 */

	public int getTamilMark() {
		return tamilMark;
	}

	/**
	 * @param tamilMark the tamilMark to set
	 */

	public void setTamilMark(int tamilMark) {
		this.tamilMark = tamilMark;
	}

	/**
	 * @return the englishMark
	 */

	public int getEnglishMark() {
		return englishMark;
	}

	/**
	 * @param englishMark the englishMark to set
	 */

	public void setEnglishMark(int englishMark) {
		this.englishMark = englishMark;
	}

	/**
	 * @return the mathamaticsMark
	 */

	public int getMathamaticsMark() {
		return mathamaticsMark;
	}

	/**
	 * @param mathamaticsMark the mathamaticsMark to set
	 */

	public void setMathamaticsMark(int mathamaticsMark) {
		this.mathamaticsMark = mathamaticsMark;
	}

	/**
	 * @return the scienceMark
	 */

	public int getScienceMark() {
		return scienceMark;
	}

	/**
	 * @param scienceMark the scienceMark to set
	 */

	public void setScienceMark(int scienceMark) {
		this.scienceMark = scienceMark;
	}

	/**
	 * @return the socialMark
	 */

	public int getSocialMark() {
		return socialMark;
	}

	/**
	 * @param socialMark the socialMark to set
	 */

	public void setSocialMark(int socialMark) {
		this.socialMark = socialMark;
	}

	/**
	 * @return the totalMark
	 */

	public int getTotalMark() {
		return totalMark;
	}

	/**
	 * @param totalMark the totalMark to set
	 */

	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}

	/**
	 * @return the averageMark
	 */

	public float getAverageMark() {
		return averageMark;
	}

	/**
	 * @param averageMark the averageMark to set
	 */

	public void setAverageMark(float averageMark) {
		this.averageMark = averageMark;
	}

	/**
	 * @return the grade
	 */

	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */

	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the gradeComment
	 */

	public String getGradeComment() {
		return gradeComment;
	}

	/**
	 * @param gradeComment the gradeComment to set
	 */

	public void setGradeComment(String gradeComment) {
		this.gradeComment = gradeComment;
	}

	@Override
	public String toString() {
		return "StudentMarksDetails [studentRollNumber=" + studentRollNumber + ", testNumber=" + testNumber
				+ ", tamilMark=" + tamilMark + ", englishMark=" + englishMark + ", mathamaticsMark=" + mathamaticsMark
				+ ", scienceMark=" + scienceMark + ", socialMark=" + socialMark + ", totalMark=" + totalMark
				+ ", averageMark=" + averageMark + ", grade=" + grade + ", gradeComment=" + gradeComment + "]";
	}

	public boolean equalsIgnoreCase(String studentRollNumber2) {
		// TODO Auto-generated method stub
		return false;
	}
}
