package server.classes;

import java.util.*;

public class Post {
    public static List<Post> posts;
    private String postId;
    private Recipient author;
    private String status;
    private String time;
    private String date;
    private String location;
    private String requiredBloodGroup;
    private String description;
    private Donor donor;

    static {
        posts = new ArrayList<>();
    }

    // constructors
    public Post() {

    }

    public Post(String postId, Recipient author, String status, String time, String date, String location,
            String requiredBloodGroup, String description) {
        this.postId = postId;
        this.author = author;
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

    public Recipient getAuthor() {
        return author;
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

    public Donor getDonor() {
        return donor;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setAuthor(Recipient author) {
        this.author = author;
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

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    // add donor (return true if successful)
    public boolean addDonor(Donor donor) {
        if (this.donor == null && this.requiredBloodGroup == donor.getBloodGroup()) {
            this.donor = donor;
            this.status = "close";
            return true;
        }
        return false;
    }

    // edit post (return true if successful)
    public boolean editPost(String aiubId, String date, String time, String location, String description) {
        if (this.author.getAiubId().equals(aiubId) && this.status.equals("open")) {
            this.date = date;
            this.time = time;
            this.location = location;
            this.description = description;
            return true;
        }

        return false;
    }

}