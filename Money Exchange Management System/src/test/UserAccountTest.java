package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Main;
import main.UserAccount;

public class UserAccountTest {

	private UserAccount ua1;
	private UserAccount ua2;
	private UserAccount ua3;
	private ArrayList<UserAccount> UAList;

	@Before
	public void setUp() throws Exception {

		// Prepare Test Data
		ua1 = new UserAccount(1, "JohnLen", "@bCd4321", "86920602");
		ua2 = new UserAccount(2, "TanKW", "@bCd432!", "96920602");
		ua3 = new UserAccount(3, "KaiLin", "@bCd1234", "83885423");

		UAList = new ArrayList<UserAccount>();
	}

	@Test
	public void testAddUserAccount() {

		// Test Case 1
		assertNotNull("Test if there is a valid UserAccount arraylist to add to", UAList);
		assertEquals("Test that the UserAccount arraylist is empty.", 0, UAList.size());

		// Test Case 2
		Main.addUserAccount(UAList, ua1);
		assertEquals("Test that UserAccount arraylist size is 1", 1, UAList.size());
		assertSame("Test that UserAccount is added", ua1, UAList.get(0));

		// Test Case 3
		Main.addUserAccount(UAList, ua2);
		assertEquals("Test that UserAccount arraylist size is 2", 2, UAList.size());
		assertNotEquals("Test that UserAccount ID is not the same as the previous", ua1.getAccountID(),
				ua2.getAccountID());
		assertSame("Test that UserAccount is added", ua2, UAList.get(1));

		// Test Case 4
		Main.addUserAccount(UAList, ua1);
		assertEquals("Test that the UserAccount arraylist size is unchange.", 2, UAList.size());

		// Test Case 5
		UserAccount uaDuplicateUsername = new UserAccount(4, "JohnLen", "@BCd4321", "80560601");
		Main.addUserAccount(UAList, uaDuplicateUsername);
		assertEquals("Test that the UserAccount arraylist size is unchange.", 2, UAList.size());
	}

	@Test
	public void testViewUserAccount() {

		assertNotNull("Test if there is a valid UserAccount arraylist to add to", UAList);
		assertEquals("Test that the UserAccount arraylist is empty.", 0, UAList.size());

		// Test Case 6
		String allUserAccounts = Main.retrieveUserAccount(UAList);

		String testOutputAccounts = "";

		assertEquals("Test that nothing is displayed", testOutputAccounts, allUserAccounts);

		// Test Case 7
		Main.addUserAccount(UAList, ua1);
		Main.addUserAccount(UAList, ua2);

		assertEquals("Test that UserAccount arraylist size is 2", 2, UAList.size());

		allUserAccounts = Main.retrieveUserAccount(UAList);

		testOutputAccounts = String.format("%-15d %-20s %-20s %-15s\n", 1, "JohnLen", "@bCd4321", "86920602");
		testOutputAccounts += String.format("%-15d %-20s %-20s %-15s\n", 2, "TanKW", "@bCd432!", "96920602");

		assertEquals("Test that the display is correct.", testOutputAccounts, allUserAccounts);

		// Test Case 8
		Main.addUserAccount(UAList, ua3);

		assertEquals("Test that UserAccount arraylist size is 3", 3, UAList.size());

		allUserAccounts = Main.retrieveUserAccount(UAList);

		testOutputAccounts += String.format("%-15d %-20s %-20s %-15s\n", 3, "KaiLin", "@bCd1234", "83885423");

		assertEquals("Test that the display is correct.", testOutputAccounts, allUserAccounts);
	}

	@Test
	public void testUpdateUserAccount() {

		assertNotNull("Test if there is a valid UserAccount arraylist to add to", UAList);
		Main.addUserAccount(UAList, ua1);

		// Test Case 9
		boolean updated = Main.doUpdateUserAccount(UAList, 1, "JohnDoe", "Password123!", "81235678");

		assertTrue("Test that all fields have been updated", updated);

		assertEquals("Username updated", "JohnDoe", ua1.getUsername());
		assertEquals("Password updated", "Password123!", ua1.getPassword());
		assertEquals("Contact Information updated", "81235678", ua1.getContactInformation());

		// Test Case 10
		updated = Main.doUpdateUserAccount(UAList, 1, "", "", "");
		assertTrue("Test that no fields have been updated", updated);

		// Test Case 11
		updated = Main.doUpdateUserAccount(UAList, 1, "AliceSmith", "SecurePwd567@", "");

		assertTrue("Test that fields indicated have been updated", updated);

		assertEquals("Username updated", "AliceSmith", ua1.getUsername());
		assertEquals("Password updated", "SecurePwd567@", ua1.getPassword());
		assertEquals("Contact Information remain unchanged", "81235678", ua1.getContactInformation());

		// Test Case 12
		updated = Main.doUpdateUserAccount(UAList, 10, "AlexieJu", "", "");
		assertFalse("Test that no fields have been updated", updated);
	}

	@Test
	public void testDeleteUserAccount() {

		Main.addUserAccount(UAList, ua1);
		Main.addUserAccount(UAList, ua2);
		Main.addUserAccount(UAList, ua3);

		assertEquals("Test that UserAccount arraylist size is 3", 3, UAList.size());

		// Test Case 13
		Main.doDeleteUserAccount(UAList, 2);
		assertEquals("Test that UserAccount arraylist size is 2", 2, UAList.size());

		// Test Case 14
		Main.doDeleteUserAccount(UAList, 5);
		assertEquals("Test that UserAccount arraylist size remains the same", 2, UAList.size());

		// Test Case 15
		UAList.clear();
		assertEquals("Test that the UserAccount arraylist is empty.", 0, UAList.size());

		Main.doDeleteUserAccount(UAList, 1);
		assertEquals("Test that UserAccount arraylist size remains the same", 0, UAList.size());
	}

	@After
	public void tearDown() throws Exception {
		ua1 = null;
		ua2 = null;
		ua3 = null;
		UAList = null;
	}

}
