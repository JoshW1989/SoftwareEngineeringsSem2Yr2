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
        //TODO this should actually escelate to the manager quote.setOwner(quote.getBroker().manager);
        System.out.println("climbed in supervisor state");
        quote.setClimbReason(climbReason);
        quote.setSupervisor(supervisor);
        quote.setQuoteState(new ManagerState(quote));
    }

    @Override
    public void submit() {
        // Do nothing, applicants can't submit quotes
    }

    @Override
    public void reject(String rejectReason) {
        quote.setStatus("REJECTED");
        quote.setQuoteState(new ApplicantState(quote));
    }

    @Override
    public void accept() {
        quote.setStatus("APPROVED");
        quote.setQuoteState(new PolicyState(quote));
    }
}