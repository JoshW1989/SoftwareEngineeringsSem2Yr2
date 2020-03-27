package Actions;

import Quotation.Quote;
import Users.User;

public class RejectAction extends UserAction {

    public RejectAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason){
        if (this.validate()){
            getActionQuote().rejectQuote(reason);
        }
    }

    public boolean validate(){

        if (getRequester().getRole() == "manager") {
            return true;
        }
        else if (getRequester().getRole() == "supervisor" & getRequester().getZone() == getActionQuote().getZone()) {
            return true;
        }
        else {
            return false;
        }
        // check that the requester is a supervisor from the relevant zone or a manager
        // return true if so

    }

}