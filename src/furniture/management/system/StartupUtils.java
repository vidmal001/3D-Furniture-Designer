package furniture.management.system;
import javax.swing.*;
import java.awt.*;
public class StartupUtils {
    public static JLabel createDescriptionLabel(String text, int x, int y, int width, int height) {
        JLabel descriptionLabel = new JLabel(text);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        descriptionLabel.setForeground(Color.black);
        descriptionLabel.setBounds(x, y, width, height);
        return descriptionLabel;
    }

    public static JLabel createImageLabel(String imagePath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image scaledImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(x, y, width, height);
        return imageLabel;
    }

    public static JPanel createTransparentOverlay(int x, int y, int width, int height, int opacity) {
        JPanel overlay = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Set the color and alpha (opacity) value
                g.setColor(new Color(255, 255, 255, opacity)); // Opacity value (0-255)
                g.fillRect(0, 0, getWidth(), getHeight()); // Fill the entire panel
            }
        };
        overlay.setOpaque(false); // Make the overlay transparent
        overlay.setBounds(x, y, width, height);
        return overlay;
    }
}