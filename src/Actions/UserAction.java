package Actions;

import Quotation.IncorrectQuoteStateError;
import Quotation.Quote;
import Users.User;

public abstract class UserAction{

    private Quote actionQuote;
    private User requester;

    public Quote getActionQuote() { return actionQuote;}
    public void setActionQuote(Quote newQuote) {actionQuote = newQuote;}

    public User getRequester() { return requester;}
    public void setRequester(User newRequester) {requester = newRequester;}


    public UserAction (Quote quote, User user) {
        setActionQuote(quote);
        setRequester(user);
    }

    public void execute(String reason) throws IncorrectQuoteStateError {}
    public boolean validate() {return true;}


}
