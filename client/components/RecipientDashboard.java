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
    JFrame frame;
    private JPanel mainPanel, navbarPanel, postPanel;
    private Sidebar sidebarPanel;
    private JScrollPane scrollPane;
    private ImageIcon favIcon, icon;
    // navbar
    private BufferedImage image;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel aiubText;
    private JButton name;
    // post
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
        frame = new JFrame("Dashboard - AIUB BLOOD DONATION CLUB");

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
        name = new JButton("Welcome, " + r.getName().split(" ")[0], icon);
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
        sidebarPanel = new Sidebar(r, frame);
        sidebarPanel.setPreferredSize(new Dimension(250, frame.getHeight()));

        // post panel
        postPanel = new JPanel();
        postPanel.setLayout(null);
        postPanel.setBackground(MyColor.darkBlue);

        // request blood text
        requestBloodText = new JLabel("REQUEST FOR BLOOD");
        requestBloodText.setBounds(80, 50, 500, 50);
        requestBloodText.setForeground(MyColor.white);
        requestBloodText.setFont(new Font("Arial", Font.BOLD, 40));

        // date label and field
        dateLabel = new JLabel("Date: ");
        dateLabel.setBounds(80, 150, 100, 50);
        dateLabel.setForeground(MyColor.white);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        dateField = new JTextField("");
        dateField.setBounds(80, 190, 450, 50);
        dateField.setForeground(MyColor.black);
        dateField.setFont(new Font("Arial", Font.PLAIN, 18));

        // time label and field
        timeLabel = new JLabel("Time: ");
        timeLabel.setBounds(555, 150, 100, 50);
        timeLabel.setForeground(MyColor.white);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        timeField = new JTextField("");
        timeField.setBounds(555, 190, 450, 50);
        timeField.setForeground(MyColor.black);
        timeField.setFont(new Font("Arial", Font.PLAIN, 18));

        // location label and field
        locationLabel = new JLabel("Location: ");
        locationLabel.setBounds(80, 240, 100, 50);
        locationLabel.setForeground(MyColor.white);
        locationLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        locationField = new JTextField("");
        locationField.setBounds(80, 280, 450, 50);
        locationField.setForeground(MyColor.black);
        locationField.setFont(new Font("Arial", Font.PLAIN, 18));

        // blood group label and field
        bloodGroupLabel = new JLabel("Blood Group: ");
        bloodGroupLabel.setBounds(555, 240, 300, 50);
        bloodGroupLabel.setForeground(MyColor.white);
        bloodGroupLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        bloodGroupBox = new JComboBox<>(bloodGroups);
        bloodGroupBox.setSelectedIndex(-1);
        bloodGroupBox.setBounds(555, 280, 450, 50);

        // description label and text area
        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(80, 330, 300, 50);
        descriptionLabel.setForeground(MyColor.white);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        descriptionTextArea = new JTextArea("");
        descriptionTextArea.setBounds(80, 370, 925, 100);
        descriptionTextArea.setForeground(MyColor.black);
        descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);

        // request blood button
        requestBloodButton = new JButton("Request Blood");
        requestBloodButton.setBounds(440, 500, 200, 50);
        requestBloodButton.setForeground(MyColor.white);
        requestBloodButton.setBackground(MyColor.green);
        requestBloodButton.setFont(new Font("Arial", Font.BOLD, 18));
        requestBloodButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // add to post panel
        postPanel.add(requestBloodText);
        postPanel.add(dateLabel);
        postPanel.add(dateField);
        postPanel.add(timeLabel);
        postPanel.add(timeField);
        postPanel.add(locationLabel);
        postPanel.add(locationField);
        postPanel.add(bloodGroupLabel);
        postPanel.add(bloodGroupBox);
        postPanel.add(descriptionLabel);
        postPanel.add(descriptionTextArea);
        postPanel.add(requestBloodButton);

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbarPanel, BorderLayout.NORTH);
        mainPanel.add(postPanel, BorderLayout.CENTER);
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
                new RecipientsProfile(r, r);
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
}
