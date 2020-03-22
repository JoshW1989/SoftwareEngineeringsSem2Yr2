package Quotation;

public class ManagerState implements QuoteState {

    Quote quote;

    ManagerState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason) {
        // Do nothing, managers can't climb
    }

    @Override
    public void submit() {
        // Do nothing, managers can't submit
    }

    @Override
    public void reject(String rejectReason) {
        quote.setOwner(quote.getBroker());
        quote.setStatus("REJECTED");
        quote.setQuoteState(new ApplicantState(quote));
    }

    @Override
    public void accept() {
        quote.setStatus("APPROVED");
        quote.setQuoteState(new PolicyState(quote));
    }

}
