import Actions.ActionFactory;
import Actions.UserAction;
import Users.*;
import Quotation.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int zone = 4;
        String crop = "";
        String rejectReason = "Missing values";

       Manager manager1 = new Manager("VCA", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0);
        User supervisor = new Supervisor("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0,1, true);
        User broker = new Broker("VCA", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0);
        User broker1 = new Broker("VCA", "broker 1", "broker@vca.com", "987654321", 98009, "password", 5.0);
        User broker2 = new Broker("VCA", "broker 2", "broker@vca.com", "987654321", 98009, "password", 5.0);

        User x = manager1;
        //manager1.addEmp(supervisor);
        
        //Systx.)

        Quote usersQuote = new Quote(broker, "Barley", 1);
        

        ActionFactory myFactory = new ActionFactory();

        UserAction usersubmits = myFactory.getAction(usersQuote, broker, "submit");
        usersubmits.execute("");

        UserAction supervisorclimbs = myFactory.getAction(usersQuote, supervisor, "climb");
        supervisorclimbs.execute("because");

        UserAction managerrejects = myFactory.getAction(usersQuote, manager1, "reject");
        managerrejects.execute("because");
    }

}
