import java.lang.*;

public class User {
    public static User users[] = new User[500];
    public static int totalUsers;
    private String aiubID;
    private String name;
    private String email;
    private String phoneNum;
    private String password;

    public User() {
    }

    public User(String aiubID, String name, String email, String phoneNum, String password) {
        totalUsers++;
        this.aiubID = aiubID;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
        users[totalUsers - 1] = this;
    }

    public String getAiubID() {
        return aiubID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setAiubID(String aiubID) {
        this.aiubID = aiubID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // code for edit profile
    public void editProfile(String email, String phoneNum, String password) {
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
    }

    // code for create post (return true if successful)
    public boolean createPost(String date, String time, String location,
            String requiredBloodGroup, int requiredBloodBags, String description) {
        Post post = new Post();
        return post.createPost(aiubID + date + time + location, this, date, time, location, requiredBloodGroup,
                requiredBloodBags,
                description);
    }
}