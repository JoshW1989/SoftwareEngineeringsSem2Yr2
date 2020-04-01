package Quotation;

import Users.User;

public class ManagerState implements QuoteState {

    Quote quote;

    ManagerState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason, User supervisor) throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Manager");   	
    }

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
