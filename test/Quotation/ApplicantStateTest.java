package Quotation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Actions.ActionFactory;
import Actions.UserAction;
import Users.Broker;
import Users.Supervisor;
import Users.User;

public class ApplicantStateTest { 

	public User supervisor;
	public Quote usersQuote;
	public ActionFactory actionFactory;
	
	@Before
	public void SetUp() {
		
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
		actionFactory = new ActionFactory();
		
	}
	
	// Some supervisors can raise and climb quotes. This tests that the QuoteState prevents a quote being
	// climbded before review
	@Test(expected = IncorrectQuoteStateError.class)
	public void applicantClimbTest() throws IncorrectQuoteStateError {
		


        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("");
		
	}
	
	@Test
	public void applicantSubmitTest() throws IncorrectQuoteStateError {
		

        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
        
        String expected = "PENDING";
        
        Assert.assertEquals(expected, usersQuote.getStatus());
		
	}
	
	@Test
	public void applicantRejectTest() throws IncorrectQuoteStateError {
		

        UserAction testReject = actionFactory.getAction(usersQuote, supervisor, "reject");
        testReject.execute("rejected");
        
        String expected = "REJECTED BY BROKER";
        
        Assert.assertEquals(expected, usersQuote.getRejectReason());
		
	}
	
	
	@Test
	public void applicantSubmitQuoteStatusChangeTest() throws IncorrectQuoteStateError {
	

        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
        
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof SupervisorState);
		
	}
	
	
	@After
	public void TearDown() {
		supervisor = null;
		usersQuote = null;
		actionFactory = null;
	}
	
	
	

}
