package Actions;

import Quotation.Quote;
import Users.User;

// User sends a command and the correct action class is returned part of factory design pattern
public class ActionFactory {

    public UserAction getAction (Quote quote, User user, String action) {

        if (action == "climb") {
            return new ClimbAction(quote, user);
        }
        if (action == "accept") {
            return new AcceptAction(quote, user);
        }
        if (action == "reject") {
            return new RejectAction(quote, user);
        }
        if (action == "submit") {
            return new SubmitAction(quote, user);
        }

        return null;
    }

}
