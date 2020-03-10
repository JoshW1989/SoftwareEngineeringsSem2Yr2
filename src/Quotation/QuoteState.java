package Quotation;

public interface QuoteState {

    //Different states expected of a quote
    //With( Applicant, Supervisor, Manager) - Rejected, Policy

    void climb();

    void submit();

    void reject();

    void accept();

}
