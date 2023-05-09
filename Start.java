/* 
 * Title: AIUB BLOOD DONATION CLUB
 * Authors:
 * 1. CHOWDHURY, FAYSAL AHAMMED [22-49046-3]
 * 2. Faysal Ahammed Chowdhury [22-49046-3]
 * 3. Faysal Ahammed Chowdhury [22-49046-3]
 * 4. RAHI, MD RAYHANUL HAQUE [22-47876-2]
 */

import server.classes.*;
import client.components.*;

public class Start {
        public static void main(String[] args) {
                // Donor d = Donor.signup("22-49045-3", "Fahim Ahammed Chowdhury Fahim",
                // "fahim@gmail.com",
                // "01819183345", "1234", "A+");
                // Donor d1 = Donor.signup("22-490415-3", "Fahim", "fahim@gmail.com",
                // "01819183345", "1234", "A-");
                // Donor d2 = Donor.signup("22-419045-3", "Fahim", "fahim@gmail.com",
                // "01819183345", "1234", "B+");
                // Donor d3 = Donor.signup("22-149045-3", "Fahim", "fahim@gmail.com",
                // "01819183345", "1234", "A+");
                // Donor d4 = Donor.signup("22-14904a5-3", "Fahim", "fahim@gmail.com",
                // "01819183345", "1234", "A+");
                // Donor d5 = Donor.signup("22-14a9045-3", "Fahim", "fahim@gmail.com",
                // "01819183345", "1234", "A+");
                // Donor d6 = Donor.signup("22-14d9045-3", "Fahim", "fahim@gmail.com",
                // "01819183345", "1234", "A+");
                // Recipient r = Recipient.signup("22-49046-3", "Faysal", "faysal@gmail.com",
                // "01610137675", "1111", "A-");

                // System.out.println("Donors: ");
                // System.out.println(d);
                // System.out.println(d2);

                // System.out.println("Recipients: ");
                // System.out.println(r);

                // if (r != null) {
                // System.out.println(r.createPost("12:00 PM", "12-04-2023", "Dhaka Hospital",
                // "AB+",
                // "Urgent for me"));
                // System.out.println(r.createPost("1:00 PM", "12-04-2023", "Labaid Dhanmondi",
                // "A+",
                // "Acciedent patient"));
                // System.out.println(r.createPost("2:00 PM", "12-04-2023", "Labaid Dhanmondi",
                // "A+",
                // "Acciedent patient"));
                // System.out.println(r.createPost("2:00 PM", "12-04-2023", "Labaid Dhanmondi",
                // "A+",
                // "Acciedent patient"));
                // System.out.println(r.createPost("2:00 PM", "12-04-2023", "Ibn Sina Uttara",
                // "A+",
                // "Urgent"));
                // }

                // d.donateBlood(Post.posts.get(0).getPostId());
                // d.donateBlood(Post.posts.get(1).getPostId());

                // System.out.println("\n Avaiable Posts:");
                // int cnt = 1;
                // for (Post i : Post.posts) {
                // System.out.println();
                // System.out.println("Post: " + cnt++);
                // System.out.println("Status: " + i.getStatus());
                // System.out.println("Blood: " + i.getRequiredBloodGroup());
                // System.out.println("Author: " + i.getAuthor().getName());
                // System.out.println("Time: " + i.getTime());
                // System.out.println("Date: " + i.getDate());
                // System.out.println("Location: " + i.getLocation());
                // System.out.println("Description: " + i.getDescription());
                // System.out.println("Donor: " + i.getDonor());
                // System.out.println();
                // }

                // System.out.println("Donor:");
                // System.out.println("Status:" + d.getStatus());
                // System.out.println("Last:" + d.getLastDonateDate());

                // System.out.println("\n Avaiable Posts:");
                // cnt = 1;
                // for (Post i : Post.posts) {
                // System.out.println();
                // System.out.println("Post: " + cnt++);
                // System.out.println("Status: " + i.getStatus());
                // System.out.println("Blood: " + i.getRequiredBloodGroup());
                // System.out.println("Author: " + i.getAuthor().getName());
                // System.out.println("Time: " + i.getTime());
                // System.out.println("Date: " + i.getDate());
                // System.out.println("Location: " + i.getLocation());
                // System.out.println("Description: " + i.getDescription());
                // if (i.getDonor() != null)
                // System.out.println("Donor: " + i.getDonor().getName());
                // System.out.println();
                // }

                // System.out.println("Donor:");
                // System.out.println("Status:" + d.getStatus());
                // System.out.println("Last:" + d.getLastDonateDate());

                // file system
                // Donor d = Donor.signup("22-49045-3", "Rakib", "Rakib@gmail.com",
                // "01610137675",
                // "1111", "A-");

                // Recipient r = Recipient.signup("22-49046a-3", "Faysal",
                // "faysalahammedchowdhury01@gmail.com",
                // "01610137675",
                // "1111", "A+");

                // r.createPost("12:00PM", "12-April-2023", "Dhaka", "A-", "urgent");
                // r.createPost("12:00PM", "12-April-2023", "Dhaka", "A-", "urgent");
                // System.out.println(d.donateBlood("4d0955d3-2c0b-4f50-bcd7-043b09e22bd6"));
                // Post post = new Post("55", "22-49046-3", "open", null, null, null, "A+",
                // null);
                // post.editPost("22-49046-3", null, null, null, "A+", null);
                // System.out.println(d.donateBlood("55"));
                // post.deletePost("22-49046-3");

                // Client
                new Login();
                // new Signup();
                // new RecipientDashboard(r);
                // new DonorDashboard(d);
                // new MyRequests(r);
                // new MyDonations(d);
                // new DonorsProfile(d, r);
                // new DonorsProfile(d, d);
                // new RecipientsProfile(r, d);
                // new RecipientsProfile(r, r);
                // new EditPost(Post.posts.get(0), r);
                // new DonorsList(r, null);
        }
}