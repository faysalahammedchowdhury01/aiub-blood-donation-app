package server.classes;

import server.interfaces.*;
import java.io.*;
import java.util.*;

public class Recipient extends User implements RecipientOperations {
    private int totalRequest;
    private int totalReceived;

    // constructors
    public Recipient() {
    }

    public Recipient(String aiubId, String name, String email, String contact, String password, String bloodGroup) {
        super(aiubId, name, email, contact, password, bloodGroup, false);
        setTotalReceivedRequestFromFile(aiubId);
    }

    // set total received and request from file
    public void setTotalReceivedRequestFromFile(String aiubId) {
        boolean found = false;
        try {
            File newFile = new File("data/recipients.csv");
            Scanner sc = new Scanner(newFile);
            while (sc.hasNext()) {
                String recipient = sc.nextLine();
                String recipientData[] = recipient.split(",");
                if (recipientData.length == 0) {
                    continue;
                }
                if (aiubId.equals(recipientData[0])) {
                    this.totalRequest = Integer.parseInt(recipientData[7]);
                    this.totalReceived = Integer.parseInt(recipientData[8]);
                    found = true;
                }
            }
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }

        if (!found) {
            this.totalRequest = 0;
            this.totalReceived = 0;
        }
    }

    // getters and setters
    public int getTotalRequest() {
        return totalRequest;
    }

    public int getTotalReceived() {
        return totalReceived;
    }

    public List<Post> getMyRequests() {
        List<Post> myPosts = new ArrayList<>();
        try {
            File newFile = new File("data/posts.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String singlePost = sc.nextLine();
                String postData[] = singlePost.split(",");
                if (postData.length == 0) {
                    continue;
                }
                Post post = new Post(postData[0], postData[1], postData[2], postData[3], postData[4], postData[5],
                        postData[6], postData[7]);
                if (post.getAuthorId().equals(this.getAiubId())) {
                    myPosts.add(post);
                }
            }

        } catch (IOException io) {
            return null;
        }

        return myPosts;
    }

