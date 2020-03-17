package Quotation;

public class SupervisorState implements QuoteState  {

    Quote quote;

    SupervisorState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb() {
        //TODO this should actually escelate to the manager quote.setOwner(quote.getBroker().manager);
        quote.setOwner(quote.getBroker().getSupervisor());
        quote.setQuoteState("M");
    }

    @Override
    public void submit() {
        // Do nothing, applicants can't submit quotes
        System.out.println("REF 2: can't submit an already submitted quote\n");
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