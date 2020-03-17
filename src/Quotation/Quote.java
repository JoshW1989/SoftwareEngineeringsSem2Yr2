package Quotation;

import Users.User;

public class Quote {

    private QuoteState currentState;

    //TODO only implement these when needed

    private int zone;
    private String crop;
    private String rejectReason;
    private String climbReason;
    private String status;
    private User broker;
    private User owner;

    public Quote() {

        //TODO build constructor fully
        //TODO make the quote generation algorhythm that pattern which hides what alogrhtym performs the function
        currentState = new ApplicantState(this);

    }

    // Used to set the current state of the quote - the state defines how method calls interact with the object
    void setQuoteState(String type) {
        switch(type) {
            case "A":
                currentState = new ApplicantState(this);
                break;
            case "S":
                currentState = new SupervisorState(this);
                break;
            case "M":
                currentState = new ManagerState(this);
                break;
            case "P":
                currentState = new PolicyState(this);
                break;
        }
    }

    //TODO insert validation of user permissions here
    public void actionQuote (String action) {
        switch(action) {
            case "climb":
                currentState.climb();
                break;
            case "submit":
                currentState.submit();
                break;
            case "reject":
                currentState.reject();
                break;
            case "accept":
                currentState.accept();
                break;
        }
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

    public User getOwner() { return owner;}
    public void setOwner(User newOwner) {owner = newOwner;}


}
