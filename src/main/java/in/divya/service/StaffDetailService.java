/**
 * 
 */
package in.divya.service;

import java.sql.SQLException;

import java.util.List;

import in.divya.dao.StaffDetailDAO;

/**
 * @author divy2624
 *
 */
public class StaffDetailService {
	public StaffDetailService() {
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
	 */

	public boolean staffValidation(String staffName, String staffPassword) throws SQLException, ClassNotFoundException {
		StaffDetailDAO staffDetailDAO = new StaffDetailDAO();
		boolean isValidStaffCredentials = false;
		List<String> staffCredetials = staffDetailDAO.staffCredentialData();
		/**
		 * If it is true......Login sucessfully. otherwise it is failed
		 */
		if (staffCredetials.contains(staffName) && staffCredetials.contains(staffPassword)) {
			isValidStaffCredentials = true;
		}
		return isValidStaffCredentials;

	}

}
