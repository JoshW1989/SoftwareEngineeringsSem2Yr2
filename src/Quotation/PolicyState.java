package Quotation;

public class PolicyState implements QuoteState {

    private Quote quote;

    PolicyState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb() {
        // Do nothing, policy cannot be modified
    }

    @Override
    public void submit() {
        // Do nothing, policy cannot be modified
    }

    @Override
    public void reject() {
        // Do nothing, policy cannot be modified
    }

    @Override
    public void accept() {
        // Do nothing, policy cannot be modified
    }
}
