package Actions;

import Quotation.Quote;
import Users.User;


public class ClimbAction extends UserAction {

    public ClimbAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason){
        if (this.validate()){
            getActionQuote().climbQuote(reason, getRequester());
        }
    }

    public boolean validate(){

        boolean valid = false;

        if (getRequester().getRole() == "supervisor") {
            if(getRequester().getZone() == getActionQuote().getZone()) {
                valid = true;
            }
        }
        return valid;

        // check that the requester is a supervisor
        //FROM RELEVANT ZONE
        //return true if so

    }

}
