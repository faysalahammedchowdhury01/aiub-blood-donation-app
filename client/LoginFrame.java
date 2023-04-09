package client;
import java.lang.*;
import javax.swing.*;  
import java.awt.event.*;  
import static javax.swing.JOptionPane.showMessageDialog;
import server.*;

public class LoginFrame {
        JLabel aiubIdLabel, passwordLabel;
        JTextField aiubIdField;
        JPasswordField passwordField;
        JButton loginButton, signupButton;
        JFrame frame;
    
    public LoginFrame() {
        // create frame
        frame = new JFrame ("Login");

        //construct components
        aiubIdLabel = new JLabel("AIUB ID:");
        aiubIdField = new JTextField("");
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField("");
        loginButton = new JButton("Login");
        signupButton = new JButton("Sign Up");

        //set component bounds (only needed by Absolute Positioning)
        aiubIdLabel.setBounds(100, 100, 90, 30);
        aiubIdField.setBounds(200, 100, 180, 30);
        passwordLabel.setBounds(100, 150, 90, 30);
        passwordField.setBounds(200, 150, 180, 30);
        loginButton.setBounds(130, 200, 90, 30);
        signupButton.setBounds(230, 200, 90, 30);

        //addActionListener
		// loginButton.addActionListener(this);


        //add components
        frame.add(aiubIdLabel);
        frame.add(passwordLabel);
        frame.add(aiubIdField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(signupButton);

        //frame properties
		//adjust size and set layout
        frame.setSize (624, 400);
		frame.setLocationRelativeTo(null);//to center screen gui
        frame.setLayout (null);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible (true); 
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
