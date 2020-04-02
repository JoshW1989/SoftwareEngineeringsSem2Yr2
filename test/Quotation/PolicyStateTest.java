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

public class PolicyStateTest {
	
	public User supervisor;
	public Quote usersQuote;
	
	@Before
	public void setUp() throws NoQuotePermissionError {
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
	}
	
	// Ensures quote cant be actioned without error
	@Test(expected = IncorrectQuoteStateError.class)
	public void policyRejectQuoteErrorTest() throws IncorrectQuoteStateError{
	
        PolicyState testPolicy = new PolicyState(usersQuote);
		testPolicy.reject("Rejected");

	}
	
	// Ensures quote cant be actioned without error
	@Test(expected = IncorrectQuoteStateError.class)
	public void policyAcceptQuoteErrorTest() throws IncorrectQuoteStateError{
	
		
        PolicyState testPolicy = new PolicyState(usersQuote);
		testPolicy.accept();
	}
	
	// Ensures quote cant be actioned without error
	@Test(expected = IncorrectQuoteStateError.class)
	public void policyClimbQuoteErrorTest() throws IncorrectQuoteStateError{
        
		PolicyState testPolicy = new PolicyState(usersQuote);
		testPolicy.climb("Climb reason", supervisor);
	}
	
	// Ensures quote cant be actioned without error
	@Test(expected = IncorrectQuoteStateError.class)
	public void policySubmitbQuoteErrorTest() throws IncorrectQuoteStateError{
        
		PolicyState testPolicy = new PolicyState(usersQuote);
		testPolicy.submit();
	}
	

}
