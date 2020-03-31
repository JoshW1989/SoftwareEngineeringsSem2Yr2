package Actions;

import Quotation.IncorrectQuoteStateError;
import Quotation.Quote;
import Users.User;

public class RejectAction extends UserAction {



    public RejectAction (Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason) throws IncorrectQuoteStateError{
        if (this.validate()){
            getActionQuote().rejectQuote(reason);
        }
    }

    public boolean validate() {

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
        // check that the requester is a supervisor from the relevant zone or a manager
        // return true if so

    }

}