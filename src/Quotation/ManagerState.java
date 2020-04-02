package Quotation;

import Users.User;

// State once escalated by a supervisor to a manager
public class ManagerState implements QuoteState {

    Quote quote;

    ManagerState(Quote sentQuote) {
        quote = sentQuote;
    }

    // Can't be escelated higher
    @Override
    public void climb(String climbReason, User supervisor) throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Manager");   	
    }

    //Quote is already submitted
    @Override
    public void submit() throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Manager");
    }

    @Override
    public void reject(String rejectReason) {
        quote.setClimbReason("");
        quote.setStatus("REJECTED");
        quote.setRejectReason(rejectReason);
        quote.setQuoteState(new ApplicantState(quote));
    }

    @Override
    public void accept() {
        quote.setClimbReason("");
        quote.setStatus("APPROVED");
        quote.setQuoteState(new PolicyState(quote));
    }

}
