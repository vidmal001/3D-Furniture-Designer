package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame {
    JProgressBar progressBar;

    public SplashScreen() {
        super("Loading...");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sofa.png"));
        Image i2 = i1.getImage().getScaledInstance(85,58, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setPreferredSize(new Dimension(85, 65)); // Set preferred size

        // Add the image to the content pane
        content.add(image, BorderLayout.NORTH);

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setString("Wait a Moment We Are getting Things Ready For You......");
        progressBar.setStringPainted(true);
        content.add(progressBar, BorderLayout.CENTER);

        setContentPane(content);
        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
        setVisible(true);
    }
}