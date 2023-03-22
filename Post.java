import java.lang.*;
import java.util.*;

public class Post {
    public static List<Post> posts;
    private String postId;
    private String authorsAiubId;
    private String status;
    private String time;
    private String date;
    private String location;
    private String requiredBloodGroup;
    private String description;
    String donorsAiubId;

    static {
        posts = new ArrayList<>();
    }

    // constructors
    public Post() {

    }

    public Post(String postId, String authorsAiubId, String status, String time, String date, String location,
            String requiredBloodGroup, String description) {
        this.postId = postId;
        this.authorsAiubId = authorsAiubId;
        this.status = status;
        this.time = time;
        this.date = date;
        this.location = location;
        this.requiredBloodGroup = requiredBloodGroup;
        this.description = description;
        posts.add(this);
    }

    // getters and setters
    public String getPostId() {
        return postId;
    }

    public String getAuthorsAiubId() {
        return authorsAiubId;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getRequiredBloodGroup() {
        return requiredBloodGroup;
    }

    public String getDescription() {
        return description;
    }

    public String getdonorsAiubId() {
        return donorsAiubId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setAuthorsAiubId(String authorsAiubId) {
        this.authorsAiubId = authorsAiubId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setRequiredBloodGroup(String requiredBloodGroup) {
        this.requiredBloodGroup = requiredBloodGroup;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setdonorsAiubId(String donorsAiubId) {
        this.donorsAiubId = donorsAiubId;
    }

    // add donor (return true if successful)
    public boolean addDonor(String donorsAiubId) {
        if (status.equals("Opens") && this.donorsAiubId == null && User.doesUserExist(donorsAiubId)) {
            for (Donor i : User.Donors) {
                if (i.getAiubId().equals(donorsAiubId) && i.getBloodGroup().equals(requiredBloodGroup)) {
                    this.donorsAiubId = donorsAiubId;
                    return true;
                }
            }
        }

        return false;
    }

    // code for close a post (return true if successful)
    public boolean closePost(String aiubId) {
        if (this.authorsAiubId == aiubId) {
            this.status = "Closed";
            return true;
        }
        return false;
    }

    // edit post (return true if successful)
    public boolean editPost(String aiubId, String date, String time, String location, String description) {
        if (this.authorsAiubId == aiubId) {
            this.date = date;
            this.time = time;
            this.location = location;
            this.description = description;
            return true;
        }

        return false;
    }

}
