package Quotation;

public class ApplicantState implements QuoteState {

    // Initial state of a quote. The applicant controls the process flow

    private Quote quote;

    ApplicantState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason) {
        // Do nothing, applicants can't climb
    }

    @Override
    public void submit() {
        quote.setOwner(quote.getBroker().getSupervisor());
        quote.setStatus("PENDING");
        quote.setQuoteState(new SupervisorState(quote));
    }

    @Override
    public void reject(String rejectReason) {
        quote.setStatus("REJECTED");
    }

    @Override
    public void accept() {
        // Do nothing, applicants can't accept
    }
}
