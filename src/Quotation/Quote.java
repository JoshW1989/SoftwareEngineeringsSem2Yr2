package Quotation;

import Users.User;
import Zones.Zone;

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

    //possibly have state manager class to stickto SOLID principles
    void setQuoteState(QuoteState newState) {
        currentState = newState;
    }

    //TODO insert validation of user permissions here
    public void climbQuote (String reason) {
        currentState.climb(reason);
    }
    public void submitQuote () {
        currentState.submit();
    }
    public void acceptQuote () {
        currentState.accept();
    }
    public void rejectQuote (String reason) {
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

    public User getOwner() { return owner;}
    public void setOwner(User newOwner) {owner = newOwner;}


}
