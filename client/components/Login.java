package client.components;

import client.assets.Color.MyColor;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class Login {
    JFrame frame;
    private JPanel logoPanel, signUpPanel;
    private BufferedImage image;
    private ImageIcon favIcon;
    private JLabel bgColor;
    private JLabel aiubLogo;
    private JLabel logo;
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
        frame = new JFrame("Login - AIUB BLOOD DONATION CLUB");

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

        // logo panel
        logoPanel = new JPanel();
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -10, 0));
        logoPanel.setBounds(0, 200, 680, 250);
        logoPanel.setBackground(MyColor.white);

        // aiub and blood logo
        try {
            image = ImageIO.read(new File("client/assets/images/aiub_logo.png"));
            aiubLogo = new JLabel(new ImageIcon(image));
            logoPanel.add(aiubLogo);
        } catch (Exception e) {
        }

        try {
            image = ImageIO.read(new File("client/assets/images/logo.png"));
            logo = new JLabel(new ImageIcon(image));
            logoPanel.add(logo);
        } catch (Exception e) {
        }

        // aiub text
        aiubText = new JLabel("AIUB BLOOD DONATION CLUB",
                SwingConstants.CENTER);
        aiubText.setBounds(0, 320, 680, 300);
        aiubText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        aiubText.setForeground(MyColor.black);

        // tagline text
        taglineText = new JLabel("Donate Blood, Save Life.", SwingConstants.CENTER);
        taglineText.setBounds(0, 370, 680, 300);
        taglineText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        taglineText.setForeground(MyColor.red);

        // login container bg
        loginContainerBg = new JLabel("");
        loginContainerBg.setOpaque(true);
        loginContainerBg.setBounds(680, 0, 770, 768);
        loginContainerBg.setBackground(MyColor.darkRed);

        // login text
        loginText = new JLabel("Login");
        loginText.setBounds(800, 80, 500, 50);
        loginText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        loginText.setForeground(MyColor.white);

        // AIUB ID field and label
        aiubIdLabel = new JLabel("AIUB ID: ");
        aiubIdLabel.setBounds(800, 170, 100, 30);
        aiubIdLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        aiubIdLabel.setForeground(MyColor.white);

        aiubIdField = new JTextField("");
        aiubIdField.setBounds(800, 210, 450, 50);
        aiubIdField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // Password label and filed
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(800, 270, 200, 30);
        passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        passwordLabel.setForeground(MyColor.white);

        passwordField = new JPasswordField("");
        passwordField.setBounds(800, 310, 450, 50);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // is donor login
        isDonorLogin = new JCheckBox("Are you a Donor?");
        isDonorLogin.setBounds(800, 375, 500, 30);
        isDonorLogin.setForeground(MyColor.white);
        isDonorLogin.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        isDonorLogin.setContentAreaFilled(false);
        isDonorLogin.setBorderPainted(false);
        isDonorLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // login button
        loginButton = new JButton("Login");
        loginButton.setBounds(800, 430, 450, 50);
        loginButton.setBackground(MyColor.green);
        loginButton.setForeground(MyColor.white);
        loginButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // forgot password button
        forgotPasswordButton = new JButton("Forgot Password?");
        forgotPasswordButton.setBounds(880, 510, 300, 30);
        forgotPasswordButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        forgotPasswordButton.setForeground(MyColor.yellow);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // sign up panel
        signUpPanel = new JPanel();
        signUpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, -10, 0));
        signUpPanel.setBounds(680, 540, 1366 - 680, 50);
        signUpPanel.setBackground(MyColor.darkRed);

        signupText = new JLabel("Don't have an account?");
        signupText.setForeground(MyColor.white);
        signupText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));

        signupButton = new JButton("Sign up");
        signupButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        signupButton.setForeground(MyColor.yellow);
        signupButton.setOpaque(false);
        signupButton.setContentAreaFilled(false);
        signupButton.setBorderPainted(false);
        signupButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // signup panel adding
        signUpPanel.add(signupText);
        signUpPanel.add(signupButton);

        // adding
        frame.add(logoPanel);
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
        frame.add(signUpPanel);
        frame.add(loginContainerBg);
        frame.add(bgColor);

        // frame
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
                            "<html><center><font size='5' color='red'><b>Oops!</b> It seems like some required information is missing. Please fill in all the fields to proceed. Thanks!</font></center></html>",
                            "", JOptionPane.WARNING_MESSAGE);
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
                                "<html><center><font size='5' color='red'><b>Oops!</b> Invalid login attempt. Please check your AIUB ID and password and try again!</font></center></html>",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    Recipient r = Recipient.login(aiubId, passwordString);
                    if (r != null) {
                        frame.setVisible(false);
                        new RecipientDashboard(r);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='red'><b>Oops!</b> Invalid login attempt. Please check your AIUB ID and password and try again!</font></center></html>",
                                "", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // forgot password action
        forgotPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new ForgotPassword();
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