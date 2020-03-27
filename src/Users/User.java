package Users;

import Quotation.Quote;

public abstract class User {

    //Attributes
    private String company;
    private String name;
    private String email;
    private String quickCall;
    private int userId;
    private String password;
    private double commission;
    private User supervisor;
    private String role;
    private int zone;
    private boolean canRequest;

    //Getters & Setters
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public User getSupervisor() { return supervisor; }
    public void setSupervisor(User supervisor) { this.supervisor = supervisor; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getQuickCall() { return quickCall; }
    public void setQuickCall(String quickCall) { this.quickCall = quickCall; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public double getCommission() { return commission; }
    public void setCommission(double commission) { this.commission = commission; }

    public String getRole() { return role; }
    public void setRole(String newRole) { this.role = newRole; }

    public int getZone() { return zone; }
    public void setZone(int newZone) { this.zone = newZone; }

    public boolean getCanRequest() { return canRequest; }
    public void setCanRequest(boolean newCanRequest) { this.canRequest = newCanRequest; }

    //Constructor
    public User(String company, String name, String email, String quickCall, int userId, String password, double commission)
    {
        this.company = company;
        this.name = name;
        this.email = email;
        this.quickCall = quickCall;
        this.userId = userId;
        this.password = password;
        this.role = role;

        if (company == "VCA" || company == "vca")
        {
            //Commission is always 5% for VCA employees
            this.commission = 5 / 100;
        }
        else
        {
            this.commission = commission;
        }
    }


}

