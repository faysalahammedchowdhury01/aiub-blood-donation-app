package client.components;

import client.assets.Color.MyColor;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class EditPost {
    JFrame frame;
    private JPanel mainPanel, navbarPanel, postPanel;
    private JScrollPane scrollPane;
    private ImageIcon favIcon;
    // navbar
    private BufferedImage image;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel aiubText;
    private JButton name;

    public EditPost(Post post, Recipient r) {
        frame = new JFrame("Edit Post - AIUB BLOOD DONATION CLUB");

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
        name = new JButton("Welcome, " + r.getName().split(" ")[0]);
        name.setBounds(1366 - 320, 15, 250, 50);
        name.setForeground(MyColor.white);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // navpanel
        navbarPanel.add(aiubText);
        navbarPanel.add(name);

        // post panel
        postPanel = new JPanel();
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
        postPanel.setBackground(MyColor.white);

        // add posts
        PostGUI singlePost = new PostGUI(post, r);
        postPanel.add(singlePost);

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
        frame.add(scrollPane);

        // frame
        frame.setSize(1366, 768);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // action listeners
    }

    // post gui component
    private class PostGUI extends JPanel {
        private JLabel statusText;
        private JLabel statusNowText;
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
        private JButton saveButton;
        private JButton cancelButton;

        public PostGUI(Post post, Recipient r) {
            setLayout(null);

            // status text
            statusText = new JLabel("Status: ");
            statusText.setBounds(80, 60, 150, 50);
            statusText.setForeground(MyColor.white);
            statusText.setFont(new Font("Arial", Font.BOLD, 30));

            String margin = post.getStatus().equals("open") ? "20px" : "7px";
            statusNowText = new JLabel(
                    "<html><p style=\"margin-left: " + margin + "\">" + post.getStatus().toUpperCase()
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

            // date label and field
            dateLabel = new JLabel("Date: ");
            dateLabel.setBounds(80, 130, 100, 50);
            dateLabel.setForeground(MyColor.white);
            dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            dateField = new JTextField("");
            dateField.setBounds(80, 170, 590, 50);
            dateField.setForeground(MyColor.black);
            dateField.setFont(new Font("Arial", Font.PLAIN, 18));
            dateField.setText(post.getDate());

            // time label and field
            timeLabel = new JLabel("Time: ");
            timeLabel.setBounds(695, 130, 100, 50);
            timeLabel.setForeground(MyColor.white);
            timeLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            timeField = new JTextField("");
            timeField.setBounds(695, 170, 590, 50);
            timeField.setForeground(MyColor.black);
            timeField.setFont(new Font("Arial", Font.PLAIN, 18));
            timeField.setText(post.getTime());

            // location label and field
            locationLabel = new JLabel("Location: ");
            locationLabel.setBounds(80, 220, 100, 50);
            locationLabel.setForeground(MyColor.white);
            locationLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            locationField = new JTextField("");
            locationField.setBounds(80, 260, 590, 50);
            locationField.setForeground(MyColor.black);
            locationField.setFont(new Font("Arial", Font.PLAIN, 18));
            locationField.setText(post.getLocation());

            // time label and field
            bloodGroupLabel = new JLabel("Blood Group: ");
            bloodGroupLabel.setBounds(695, 220, 300, 50);
            bloodGroupLabel.setForeground(MyColor.white);
            bloodGroupLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
            bloodGroupBox = new JComboBox<>(bloodGroups);
            bloodGroupBox.setSelectedItem(post.getRequiredBloodGroup());
            bloodGroupBox.setBounds(695, 260, 590, 50);

            // description label and text area
            descriptionLabel = new JLabel("Description:");
            descriptionLabel.setBounds(80, 310, 300, 50);
            descriptionLabel.setForeground(MyColor.white);
            descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 18));

            descriptionTextArea = new JTextArea("");
            descriptionTextArea.setBounds(80, 350, 1205, 100);
            descriptionTextArea.setForeground(MyColor.black);
            descriptionTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
            descriptionTextArea.setWrapStyleWord(true);
            descriptionTextArea.setLineWrap(true);
            descriptionTextArea.setText(post.getDescription());

            // save button
            saveButton = new JButton("Save");
            saveButton.setBounds(475, 490, 200, 50);
            saveButton.setForeground(MyColor.white);
            saveButton.setBackground(MyColor.green);
            saveButton.setFont(new Font("Arial", Font.BOLD, 18));
            saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // cancel button
            cancelButton = new JButton("Cancel");
            cancelButton.setBounds(700, 490, 200, 50);
            cancelButton.setForeground(MyColor.white);
            cancelButton.setBackground(MyColor.darkRed);
            cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
            cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // adding
            add(statusText);
            add(statusNowText);
            add(dateLabel);
            add(dateField);
            add(timeLabel);
            add(timeField);
            add(locationLabel);
            add(locationField);
            add(bloodGroupLabel);
            add(bloodGroupBox);
            add(descriptionLabel);
            add(descriptionTextArea);
            add(saveButton);
            add(cancelButton);

            // panel
            setBackground(MyColor.darkBlue);
            setBorder(BorderFactory.createLineBorder(MyColor.white));
            setPreferredSize(new Dimension(1366, 610));

            // action listeners

            // save button action
            saveButton.addActionListener(new ActionListener() {
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

                    // go for edit post
                    if (post.editPost(r.getAiubId(), date, time, location, bloodGroup, description)) {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='green'>Your changes have been saved successfully!</font></center></html>",
                                "", JOptionPane.PLAIN_MESSAGE);
                        frame.setVisible(false);
                        new MyRequests(r);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='red'><b>Oops!</b> Sorry, we could not update your post at this time. Please try again later!</font></center></html>",
                                "", JOptionPane.INFORMATION_MESSAGE);
                        frame.setVisible(false);
                        new MyRequests(r);
                    }
                }
            });

            // cancel button action
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                    new MyRequests(r);
                }
            });
        }
    }
}
