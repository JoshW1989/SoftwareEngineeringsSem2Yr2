package Calculation;

public class StandardQuoteCalculation extends QuoteCalculation{

	public StandardQuoteCalculation(int zone, String crop, double hecatares, double userComission) {
		super(zone, crop, hecatares, userComission);
		
		Rates standardRates = new StandardCropRates();
		this.setRateType(standardRates);
		this.calculateTotal();
		this.calculateMonthly();
		this.calculateComission();

	}
}
