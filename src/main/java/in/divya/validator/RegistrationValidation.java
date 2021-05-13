package in.divya.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author divy2624
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
	
	
}
