package Actions;

import Quotation.Quote;
import Users.User;


public class ClimbAction extends UserAction {

    public ClimbAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason){
        this.validate();
        if (this.getValidated()){
            getActionQuote().climbQuote(reason);
        }
    }

    public void validate(){

        // check that the requester is a supervisor
        //return true if so

    }

}
