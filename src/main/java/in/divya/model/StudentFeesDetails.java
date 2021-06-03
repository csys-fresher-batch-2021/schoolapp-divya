/**
 * 
 */
package in.divya.model;

import java.time.LocalDate;

/**
 * @author divy2624
 *
 */
public class StudentFeesDetails {

	/**
	 * To Declare Fees Details
	 */
	private String studentRollNumber;
	private String month;
	private int studentFees;
	private LocalDate date;

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
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the studentFees
	 */
	public int getStudentFees() {
		return studentFees;
	}

	/**
	 * @param studentFees the studentFees to set
	 */
	public void setStudentFees(int studentFees) {
		this.studentFees = studentFees;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "StudentFeesDetails [studentRollNumber=" + studentRollNumber + ", month=" + month + ", studentFees="
				+ studentFees + ", date=" + date + "]";
	}

}
