package Quotation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Users.Supervisor;
import Users.User;

public class ApplicantStateTest { 

	public User supervisor;
	public Quote usersQuote;
	
	@Before
	public void setUp() {
		
		supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		usersQuote = new Quote(supervisor, "Barley", 1, 52);
		
	}
	
	// Some supervisors can raise and climb quotes. This tests that the QuoteState prevents a quote being
	// climbded before review
	@Test(expected = IncorrectQuoteStateError.class)
	public void applicantClimbTest() throws IncorrectQuoteStateError {
		
		ApplicantState testState = new ApplicantState(usersQuote);

		testState.climb("Climbed", supervisor);
		
	}
	
	@Rule
	public ExpectedException expected = ExpectedException.none();
	
	@Test(expected = IncorrectQuoteStateError.class)
	public void applicantClimbErrorMessageTest() throws IncorrectQuoteStateError {
		
		ApplicantState testState = new ApplicantState(usersQuote);

		testState.climb("Climbed", supervisor);
		
		String expectedMessage = "This operation can not be performed while the quoute is in Applicant state";
		
		expected.expectMessage(expectedMessage);
		
	}
	
	@Test
	public void applicantSubmitTest() throws IncorrectQuoteStateError {
		
		ApplicantState testState = new ApplicantState(usersQuote);
		
		testState.submit();
        String expected = "PENDING";
        
        Assert.assertEquals(expected, usersQuote.getStatus());
		
	}
	
	
	
	@Test
	public void applicantSubmitQuoteStatusChangeTest() throws IncorrectQuoteStateError {
	
		ApplicantState testState = new ApplicantState(usersQuote);
		testState.submit();
        
        Assert.assertTrue(usersQuote.getQuoteState() instanceof SupervisorState);

	}
	
	@Test
	public void applicantRejectTest() throws IncorrectQuoteStateError {
	
		ApplicantState testState = new ApplicantState(usersQuote);
		testState.reject("rejected");
        
        String expected = "REJECTED BY BROKER";
        
        Assert.assertEquals(expected, usersQuote.getRejectReason());
	}
	
	
	@After
	public void tearDown() {
		supervisor = null;
		usersQuote = null;
	}
	
	
	

}
