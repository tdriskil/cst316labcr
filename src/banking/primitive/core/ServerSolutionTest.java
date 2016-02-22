package banking.primitive.core;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerSolutionTest {

	private ServerSolution mTestServer;
	@Before
	public void setUp() throws Exception {
		mTestServer = new ServerSolution();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void savingOpeningTest() {
		mTestServer.newAccount("Checking", "UnitTest", 3000.0f);
		try {
			mTestServer.saveAccounts();
		} catch (IOException e) {
			fail("Testing: Failed to save accounts");
		}
		boolean existsInList = false;
		ServerSolution theSecondServer = new ServerSolution();
		List<Account> theAccounts = new ArrayList<Account>(theSecondServer.getAllAccounts());
		for( int i = 0; i < theAccounts.size(); i++ ) {
			if( theAccounts.get( i ).getName().equals( "UnitTest" ) ) {
				existsInList = true;
				assertEquals(theAccounts.get( i ).getBalance(), 3000.0f, 0.1f);
				assertEquals(theAccounts.get( i ).getType(), "Checking");
				assertEquals(theAccounts.get( i ).getState(), Account.State.OPEN);
			}
		}
		assertTrue(existsInList);
		existsInList = false;
		theSecondServer.closeAccount("UnitTest");
		List<Account> theActiveAccounts = new ArrayList<Account>(theSecondServer.getActiveAccounts());
		for( int i = 0; i < theActiveAccounts.size(); i++ ) {
			if( theActiveAccounts.get( i ).getName().equals( "UnitTest" ) ) {
				existsInList = true;
			}
		}
		assertFalse(existsInList);
	}

}
