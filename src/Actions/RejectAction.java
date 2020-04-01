package Actions;

import Quotation.IncorrectQuoteStateError;
import Quotation.ManagerState;
import Quotation.SupervisorState;
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

    	if (getActionQuote().getQuoteState() instanceof ManagerState) {
    		return validateManager();
    	} 
    	else if (getActionQuote().getQuoteState() instanceof SupervisorState) {
    		return validateSupervisor();
    	}
        return false;

    }
    
    public boolean validateManager() {
        if (getRequester().getRole() == "manager") {
            if (getRequester().checkEmployee(getActionQuote().getSupervisorID())) {
                return true;
            }
        }
        return false;    
    }
    
    public boolean validateSupervisor() {
    	if (getRequester().getRole() == "supervisor" &
                getRequester().getZone() == getActionQuote().getZone()) {
            return true;
    	}
    	return false;
    }

}