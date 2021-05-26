/**
 * 
 */
package in.divya.util;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import org.apache.taglibs.standard.lang.jstl.parser.ParseException;
import org.junit.jupiter.api.Test;

import in.divya.exceptions.InValidBloodGroupFormatException;
import in.divya.exceptions.InValidDateException;
import in.divya.exceptions.InValidEmailIDException;
import in.divya.exceptions.InValidPasswordFormatException;
import in.divya.exceptions.InValidLongNumberTypeException;

/**
 * @author divy2624
 *
 */
class ValidationUtilTest {

	/**
	 * To Check Empty String TestCase
	 */
	
	@Test
	public void emptyStringInputIsChecked() {
		try {
			StringValidatorUtil.isStringNotNullOrEmpty(" ", "Field cannot be Empty");
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

	/**
	 * To Check Valid String TestCase
	 */
	
	@Test
	public void validStringInputIsChecked() {
		try {
			boolean isValidString =StringValidatorUtil.isStringNotNullOrEmpty("K.DIVYA", "Field cannot be Empty");
			assertTrue(isValidString);
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

	/**
	 * To Check Null TestCase
	 */
	 
	@Test
	public void nullStringInputIsChecked() {
		try {
			StringValidatorUtil.isStringNotNullOrEmpty(null, "Field cannot be Empty");
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

	/**
	 * To check Valid EmailId Format TestCase.
	 * @throws InValidEmailIDException
	 */
	
	@Test
	public void validEmailIdIsTested() throws InValidEmailIDException {
		String emailId = "divya@gmail.com";
		boolean isValidMail = EmailIDValidatorUtil.isValidEmailId(emailId,"InValid EmailId Format");
		assertTrue(isValidMail);
	}
	
	/**
	 * To check InValid EmailId Format TestCase.
	 */
	
	@Test
	public void inValidEmailIdIsTested() {
		try {
			String emailId = "divyagmail.com";
			boolean isValidMail =EmailIDValidatorUtil.isValidEmailId(emailId,"InValid EmailID Format");
			assertFalse(isValidMail);
		} catch (Exception e) {
			assertEquals("InValid EmailID Format", e.getMessage());
			
		}
	}
	
	/**
	 * To check Valid Password Format TestCase. 
	 * @throws InValidPasswordFormatException
	 */
	
	@Test
	public void validPasswordFormatIsTested() throws InValidPasswordFormatException {
		String password = "Divya@76";
		boolean isValidPassword = PasswordValidatorUtil.isValidPasswordFormat(password, "Invalid password format");
		assertTrue(isValidPassword);
	}

	/**
	 * To check InValid Password Format TestCase. 
	 */
	
	@Test
	public void inValidPasswordFormatIsTested() {
		try {
			String password = "raja123";
			boolean isValidPassword = PasswordValidatorUtil.isValidPasswordFormat(password, "Invalid password format");
			assertFalse(isValidPassword);
		} catch (Exception e) {
			assertEquals("Invalid password format", e.getMessage());
		}
	}
	
	/**
	 * To check Valid BloodGroup Format TestCase
	 * @throws InValidBloodGroupFormatException
	 */
	
	@Test
	public void validBloodGroupFormatIsTeste() throws InValidBloodGroupFormatException {
		String bloodGroup = "A-";
		boolean isValidBloodGroup = BloodGroupValidatorUtil.isValidBloodGroupFormat(bloodGroup, "Invalid bloodGroup format");
		assertTrue(isValidBloodGroup);
	}

	/**
	 * To check InValid BloodGroup Format TestCase
	 */
	
	@Test
	public void inValidBloodGroupFormatIsTested() {
		try {
			String bloodGroup = "-A";
			boolean isValidBloodGroup = BloodGroupValidatorUtil.isValidBloodGroupFormat(bloodGroup, "InValid BloodGroup format");
			assertFalse(isValidBloodGroup);
		} catch (Exception e) {
			assertEquals("InValid BloodGroup format", e.getMessage());
		}
	}
	
	/**
	 * To check MobileNumber TestCase. 
	 * @throws ParseException
	 * @throws InValidLongNumberTypeException
	 */
	
	@Test
	public void validNumberIsTestedWithoutAnyAlphabets() throws ParseException, InValidLongNumberTypeException {
		String number = "9600923846";
		Long isValidNumber = NumberValidatorUtil.isValidNumberOnly(number, "Mobile number cannot contain alphabets");
		assertEquals(Long.valueOf(9600923846L), isValidNumber);
	}

	/**
	 * To check InValid MobileNumber Format TestCase.
	 */
	
	@Test
	public void invalidNumberIsTestedWithAlphabet() {
		try {
			String number = "960092384s";
			Long isValidNumber = NumberValidatorUtil.isValidNumberOnly(number, "Mobile Number cannot contain alphabets");
			assertEquals(Long.valueOf(9600923846L), isValidNumber);
		} catch (Exception e) {
			assertEquals("Mobile Number cannot contain alphabets", e.getMessage());
		}
	}
	
	/**
	 * To check Future Date TestCase. 
	 */
	
	@Test
	public void futureDateIsTested() {
		try{
			LocalDate testDate = LocalDate.now().plusDays(1);
			DateValidatorUtil.isNotAFutureDate(testDate, "Invalid Date");
		}
		catch(Exception e) {
			assertEquals("Invalid Date",e.getMessage());
		}
		
	}
	
	/**
	 * To check Present Date TestCase. 
	 */
	
	@Test
	public void presentDateIsTested() throws InValidDateException {
		LocalDate testDate = LocalDate.now();
		boolean isValidEmployeeId = DateValidatorUtil.isNotAFutureDate(testDate, "Invalid Date");
		assertTrue(isValidEmployeeId);
	}
	
	/**
	 * To check Past Date TestCase. 
	 */
	
	@Test
	public void pastDateIsChecked() throws InValidDateException {
		LocalDate testDate = LocalDate.now().minusDays(1);
		boolean isValidEmployeeId = DateValidatorUtil.isNotAFutureDate(testDate, "Invalid Date");
		assertTrue(isValidEmployeeId);
	}
	
	/**
	 * To check Valid Date Format TestCase. 
	 * @throws InValidDateException
	 */
	
	@Test
	public void validDateFormatOrNotIsChecked() throws InValidDateException {
		String testDate = "2000-12-12";
		LocalDate ValidDate = DateValidatorUtil.isDateFormatOrNot(testDate, "Invalid Date format");
		assertEquals(ValidDate,LocalDate.parse("2000-12-12"));
	}
	
	/**
	 *  To check InValid Date Format TestCase. 
	 */
	
	@Test
	public void inValidDateFormatIsChecked() {
		try{
			String testDate = "2000-12-1";
			DateValidatorUtil.isDateFormatOrNot(testDate, "Invalid Date format");
		}
		catch(Exception e) {
			assertEquals("Invalid Date format",e.getMessage());
		}
		
	}
	
}
