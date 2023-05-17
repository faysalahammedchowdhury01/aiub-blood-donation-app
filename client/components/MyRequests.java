package client.components;

import client.assets.Color.MyColor;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class MyRequests {
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

    private JLabel availablePostText;
    private JLabel noRequestText;
    private JButton requestBloodButton;

    public MyRequests(Recipient r) {
        frame = new JFrame("My Requests - AIUB BLOOD DONATION CLUB");

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
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
        postPanel.setBackground(MyColor.white);

        // available post text
        availablePostText = new JLabel(
                "<html><br><p style=\"margin-left: 65px;\">Your Life-Saving Requests:</p><br></html>");
        availablePostText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        availablePostText.setForeground(MyColor.black);

        postPanel.add(availablePostText);

        // add posts
        boolean hasPost = false;
        for (Post post : r.getMyRequests()) {
            PostGUI singlePost = new PostGUI(post, r);
            postPanel.add(singlePost);
            hasPost = true;
        }

        // request blood button here to handle exception
        requestBloodButton = new JButton("Request Blood");

        if (!hasPost) {
            postPanel.setLayout(null);

            noRequestText = new JLabel(
                    "<html><center>Looks like you haven't made any blood requests yet.<br/> Don't worry, you can make a request anytime on our application and help save lives. <br>Thank you for your support!</center></html>",
                    SwingConstants.CENTER);
            noRequestText.setBounds(0, -20, 1116, 200);
            noRequestText.setOpaque(true);
            noRequestText.setForeground(MyColor.black);
            noRequestText.setBackground(MyColor.white);
            noRequestText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));

            // request blood button
            requestBloodButton = new JButton("Request Blood");
            requestBloodButton.setBounds(450, 200, 200, 50);
            requestBloodButton.setForeground(MyColor.white);
            requestBloodButton.setBackground(MyColor.green);
            requestBloodButton.setFont(new Font("Arial", Font.BOLD, 18));
            requestBloodButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            postPanel.add(noRequestText);
            postPanel.add(requestBloodButton);
        }

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

        // request blood button action
        requestBloodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RecipientDashboard(r);
            }
        });
    }

    // post gui component
    private class PostGUI extends JPanel {
        private JLabel statusText;
        private JLabel statusNowText;
        private JButton editButton;
        private JButton deleteButton;
        private JLabel dateLabel;
        private JTextField dateField;
        private JLabel timeLabel;
        private JTextField timeField;
        private JLabel locationLabel;
        private JTextField locationField;
        private JLabel bloodGroupLabel;
        private JTextField bloodGroupField;
        private JLabel descriptionLabel;
        private JTextArea descriptionTextArea;
        private JButton contactDonorButton;

        public PostGUI(Post post, Recipient r) {
            setLayout(null);

            // status text
            statusText = new JLabel("Status: ");
            statusText.setBounds(80, 60, 150, 50);
            statusText.setForeground(MyColor.white);
            statusText.setFont(new Font("Arial", Font.BOLD, 30));

            String margin = post.getStatus().equals("open") ? "20px" : "7px";
            statusNowText = new JLabel(
                    "<html><p style='margin-left: " + margin + "'>" + post.getStatus().toUpperCase()
                            + "</center></html>");
            statusNowText.setBounds(230, 60, 150, 50);
            statusNowText.setOpaque(true);
            statusNowText.setBackground(MyColor.white);
            statusNowText.setFont(new Font("Arial", Font.BOLD, 30));
            if (post.getStatus().equals("open")) {
                statusNowText.setForeground(MyColor.red);
            } else {
                statusNowText.setForeground(MyColor.green);
            }

            // edit button for "open" post
            editButton = new JButton("Edit");
            editButton.setBounds(775, 70, 80, 40);
            editButton.setForeground(MyColor.black);
            editButton.setBackground(MyColor.yellow);
            editButton.setFont(new Font("Arial", Font.BOLD, 18));
            editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            if (post.getStatus().equals("closed")) {
                editButton.setVisible(false);
            }

            // delete button for "open" post
            deleteButton = new JButton("Delete");
            deleteButton.setBounds(875, 70, 130, 40);
            deleteButton.setForeground(MyColor.white);
            deleteButton.setBackground(MyColor.darkRed);
            deleteButton.setFont(new Font("Arial", Font.BOLD, 18));
            deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            if (post.getStatus().equals("closed")) {
                deleteButton.setVisible(false);
            }

            // date label and field
            dateLabel = new JLabel("Date: ");
            dateLabel.setBounds(80, 130, 100, 50);
            dateLabel.setForeground(MyColor.white);
            dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            dateField = new JTextField("");
            dateField.setBounds(80, 170, 450, 50);
            dateField.setForeground(MyColor.black);
            dateField.setFont(new Font("Arial", Font.PLAIN, 18));
            dateField.setText(post.getDate());
            dateField.setEditable(false);

            // time label and field
            timeLabel = new JLabel("Time: ");
            timeLabel.setBounds(555, 130, 100, 50);
            timeLabel.setForeground(MyColor.white);
            timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            timeField = new JTextField("");
            timeField.setBounds(555, 170, 450, 50);
            timeField.setForeground(MyColor.black);
            timeField.setFont(new Font("Arial", Font.PLAIN, 18));
            timeField.setText(post.getTime());
            timeField.setEditable(false);

            // location label and field
            locationLabel = new JLabel("Location: ");
            locationLabel.setBounds(80, 220, 100, 50);
            locationLabel.setForeground(MyColor.white);
            locationLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            locationField = new JTextField("");
            locationField.setBounds(80, 260, 450, 50);
            locationField.setForeground(MyColor.black);
            locationField.setFont(new Font("Arial", Font.PLAIN, 18));
            locationField.setText(post.getLocation());
            locationField.setEditable(false);

            // time label and field
            bloodGroupLabel = new JLabel("Blood Group: ");
            bloodGroupLabel.setBounds(555, 220, 300, 50);
            bloodGroupLabel.setForeground(MyColor.white);
            bloodGroupLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            bloodGroupField = new JTextField("");
            bloodGroupField.setBounds(555, 260, 450, 50);
            bloodGroupField.setForeground(MyColor.black);
            bloodGroupField.setFont(new Font("Arial", Font.PLAIN, 18));
            bloodGroupField.setText(post.getRequiredBloodGroup());
            bloodGroupField.setEditable(false);

            // description label and text area
            descriptionLabel = new JLabel("Description:");
            descriptionLabel.setBounds(80, 310, 300, 50);
            descriptionLabel.setForeground(MyColor.white);
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            descriptionTextArea = new JTextArea("");
            descriptionTextArea.setBounds(80, 350, 925, 100);
            descriptionTextArea.setForeground(MyColor.black);
            descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
            descriptionTextArea.setWrapStyleWord(true);
            descriptionTextArea.setLineWrap(true);
            descriptionTextArea.setText(post.getDescription());
            descriptionTextArea.setEditable(false);

            // contact donor button
            contactDonorButton = new JButton("Contact Donor");
            contactDonorButton.setBounds(440, 490, 200, 50);
            contactDonorButton.setForeground(MyColor.white);
            contactDonorButton.setBackground(MyColor.green);
            contactDonorButton.setFont(new Font("Arial", Font.BOLD, 18));
            contactDonorButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            if (post.getStatus().equals("open")) {
                contactDonorButton.setVisible(false);
            }

            // adding
            add(statusText);
            add(statusNowText);
            add(editButton);
            add(deleteButton);
            add(dateLabel);
            add(dateField);
            add(timeLabel);
            add(timeField);
            add(locationLabel);
            add(locationField);
            add(bloodGroupLabel);
            add(bloodGroupField);
            add(descriptionLabel);
            add(descriptionTextArea);
            add(contactDonorButton);

            // panel
            setBackground(MyColor.darkBlue);
            setBorder(BorderFactory.createLineBorder(MyColor.white));
            setPreferredSize(new Dimension(1366, 610));

            // action listeners

            // edit post action
            editButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new EditPost(post, r);
                }
            });

            // delete post action
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this post?",
                            "Delete",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        // selected
                        if (r.deletePost(post.getPostId())) {
                            JOptionPane.showMessageDialog(null,
                                    "<html><center><font size='5' color='green'>The post has been successfully deleted.</font></center></html>",
                                    "", JOptionPane.PLAIN_MESSAGE);
                            frame.setVisible(false);
                            new MyRequests(r);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "<html><center><font size='5' color='red'><b>Oops!</b> The post was not deleted.</font></center></html>",
                                    "", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });

            // contact donor action
            contactDonorButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new DonorsProfile(Post.getDonor(post.getDonorId()), r);
                }
            });
        }
    }
}
