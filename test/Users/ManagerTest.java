package Users;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ManagerTest {
	
	public Manager manager;
	public Supervisor supervisor;
	
	@Before
	public void setUp() {
		manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		supervisor = new  Supervisor("test", "John Smith", "supervisior@vca.com", "987654321",
				98009, "password", 1.0, 1, true);
	}

	// Ensures constuctor is assigng values
	@Test
	public void testManagerConstructor() {

		
		String expected = "manager";
		
		assertEquals(expected, manager.getRole());
	}
	
	// checks employees can be added to manager list
	@Test
	public void testManagerAddEmpSupervisor () throws WrongUserException {

		
		manager.addEmp(supervisor);
		
		assertEquals(1,manager.employees.size());
		
	}
	
	// checks manager cant add non-supervisors
	@Test(expected = WrongUserException.class)
	public void testManagerAddEmpBroker() throws WrongUserException {

		User broker = new  Broker("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		
		manager.addEmp(broker);
		
	}
	
	// checks that objects can be removed from the list
	@Test
	public void testManagerRemoveEmpSupervisor () throws WrongUserException {
		
		manager.addEmp(supervisor);
		manager.removeEmp(supervisor);
		assertEquals(0,manager.employees.size());
		
	}
	
	// checks that the list can be searched for a matching employee id
	@Test
	public void testManagerCheckEmployeeCorrect () throws WrongUserException {
		
		manager.addEmp(supervisor);
		boolean foundEmp = manager.checkEmployee(98009);
		assertEquals(true, foundEmp);
		
	}
	
	// checks that a non matching employee ID doesnt return a match
	@Test
	public void testManagerCheckEmployeeIncorrect () throws WrongUserException {
		
		manager.addEmp(supervisor);
		boolean foundEmp = manager.checkEmployee(999);
		assertEquals(false, foundEmp);
		
	}

}
