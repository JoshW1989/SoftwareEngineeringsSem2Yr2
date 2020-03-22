package Actions;

import Quotation.Quote;
import Users.User;

public class AcceptAction extends UserAction {

    public AcceptAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(){
        this.validate();
        if (this.getValidated()){
            getActionQuote().acceptQuote();
        }
    }

    public void validate(){

        // check that the requester is a supervisor from the relevant zone or a manager
        // return true if so

    }

}