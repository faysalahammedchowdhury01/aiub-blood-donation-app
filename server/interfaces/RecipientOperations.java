package server.interfaces;

public interface RecipientOperations {
    // create post (return true if success)
    public boolean createPost(String time, String date, String location, String requiredBloodGroup,
            String description);
}
