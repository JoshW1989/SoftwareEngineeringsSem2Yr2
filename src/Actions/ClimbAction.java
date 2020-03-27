package Actions;

import Quotation.Quote;
import Users.User;


public class ClimbAction extends UserAction {

    public ClimbAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason){
        if (this.validate()){
            getActionQuote().climbQuote(reason);
        }
    }

    public boolean validate(){
        System.out.println("got here");
        return getRequester().getRole() == "supervisor";

        // check that the requester is a supervisor
        //FROM RELEVANT ZONE
        //return true if so

    }

}
