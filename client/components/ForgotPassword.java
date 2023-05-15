package client.components;

import client.assets.Color.MyColor;
import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class ForgotPassword {
    JFrame frame;
    private JPanel logoPanel;
    private BufferedImage image;
    private ImageIcon favIcon;
    private JLabel bgColor;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel taglineText;
    private JLabel aiubText;
    private JLabel forgotText;
    private JLabel forgotPassContainer;
    private JLabel aiubIdLabel;
    private JTextField aiubIdField;
    private JCheckBox isDonorAccount;
    private JButton searchButton;
    private JButton cancelButton;

    public ForgotPassword() {
        frame = new JFrame("Forgot Password? - AIUB BLOOD DONATION CLUB");

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

        // forgot pass container bg
        forgotPassContainer = new JLabel("");
        forgotPassContainer.setOpaque(true);
        forgotPassContainer.setBounds(680, 0, 770, 768);
        forgotPassContainer.setBackground(MyColor.darkRed);

        // forgot pass text
        forgotText = new JLabel("Find Your Account");
        forgotText.setBounds(800, 80, 500, 50);
        forgotText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        forgotText.setForeground(MyColor.white);

        // AIUB ID field and label
        aiubIdLabel = new JLabel("<html>Please enter your aiub id to search <br> for your account.</html>");
        aiubIdLabel.setBounds(800, 170, 500, 80);
        aiubIdLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        aiubIdLabel.setForeground(MyColor.white);

        aiubIdField = new JTextField("");
        aiubIdField.setBounds(800, 250, 450, 50);
        aiubIdField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // is donor account
        isDonorAccount = new JCheckBox("Are you a Donor?");
        isDonorAccount.setBounds(800, 320, 500, 30);
        isDonorAccount.setForeground(MyColor.white);
        isDonorAccount.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        isDonorAccount.setContentAreaFilled(false);
        isDonorAccount.setBorderPainted(false);
        isDonorAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // search button
        searchButton = new JButton("Search");
        searchButton.setBounds(800, 370, 220, 50);
        searchButton.setBackground(MyColor.green);
        searchButton.setForeground(MyColor.white);
        searchButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // cancel
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(1030, 370, 220, 50);
        cancelButton.setBackground(MyColor.darkBlue);
        cancelButton.setForeground(MyColor.white);
        cancelButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // adding
        frame.add(logoPanel);
        frame.add(aiubText);
        frame.add(taglineText);
        frame.add(forgotText);
        frame.add(aiubIdLabel);
        frame.add(aiubIdField);
        frame.add(isDonorAccount);
        frame.add(searchButton);
        frame.add(cancelButton);
        frame.add(forgotPassContainer);
        frame.add(bgColor);

        // frame
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // action listeners

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String aiubId = aiubIdField.getText().trim();
                boolean isDonor = isDonorAccount.isSelected();

                if (aiubId.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "<html><center><font size='5' color='red'><b>Oops!</b> It seems like some required information is missing. Please fill in all the fields to proceed. Thanks!</font></center></html>",
                            "", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (isDonor) {
                    if (!Donor.isDonorExist(aiubId)) {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='red'>Your search did not return any results. Please try again with other information.",
                                "", JOptionPane.WARNING_MESSAGE);
                    } else {
                        frame.setVisible(false);
                        new ResetPassword(aiubId, isDonor);
                    }
                } else {
                    if (!Recipient.isRecipientExist(aiubId)) {
                        JOptionPane.showMessageDialog(null,
                                "<html><center><font size='5' color='red'>Your search did not return any results. Please try again with other information.",
                                "", JOptionPane.WARNING_MESSAGE);
                    } else {
                        frame.setVisible(false);
                        new ResetPassword(aiubId, isDonor);
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