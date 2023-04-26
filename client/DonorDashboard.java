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

public class DonorDashboard {
    private JPanel mainPanel, navbarPanel, postPanel;

    public DonorDashboard(Donor d) {
        // Create a JPanel for the navigation bar
        navbarPanel = new JPanel();
        // navbarPanel.setPreferredSize(new Dimension(400, 50));
        navbarPanel.setBackground(Color.BLUE);
        JLabel navLabel = new JLabel("Navigation Bar");
        navbarPanel.add(navLabel);

        // Create a JPanel for the posts
        postPanel = new JPanel();
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
        for (Post post : Post.posts) {
            PostPanel panelPost = new PostPanel(post);
            postPanel.add(panelPost);
        }

        // Create a main panel to hold the navigation bar and post panel
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navbarPanel, BorderLayout.NORTH);
        mainPanel.add(postPanel, BorderLayout.CENTER);

        // Create a JScrollPane and add the main panel to it
        JScrollPane scrollPane = new JScrollPane(mainPanel);

        // Create a JFrame and add the JScrollPane to it
        JFrame frame = new JFrame("Post Scroll Pane Example");
        frame.add(scrollPane);

        // frame
        frame.setSize(1366, 768);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static class PostPanel extends JPanel {
        public PostPanel(Post post) {
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
}
