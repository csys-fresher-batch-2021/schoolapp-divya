/**
 * 
 */
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
		private Long parentMobileNumber;
		private LocalDate dateOfBirth;
		private LocalDate dateOfJoining;
		
	   public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getFatherName() {
			return fatherName;
		}

		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}

		public String getMotherName() {
			return motherName;
		}

		public void setMotherName(String motherName) {
			this.motherName = motherName;
		}

		public String getStudentEmailId() {
			return studentEmailId;
		}

		public void setStudentEmailId(String studentEmailId) {
			this.studentEmailId = studentEmailId;
		}

		public String getStudentPassword() {
			return studentPassword;
		}

		public void setStudentPassword(String studentPassword) {
			this.studentPassword = studentPassword;
		}

		public String getStudentRollNumber() {
			return studentRollNumber;
		}

		public void setStudentRollNumber(String studentRollNumber) {
			this.studentRollNumber = studentRollNumber;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getStudentAddress() {
			return studentAddress;
		}

		public void setStudentAddress(String studentAddress) {
			this.studentAddress = studentAddress;
		}

		public String getStudentCity() {
			return studentCity;
		}

		public void setStudentCity(String studentCity) {
			this.studentCity = studentCity;
		}

		public String getOccupation() {
			return occupation;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}

		public String getStudentBloodGroup() {
			return studentBloodGroup;
		}

		public void setStudentBloodGroup(String studentBloodGroup) {
			this.studentBloodGroup = studentBloodGroup;
		}

		public String getStudentStandard() {
			return studentStandard;
		}

		public void setStudentStandard(String studentStandard) {
			this.studentStandard = studentStandard;
		}

		public Long getParentMobileNumber() {
			return parentMobileNumber;
		}

		public void setParentMobileNumber(Long parentMobileNumber) {
			this.parentMobileNumber = parentMobileNumber;
		}

		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public LocalDate getDateOfJoining() {
			return dateOfJoining;
		}

		public void setDateOfJoining(LocalDate dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}

	@Override
		public String toString() {
			return "StudentDetails [STUDENT NAME=" + studentName + ", FATHER NAME=" +fatherName+ ", MOTHER NAME=" + motherName + ", STUDENT EMAIL-ID=" + studentEmailId
					+ ", STUDENT PASSWORD=" + studentPassword + ", GENDER=" + gender + ", ADDRESS=" + studentAddress + ", CITY="
					+ studentCity + ", OCCUPATION=" + occupation + ", BLOOD GROUP=" + studentBloodGroup + ", CLASS=" + studentStandard + ", PARENT MOBILE NUMBER="
					+ parentMobileNumber + ", DATE OF BIRTH=" + dateOfBirth + ", DATE OF JOINING=" + dateOfJoining+ "]";
		}
		
	}





