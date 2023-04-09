package client;
import server.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DonorDashboard {
    public DonorDashboard(Donor d) {
        JFrame f = new JFrame("Dashboard");

        JLabel greetLabel;
        JButton logoutButton;

        greetLabel = new JLabel("Hello, " + d.getName());
        greetLabel.setBounds(20, 20, 90, 30);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(370, 20, 90, 30);

        f.add(greetLabel);
        f.add(logoutButton);

        f.setSize(500, 900);
        f.setLayout(null);
        f.setVisible(true);

    }

}
