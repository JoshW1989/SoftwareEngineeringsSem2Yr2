package Actions;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Quotation.IncorrectQuoteStateError;
import Quotation.NoQuotePermissionError;
import Quotation.Quote;
import Users.Broker;
import Users.Manager;
import Users.Supervisor;
import Users.User;
import Users.WrongUserException;

public class RejectActionTest {

	public User supervisor;
	public Manager manager;
	public Quote usersQuote;
	
	@Before
	public void setUp() throws NoQuotePermissionError {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
	}

	@Test
	public void checkIncorrectState() {

		RejectAction testAction = new RejectAction(usersQuote, manager);
		
		testAction.validate();
		boolean expected = false;
		
		Assert.assertEquals(expected, testAction.validate());		
	}
	
	
	@Test
	public void RejectActionCorrectManager() throws IncorrectQuoteStateError, WrongUserException {
		
		RejectAction testAction = new RejectAction(usersQuote, manager);
		manager.addEmp(supervisor);
		usersQuote.submitQuote();
		usersQuote.climbQuote("", supervisor);
		testAction.validate();
		
		boolean expected = true;
		
		Assert.assertEquals(expected, testAction.validate());	
	}
	
	@Test
	public void RejectActionInorrectManager() throws IncorrectQuoteStateError, WrongUserException {
		
		RejectAction testAction = new RejectAction(usersQuote, manager);
		usersQuote.submitQuote();
		usersQuote.climbQuote("", supervisor);
		testAction.validate();
		
		boolean expected = false;
		
		Assert.assertEquals(expected, testAction.validate());	
	}
	
	@Test
	public void RejectActionSupervisorCorrectZone() throws IncorrectQuoteStateError, WrongUserException {
		
		RejectAction testAction = new RejectAction(usersQuote, supervisor);
		usersQuote.submitQuote();
		testAction.validate();
		
		boolean expected = true;
		
		Assert.assertEquals(expected, testAction.validate());	
	}
	
	@Test
	public void RejectActionSupervisorIncorrectZone() throws IncorrectQuoteStateError, WrongUserException, NoQuotePermissionError {
		
		Quote usersQuote = new Quote(supervisor, "Barley", 2, 52);
		RejectAction testAction = new RejectAction(usersQuote, supervisor);
		usersQuote.submitQuote();
		testAction.validate();
		
		boolean expected = false;
		
		Assert.assertEquals(expected, testAction.validate());	
	}
	
	@Test
	public void RejectActionWrongUser() throws IncorrectQuoteStateError, WrongUserException {

		User broker = new  Broker("test", "John Smith", "broker@vca.com", "987654321", 98009, "password", 1.0);
		RejectAction testAction = new RejectAction(usersQuote, broker);
		usersQuote.submitQuote();
		testAction.validate();
		
		boolean expected = false;
		
		Assert.assertEquals(expected, testAction.validate());	
	}
}
