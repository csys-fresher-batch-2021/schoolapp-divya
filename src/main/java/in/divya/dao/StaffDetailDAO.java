/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class StaffDetailDAO {
	private StaffDetailDAO() {
		// Default Constructor
	}

	/**
	 * To Verify Staff Login using database
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws InValidCredentialsException 
	 */
	public static List<String> staffCredentialData() throws SQLException, InValidCredentialsException {

		List<String> staffCredetials = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select staff_name,staff_password from staff_data";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				String staffName = rs.getString("staff_name");
				String staffPassword = rs.getString("staff_password");
				staffCredetials.add(staffName);
				staffCredetials.add(staffPassword);
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return staffCredetials;
	}

}
