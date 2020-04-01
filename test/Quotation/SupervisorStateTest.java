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
	public UserAction submit;
	
	@Before
	public void SetUp() throws IncorrectQuoteStateError {
		
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
		
        actionFactory = new ActionFactory();

        submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
		
	}

	@Test
	public void supervisorClimbQuoteSupervisorChangeTest() throws IncorrectQuoteStateError {
	
        
        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("Climbed quote");
        
        int expected = 98009;
        
        Assert.assertEquals(expected, usersQuote.getSupervisor().getUserId());
		
	}
	
	@Test
	public void supervisorClimbQuoteStateChangeTest() throws IncorrectQuoteStateError {
	
        
        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("Climbed quote");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof ManagerState);
		
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void supervisorSubmitErrorTest() throws IncorrectQuoteStateError {
	
        
        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
		
	}
	
	@Test
	public void supervisorRejectQuoteStateChangeTest() throws IncorrectQuoteStateError {
	
        
        UserAction testReject = actionFactory.getAction(usersQuote, supervisor, "reject");
        testReject.execute("Rejected quote");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof ApplicantState);
		
	}
	
	@Test
	public void supervisorAcceptQuoteStateChangeTest() throws IncorrectQuoteStateError {

        
        UserAction testAccept = actionFactory.getAction(usersQuote, supervisor, "accept");
        testAccept.execute("Accepted quote");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof PolicyState);
		
	}

}
