package in.divya.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.Test;

import in.divya.model.StudentDetails; 


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
		student2.studentName="K.KAVI";
		student2.fatherName="K.KUMAR";
		student2.motherName="K.ESWARI";
		student2.studentEmailId="kavi@gmail.com";
		student2.studentPassword="Kavibh@76";
		student2.studentRollNo="BB33CC2222";
		student2.gender="MALE";
		student2.studentAddress="VVV NAGAR";
		student2.studentCity="SIVAKASI";
		student2.occupation="BUSINESS";
		student2.studentBloodGroup="A+";
		student2.studentStandard="X";
		student2.parentMobileNumber=8080605049l;
		student2.dateOfBirth=LocalDate.of(2000, 02, 13);
		student2.dateOfJoining=LocalDate.of(2006, 07, 10);
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
		student3.studentName="";
		student3.fatherName="";
		student3.motherName="";
		student3.studentEmailId="ghiju@gmail.company";
		student3.studentPassword="@76";
		student3.studentRollNo="BBBBBBBB";
		student3.gender="";
		student3.studentAddress="";
		student3.studentCity="";
		student3.occupation="";
		student3.studentBloodGroup="+B";
		student3.studentStandard="9";
		student3.parentMobileNumber=808049l;
		student3.dateOfBirth=LocalDate.of(2023, 02, 13);
		student3.dateOfJoining=LocalDate.of(2022, 07, 10);
		boolean isAddedStudent3= AddStudentDetails.addStudent(student3);
		assertFalse(isAddedStudent3);
		
		HashMap<String, StudentDetails> getStudentMap = AddStudentDetails.getStudentMap();
		System.out.println(getStudentMap);
	
	}
	
	

	

}
