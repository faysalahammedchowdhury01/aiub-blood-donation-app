import java.lang.*;

public class Post {
    public static Post posts[] = new Post[500];
    public static int totalPosts;
    private String postId;
    private User recipient;
    private boolean status;
    private String date;
    private String time;
    private String location;
    private String requiredBloodGroup;
    private int requiredBloodBags;
    private int donorCount;
    private String description;
    private Donor donors[] = new Donor[500];

    public Post() {
    }

    // code for create a post (return true if successful)
    public boolean createPost(String postId, User recipient, String date, String time, String location,
            String requiredBloodGroup,
            int requiredBloodBags, String description) {
        this.postId = postId;
        this.recipient = recipient;
        this.status = false; // false means 'open'
        this.date = date;
        this.time = time;
        this.location = location;
        this.requiredBloodGroup = requiredBloodGroup;
        this.requiredBloodBags = requiredBloodBags;
        this.donorCount = 0;
        this.description = description;
        if (totalPosts < 500) {
            totalPosts++;
            posts[totalPosts - 1] = this;
            return true;
        } else {
            return false;
        }
    }

    // getters and setters
    public String getPostId() {
        return postId;
    }

    public User getRecipient() {
        return recipient;
    }

    public boolean getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getRequiredBloodGroup() {
        return requiredBloodGroup;
    }

    public int getRequiredBloodBags() {
        return requiredBloodBags;
    }

    public String getDescription() {
        return description;
    }

    public Donor[] getDonors() {
        return donors;
    }

    public int getDonorCount() {
        return donorCount;
    }

    public void setDonors(Donor[] donors) {
        this.donors = donors;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRequiredBloodBags(int requiredBloodBags) {
        this.requiredBloodBags = requiredBloodBags;
    }

    public void setRequiredBloodGroup(String requiredBloodGroup) {
        this.requiredBloodGroup = requiredBloodGroup;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // add donor (return true if successful)
    public boolean addDonor(Donor donor) {
        if (!status && donorCount < requiredBloodBags && donor.getBloodGroup().equals(requiredBloodGroup)) {
            for (int i = 0; i < donorCount; i++) {
                if (donors[i] == donor)
                    return false;
            }
            donorCount++;
            donors[donorCount - 1] = donor;
            return true;
        }

        return false;
    }

    // code for close a post (return true if successful)
    public boolean closePost(User user) {
        if (user == recipient) {
            this.status = true; // true means 'closed'
            return true;
        }

        return false;
    }

    // edit post (return true if successful)
    public boolean editPost(User recipient, String date, String time, String location,
            int requiredBloodBags, String description) {
        if (this.recipient == recipient) {
            this.date = date;
            this.time = time;
            this.location = location;
            this.requiredBloodBags = requiredBloodBags;
            this.description = description;
            return true;
        }

        return false;
    }
}
