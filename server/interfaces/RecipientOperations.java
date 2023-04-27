package server.interfaces;

public interface RecipientOperations {
    public boolean createPost(String time, String date, String location, String requiredBloodGroup,
            String description);
}
