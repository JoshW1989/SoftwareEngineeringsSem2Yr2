package Quotation;

public class NoQuotePermissionError extends Exception{

    public NoQuotePermissionError () {
        super("This user does not have permissions to create a quote");
    }
}
