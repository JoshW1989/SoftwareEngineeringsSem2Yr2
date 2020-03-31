package Quotation;
import Actions.UserAction;
import Users.User;

public class SupervisorState implements QuoteState  {

    Quote quote;

    SupervisorState(Quote sentQuote) {
        quote = sentQuote;
    }

    @Override
    public void climb(String climbReason, User supervisor) {
        quote.setClimbReason(climbReason);
        quote.setSupervisor(supervisor);
        quote.setQuoteState(new ManagerState(quote));
    }

    @Override
    public void submit() throws IncorrectQuoteStateError {
    	throw new IncorrectQuoteStateError("Supervisor State");
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