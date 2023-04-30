package server.classes;

import server.interfaces.*;

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

    // create post
    public boolean createPost(String time, String date, String location, String requiredBloodGroup,
            String description) {
        try {
            String postId = this.getAiubId() + time + date + location + requiredBloodGroup;
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
        recipients.add(recipient);
        return recipient;
    }
}