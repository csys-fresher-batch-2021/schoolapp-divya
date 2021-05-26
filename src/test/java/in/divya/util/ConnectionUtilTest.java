/**
 * 
 */
package in.divya.util;

import java.sql.Connection;

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
	 * @throws InValidCredentialsException
	 */
	public static void main(String[] args) throws InValidCredentialsException {
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(connection);
	}

}
