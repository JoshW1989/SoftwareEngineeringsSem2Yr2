package Actions;

import static org.junit.Assert.*;

import org.junit.Test;

import Quotation.IncorrectQuoteStateError;
import Quotation.Quote;
import Users.Broker;
import Users.Manager;
import Users.Supervisor;
import Users.User;
import Users.WrongUserException;
import junit.framework.Assert;

public class ActionTestCases {

	@Test
	public void testSubmitQuote() throws IncorrectQuoteStateError {
		
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);
		ActionFactory myFactory = new ActionFactory();

		UserAction usersubmits = myFactory.getAction(quote, broker, "submit");
		usersubmits.execute("");

		String expectedResult = "PENDING";
		String testResult = quote.getStatus();

		Assert.assertEquals("Quote has been submitted and is now pending.", expectedResult, testResult);
		
	}
	
	@Test
	public void testRejectRequest() throws IncorrectQuoteStateError {
		
		User supervisor = new Supervisor("VCA", "Mr. Jeffrey Jordan", "jefferyjordan@vca.com", "123456789", 381534, "password", 5.0,1, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);

		ActionFactory myFactory = new ActionFactory();

        UserAction usersubmits = myFactory.getAction(quote, broker, "submit");
        usersubmits.execute("");

        UserAction supervisorclimbs = myFactory.getAction(quote, supervisor, "reject");
        supervisorclimbs.execute("because");

        String expectedResult = "REJECTED";
        String testResult = quote.getStatus();

        Assert.assertEquals("Quote has been submitted and has been rejected.", expectedResult, testResult);
        
	}

	@Test
	public void testApproveRequest() throws IncorrectQuoteStateError {
		
		User supervisor = new Supervisor("VCA", "Mr. Jeffrey Jordan", "jefferyjordan@vca.com", "123456789", 381534, "password", 5.0, 1, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);

		ActionFactory myFactory = new ActionFactory();

        UserAction userSubmission = myFactory.getAction(quote, broker, "submit");
        userSubmission.execute("");
        
        UserAction supervisorApproval = myFactory.getAction(quote, supervisor, "accept");
        supervisorApproval.execute("");
        
        String expectedResult = "APPROVED";

        String testResult = quote.getStatus();

        Assert.assertEquals("Quote has been submitted and has been approved.", expectedResult, testResult);
        
	}
	
	@Test
	public void testClimbRejectRequest() throws WrongUserException, IncorrectQuoteStateError {
		
		Manager manager = new Manager("VCA", "Mr. Douglas Jackson", "douglasjackson@vca.com", "987654321", 98009, "password", 5.0);
		User supervisor = new Supervisor("VCA", "Mr. Jeffrey Jordan", "jefferyjordan@vca.com", "123456789", 381534, "password", 5.0, 1, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);

		manager.addEmp(supervisor);
		
		ActionFactory myFactory = new ActionFactory();

        UserAction userSubmission = myFactory.getAction(quote, broker, "submit");
        userSubmission.execute("");    
        
        UserAction supervisorApproval = myFactory.getAction(quote, supervisor, "climb");
        supervisorApproval.execute("");
       
        UserAction managerrejects = myFactory.getAction(quote, manager, "reject");
        managerrejects.execute("because");
        
        String expectedResult = "REJECTED";
        String testResult = quote.getStatus();

        Assert.assertEquals("Quote has been climbed and has been rejected.", expectedResult, testResult);
        
	}
	
	@Test
	public void testClimbAcceptRequest() throws WrongUserException, IncorrectQuoteStateError {
		
		Manager manager = new Manager("VCA", "Mr. Douglas Jackson", "douglasjackson@vca.com", "987654321", 98009, "password", 5.0);
		User supervisor = new Supervisor("VCA", "Mr. Jeffrey Jordan", "jefferyjordan@vca.com", "123456789", 381534, "password", 5.0, 1, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);

		manager.addEmp(supervisor);
		
		ActionFactory myFactory = new ActionFactory();

        UserAction userSubmission = myFactory.getAction(quote, broker, "submit");
        userSubmission.execute("");    
        
        UserAction supervisorApproval = myFactory.getAction(quote, supervisor, "climb");
        supervisorApproval.execute("");
       
        UserAction managerrejects = myFactory.getAction(quote, manager, "accept");
        managerrejects.execute("because");
        
        String expectedResult = "APPROVED";
        String testResult = quote.getStatus();

        Assert.assertEquals("Quote has been climbed and has been approved.", expectedResult, testResult);
        
	}
	
	@Test
	public void testQuoteAndSupervisorZoneComparison() throws IncorrectQuoteStateError {
		
		User supervisor = new Supervisor("VCA", "Mr. Maurice Pippen", "mauricepippen@vca.com", "2354", 390674, "password", 5.0, 2, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 3);

		ActionFactory myFactory = new ActionFactory();

        UserAction userSubmission = myFactory.getAction(quote, broker, "submit");
        userSubmission.execute("");
        
        UserAction supervisorApproval = myFactory.getAction(quote, supervisor, "accept");
        supervisorApproval.execute("");
       
        boolean expectedResult = false;
        boolean testResult = supervisorApproval.validate();

        Assert.assertEquals("Exception is thrown as quote zone does not match supervisor zone.", expectedResult, testResult);
        
	}

}
