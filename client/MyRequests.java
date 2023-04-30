package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class MyRequests {
    private boolean isShowDropdown;

    JFrame frame;
    private JPanel mainPanel, navbarPanel, postPanel;
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
    private JButton viewProfileButton;
    private JButton donorsListButton;
    private JButton logoutButton;

    private JLabel availablePostText;
    private JLabel noRequestText;
    private JButton requestBloodButton;

    public MyRequests(Recipient r) {
        frame = new JFrame("My Requests - AIUB BLOOD DONATION CLUB");

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

        // view profile button
        viewProfileButton = new JButton("View Profile");
        viewProfileButton.setBounds(1366 - 280, 160, 210, 65);
        viewProfileButton.setBackground(Color.WHITE);
        viewProfileButton.setForeground(Color.BLACK);
        viewProfileButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        viewProfileButton.setBorderPainted(false);
        viewProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewProfileButton.setVisible(false);

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
        frame.add(viewProfileButton);
        frame.add(donorsListButton);
        frame.add(logoutButton);
        frame.add(dropdownBox);

        // post panel
        postPanel = new JPanel();
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
        postPanel.setBackground(Color.WHITE);

        // available post text
        availablePostText = new JLabel(
                "<html><br><p style=\"margin-left: 65px;\">Your Life-Saving Requests:</p><br></html>");
        availablePostText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        availablePostText.setForeground(new Color(45, 39, 39));

        postPanel.add(availablePostText);

        // add posts
        boolean hasPost = false;
        for (Post post : Post.posts) {
            if (post.getAuthor().getAiubId().equals(r.getAiubId())) {
                PostGUI singlePost = new PostGUI(post, r);
                postPanel.add(singlePost);
                hasPost = true;
            }
        }

        // request blood button here to handle exception
        requestBloodButton = new JButton("Request Blood");

        if (!hasPost) {
            postPanel.setLayout(null);

            noRequestText = new JLabel(
                    "<html><center>Looks like you haven't made any blood requests yet.<br/> Don't worry, you can make a request anytime on our website and help save lives. Thank you for your support!</center></html>");
            noRequestText.setBounds(0, -20, 1366, 200);
            noRequestText.setForeground(Color.RED);
            noRequestText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));

            // request blood button
            requestBloodButton = new JButton("Request Blood");
            requestBloodButton.setBounds(580, 150, 200, 50);
            requestBloodButton.setForeground(Color.WHITE);
            requestBloodButton.setBackground(new Color(169, 29, 20));
            requestBloodButton.setFont(new Font("Arial", Font.BOLD, 18));
            requestBloodButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            postPanel.add(noRequestText);
            postPanel.add(requestBloodButton);
        }

        // main panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbarPanel, BorderLayout.NORTH);
        mainPanel.add(postPanel, BorderLayout.CENTER);

        // scroll pane
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.getVerticalScrollBar().setBlockIncrement(200);

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
                new RecipientDashboard(r);
            }
        });

        // view profile action
        viewProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RecipientsProfile(r, r);
            }
        });

        // donors list action
        donorsListButton.addActionListener(new ActionListener() {
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

        // request blood button action
        requestBloodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RecipientDashboard(r);
            }
        });
    }

    // show dropwdown
    private void showDropdown() {
        isShowDropdown = true;
        dropdownBox.setVisible(true);
        goHomeButton.setVisible(true);
        viewProfileButton.setVisible(true);
        donorsListButton.setVisible(true);
        logoutButton.setVisible(true);
    }

    // hide dropdown
    private void hideDropdown() {
        isShowDropdown = false;
        dropdownBox.setVisible(false);
        goHomeButton.setVisible(false);
        viewProfileButton.setVisible(false);
        donorsListButton.setVisible(false);
        logoutButton.setVisible(false);
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
            statusText.setForeground(Color.WHITE);
            statusText.setFont(new Font("Arial", Font.BOLD, 30));

            String margin = post.getStatus().equals("open") ? "20px" : "7px";
            statusNowText = new JLabel(
                    "<html><p style=\"margin-left: " + margin + "\">" + post.getStatus().toUpperCase()
                            + "</center></html>");
            statusNowText.setBounds(230, 60, 150, 50);
            statusNowText.setOpaque(true);
            statusNowText.setBackground(Color.WHITE);
            statusNowText.setFont(new Font("Arial", Font.BOLD, 30));
            if (post.getStatus().equals("open")) {
                statusNowText.setForeground(Color.RED);
            } else {
                statusNowText.setForeground(new Color(55, 146, 55));
            }

            // edit button for "open" post
            editButton = new JButton("Edit");
            editButton.setBounds(1050, 70, 80, 40);
            editButton.setBackground(Color.YELLOW);
            editButton.setFont(new Font("Arial", Font.BOLD, 18));
            editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            if (post.getStatus().equals("closed")) {
                editButton.setVisible(false);
            }

            // delete button for "open" post
            deleteButton = new JButton("Delete");
            deleteButton.setBounds(1150, 70, 130, 40);
            deleteButton.setBackground(Color.RED);
            deleteButton.setFont(new Font("Arial", Font.BOLD, 18));
            deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            if (post.getStatus().equals("closed")) {
                deleteButton.setVisible(false);
            }

            // date label and field
            dateLabel = new JLabel("Date: ");
            dateLabel.setBounds(80, 130, 100, 50);
            dateLabel.setForeground(Color.WHITE);
            dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            dateField = new JTextField("");
            dateField.setBounds(80, 170, 590, 50);
            dateField.setForeground(Color.BLACK);
            dateField.setFont(new Font("Arial", Font.PLAIN, 18));
            dateField.setText(post.getDate());
            dateField.setEditable(false);

            // time label and field
            timeLabel = new JLabel("Time: ");
            timeLabel.setBounds(695, 130, 100, 50);
            timeLabel.setForeground(Color.WHITE);
            timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            timeField = new JTextField("");
            timeField.setBounds(695, 170, 590, 50);
            timeField.setForeground(Color.BLACK);
            timeField.setFont(new Font("Arial", Font.PLAIN, 18));
            timeField.setText(post.getTime());
            timeField.setEditable(false);

            // location label and field
            locationLabel = new JLabel("Location: ");
            locationLabel.setBounds(80, 220, 100, 50);
            locationLabel.setForeground(Color.WHITE);
            locationLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            locationField = new JTextField("");
            locationField.setBounds(80, 260, 590, 50);
            locationField.setForeground(Color.BLACK);
            locationField.setFont(new Font("Arial", Font.PLAIN, 18));
            locationField.setText(post.getLocation());
            locationField.setEditable(false);

            // time label and field
            bloodGroupLabel = new JLabel("Blood Group: ");
            bloodGroupLabel.setBounds(695, 220, 300, 50);
            bloodGroupLabel.setForeground(Color.WHITE);
            bloodGroupLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            bloodGroupField = new JTextField("");
            bloodGroupField.setBounds(695, 260, 590, 50);
            bloodGroupField.setForeground(Color.BLACK);
            bloodGroupField.setFont(new Font("Arial", Font.PLAIN, 18));
            bloodGroupField.setText(post.getRequiredBloodGroup());
            bloodGroupField.setEditable(false);

            // description label and text area
            descriptionLabel = new JLabel("Description:");
            descriptionLabel.setBounds(80, 310, 300, 50);
            descriptionLabel.setForeground(Color.WHITE);
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            descriptionTextArea = new JTextArea("");
            descriptionTextArea.setBounds(80, 350, 1200, 100);
            descriptionTextArea.setForeground(Color.BLACK);
            descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
            descriptionTextArea.setWrapStyleWord(true);
            descriptionTextArea.setLineWrap(true);
            descriptionTextArea.setText(post.getDescription());
            descriptionTextArea.setEditable(false);

            // contact donor button
            contactDonorButton = new JButton("Contact Donor");
            contactDonorButton.setBounds(570, 490, 200, 50);
            contactDonorButton.setForeground(Color.WHITE);
            contactDonorButton.setBackground(new Color(169, 29, 20));
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
            setBackground(new Color(4, 78, 161));
            setBorder(BorderFactory.createLineBorder(Color.WHITE));
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
                    int flag = 0;
                    int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this post?",
                            "Delete",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        // selected
                        int idx = -1;
                        for (int i = 0; i < Post.posts.size(); i++) {
                            if (Post.posts.get(i).getPostId().equals(post.getPostId())) {
                                idx = i;
                                break;
                            }
                        }

                        if (idx != -1) {
                            Post.posts.remove(idx);
                            flag = 1;
                        }
                    }

                    // post state
                    if (flag == 1) {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font color='green'>The post has been successfully deleted.</font></center></html>",
                                "", JOptionPane.INFORMATION_MESSAGE);
                        frame.setVisible(false);
                        new MyRequests(r);
                    } else if (result != JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font color='red'><b>Oops!</b> The post was not deleted.</font></center></html>",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // contact donor action
            contactDonorButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new DonorsProfile(post.getDonor(), r);
                }
            });
        }
    }
}
