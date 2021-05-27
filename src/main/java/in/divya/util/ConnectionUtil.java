/**
 * 
 */
package in.divya.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import in.divya.exceptions.InValidCredentialsException;

/**
 * @author divy2624
 *
 */
public class ConnectionUtil {
	private ConnectionUtil() {
		// Default Constructor
	}

	private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
	private static final String DATABASE_NAME = "student_db";
	private static final String DB_USERNAME = "prod_user";
	private static final String DB_PASSWORD = "prod_user";
	private static final String HOST = "projecttracker.ck1ayq0lncmp.ap-south-1.rds.amazonaws.com";
	private static final int PORT = 5432;
	private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME; // jdbc:postgres://localhost:5432/student_db

	/**
	 * This method creates a connection.
	 * 
	 * @return
	 * @throws InValidCredentialsException
	 */
	public static Connection getConnection() throws InValidCredentialsException {

		Connection connection = null;
		try {
			/**
			 * Step 1: Load the database driver into memory ( ClassNotFoundException )
			 */
			Class.forName(DRIVER_CLASS_NAME);

			/**
			 * Step 2: Get the Database Connection (SQLException)
			 */
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new InValidCredentialsException("Unable to get the database connection");
		}

		return connection;
	}

	public static void close(PreparedStatement pst, Connection con) {
		/**
		 * Null Check - to avoid Null Pointer Exception
		 */
		try {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close the connection of Resultset connection and
	 * prepared statement Method overloading
	 * 
	 * @param con
	 */
	public static void close(ResultSet rs, Statement statement, Connection con) {
		try {

			if (rs != null) {
				rs.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
