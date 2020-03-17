import Users.*;
import Quotation.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int zone = 4;
        String crop = "";
        String rejectReason = "Missing values";

        // We start by defining a user and supervisor. You will notice a new parameter. A supervisor. This decides
        // who the quote is escelated to. The new supervisor object sets itself as its own supervisor (yes that will need to change)
        // the user has the new supervisor set as its supervisor.
        //
        // In the end, we will need it so brokers dont have supervisors, but simply a zone, because any supervisor responsible
        // for a set zone should be able to interact with the quote. Only supervisors should have managers. (confusing enough?)
        User supervisor = new Supervisor("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
        User broker = new Broker("VCA", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0, supervisor);

        // a quote is now created by calling the brokers 'create quote class'. Supervisors also have this function.
        // right now the details are light, but we can have more details sent to the quote once the architecture is done
        // it makes sense for the broker to create the quote as they are the ones who make it
        Quote usersQuote = broker.createQuote(1, "barley");

        // so now we have a quote object. The point of the interface design pattern is to let lots of objects interact
        // with that quote
        // The broker wants to submit a quote for review by the supervisor. Its the broker that takes the action, so
        // we simply pass the brokers modifyQuote method the quote, and the command we want to execute
        // check the console messages labeled REF1 to see what this has done
        broker.modifyQuote( "submit", usersQuote);

        // Now interacting with the quote will go through the SupervisorState interface. The quote can't be resubmitted
        // so that function is left blank (asides a line out explaining this with REF2)
        supervisor.modifyQuote("submit", usersQuote);

        // And so on, now the supervisor will reject the quote. See the SupervisorState interface to see how that will effect
        // the quote
        supervisor.modifyQuote("reject", usersQuote);

        System.out.println("user quote status " + usersQuote.getStatus());

        // try experimenting by providing a user, calling the modify quote function, and assigning a command,
        // either submit, reject, climb, accept

        // I hope you can see how this flows and it makes sense. The next step is to decide how to limit some of these functions
        // so that only the relevant people can perform the relevant actions.
        // we also need to make it so that only some users can submit, brokers can all submit, but managers cant.
        // Do we have a manager class? Do we just assign a label to the supervisor class manager/non-manager - and put if statements?
        // My guess is that the composite design pattern should let us have a sub collection of user subclasses which can quote but IDK
        // Ignore all the zone stuff - the quote class will call that, it uses a factory pattern.

        // Other tasks i need to do are allowing supervisors to modify quote variables etc.

        // This should be fun :/







    }

}
