package server.classes;

import java.util.*;
import java.util.regex.*;

public abstract class User {
    public static List<Donor> donors;
    public static List<Recipient> recipients;
    private String aiubId;
    private String name;
    private String email;
    private String contact;
    private String password;
    private String bloodGroup;
    private boolean isDonor;

    static {
        donors = new ArrayList<>();
        recipients = new ArrayList<>();
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

    // check a string is numeric or not
    public static boolean isNumeric(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    // check valid email or not
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // check valid aiub id or not
    public static boolean isValidAiubId(String aiubId) {
        String[] aiubIdDivide = aiubId.split("-");
        if (aiubIdDivide.length != 3 || !isNumeric(aiubIdDivide[0]) || !isNumeric(aiubIdDivide[1])
                || !isNumeric(aiubIdDivide[2]) || aiubIdDivide[0].length() != 2 || aiubIdDivide[1].length() != 5
                || aiubIdDivide[2].length() != 1) {
            return false;
        }

        return true;
    }
}