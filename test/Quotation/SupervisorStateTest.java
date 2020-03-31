package Quotation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Actions.ActionFactory;
import Actions.UserAction;
import Users.Supervisor;
import Users.User;

public class SupervisorStateTest {

	@Test
	public void supervisorClimbQuoteSupervisorChangeTest() throws IncorrectQuoteStateError {
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("Climbed quote");
        
        int expected = 98009;
        
        Assert.assertEquals(expected, usersQuote.getSupervisor().getUserId());
		
	}
	
	@Test
	public void supervisorClimbQuoteStateChangeTest() throws IncorrectQuoteStateError {
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("Climbed quote");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof ManagerState);
		
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void supervisorSubmitErrorTest() throws IncorrectQuoteStateError {
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
		
	}
	
	@Test
	public void supervisorRejectQuoteStateChangeTest() throws IncorrectQuoteStateError {
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction testReject = actionFactory.getAction(usersQuote, supervisor, "reject");
        testReject.execute("Rejected quote");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof ApplicantState);
		
	}
	
	@Test
	public void supervisorAcceptQuoteStateChangeTest() throws IncorrectQuoteStateError {
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction testAccept = actionFactory.getAction(usersQuote, supervisor, "accept");
        testAccept.execute("Accepted quote");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof PolicyState);
		
	}

}
