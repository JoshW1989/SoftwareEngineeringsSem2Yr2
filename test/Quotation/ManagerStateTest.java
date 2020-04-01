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
	public Manager manager;
	public Quote usersQuote;
	public ActionFactory actionFactory;
	public UserAction submit;
	public UserAction climb;
	
	@Before
	public void setUp() throws WrongUserException, IncorrectQuoteStateError {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		manager = new Manager("VCA", "John Smith", "broker@vca.com", "968885", 97759, "password", 5.0);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
		
		manager.addEmp(supervisor);
		
		actionFactory = new ActionFactory();
		
		submit = actionFactory.getAction(usersQuote, supervisor, "submit");
        submit.execute("");
        climb = actionFactory.getAction(usersQuote, supervisor, "climb");
        climb.execute("Climbed quote");  
        
	}

	@Test
	public void managerRejectQuoteErrorTest() throws IncorrectQuoteStateError, WrongUserException {
        
        UserAction testReject = actionFactory.getAction(usersQuote, manager, "reject");
        testReject.execute("Rejecting quote as manager");
        
        String expected = "Rejecting quote as manager";
        
        Assert.assertEquals(expected, usersQuote.getRejectReason());
	}
	
	@Test
	public void managerAcceptQuotePolicyStateTest() throws IncorrectQuoteStateError, WrongUserException {
        
        UserAction testAccept = actionFactory.getAction(usersQuote, manager, "accept");
        testAccept.execute("");
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof PolicyState);
	
	}
	
}