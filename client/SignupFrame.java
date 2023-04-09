package client;
import server.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupFrame {
    public SignupFrame() {
        JFrame f = new JFrame("Signup");

        JLabel aiubIdLabel, nameLabel, emailLabel, contactLabel, passwordLabel, bloodGroupLabel;
        JTextField aiubIdField, nameField, emailField, contactField;
        JPasswordField passwordField;
        JRadioButton donorRadioButton;
        JButton loginButton, signupButton;
        JComboBox<String> bloodGroupDropdown;

        aiubIdLabel = new JLabel("AIUB ID:");
        aiubIdLabel.setBounds(100, 100, 90, 30);
        aiubIdField = new JTextField("");
        aiubIdField.setBounds(200, 100, 180, 30);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 150, 90, 30);
        nameField = new JTextField("");
        nameField.setBounds(200, 150, 180, 30);

        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 200, 90, 30);
        emailField = new JTextField("");
        emailField.setBounds(200, 200, 180, 30);

        contactLabel = new JLabel("Phone NO:");
        contactLabel.setBounds(100, 250, 90, 30);
        contactField = new JTextField("");
        contactField.setBounds(200, 250, 180, 30);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 300, 90, 30);
        passwordField = new JPasswordField("");
        passwordField.setBounds(200, 300, 180, 30);

        bloodGroupLabel = new JLabel("Select your blood group: ");
        bloodGroupLabel.setBounds(100, 350, 150, 30);
        bloodGroupDropdown = new JComboBox<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" });
        bloodGroupDropdown.setBounds(250, 350, 100, 30);

        donorRadioButton = new JRadioButton("Are you a donor?");
        donorRadioButton.setBounds(130, 400, 200, 30);

        signupButton = new JButton("Sign Up");
        signupButton.setBounds(130, 450, 90, 30);
        loginButton = new JButton("Login");
        loginButton.setBounds(230, 450, 90, 30);

        // goto login frame
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                f.setVisible(false);
            }
        });

        // signup button event
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String aiubId = aiubIdField.getText();
                String name = nameField.getText();
                String email = emailField.getText();
                String contact = contactField.getText();
                String password = new String(passwordField.getPassword());
                String bloodGroup = (String) bloodGroupDropdown.getSelectedItem();
                boolean isDonor = donorRadioButton.isSelected();

                if (User.signup(aiubId, name, email, contact, password, bloodGroup, isDonor)) {
                    if (isDonor) {
                        Donor d = new Donor(aiubId, name, email, contact, password, bloodGroup, isDonor);
                        new DonorDashboard(d);
                        f.setVisible(false);
                    } else {
                        Recipient r = new Recipient(aiubId, name, email, contact, password, bloodGroup, isDonor);
                        // new RecipientDashboard(r);
                        f.setVisible(false);
                    }
                }

            }
        });

        f.add(aiubIdLabel);
        f.add(aiubIdField);
        f.add(nameLabel);
        f.add(nameField);
        f.add(emailLabel);
        f.add(emailField);
        f.add(contactLabel);
        f.add(contactField);
        f.add(passwordLabel);
        f.add(passwordField);
        f.add(passwordField);
        f.add(bloodGroupLabel);
        f.add(bloodGroupDropdown);
        f.add(donorRadioButton);
        f.add(donorRadioButton);
        f.add(loginButton);
        f.add(signupButton);

        f.setSize(500, 900);
        f.setLayout(null);
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new SignupFrame();
    }
}
