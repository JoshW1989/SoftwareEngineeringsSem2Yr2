package Users;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class BrokerTest {

	@Test
	public void testConstructorCommission() {
		//
		User broker = new  Broker("test", "John Smith", "broker@vca.com", "987654321", 98009, "password", 1.0);
		double expected = 1.0;
	
		Assert.assertEquals(expected, broker.getCommission(), 0);
	}
	
	// checks that method calls the super class implementation.
	// This method is designed for managers only, but is shared for the composite design structure
	@Test(expected = UnsupportedOperationException.class)
	public void testBrokerCheckEmployeeErrors() {
		User broker = new Broker("test", "John Smith", "broker@vca.com", "987654321", 98009, "password", 1.0);
		broker.checkEmployee(1);
		
	}


}
