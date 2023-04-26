package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Login {
    JFrame frame;
    private ImageIcon favIcon;
    private JLabel bgColor;
    private JLabel aiubLogo;
    private JLabel logo;
    private BufferedImage image;
    private JLabel taglineText;
    private JLabel aiubText;
    private JLabel loginText;
    private JLabel loginContainerBg;
    private JLabel aiubIdLabel;
    private JTextField aiubIdField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton forgotPasswordButton;
    private JLabel signupText;
    private JButton signupButton;
    private JCheckBox isDonorLogin;

    public Login() {
        frame = new JFrame("Login - AIUB BLOOD DONATIIN CLUB");

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

        // login container bg
        loginContainerBg = new JLabel("");
        loginContainerBg.setOpaque(true);
        loginContainerBg.setBounds(680, 0, 770, 768);
        loginContainerBg.setBackground(new Color(169, 29, 20));

        // login text
        loginText = new JLabel("Login");
        loginText.setBounds(800, 80, 500, 50);
        loginText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        loginText.setForeground(Color.WHITE);

        // AIUB ID field and label
        aiubIdLabel = new JLabel("AIUB ID: ");
        aiubIdLabel.setBounds(800, 170, 100, 30);
        aiubIdLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        aiubIdLabel.setForeground(Color.WHITE);

        aiubIdField = new JTextField("");
        aiubIdField.setBounds(800, 210, 450, 50);
        aiubIdField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // Password label and filed
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(800, 270, 200, 30);
        passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        passwordLabel.setForeground(Color.WHITE);

        passwordField = new JPasswordField("");
        passwordField.setBounds(800, 310, 450, 50);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // is donor login
        isDonorLogin = new JCheckBox("Are you a Donor?");
        isDonorLogin.setBounds(800, 375, 500, 30);
        isDonorLogin.setBackground(new Color(255, 109, 96));
        isDonorLogin.setForeground(Color.WHITE);
        isDonorLogin.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        isDonorLogin.setOpaque(false);
        isDonorLogin.setContentAreaFilled(false);
        isDonorLogin.setBorderPainted(false);
        isDonorLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // login button
        loginButton = new JButton("Login");
        loginButton.setBounds(800, 430, 450, 50);
        loginButton.setBackground(new Color(24, 165, 88));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // forgot password button
        forgotPasswordButton = new JButton("Forgot Password?");
        forgotPasswordButton.setBounds(880, 490, 300, 30);
        forgotPasswordButton.setForeground(new Color(247, 208, 96));
        forgotPasswordButton.setBackground(new Color(255, 109, 96));
        forgotPasswordButton.setOpaque(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // sign up text and button
        signupText = new JLabel("Don't have an account?");
        signupText.setBounds(915, 520, 200, 30);
        signupText.setForeground(Color.WHITE);

        signupButton = new JButton("Sign up");
        signupButton.setBounds(1060, 520, 100, 30);
        signupButton.setForeground(new Color(247, 208, 96));
        signupButton.setOpaque(false);
        signupButton.setContentAreaFilled(false);
        signupButton.setBorderPainted(false);
        signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // adding
        frame.add(aiubLogo);
        frame.add(logo);
        frame.add(aiubText);
        frame.add(taglineText);
        frame.add(loginText);
        frame.add(isDonorLogin);
        frame.add(aiubIdLabel);
        frame.add(aiubIdField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(forgotPasswordButton);
        frame.add(signupText);
        frame.add(signupButton);
        frame.add(loginContainerBg);
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
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // take data
                String aiubId = aiubIdField.getText().trim();
                char[] password = passwordField.getPassword();
                String passwordString = new String(password);
                boolean isDonor = isDonorLogin.isSelected();

                // validation
                if (aiubId.isEmpty() || passwordString.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font color='red'><b>Oops!</b> It seems like some required information is missing. Please fill in all the fields to proceed. Thanks!</font></center></html>",
                            "", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // go for login process
                if (isDonor) {
                    Donor d = Donor.login(aiubId, passwordString);
                    if (d != null) {
                        frame.setVisible(false);
                        new DonorDashboard(d);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font color='red'><b>Oops!</b> Invalid login credentials. Please check your AIUB ID and password and try again!</font></center></html>",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    Recipient r = Recipient.login(aiubId, passwordString);
                    if (r != null) {
                        frame.setVisible(false);
                        new RecipientDashboard(r);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font color='red'><b>Oops!</b> Invalid login credentials. Please check your email and password and try again!</font></center></html>",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // sign up action
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Signup();
            }
        });
    }
}