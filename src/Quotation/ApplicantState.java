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
        quote.setOwner(quote.getBroker().getSupervisor());
        quote.setStatus("PENDING");
        quote.setQuoteState("S");


        System.out.println("REF 1: Current state is applicant state");
        System.out.println("REF 1: Set quote status to pending");
        System.out.println("REF 1: Set the owner to the applicants supervisor - this is for control e.g only the current owner can interact");
        System.out.println("REF 1: Set the quote state to Supervisor state. Next time an action on the quote is performed e.g climb, it will perform the action defined in the SupervisorState interface class");
        System.out.println("\n");
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
