package Actions;

import Quotation.Quote;
import Users.User;

public class RejectAction extends UserAction {

    public RejectAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason){
        this.validate();
        if (this.getValidated()){
            getActionQuote().rejectQuote(reason);
        }
    }

    public void validate(){

        // check that the requester is a supervisor from the relevant zone or a manager
        // return true if so

    }

}