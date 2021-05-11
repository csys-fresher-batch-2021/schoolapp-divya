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

		public String studentName;
		public String fatherName;
		public String motherName;
		public String studentEmailId;
		public String studentPassword;
		public String studentRollNumber;
		public String gender;
		public String studentAddress;
		public String studentCity;
		public String occupation;
		public String studentBloodGroup;
		public String studentStandard;
		public Long parentMobileNumber;
		public LocalDate dateOfBirth;
		public LocalDate dateOfJoining;
		
	   @Override
		public String toString() {
			return "StudentDetails [STUDENT NAME=" + studentName + ", FATHER NAME=" +fatherName+ ", MOTHER NAME=" + motherName + ", STUDENT EMAIL-ID=" + studentEmailId
					+ ", STUDENT PASSWORD=" + studentPassword + ", GENDER=" + gender + ", ADDRESS=" + studentAddress + ", CITY="
					+ studentCity + ", OCCUPATION=" + occupation + ", BLOOD GROUP=" + studentBloodGroup + ", CLASS=" + studentStandard + ", PARENT MOBILE NUMBER="
					+ parentMobileNumber + ", DATE OF BIRTH=" + dateOfBirth + ", DATE OF JOINING=" + dateOfJoining+ "]";
		}
		
	}





