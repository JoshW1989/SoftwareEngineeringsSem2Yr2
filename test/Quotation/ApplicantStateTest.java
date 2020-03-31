package Quotation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Actions.ActionFactory;
import Actions.UserAction;
import Users.Broker;
import Users.Supervisor;
import Users.User;

public class ApplicantStateTest { 

	
	// Some supervisors can raise and climb quotes. This tests that the QuoteState prevents a quote being
	// climbded before review
	@Test(expected = IncorrectQuoteStateError.class)
	public void applicantClimbTest() throws IncorrectQuoteStateError {
		
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("");
		
	}
	
	@Test
	public void applicantSubmitTest() throws IncorrectQuoteStateError {
		
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
        
        String expected = "PENDING";
        
        Assert.assertEquals(expected, usersQuote.getStatus());
		
	}
	
	
	@Test
	public void applicantSubmitQuoteStatusChangeTest() throws IncorrectQuoteStateError {
		
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
        
        String expected = "PENDING";
        
        Assert.assertEquals(expected, usersQuote.getStatus());
		
	}
	
	
	
	

}
