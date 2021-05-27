/**
 * 
 */
package in.divya.service;

import java.sql.SQLException;

import java.util.List;

import in.divya.dao.StaffDetailDAO;
import in.divya.exceptions.InValidCredentialsException;

/**
 * @author divy2624
 *
 */
public class StaffDetailService {
	private StaffDetailService() {
		/**
		 * Default constructor
		 */
	}

	/**
	 * To Validate Staff Login
	 * 
	 * @param staffName
	 * @param staffPassword
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws InValidCredentialsException
	 */

	public static boolean staffValidation(String staffName, String staffPassword)
			throws SQLException, InValidCredentialsException {

		boolean isValidStaffCredentials = false;
		List<String> staffCredetials = StaffDetailDAO.staffCredentialData();
		/**
		 * If it is true......Login sucessfully. otherwise it is failed
		 */
		if (staffCredetials.contains(staffName) && staffCredetials.contains(staffPassword)) {
			isValidStaffCredentials = true;
		}
		return isValidStaffCredentials;

	}

}
