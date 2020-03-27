package Users;

import Quotation.*;

public class Broker extends User {


    //Constructor

    public Broker(String company, String name, String email, String quickCall, int userId, String password, double commission, User supervisor)
    {
        super(company, name, email, quickCall, userId, password, commission);
        setSupervisor(supervisor);
        setRole("user");
        setZone(0);
        setCanRequest(true);

    }

    //Broker creates Insurance Quote
    //Return type is Quote
    //Quote instance and Quote data passed in as parameters

}
