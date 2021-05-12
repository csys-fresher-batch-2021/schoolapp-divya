package in.divya.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import java.util.Map;

import org.junit.Test;

import in.divya.model.StudentDetails; 
/**
 * 
 * @author divy2624
 *
 */

public class AddStudentDetailsTest
{
	/**
	 * To check the student1 details is add to HashMap or Not
	 * return True
	 */
	@Test
	public void studentInputDetails() 
	{
		StudentDetails student1 = new StudentDetails();
		student1.setStudentName("K.DIVYA");
		student1.setFatherName("R.KUMAR");
		student1.setMotherName("K.RAJESWARI");
		student1.setStudentEmailId("divya@gmail.com");;
		student1.setStudentPassword("Divya@76");;
		student1.setStudentRollNumber("AA22BB1111");;
		student1.setGender("FEMALE");;
		student1.setStudentAddress("ANNA NAGAR");;
		student1.setStudentCity("CHENNAI");;
		student1.setOccupation("MASON");;
		student1.setStudentBloodGroup("A-");
		student1.setStudentStandard("IX");
		student1.setParentMobileNumber(Long.parseLong("8979697865"));
		student1.setDateOfBirth(LocalDate.of(2000, 06, 07));
		student1.setDateOfJoining(LocalDate.of(2005, 06, 05));    
		boolean isAddedStudent1 = AddStudentDetails.addStudent(student1);
		assertTrue(isAddedStudent1);
	
	}
	/**
	 * To check the student2 details is add to HashMap or Not.
	 * return True
	 */
	@Test
	public void studentInputDetails2() 
	{
		StudentDetails student2 = new StudentDetails();
		student2.setStudentName("K.KAVI");
		student2.setFatherName("R.KUMAR");
		student2.setMotherName("K.ESWARI");
		student2.setStudentEmailId("kavi@gmail.com");
		student2.setStudentPassword("Brathi@70");
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
		boolean isAddedStudent2= AddStudentDetails.addStudent(student2);
		assertTrue(isAddedStudent2);
		
	}
	/**
	 * To check the student3 details is add to HashMap or Not.
	 * return False
	 */
	@Test
	public void studentInputDetails3() 
	{
		StudentDetails student3 = new StudentDetails();
		student3.setStudentName("");
		student3.setFatherName("S.SUBRAMANI");
		student3.setMotherName("S.PANDIMEENA");
		student3.setStudentEmailId("raji@gmail.com");
		student3.setStudentPassword("Raji@65");
		student3.setStudentRollNumber("DD55@");
		student3.setGender("");
		student3.setStudentAddress("T NAGAR");
		student3.setStudentCity("CHENNAI");
		student3.setOccupation("PROFEESOR");
		student3.setStudentBloodGroup("B+");
		student3.setStudentStandard("XIXXXXXXX");
		student3.setParentMobileNumber(Long.parseLong("9080765049"));
		student3.setDateOfBirth(LocalDate.of(2000, 06, 06));
		student3.setDateOfJoining(LocalDate.of(2003, 06, 05));   
		boolean isAddedStudent3= AddStudentDetails.addStudent(student3);
		assertFalse(isAddedStudent3);
		
		Map<String, StudentDetails> getStudentMap = AddStudentDetails.getStudentMap();
		System.out.println(getStudentMap);
	
	}
	
	

	

}
