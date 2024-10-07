package furniture.management.system;

import javax.swing.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;

public class DiningChairDisplay extends JPanel {
    DiningChairDisplay(boolean showControls){
        DiningChair diningChair = new DiningChair();
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        final GLJPanel gljPanel = new GLJPanel(capabilities);
        gljPanel.addGLEventListener(diningChair);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);

        if(showControls) {
            ControlsPanel controlsPanel = new ControlsPanel(diningChair.rotationManager, diningChair.colorManager, diningChair.lightingManager);
            add(controlsPanel, BorderLayout.SOUTH);
            SavePanel savePanel = new SavePanel("DiningChairDisplay");
            add(savePanel,BorderLayout.NORTH);
        }
        final FPSAnimator animator = new FPSAnimator(gljPanel, 60, true);
        animator.start();

    }
}
