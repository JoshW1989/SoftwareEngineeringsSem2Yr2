package Quotation;

import Users.User;

public class PolicyState implements QuoteState {

    private Quote quote;

    PolicyState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason, User supervisor) throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }

    @Override
    public void submit() throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }

    @Override
    public void reject(String rejectReason) throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }

    @Override
    public void accept() throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }
}
