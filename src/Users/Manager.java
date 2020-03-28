package Users;

import java.util.ArrayList;

public class Manager extends User{


    public Manager(String company, String name, String email, String quickCall, int userId, String password,
                      double commission)
    {
        super(company, name, email, quickCall, userId, password, commission);
        //validate to ensure that the user is a supervisor.
        setRole("manager");


    }

    public void addEmp(User employee) {
        employees.add(employee);
    }

    public void removeEmp(User employee) {
        employees.remove(employee);
    }

}
