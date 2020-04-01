package Quotation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Actions.ActionFactory;
import Actions.UserAction;
import Users.Supervisor;
import Users.User;

public class SupervisorStateTest {
	
	public User supervisor;
	public Quote usersQuote;
	public ActionFactory actionFactory;
	
	@Before
	public void setUp() throws IncorrectQuoteStateError {
		
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
		
        actionFactory = new ActionFactory();

		
	}

	@Test
	public void supervisorClimbQuoteSupervisorChangeTest() throws IncorrectQuoteStateError {
	
        SupervisorState testState = new SupervisorState(usersQuote); 
        testState.climb("Climbing quote", supervisor);
       
        int expected = 98009;
        
        Assert.assertEquals(expected, usersQuote.getSupervisor().getUserId());
		
	}
	
	@Test
	public void supervisorClimbQuoteStateChangeTest() throws IncorrectQuoteStateError {
	
        
        SupervisorState testState = new SupervisorState(usersQuote); 
        testState.climb("Climbing quote", supervisor);
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof ManagerState);
		
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void supervisorSubmitErrorTest() throws IncorrectQuoteStateError {
	
        
        SupervisorState testState = new SupervisorState(usersQuote); 
        testState.submit();
		
	}
	
	@Test
	public void supervisorRejectQuoteStateChangeTest() throws IncorrectQuoteStateError {
	
        
        SupervisorState testState = new SupervisorState(usersQuote); 
        testState.reject("Rejecting quote");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof ApplicantState);
		
	}
	
	@Test
	public void supervisorAcceptQuoteStateChangeTest() throws IncorrectQuoteStateError {

        
        SupervisorState testState = new SupervisorState(usersQuote); 
        testState.accept();
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof PolicyState);
		
	}

}
