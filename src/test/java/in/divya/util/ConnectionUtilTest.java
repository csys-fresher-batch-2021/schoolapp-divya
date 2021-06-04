/**
 * 
 */
package in.divya.util;

import java.sql.Connection;
import java.sql.SQLException;

import in.divya.exceptions.InValidCredentialsException;

/**
 * @author divy2624
 *
 */
public class ConnectionUtilTest {
	/**
	 * This method is to get Connection.
	 * 
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws InValidCredentialsException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
	}

}
