package Users;

import Quotation.*;
import java.util.ArrayList;

public class Supervisor extends User {

    public Supervisor(String company, String name, String email, String quickCall, int userId, String password,
                      double commission, int zone, boolean request)
    {
        super(company, name, email, quickCall, userId, password, commission);
        setRole("supervisor");
        setZone(zone);
        setCanRequest(request);

    }

}
