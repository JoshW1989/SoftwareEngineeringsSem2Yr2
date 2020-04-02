package Actions;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Quotation.NoQuotePermissionError;
import Quotation.Quote;
import Users.Manager;
import Users.Supervisor;
import Users.User;

public class ClimbActionTest {

	public User supervisor;
	public Manager manager;
	public Quote usersQuote;
	
	@Before
	public void setUp() throws NoQuotePermissionError {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
	}

	// checks correct supervisor passes validation
	@Test
	public void climbTestCorrecSupervisor() {

		ClimbAction testAction = new ClimbAction(usersQuote, supervisor);
		
		testAction.validate();
		boolean expected = true;
		
		Assert.assertEquals(expected, testAction.validate());		
	}
	
	// checks supervisor not assigned the quotes zone, fails validation
	@Test
	public void climbTestIncorrectZone() throws NoQuotePermissionError {
		usersQuote = new Quote(supervisor, "Barley", 2, 52);
		ClimbAction testAction = new ClimbAction(usersQuote, supervisor);
		
		testAction.validate();
		boolean expected = false;
		
		Assert.assertEquals(expected, testAction.validate());		
	}
	
	// checks user who can't climb quotes fails validation
	@Test
	public void climbTestIncorrectUser() {

		ClimbAction testAction = new ClimbAction(usersQuote, manager);
		
		testAction.validate();
		boolean expected = false;
		
		Assert.assertEquals(expected, testAction.validate());		
	}
	


}
