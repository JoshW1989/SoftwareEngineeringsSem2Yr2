package Users;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManagerTest {

	@Test
	public void testManagerConstructor() {
		User manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		
		String expected = "manager";
		
		assertEquals(expected, manager.getRole());
	}
	
	@Test
	public void testManagerAddEmpSupervisor () throws WrongUserException {
		Manager manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		User supervisor = new  Supervisor("test", "John Smith", "supervisior@vca.com", "987654321",
				98009, "password", 1.0, 1, true);
		
		manager.addEmp(supervisor);
		
		assertEquals(1,manager.employees.size());
		
	}
	
	@Test(expected = WrongUserException.class)
	public void testManagerAddEmpBroker() throws WrongUserException {
		Manager manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		User broker = new  Broker("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		
		manager.addEmp(broker);
		
	}
	
	@Test
	public void testManagerRemoveEmpSupervisor () throws WrongUserException {
		Manager manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		User supervisor = new  Supervisor("test", "John Smith", "supervisior@vca.com", "987654321",
				98009, "password", 1.0, 1, true);
		
		manager.addEmp(supervisor);
		manager.removeEmp(supervisor);
		assertEquals(0,manager.employees.size());
		
	}
	
	@Test
	public void testManagerCheckEmployeeCorrect () throws WrongUserException {
		Manager manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		User supervisor = new  Supervisor("test", "John Smith", "supervisior@vca.com", "987654321",
				98009, "password", 1.0, 1, true);
		
		manager.addEmp(supervisor);
		boolean foundEmp = manager.checkEmployee(98009);
		assertEquals(true, foundEmp);
		
	}
	
	@Test
	public void testManagerCheckEmployeeIncorrect () throws WrongUserException {
		Manager manager = new  Manager("test", "John Smith", "manager@vca.com", "987654321", 98009, "password", 1.0);
		User supervisor = new  Supervisor("test", "John Smith", "supervisior@vca.com", "987654321",
				98009, "password", 1.0, 1, true);
		
		manager.addEmp(supervisor);
		boolean foundEmp = manager.checkEmployee(1);
		assertEquals(false, foundEmp);
		
	}

}
