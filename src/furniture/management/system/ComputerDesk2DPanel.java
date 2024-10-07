package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;

import javax.swing.*;
import java.awt.*;

public class ComputerDesk2DPanel extends JPanel {

    ComputerDesk2DPanel(){
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        final GLJPanel gljPanel = new GLJPanel(capabilities);
        ComputerDesk2D computerDesk2D = new ComputerDesk2D();
        gljPanel.addGLEventListener(computerDesk2D);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);
    }
}
