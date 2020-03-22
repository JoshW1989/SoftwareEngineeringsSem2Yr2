package Actions;

import Quotation.Quote;
import Users.User;

public class ActionFactory {

    public UserAction getAction (Quote quote, User user, String action) {

        if (action == "climb") {
            return new ClimbAction(quote, user);
        }

        return null;
    }

}
