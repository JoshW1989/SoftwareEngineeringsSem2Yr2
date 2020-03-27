package Actions;

import Quotation.Quote;
import Users.User;

public class SubmitAction extends UserAction {

    public SubmitAction(Quote quote, User user) {
        super(quote, user);
    }

    public void execute(String reason) {

        if (this.validate()) {
            System.out.println("submitted");
            getActionQuote().submitQuote();
        }
    }

    public boolean validate() {
        System.out.println(getRequester().getUserId());
        System.out.println(getActionQuote().getBroker().getUserId());
        // Checks that the person performing an action is the quotes broker
        return (getRequester().getUserId() == getActionQuote().getBroker().getUserId());

    }
}