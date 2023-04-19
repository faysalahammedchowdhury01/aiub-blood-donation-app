/* 
 * Title: AIUB Blood Donation Society
 * Authors:
 * 1. Faysal Ahammed Chowdhury [22-49046-3]
 * 2. Faysal Ahammed Chowdhury [22-49046-3]
 * 3. Faysal Ahammed Chowdhury [22-49046-3]
 * 4. Faysal Ahammed Chowdhury [22-49046-3]
 */

import server.classes.*;

public class Start {
    public static void main(String[] args) {
        Donor d = Donor.signup("22-49044-3", "Fahim", "fahim@gmail.com", "01819183345", "1233", "A+");
        Recipient r = Recipient.signup("22-49046-3", "Faysal", "faysal@gmail.com", "01610137675", "1233", "A+");

        if (r != null) {
            r.createPost("12:00 PM", "12-04-2023", "Dhaka PG Hospital", "A+", "Urgent");
        }

        System.out.println("\n Avaiable Posts:");
        int cnt = 1;
        for (Post i : Post.posts) {
            System.out.println();
            System.out.println("Post: " + cnt++);
            System.out.println("Status: " + i.getStatus());
            System.out.println("Blood: " + i.getRequiredBloodGroup());
            System.out.println("Author: " + i.getAuthor().getName());
            System.out.println("Time: " + i.getTime());
            System.out.println("Date: " + i.getDate());
            System.out.println("Location: " + i.getLocation());
            System.out.println("Description: " + i.getDescription());
            System.out.println("Donor: " + i.getDonor().getName());
            System.out.println();
        }

        if (d.donateBlood("22-49046-312:00 PM12-04-2023Dhaka PG HospitalA+0")) {
            System.out.println("Donated");
        } else {
            System.out.println("Failed");
        }
    }
}