package Quotation;

public class ApplicantState implements QuoteState {

    // Initial state of a quote. The applicant controls the process flow

    private Quote quote;

    ApplicantState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb() {
        // Do nothing, applicants can't climb
    }

    @Override
    public void submit() {
        quote.setOwner(quote.getBroker().supervisor);
        quote.setStatus("PENDING");
        quote.setQuoteState(quote.getSupervisorState());
    }

    @Override
    public void reject() {
        // Do nothing, applicants can't reject
    }

    @Override
    public void accept() {
        // Do nothing, applicants can't accept
    }
}
