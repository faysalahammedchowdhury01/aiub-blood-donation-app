import javax.swing.*;
import java.awt.*;

public class Demo {
    public static void main(String[] args) {
        // Create an array of posts to display
        Post[] posts = {
                new Post("2022-05-01", "New York", "Post 1 description"),
                new Post("2022-05-02", "Los Angeles", "Post 2 description"),
                new Post("2022-05-03", "Chicago", "Post 3 description"),
                new Post("2022-05-04", "Houston", "Post 4 description"),
                new Post("2022-05-05", "Miami", "Post 5 description"),
                new Post("2022-05-06", "San Francisco", "Post 6 description"),
                new Post("2022-05-07", "Seattle", "Post 7 description"),
                new Post("2022-05-08", "Boston", "Post 8 description"),
                new Post("2022-05-09", "Dallas", "Post 9 description"),
                new Post("2022-05-10", "Washington DC", "Post 10 description")
        };

        // Create a JPanel for the navigation bar
        JPanel navBar = new JPanel();
        navBar.setPreferredSize(new Dimension(400, 50));
        navBar.setBackground(Color.BLUE);
        JLabel navLabel = new JLabel("Navigation Bar");
        navBar.add(navLabel);

        // Create a JPanel for the posts
        JPanel postPanel = new JPanel();
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
        for (Post post : posts) {
            PostPanel panelPost = new PostPanel(post);
            postPanel.add(panelPost);
        }

        // Create a main panel to hold the navigation bar and post panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(navBar, BorderLayout.NORTH);
        mainPanel.add(postPanel, BorderLayout.CENTER);

        // Create a JScrollPane and add the main panel to it
        JScrollPane scrollPane = new JScrollPane(mainPanel);

        // Create a JFrame and add the JScrollPane to it
        JFrame frame = new JFrame("Post Scroll Pane Example");
        frame.add(scrollPane);

        // Set the size of the JFrame and make it visible
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private static class Post {
        private String date;
        private String location;
        private String description;

        public Post(String date, String location, String description) {
            this.date = date;
            this.location = location;
            this.description = description;
        }

        public String getDate() {
            return date;
        }

        public String getLocation() {
            return location;
        }

        public String getDescription() {
            return description;
        }
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
