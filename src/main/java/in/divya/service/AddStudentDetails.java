/**
 * 
 */
package in.divya.service;
import java.time.LocalDate;
import java.util.HashMap;

import in.divya.validator.RegistrationValidation;
import in.divya.model.StudentDetails;
/**
 * 
 * @author divy2624
 *
 */

public class AddStudentDetails {
	private AddStudentDetails() {
		//Default constructor
	}
	/**
	 * Feature1: Registration-Add the student details to the HashMap
	 * To check it is successfully add or not.
	 */
	private static HashMap<String, StudentDetails> studentDetailsMap = new HashMap<>();

	static {
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
	student1.setDateOfBirth(LocalDate.of(2000, 06, 07));
	student1.setDateOfJoining(LocalDate.of(2005, 06, 05));      
	studentDetailsMap.put(student1.getStudentRollNumber(), student1);
	
	StudentDetails student2 = new StudentDetails();
	student2.setStudentName("K.KAVI");
	student2.setFatherName("R.KUMAR");
	student2.setMotherName("K.ESWARI");
	student2.setStudentEmailId("kavi@gmail.com");
	student2.setStudentPassword("Kavi@76");
	student2.setStudentRollNumber("BB33CC2222");
	student2.setGender("MALE");
	student2.setStudentAddress("VVV NAGAR");
	student2.setStudentCity("MADURAI");
	student2.setOccupation("BUSINESS");
	student2.setStudentBloodGroup("A+");
	student2.setStudentStandard("X");
	student2.setParentMobileNumber(Long.parseLong("8976765890"));
	student2.setDateOfBirth(LocalDate.of(2000, 06, 13));
	student2.setDateOfJoining(LocalDate.of(2006, 06, 05));      
	studentDetailsMap.put(student2.getStudentRollNumber(), student2);

	StudentDetails student3 = new StudentDetails();
	student3.setStudentName("S.RAJESWARI");
	student3.setFatherName("S.SUBRAMANI");
	student3.setMotherName("S.PANDIMEENA");
	student3.setStudentEmailId("raji@gmail.com");
	student3.setStudentPassword("Raji@65");
	student3.setStudentRollNumber("DD55EE4444");
	student3.setGender("FEMALE");
	student3.setStudentAddress("T NAGAR");
	student3.setStudentCity("CHENNAI");
	student3.setOccupation("PROFEESOR");
	student3.setStudentBloodGroup("B+");
	student3.setStudentStandard("XI");
	student3.setParentMobileNumber(Long.parseLong("9080765049"));
	student3.setDateOfBirth(LocalDate.of(2000, 06, 06));
	student3.setDateOfJoining(LocalDate.of(2003, 06, 05));      
	studentDetailsMap.put(student3.getStudentRollNumber(), student3);

			
	}
	
	/**
	 * To check the student details is validate or not.
	 * @param student
	 * @return
	 */
	public static boolean addStudent(StudentDetails student) 
	{	
		boolean isAddedStudent = false;
		boolean isValidName=RegistrationValidation.isNameValidation(student.getStudentName());
		boolean isValidFatherName=RegistrationValidation.isNameValidation(student.getFatherName());
		boolean isValidMotherName=RegistrationValidation.isNameValidation(student.getMotherName());
		boolean isValidEmailId=RegistrationValidation.isValidEmailId(student.getStudentEmailId());
		boolean isValidPassword=RegistrationValidation.isValidPasswordFormat(student.getStudentPassword());
		boolean isValidRollNumber=RegistrationValidation.isValidRollNumberFormat(student.getStudentRollNumber());
		boolean isValidGender=RegistrationValidation.isNameValidation(student.getGender());
		boolean isValidAddress=RegistrationValidation.isNameValidation(student.getStudentAddress());
		boolean isValidCity=RegistrationValidation.isNameValidation(student.getStudentCity());
		boolean isValidOccupation=RegistrationValidation.isNameValidation(student.getOccupation());
		boolean isValidBloodGroup=RegistrationValidation.bloodGroupValidation(student.getStudentBloodGroup());
		boolean isValidStudentStandard=RegistrationValidation.standardValidation(student.getStudentStandard());
		boolean isValidMobileNumber=RegistrationValidation.mobileNumberValidation(student.getParentMobileNumber());
		boolean isValidDob=RegistrationValidation.isValidDate(student.getDateOfBirth());
		boolean isValidJoiningDate=RegistrationValidation.isValidDate(student.getDateOfJoining());
		
		
		if(isValidName && isValidFatherName && isValidMotherName && isValidEmailId && isValidPassword && isValidRollNumber && isValidGender && isValidAddress && isValidCity && isValidOccupation && isValidBloodGroup && isValidStudentStandard && isValidMobileNumber&& isValidDob && isValidJoiningDate) 
		{
				studentDetailsMap.put(student.getStudentRollNumber(),student);
				isAddedStudent = true;
		}
		return isAddedStudent;
	}
	
	
	}
	
	


