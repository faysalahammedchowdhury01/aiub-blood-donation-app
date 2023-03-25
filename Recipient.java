import java.lang.*;
import java.util.*;

public class Recipient extends User {
    private List<String> postsId;

    // constructors
    public Recipient() {
    }

    public Recipient(String aiubId, String name, String email, String contact, String password, String bloodGroup,
            boolean isDonor) {
        super(aiubId, name, email, contact, password, bloodGroup, isDonor);
        Recipients.add(this);
    }

    // create post (return true if possible)
    public boolean createPost(String status, String time, String date, String location, String requiredBloodGroup,
            String description) {
        String postId = this.getAiubId() + time + date + location + requiredBloodGroup;
        new Post(postId, this.getAiubId(), "Open", time, date, location, requiredBloodGroup, description);
        postsId.add(postId);
        return true;
    }

    // login (return object if success)
    public static Recipient Login(String aiubId, String password) {
        for (Recipient i : Recipients) {
            if (i.getAiubId().equals(aiubId) && i.getPassword().equals(password)) {
                return i;
            }
        }

        return null;
    }
}
