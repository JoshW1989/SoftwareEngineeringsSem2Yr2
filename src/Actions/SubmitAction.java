package Actions;

import Quotation.Quote;
import Users.User;

public class SubmitAction extends UserAction {

    public SubmitAction(Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason) {
        this.validate();
        if (this.getValidated()) {
            getActionQuote().submitQuote();
        }
    }

    public void validate() {

        // check that the person requesting has permissions to request a quote
        // return true if so

    }
}