package Actions;

import Quotation.IncorrectQuoteStateError;
import Quotation.ManagerState;
import Quotation.Quote;
import Quotation.SupervisorState;
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

	// checks quote is in correct state and passes to employee specific validation
    public boolean validate(){
        if (getActionQuote().getQuoteState() instanceof ManagerState) {
        	return validateManager();
        	
        } else if (getActionQuote().getQuoteState() instanceof SupervisorState) {
        	return validateSupervisor();
        }
        return false;

    }
    
    // checks employee is manager
    // ensures the person who escalated the quote is within the managers employees list
    public boolean validateManager() {
        if (getRequester().getRole() == "manager") {
            if (getRequester().checkEmployee(getActionQuote().getSupervisorID())) {
                return true;
            }
        }
        return false;    
    }
    
    // Ensures employee is a supervisor and is assigned the correct zone
    public boolean validateSupervisor() {
    	if (getRequester().getRole() == "supervisor" &
                getRequester().getZone() == getActionQuote().getZone()) {
            return true;
    	}
    	
    	return false;
    }
}
