/* 
 * Title: AIUB Blood Donation Society App
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
        Donor d = Donor.signup("22-49044-3", "Fahim", "fahim@gmail.com",
                "01819183345", "1234", "A+");
        Recipient r = Recipient.signup("22-49046-3", "Faysal", "faysal@gmail.com",
                "01610137675", "1233", "A+");

        // System.out.println("Donors: ");
        // System.out.println(d);
        // System.out.println(d2);

        // System.out.println("Recipients: ");
        // System.out.println(r);

        // if (r != null) {
        // System.out.println(r.createPost("12:00 PM", "12-04-2023", "Dhaka PG
        // Hospital", "A+", "Urgent"));
        // }

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

        // String postId = "22-49046-312:00 PM12-04-2023Dhaka PG HospitalA+";
        // if (d.donateBlood(postId)) {
        // System.out.println("Donated");
        // } else {
        // System.out.println("Failed Donate");
        // }

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
        new Login();
        // new Signup();
    }
}