/**
 * 
 */
package in.divya.service;
import java.time.LocalDate;
import java.util.HashMap;

import in.divya.Validator.RegistrationValidation;
import in.divya.model.StudentDetails;
/**
 * 
 * @author divy2624
 *
 */

public class AddStudentDetails {
	/**
	 * Feature1: Registration-Add the student details to the HashMap
	 * To check it is successfully add or not.
	 */
	private static HashMap<String, StudentDetails> studentDetailsMap = new HashMap<String, StudentDetails>();

	static {
	StudentDetails student1 = new StudentDetails();
	student1.studentName="K.DIVYA";
	student1.fatherName="R.KUMAR";
	student1.motherName="K.RAJESWARI";
	student1.studentEmailId="divya@gmail.com";
	student1.studentPassword="Divya@76";
	student1.studentRollNo="AA22BB1111";
	student1.gender="FEMALE";
	student1.studentAddress="ANNA NAGAR";
	student1.studentCity="CHENNAI";
	student1.occupation="MASON";
	student1.studentBloodGroup="A-";
	student1.studentStandard="IX";
	student1.parentMobileNumber=9080605049l;
	student1.dateOfBirth=LocalDate.of(2000, 06, 07);
	student1.dateOfJoining=LocalDate.of(2005, 06, 05);
	studentDetailsMap.put(student1.studentRollNo, student1);
	
	StudentDetails student2 = new StudentDetails();
	student2.studentName="K.KAVI";
	student2.fatherName="K.KUMAR";
	student2.motherName="K.ESWARI";
	student2.studentEmailId="kavi@gmail.com";
	student2.studentPassword="Kavi@68";
	student2.studentRollNo="BB33CC2222";
	student2.gender="MALE";
	student2.studentAddress="VVV NAGAR";
	student2.studentCity="SIVAKASI";
	student2.occupation="BUSINESS";
	student2.studentBloodGroup="A+";
	student2.studentStandard="X";
	student2.parentMobileNumber=8080605049l;
	student2.dateOfBirth=LocalDate.of(2000, 02, 13);
	student2.dateOfJoining=LocalDate.of(2006, 07, 03);
	studentDetailsMap.put(student2.studentRollNo, student2);

	StudentDetails student3 = new StudentDetails();
	student3.studentName="S.RAJESWARI";
	student3.fatherName="S.SUBRAMANI";
	student3.motherName="S.PANDIMEENA";
	student3.studentEmailId="raji@gmail.com";
	student3.studentPassword="raji@65";
	student3.studentRollNo="DD55EE4444";
	student3.gender="FEMALE";
	student3.studentAddress="RAM NAGAR";
	student3.studentCity="MADURAI";
	student3.occupation="PROFESSOR";
	student3.studentBloodGroup="B+";
	student3.studentStandard="XI";
	student3.parentMobileNumber=9080765049l;
	student3.dateOfBirth=LocalDate.of(1999, 06, 07);
	student3.dateOfJoining=LocalDate.of(2004, 07, 01);
	studentDetailsMap.put(student3.studentRollNo, student3);
			
	}
	
	/**
	 * To check the student details is validate or not.
	 * @param student
	 * @return
	 */
	public static boolean addStudent(StudentDetails student) 
	{	
		boolean isAddedStudent = false;
		boolean isValidName=RegistrationValidation.isNameValidation(student.studentName);
		boolean isValidFatherName=RegistrationValidation.isNameValidation(student.fatherName);
		boolean isValidMotherName=RegistrationValidation.isNameValidation(student.motherName);
		boolean isValidEmailId=RegistrationValidation.isValidEmailId(student.studentEmailId);
		boolean isValidPassword=RegistrationValidation.isValidPasswordFormat(student.studentPassword);
		boolean isValidRollNumber=RegistrationValidation.isValidRollNumberFormat(student.studentRollNo);
		boolean isValidGender=RegistrationValidation.isNameValidation(student.gender);
		boolean isValidAddress=RegistrationValidation.isNameValidation(student.studentAddress);
		boolean isValidCity=RegistrationValidation.isNameValidation(student.studentCity);
		boolean isValidOccupation=RegistrationValidation.isNameValidation(student.occupation);
		boolean isValidBloodGroup=RegistrationValidation.bloodGroupValidation(student.studentBloodGroup);
		boolean isValidStudentStandard=RegistrationValidation.standardValidation(student.studentStandard);
		boolean isValidMobileNumber=RegistrationValidation.mobileNumberValidation(student.parentMobileNumber);
		boolean isValidDob=RegistrationValidation.isValidDate(student.dateOfBirth);
		boolean isValidJoiningDate=RegistrationValidation.isValidDate(student.dateOfJoining);
		
		
		if(isValidName && isValidFatherName && isValidMotherName && isValidEmailId && isValidPassword && isValidRollNumber && isValidGender && isValidAddress && isValidCity && isValidOccupation && isValidBloodGroup && isValidStudentStandard && isValidMobileNumber&& isValidDob && isValidJoiningDate) 

		
		{
				studentDetailsMap.put(student.studentRollNo,student);
				isAddedStudent = true;
				//System.out.println(StudentDetails.toString);
		}
		return isAddedStudent;
	}
	/**
	 * To check HashMap
	 * @return
	 */
	public static HashMap<String, StudentDetails> getStudentMap() {
		return studentDetailsMap;
	}

	
	}
	
	


