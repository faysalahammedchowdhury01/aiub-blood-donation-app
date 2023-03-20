import java.lang.*;

public class Start {
    public static void main(String[] args) {
        User u1 = new User("22-49046-3", "Fahim", "fahim@gmail.com", "01610137675", "passwordBolaJabeNa");
        Donor d1 = new Donor("22-49045-3", "Rakib", "rakib@gmail.com", "01810137675",
                "passwordBolaJabeNa2", "A+");
        u1.createPost("25-Mar-2024", "12:00 PM", "Dhaka", "A+", 5, "Urgent Needed");
        u1.createPost("21-Mar-2024", "12:00 PM", "Dhaka", "A+", 5, "Urgent Needed");
        System.out.println(Post.posts[0].closePost(u1));
        if (d1.donateBlood(Post.posts[1])) {
            System.out.println("Donation Successful");
        } else {
            System.out.println("Donation Failed");
        }
        if (d1.donateBlood(Post.posts[0])) {
            System.out.println("Donation Successful");
        } else {
            System.out.println("Donation Failed");
        }
        System.out.println(d1.getDonationCount());
        System.out.println(d1.getLastDonateDate());

        for (int i = 0; i < Post.totalPosts; i++) {
            System.out.println(Post.posts[i].getRecipient().getName());
            System.out.println(Post.posts[i].getStatus());
        }
    }
}
