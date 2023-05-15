package client.components;

import client.assets.Color.MyColor;
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
    private JButton viewProfileButton;
    private JButton myRequestsButton;
    private JButton findDonorButton;
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
        System.out.println(r);
        frame = new JFrame("Dashboard - AIUB BLOOD DONATION CLUB");

        // favIcon
        try {
            favIcon = new ImageIcon("client/assets/images/logo.png");
            frame.setIconImage(favIcon.getImage());
        } catch (Exception e) {
        }

        // frame background
        bgColor = new JLabel("");
        bgColor.setOpaque(true);
        bgColor.setBounds(0, 0, 1366, 768);
        bgColor.setBackground(MyColor.white);

        // top nav background
        topNavBg = new JLabel("");
        topNavBg.setOpaque(true);
        topNavBg.setBounds(0, 0, 1366, 80);
        topNavBg.setBackground(MyColor.darkRed);

        // aiub and blood logo
        try {
            image = ImageIO.read(new File("client/assets/images/aiub_logo_sm.png"));
            aiubLogo = new JLabel(new ImageIcon(image));
            aiubLogo.setBounds(50, 15, image.getWidth(), image.getHeight());
            frame.add(aiubLogo);
        } catch (Exception e) {
        }

        try {
            image = ImageIO.read(new File("client/assets/images/logo_sm.png"));
            logo = new JLabel(new ImageIcon(image));
            logo.setBounds(100, 15, image.getWidth(), image.getHeight());
            frame.add(logo);
        } catch (Exception e) {
        }

        // aiub text
        aiubText = new JLabel("AIUB BLOOD DONATION CLUB");
        aiubText.setBounds(160, 15, 400, 50);
        aiubText.setForeground(MyColor.white);
        aiubText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));

        // name label and dropdown
        icon = new ImageIcon("client/assets/images/dropdown.png");
        name = new JButton("Welcome, " + r.getName().split(" ")[0], icon);
        name.setBounds(1366 - 320, 15, 250, 50);
        name.setForeground(MyColor.white);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // dropdown box
        dropdownBox = new JLabel("");
        dropdownBox.setBounds(1366 - 300, 70, 250, 330);
        dropdownBox.setBackground(MyColor.yellow);
        dropdownBox.setOpaque(true);
        dropdownBox.setVisible(false);
        isShowDropdown = false;

        // view profile button
        viewProfileButton = new JButton("View Profile");
        viewProfileButton.setBounds(1366 - 280, 80, 210, 65);
        viewProfileButton.setBackground(MyColor.white);
        viewProfileButton.setForeground(MyColor.black);
        viewProfileButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        viewProfileButton.setBorderPainted(false);
        viewProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewProfileButton.setVisible(false);

        // my requests button
        myRequestsButton = new JButton("My Requests");
        myRequestsButton.setBounds(1366 - 280, 160, 210, 65);
        myRequestsButton.setBackground(MyColor.white);
        myRequestsButton.setForeground(MyColor.black);
        myRequestsButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        myRequestsButton.setBorderPainted(false);
        myRequestsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myRequestsButton.setVisible(false);

        // find donor button
        findDonorButton = new JButton("Find Donor");
        findDonorButton.setBounds(1366 - 280, 240, 210, 65);
        findDonorButton.setBackground(MyColor.white);
        findDonorButton.setForeground(MyColor.black);
        findDonorButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        findDonorButton.setBorderPainted(false);
        findDonorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        findDonorButton.setVisible(false);

        // logout button
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1366 - 280, 320, 210, 65);
        logoutButton.setBackground(MyColor.white);
        logoutButton.setForeground(MyColor.black);
        logoutButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        logoutButton.setBorderPainted(false);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setVisible(false);

        // post bg
        postContainerBg = new JLabel();
        postContainerBg.setBounds(50, 120, 1260, 520);
        postContainerBg.setOpaque(true);
        postContainerBg.setBackground(MyColor.darkBlue);

        // request blood text
        requestBloodText = new JLabel("REQUEST FOR BLOOD");
        requestBloodText.setBounds(80, 150, 500, 50);
        requestBloodText.setForeground(MyColor.white);
        requestBloodText.setFont(new Font("Arial", Font.BOLD, 30));

        // date label and field
        dateLabel = new JLabel("Date: ");
        dateLabel.setBounds(80, 200, 100, 50);
        dateLabel.setForeground(MyColor.white);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        dateField = new JTextField("");
        dateField.setBounds(80, 240, 590, 50);
        dateField.setForeground(MyColor.black);
        dateField.setFont(new Font("Arial", Font.PLAIN, 18));

        // time label and field
        timeLabel = new JLabel("Time: ");
        timeLabel.setBounds(695, 200, 100, 50);
        timeLabel.setForeground(MyColor.white);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        timeField = new JTextField("");
        timeField.setBounds(695, 240, 590, 50);
        timeField.setForeground(MyColor.black);
        timeField.setFont(new Font("Arial", Font.PLAIN, 18));

        // location label and field
        locationLabel = new JLabel("Location: ");
        locationLabel.setBounds(80, 290, 100, 50);
        locationLabel.setForeground(MyColor.white);
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        locationField = new JTextField("");
        locationField.setBounds(80, 330, 590, 50);
        locationField.setForeground(MyColor.black);
        locationField.setFont(new Font("Arial", Font.PLAIN, 18));

        // blood group label and field
        bloodGroupLabel = new JLabel("Blood Group: ");
        bloodGroupLabel.setBounds(695, 290, 300, 50);
        bloodGroupLabel.setForeground(MyColor.white);
        bloodGroupLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        bloodGroupBox = new JComboBox<>(bloodGroups);
        bloodGroupBox.setSelectedIndex(-1);
        bloodGroupBox.setBounds(695, 330, 590, 50);

        // description label and text area
        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(80, 380, 300, 50);
        descriptionLabel.setForeground(MyColor.white);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        descriptionTextArea = new JTextArea("");
        descriptionTextArea.setBounds(80, 420, 1200, 100);
        descriptionTextArea.setForeground(MyColor.black);
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);

        // request blood button
        requestBloodButton = new JButton("Request Blood");
        requestBloodButton.setBounds(580, 550, 200, 50);
        requestBloodButton.setForeground(MyColor.white);
        requestBloodButton.setBackground(MyColor.green);
        requestBloodButton.setFont(new Font("Arial", Font.BOLD, 18));
        requestBloodButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // adding
        frame.add(aiubText);
        frame.add(name);
        frame.add(viewProfileButton);
        frame.add(myRequestsButton);
        frame.add(findDonorButton);
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

        // view profile action
        viewProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RecipientsProfile(r, r);
            }
        });

        // my requests action
        myRequestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new MyRequests(r);
            }
        });

        // find donor action
        findDonorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new DonorsList(r, null);
            }
        });

        // logout action
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });

        // request blood action
        requestBloodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // get data
                String time = timeField.getText().trim();
                String date = dateField.getText().trim();
                String location = locationField.getText().trim();
                String bloodGroup = (String) bloodGroupBox.getSelectedItem();
                String description = descriptionTextArea.getText().trim();

                // validation
                if (time.isEmpty() || date.isEmpty() || location.isEmpty() || bloodGroup == null) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font size='5' color='red'><b>Oops!</b> It seems like some required information is missing. Please fill in all the fields to proceed. Thanks!</font></center></html>",
                            "", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // dont use comma
                if (time.indexOf(',') != -1 || date.indexOf(',') != -1 || location.indexOf(',') != -1
                        || description.indexOf(',') != -1) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font size='5' color='red'>Please avoid using commas in any fields. Thanks!</font></center></html>",
                            "", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // go for create post
                if (r.createPost(time, date, location, bloodGroup, description)) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font size='5' color='green'>Your blood request has been posted! We'll do our best to find a match and notify you as soon as possible. <br> Thank you for your life-saving request and patience! You can see your request status at \"My Requests\".</font></center></html>",
                            "", JOptionPane.PLAIN_MESSAGE);

                    frame.setVisible(false);
                    new MyRequests(r);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font size='5' color='red'><b>Oops!</b> It seems like we had trouble posting your request. Please try again in a few moments. Thank you for your life-saving efforts!</font></center></html>",
                            "", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    // show dropwdown
    private void showDropdown() {
        isShowDropdown = true;
        dropdownBox.setVisible(true);
        viewProfileButton.setVisible(true);
        myRequestsButton.setVisible(true);
        findDonorButton.setVisible(true);
        logoutButton.setVisible(true);
    }

    // hide dropdown
    private void hideDropdown() {
        isShowDropdown = false;
        dropdownBox.setVisible(false);
        viewProfileButton.setVisible(false);
        myRequestsButton.setVisible(false);
        findDonorButton.setVisible(false);
        logoutButton.setVisible(false);
    }
}
