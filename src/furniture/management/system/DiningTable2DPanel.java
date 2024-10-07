package furniture.management.system;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;
public class DiningTable2DPanel extends JPanel {
    DiningTable2DPanel() {
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);
        DiningTable2D diningTable2D = new DiningTable2D();
        gljPanel.addGLEventListener(diningTable2D);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);
    }
}
