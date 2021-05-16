/**
 * 
 */
package in.divya.service;

import java.util.HashMap;
import in.divya.util.Validation;

/**
 * @author divy2624
 *
 */
public class StaffDetailService
{
	private StaffDetailService()
	{
		/**
		 * Default constructor
		 */
	}
	
	private static final HashMap<String, String> staffDetailsMap = new HashMap<>();
	
	static
	{
		staffDetailsMap.put("M.LAKSHMI", "Rlakshmi@123");
	}
	
	/**
	 * To Validate Staff Login
	 * @param staffName
	 * @param staffPassword
	 * @return
	 */
	
	public static boolean staffValidation(String staffName,String staffPassword) 
	{
		boolean isValidStaff = false;
		boolean isValidName = Validation.isValidString(staffName);
		boolean isValidPasswordFormat = Validation.isValidPasswordFormat(staffPassword);
		
		/**
		 * To validate name,password.
		 * If it is true......Login sucessfully.
		 * otherwise it is failed
		 */
		if (isValidName  && isValidPasswordFormat && staffDetailsMap.containsKey(staffName) && staffPassword.equals(staffDetailsMap.get(staffName))) 
		{
				isValidStaff = true;
			
		}
		return isValidStaff;

	}


}
