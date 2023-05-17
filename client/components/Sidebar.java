package client.components;

import client.assets.Color.MyColor;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Sidebar extends JPanel {
    // navbar
    private JButton backToHome;
    private JButton myDonationsButton;
    private JButton myRequestsButton;
    private JButton findDonorButton;
    private JButton logoutButton;

    public Sidebar(User u, Frame frame) {

        // set the layout and background color of the panel
        setLayout(null);
        setBackground(Color.lightGray);

        // go home button
        backToHome = new JButton("Home");
        backToHome.setBounds(10, 10, 230, 65);
        backToHome.setBackground(MyColor.black);
        backToHome.setForeground(MyColor.white);
        backToHome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        backToHome.setBorderPainted(false);
        backToHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // my donations button
        myDonationsButton = new JButton("My Donations");
        myDonationsButton.setBounds(10, 85, 230, 65);
        myDonationsButton.setBackground(MyColor.black);
        myDonationsButton.setForeground(MyColor.white);
        myDonationsButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        myDonationsButton.setBorderPainted(false);
        myDonationsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // my requests button
        myRequestsButton = new JButton("My Requests");
        myRequestsButton.setBounds(10, 85, 230, 65);
        myRequestsButton.setBackground(MyColor.black);
        myRequestsButton.setForeground(MyColor.white);
        myRequestsButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        myRequestsButton.setBorderPainted(false);
        myRequestsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // find donor button
        findDonorButton = new JButton("Find Donor");
        findDonorButton.setBounds(10, 160, 230, 65);
        findDonorButton.setBackground(MyColor.black);
        findDonorButton.setForeground(MyColor.white);
        findDonorButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        findDonorButton.setBorderPainted(false);
        findDonorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // logout button
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 235, 230, 65);
        logoutButton.setBackground(MyColor.black);
        logoutButton.setForeground(MyColor.white);
        logoutButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        logoutButton.setBorderPainted(false);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // add to panel
        add(backToHome);
        add(findDonorButton);
        add(logoutButton);
        if (u.getIsDonor()) {
            add(myDonationsButton);
        } else {
            add(myRequestsButton);
        }

        // action listeners

        // go home action
        backToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (u.getIsDonor()) {
                    frame.setVisible(false);
                    new DonorDashboard(Donor.login(u.getAiubId(), u.getPassword()));
                } else {
                    frame.setVisible(false);
                    new RecipientDashboard(Recipient.login(u.getAiubId(), u.getPassword()));
                }
            }
        });

        // my donations action
        myDonationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (u.getIsDonor()) {
                    frame.setVisible(false);
                    new MyDonations(Donor.login(u.getAiubId(), u.getPassword()));
                }
            }
        });

        // my requests action
        myRequestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!u.getIsDonor()) {
                    frame.setVisible(false);
                    new MyRequests(Recipient.login(u.getAiubId(), u.getPassword()));
                }
            }
        });

        // find donor action
        findDonorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new DonorsList(u, null);
            }
        });

        // logout action
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
    }

}
