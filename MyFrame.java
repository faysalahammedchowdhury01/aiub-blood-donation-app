import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Have an account?");
        panel.add(label);

        JButton button = new JButton("Login");
        panel.add(button);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
