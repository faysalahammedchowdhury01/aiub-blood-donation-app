package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class RecipientDashboard {
    private boolean isShowDropdown;

    JFrame frame;
    private ImageIcon favIcon, icon;
    private JLabel bgColor;
    private JLabel topNavBg;
    private BufferedImage image;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel aiubText;
    private JButton name;
    private JLabel dropdownBox;
    private JButton seeProfile;
    private JButton logoutButton;
    private JLabel postContainerBg;
    private JLabel requestBloodText;
    private JLabel dateLabel;
    private JTextField dateField;
    private JLabel timeLabel;
    private JTextField timeField;
    private JLabel locationLabel;
    private JTextField locationField;
    private JLabel bloodGroupLabel;
    private JComboBox<String> bloodGroupBox;
    private JLabel descriptionLabel;
    private JTextArea descriptionTextArea;
    private JButton requestBloodButton;

    public RecipientDashboard(Recipient r) {
        frame = new JFrame("Dashboard - AIUB Blood Donation Club");

        // favIcon
        favIcon = new ImageIcon("images/logo.png");
        frame.setIconImage(favIcon.getImage());

        // frame background
        bgColor = new JLabel("");
        bgColor.setOpaque(true);
        bgColor.setBounds(0, 0, 1366, 768);
        bgColor.setBackground(Color.WHITE);

        // top nav background
        topNavBg = new JLabel("");
        topNavBg.setOpaque(true);
        topNavBg.setBounds(0, 0, 1366, 80);
        topNavBg.setBackground(new Color(169, 29, 20));

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
        name = new JButton("Welcome, " + r.getName().split(" ")[0], icon);
        name.setBounds(1366 - 320, 15, 250, 50);
        name.setForeground(Color.WHITE);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // dropdown box
        dropdownBox = new JLabel("");
        dropdownBox.setBounds(1366 - 300, 70, 250, 170);
        dropdownBox.setBackground(Color.GRAY);
        dropdownBox.setOpaque(true);
        dropdownBox.setVisible(false);
        isShowDropdown = false;

        // see profile
        seeProfile = new JButton("See Profile");
        seeProfile.setBounds(1366 - 280, 80, 210, 65);
        seeProfile.setBackground(Color.WHITE);
        seeProfile.setForeground(Color.BLACK);
        seeProfile.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        seeProfile.setBorderPainted(false);
        seeProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seeProfile.setVisible(false);

        // see profile
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1366 - 280, 160, 210, 65);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        logoutButton.setBorderPainted(false);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setVisible(false);

        // post bg
        postContainerBg = new JLabel();
        postContainerBg.setBounds(50, 120, 1260, 520);
        postContainerBg.setOpaque(true);
        postContainerBg.setBackground(new Color(26, 127, 100));

        // request blood text
        requestBloodText = new JLabel("REQUEST FOR BLOOD");
        requestBloodText.setBounds(80, 150, 500, 50);
        requestBloodText.setForeground(Color.WHITE);
        requestBloodText.setFont(new Font("Arial", Font.BOLD, 30));

        // date label and field
        dateLabel = new JLabel("Date: ");
        dateLabel.setBounds(80, 200, 100, 50);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        dateField = new JTextField("");
        dateField.setBounds(80, 240, 590, 50);
        dateField.setForeground(Color.BLACK);
        dateField.setFont(new Font("Arial", Font.PLAIN, 18));

        // time label and field
        timeLabel = new JLabel("Time: ");
        timeLabel.setBounds(695, 200, 100, 50);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        timeField = new JTextField("");
        timeField.setBounds(695, 240, 590, 50);
        timeField.setForeground(Color.BLACK);
        timeField.setFont(new Font("Arial", Font.PLAIN, 18));

        // location label and field
        locationLabel = new JLabel("Location: ");
        locationLabel.setBounds(80, 290, 100, 50);
        locationLabel.setForeground(Color.WHITE);
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        locationField = new JTextField("");
        locationField.setBounds(80, 330, 590, 50);
        locationField.setForeground(Color.BLACK);
        locationField.setFont(new Font("Arial", Font.PLAIN, 18));

        // time label and field
        bloodGroupLabel = new JLabel("Blood Group: ");
        bloodGroupLabel.setBounds(695, 290, 300, 50);
        bloodGroupLabel.setForeground(Color.WHITE);
        bloodGroupLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        bloodGroupBox = new JComboBox<>(bloodGroups);
        bloodGroupBox.setSelectedIndex(-1);
        bloodGroupBox.setBounds(695, 330, 590, 50);

        // description label and text area
        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(80, 380, 300, 50);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        descriptionTextArea = new JTextArea("");
        descriptionTextArea.setBounds(80, 420, 1200, 100);
        descriptionTextArea.setForeground(Color.BLACK);
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 18));

        // request blood button
        requestBloodButton = new JButton("Request Blood");
        requestBloodButton.setBounds(580, 550, 200, 50);
        requestBloodButton.setForeground(Color.WHITE);
        requestBloodButton.setBackground(new Color(248, 100, 100));
        requestBloodButton.setFont(new Font("Arial", Font.BOLD, 18));
        requestBloodButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // adding
        frame.add(aiubLogo);
        frame.add(logo);
        frame.add(aiubText);
        frame.add(name);
        frame.add(seeProfile);
        frame.add(logoutButton);
        frame.add(dropdownBox);
        frame.add(requestBloodText);
        frame.add(dateLabel);
        frame.add(dateField);
        frame.add(timeLabel);
        frame.add(timeField);
        frame.add(locationLabel);
        frame.add(locationField);
        frame.add(bloodGroupLabel);
        frame.add(bloodGroupBox);
        frame.add(descriptionLabel);
        frame.add(descriptionTextArea);
        frame.add(requestBloodButton);
        frame.add(postContainerBg);
        frame.add(topNavBg);
        frame.add(bgColor);

        // frame
        frame.setIconImage(favIcon.getImage());
        frame.setSize(1366, 768);
        frame.setLayout(null);
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
        seeProfile.setVisible(true);
        logoutButton.setVisible(true);
    }

    // hide dropdown
    private void hideDropdown() {
        isShowDropdown = false;
        dropdownBox.setVisible(false);
        seeProfile.setVisible(false);
        logoutButton.setVisible(false);
    }
}
