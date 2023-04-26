package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Signup {
    JFrame frame;
    private BufferedImage image;
    private ImageIcon favIcon;
    private JLabel bgColor;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel taglineText;
    private JLabel aiubText;
    private JLabel signupText;
    private JLabel signupContainerBg;
    private JLabel aiubIdLabel;
    private JTextField aiubIdField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordField;
    private JLabel bloodGroupLabel;
    private JComboBox<String> bloodGroupBox;
    private JCheckBox isDonorLogin;
    private JButton signupButton;
    private JLabel loginText;
    private JButton loginButton;

    public Signup() {
        frame = new JFrame("Sign Up - AIUB BLOOD DONATION CLUB");

        // favIcon
        favIcon = new ImageIcon("images/logo.png");
        frame.setIconImage(favIcon.getImage());

        // frame background
        bgColor = new JLabel("");
        bgColor.setOpaque(true);
        bgColor.setBounds(0, 0, 1366, 768);
        bgColor.setBackground(Color.WHITE);

        // aiub and blood logo
        try {
            image = ImageIO.read(new File("images/aiub_logo.png"));
            aiubLogo = new JLabel(new ImageIcon(image));
            aiubLogo.setBounds(130, 200, image.getWidth(), image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            image = ImageIO.read(new File("images/logo.png"));
            logo = new JLabel(new ImageIcon(image));
            logo.setBounds(310, 190, image.getWidth(), image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // aiub text
        aiubText = new JLabel("AIUB BLOOD DONATION CLUB");
        aiubText.setBounds(90, 320, 500, 300);
        aiubText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        aiubText.setForeground(new Color(45, 39, 39));

        // tagline text
        taglineText = new JLabel("Donate Blood, Save Life.");
        taglineText.setBounds(130, 370, 500, 300);
        taglineText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        taglineText.setForeground(new Color(210, 39, 25));

        // signup container bg
        signupContainerBg = new JLabel("");
        signupContainerBg.setOpaque(true);
        signupContainerBg.setBounds(680, 0, 770, 768);
        signupContainerBg.setBackground(new Color(169, 29, 20));

        // signup text
        signupText = new JLabel("Registration");
        signupText.setBounds(770, 80, 500, 50);
        signupText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        signupText.setForeground(Color.WHITE);

        // AIUB ID field and label
        aiubIdLabel = new JLabel("AIUB ID: ");
        aiubIdLabel.setBounds(770, 170, 100, 30);
        aiubIdLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        aiubIdLabel.setForeground(Color.WHITE);

        aiubIdField = new JTextField("");
        aiubIdField.setBounds(930, 165, 340, 40);
        aiubIdField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // name label and field
        nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(770, 220, 100, 30);
        nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        nameLabel.setForeground(Color.WHITE);

        nameField = new JTextField("");
        nameField.setBounds(930, 215, 340, 40);
        nameField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // email label and field
        emailLabel = new JLabel("E-mail: ");
        emailLabel.setBounds(770, 270, 100, 30);
        emailLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        emailLabel.setForeground(Color.WHITE);

        emailField = new JTextField("");
        emailField.setBounds(930, 265, 340, 40);
        emailField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // phone label and field
        phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(770, 320, 100, 30);
        phoneLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        phoneLabel.setForeground(Color.WHITE);

        phoneField = new JTextField("");
        phoneField.setBounds(930, 315, 340, 40);
        phoneField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // password label and filed
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(770, 370, 200, 30);
        passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        passwordLabel.setForeground(Color.WHITE);

        passwordField = new JPasswordField("");
        passwordField.setBounds(930, 365, 340, 40);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // confirm password label and filed
        confirmPasswordLabel = new JLabel("Re-Password: ");
        confirmPasswordLabel.setBounds(770, 420, 200, 30);
        confirmPasswordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        confirmPasswordLabel.setForeground(Color.WHITE);

        confirmPasswordField = new JPasswordField("");
        confirmPasswordField.setBounds(930, 415, 340, 40);
        confirmPasswordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // blood group label and combo box
        bloodGroupLabel = new JLabel("Blood Group: ");
        bloodGroupLabel.setBounds(770, 470, 200, 30);
        bloodGroupLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        bloodGroupLabel.setForeground(Color.WHITE);

        String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        bloodGroupBox = new JComboBox<>(bloodGroups);
        bloodGroupBox.setSelectedIndex(-1);
        bloodGroupBox.setBounds(930, 465, 340, 40);

        // is donor login
        isDonorLogin = new JCheckBox("Would you like to be a Donor?");
        isDonorLogin.setBounds(770, 520, 500, 30);
        isDonorLogin.setBackground(new Color(255, 109, 96));
        isDonorLogin.setForeground(Color.WHITE);
        isDonorLogin.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        isDonorLogin.setOpaque(false);
        isDonorLogin.setContentAreaFilled(false);
        isDonorLogin.setBorderPainted(false);
        isDonorLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // signup button
        signupButton = new JButton("Sign Up");
        signupButton.setBounds(770, 580, 500, 50);
        signupButton.setBackground(new Color(24, 165, 88));
        signupButton.setForeground(Color.WHITE);
        signupButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // login text and button
        loginText = new JLabel("Already have an account?");
        loginText.setBounds(910, 640, 200, 30);
        loginText.setForeground(Color.WHITE);

        loginButton = new JButton("Login");
        loginButton.setBounds(1065, 640, 100, 30);
        loginButton.setForeground(new Color(247, 208, 96));
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // adding
        frame.add(aiubLogo);
        frame.add(logo);
        frame.add(aiubText);
        frame.add(taglineText);
        frame.add(signupText);
        frame.add(aiubIdLabel);
        frame.add(aiubIdField);
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(bloodGroupLabel);
        frame.add(bloodGroupBox);
        frame.add(isDonorLogin);
        frame.add(signupButton);
        frame.add(loginText);
        frame.add(loginButton);
        frame.add(signupContainerBg);
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

        // login action
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // take data
                String aiubId = aiubIdField.getText().trim();
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();
                char[] password = passwordField.getPassword();
                String passwordString = new String(password);
                password = confirmPasswordField.getPassword();
                String confirmPasswordString = new String(password);
                String bloodGroup = (String) bloodGroupBox.getSelectedItem();
                boolean isDonor = isDonorLogin.isSelected();

                // validation
                if (aiubId.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty() || passwordString.isEmpty()
                        || confirmPasswordString.isEmpty() || bloodGroup.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font color='red'><b>Oops!</b> It seems like some required information is missing. Please fill in all the fields to proceed. Thanks!</font></center></html>",
                            "", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // password and confirm password matching
                if (!passwordString.equals(confirmPasswordString)) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font color='red'><b>Oops!</b> Password and confirm password don't match. Please try again.</font></center></html>",
                            "", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // go for sign up process
                if (isDonor) {
                    Donor d = Donor.signup(aiubId, name, email, passwordString, confirmPasswordString, bloodGroup);
                    if (d != null) {
                        frame.setVisible(false);
                        new DonorDashboard(d);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font color='red'><b>Oops!</b> User already exist but Try again with correct password. Thanks!</font></center></html>",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    Recipient r = Recipient.signup(aiubId, name, email, passwordString, confirmPasswordString,
                            bloodGroup);
                    if (r != null) {
                        frame.setVisible(false);
                        new RecipientDashboard(r);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font color='red'><b>Oops!</b> User already exist but Try again with correct password. Thanks!</font></center></html>",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // login action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
    }
}