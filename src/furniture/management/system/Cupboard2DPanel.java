package furniture.management.system;

import javax.swing.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import java.awt.*;

public class Cupboard2DPanel extends JPanel {

    Cupboard2DPanel() {
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);
        Cupboard2D cupboard2D = new Cupboard2D();
        gljPanel.addGLEventListener(cupboard2D);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);
    }
}
