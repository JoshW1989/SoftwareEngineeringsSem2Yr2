package Quotation;

import Users.User;

public class PolicyState implements QuoteState {

    private Quote quote;

    PolicyState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason, User supervisor) {
        // Do nothing, policy is final and cannot be modified
    }

    @Override
    public void submit() {
        // Do nothing, policy is final and cannot be modified
    }

    @Override
    public void reject(String rejectReason) {
        // Do nothing, policy is final and cannot be modified
    }

    @Override
    public void accept() {
        // Do nothing, policy is final and cannot be modified
    }
}
