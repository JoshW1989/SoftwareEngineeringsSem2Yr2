package Quotation;

import Users.User;

// Initial state of a quote. The applicant controls the process flow
public class ApplicantState implements QuoteState {

    private Quote quote;

    ApplicantState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason, User supervisor) throws IncorrectQuoteStateError{
        // Do nothing, applicants can't climb
    	throw new IncorrectQuoteStateError("Applicant");
    	
    }

    @Override
    public void submit() {
        quote.setStatus("PENDING");
        quote.setQuoteState(new SupervisorState(quote));
    }

    @Override
    //maybe change this
    public void reject(String rejectReason) {
        quote.setRejectReason("REJECTED BY BROKER");
    }

    // Quote must be submitted for review first
    @Override
    public void accept() throws IncorrectQuoteStateError{
        // Do nothing, applicants can't accept
    	
    	throw new IncorrectQuoteStateError("Applicant State");
    	
    }
}
