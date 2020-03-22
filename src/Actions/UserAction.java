package Actions;

import Quotation.Quote;
import Users.User;

public abstract class UserAction{

    private boolean validated = false;
    private Quote actionQuote;
    private User requester;

    public boolean getValidated() { return validated;}
    public void setValidated(boolean newValidated) {validated = newValidated;}

    public Quote getActionQuote() { return actionQuote;}
    public void setActionQuote(Quote newQuote) {actionQuote = newQuote;}

    public User getRequester() { return requester;}
    public void setRequester(User newRequester) {requester = newRequester;}


    public UserAction (Quote quote, User user) {
        setActionQuote(quote);
        setRequester(user);
    }

    public void execute(String reason) {}

    public void validate(){}

}
