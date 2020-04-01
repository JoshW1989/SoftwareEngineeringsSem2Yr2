package Calculation;

public abstract class QuoteCalculation {

	private double totalVal;
	private double monthlyCost;
	private double comission;
	
	public Rates rateType;
	
	public double getTotalVal() {return totalVal;}
	public void setTotalVal(double totalVal) {this.totalVal = totalVal;}
	
	public double getMonthlyCost() {return monthlyCost;}
	public void setMonthlyCost(double monthlyCost) {this.monthlyCost = monthlyCost;}

	public double getComission() {return comission;}
	public void setComission(double comission) {this.comission = comission;}
	
	//base cost
	public double calculateTotal() {
		
	}
	//get total value
	//Get monthly payment
	//get get comission
	
}
