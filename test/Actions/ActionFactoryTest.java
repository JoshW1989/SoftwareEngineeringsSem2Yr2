package Actions;

import static org.junit.Assert.*;

import org.junit.Test;

import Quotation.Quote;
import Quotation.SupervisorState;

import org.junit.Assert;
import org.junit.Before;

import Users.Manager;
import Users.Supervisor;
import Users.User;

public class ActionFactoryTest {

	public User supervisor;
	public Quote usersQuote;
	public ActionFactory testFactory;
	
	@Before
	public void setUp() {
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
		testFactory = new ActionFactory();
	}
	
	@Test
	public void actionFactoryIncorrectValueTest() {
		
		UserAction testAction = testFactory.getAction(usersQuote, supervisor, "invalid");
		
		UserAction expected = null;
		
		Assert.assertEquals(expected, testAction);	
	}
	
	@Test
	public void actionFactoryReturnsClimbTest() {
		
		UserAction testAction = testFactory.getAction(usersQuote, supervisor, "climb");
		
		Assert.assertTrue(testAction instanceof ClimbAction);
		
	}
	
	@Test
	public void actionFactoryReturnsRejectTest() {
		
		UserAction testAction = testFactory.getAction(usersQuote, supervisor, "reject");
		
		Assert.assertTrue(testAction instanceof RejectAction);
		
	}
	
	@Test
	public void actionFactoryReturnsAcceptTest() {
		
		UserAction testAction = testFactory.getAction(usersQuote, supervisor, "accept");
		
		Assert.assertTrue(testAction instanceof AcceptAction);
		
	}
	
	@Test
	public void actionFactoryReturnsSubmitTest() {
		
		UserAction testAction = testFactory.getAction(usersQuote, supervisor, "submit");
		
		Assert.assertTrue(testAction instanceof SubmitAction);
		
	}

}
