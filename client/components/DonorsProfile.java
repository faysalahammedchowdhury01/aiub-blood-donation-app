package client.components;

import client.assets.Color.*;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.table.*;

public class DonorsProfile {
    User u;

    JFrame frame;
    private JPanel mainPanel, navbarPanel, profilePanel;
    private Sidebar sidebarPanel;
    private JScrollPane scrollPane;
    private ImageIcon favIcon, icon;
    // navbar
    private BufferedImage image;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel aiubText;
    private JButton name;

    // profile
    private DefaultTableModel tableModel;
    private JTable table;
    private JLabel tableHeaderLabel;

    public DonorsProfile(Donor d, User u) {
        this.u = u;
        frame = new JFrame("Profile - " + d.getName() + " [" + d.getAiubId() + "]" + " - AIUB BLOOD DONATION CLUB");

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
        navbarPanel.add(aiubText);
        navbarPanel.add(name);

        // sidebar panel
        sidebarPanel = new Sidebar(u, frame);
        sidebarPanel.setPreferredSize(new Dimension(250, frame.getHeight()));

        // post panel
        profilePanel = new JPanel();
        profilePanel.setLayout(null);

        // profile info in table view

        // table header
        boolean isProfileOwner = d.getAiubId().equals(u.getAiubId()) && u.getIsDonor();
        tableHeaderLabel = new JLabel(isProfileOwner ? "Your Details:" : "Details:");
        tableHeaderLabel.setBounds(70, 20, 400, 100);
        tableHeaderLabel.setFont(new Font("Arial", Font.BOLD, 30));
        tableHeaderLabel.setOpaque(true);
        tableHeaderLabel.setForeground(MyColor.black);

        // create data for the table
        Object[][] data = {
                { "  Name", "  " + d.getName() },
                { "  User Type", "  Donor" },
                { "  Blood Group", "  " + d.getBloodGroup() },
                { "  AIUB ID", "  " + d.getAiubId() },
                { "  Status", "  " + d.getStatus() },
                { "  Email", "  " + d.getEmail() },
                { "  Phone", "  " + d.getContact() },
                { "  Last Donate Date", "  " + d.getLastDonateDate() },
                { "  Total Donation", "  " + d.getTotalDonation() },
        };
        String[] columnNames = { "", "" };

        // create a table model with the data
        tableModel = new DefaultTableModel(data, columnNames);

        // create a JTable with the model
        table = new JTable(tableModel);
        table.setBounds(70, 120, 970, 450);
        table.setFont(new Font("Arial", Font.BOLD, 22));
        table.setForeground(MyColor.white);
        table.setBackground(MyColor.darkBlue);
        table.setRowHeight(50);
        table.setEnabled(false);

        // adding
        profilePanel.add(tableHeaderLabel);
        profilePanel.add(table);

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbarPanel, BorderLayout.NORTH);
        mainPanel.add(profilePanel, BorderLayout.CENTER);
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

        // action listener

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
    }
}
