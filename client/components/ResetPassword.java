package client.components;

import client.assets.Color.MyColor;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class ResetPassword {
    JFrame frame;
    private JPanel logoPanel;
    private BufferedImage image;
    private ImageIcon favIcon;
    private JLabel bgColor;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel taglineText;
    private JLabel aiubText;
    private JLabel setupPassText;
    private JLabel setupPassContainer;
    private JLabel aiubIdLabel;
    private JTextField aiubIdField;
    private JLabel newPasswordLabel;
    private JPasswordField newPasswordField;
    private JLabel confirmNewPasswordLabel;
    private JPasswordField confirmNewPasswordField;
    private JButton resetButton;
    private JButton cancelButton;

    public ResetPassword(String aiubId, boolean isDonor) {
        frame = new JFrame("Reset Password - AIUB BLOOD DONATION CLUB");

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

        // setup pass container bg
        setupPassContainer = new JLabel("");
        setupPassContainer.setOpaque(true);
        setupPassContainer.setBounds(680, 0, 770, 768);
        setupPassContainer.setBackground(MyColor.darkRed);

        // setup pass text
        setupPassText = new JLabel("Reset Password");
        setupPassText.setBounds(800, 80, 500, 50);
        setupPassText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        setupPassText.setForeground(MyColor.white);

        // AIUB ID field and label
        aiubIdLabel = new JLabel("AIUB ID:");
        aiubIdLabel.setBounds(800, 170, 450, 30);
        aiubIdLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        aiubIdLabel.setForeground(MyColor.white);

        aiubIdField = new JTextField(aiubId);
        aiubIdField.setBounds(800, 210, 450, 50);
        aiubIdField.setEditable(false);
        aiubIdField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // new password label and filed
        newPasswordLabel = new JLabel("New Password: ");
        newPasswordLabel.setBounds(800, 270, 450, 30);
        newPasswordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        newPasswordLabel.setForeground(MyColor.white);

        newPasswordField = new JPasswordField("");
        newPasswordField.setBounds(800, 310, 450, 50);
        newPasswordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // confirm new password label and filed
        confirmNewPasswordLabel = new JLabel("Confirm New Password: ");
        confirmNewPasswordLabel.setBounds(800, 370, 450, 30);
        confirmNewPasswordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        confirmNewPasswordLabel.setForeground(MyColor.white);

        confirmNewPasswordField = new JPasswordField("");
        confirmNewPasswordField.setBounds(800, 410, 450, 50);
        confirmNewPasswordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // reset button
        resetButton = new JButton("Reset");
        resetButton.setBounds(800, 490, 220, 50);
        resetButton.setBackground(MyColor.green);
        resetButton.setForeground(MyColor.white);
        resetButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // cancel
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(1030, 490, 220, 50);
        cancelButton.setBackground(MyColor.darkBlue);
        cancelButton.setForeground(MyColor.white);
        cancelButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // adding
        frame.add(logoPanel);
        frame.add(aiubText);
        frame.add(taglineText);
        frame.add(setupPassText);
        frame.add(aiubIdLabel);
        frame.add(aiubIdField);
        frame.add(newPasswordLabel);
        frame.add(newPasswordField);
        frame.add(confirmNewPasswordLabel);
        frame.add(confirmNewPasswordField);
        frame.add(resetButton);
        frame.add(cancelButton);
        frame.add(setupPassContainer);
        frame.add(bgColor);

        // frame
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // action listeners

        // cancel button action
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] password = newPasswordField.getPassword();
                String passwordString = new String(password).trim();
                password = confirmNewPasswordField.getPassword();
                String confirmPasswordString = new String(password).trim();

                // validation
                if (passwordString.isEmpty() || confirmPasswordString.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font size='5' color='red'><b>Oops!</b> It seems like some required information is missing. Please fill in all the fields to proceed. Thanks!</font></center></html>",
                            "", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // password and confirm password matching
                if (!passwordString.equals(confirmPasswordString)) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font size='5' color='red'><b>Oops!</b> Password and confirm password don't match. Please try again.</font></center></html>",
                            "", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // go for reset password
                if (isDonor) {
                    if (Donor.resetPassword(aiubId, confirmPasswordString)) {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='green'>Your password has been successfully updated! Login with confidence using your new credentials.</font></center></html>",
                                "", JOptionPane.WARNING_MESSAGE);
                        frame.setVisible(false);
                        new Login();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='red'>We apologize, but the password update process was unsuccessful. Please try again.</font></center></html>",
                                "", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    if (Recipient.resetPassword(aiubId, confirmPasswordString)) {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='green'>Your password has been successfully updated! Login with confidence using your new credentials.</font></center></html>",
                                "", JOptionPane.WARNING_MESSAGE);
                        frame.setVisible(false);
                        new Login();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='red'>We apologize, but the password update process was unsuccessful. Please try again.</font></center></html>",
                                "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        // cancel button action
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
    }
}