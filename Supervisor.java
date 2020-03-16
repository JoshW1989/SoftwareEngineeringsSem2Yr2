package Quotation;

import java.util.ArrayList;

public class Supervisor extends User {

	//private ArrayList<User> users;
	
	//Constructor
	public Supervisor(String company, String name, String email, String quickCall, int userId, String password, double commission)
	{
		super(company, name, email, quickCall, userId, password, commission);
		//users = new ArrayList<User>();
	}
	
	public void evaluateRequest(Quote quote) {
		QuoteState state = new SupervisorState(quote);
		
		//Using blank value to test status of a quote
		if (quote.getCrop().equals("")) {
			state.reject();
		}
		else {
			state.accept();
		}
	}
	
	
	
	
	
	//Ignore for now - Was causing errors without it
	@Override
	protected void createQuote(Quote quote, int zone, String crop, User broker) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void requestPolicy(Quote quote, User supervisor) {
		// TODO Auto-generated method stub
	}
}
