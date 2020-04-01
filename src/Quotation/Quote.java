package Quotation;

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

    public Quote(User user, String crop, int zone, double hectares) throws NoQuotePermissionError {
    	
    	if (user.getCanRequest() == true) {
	        setZone(zone);
	        setCrop(crop);
	        setBroker(user);
	        setHectares(hectares);
	        currentState = new ApplicantState(this);
    	} else {
    		throw new NoQuotePermissionError();
    	}
    }

    // Used to set the current state of the quote - the state defines how method calls interact with the object

    //possibly have state manager class to stickto SOLID principles
    void setQuoteState(QuoteState newState) {
        currentState = newState;
    }
    public QuoteState getQuoteState() {return currentState;}
    
    //TODO insert validation of user permissions here
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


}
