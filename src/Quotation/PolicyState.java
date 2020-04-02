package Quotation;

import Users.User;

// Final and unchangeable state of a quote
public class PolicyState implements QuoteState {

    private Quote quote;

    PolicyState(Quote sentQuote) {
        quote = sentQuote;
    }

    // Policy is final, the quote can not be changed
    @Override
    public void climb(String climbReason, User supervisor) throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }

    // Policy is final, the quote can not be changed
    @Override
    public void submit() throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }

    // Policy is final, the quote can not be changed
    @Override
    public void reject(String rejectReason) throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }

    // Policy is final, the quote can not be changed
    @Override
    public void accept() throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Policy");
    }
}
