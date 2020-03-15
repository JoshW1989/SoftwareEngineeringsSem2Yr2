package Quotation;

public class SupervisorState implements QuoteState  {

    Quote quote;

    SupervisorState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb() {
        quote.setOwner(quote.getBroker().manager);
        quote.setQuoteState("M");
    }

    @Override
    public void submit() {
        // Do nothing, applicants can't submit quotes
    }

    @Override
    public void reject() {
        quote.setOwner(quote.getBroker());
        quote.setStatus("REJECTED");
        quote.setQuoteState("A");
    }

    @Override
    public void accept() {
        quote.setStatus("APPROVED");
        quote.setQuoteState("P");
    }
}