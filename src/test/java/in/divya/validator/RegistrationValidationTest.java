/**
 * 
 */
package in.divya.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;



import org.junit.Test;

import in.divya.util.Validation;
/**
 * @author divy2624
 *
 */
public class RegistrationValidationTest
{
	@Test
	public void isStringEmptyTestCase1() 
	{ 
		/**
		 *returns false if empty 
		 */
		String name = "  ";
		boolean isValidName = Validation.isStringNotEmpty(name);
		assertFalse(isValidName);
	}
	
	@Test
	public void isStringNotEmptyTestCase2() 
	{ 
		 /**
		  * returns true if available
		  */
		String name = "DIVYA";
		boolean isValidName = Validation.isStringNotEmpty(name);
		assertTrue(isValidName);
	}
	
	@Test
	public void isStringNullTestCase1() 
	{
		/**
		  * returns false if available
		  */
		String name = null;
		boolean isValidName = Validation.isStringNotNull(name);
		assertFalse(isValidName);
	}
	
	@Test
	public void isStringNotNullTestCase2()
	{
		/**
		  * returns True if available
		  */
		String name = "DIVYA";
		boolean isValidName = Validation.isStringNotNull(name);
		assertTrue(isValidName);
	}
	
	/**
	 * Final Combined verification
	 */


	@Test
	public void isValidStringFinalTestCase1() 
	{
		/**
		 * To Validate String
		 */
	String name = "DIVYA";
	boolean finalEmployeeNameValidation  =  Validation.isValidString(name);
	assertTrue(finalEmployeeNameValidation);
	}
	
	
	@Test
	public void isValidEmailTestCase1() 
	{  
		/**
		 * Valid Mail
		 */
		String emailId = "divya@gmail.com";
		boolean isValidName = Validation.isValidEmailId(emailId);
		assertTrue(isValidName);
	}
	
	@Test
	public void isValidEmailTestCase2() 
	{  
		/**
		 * Invalid Mail 
		 */
	
		String emailId = "divyagmail.com";
		boolean isValidEmailId = Validation.isValidEmailId(emailId);
		assertFalse(isValidEmailId);
	}
		
	@Test
	public void isValidEmailTestCase3() 
	{ 
		/**
		 * Invalid Mail 
		 */
		String emailId = "divyagmailcom";
		boolean isValidEmailId= Validation.isValidEmailId(emailId);
		assertFalse(isValidEmailId);
	}
	
	@Test
	public void isValidPasswordFormatTest1()
	{ 
		/**
		 *The password is wrong format is correct
		 */
	String password =  "raja123";
	boolean isValidPasswordLength = Validation.isValidPasswordFormat(password);
	assertFalse(isValidPasswordLength);
	}

	@Test
	public void isValidPasswordFormatTest2() 
	{ 
		/**
		 *password is correct format is correct
		 */
	String password =  "Divya@76";
	boolean isValidPasswordLength = Validation.isValidPasswordFormat(password);
	assertTrue(isValidPasswordLength);
	}	
	
	
	@Test
	public void isValidRollNumberFormatTest1() 
	{ 
		/**
		 * Roll number is wrong password is correct
		 */
	String rollNumber =  "2345VV67AA";
	boolean isValidRollNumber = RegistrationValidation.isValidRollNumberFormat(rollNumber);
	assertFalse(isValidRollNumber);
	}

	@Test
	public void isValidRollNumberFormatTest2() 
	{ 
		/**
		 *  roll no is correct password is correct
		 */
	String rollNumber =  "AA23BB3456";
	boolean isValidRollNumber = RegistrationValidation.isValidRollNumberFormat(rollNumber);
	assertTrue(isValidRollNumber);
	}	
	
	@Test
	public void isValidDateTestCase1()
	{
		/**
		 * To Validate date.
		 */
		LocalDate date = LocalDate.of(2020, 12, 02);
		boolean isValidName = Validation.isValidDate(date);
		assertTrue(isValidName);
	}
	
	@Test
	public void isValidDateTestCase2()
	{

		/**
		 * To Validate date.
		 */
		LocalDate date = LocalDate.now().plusDays(1);
		boolean isValidName = Validation.isValidDate(date);
		assertFalse(isValidName);
	}
	
	@Test
	public void isValidMobileNumberTestCase1()
	{
		/**
		 * To validate mobile number format.
		 */
		long number = 1234567890l;
		boolean isValidMobileNumber = Validation.isValidMobileNumberLength(number);
		assertTrue(isValidMobileNumber);
	}
	
	@Test
	public void isValidMobileNumberTestCase2() 
	{
		/**
		 * To validate mobile number format.
		 */
		Long number = 1231110L;
		boolean isValidMobileNumber = Validation.isValidMobileNumberLength(number);
		assertFalse(isValidMobileNumber);
	}
	
	@Test
	public void isValidMobileNumberTestCase3() 
	{
		/**
		 * To validate mobile number format.
		 */
		Long number = 0000000000L;
		boolean isValidMobileNumber = Validation.isValidMobileNumberLength(number);
		assertFalse(isValidMobileNumber);
	}
	
	@Test
	public void isValidMobileNumberTestCase4() 
	{
		/**
		 * To validate mobile number format.
		 */
		Long number = null;
		boolean isValidMobileNumber = Validation.isValidMobileNumberLength(number);
		assertFalse(isValidMobileNumber);
	}
		
	@Test
	public void isMobileNumberPositiveTestCase1() 
	{
		/**
		 * To validate mobile number format.
		 */
		Long number = -8374987334L;
		boolean isValidMobileNumber = Validation.isMobileNumberPositive(number);
		assertFalse(isValidMobileNumber);
	}
	
	@Test
	public void isMobileNumberPositiveTestCase2() 
	{
		/**
		 * To validate mobile number format.
		 */
		Long number = 8374987334L;
		boolean isValidMobileNumber = Validation.isMobileNumberPositive(number);
		assertTrue(isValidMobileNumber);
	}
	
	
	
	

	

	

}
