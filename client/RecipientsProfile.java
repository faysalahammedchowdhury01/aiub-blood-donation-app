package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class RecipientsProfile {
    User u;
    private boolean isShowDropdown;

    JFrame frame;
    private JPanel mainPanel, navbarPanel;
    private JScrollPane scrollPane;
    private ImageIcon favIcon, icon;
    // navbar
    private BufferedImage image;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel aiubText;
    private JButton name;
    private JLabel dropdownBox;
    private JButton goHomeButton;
    private JButton myDonationsButton;
    private JButton myRequestsButton;
    private JButton donorsListButton;
    private JButton logoutButton;

    // profile
    private JLabel profileBg;
    private JLabel nameLabel;
    private JLabel userTypeLabel;
    private JLabel bloodLabel;
    private JLabel aiubIdLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel totalRequestLabel;
    private JLabel totalReceivedLabel;
    private JLabel pendingRequest;

    public RecipientsProfile(Recipient r, User u) {
        this.u = u;
        frame = new JFrame("Profile - " + r.getName() + " [" + r.getAiubId() + "]" + " - AIUB BLOOD DONATION CLUB");

        // favIcon
        favIcon = new ImageIcon("images/logo.png");
        frame.setIconImage(favIcon.getImage());

        // navbar panel
        navbarPanel = new JPanel();
        navbarPanel.setLayout(null);
        navbarPanel.setPreferredSize(new Dimension(1366, 80));
        navbarPanel.setBackground(new Color(169, 29, 20));

        // aiub and blood logo
        try {
            image = ImageIO.read(new File("images/aiub_logo_sm.png"));
            aiubLogo = new JLabel(new ImageIcon(image));
            aiubLogo.setBounds(50, 15, image.getWidth(), image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            image = ImageIO.read(new File("images/logo_sm.png"));
            logo = new JLabel(new ImageIcon(image));
            logo.setBounds(100, 15, image.getWidth(), image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // aiub text
        aiubText = new JLabel("AIUB BLOOD DONATION CLUB");
        aiubText.setBounds(160, 15, 400, 50);
        aiubText.setForeground(Color.WHITE);
        aiubText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));

        // name label and dropdown
        icon = new ImageIcon("images/dropdown.png");
        name = new JButton("Welcome, " + u.getName().split(" ")[0], icon);
        name.setBounds(1366 - 320, 15, 250, 50);
        name.setForeground(Color.WHITE);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // dropdown box
        dropdownBox = new JLabel("");
        dropdownBox.setBounds(1366 - 300, 70, 250, 330);
        dropdownBox.setBackground(Color.GRAY);
        dropdownBox.setOpaque(true);
        dropdownBox.setVisible(false);
        isShowDropdown = false;

        // go home button
        goHomeButton = new JButton("Home");
        goHomeButton.setBounds(1366 - 280, 80, 210, 65);
        goHomeButton.setBackground(Color.WHITE);
        goHomeButton.setForeground(Color.BLACK);
        goHomeButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        goHomeButton.setBorderPainted(false);
        goHomeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        goHomeButton.setVisible(false);

        // my donations button
        myDonationsButton = new JButton("My Donations");
        myDonationsButton.setBounds(1366 - 280, 160, 210, 65);
        myDonationsButton.setBackground(Color.WHITE);
        myDonationsButton.setForeground(Color.BLACK);
        myDonationsButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        myDonationsButton.setBorderPainted(false);
        myDonationsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myDonationsButton.setVisible(false);

        // my requests button
        myRequestsButton = new JButton("My Requests");
        myRequestsButton.setBounds(1366 - 280, 160, 210, 65);
        myRequestsButton.setBackground(Color.WHITE);
        myRequestsButton.setForeground(Color.BLACK);
        myRequestsButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        myRequestsButton.setBorderPainted(false);
        myRequestsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myRequestsButton.setVisible(false);

        // donors list button
        donorsListButton = new JButton("Donors List");
        donorsListButton.setBounds(1366 - 280, 240, 210, 65);
        donorsListButton.setBackground(Color.WHITE);
        donorsListButton.setForeground(Color.BLACK);
        donorsListButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        donorsListButton.setBorderPainted(false);
        donorsListButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        donorsListButton.setVisible(false);

        // logout button
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1366 - 280, 320, 210, 65);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        logoutButton.setBorderPainted(false);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setVisible(false);

        // navbar adding
        navbarPanel.add(aiubLogo);
        navbarPanel.add(logo);
        navbarPanel.add(aiubText);
        navbarPanel.add(name);
        frame.add(goHomeButton);
        frame.add(myDonationsButton);
        frame.add(myRequestsButton);
        frame.add(donorsListButton);
        frame.add(logoutButton);
        frame.add(dropdownBox);

        // profile bg
        profileBg = new JLabel();
        profileBg.setBounds(50, 120, 1260, 520);
        profileBg.setOpaque(true);
        profileBg.setBackground(new Color(4, 78, 161));

        // name label
        nameLabel = new JLabel(
                "<html><b>Name: </b><span color=\"black\" style=\"background:white\">" + r.getName()
                        + "</span></html>");
        nameLabel.setBounds(100, 150, 1000, 50);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // user type label
        userTypeLabel = new JLabel(
                "<html><b>Type: </b><span color=\"black\" style=\"background:white\">Recipient</span></html>");
        userTypeLabel.setBounds(100, 200, 1000, 50);
        userTypeLabel.setForeground(Color.WHITE);
        userTypeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // blood label
        bloodLabel = new JLabel(
                "<html><b>Blood: </b><span color=\"black\" style=\"background:white\">" + r.getBloodGroup()
                        + "</span></html>");
        bloodLabel.setBounds(100, 250, 1000, 50);
        bloodLabel.setForeground(Color.WHITE);
        bloodLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // aiub id label
        aiubIdLabel = new JLabel(
                "<html><b>AIUB ID: </b><span color=\"black\" style=\"background:white\">" + r.getAiubId()
                        + "</span></html>");
        aiubIdLabel.setBounds(100, 300, 1000, 50);
        aiubIdLabel.setForeground(Color.WHITE);
        aiubIdLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // email label
        emailLabel = new JLabel("<html><b>E-mail: </b><span color=\"black\" style=\"background:white\">" + r.getEmail()
                + "</span></html>");
        emailLabel.setBounds(100, 350, 1000, 50);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // phone label
        phoneLabel = new JLabel("<html><b>Phone: </b><span color=\"black\" style=\"background:white\">" + r.getContact()
                + "</span></html>");
        phoneLabel.setBounds(100, 400, 1000, 50);
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // total blood request label
        totalRequestLabel = new JLabel(
                "<html><b>Total Bloood Request: </b><span color=\"black\" style=\"background:white\">"
                        + r.getTotalRequest()
                        + "</span></html>");
        totalRequestLabel.setBounds(100, 450, 1200, 50);
        totalRequestLabel.setForeground(Color.WHITE);
        totalRequestLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // total received label
        totalReceivedLabel = new JLabel(
                "<html><b>Received Blood: </b><span color=\"green\" style=\"background:white\">" + r.getTotalReceived()
                        + "</span></html>");
        totalReceivedLabel.setBounds(100, 500, 1000, 50);
        totalReceivedLabel.setForeground(Color.WHITE);
        totalReceivedLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // pending label
        int pending = r.getTotalRequest() - r.getTotalReceived();
        pendingRequest = new JLabel(
                "<html><b>Pending Request: </b><span color=\"red\" style=\"background:white\">" + pending
                        + "</span></html>");
        pendingRequest.setBounds(100, 550, 1000, 50);
        pendingRequest.setForeground(Color.WHITE);
        pendingRequest.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // adding to profile
        frame.add(nameLabel);
        frame.add(userTypeLabel);
        frame.add(bloodLabel);
        frame.add(aiubIdLabel);
        frame.add(emailLabel);
        frame.add(phoneLabel);
        frame.add(totalRequestLabel);
        frame.add(totalReceivedLabel);
        frame.add(pendingRequest);
        frame.add(profileBg);

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbarPanel, BorderLayout.NORTH);

        // scroll pane
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // adding to frame
        frame.setIconImage(favIcon.getImage());
        frame.add(scrollPane);

        // frame
        frame.setSize(1366, 768);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // action listeners

        // dropdown action
        name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isShowDropdown) {
                    hideDropdown();
                } else {
                    showDropdown();
                }
            }
        });

        // go home action
        goHomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                if (u.getIsDonor()) {
                    new DonorDashboard(Donor.login(u.getAiubId(), u.getPassword()));
                } else {
                    new RecipientDashboard(Recipient.login(u.getAiubId(), u.getPassword()));
                }
            }
        });

        // my requests action
        myRequestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MyRequests(Recipient.login(u.getAiubId(), u.getPassword()));
            }
        });

        // my donations action
        myDonationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MyDonations(Donor.login(u.getAiubId(), u.getPassword()));
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

    // show dropwdown
    private void showDropdown() {
        isShowDropdown = true;
        dropdownBox.setVisible(true);
        goHomeButton.setVisible(true);
        donorsListButton.setVisible(true);
        logoutButton.setVisible(true);
        if (u.getIsDonor()) {
            myDonationsButton.setVisible(true);
        } else {
            myRequestsButton.setVisible(true);
        }
    }

    // hide dropdown
    private void hideDropdown() {
        isShowDropdown = false;
        dropdownBox.setVisible(false);
        goHomeButton.setVisible(false);
        donorsListButton.setVisible(false);
        logoutButton.setVisible(false);
        myDonationsButton.setVisible(false);
        myRequestsButton.setVisible(false);
    }
}
