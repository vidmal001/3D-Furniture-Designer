package furniture.management.system;
import javax.swing.*;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.*;

public class CupboardPanel extends  JPanel{

    CupboardPanel(boolean showControls){
        Cupboard cupboard = new Cupboard();
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        final GLJPanel gljPanel = new GLJPanel(capabilities);
        gljPanel.addGLEventListener(cupboard);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);

        if(showControls) {
            ControlsPanel controlsPanel = new ControlsPanel(cupboard.rotationManager, cupboard.colorManager, cupboard.lightingManager);
            add(controlsPanel, BorderLayout.SOUTH);
            SavePanel savePanel = new SavePanel("CupboardPanel");
            add(savePanel,BorderLayout.NORTH);
        }
        final FPSAnimator animator = new FPSAnimator(gljPanel, 60, true);
        animator.start();
    }
}
