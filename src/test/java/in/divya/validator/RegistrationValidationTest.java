/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;



import org.junit.Test;



/**
 * @author divy2624
 *
 */
public class RegistrationValidationTest {
	@Test
	public void isNameEmptyTestCase1() {// returns false if empty
		String name = "  ";
		boolean isValidName = RegistrationValidation.isNameNull(name);
		assertTrue(isValidName);
	}
	
	@Test
	public void isNameEmptyTestCase2() { // returns true if available
		String name = "DIVYA";
		boolean isValidName = RegistrationValidation.isNameNotEmpty(name);
		assertTrue(isValidName);
	}
	
//////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void isNameNullTestCase1() {
		String name = null;
		boolean isValidName = RegistrationValidation.isNameNull(name);
		assertFalse(isValidName);
	}
	
	@Test
	public void isNameNullTestCase2() {
		String name = null;
		boolean isValidName = RegistrationValidation.isNameNull(name);
		assertFalse(isValidName);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////Final Combined verification


	@Test
	public void isValidNameFinalTestCase1() {
	String name = "DIVYA";
	boolean finalEmployeeNameValidation  =  RegistrationValidation.isNameValidation(name);
	assertTrue(finalEmployeeNameValidation);
	}
	
	
//////////////////////////////////////////////////////////////////////////////////	
	
	@Test
	public void isValidEmailTestCase1() {  //Valid Mail 
		String emailId = "divya@gmail.com";
		boolean isValidName = RegistrationValidation.isValidEmailId(emailId);
		assertTrue(isValidName);
	}
	
	@Test
	public void isValidEmailTestCase2() {  //Valid Mail 
		String emailId = "divyagmail.com";
		boolean isValidName = RegistrationValidation.isValidEmailId(emailId);
		assertFalse(isValidName);
	}
		
	@Test
	public void isValidEmailTestCase3() {  //Valid Mail 
		String emailId = "divyagmailcom";
		boolean isValidName = RegistrationValidation.isValidEmailId(emailId);
		assertFalse(isValidName);
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void isValidPasswordFormatTest1() { //user password is wrong password is correct
	String password =  "raja123";
	boolean isValidPasswordLength = RegistrationValidation.isValidPasswordFormat(password);
	assertFalse(isValidPasswordLength);
	}

	@Test
	public void isValidPasswordFormatTest2() { //user password is wrong password is correct
	String password =  "Divya@76";
	boolean isValidPasswordLength = RegistrationValidation.isValidPasswordFormat(password);
	assertTrue(isValidPasswordLength);
	}	
	
//////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void isValidRollNumberFormatTest1() { //user roll no is wrong password is correct
	String rollNumber =  "2345VV67AA";
	boolean isValidRollNumber = RegistrationValidation.isValidRollNumberFormat(rollNumber);
	assertFalse(isValidRollNumber);
	}

	@Test
	public void isValidRollNumberFormatTest2() { //user roll no is wrong password is correct
	String rollNumber =  "AA23BB3456";
	boolean isValidRollNumber = RegistrationValidation.isValidRollNumberFormat(rollNumber);
	assertTrue(isValidRollNumber);
	}	
	
//////////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	public void isValidDateTestCase1() {
		LocalDate date = LocalDate.of(2020, 12, 02);
		boolean isValidName = RegistrationValidation.isValidDate(date);
		assertTrue(isValidName);
	}
	
	@Test
	public void isValidDateTestCase2() {
		LocalDate date = LocalDate.now().plusDays(1);
		boolean isValidName = RegistrationValidation.isValidDate(date);
		assertFalse(isValidName);
	}
	
//////////////////////////////////////////////////////////////////////////////////	
	@Test
	public void isValidMobileNumberTestCase1() {
		long number = 1234567890l;
		boolean isValidMobileNumber = RegistrationValidation.isValidMobileNumberLength(number);
		assertTrue(isValidMobileNumber);
	}
	
	@Test
	public void isValidMobileNumberTestCase2() {
		Long number = 1231110L;
		boolean isValidMobileNumber = RegistrationValidation.isValidMobileNumberLength(number);
		assertFalse(isValidMobileNumber);
	}
	
	@Test
	public void isValidMobileNumberTestCase3() {
		Long number = 0000000000L;
		boolean isValidMobileNumber = RegistrationValidation.isValidMobileNumberLength(number);
		assertFalse(isValidMobileNumber);
	}
	
	@Test
	public void isValidMobileNumberTestCase4() {
		Long number = null;
		boolean isValidMobileNumber = RegistrationValidation.isValidMobileNumberLength(number);
		assertFalse(isValidMobileNumber);
	}
	
//////////////////////////////////////////////////////////////////////////////////	
	@Test
	public void isMobileNumberPositiveTestCase1() {
		Long number = -8374987334L;
		boolean isValidMobileNumber = RegistrationValidation.isMobileNumberPositive(number);
		assertFalse(isValidMobileNumber);
	}
	
	@Test
	public void isMobileNumberPositiveTestCase2() {
		Long number = 8374987334L;
		boolean isValidMobileNumber = RegistrationValidation.isMobileNumberPositive(number);
		assertTrue(isValidMobileNumber);
	}
	
	
	
	

	

	

}