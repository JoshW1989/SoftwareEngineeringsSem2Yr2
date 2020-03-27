package Users;

import Quotation.*;
import java.util.ArrayList;

public class Supervisor extends User {

    private ArrayList<User> users;

    //Constructor

    public Supervisor(String company, String name, String email, String quickCall, int userId, String password,
                      double commission, int zone, boolean request)
    {
        super(company, name, email, quickCall, userId, password, commission);
        //validate to ensure that the user is a supervisor.
        setSupervisor(this);
        setRole("supervisor");
        setZone(zone);
        setCanRequest(request);
        //users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

}