    public boolean setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
        String updatedData = getAiubId() + "," + getName() + "," + getEmail() + "," + getContact() + ","
                + getPassword() + "," + getBloodGroup() + "," + getIsDonor() + "," + getTotalRequest() + ","
                + getTotalReceived();
        return updateProfile(updatedData);
    }

    public boolean setTotalReceived(int totalReceived) {
        System.out.println(totalReceived);
        this.totalReceived = totalReceived;
        String updatedData = getAiubId() + "," + getName() + "," + getEmail() + "," + getContact() + ","
                + getPassword() + "," + getBloodGroup() + "," + getIsDonor() + "," + getTotalRequest() + ","
                + getTotalReceived();
        return updateProfile(updatedData);
    }

    // update profile
    public boolean updateProfile(String updatedData) {
        boolean found = false;
        // check post exist or not
        int idx = 0;
        List<String> allRecipients = new ArrayList<String>();
        try {
            File newFile = new File("data/recipients.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String recipient = sc.nextLine();
                if (recipient.isEmpty()) {
                    continue;
                }
                allRecipients.add(recipient);
            }

            for (String recipient : allRecipients) {
                String postData[] = recipient.split(",");
                if (postData[0].equals(this.getAiubId())) {
                    found = true;
                    break;
                }
                idx++;
            }
        } catch (IOException io) {
            return false;
        }

        if (!found) {
            return false;
        }

        // set all recipient again
        try {
            FileWriter file = new FileWriter("data/recipients.csv");
            // insert all previous recipients
            for (int i = 0; i < allRecipients.size(); i++) {
                String recipient = allRecipients.get(i);
                if (i == idx) {
                    recipient = updatedData;
                }
                file.write(recipient + "\n");
            }

            file.close();
            return true;
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return false;
        }
    }

    // create post (return true if success)
    public boolean createPost(String time, String date, String location, String requiredBloodGroup,
            String description) {
        // add new post
        UUID uuid = UUID.randomUUID();
        String postId = uuid.toString();

        // read all posts
        List<String> allPosts = new ArrayList<String>();
        try {
            File newFile = new File("data/posts.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String post = sc.nextLine();
                if (post.isEmpty()) {
                    continue;
                }
                allPosts.add(post);
            }
        } catch (IOException io) {
            return false;
        }

        // push new post
        try {
            FileWriter file = new FileWriter("data/posts.csv");
            // insert all previous posts
            for (String post : allPosts) {
                file.write(post + "\n");
            }
            // add new post
            String newPost = postId + "," + this.getAiubId() + "," + "open" + "," + time + "," + date + "," + location
                    + "," + requiredBloodGroup + "," + description + "," + null;
            file.write(newPost + "\n");

            file.close();
            // increase total requests
            setTotalRequest(this.getTotalRequest() + 1);
            return true;
        } catch (IOException io) {
            return false;
        }

    }

    // delete post (if success return true)
    public boolean deletePost(String postId) {
        boolean deleted = false;
        // check post exist or not
        try {
            File newFile = new File("data/posts.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String singlePost = sc.nextLine();
                String postData[] = singlePost.split(",");
                if (postData.length == 0) {
                    continue;
                }
                if (postData[0].equals(postId)) {
                    Post post = new Post(postData[0], postData[1], postData[2], postData[3], postData[4], postData[5],
                            postData[6], postData[7]);
                    if (post.deletePost(this.getAiubId())) {
                        deleted = true;
                    }
                    break;
                }
            }

        } catch (IOException io) {
            return false;
        }

        // decrease total requests
        if (deleted) {
            this.setTotalRequest(this.getTotalRequest() - 1);
            return true;
        }

        return false;
    }

    // login (return object if success)
    public static Recipient login(String aiubId, String password) {
        // check recipient exist or not
        List<String> allRecipients = new ArrayList<String>();
        try {
            File newFile = new File("data/recipients.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String recipient = sc.nextLine();
                if (recipient.isEmpty()) {
                    continue;
                }
                allRecipients.add(recipient);
            }

            // 0 -> index aiub id, 4 -> index password
            for (String recipient : allRecipients) {
                String recipientData[] = recipient.split(",");
                if (recipientData[0].equals(aiubId) && recipientData[4].equals(password)) {
                    // user found
                    return new Recipient(recipientData[0], recipientData[1], recipientData[2], recipientData[3],
                            recipientData[4],
                            recipientData[5]);
                }
            }
        } catch (IOException io) {
            return null;
        }

        return null;
    }

    // signup (return object if success)
    public static Recipient signup(String aiubId, String name, String email, String contact, String password,
            String bloodGroup) {
        // check already exist or not
        List<String> allRecipients = new ArrayList<String>();
        try {
            File newFile = new File("data/recipients.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String recipient = sc.nextLine();
                if (recipient.isEmpty()) {
                    continue;
                }
                allRecipients.add(recipient);
            }

            // 0 -> index aiub id, 4 -> index password
            for (String recipient : allRecipients) {
                String recipientsData[] = recipient.split(",");
                if (recipientsData[0].equals(aiubId) && recipientsData[4].equals(password)) {
                    // user found
                    return new Recipient(aiubId, name, email, contact, password, bloodGroup);
                }
            }
        } catch (IOException io) {
            return null;
        }

        // add new recipient
        Recipient recipient = new Recipient(aiubId, name, email, contact, password, bloodGroup);
        return addNewRecipient(recipient) ? recipient : null;
    }

    // add new recipient to file(return true if succrss)
    private static boolean addNewRecipient(Recipient r) {
        // read all recipient
        List<String> allRecipients = new ArrayList<String>();
        try {
            File newFile = new File("data/recipients.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String recipient = sc.nextLine();
                if (recipient.isEmpty()) {
                    continue;
                }
                allRecipients.add(recipient);
            }
        } catch (IOException io) {
            return false;
        }

        // push new recipient
        try {
            FileWriter file = new FileWriter("data/recipients.csv");
            // insert all previous user
            for (String recipient : allRecipients) {
                file.write(recipient + "\n");
            }
            // add new recipient
            String newDonor = r.getAiubId() + "," + r.getName() + "," + r.getEmail() + "," + r.getContact() + ","
                    + r.getPassword() + "," + r.getBloodGroup() + "," + r.getIsDonor() + "," + r.getTotalRequest() + ","
                    + r.getTotalReceived();
            file.write(newDonor + "\n");

            file.close();
            return true;
        } catch (IOException io) {
            return false;
        }
    }
}