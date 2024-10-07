package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class WardrobeStartUpPanel extends JPanel {
    WardrobeStartUpPanel() {
        setBackground(new Color(171, 222, 247));
        setLayout(null);  // Set null layout

        // Adding labels to the panel
        JLabel titleLabel = new JLabel("Wardrobe");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        titleLabel.setForeground(Color.black);
        titleLabel.setBounds(50, 50, 400, 30);  // Set bounds (x, y, width, height)

        JLabel descriptionLabel = StartupUtils.createDescriptionLabel(
                "You Can Select Either 2D or 3D model to Customize Your Design ....",
                430, 190, 750, 30);
        //add(titleLabel);
        add(descriptionLabel);

        JLabel backgroundImage = StartupUtils.createImageLabel("icons/pexels-nugroho-wahyu-3119180.jpg", 0, 0, 1540, 760);


        // Adding images to the panel
        JLabel image2d = StartupUtils.createImageLabel("icons/2d.png", 510, 280, 256, 256);
        JLabel image3d = StartupUtils.createImageLabel("icons/3d_1666631.png", 820, 280, 256, 256);

        add(image2d);
        add(image3d);

        // Adding transparent overlay
        JPanel imageOverlay = StartupUtils.createTransparentOverlay(370, 150, 840, 500, 50);
        add(imageOverlay);

        ///////////////////new
        Color startColor = new Color(143, 108, 74);
        Color endColor = new Color(107, 80, 54);


        // Adding buttons for 2D and 3D
        JButton button2d = new RoundedButton("2d Design", startColor, endColor);
        button2d.setBounds(590, 550, 100, 30);
        button2d.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(WardrobeStartUpPanel.this);
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "WardrobeDisplay2d");
        });
        add(button2d);

        JButton button3d =  new RoundedButton("3d Design", startColor, endColor);
        button3d.setBounds(900, 550, 100, 30);
        button3d.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(WardrobeStartUpPanel.this);
            CardLayout cardLayout = (CardLayout) frame.getContentPane().getLayout();
            cardLayout.show(frame.getContentPane(), "WardrobeDisplay");
        });
        add(button3d);
        ///////////

        add(backgroundImage);
    }
}
