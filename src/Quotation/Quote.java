package Quotation;

import Calculation.QuoteCalculation;
import Calculation.StandardQuote;
import Users.User;

public class Quote {

    private QuoteState currentState;

    private int zone;
    private String crop;
    private String rejectReason;
    private String climbReason;
    private String status;
    private User broker;
    private User supervisor;
    private double hectares;
    
    private double totalVal;
    private double monthlyCost;
    private double comissionTotal;
    
    public int getZone() { return zone;}
    public void setZone(int newZone) {zone = newZone;}

    public String getCrop() { return crop;}
    public void setCrop(String newCrop) {crop = newCrop;}

    public String getRejectReason() { return rejectReason;}
    public void setRejectReason(String newRejectReason) {rejectReason = newRejectReason;}

    public String getClimbReason() { return climbReason;}
    public void setClimbReason(String newClimbReason) {climbReason = newClimbReason;}

    public String getStatus() { return status;}
    public void setStatus(String newStatus) {status = newStatus;}

    public User getBroker() { return broker;}
    public void setBroker(User newBroker) {broker = newBroker;}

    public User getSupervisor() { return supervisor;}
    public void setSupervisor(User newSupervisor) {supervisor = newSupervisor;}

    public int getSupervisorID() { return supervisor.getUserId();}

	public double getHectares() {return hectares;}
	public void setHectares(double hectares) {this.hectares = hectares;}

	public double getTotalVal() {return totalVal;}
	public void setTotalVal(double totalVal) {this.totalVal = totalVal;}

	public double getMonthlyCost() {return monthlyCost;}
	public void setMonthlyCost(double monthlyCost) {this.monthlyCost = monthlyCost;}

	public double getComissionTotal() {return comissionTotal;}
	public void setComissionTotal(double comissionTotal) {this.comissionTotal = comissionTotal;}
	
	public QuoteState getQuoteState() {return currentState;}
    void setQuoteState(QuoteState newState) {currentState = newState;}    	


    public Quote(User user, String crop, int zone, double hectares) throws NoQuotePermissionError {
    	
    	if (user.getCanRequest() == true) {
	        setZone(zone);
	        setCrop(crop);
	        setBroker(user);
	        setHectares(hectares);
	        currentState = new ApplicantState(this);
	        assignValues();
	        
    	} else {
    		throw new NoQuotePermissionError();
    	}
    }


    public void assignValues() {
    	
    	QuoteCalculation quoteRates = new StandardQuote(this.getZone(), this.getCrop(),
    			this.getHectares(), this.getBroker().getCommission());
    	
    	this.setTotalVal(quoteRates.getTotalVal());
    	this.setMonthlyCost(quoteRates.getMonthlyCost());
    	this.setComissionTotal(quoteRates.getComission());
    	
    }

    
    public void climbQuote (String reason, User user) throws IncorrectQuoteStateError {
        currentState.climb(reason, user);
    }
    public void submitQuote () throws IncorrectQuoteStateError {
        currentState.submit();
    }
    public void acceptQuote () throws IncorrectQuoteStateError {
        currentState.accept();
    }
    public void rejectQuote (String reason) throws IncorrectQuoteStateError {
        currentState.reject(reason);
    }





	
	
}
