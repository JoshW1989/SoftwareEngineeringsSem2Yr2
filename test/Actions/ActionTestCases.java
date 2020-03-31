package Actions;

import static org.junit.Assert.*;

import org.junit.Test;

import Quotation.Quote;
import Users.Broker;
import Users.Manager;
import Users.Supervisor;
import Users.User;
import junit.framework.Assert;

public class ActionTestCases {

	@Test
	public void testSubmitQuote() {
		//Elements of a test case
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);
		ActionFactory myFactory = new ActionFactory();

		//Test Input
		UserAction usersubmits = myFactory.getAction(quote, broker, "submit");
		usersubmits.execute("");

		//Test Expectation
		String expectedResult = "PENDING";

		//Test Result
		String testResult = quote.getStatus();

		//Compare the result against the expectation
		Assert.assertEquals("Quote has been submitted and is now pending.", expectedResult, testResult);
	}
	
	@Test
	public void testRejectRequest() {
		//Elements of a test case
		User supervisor = new Supervisor("VCA", "Mr. Jeffrey Jordan", "jefferyjordan@vca.com", "123456789", 381534, "password", 5.0,1, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);

		ActionFactory myFactory = new ActionFactory();

        UserAction usersubmits = myFactory.getAction(quote, broker, "submit");
        usersubmits.execute("");

        UserAction supervisorclimbs = myFactory.getAction(quote, supervisor, "reject");
        supervisorclimbs.execute("because");

        //Test Expectation
        String expectedResult = "REJECTED";

        //Test Result
        String testResult = quote.getStatus();

        //Compare the result against the expectation
        Assert.assertEquals("Quote has been submitted and has been rejected.", expectedResult, testResult);
	}

	@Test
	public void testApproveRequest() {
		//Elements of a test case
		User supervisor = new Supervisor("VCA", "Mr. Jeffrey Jordan", "jefferyjordan@vca.com", "123456789", 381534, "password", 5.0, 1, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 1);

		ActionFactory myFactory = new ActionFactory();

        UserAction userSubmission = myFactory.getAction(quote, broker, "submit");
        userSubmission.execute("");
        
        UserAction supervisorApproval = myFactory.getAction(quote, supervisor, "accept");
        supervisorApproval.execute("");
        
        //Test Expectation
        String expectedResult = "APPROVED";

        //Test Result
        String testResult = quote.getStatus();

        //Compare the result against the expectation
        Assert.assertEquals("Quote has been submitted and has been approved.", expectedResult, testResult);
	}
	
	@Test
	public void testClimbRejectRequest() {
		//Elements of a test case
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
        
        //Test Expectation
        String expectedResult = "REJECTED";

        //Test Result
        String testResult = quote.getStatus();

        //Compare the result against the expectation
        Assert.assertEquals("Quote has been climbed and has been rejected.", expectedResult, testResult);
	}
	
	@Test
	public void testClimbAcceptRequest() {
		//Elements of a test case
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
        
        //Test Expectation
        String expectedResult = "APPROVED";

        //Test Result
        String testResult = quote.getStatus();

        //Compare the result against the expectation
        Assert.assertEquals("Quote has been climbed and has been approved.", expectedResult, testResult);
	}
	
	@Test
	public void testQuoteAndSupervisorZoneComparison() {
		//Elements of a test case
		User supervisor = new Supervisor("VCA", "Mr. Maurice Pippen", "mauricepippen@vca.com", "2354", 390674, "password", 5.0, 2, true);
		User broker = new Broker("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		Quote quote = new Quote(broker, "Barley", 3);

		ActionFactory myFactory = new ActionFactory();

        UserAction userSubmission = myFactory.getAction(quote, broker, "submit");
        userSubmission.execute("");
        
        UserAction supervisorApproval = myFactory.getAction(quote, supervisor, "accept");
        supervisorApproval.execute("");
       
        //Test Expectation
        boolean expectedResult = false;

        //Test Result
        boolean testResult = supervisorApproval.validate();
        
        //Compare the result against the expectation
        Assert.assertEquals("Exception is thrown as quote zone does not match supervisor zone.", expectedResult, testResult);
	}

}
