package server;
import java.lang.*;
import java.util.*;

public class Donor extends User {
    private String status;
    private String lastDonateDate;

    // constructors
    public Donor() {
    }

    public Donor(String aiubId, String name, String email, String contact, String password, String bloodGroup,
            boolean isDonor) {
        super(aiubId, name, email, contact, password, bloodGroup, isDonor);
        this.status = "Available";
        this.lastDonateDate = null;
        Donors.add(this);
    }

    // getters and setters
    public String getStatus() {
        return status;
    }

    public String getLastDonateDate() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastDonateDate(String lastDonateDate) {
        this.lastDonateDate = lastDonateDate;
    }

    // donate blood (return true if successful)
    public boolean donateBlood(String postId) {
        for (Post i : Post.posts) {
            if (i.getPostId().equals(postId)) {
                i.addDonor(this.getAiubId());
                return true;
            }
        }
        return false;
    }

    // login (return object if success)
    public static Donor Login(String aiubId, String password) {
        for (Donor i : Donors) {
            if (i.getAiubId().equals(aiubId) && i.getPassword().equals(password)) {
                return i;
            }
        }

        return null;
    }
}
