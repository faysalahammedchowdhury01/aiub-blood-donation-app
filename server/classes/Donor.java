package server.classes;

import server.interfaces.*;
import java.io.*;
import java.util.*;

public class Donor extends User implements DonorOperations {
    private String status;
    private String lastDonateDate;
    private int totalDonation;

    // constructors
    public Donor() {
    }

    public Donor(String aiubId, String name, String email, String contact, String password, String bloodGroup) {
        super(aiubId, name, email, contact, password, bloodGroup, true);
        setStatusLastDonateTotalDonationFromFile(aiubId);
    }

    // set last donate date, status, from file
    public void setStatusLastDonateTotalDonationFromFile(String aiubId) {
        boolean found = false;
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);
            while (sc.hasNext()) {
                String donor = sc.nextLine();
                String donorData[] = donor.split(",");
                if (donorData.length == 0) {
                    continue;
                }
                if (aiubId.equals(donorData[0])) {
                    this.status = donorData[7];
                    this.lastDonateDate = donorData[8];
                    this.totalDonation = Integer.parseInt(donorData[9]);
                    found = true;
                }
            }
        } catch (IOException ie) {
            System.out.println(ie.getMessage());
        }
        if (!found) {
            this.status = "Available";
            this.lastDonateDate = "N/A";
            this.totalDonation = 0;
        }
    }

    // getters and setters
    public String getStatus() {
        return status;
    }

    public String getLastDonateDate() {
        return lastDonateDate;
    }

    public int getTotalDonation() {
        return totalDonation;
    }

    public boolean setStatus(String status) {
        this.status = status;
        String updatedData = getAiubId() + "," + getName() + "," + getEmail() + "," + getContact() + ","
                + getPassword() + "," + getBloodGroup() + "," + getIsDonor() + "," + getStatus() + ","
                + getLastDonateDate() + "," + getTotalDonation();
        return updateProfile(updatedData);
    }

    public boolean setLastDonateDate(String lastDonateDate) {
        this.lastDonateDate = lastDonateDate;
        String updatedData = getAiubId() + "," + getName() + "," + getEmail() + "," + getContact() + ","
                + getPassword() + "," + getBloodGroup() + "," + getIsDonor() + "," + getStatus() + ","
                + getLastDonateDate() + "," + getTotalDonation();
        return updateProfile(updatedData);
    }

    public boolean setTotalDonation(int totalDonation) {
        this.totalDonation = totalDonation;
        String updatedData = getAiubId() + "," + getName() + "," + getEmail() + "," + getContact() + ","
                + getPassword() + "," + getBloodGroup() + "," + getIsDonor() + "," + getStatus() + ","
                + getLastDonateDate() + "," + getTotalDonation();
        return updateProfile(updatedData);
    }

    public List<Post> getPosts() {
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
                if (post.getRequiredBloodGroup().equals(this.getBloodGroup()) && post.getStatus().equals("open")) {
                    myPosts.add(post);
                }
            }

        } catch (IOException io) {
            return null;
        }

        return myPosts;
    }

    public List<Post> getMyDonations() {
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
                if (post.getDonorId().equals(this.getAiubId())) {
                    System.out.println("Paisi");
                    myPosts.add(post);
                } else {
                    System.out.println(post.getDonorId());
                }
            }

        } catch (IOException io) {
            return null;
        }

        return myPosts;
    }

    // update profile
    public boolean updateProfile(String updatedData) {
        boolean found = false;
        // check donor exist or not
        int idx = 0;
        List<String> allDonors = new ArrayList<String>();
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String donor = sc.nextLine();
                if (donor.isEmpty()) {
                    continue;
                }
                allDonors.add(donor);
            }

            for (String donor : allDonors) {
                String donorData[] = donor.split(",");
                if (donorData[0].equals(this.getAiubId())) {
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

        // set all donor again
        try {
            FileWriter file = new FileWriter("data/donors.csv");
            // insert all previous donors
            for (int i = 0; i < allDonors.size(); i++) {
                String donor = allDonors.get(i);
                if (i == idx) {
                    donor = updatedData;
                }
                file.write(donor + "\n");
            }

            file.close();
            return true;
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return false;
        }
    }

    // donate blood (return true if success)
    public boolean donateBlood(String postId) {
        boolean found = false;
        Post post = null;
        // check post exist or not
        int idx = 0;
        List<String> allPosts = new ArrayList<String>();
        try {
            File newFile = new File("data/posts.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String singlePost = sc.nextLine();
                if (singlePost.isEmpty()) {
                    continue;
                }
                allPosts.add(singlePost);
            }

            for (String singlePost : allPosts) {
                String postData[] = singlePost.split(",");
                if (postData[0].equals(postId)) {
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

        String postData[] = allPosts.get(idx).split(",");
        post = new Post(postData[0], postData[1], postData[2], postData[3], postData[4], postData[5], postData[6],
                postData[7]);

        if (post.addDonor(this.getAiubId())) {
            this.setStatus("Unavailable");
            this.setLastDonateDate(post.getDate());
            this.setTotalDonation(this.getTotalDonation() + 1);
            return true;
        }
        return false;
    }

    // login (return object if success)
    public static Donor login(String aiubId, String password) {
        // check donor exist or not
        List<String> allDonors = new ArrayList<String>();
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String donor = sc.nextLine();
                if (donor.isEmpty()) {
                    continue;
                }
                allDonors.add(donor);
            }

            // 0 -> index aiub id, 4 -> index password
            for (String donor : allDonors) {
                String donorData[] = donor.split(",");
                if (donorData[0].equals(aiubId) && donorData[4].equals(password)) {
                    // user found
                    return new Donor(donorData[0], donorData[1], donorData[2], donorData[3], donorData[4],
                            donorData[5]);
                }
            }
        } catch (IOException io) {
            return null;
        }

        return null;
    }

    // signup (return object if success)
    public static Donor signup(String aiubId, String name, String email, String contact, String password,
            String bloodGroup) {
        // check already exist or not
        if (Donor.isDonorExist(aiubId)) {
            return null;
        }

        // add new donor
        Donor donor = new Donor(aiubId, name, email, contact, password, bloodGroup);
        return addNewDonor(donor) ? donor : null;
    }

    // add new donor to file(return true if succrss)
    private static boolean addNewDonor(Donor d) {
        // read all donor
        List<String> allDonors = new ArrayList<String>();
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String donor = sc.nextLine();
                if (donor.isEmpty()) {
                    continue;
                }
                allDonors.add(donor);
            }
        } catch (IOException io) {
            return false;
        }

        // push new donor
        try {
            FileWriter file = new FileWriter("data/donors.csv");
            // insert all previous user
            for (String donor : allDonors) {
                file.write(donor + "\n");
            }
            // add new donor
            String newDonor = d.getAiubId() + "," + d.getName() + "," + d.getEmail() + "," + d.getContact() + ","
                    + d.getPassword() + "," + d.getBloodGroup() + "," + d.getIsDonor() + "," + d.getStatus() + ","
                    + d.getLastDonateDate() + "," + d.getTotalDonation();
            file.write(newDonor + "\n");

            file.close();
            return true;
        } catch (IOException io) {
            return false;
        }
    }

    // return true if donor exist
    public static boolean isDonorExist(String aiubId) {
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);
            while (sc.hasNext()) {
                String singleDonor = sc.nextLine();
                String donorData[] = singleDonor.split(",");
                if (donorData.length == 0) {
                    continue;
                }
                if (donorData[0].equals(aiubId)) {
                    return true;
                }
            }

        } catch (IOException io) {
            return false;
        }

        return false;
    }

    // reset password (return object if success)
    public static boolean resetPassword(String aiubId, String password) {
        boolean found = false;
        // check donor exist or not
        int idx = 0;
        List<String> allDonors = new ArrayList<String>();
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);

            while (sc.hasNext()) {
                String donor = sc.nextLine();
                if (donor.isEmpty()) {
                    continue;
                }
                allDonors.add(donor);
            }

            for (String donor : allDonors) {
                String donorData[] = donor.split(",");
                if (donorData[0].equals(aiubId)) {
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

        // updated data
        String donorData[] = allDonors.get(idx).split(",");
        String updatedData = donorData[0] + "," + donorData[1] + "," + donorData[2] + "," + donorData[3] + ","
                + password + "," + donorData[5] + "," + donorData[6] + "," + donorData[7] + ","
                + donorData[8] + "," + donorData[9];

        // set all donor again
        try {
            FileWriter file = new FileWriter("data/donors.csv");
            // insert all previous donors
            for (int i = 0; i < allDonors.size(); i++) {
                String donor = allDonors.get(i);
                if (i == idx) {
                    donor = updatedData;
                }
                file.write(donor + "\n");
            }

            file.close();
            return true;
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return false;
        }
    }

    // get all donors
    public static List<Donor> getDonors(String selectedBlood) {
        List<Donor> donors = new ArrayList<>();
        try {
            File newFile = new File("data/donors.csv");
            Scanner sc = new Scanner(newFile);
            while (sc.hasNext()) {
                String singleDonor = sc.nextLine();
                String donorData[] = singleDonor.split(",");
                if (donorData.length == 0) {
                    continue;
                }
                System.out.println("Name: " + donorData[0]);
                Donor donor = new Donor(donorData[0], donorData[1], donorData[2], donorData[3], donorData[4],
                        donorData[5]);
                if ((selectedBlood == null || selectedBlood.equals(donor.getBloodGroup()))) {
                    donors.add(donor);
                }
            }

        } catch (IOException io) {
            return null;
        }

        return donors;
    }
}