package main;

import java.util.ArrayList;
import java.util.Currency;

public class Main {

	private static final String USERNAME_PATTERN = "^[A-Za-z0-9]{6,}$";
	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	private static final String PHONE_NUMBER_PATTERN = "^(6|8|9)\\d{7}$";
	private static final String NOT_EMPTY = ".+";

	private static int lastUserID = 0;

	public static void main(String[] args) {

	}

	public static void setHeader(String header) {
		Helper.line(100, "-");
		System.out.println(header);
		Helper.line(100, "-");
	}

	// ================================= Accounts =================================

	public static UserAccount inputUserAccount(ArrayList<UserAccount> UAList) {
		UserAccount UA = null;
		int userID = ++lastUserID;

		String username = Helper.readStringRegEx("Enter Username > ", USERNAME_PATTERN);
		String password = Helper.readStringRegEx("Enter Password > ", PASSWORD_PATTERN);
		String contactInformation = Helper.readStringRegEx("Enter Phone Number (SG) > ", PHONE_NUMBER_PATTERN);

		UA = new UserAccount(userID, username, password, contactInformation);

		return UA;
	}

	public static void addUserAccount(ArrayList<UserAccount> UAList, UserAccount ua) {
		for (UserAccount UA : UAList) {
			if (ua.getAccountID() == UA.getAccountID() || ua.getUsername() == UA.getUsername()) {
				return;
			}
		}
		UAList.add(ua);

	}

	public static String retrieveUserAccount(ArrayList<UserAccount> UAList) {
		String output = "";

		for (UserAccount UA : UAList) {
			output += String.format("%-73s\n", UA.toString());
		}
		return output;

	}

	public static void viewUserAccount(ArrayList<UserAccount> UAList) {
		String output = retrieveUserAccount(UAList);

		setHeader("USER ACCOUNT LIST");
		String header = String.format("%-15s %-20s %-20s %-15s\n", "USER ID", "ACCOUNT ID", "PASSWORD",
				"CONTACT INFORMATION");
		System.out.println(header + output);
	}

	public static boolean doUpdateUserAccount(ArrayList<UserAccount> UAList, int userToUpdateID, String newUsername,
			String newPassword, String newContactInformation) {

		for (UserAccount UA : UAList) {
			if (UA.getAccountID() == userToUpdateID) {
				if (!newUsername.isEmpty()) {
					UA.setUsername(newUsername);
				}
				if (!newPassword.isEmpty()) {
					UA.setPassword(newPassword);
				}
				if (!newContactInformation.isEmpty()) {
					UA.setContactInformation(newContactInformation);
				}
				return true;

			}
		}
		return false;

	}

	public static void updateUserAccount(ArrayList<UserAccount> UAList) {
		Main.viewUserAccount(UAList);

		String userToUpdateID = Helper.readStringRegEx("Enter User ID to Update > ", NOT_EMPTY);
		String newUsername = Helper.readString("Enter New Username (Press Enter to keep current) > ");
		String newPassword = Helper.readString("Enter New Password (Press Enter to keep current) > ");
		String newContactInformation = Helper
				.readString("Enter New Contact Information (Press Enter to keep current) > ");

		int usertoUpdateIDInt = Integer.parseInt(userToUpdateID);
		boolean updated = doUpdateUserAccount(UAList, usertoUpdateIDInt, newUsername, newPassword,
				newContactInformation);

		if (updated == false) {
			System.out.println("Invalid User ID");
		} else {
			System.out.println("User" + userToUpdateID + "Updated");
		}

	}

	public static boolean doDeleteUserAccount(ArrayList<UserAccount> UAList, int userToDeleteID) {
		for (UserAccount UA : UAList) {
			if (UA.getAccountID() == userToDeleteID) {
				UAList.remove(userToDeleteID);
				return true;
			}
		}
		return false;

	}

	public static void deleteUserAccount(ArrayList<UserAccount> UAList) {
		Main.viewUserAccount(UAList);

		int userToDeleteID = Helper.readInt("Enter User ID to Delete > ");

		boolean deleted = doDeleteUserAccount(UAList, userToDeleteID);

		if (deleted == false) {
			System.out.println("Invalid User ID");
		} else {
			System.out.println("User" + userToDeleteID + "Deleted");
		}

	}

	// ================================= Currency =================================

	public static CurrencyMEMS inputCurrency(ArrayList<CurrencyMEMS> CList) {
		CurrencyMEMS CA = null;

		String currencyCode = Helper.readStringRegEx("Enter Currency Code (ISO 4217) > ", NOT_EMPTY);
		String currencyName = Currency.getInstance(currencyCode).getDisplayName();

		CA = new CurrencyMEMS(currencyCode, currencyName);

		return CA;
	}

	public static boolean isValidCurrencyCode(String currencyCode) {
		try {
			Currency.getInstance(currencyCode);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public static void addCurrency(ArrayList<CurrencyMEMS> CList, CurrencyMEMS ca) {

		if (ca.getCurrencyCode() == null || !isValidCurrencyCode(ca.getCurrencyCode())) {
			return;
		}

		for (CurrencyMEMS CA : CList) {
			if (ca.getCurrencyCode().equals(CA.getCurrencyCode())) {
				return;
			}
		}
		CList.add(ca);
	}

}
