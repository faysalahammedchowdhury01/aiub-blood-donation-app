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

    JFrame frame;
    private JPanel mainPanel, navbarPanel, donorsPanel, bloodGroupPanel, noDonorPanel;
    private Sidebar sidebarPanel;
    private JScrollPane scrollPane;
    private ImageIcon favIcon, icon;
    // navbar
    private BufferedImage image;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel aiubText;
    private JButton name;

    // donor
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

        // name label
        icon = new ImageIcon("client/assets/images/right-arrow.png");
        name = new JButton("Welcome, " + u.getName().split(" ")[0], icon);
        name.setBounds(1366 - 320, 15, 250, 50);
        name.setForeground(MyColor.white);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // navbar adding
        navbarPanel.add(aiubLogo);
        navbarPanel.add(logo);
        navbarPanel.add(aiubText);
        navbarPanel.add(name);

        // sidebar panel
        sidebarPanel = new Sidebar(u, frame);
        sidebarPanel.setPreferredSize(new Dimension(250, frame.getHeight()));

        // donors panel
        donorsPanel = new JPanel();
        donorsPanel.setLayout(new BoxLayout(donorsPanel, BoxLayout.Y_AXIS));
        donorsPanel.setBackground(MyColor.white);

        // blood group panel
        bloodGroupPanel = new JPanel();
        bloodGroupPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        bloodGroupPanel.setPreferredSize(new Dimension(1116, 110));
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
        for (Donor d : Donor.getDonors(selectedBlood)) {
            SingleDonorGUI singleDonor = new SingleDonorGUI(d, u);
            donorsPanel.add(singleDonor);
            hasDonor = true;
        }

        // no donor panel
        noDonorPanel = new JPanel();
        noDonorPanel.setLayout(null);
        noDonorPanel.setPreferredSize(new Dimension(1116, 110));
        donorsPanel.add(noDonorPanel);

        if (!hasDonor) {
            noDonorText = new JLabel(
                    "<html><center>Sorry, no " + (searchingBlood == null ? "" : "\"" + searchingBlood + "\"")
                            + " donor is available at this moment.<br>Please try again later.</center></html>",
                    SwingConstants.CENTER);
            noDonorText.setBounds(0, -120, 1116, 300);
            noDonorText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
            noDonorText.setForeground(MyColor.black);

            noDonorPanel.add(noDonorText);
        }

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbarPanel, BorderLayout.NORTH);
        mainPanel.add(donorsPanel, BorderLayout.CENTER);
        mainPanel.add(sidebarPanel, BorderLayout.WEST);

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

        // visit profile action
        name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                if (u.getIsDonor()) {
                    Donor d = Donor.login(u.getAiubId(), u.getPassword());
                    new DonorsProfile(d, u);
                } else {
                    Recipient r = Recipient.login(u.getAiubId(), u.getPassword());
                    new RecipientsProfile(r, u);
                }
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

    // single donor gui component
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
            viewProfileButton.setVerticalAlignment(SwingConstants.CENTER);
            viewProfileButton.setForeground(MyColor.black);
            viewProfileButton.setBackground(MyColor.white);
            viewProfileButton.setFont(new Font("Arial", Font.BOLD, 22));
            viewProfileButton.setBounds(825, 50, 200, 50);
            viewProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // adding
            add(name);
            add(bloodGroup);
            add(viewProfileButton);

            // panel
            setBackground(MyColor.darkBlue);
            setBorder(BorderFactory.createLineBorder(MyColor.white));
            setPreferredSize(new Dimension(1116, 160));

            // action listeners

            // view donors peofile action
            viewProfileButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new DonorsProfile(d, u);
                }
            });
        }
    }
}
