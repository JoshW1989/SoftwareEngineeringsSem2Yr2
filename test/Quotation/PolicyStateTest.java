package Quotation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Actions.ActionFactory;
import Actions.UserAction;
import Users.Manager;
import Users.Supervisor;
import Users.User;
import Users.WrongUserException;

public class PolicyStateTest {


	@Test(expected = IncorrectQuoteStateError.class)
	public void policyAcceptQuoteErrorTest() throws IncorrectQuoteStateError{
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction accept = actionFactory.getAction(usersQuote, supervisor, "accept");
        accept.execute("Accepted quote");
        
        UserAction testAccept = actionFactory.getAction(usersQuote, supervisor, "accept");
        testAccept.execute("");
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void policyRejectQuoteErrorTest() throws IncorrectQuoteStateError{
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction accept = actionFactory.getAction(usersQuote, supervisor, "accept");
        accept.execute("");
        
        UserAction testReject = actionFactory.getAction(usersQuote, supervisor, "reject");
        testReject.execute("Rejecting policy");
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void policySubmitQuoteErrorTest() throws IncorrectQuoteStateError{
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction accept = actionFactory.getAction(usersQuote, supervisor, "accept");
        accept.execute("");
        
        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void policyClimbQuoteErrorTest() throws IncorrectQuoteStateError{
	
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1);
		
        ActionFactory actionFactory = new ActionFactory();

        UserAction submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        UserAction accept = actionFactory.getAction(usersQuote, supervisor, "accept");
        accept.execute("");
        
        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("Climbing Policy");
	}

}
