package server.interfaces;

import server.classes.*;

public interface RecipientOperations {
    // create post (return true if success)
    public boolean createPost(String time, String date, String location, String requiredBloodGroup,
            String description);

    // delete post (return true if success)
    public boolean deletePost(String postId);
}