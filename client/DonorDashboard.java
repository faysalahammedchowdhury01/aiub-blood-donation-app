package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class DonorDashboard {
    private boolean isShowDropdown;

    JFrame frame;
    private ImageIcon favIcon;
    private JLabel bgColor;
    private JLabel topNavBg;
    private BufferedImage image;
    private JLabel aiubLogo;
    private JLabel logo;
    private JLabel aiubText;
    private JButton name;
    private JLabel dropdownImage;
    private JLabel dropdownBox;
    private JButton seeProfile;
    private JButton logoutButton;

    public DonorDashboard(Donor r) {
        frame = new JFrame("Dashboard - AIUB Blood Donation Club");

        // favIcon
        favIcon = new ImageIcon("images/logo.png");
        frame.setIconImage(favIcon.getImage());

        // frame background
        bgColor = new JLabel("");
        bgColor.setOpaque(true);
        bgColor.setBounds(0, 0, 1366, 768);
        bgColor.setBackground(Color.WHITE);

        // top nav background
        topNavBg = new JLabel("");
        topNavBg.setOpaque(true);
        topNavBg.setBounds(0, 0, 1366, 80);
        topNavBg.setBackground(new Color(169, 29, 20));

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
        name = new JButton("Welcome, " + r.getName().split(" ")[0]);
        name.setBounds(1366 - 320, 15, 250, 50);
        name.setForeground(Color.WHITE);
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // dropdown image
        try {
            image = ImageIO.read(new File("images/dropdown.png"));
            dropdownImage = new JLabel(new ImageIcon(image));
            dropdownImage.setBounds(1366 - 150, 15, 150, 50);
            dropdownImage.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
            dropdownImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // dropdown box
        dropdownBox = new JLabel("");
        dropdownBox.setBounds(1366 - 300, 70, 250, 170);
        dropdownBox.setBackground(Color.BLACK);
        dropdownBox.setOpaque(true);
        dropdownBox.setVisible(false);
        isShowDropdown = false;

        // see profile
        seeProfile = new JButton("See Profile");
        seeProfile.setBounds(1366 - 280, 80, 210, 65);
        seeProfile.setBackground(Color.WHITE);
        seeProfile.setForeground(Color.BLACK);
        seeProfile.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        seeProfile.setBorderPainted(false);
        seeProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seeProfile.setVisible(false);

        // see profile
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(1366 - 280, 160, 210, 65);
        logoutButton.setBackground(Color.WHITE);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        logoutButton.setBorderPainted(false);
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setVisible(false);

        // adding
        frame.add(aiubLogo);
        frame.add(logo);
        frame.add(aiubText);
        frame.add(dropdownImage);
        frame.add(name);
        frame.add(seeProfile);
        frame.add(logoutButton);
        frame.add(dropdownBox);
        frame.add(topNavBg);
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

        // logout action
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
    }

    // show dropwdown
    private void showDropdown() {
        isShowDropdown = true;
        dropdownBox.setVisible(true);
        seeProfile.setVisible(true);
        logoutButton.setVisible(true);
    }

    // hide dropdown
    private void hideDropdown() {
        isShowDropdown = false;
        dropdownBox.setVisible(false);
        seeProfile.setVisible(false);
        logoutButton.setVisible(false);
    }
}
