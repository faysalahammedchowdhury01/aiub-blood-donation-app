package client.components;

import client.assets.Color.MyColor;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class DonorsList {
    User u;
    private boolean isShowDropdown;

    JFrame frame;
    private JPanel mainPanel, navbarPanel, donorsPanel, bloodGroupPanel, noDonorPanel;
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
    private JButton logoutButton;

    // donor panel
    private JLabel selectBloodText;
    private JComboBox<String> bloodGroupBox;
    private JLabel noDonorText;

    public DonorsList(User u, String searchingBlood) {
        this.u = u;
        frame = new JFrame(
                (searchingBlood == null ? "" : searchingBlood) + (" Donors List - AIUB BLOOD DONATION CLUB"));

        // favIcon
        try {
            favIcon = new ImageIcon("client/assets/images/logo.png");
            frame.setIconImage(favIcon.getImage());
        } catch (Exception e) {
        }

        // navbar panel
        navbarPanel = new JPanel();
        navbarPanel.setLayout(null);
        navbarPanel.setPreferredSize(new Dimension(1366, 80));
        navbarPanel.setBackground(MyColor.darkRed);

        // aiub and blood logo
        try {
            image = ImageIO.read(new File("client/assets/images/aiub_logo_sm.png"));
            aiubLogo = new JLabel(new ImageIcon(image));
            aiubLogo.setBounds(50, 15, image.getWidth(), image.getHeight());
            navbarPanel.add(aiubLogo);
        } catch (Exception e) {
        }

        try {
            image = ImageIO.read(new File("client/assets/images/logo_sm.png"));
            logo = new JLabel(new ImageIcon(image));
            logo.setBounds(100, 15, image.getWidth(), image.getHeight());
            navbarPanel.add(logo);
        } catch (Exception e) {
        }

        // aiub text
        aiubText = new JLabel("AIUB BLOOD DONATION CLUB");
        aiubText.setBounds(160, 15, 400, 50);
        aiubText.setForeground(MyColor.white);
        aiubText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));

        // name label and dropdown
        icon = new ImageIcon("client/assets/images/dropdown.png");
        name = new JButton("Welcome, " + u.getName().split(" ")[0], icon);
        name.setBounds(1366 - 320, 15, 250, 50);
        name.setForeground(MyColor.white);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // dropdown box
        dropdownBox = new JLabel("");
        dropdownBox.setBounds(1366 - 300, 70, 250, 250);
        dropdownBox.setBackground(MyColor.green);
        dropdownBox.setOpaque(true);
        dropdownBox.setVisible(false);
        isShowDropdown = false;

        // go home button
        goHomeButton = new JButton("Home");
        goHomeButton.setBounds(1366 - 280, 80, 210, 65);
        goHomeButton.setBackground(MyColor.white);
        goHomeButton.setForeground(MyColor.black);
        goHomeButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        goHomeButton.setBorderPainted(false);
        goHomeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        goHomeButton.setVisible(false);

        // my donations button
        myDonationsButton = new JButton("My Donations");
        myDonationsButton.setBounds(1366 - 280, 160, 210, 65);
        myDonationsButton.setBackground(MyColor.white);
        myDonationsButton.setForeground(MyColor.black);
        myDonationsButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        myDonationsButton.setBorderPainted(false);
        myDonationsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myDonationsButton.setVisible(false);

        // my requests button
        myRequestsButton = new JButton("My Requests");
        myRequestsButton.setBounds(1366 - 280, 160, 210, 65);
        myRequestsButton.setBackground(MyColor.white);
        myRequestsButton.setForeground(MyColor.black);
        myRequestsButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        myRequestsButton.setBorderPainted(false);
        myRequestsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        myRequestsButton.setVisible(false);

        // logout button
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1366 - 280, 240, 210, 65);
        logoutButton.setBackground(MyColor.white);
        logoutButton.setForeground(MyColor.black);
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
        frame.add(logoutButton);
        frame.add(dropdownBox);

        // donors panel
        donorsPanel = new JPanel();
        donorsPanel.setLayout(new BoxLayout(donorsPanel, BoxLayout.Y_AXIS));
        donorsPanel.setBackground(MyColor.white);

        // blood group panel
        bloodGroupPanel = new JPanel();
        bloodGroupPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bloodGroupPanel.setPreferredSize(new Dimension(1366, 110));
        donorsPanel.add(bloodGroupPanel);

        // select blood text
        selectBloodText = new JLabel(
                "<html><br><center style=\"margin-left: 65px;\">Select Blood Group:</center><br></html>");
        selectBloodText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        selectBloodText.setForeground(MyColor.black);

        String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        bloodGroupBox = new JComboBox<>(bloodGroups);
        bloodGroupBox.setSelectedItem(searchingBlood);

        bloodGroupPanel.add(selectBloodText);
        bloodGroupPanel.add(bloodGroupBox);

        // add donor
        String selectedBlood = searchingBlood;
        boolean hasDonor = false;
        for (Donor d : User.donors) {
            System.out.println(d);
            System.out.println(d.getStatus());
            System.out.println(selectedBlood == null);
            if (d.getStatus().equals("Available")) {
                SingleDonorGUI singleDonor = new SingleDonorGUI(d, u);
                donorsPanel.add(singleDonor);
                hasDonor = true;
            }
        }

        // no donor panel
        noDonorPanel = new JPanel();
        noDonorPanel.setLayout(null);
        noDonorPanel.setPreferredSize(new Dimension(1366, 110));
        donorsPanel.add(noDonorPanel);

        if (!hasDonor) {
            noDonorText = new JLabel(
                    "Sorry, no " + (searchingBlood == null ? "" : "\"" + searchingBlood + "\"")
                            + " donor is available at this moment. Please try again later.",
                    SwingConstants.CENTER);
            noDonorText.setBounds(0, -140, 1366, 300);
            noDonorText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
            noDonorText.setForeground(MyColor.black);

            noDonorPanel.add(noDonorText);
        }

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbarPanel, BorderLayout.NORTH);
        mainPanel.add(donorsPanel, BorderLayout.CENTER);

        // scroll pane
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setBlockIncrement(200);

        // adding to frame
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

        // search action
        bloodGroupBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bloodGroup = (String) bloodGroupBox.getSelectedItem();
                frame.setVisible(false);
                new DonorsList(u, bloodGroup);
            }
        });
    }

    // show dropwdown
    private void showDropdown() {
        isShowDropdown = true;
        dropdownBox.setVisible(true);
        goHomeButton.setVisible(true);
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
        logoutButton.setVisible(false);
        myDonationsButton.setVisible(false);
        myRequestsButton.setVisible(false);
    }

    // post gui component
    private class SingleDonorGUI extends JPanel {
        private JLabel name;
        private JLabel bloodGroup;
        private JButton viewProfileButton;

        public SingleDonorGUI(Donor d, User u) {
            setLayout(null);

            // name
            name = new JLabel("Name: " + d.getName());
            name.setForeground(MyColor.white);
            name.setFont(new Font("Arial", Font.BOLD, 22));
            name.setBounds(80, 30, 1000, 50);

            // blood group
            bloodGroup = new JLabel("Blood Group: " + d.getBloodGroup());
            bloodGroup.setForeground(MyColor.white);
            bloodGroup.setFont(new Font("Arial", Font.BOLD, 22));
            bloodGroup.setBounds(80, 80, 1000, 50);

            // view profile button
            viewProfileButton = new JButton("View Profile");
            viewProfileButton.setForeground(MyColor.black);
            viewProfileButton.setBackground(MyColor.white);
            viewProfileButton.setFont(new Font("Arial", Font.BOLD, 22));
            viewProfileButton.setBounds(1050, 50, 200, 50);
            viewProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // adding
            add(name);
            add(bloodGroup);
            add(viewProfileButton);

            // panel
            setBackground(MyColor.darkBlue);
            setBorder(BorderFactory.createLineBorder(MyColor.white));
            setPreferredSize(new Dimension(1366, 160));

            // action listeners

            // view peofile action
            viewProfileButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new DonorsProfile(d, u);
                }
            });
        }
    }
}
