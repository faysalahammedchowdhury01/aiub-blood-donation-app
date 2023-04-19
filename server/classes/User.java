package server.classes;

import java.util.*;

public abstract class User {
    protected static List<Donor> donors;
    protected static List<Recipient> recipients;
    private String aiubId;
    private String name;
    private String email;
    private String contact;
    private String password;
    private String bloodGroup;
    private boolean isDonor;

    // constructors
    public User() {
    }

    public User(String aiubId, String name, String email, String contact, String password, String bloodGroup,
            boolean isDonor) {
        this.aiubId = aiubId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.bloodGroup = bloodGroup;
        this.isDonor = isDonor;
        donors = new ArrayList<>();
        recipients = new ArrayList<>();
    }

    // getters and setters for all attributes
    public String getAiubId() {
        return aiubId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public boolean getIsDonor() {
        return isDonor;
    }

    public void setAiubId(String aiubId) {
        this.aiubId = aiubId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setIsDonor(boolean isDonor) {
        this.isDonor = isDonor;
    }
}