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
	public ActionFactory actionFactory;
	public UserAction submit;
	public UserAction accept;
	
	@Before
	public void SetUp() throws IncorrectQuoteStateError {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
		
        actionFactory = new ActionFactory();

        submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        
        accept = actionFactory.getAction(usersQuote, supervisor, "accept");
        accept.execute("");
	}

	
	@Test(expected = IncorrectQuoteStateError.class)
	public void policyRejectQuoteErrorTest() throws IncorrectQuoteStateError{
	
        
        UserAction testReject = actionFactory.getAction(usersQuote, supervisor, "reject");
        testReject.execute("Rejecting policy");
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void policySubmitQuoteErrorTest() throws IncorrectQuoteStateError{
	

        UserAction testSubmit = actionFactory.getAction(usersQuote, supervisor, "submit");
        testSubmit.execute("");
	}
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void policyClimbQuoteErrorTest() throws IncorrectQuoteStateError{
	

        
        UserAction testClimb = actionFactory.getAction(usersQuote, supervisor, "climb");
        testClimb.execute("Climbing Policy");
	}

}
