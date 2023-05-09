package server.classes;

import server.interfaces.*;
import java.io.*;
import java.util.*;

public class Post implements PostOperations {
    private String postId;
    private String authorId;
    private String status;
    private String time;
    private String date;
    private String location;
    private String requiredBloodGroup;
    private String description;
    private String donorId;

    // constructors
    public Post() {

    }

    public Post(String postId, String authorId, String status, String time, String date, String location,
            String requiredBloodGroup, String description) {
        this.postId = postId;
        this.authorId = authorId;
        this.status = status;
        this.time = time;
        this.date = date;
        this.location = location;
        this.requiredBloodGroup = requiredBloodGroup;
        this.description = description;
        setDonorFromFile(postId);
    }

    // set donor from file
    public void setDonorFromFile(String postId) {
        boolean found = false;
        try {
            File newFile = new File("data/posts.csv");
            Scanner sc = new Scanner(newFile);
            while (sc.hasNext()) {
                String post = sc.nextLine();
                String postData[] = post.split(",");
                if (this.postId.equals(postData[0])) {
                    this.donorId = postData[8];
                    found = true;
                }
            }
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
        if (!found) {
            this.donorId = "";
        }
    }

    // getters and setters
    public String getPostId() {
        return postId;
    }

    public String getAuthorId() {
        return authorId;
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

    public String getDonorId() {
        return donorId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
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

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    // get author
    public static Recipient getAuthor(String authorId) {
        // check recipient exist or not
        List<String> allRecipients = new ArrayList<String>();
        try {
            File newFile = new File("data/recipients.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String recipient = sc.nextLine();
                allRecipients.add(recipient);
            }

            // 0 -> index aiub id
            for (String recipient : allRecipients) {
                String recipientData[] = recipient.split(",");

                if (recipientData[0].equals(authorId)) {
                    // user found
                    return new Recipient(recipientData[0], recipientData[1], recipientData[2], recipientData[3],
                            recipientData[4],
                            recipientData[5]);
                }
            }
        } catch (IOException io) {
            return null;
        }

        return null;
    }

    // get donor
    public static Donor getDonor(String donorId) {
        // check donor exist or not
        List<String> allDonors = new ArrayList<String>();
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String donor = sc.nextLine();
                allDonors.add(donor);
            }

            // 0 -> index aiub id
            for (String donor : allDonors) {
                String donorData[] = donor.split(",");
                if (donorData[0].equals(donorId)) {
                    // user found
                    return new Donor(donorData[0], donorData[1], donorData[2], donorData[3], donorData[4],
                            donorData[5]);
                }
            }
        } catch (

        IOException io) {
            return null;
        }

        return null;
    }

    // update post data (return true if successful)
    private boolean updatePostData(String editedPost) {
        boolean found = false;
        // check post exist or not
        int idx = 0;
        List<String> allPosts = new ArrayList<String>();
        try {
            File newFile = new File("data/posts.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String post = sc.nextLine();
                allPosts.add(post);
            }

            for (String post : allPosts) {
                String postData[] = post.split(",");
                if (postData[0].equals(postId)) {
                    found = true;
                    break;
                }
                idx++;
            }
        } catch (IOException io) {
            return false;
        }

        if (!found) {
            return false;
        }

        // set all post again
        try {
            FileWriter file = new FileWriter("data/posts.csv");
            // insert all previous posts
            for (int i = 0; i < allPosts.size(); i++) {
                String post = allPosts.get(i);
                if (i == idx) {
                    post = editedPost;
                }
                file.write(post + "\n");
            }

            file.close();
            return true;
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return false;
        }
    }

    // add donor (return true if successful)
    public boolean addDonor(String donorId) {
        Donor d = getDonor(donorId);
        if (this.status.equals("open") && this.requiredBloodGroup.equals(d.getBloodGroup())) {
            this.donorId = donorId;
            this.status = "closed";

            // edit post
            String editedPost = this.postId + "," + this.authorId + "," + this.status + "," + this.time + ","
                    + this.date + "," + this.location + "," + this.requiredBloodGroup + "," + this.description + ","
                    + this.donorId;

            if (updatePostData(editedPost)) {
                System.out.print(d.getName());
                Recipient r = getAuthor(this.authorId);
                r.setTotalRequest(r.getTotalRequest());
                return r.setTotalReceived(r.getTotalReceived() + 1);
            }
        }
        return false;

    }

    // edit post (return true if successful)
    public boolean editPost(String aiubId, String date, String time, String location, String bloodGroup,
            String description) {
        if (this.authorId.equals(aiubId) && this.status.equals("open")) {
            this.date = date;
            this.time = time;
            this.location = location;
            this.requiredBloodGroup = bloodGroup;
            this.description = description;

            // edit post
            String editedPost = this.postId + "," + this.authorId + "," + this.status + "," + this.time + ","
                    + this.date + "," + this.location + "," + this.requiredBloodGroup + "," + this.description + ","
                    + this.donorId;

            return updatePostData(editedPost);
        }

        return false;
    }

    // delete post (return true if successful)
    public boolean deletePost(String aiubId) {
        if (this.authorId.equals(aiubId) && this.status.equals("open")) {
            // check post exist or not
            int idx = 0;
            List<String> allPosts = new ArrayList<String>();
            try {
                File newFile = new File("data/posts.csv");
                Scanner sc = new Scanner(newFile);

                while (sc.hasNext()) {
                    String post = sc.nextLine();
                    allPosts.add(post);
                }

                for (String post : allPosts) {
                    String postData[] = post.split(",");
                    if (postData[0].equals(postId)) {
                        break;
                    }
                    idx++;
                }
            } catch (IOException io) {
                return false;
            }

            // delete this post
            try {
                FileWriter file = new FileWriter("data/posts.csv");
                // insert all previous posts
                for (int i = 0; i < allPosts.size(); i++) {
                    String post = allPosts.get(i);
                    if (i != idx) {
                        file.write(post + "\n");
                    }
                }

                file.close();
            } catch (IOException io) {
                return false;
            }
            // decrease total request of "Recipient"
            Recipient r = getAuthor(this.authorId);
            return r.setTotalRequest(r.getTotalRequest() - 1);
        }

        return false;
    }
}