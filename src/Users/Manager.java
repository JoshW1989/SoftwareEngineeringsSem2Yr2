package Users;

import java.util.ArrayList;

public class Manager extends User{

	protected ArrayList<User> employees;

	
	
    public Manager(String company, String name, String email, String quickCall, int userId, String password,
                      double commission)
    {
        super(company, name, email, quickCall, userId, password, commission);

        setRole("manager");
        setCanRequest(false);
        employees = new ArrayList<User>();

    }

    // ensures only supervisors can be added as employees
    public void addEmp(User employee) throws WrongUserException {
    	if (employee.getRole() == "supervisor") {	
    		employees.add(employee);
    	}
    	else {
    		throw new WrongUserException("Only supervisors can be added as employees.");
    	}
    }

    public void removeEmp(User employee) {
    	employees.remove(employee);
    }
    
    // returns true if 2 employee objects have matching ID's
    public boolean checkEmployee(int id) {

        boolean hasEmployee = false;

        for (User x: employees) {
            if (x.getUserId() == id) {
                hasEmployee = true;
            }
        }

        return hasEmployee;

    }



}
