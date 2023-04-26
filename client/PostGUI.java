package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import server.classes.*;

public class PostGUI extends JPanel {
    public PostGUI(Post post) {
        setLayout(new GridLayout(2, 3));
        JLabel dateLabel = new JLabel("Date: " + post.getDate());
        JLabel locationLabel = new JLabel("Location: " + post.getLocation());
        JLabel descriptionLabel = new JLabel("Description: " + post.getDescription());
        add(dateLabel);
        add(locationLabel);
        add(descriptionLabel);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setPreferredSize(new Dimension(200, 100));
    }
}
