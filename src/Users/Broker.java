package Users;

public class Broker extends User {


    //Constructor

    public Broker(String company, String name, String email, String quickCall, int userId, String password, double commission)
    {
        super(company, name, email, quickCall, userId, password, commission);
        setRole("broker");
        setZone(0);
        setCanRequest(true);

    }

}
