package de.fhb.websecurity.data;

/**
 * A value object of the user table from the database.
 * 
 * @author Arvid Grunenberg, Thomas Habiger
 * @version 0.1
 *
 */
public class UserVO {
	
	protected String username;
	protected String lastLoginDate;
	protected String role;
	protected String message;
	protected String password;

	public UserVO() {
	}
	
	public UserVO(String username, String lastLoginDate, String role) {
		super();
		this.username = username;
		this.lastLoginDate = lastLoginDate;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
