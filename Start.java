/* 
 * Title: AIUB BLOOD DONATION CLUB
 * Authors:
 * 1. Faysal Ahammed Chowdhury [22-49046-3]
 * 2. Faysal Ahammed Chowdhury [22-49046-3]
 * 3. Faysal Ahammed Chowdhury [22-49046-3]
 * 4. Faysal Ahammed Chowdhury [22-49046-3]
 */

import server.classes.*;
import client.*;

public class Start {
        public static void main(String[] args) {
                Donor d = Donor.signup("22-49045-3", "Fahim", "fahim@gmail.com",
                                "01819183345", "1234", "A+");
                Recipient r = Recipient.signup("22-49046-3", "Faysal", "faysal@gmail.com",
                                "01610137675", "1111", "A+");

                // System.out.println("Donors: ");
                // System.out.println(d);
                // System.out.println(d2);

                // System.out.println("Recipients: ");
                // System.out.println(r);

                if (r != null) {
                        System.out.println(r.createPost("12:00 PM", "12-04-2023", "Dhaka Hospital",
                                        "AB+",
                                        "Urgent for me"));
                        System.out.println(r.createPost("1:00 PM", "12-04-2023", "Labaid Dhanmondi",
                                        "A+",
                                        "Acciedent patient"));
                        System.out.println(r.createPost("2:00 PM", "12-04-2023", "Labaid Dhanmondi",
                                        "A+",
                                        "Acciedent patient"));
                        System.out.println(r.createPost("2:00 PM", "12-04-2023", "Labaid Dhanmondi",
                                        "A+",
                                        "Acciedent patient"));
                        System.out.println(r.createPost("2:00 PM", "12-04-2023", "Ibn Sina Uttara",
                                        "A+",
                                        "Urgent"));
                }

                if (d.donateBlood("22-49046-31:00 PM12-04-2023Labaid DhanmondiA+")) {
                        System.out.println("Donated");
                } else {
                        System.out.println("Failed");
                }

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

                // Client
                // new Login();
                // new Signup();
                // new RecipientDashboard(r);
                // new DonorDashboard(d);
                // new MyRequests(r);
                // new MyDonations(d);
                // new DonorsProfile(d, r);
                // new DonorsProfile(d, d);
                // new RecipientsProfile(r, d);
                // new RecipientsProfile(r, r);
                new EditPost(Post.posts.get(0), r);
        }
}