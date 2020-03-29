package Quotation;

import Users.User;

public class ApplicantState implements QuoteState {

    // Initial state of a quote. The applicant controls the process flow

    private Quote quote;

    ApplicantState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason, User supervisor) {
        // Do nothing, applicants can't climb
    }

    @Override
    public void submit() {
        quote.setStatus("PENDING");
        quote.setQuoteState(new SupervisorState(quote));
    }

    @Override
    //maybe change this
    public void reject(String rejectReason) {
        quote.setStatus("REJECTED");
    }

    @Override
    public void accept() {
        // Do nothing, applicants can't accept
    }
}
