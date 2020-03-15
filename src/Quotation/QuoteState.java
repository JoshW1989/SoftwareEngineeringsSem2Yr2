package Quotation;

public interface QuoteState {

    // Defines the actions which will be available to all states the quote can be in

    void climb();

    void submit();

    void reject();

    void accept();

}
