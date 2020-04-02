package Actions;

import Quotation.IncorrectQuoteStateError;
import Quotation.Quote;
import Users.User;

public class SubmitAction extends UserAction {

    public SubmitAction(Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason) throws IncorrectQuoteStateError {
        if (this.validate()) {
            getActionQuote().submitQuote();
        }
    }
    
    // Checks that the person performing an action is the quotes broker
    public boolean validate() {        
        return (getRequester().getUserId() == getActionQuote().getBroker().getUserId());

    }
}