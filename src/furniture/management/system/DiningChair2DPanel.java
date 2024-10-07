package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class DiningChair2DPanel extends JPanel {

    DiningChair2DPanel(){
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);
        DiningChair2D diningChair2D = new DiningChair2D();
        gljPanel.addGLEventListener(diningChair2D);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);

    }
    public static void main(String[] args) {
        // Create and display the panel
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Computer Desk 2D Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new DiningChair2DPanel(), BorderLayout.CENTER);
            frame.setSize(1540, 762);
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }

}
