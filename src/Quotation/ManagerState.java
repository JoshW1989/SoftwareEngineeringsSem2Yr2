package Quotation;

public class ManagerState implements QuoteState {

    Quote quote;

    ManagerState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb() {
        // Do nothing, managers can't climb
    }

    @Override
    public void submit() {
        // Do nothing, managers can't submit
    }

    @Override
    public void reject() {
        quote.setOwner(quote.getBroker());
        quote.setOwner(quote.getBroker().supervisor);
        quote.setStatus("REJECTED");
        quote.setQuoteState("A");
    }

    @Override
    public void accept() {
        quote.setStatus("APPROVED");
        quote.setQuoteState("P");
    }

}
