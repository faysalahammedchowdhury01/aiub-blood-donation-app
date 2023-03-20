import java.lang.*;

public class Donor extends User {
    private int donationCount;
    private boolean status;
    private String bloodGroup;
    private String lastDonateDate;

    public Donor() {
    }

    public Donor(String aiubID, String name, String email, String phoneNum, String password, String bloodGroup) {
        super(aiubID, name, email, phoneNum, password);
        this.status = true;
        this.donationCount = 0;
        this.bloodGroup = bloodGroup;
        users[totalUsers - 1] = this;
    }

    // getters and setters
    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setLastDonateDate(String lastDonateDate) {
        this.lastDonateDate = lastDonateDate;
    }

    public boolean getStatus() {
        return status;
    }

    public int getDonationCount() {
        return donationCount;
    }

    public String getLastDonateDate() {
        return lastDonateDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    // donate blood groups (return true if successful)
    public boolean donateBlood(Post post) {
        if (post != null && post.addDonor(this)) {
            lastDonateDate = post.getDate();
            donationCount++;
            return true;
        }

        return false;
    }
}
