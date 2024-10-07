package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class Bed2DPanel extends JPanel {
    Bed2DPanel() {
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);
        Bed2D Bed2D = new Bed2D();
        gljPanel.addGLEventListener(Bed2D);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);
    }
}
