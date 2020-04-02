package Quotation;

public class IncorrectQuoteStateError extends Exception{

	// Thrown when the action should not be performed in a particualr state
    public IncorrectQuoteStateError (String errorMessage) {
        super("This operation can not be performed while the quoute is in " + errorMessage + " state");
    }

	
}
