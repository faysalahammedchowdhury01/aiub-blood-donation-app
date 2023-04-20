package server.classes;

import server.interfaces.*;

public class Donor extends User implements DonorOperations {
    private String status;
    private String lastDonateDate;

    // constructors
    public Donor() {
    }

    public Donor(String aiubId, String name, String email, String contact, String password, String bloodGroup) {
        super(aiubId, name, email, contact, password, bloodGroup, true);
        this.status = "Available";
        this.lastDonateDate = "N/A";
        donors.add(this);
    }

    // getters and setters
    public String getStatus() {
        return status;
    }

    public String getLastDonateDate() {
        return lastDonateDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastDonateDate(String lastDonateDate) {
        this.lastDonateDate = lastDonateDate;
    }

    // donate blood (return true if success)
    public boolean donateBlood(String postId) {
        Post post = null;
        for (Post i : Post.posts) {
            if (i.getPostId().equals(postId)) {
                post = i;
                break;
            }
        }

        try {
            if (post.addDonor(this)) {
                this.lastDonateDate = post.getDate();
                this.setStatus("Unavailable");
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    // login (return object if success)
    public static Donor login(String aiubId, String password) {
        for (Donor donor : donors) {
            if (donor.getAiubId().equals(aiubId) && donor.getPassword().equals(password)) {
                return donor;
            }
        }

        return null;
    }

    // signup (return object if success)
    public static Donor signup(String aiubId, String name, String email, String contact, String password,
            String bloodGroup) {
        for (int i = 0; i < donors.size(); i++) {
            if (donors.get(i).getAiubId().equals(aiubId)) {
                if (donors.get(i).getPassword().equals(password)) {
                    return donors.get(i);
                } else {
                    return null;
                }
            }
        }

        Donor donor = new Donor(aiubId, name, email, contact, password, bloodGroup);
        donors.add(donor);
        return donor;
    }
}