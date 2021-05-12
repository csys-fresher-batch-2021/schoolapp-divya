/**
 * 
 */
package in.divya.validator;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author divy2624
 *
 */
public class RegistrationValidation {
    private RegistrationValidation() {
		//Default constructor
	}
	/**
	 * This method checks whether the name has no empty value or null values
	 * @param name
	 * @return
	 */
	public static boolean isNameNull(String name){ 
		boolean isValidName = false;
		
		if(name != null) {
			isValidName = true;
		}
		
		return isValidName;
	}
	/**
	 * This method returns if the name is empty or not
	 * @param name
	 * @return
	 */
	public static boolean isNameNotEmpty(String name){  
		boolean isValidName = true;
		
		if(name.trim().isEmpty()) {
			isValidName = false;
		}
	
		
		return isValidName;
	}
	/**
	 * 
	 * @param employeeName
	 * @return
	 */
	public static boolean isNameValidation(String name) {
		boolean isNameValid = false;
		boolean isNameNotNull = isNameNotEmpty(name);
		boolean isNameNull = isNameNull(name);
		if(isNameNull) {
		if(isNameNotNull) {
			isNameValid = true;
		}
		}
		return isNameValid;
	}
	
	/**
	 * 
	 * @param emailId
	 * @return
	 */
	
	public static boolean isValidEmailId(String emailId) {
		boolean isValidEmailId = false;
		if(emailId == null || emailId.isEmpty()) {
			isValidEmailId = false;
		}
		
		else {
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
			Pattern regexEmailFormat = Pattern.compile(regex);
			Matcher matchEmailPattern = regexEmailFormat.matcher(emailId);
			isValidEmailId = matchEmailPattern.matches(); 
			
		}
		return isValidEmailId;
	}
	
	/**
	 * 
	 * @param password
	 * @return
	 */
	public static boolean isValidPasswordFormat(String password) {
		 boolean isValidFormat = false;
		 if (password != null)
		 {
			 String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
			 Pattern regexPattern = Pattern.compile(regex);
			 Matcher matchCheck = regexPattern.matcher(password);
			 isValidFormat = matchCheck.matches();
		 	}
		 return isValidFormat;
}
	
	public static boolean isValidRollNumberFormat(String studentRollNo) {
		
		 String regex = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$";  
	        /* ^ means start of string
	        [A-Z]{2} means 2 characters in the range of A through Z
	       
	        [0-9]{2} means 2 characters in the range of 0 through 9
	        
	        [A-Z]{2} means 2 characters in the range of A through Z
	        
	        [0-9]{4} means 4 characters in the range of 0 through 9
	        $ means end of string */

	        

	        Pattern p = Pattern.compile(regex);

	        if (studentRollNo== null)
	        {
	            return false;

	        }
	        Matcher m = p.matcher(studentRollNo);
	        return m.matches();
	}
	
	/**
	 * This method checks whether the length of mobile number is 10 digits
	 * @param number
	 * @return
	 */
	
	public static boolean bloodGroupValidation(String  studentBloodGroup) {
		 String regex = "^(A|B|AB|O)[+-]$"; 
		 Pattern p = Pattern.compile(regex);

	        if (studentBloodGroup== null)
	        {
	            return false;

	        }
	        Matcher m = p.matcher(studentBloodGroup);
	        return m.matches();
		
	}
	public static boolean standardValidation(String studentStandard) {
		 String regex = "^(I|II|III|IV|V|VI|VII|VIII|IX|X|XI|XII)$"; 
		 Pattern p = Pattern.compile(regex);

	        if (studentStandard== null)
	        {
	            return false;

	        }
	        Matcher m = p.matcher(studentStandard);
	        return m.matches();
	
	}
	public static boolean isValidMobileNumberLength(Long number) {
		boolean isValidNumber = false;
		if(number != null) {
			long numberString = (long) number.toString().trim().length();
			if((numberString == 10) && number != 0) {
				isValidNumber = true;
			}
		}		
		return isValidNumber;
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isMobileNumberPositive(Long number) {
		boolean isValidNumber = false;
		if(number != null && number>0) {
			isValidNumber = true;
			}		
		return isValidNumber;
	}
	
	/**
	 * 
	 * @param mobileNumber
	 * @return
	 */
	
	public static boolean mobileNumberValidation(long mobileNumber) {
		boolean isValidMobileNumber = false;
		boolean isValidMobileNumberLength = isValidMobileNumberLength(mobileNumber);
		boolean isMobileNumberPositive = isMobileNumberPositive(mobileNumber);
		if(isMobileNumberPositive && isValidMobileNumberLength) {
			isValidMobileNumber = true;
			
		}
		return isValidMobileNumber;
	}
	
	
	/**This method checks whether the date of birth is not a future date
	 * This method
	 * @param date
	 * @return
	 */
	public static boolean isValidDate(LocalDate date) {
		boolean isValidDate = true;
		if(date.isAfter(LocalDate.now())) {
			isValidDate = false;
		}
		return isValidDate;	
	}
	
	
		



}
