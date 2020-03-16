package Quotation;

public class Broker extends User {

	//Constructor
	public Broker(String company, String name, String email, String quickCall, int userId, String password, double commission)
	{
		super(company, name, email, quickCall, userId, password, commission);
	}

	//Broker creates Insurance Quote
	//Return type is Quote
	//Quote instance and Quote data passed in as parameters
	public void createQuote(Quote quote, int zone, String crop, User broker)
	{	
		QuoteState state = new ApplicantState(quote);
		
		//Assign Quote data - to still be amended once exact Quote data is decided on
		quote.setZone(zone);
		quote.setCrop(crop);
		quote.setBroker(broker);
		
		//Quote state once created and before it has been sent through the policy request
		state.submit();
		
	}

	//Broker requests Policy
	public void requestPolicy(Quote quote, User supervisor)
	{
		supervisor.evaluateRequest(quote);
	}

	
	//Ignore for now - Was causing errors
	@Override
	protected void evaluateRequest(Quote quote) {
		// TODO Auto-generated method stub
		
	}
}
