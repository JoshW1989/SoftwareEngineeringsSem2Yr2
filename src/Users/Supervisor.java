package Users;

import Quotation.*;
import java.util.ArrayList;

public class Supervisor extends User {

    //private ArrayList<User> users;

    //Constructor
    public Supervisor(String company, String name, String email, String quickCall, int userId, String password, double commission)
    {
        super(company, name, email, quickCall, userId, password, commission);
        setSupervisor(this);
        //users = new ArrayList<User>();
    }

    @Override
    public Quote createQuote(int zone, String crop)
    {

        Quote quote = new Quote();

        quote.setZone(zone);
        quote.setCrop(crop);
        quote.setBroker(this);

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
