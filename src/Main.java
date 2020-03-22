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

        User supervisor = new Supervisor("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
        User broker = new Broker("VCA", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, supervisor);

        //create an action class, that gets sent with all quote commands

        Quote usersQuote = broker.createQuote(1, "barley");

        ActionFactory myFactory = new ActionFactory();

        UserAction myAction = myFactory.getAction(usersQuote, broker, "climb");
        //myAction.execute("test");

    }

}
