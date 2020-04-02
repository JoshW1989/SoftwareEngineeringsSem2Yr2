package Quotation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import Users.Supervisor;
import Users.User;

public class QuoteTest {

	@Test
	public void newQuoteHasPermission() throws NoQuotePermissionError {
		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, true);
		Quote usersQuote = new Quote(supervisor, "Barley", 1, 52);
		
		double expected = 52.00;
		
		Assert.assertEquals(expected, usersQuote.getHectares(), 0);
		
	}
	
	// checks quote stops new quotes beng assigned to those without permission to request
	@Test(expected = NoQuotePermissionError.class)
	public void newQuoteIncorrectPermission() throws NoQuotePermissionError {

		User supervisor = new Supervisor("vca", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, 1, false);
		Quote usersQuote = new Quote(supervisor, "Barley", 1, 52);
		
	}

}
