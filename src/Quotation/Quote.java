package Quotation;

public class Quote {

    private QuoteState currentState;
    private QuoteState applicantState;
    private QuoteState supervisorState;
    private QuoteState managerState;
    private QuoteState policyState;

    private int zone;
    private String crop;
    private String rejectReason;
    private String climbReason;
    private String status;
    private User broker;
    private User owner;

    public Quote() {

        //TODO build constructor fully
        applicantState = new ApplicantState(this);
        supervisorState = new SupervisorState(this);
        managerState = new ManagerState(this);
        policyState = new PolicyState(this);

        currentState = applicantState;

    }

    void setQuoteState(QuoteState newQuoteState) {
        currentState = newQuoteState;
    }

    //TODO insert validation of user permissions here
    public void climb() {
        currentState.climb();
    }

    public void submit() {
        currentState.submit();
    }

    public void reject() {
        currentState.reject();
    }

    public void accept() {
        currentState.accept();
    }

    QuoteState getApplicantState() { return applicantState; }
    QuoteState getSupervisorState() { return supervisorState; }
    QuoteState getManagerState() { return managerState; }
    QuoteState getPolicyState() { return policyState; }


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
