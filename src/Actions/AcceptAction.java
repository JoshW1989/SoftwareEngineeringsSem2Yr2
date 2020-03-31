package Actions;

import Quotation.IncorrectQuoteStateError;
import Quotation.Quote;
import Users.User;

public class AcceptAction extends UserAction {

    public AcceptAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason) throws IncorrectQuoteStateError{
        if (this.validate()){
        	getActionQuote().acceptQuote();
        }
    }

    public boolean validate(){

        boolean validated = false;

        if (getRequester().getRole() == "manager") {
            if (getRequester().checkEmployee(getActionQuote().getSupervisorID())) {
                validated = true;
            }
        } else if (getRequester().getRole() == "supervisor" &
                getRequester().getZone() == getActionQuote().getZone()) {
            validated = true;
        }
        return validated;

    }

}