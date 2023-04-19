package server.classes;

import java.util.*;

public class Recipient extends User {
    protected List<Post> posts;

    // constructors
    public Recipient() {
    }

    public Recipient(String aiubId, String name, String email, String contact, String password, String bloodGroup) {
        super(aiubId, name, email, contact, password, bloodGroup, false);
        recipients.add(this);
    }

    // create post
    public void createPost(String time, String date, String location, String requiredBloodGroup, String description) {
        try {
            String postId = "hello";
            Post post = new Post(postId, this, "open", time, date, location, requiredBloodGroup, description);
            posts.add(post);
        } catch (Exception ex) {
            System.out.println("Failed post");
        }
    }

    // login (return object if success)
    public static Recipient login(String aiubId, String password) {
        for (Recipient i : recipients) {
            if (i.getAiubId().equals(aiubId) && i.getPassword().equals(password)) {
                return i;
            }
        }

        return null;
    }

    // signup (return object if success)
    public static Recipient signup(String aiubId, String name, String email, String contact, String password,
            String bloodGroup) {
        boolean userExist = false;
        for (Recipient recipient : recipients) {
            if (recipient.getAiubId().equals(aiubId)) {
                userExist = true;
                break;
            }
        }
        if (userExist) {
            Recipient recipient = new Recipient(aiubId, name, email, contact, password, bloodGroup);
            recipients.add(recipient);
            return recipient;
        }

        return null;
    }
}