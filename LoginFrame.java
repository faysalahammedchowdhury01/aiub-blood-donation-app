import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame {
    public LoginFrame() {
        JFrame f = new JFrame("Login");

        JLabel aiubIdLabel, passwordLabel;
        JTextField aiubIdField;
        JPasswordField passwordField;
        JButton loginButton, signupButton;

        aiubIdLabel = new JLabel("AIUB ID:");
        aiubIdLabel.setBounds(100, 100, 90, 30);
        aiubIdField = new JTextField("");
        aiubIdField.setBounds(200, 100, 180, 30);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 150, 90, 30);
        passwordField = new JPasswordField("");
        passwordField.setBounds(200, 150, 180, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(130, 200, 90, 30);
        signupButton = new JButton("Sign Up");
        signupButton.setBounds(230, 200, 90, 30);

        // login event
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String aiubId = aiubIdField.getText();
                String password = new String(passwordField.getPassword());

                Donor d = Donor.Login(aiubId, password);
                Recipient r = Recipient.Login(aiubId, password);
                if (d != null) {
                    // new DonorDashboard(d);
                } else if (r != null) {
                    // new RecipientDashboard(r);
                } else {
                    // login failed
                }
            }
        });

        // signup button event
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignupFrame();
                f.setVisible(false);
            }
        });

        f.add(aiubIdLabel);
        f.add(passwordLabel);
        f.add(aiubIdField);
        f.add(passwordField);
        f.add(loginButton);
        f.add(signupButton);

        f.setSize(500, 900);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
