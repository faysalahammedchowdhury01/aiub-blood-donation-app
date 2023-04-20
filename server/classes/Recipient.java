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
    public boolean createPost(String time, String date, String location, String requiredBloodGroup,
            String description) {
        try {
            String postId = this.getAiubId() + time + date + location + requiredBloodGroup;
            Post post = new Post(postId, this, "open", time, date, location, requiredBloodGroup, description);
            posts.add(post);
            return true;
        } catch (Exception e) {
            return false;
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
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).getAiubId().equals(aiubId)) {
                if (recipients.get(i).getPassword().equals(password)) {
                    return recipients.get(i);
                } else {
                    return null;
                }
            }
        }

        Recipient recipient = new Recipient(aiubId, name, email, contact, password, bloodGroup);
        recipients.add(recipient);
        return recipient;
    }
}