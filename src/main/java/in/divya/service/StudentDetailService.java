package in.divya.service;

import java.time.LocalDate;
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

	
	static 
	{
	StudentDetails student1 = new StudentDetails();
	student1.setStudentName("K.DIVYA");
	student1.setFatherName("R.KUMAR");
	student1.setMotherName("K.RAJESWARI");
	student1.setStudentEmailId("divya@gmail.com");
	student1.setStudentPassword("Divya@76");
	student1.setStudentRollNumber("AA22BB1111");
	student1.setGender("FEMALE");
	student1.setStudentAddress("ANNA NAGAR");
	student1.setStudentCity("CHENNAI");
	student1.setOccupation("MASON");
	student1.setStudentBloodGroup("A-");
	student1.setStudentStandard("IX");
	student1.setParentMobileNumber(Long.parseLong("8979697865"));
	student1.setDateOfBirth(LocalDate.of(2004, 06, 07));
	student1.setDateOfJoining(LocalDate.of(2009, 07, 06));      
	studentDetailsMap.put(student1.getStudentRollNumber(), student1);
	
	StudentDetails student2 = new StudentDetails();
	student2.setStudentName("K.KAVI");
	student2.setFatherName("R.KUMAR");
	student2.setMotherName("K.ESWARI");
	student2.setStudentEmailId("kavi@gmail.com");
	student2.setStudentPassword("Bharathi@76");
	student2.setStudentRollNumber("BB33CC2222");
	student2.setGender("MALE");
	student2.setStudentAddress("VVV NAGAR");
	student2.setStudentCity("MADURAI");
	student2.setOccupation("BUSINESS");
	student2.setStudentBloodGroup("A+");
	student2.setStudentStandard("X1");
	student2.setParentMobileNumber(Long.parseLong("8976765890"));
	student2.setDateOfBirth(LocalDate.of(2004, 02, 13));
	student2.setDateOfJoining(LocalDate.of(2009, 07, 06));      
	studentDetailsMap.put(student2.getStudentRollNumber(), student2);
	
	}
	
	
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

	
	public static boolean studentValidation(String studentName,String studentRollNumber, String studentPassword) 
	{
		boolean isValidStudent = false;
		boolean isValidName = Validation.isValidString(studentName);
		boolean isValidRollNumberFormat = RegistrationValidation.isValidRollNumberFormat(studentRollNumber);
		boolean isValidPasswordFormat = Validation.isValidPasswordFormat(studentPassword);
		StudentDetails student=studentDetailsMap.get(studentRollNumber);
		
		/**
		 * To validate name,rollnumber,password.
		 * If it is true......Login sucessfully.
		 * otherwise it is failed
		 */
		
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
	
	


