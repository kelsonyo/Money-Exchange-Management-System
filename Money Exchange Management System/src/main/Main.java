package main;

import java.util.ArrayList;

public class Main {

	private static final String USERNAME_PATTERN = "^[A-Za-z0-9]{6,}$";
	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	public static final String PHONE_NUMBER_PATTERN = "^(6|8|9)\\d{7}$";

	public static void main(String[] args) {

	}

	public static void setHeader(String header) {
		Helper.line(100, "-");
		System.out.println(header);
		Helper.line(100, "-");
	}

	public static UserAccount inputUserAccount(ArrayList<UserAccount> UAList) {
		UserAccount UA = null;

		String username = Helper.readStringRegEx("Enter Your Username > ", USERNAME_PATTERN);
		String password = Helper.readStringRegEx("Enter your password > ", PASSWORD_PATTERN);
		String contactInformation = Helper.readStringRegEx("Enter your Phone Number (SG) > ", PHONE_NUMBER_PATTERN);

		UA = new UserAccount(username, password, contactInformation);

		return UA;
	}

	public static void addUserAccount(ArrayList<UserAccount> UAList, UserAccount UA) {
		for (UserAccount ua : UAList) {
			if (ua.getAccountID() == UA.getAccountID() || ua.getUsername() == UA.getUsername()) {
				return;
			}
		}
		UAList.add(UA);

	}

	public static String retrieveUserAccount(ArrayList<UserAccount> UAList) {
		String output = "";

		for (UserAccount UA : UAList) {
			output += String.format("%-90s\n", UA.toString());
		}
		return output;

	}

	public static void viewUserAccount(ArrayList<UserAccount> UAList) {
		String output = retrieveUserAccount(UAList);

		setHeader("USER ACCOUNT LIST");
		String header = String.format("%-15d %-20s %-20s $%-15s", "ACCOUNT ID", "PASSWORD", "CONTACT INFORMATION");
		System.out.println(header + output);
	}

}
