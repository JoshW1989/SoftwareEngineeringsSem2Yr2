package Actions;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Quotation.NoQuotePermissionError;
import Quotation.Quote;
import Users.Manager;
import Users.Supervisor;
import Users.User;

public class SubmitActionTest {

	public User supervisor;
	public Manager manager;
	public Quote usersQuote;
	
	@Before
	public void setUp() throws NoQuotePermissionError {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 97669, "password", 1.0);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
	}

	
	@Test
	public void submitTestCorrecUser() {

		SubmitAction testAction = new SubmitAction(usersQuote, supervisor);
		testAction.validate();
		
		boolean expected = true;
		
		Assert.assertEquals(expected, testAction.validate());		
	}
	
	@Test
	public void submitTestIncorrecUser() {

		SubmitAction testAction = new SubmitAction(usersQuote, manager);
		testAction.validate();
		
		boolean expected = false;
		
		Assert.assertEquals(expected, testAction.validate());		
	}
	
}
