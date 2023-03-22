import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame {
    public LoginFrame() {
        JFrame f = new JFrame("Login");

        JLabel usernameLabel, passwordLabel;
        JTextField usernameField;
        JPasswordField passwordField;
        JButton loginButton, signupButton;

        usernameLabel = new JLabel("AIUB ID:");
        usernameLabel.setBounds(100, 100, 90, 30);
        usernameField = new JTextField("");
        usernameField.setBounds(200, 100, 180, 30);

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
                String aiubId = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (User.login(aiubId, password)) {
                } else {
                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // new SignupFrame();
            }
        });

        f.add(usernameLabel);
        f.add(passwordLabel);
        f.add(usernameField);
        f.add(passwordField);
        f.add(loginButton);
        f.add(signupButton);
        f.setSize(500, 900);
        f.setLayout(null);
        f.setVisible(true);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); // center window on screen
        f.setResizable(false);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
