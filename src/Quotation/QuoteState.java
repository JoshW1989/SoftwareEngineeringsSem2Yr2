package Quotation;

import Users.User;

public interface QuoteState {

    // Defines the actions which will be available to all states the quote can be in

    void climb(String climbReason, User supervisor);

    void submit();

    void reject(String rejectReason);

    void accept();

    //String getQuoteState*(<)
}
