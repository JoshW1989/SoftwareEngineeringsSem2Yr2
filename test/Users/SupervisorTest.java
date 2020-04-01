package Users;

import static org.junit.Assert.*;

import org.junit.Test;

public class SupervisorTest {

	@Test
	public void testSupervisorConstructor() {

		User supervisor = new  Supervisor("vca", "John Smith", "supervisior@vca.com", "987654321",
				98009, "password", 1.0, 1, true);
		
				
		double expected = 5/100;
		
		assertEquals(expected, supervisor.getCommission(), 0);
	}


}
