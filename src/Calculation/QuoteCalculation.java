package Calculation;

// base class for any calculations which implement their own rates (strategy design pattern)
public abstract class QuoteCalculation {

	private double totalVal;
	private double monthlyCost;
	private double commissionTotal;
	private double baseCost = 300;
	private double monthlyModifier = 1.7;
	
	private int zone;
	private String crop;
	private double hectares;
	private double userCommission;
	
	private Rates rateType;
	
	public void setRateType(Rates newRate) {this.rateType = newRate;}
	public Rates getRateType() {return rateType;}
	
	public double getTotalVal() {return totalVal;}
	public void setTotalVal(double totalVal) {this.totalVal = totalVal;}
	
	public double getMonthlyCost() {return monthlyCost;}
	public void setMonthlyCost(double monthlyCost) {this.monthlyCost = monthlyCost;}

	public double getCommission() {return commissionTotal;}
	public void setCommission(double commission) {this.commissionTotal = commission;}
	
	public int getZone() {return zone;}
	public void setZone(int zone) {this.zone = zone;}

	public String getCrop() {return crop;}
	public void setCrop(String crop) {this.crop = crop;}

	public double getHectares() {return hectares;}
	public void setHectares(double hectares) {this.hectares = hectares;}

	public double getUserCommission() {return userCommission;}
	public void setUserCommission(double userCommission) {this.userCommission = userCommission;}
	
	
	public QuoteCalculation(int zone, String crop, double hecatares, double userCommission) {
		
		this.zone = zone;
		this.crop = crop;
		this.hectares = hecatares;
		this.userCommission = userCommission;
		
	}
	
	public void calculateTotal() {
		
		double total = baseCost * this.getRateType().cropModifier(this.getCrop());
		total = total * this.getHectares();
		double max = this.getRateType().zoneMax(this.getZone());
		if (total > max) {
			total = max;
		}
		
		this.setTotalVal(total);
		
	}
	
	public void calculateMonthly() {
		double monthly = (this.getTotalVal() / 12) * monthlyModifier;
		this.setMonthlyCost(monthly);
	}
	
	
	public void calculateCommission() {
		this.setCommission(getTotalVal() * this.getUserCommission());
	}


	
}
