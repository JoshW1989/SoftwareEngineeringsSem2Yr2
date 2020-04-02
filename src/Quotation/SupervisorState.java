package Quotation;
import Users.User;

// State once a quote is initially submitted for review
public class SupervisorState implements QuoteState  {

    Quote quote;

    SupervisorState(Quote sentQuote) {
        quote = sentQuote;
    }

    // Supervisor attached to quote so only the correct manager can then review
    @Override
    public void climb(String climbReason, User supervisor) {
        quote.setClimbReason(climbReason);
        quote.setSupervisor(supervisor);
        quote.setQuoteState(new ManagerState(quote));
    }

    // Quote is already submitted
    @Override
    public void submit() throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Supervisor");
    }

    @Override
    public void reject(String rejectReason) {
    	quote.setRejectReason(rejectReason);
        quote.setStatus("REJECTED");
        quote.setQuoteState(new ApplicantState(quote));
    }

    @Override
    public void accept() {
        quote.setStatus("APPROVED");
        quote.setQuoteState(new PolicyState(quote));
    }
}