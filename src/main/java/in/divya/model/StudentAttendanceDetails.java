/**
 * 
 */
package in.divya.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author divy2624
 *
 */
public class StudentAttendanceDetails {
	/**
	 * To Declare Attendance Details
	 */
	private String studentRollNumber;
	private LocalDate date;
	private String studentAttendance;
	private LocalTime inTime;
	private LocalTime outTime;
	private String reason;

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

	/**
	 * @return the studentAttendance
	 */
	public String getStudentAttendance() {
		return studentAttendance;
	}

	/**
	 * @param studentAttendance the studentAttendance to set
	 */
	public void setStudentAttendance(String studentAttendance) {
		this.studentAttendance = studentAttendance;
	}

	/**
	 * @return the inTime
	 */
	public LocalTime getInTime() {
		return inTime;
	}

	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}

	/**
	 * @return the outTime
	 */
	public LocalTime getOutTime() {
		return outTime;
	}

	/**
	 * @param outTime the outTime to set
	 */
	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "StudentAttendanceDetails [studentRollNumber=" + studentRollNumber + ", date=" + date
				+ ", studentAttendance=" + studentAttendance + ", inTime=" + inTime + ", outTime=" + outTime
				+ ", reason=" + reason + "]";
	}

}
