package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class StartUp extends JFrame {

    JLabel label2;
    JButton b1;

    StartUp() {
        label2 = new JLabel("Arpico Furniture");
        label2.setForeground(new Color(15, 50, 61));
        label2.setFont(new Font("Comic Sans MS", Font.BOLD, 37));
        label2.setBounds(386, 76, 430, 60);
        add(label2);

        String longText = "Our passion for craftsmanship and commitment to quality "
                + "reflect in every piece we create. We are more than just a "
                + "furniture company; we are artisans of comfort, style, and "
                + "functionality.";

        JTextArea textArea = new JTextArea(longText, 5, 30); // set rows and columns
        textArea.setForeground(new Color(131, 93, 56));
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // add some padding
        textArea.setOpaque(false); // make background transparent
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBounds(386, 150, 420, 300);
        add(textArea);

        Color startColor = new Color(143, 108, 74);
        Color endColor = new Color(107, 80, 54);
        b1 = new RoundedButton("Login", startColor, endColor);
        b1.setBounds(370, 450, 100, 30);
        b1.setFocusable(true); // Ensure the button is focusable
        add(b1);

        // Add ActionListener to the button
        b1.addActionListener(e -> {

            // Close startup form
            dispose();
            // Open login form
            new Login();
        });

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180));
        footerPanel.setBounds(0, 430, 850, 110);
        add(footerPanel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/virender-singh-hE0nmTffKtM-unsplash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 480);
        add(image);

        setLayout(null);
        setSize(850, 540);
        setLocation(380, 180);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application when the window is closed
    }

    public static void main(String[] args) {
        new StartUp();
    }
}
