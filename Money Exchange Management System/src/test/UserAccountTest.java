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
		ua1 = new UserAccount("JohnLen", "@bCd4321", "86920602");
		ua2 = new UserAccount("TanKW", "@bCd432!", "96920602");
		ua3 = new UserAccount("KaiLin", "@bCd1234", "83885423");

		UAList = new ArrayList<UserAccount>();
	}

	@Test
	public void testAddUserAccount() {

		// Test Case 1
		// UserAccount list is not null, so that can add a new user account
		assertNotNull("Test if there is a valid UserAccount arraylist to add to", UAList);
		assertEquals("Test that the UserAccount arraylist is empty.", 0, UAList.size());
		// Given an empty UserAccount list, after adding 1 user account, the size of
		// the list is 1 - normal
		// The user account just added is as same as the first item of the list
		Main.addUserAccount(UAList, ua1);
		assertEquals("Test that UserAccount arraylist size is 1", 1, UAList.size());
		assertSame("Test that UserAccount is added", ua1, UAList.get(0));

		// Test Case 2
		// Add another user account. Test the size of the list is 2 - normal
		// The user account just added is as same as the second item of the list
		Main.addUserAccount(UAList, ua2);
		assertEquals("Test that UserAccount arraylist size is 2", 2, UAList.size());
		assertNotEquals("Test that UserAccount ID is not the same as the previous", ua1.getAccountID(),
				ua2.getAccountID());
		assertSame("Test that UserAccount is added", ua2, UAList.get(1));

		// Test Case 3
		// Add a user account that already exists in the list
		Main.addUserAccount(UAList, ua1);
		assertEquals("Test that the UserAccount arraylist size is unchange.", 2, UAList.size());
		
		// Test Case 4
		
	}

	@Test
	public void testViewUserAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserAccount() {
		fail("Not yet implemented");
	}

	@After
	public void tearDown() throws Exception {
		ua1 = null;
		ua2 = null;
		ua3 = null;
		UAList = null;
	}

}
