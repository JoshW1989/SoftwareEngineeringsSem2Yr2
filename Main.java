package Quotation;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zone = 4;
		String crop = "";
		String rejectReason = "Missing values";
		
		User supervisor = new Supervisor("VCA", "Scott Neary", "B00381534@studentmail.uws.ac.uk", "123456789", 381534, "password", 5.0);
		User broker = new Broker("VCA", "John Smith", "broker@vca.com", "987654321", 98009, "password", 5.0);
		Quote quote = new Quote();
		
		broker.createQuote(quote, zone, crop, broker);
		
		System.out.println("Zone: " + quote.getZone() + "\n" +
				           "Crop Type: " + quote.getCrop() + "\n" +
						   "Broker: " + quote.getBroker().getName());
		
		broker.requestPolicy(quote, supervisor);
		
		System.out.println("Quote Status: " + quote.getStatus());
		
		if (quote.getStatus().contentEquals("REJECTED"))
		{
			quote.setRejectReason(rejectReason);
			System.out.println("Reject Reason: " + rejectReason);
		}
		else if (quote.getStatus().contentEquals("CLIMBED"))
		{
			quote.setRejectReason(rejectReason);
			System.out.println("Reject Reason: " + rejectReason);
		}
	}

}
