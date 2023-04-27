package server.interfaces;

import server.classes.*;

public interface PostOperations {
    public boolean addDonor(Donor donor);

    public boolean editPost(String aiubId, String date, String time, String location, String description);
}
