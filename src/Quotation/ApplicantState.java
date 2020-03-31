package Quotation;

import Users.User;
import Users.WrongUserException;

public class ApplicantState implements QuoteState {

    // Initial state of a quote. The applicant controls the process flow

    private Quote quote;

    ApplicantState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason, User supervisor) throws IncorrectQuoteStateError{
        // Do nothing, applicants can't climb
    	throw new IncorrectQuoteStateError("Applicant State");
    	
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

    @Override
    public void accept() throws IncorrectQuoteStateError{
        // Do nothing, applicants can't accept
    	
    	throw new IncorrectQuoteStateError("Applicant State");
    	
    }
}
