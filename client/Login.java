package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;

public class Login implements ActionListener {
    JFrame frame;
    private ImageIcon favIcon;
    private JLabel bgColor;
    private JLabel logo;
    private BufferedImage image;
    private JLabel text;
    private JLabel loginText;
    private JLabel loginContainerBg;
    private JLabel aiubIdLabel;
    private JTextField aiubIdField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        frame = new JFrame("AIUB Blood Donation Club App");

        // FavIcon
        favIcon = new ImageIcon("images/favIcon.png");
        frame.setIconImage(favIcon.getImage());

        // frame background
        bgColor = new JLabel("");
        bgColor.setOpaque(true);
        bgColor.setBounds(0, 0, 1366, 768);
        bgColor.setBackground(new Color(247, 208, 96));

        // Logo
        try {
            image = ImageIO.read(new File("images/logo.png"));
            logo = new JLabel(new ImageIcon(image));
            logo.setBounds(240, 180, image.getWidth(), image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Text
        text = new JLabel("Donate Blood, Save Life");
        text.setBounds(120, 330, 500, 300);
        text.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        text.setForeground(Color.red);

        // login text
        loginText = new JLabel("Login");
        loginText.setBounds(800, 100, 500, 50);
        loginText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        loginText.setForeground(Color.WHITE);

        // login container bg
        loginContainerBg = new JLabel("");
        loginContainerBg.setOpaque(true);
        loginContainerBg.setBounds(680, 0, 770, 768);
        loginContainerBg.setBackground(new Color(255, 109, 96));

        // AIUB ID field and label
        aiubIdLabel = new JLabel("AIUB ID: ");
        aiubIdLabel.setBounds(800, 190, 100, 30);
        aiubIdLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        aiubIdLabel.setForeground(Color.WHITE);

        aiubIdField = new JTextField("");
        aiubIdField.setBounds(800, 230, 450, 50);
        aiubIdField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // Password label and filed
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(800, 290, 200, 30);
        passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        passwordLabel.setForeground(Color.WHITE);

        passwordField = new JPasswordField("");
        passwordField.setBounds(800, 330, 450, 50);
        passwordField.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        // login button
        loginButton = new JButton("Login");
        loginButton.setBounds(800, 410, 450, 50);
        loginButton.setBackground(new Color(24, 165, 88));

        // adding
        frame.add(logo);
        frame.add(text);
        frame.add(loginText);
        frame.add(aiubIdLabel);
        frame.add(aiubIdField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);
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

    }

    public void actionPerformed(ActionEvent e) {

    }

}