package Users;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class BrokerTest {

	@Test
	public void testConstructorComission() {
		//
		User broker = new  Broker("test", "John Smith", "broker@vca.com", "987654321", 98009, "password", 1.0);
		double expected = 1.0;
	
		Assert.assertEquals(expected, broker.getCommission(), 0);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testBrokerCheckEmployeeErrors() {
		User broker = new Broker("test", "John Smith", "broker@vca.com", "987654321", 98009, "password", 1.0);
		broker.checkEmployee(1);
		
	}


}
