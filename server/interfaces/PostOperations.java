package server.interfaces;

import server.classes.*;

public interface PostOperations {
    public boolean addDonor(Donor donor);

    // edit post (return true if successful)
    public boolean editPost(String aiubId, String date, String time, String location, String bloodGroup,
            String description);

    // delete post (return true if successful)
    public boolean deletePost(String aiubId);
}
