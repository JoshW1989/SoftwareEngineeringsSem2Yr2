package Users;

import Quotation.*;

public class Broker extends User {


    //Constructor
    public Broker(String company, String name, String email, String quickCall, int userId, String password, double commission, User supervisor)
    {
        super(company, name, email, quickCall, userId, password, commission);
        setSupervisor(supervisor);

    }

    //Broker creates Insurance Quote
    //Return type is Quote
    //Quote instance and Quote data passed in as parameters


    @Override
    public Quote createQuote(int zone, String crop)
    {
        // DELETE QuoteState state = new ApplicantState(quote);

        Quote quote = new Quote();

        //Assign Quote data - to still be amended once exact Quote data is decided on
        quote.setZone(zone);
        quote.setCrop(crop);
        quote.setBroker(this);

        //Quote state once created and before it has been sent through the policy request
        return quote;
    }

    public void climbQuote( Quote quote, String climbReason) {
        quote.climbQuote(climbReason);
    }

    public void submitQuote(Quote quote) {
        quote.submitQuote();
    }

    public void acceptQuote(Quote quote) {
        quote.acceptQuote();
    }

    public void rejectQuote( Quote quote, String rejectReason) {
        quote.rejectQuote(rejectReason);
    }
}
