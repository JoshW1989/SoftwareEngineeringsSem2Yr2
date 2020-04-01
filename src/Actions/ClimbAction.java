package Actions;

import Quotation.IncorrectQuoteStateError;
import Quotation.Quote;
import Users.User;


public class ClimbAction extends UserAction {

    public ClimbAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason) throws IncorrectQuoteStateError{
        if (this.validate()){
            getActionQuote().climbQuote(reason, getRequester());
        }
    }

    public boolean validate(){

        if (getRequester().getRole() == "supervisor") {
            if(getRequester().getZone() == getActionQuote().getZone()) {
                return true;
            }
        }
        return false;

    }

}
