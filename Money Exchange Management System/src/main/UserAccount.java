package main;

public class UserAccount {

	private int userID;
	private String username;
	private String password;
	private String contactInformation;

	public UserAccount(int userID, String username, String password, String contactInformation) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.contactInformation = contactInformation;
	}

	public String toString() {
		String accountInfo = String.format("%-15d %-20s %-20s %-15s", userID, username, password, contactInformation);
		return accountInfo;
	}

	public int getAccountID() {
		return userID;
	}

	public void setAccountID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

}
