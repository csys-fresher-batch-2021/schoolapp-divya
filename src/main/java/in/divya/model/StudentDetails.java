package in.divya.model;

import java.time.LocalDate;

/**
 * @author divy2624
 *
 */

public class StudentDetails {

	/**
	 * To declare the studentDetails.
	 */

	private String studentName;
	private String fatherName;
	private String motherName;
	private String studentEmailId;
	private String studentPassword;
	private String studentRollNumber;
	private String gender;
	private String studentAddress;
	private String studentCity;
	private String occupation;
	private String studentBloodGroup;
	private String studentStandard;
	private String staffName;
	private Long parentMobileNumber;
	private LocalDate dateOfBirth;

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the fatherName
	 */

	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @param fatherName the fatherName to set
	 */

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * @return the motherName
	 */

	public String getMotherName() {
		return motherName;
	}

	/**
	 * @param motherName the motherName to set
	 */
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	/**
	 * @return the studentEmailId
	 */

	public String getStudentEmailId() {
		return studentEmailId;
	}

	/**
	 * @param studentEmailId the studentEmailId to set
	 */

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	/**
	 * @return the studentPassword
	 */

	public String getStudentPassword() {
		return studentPassword;
	}

	/**
	 * @param studentPassword the studentPassword to set
	 */

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

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
	 * @return the gender
	 */

	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the studentAddress
	 */
	public String getStudentAddress() {
		return studentAddress;
	}

	/**
	 * @param studentAddress the studentAddress to set
	 */

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	/**
	 * @return the studentCity
	 */

	public String getStudentCity() {
		return studentCity;
	}

	/**
	 * @param studentCity the studentCity to set
	 */
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the studentBloodGroup
	 */

	public String getStudentBloodGroup() {
		return studentBloodGroup;
	}

	/**
	 * @param studentBloodGroup the studentBloodGroup to set
	 */

	public void setStudentBloodGroup(String studentBloodGroup) {
		this.studentBloodGroup = studentBloodGroup;
	}

	/**
	 * @return the studentStandard
	 */

	public String getStudentStandard() {
		return studentStandard;
	}

	/**
	 * @param studentStandard the studentStandard to set
	 */

	public void setStudentStandard(String studentStandard) {
		this.studentStandard = studentStandard;
	}

	/**
	 * @return the staffName
	 */

	public String getStaffName() {
		return staffName;
	}

	/**
	 * @param staffName the staffName to set
	 */

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * @return the parentMobileNumber
	 */

	public Long getParentMobileNumber() {
		return parentMobileNumber;
	}

	/**
	 * @param studentValidMobileNumber the parentMobileNumber to set
	 */

	public void setParentMobileNumber(Long studentValidMobileNumber) {
		this.parentMobileNumber = studentValidMobileNumber;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param studentParsedDate the dateOfBirth to set
	 */

	public void setDateOfBirth(LocalDate studentParsedDate) {
		this.dateOfBirth = studentParsedDate;
	}

}
