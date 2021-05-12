package in.divya.validator;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author divya
 *
 */

public class RegistrationValidation 
{
    private RegistrationValidation()
    {
		/**
		 * Default constructor
		 */
	}
    
	/**
	 * This method checks whether the name has no empty value or null values
	 * @param name
	 * @return
	 */
    
	public static boolean isNameNull(String name)
	{ 
		boolean isValidName = false;
		
		if(name != null) 
		{
			isValidName = true;
		}
		
		return isValidName;
	}
	
	/**
	 * This method returns if the name is empty or not
	 * @param name
	 * @return
	 */
	
	public static boolean isNameNotEmpty(String name)
	{  
		boolean isValidName = true;
		
		if(name.trim().isEmpty()) 
		{
			isValidName = false;
		}
		return isValidName;
	}
	
	/**
	 * This method is used to validate name.
	 * @param name
	 * @return
	 */
	
	public static boolean isNameValidation(String name) {
		boolean isNameValid = false;
		boolean isNameNotNull = isNameNotEmpty(name);
		if(isNameNotNull) 
			{
				isNameValid = true;
			
			}
		
		return isNameValid;
	}
	
	/**
	 *This method is used to validate emailId. 
	 * @param emailId
	 * @return
	 */
	
	public static boolean isValidEmailId(String emailId) 
	{
		boolean isValidEmailId = false;
		if(emailId == null || emailId.isEmpty())
		{
			isValidEmailId = false;
		}
		
		else 
		{
			String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.(com|edu|org)$";
			
			/**
			 * There should be at least one character or number before. 
			 * Then there comes.
			 * There should be at least one character or number after @ and before .
			 * The string should end with either edu, com, or org.
			 */
			
			Pattern regexEmailFormat = Pattern.compile(regex);
			Matcher matchEmailPattern = regexEmailFormat.matcher(emailId);
			isValidEmailId = matchEmailPattern.matches(); 
			
		}
		return isValidEmailId;
	}
	
	/**
	 * This method is used to validate password format
	 * @param password
	 * @return
	 */
	
	public static boolean isValidPasswordFormat(String password) 
	{
		 boolean isValidFormat = false;
		 if (password != null)
		 {
			 String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
			/**
			 * ^ represents starting character of the string.
			 * (?=.*[0-9]) represents a digit must occur at least once.
			 * (?=.*[a-z]) represents a lower case alphabet must occur at least once.
			 * (?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
			 * (?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
			 * (?=\\S+$) white spaces don’t allowed in the entire string.
			 * .{8, 15} represents at least 8 characters and at most 20 characters.
			 * $ represents the end of the string.
			 */
			 Pattern regexPattern = Pattern.compile(regex);
			 Matcher matchCheck = regexPattern.matcher(password);
			 isValidFormat = matchCheck.matches();
		 	}
		 return isValidFormat;
	}
	
	/**
	 * This method to check roll number format.
	 * @param studentRollNo
	 * @return
	 */
	
	public static boolean isValidRollNumberFormat(String studentRollNo) 
	{
		
		 String regex = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$";  
		 
	        /**
	         *  ^ means start of string
	         * [A-Z]{2} means 2 characters in the range of A through Z
	         * [0-9]{2} means 2 characters in the range of 0 through 9
	         * [A-Z]{2} means 2 characters in the range of A through Z
	         * [0-9]{4} means 4 characters in the range of 0 through 9
	         * $ means end of string
	         */

	        

	        Pattern p = Pattern.compile(regex);

	        if (studentRollNo== null)
	        {
	            return false;

	        }
	        Matcher m = p.matcher(studentRollNo);
	        return m.matches();
	}
	
	/**
	 * This method checks whether the blood group is correct format or not.
	 * @param studentBloodGroup
	 * @return
	 */
	
	public static boolean bloodGroupValidation(String  studentBloodGroup) 
	{
		 String regex = "^(A|B|AB|O)[+-]$"; 
		 Pattern p = Pattern.compile(regex);

	        if (studentBloodGroup== null)
	        {
	            return false;

	        }
	        Matcher m = p.matcher(studentBloodGroup);
	        return m.matches();
		
	}
	
	/**
	 * This method is to check student standard.
	 * @param studentStandard
	 * @return
	 */
	public static boolean standardValidation(String studentStandard)
	{
		 String regex = "^(I|II|III|IV|V|VI|VII|VIII|IX|X|XI|XII)$"; 
		 Pattern p = Pattern.compile(regex);

	        if (studentStandard== null)
	        {
	            return false;

	        }
	        Matcher m = p.matcher(studentStandard);
	        return m.matches();
	
	}
	
	/**
	 * This method checks whether the mobile number length is 10.
	 * @param number
	 * @return
	 */
	public static boolean isValidMobileNumberLength(Long number)
	{
		boolean isValidNumber = false;
		if(number != null)
		{
			long numberString = (long) number.toString().trim().length();
			if((numberString == 10) && number != 0)
			{
				isValidNumber = true;
			}
		}		
		return isValidNumber;
	}
	
	/**
	 *This method checks whether the mobile number is positive. 
	 * @param number
	 * @return
	 */
	
	public static boolean isMobileNumberPositive(Long number)
	{
		boolean isValidNumber = false;
		if(number != null && number>0)
		{
			isValidNumber = true;
			}		
		return isValidNumber;
	}
	
	/**
	 * To valid Mobile Number
	 * @param mobileNumber
	 * @return
	 */
	
	public static boolean mobileNumberValidation(long mobileNumber) 
	{
		boolean isValidMobileNumber = false;
		boolean isValidMobileNumberLength = isValidMobileNumberLength(mobileNumber);
		boolean isMobileNumberPositive = isMobileNumberPositive(mobileNumber);
		if(isMobileNumberPositive && isValidMobileNumberLength) 
		{
			isValidMobileNumber = true;
			
		}
		return isValidMobileNumber;
	}
	
	
	/**
	 * This method checks whether the date of birth is not a future date
	 * This method checks whether the date of joining is not a future date
	 * @param date
	 * @return
	 */
	
	public static boolean isValidDate(LocalDate date)
	{
		boolean isValidDate = true;
		if(date.isAfter(LocalDate.now()))
		{
			isValidDate = false;
		}
		return isValidDate;	
	}
	
}
