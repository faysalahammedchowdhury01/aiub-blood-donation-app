package server.classes;

import server.interfaces.*;
import java.util.*;

public class Recipient extends User implements RecipientOperations {
    private int totalRequest;
    private int totalReceived;

    // constructors
    public Recipient() {
    }

    public Recipient(String aiubId, String name, String email, String contact, String password, String bloodGroup) {
        super(aiubId, name, email, contact, password, bloodGroup, false);
        totalRequest = 0;
        totalReceived = 0;
        recipients.add(this);
    }

    // getters and setters
    public int getTotalRequest() {
        return totalRequest;
    }

    public int getTotalReceived() {
        return totalReceived;
    }

    public void setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
    }

    public void setTotalReceived(int totalReceived) {
        this.totalReceived = totalReceived;
    }

    // create post (return true if success)
    public boolean createPost(String time, String date, String location, String requiredBloodGroup,
            String description) {
        try {
            UUID uuid = UUID.randomUUID();
            String uniqueId = uuid.toString();

            String postId = this.getAiubId() + time + date + location + requiredBloodGroup + uniqueId;
            new Post(postId, this, "open", time, date, location, requiredBloodGroup, description);
            totalRequest++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // login (return object if success)
    public static Recipient login(String aiubId, String password) {
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).getAiubId().equals(aiubId) && recipients.get(i).getPassword().equals(password)) {
                return recipients.get(i);
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
        return recipient;
    }
}