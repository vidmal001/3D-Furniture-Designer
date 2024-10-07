package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;

public class WardrobeDisplay extends JPanel {
    //    private Wardrobe wardrobe;
    WardrobeDisplay(boolean showControls){
        Wardrobe wardrobe = new Wardrobe();
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        final GLJPanel gljPanel = new GLJPanel(capabilities);
        gljPanel.addGLEventListener(wardrobe);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);

        if(showControls) {
            ControlsPanel controlsPanel = new ControlsPanel(wardrobe.rotationManager, wardrobe.colorManager, wardrobe.lightingManager);
            add(controlsPanel, BorderLayout.SOUTH);
            SavePanel savePanel = new SavePanel("WardrobeDisplay");
            add(savePanel,BorderLayout.NORTH);
        }

        final FPSAnimator animator = new FPSAnimator(gljPanel, 60, true);
        animator.start();

    }
}

