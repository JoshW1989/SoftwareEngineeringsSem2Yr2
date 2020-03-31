package Quotation;

import Users.User;

public interface QuoteState {

    // Defines the actions which will be available to all states the quote can be in

    void climb(String climbReason, User supervisor) throws IncorrectQuoteStateError;

    void submit() throws IncorrectQuoteStateError;

    void reject(String rejectReason) throws IncorrectQuoteStateError;;

    void accept() throws IncorrectQuoteStateError;

    //String getQuoteState*(<)
}
