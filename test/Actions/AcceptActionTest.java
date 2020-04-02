package Actions;

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

public class AcceptActionTest {
	
	public User supervisor;
	public Manager manager;
	public Quote usersQuote;
	
	@Before
	public void setUp() throws NoQuotePermissionError {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
	}

	// Manager tries to accept a quote that has not been submitted for review
	@Test
	public void checkIncorrectState() {

		AcceptAction testAction = new AcceptAction(usersQuote, manager);
		
		testAction.validate();
		boolean expected = false;
		
		Assert.assertEquals("Cant accept before submitting quote",expected, testAction.validate());		
	}
	
	// Manager accepts a quote climbed by his employee
	@Test
	public void acceptActionCorrectManager() throws IncorrectQuoteStateError, WrongUserException {
		
		AcceptAction testAction = new AcceptAction(usersQuote, manager);
		
		manager.addEmp(supervisor);
		usersQuote.submitQuote();
		usersQuote.climbQuote("", supervisor);
		testAction.validate();
		
		boolean expected = true;
		
		Assert.assertEquals("Employee is part of managers staff", expected, testAction.validate());	
	}
	
	// Manager accepts quote raised by someone who isnt his employee
	@Test
	public void acceptActionInorrectManager() throws IncorrectQuoteStateError, WrongUserException {
		
		AcceptAction testAction = new AcceptAction(usersQuote, manager);
		
		usersQuote.submitQuote();
		usersQuote.climbQuote("", supervisor);
		testAction.validate();
		
		boolean expected = false;
		
		Assert.assertEquals("Employee isnt part of manager list", expected, testAction.validate());	
	}
	
	// Supervisor accepts submitted quote belonging to his zone assignment
	@Test
	public void acceptActionSupervisorCorrectZone() throws IncorrectQuoteStateError, WrongUserException {
		
		AcceptAction testAction = new AcceptAction(usersQuote, supervisor);
		
		usersQuote.submitQuote();
		testAction.validate();
		
		boolean expected = true;
		
		Assert.assertEquals("supervisor correct zone", expected, testAction.validate());	
	}
	
	// Supervisor accepts submitted quote not belonging to his zone assignment
	@Test
	public void acceptActionSupervisorIncorrectZone() throws IncorrectQuoteStateError, WrongUserException, NoQuotePermissionError {
		
		Quote usersQuote = new Quote(supervisor, "Barley", 2, 52);
		AcceptAction testAction = new AcceptAction(usersQuote, supervisor);
		
		usersQuote.submitQuote();
		testAction.validate();
		
		boolean expected = false;
		
		Assert.assertEquals("Supervisor wrong zone", expected, testAction.validate());	
	}
	
	// Broker tries to accepts a submitted quote
	@Test
	public void acceptActionWrongUser() throws IncorrectQuoteStateError, WrongUserException {

		User broker = new  Broker("test", "John Smith", "broker@vca.com", "987654321", 98009, "password", 1.0);
		
		AcceptAction testAction = new AcceptAction(usersQuote, broker);
		
		usersQuote.submitQuote();
		testAction.validate();
		
		boolean expected = false;
		
		Assert.assertEquals("Users cant accept quotes", expected, testAction.validate());	
	}

}
