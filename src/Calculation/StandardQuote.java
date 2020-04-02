package Calculation;

public class StandardQuote extends QuoteCalculation{

	public StandardQuote(int zone, String crop, double hecatares, double userComission) {
		super(zone, crop, hecatares, userComission);
		
		Rates standardRates = new StandardCropRates();
		this.setRateType(standardRates);
		this.calculateTotal();
		this.calculateMonthly();
		this.calculateComission();

	}
}
