package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class PantryCupboard2DPanel extends JPanel {

    PantryCupboard2DPanel() {
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);

        PantryCupboard2D pantryCupboard2D = new PantryCupboard2D();
        gljPanel.addGLEventListener(pantryCupboard2D);

        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);
    }

}
