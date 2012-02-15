package de.fhb.websecurity.access.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import aglib.dataaccess.database.SQLDatabaseAccessor;

import de.fhb.websecurity.access.file.Logger;
import de.fhb.websecurity.data.UserVO;

/**
 * This class creates the connection to the database.
 * 
 * @author Arvid Grunenberg, Thomas Habiger
 * @version 0.2
 *
 */
public class DatabaseAccess extends SQLDatabaseAccessor {

	protected final static String DB = "forensic_demo";
	protected final String URL = "jdbc:mysql://localhost:3306/" + DB;
	protected final String USER = "root";
	protected final String PASSWORD = "";
	
	protected final static String DRIVER = "com.mysql.jdbc.Driver";
	
	protected Connection connection;
	
	/**
	 * Default-Constructor
	 */
	public DatabaseAccess() {
		super(DB);
		connection = null;
		loadDriver();
	}
	
	/**
	 * Loads the current driver.
	 * @return True if the driver is loaded.
	 */
	protected boolean loadDriver() {
		try {
			Class.forName(DRIVER).newInstance();
		} catch (Exception e) {
			System.out.println("Failed to load MySQL JDBC driver.");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method is for authentication on the system. It creates a SQL statement and sends it to the database.
	 * 
	 * @param username - The given username, which should use for authentication.
	 * @param password - The given password, which should use for authentication.
	 * @return The user table as an object.
	 */
	public UserVO login(String username, String password) {
		UserVO user = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			System.out.println("SELECT * FROM user WHERE username = '"+username+"';");
			ResultSet result_user = statement.executeQuery("SELECT * FROM user WHERE username = '"+username+"';");
			if (result_user.next()) {
				user = new UserVO();
				user.setUsername(result_user.getString("username"));
				System.out.println("SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"';");
				ResultSet result_password = statement.executeQuery("SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"';");
				if (result_password.next()) {
					user.setLastLoginDate(result_password.getString("lastLoginDate"));
					user.setRole(result_password.getString("role"));
					user.setMessage(result_password.getString("message"));
					user.setPassword(result_password.getString("password"));
					setLastLoginDate(statement, user.getUsername());
				}
				result_password.close();
			}
			result_user.close();
			statement.close();
		} catch (Exception e) {
			Logger.getInstance().logError(new StringBuffer("Es konnte keine Verbindung zur Datenbank aufgebaut werden."));
			System.out.println("Failed to send sql query.");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try { 
					connection.close(); 
				} catch(Exception e) {
					Logger.getInstance().logError(new StringBuffer("Die Verbindung zur Datenbank konnte nicht geschlossen werden."));
					System.out.println("Failed to close connection.");
					e.printStackTrace(); 
				}
			}
		}
		return user;
	}
	
	/**
	 * Sets the current time/date as the lastLoginDate.
	 * 
	 * @param statement - 
	 * @param username - The name of the user, which is log in.
	 * @throws SQLException When the statement could not execute, e.g. the statement is not valid.
	 */
	protected void setLastLoginDate(Statement statement, String username) throws SQLException {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("UPDATE user SET lastLoginDate = '" + df.format(date) + "' WHERE username = '" + username + "'");
		statement.executeUpdate("UPDATE user SET lastLoginDate = '" + df.format(date) + "' WHERE username = '" + username + "'");
	}
	
}
