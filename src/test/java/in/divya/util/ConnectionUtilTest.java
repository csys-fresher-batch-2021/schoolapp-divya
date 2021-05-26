/**
 * 
 */
package in.divya.util;

import java.sql.Connection;

/**
 * @author divy2624
 *
 */
public class ConnectionUtilTest {
		/**
		 * This method is to get Connection.
		 * @param args
		 */
		public static void main(String[] args) {
			Connection connection = ConnectionUtil.getConnection();
			System.out.println(connection);
		}

}
