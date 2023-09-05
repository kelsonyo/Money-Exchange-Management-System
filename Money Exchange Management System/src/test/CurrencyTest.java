package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.CurrencyMEMS;
import main.Main;

public class CurrencyTest {

	private CurrencyMEMS c1;
	private CurrencyMEMS c2;
	private CurrencyMEMS c3;
	private ArrayList<CurrencyMEMS> CList;

	@Before
	public void setUp() throws Exception {

		// Prepare Test Data
		c1 = new CurrencyMEMS("USD", "United States Dollar");
		c2 = new CurrencyMEMS("JPY", "Japanese Yen");
		c3 = new CurrencyMEMS("GBP", "British Pound Sterling");

		CList = new ArrayList<CurrencyMEMS>();
	}

	@Test
	public void testAddCurrency() {

		assertNotNull("Test if there is a valid Currency arraylist to add to", CList);
		assertEquals("Test that the Currency arraylist is empty.", 0, CList.size());

		// Test Case 1
		Main.addCurrency(CList, c1);
		assertEquals("Test that Currency arraylist size is 1", 1, CList.size());
		assertSame("Test that Currency is added", c1, CList.get(0));

		// Test Case 2
		Main.addCurrency(CList, c2);
		assertEquals("Test that Currency arraylist size is 2", 2, CList.size());
		assertSame("Test that Currency is added", c2, CList.get(1));

		// Test Case 3
		Main.addCurrency(CList, c1);
		assertEquals("Test that the Currency arraylist size is unchange.", 2, CList.size());
		
		// Test Case 4
		CurrencyMEMS cInvalidCode = new CurrencyMEMS("", "United States Dollar");
		Main.addCurrency(CList, cInvalidCode);
		assertEquals("Test that the Currency arraylist size is unchange.", 2, CList.size());

		// Test Case 5
		CurrencyMEMS cDuplicateUsername = new CurrencyMEMS("USD", "United States Dollar");
		Main.addCurrency(CList, cDuplicateUsername);
		assertEquals("Test that the Currency arraylist size is unchange.", 2, CList.size());
	}

	

	@After
	public void tearDown() throws Exception {
		c1 = null;
		c2 = null;
		c3 = null;
		CList = null;
	}

}
