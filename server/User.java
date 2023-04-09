package server;
import java.lang.*;
import java.util.*;

public abstract class User {
    public static List<Donor> Donors;
    public static List<Recipient> Recipients;
    private String aiubId;
    private String name;
    private String email;
    private String contact;
    private String password;
    private String bloodGroup;
    private boolean isDonor;

    static {
        Donors = new ArrayList<>();
        Recipients = new ArrayList<>();
    }

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

    // edit profile
    public void editProfile(String name, String email, String contact, String password,
            String bloodGroup) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.bloodGroup = bloodGroup;
    }

    // check user exist (return true if exist)
    public static boolean doesUserExist(String aiubId) {
        for (User i : Donors) {
            if (i.getAiubId().equals(aiubId)) {
                return true;
            }
        }

        for (User i : Recipients) {
            if (i.getAiubId().equals(aiubId)) {
                return true;
            }
        }

        return false;
    }

    // login (return true if success)
    public static boolean login(String aiubId, String password) {
        for (Donor i : Donors) {
            if (i.getAiubId().equals(aiubId) && i.getPassword().equals(password)) {
                return true;
            }
        }

        for (Recipient i : Recipients) {
            if (i.getAiubId().equals(aiubId) && i.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    // signup (return true if success)
    public static boolean signup(String aiubId, String name, String email, String contact, String password,
            String bloodGroup,
            boolean isDonor) {
        if (doesUserExist(aiubId)) {
            return false;
        }

        return true;
    }
}
