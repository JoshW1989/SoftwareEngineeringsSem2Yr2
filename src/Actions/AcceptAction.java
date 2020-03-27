package Actions;

import Quotation.Quote;
import Users.User;

public class AcceptAction extends UserAction {

    public AcceptAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(){
        if (this.validate()){
            getActionQuote().acceptQuote();
        }
    }

    public boolean validate(){
        if (getRequester().getRole() == "supervisor") {
            if(getRequester().getZone() == getActionQuote().getZone()) {
                return true;
            }
        }
        //THIS WONT WORK
        return false;
        // check that the requester is a supervisor from the relevant zone or a manager
        // return true if so

    }

}