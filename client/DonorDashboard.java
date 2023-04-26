package client;

import server.classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class DonorDashboard {
    JFrame frame;
    private JPanel panelTopNav, postPanel;
    private JScrollPane scrollpanelTopNav, scrollPostPanel;

    public DonorDashboard(Donor d) {
        frame = new JFrame("Dashboard - AIUB BLOOD DONATIIN CLUB");
        postPanel = new JPanel();
        panelTopNav = new JPanel();

        // panels layout
        panelTopNav.setLayout(null);
        panelTopNav.setLayout(new BoxLayout(panelTopNav, BoxLayout.Y_AXIS));

        // posts
        for (Post post : Post.posts) {
            PostPanel postPanel = new PostPanel(post);
            panelTopNav.add(postPanel);
        }

        // scroll panels
        scrollpanelTopNav = new JScrollPane(panelTopNav);
        scrollPostPanel = new JScrollPane(postPanel);

        // panel adding
        frame.add(scrollpanelTopNav);

        // Set the size of the JFrame and make it visible
        frame.setSize(1366, 768);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // post panel
    private static class PostPanel extends JPanel {
        public PostPanel(Post post) {
            setLayout(null); // set null layout to enable manual positioning of components
            JLabel dateLabel = new JLabel("Date: " + post.getDate());
            JLabel locationLabel = new JLabel("Location: " + post.getLocation());
            JLabel descriptionLabel = new JLabel("Description: " + post.getDescription());
            dateLabel.setBounds(100, 20, 100, 20); // set bounds for dateLabel
            locationLabel.setBounds(10, 40, 100, 20); // set bounds for locationLabel
            descriptionLabel.setBounds(10, 100, 180, 40); // set bounds for descriptionLabel
            add(dateLabel);
            add(locationLabel);
            add(descriptionLabel);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setPreferredSize(new Dimension(1366, 600));
        }
    }

}
