package Quotation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Actions.ActionFactory;
import Actions.UserAction;
import Users.Manager;
import Users.Supervisor;
import Users.User;
import Users.WrongUserException;

public class ManagerStateTest {
	
	public User supervisor;
	public Quote usersQuote;

	
	@Before
	public void setUp() throws WrongUserException, IncorrectQuoteStateError, NoQuotePermissionError {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);	
        
	}

	// checks reject method executes
	@Test
	public void managerRejectTest() throws IncorrectQuoteStateError, WrongUserException {
        
		ManagerState testState = new ManagerState(usersQuote);
		testState.reject("Rejecting quote management state");
        
        String expected = "Rejecting quote management state";
        
        Assert.assertEquals(expected, usersQuote.getRejectReason());
	}
	
	// check accept executes and assigns quote new state
	@Test
	public void managerAcceptQuotePolicyStateTest() throws IncorrectQuoteStateError, WrongUserException {
        
		ManagerState testState = new ManagerState(usersQuote);
		testState.accept();
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof PolicyState);
	
	}
	
	// checks quote at manager state cant be climbed, throws error
	@Test(expected = IncorrectQuoteStateError.class)
	public void managerClimbErrorTest() throws IncorrectQuoteStateError{
		
		ManagerState testState = new ManagerState(usersQuote);
		testState.climb("climbing", supervisor);
		
	}
	
	// checks error when trying to submit in manager state
	@Test(expected = IncorrectQuoteStateError.class)
	public void managerSubmitErrorTest() throws IncorrectQuoteStateError{
		
		ManagerState testState = new ManagerState(usersQuote);
		testState.submit();
		
	}
	
}