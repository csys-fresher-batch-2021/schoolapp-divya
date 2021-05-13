package in.divya.service;

import java.util.HashMap;
import java.util.Map;

import in.divya.validator.RegistrationValidation;
import in.divya.model.StudentDetails;
import in.divya.util.Validation;

/**
 * 
 * @author divy2624
 *
 */

public class StudentDetailService 
{
	private StudentDetailService()
	{
		/**
		 * Default constructor
		 */
	}
	
	/**
	 * Feature1: Registration-Add the student details to the HashMap
	 * To check it is successfully add or not.
	 */
	
	private static final HashMap<String, StudentDetails> studentDetailsMap = new HashMap<>();

	
	
	/**
	 * To check the student details is validate or not.
	 * @param student
	 * @return
	 */
	
	public static boolean addStudent(StudentDetails student) 
	{	
		boolean isAddedStudent = false;
		boolean isValidName=Validation.isValidString(student.getStudentName());
		boolean isValidFatherName=Validation.isValidString(student.getFatherName());
		boolean isValidMotherName=Validation.isValidString(student.getMotherName());
		boolean isValidEmailId=Validation.isValidEmailId(student.getStudentEmailId());
		boolean isValidPassword=Validation.isValidPasswordFormat(student.getStudentPassword());
		boolean isValidRollNumber=RegistrationValidation.isValidRollNumberFormat(student.getStudentRollNumber());
		boolean isValidGender=Validation.isValidString(student.getGender());
		boolean isValidAddress=Validation.isValidString(student.getStudentAddress());
		boolean isValidCity=Validation.isValidString(student.getStudentCity());
		boolean isValidOccupation=Validation.isValidString(student.getOccupation());
		boolean isValidBloodGroup=Validation.bloodGroupValidation(student.getStudentBloodGroup());
		boolean isValidStudentStandard=RegistrationValidation.standardValidation(student.getStudentStandard());
		boolean isValidMobileNumber=Validation.mobileNumberValidation(student.getParentMobileNumber());
		boolean isValidDob=Validation.isValidDate(student.getDateOfBirth());
		boolean isValidJoiningDate=Validation.isValidDate(student.getDateOfJoining());
		
		
		if(isValidName && isValidFatherName && isValidMotherName && isValidEmailId && isValidPassword && isValidRollNumber && isValidGender && isValidAddress && isValidCity && isValidOccupation && isValidBloodGroup && isValidStudentStandard && isValidMobileNumber&& isValidDob && isValidJoiningDate) 
		{
				studentDetailsMap.put(student.getStudentRollNumber(),student);
				isAddedStudent = true;
		}
		return isAddedStudent;
	}
	 
	
	/**
	 * This method is used for validate login page
	 * @param studentName
	 * @param studentRollNumber
	 * @param studentPassword
	 * @return
	 */

	
	public static boolean studentValidation(String studentName,String studentRollNumber, String studentPassword) {
		boolean isValidStudent = false;
		boolean isValidName = Validation.isValidString(studentName);
		boolean isValidRollNumberFormat = RegistrationValidation.isValidRollNumberFormat(studentRollNumber);
		boolean isValidPasswordFormat = Validation.isValidPasswordFormat(studentPassword);
		StudentDetails student=studentDetailsMap.get(studentRollNumber);
		if (isValidName && isValidRollNumberFormat && isValidPasswordFormat && studentDetailsMap.containsKey(studentRollNumber) && ((student.getStudentName()).equals(studentName))&&((student.getStudentRollNumber()).equals(studentRollNumber)) && (student.getStudentPassword().equals(studentPassword)) ) 
		{
				isValidStudent = true;
			
		}
		return isValidStudent;

	}

	public static Map<String, StudentDetails> getStudentMap() 
	{
		return studentDetailsMap;
		
	}

}
	
	


