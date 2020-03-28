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

        boolean valid = false;

        if (getRequester().getRole() == "supervisor") {
            if(getRequester().getZone() == getActionQuote().getZone()) {
                valid = true;
            }
        }
        return valid;
    }

}