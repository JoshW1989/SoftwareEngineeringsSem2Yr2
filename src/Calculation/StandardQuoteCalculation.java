package Calculation;


// Quote calculation which implements business rules in StandardCropRates.class
public class StandardQuoteCalculation extends QuoteCalculation{

	public StandardQuoteCalculation(int zone, String crop, double hecatares, double userCommission) {
		super(zone, crop, hecatares, userCommission);
		
		Rates standardRates = new StandardCropRates();
		this.setRateType(standardRates);
		this.calculateTotal();
		this.calculateMonthly();
		this.calculateCommission();

	}
}
