package server;
import java.lang.*;
import java.util.*;

public class Recipient extends User {
    private List<Post> posts;

    // constructors
    public Recipient() {
    }

    public Recipient(String aiubId, String name, String email, String contact, String password, String bloodGroup,
            boolean isDonor) {
        super(aiubId, name, email, contact, password, bloodGroup, isDonor);
        Recipients.add(this);
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
