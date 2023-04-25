package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup implements ActionListener {

    JFrame frame;
    private ImageIcon logo;

    public Signup() {

        frame = new JFrame("AIUB Blood Donation Club App");

        frame.setIconImage(logo.getImage());
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