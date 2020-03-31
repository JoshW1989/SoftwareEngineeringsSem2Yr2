package Quotation;

public class IncorrectQuoteStateError extends Exception{

    public IncorrectQuoteStateError (String errorMessage) {
        super("This operation can not be performed while the quoute is in " + errorMessage + " state");
    }

	
}
