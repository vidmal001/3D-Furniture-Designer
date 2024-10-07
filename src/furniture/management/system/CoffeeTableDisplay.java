package furniture.management.system;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;

public class CoffeeTableDisplay extends JPanel {

    CoffeeTableDisplay(boolean showControls){
        CoffeeTable coffeeTable  = new CoffeeTable();
        setLayout(new BorderLayout());

        final GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);

        final GLJPanel gljPanel = new GLJPanel(capabilities);
        gljPanel.addGLEventListener(coffeeTable);
        gljPanel.setSize(800, 600);
        add(gljPanel, BorderLayout.CENTER);

        if(showControls) {
            ControlsPanel controlsPanel = new ControlsPanel(coffeeTable.rotationManager, coffeeTable.colorManager, coffeeTable.lightingManager);
            add(controlsPanel, BorderLayout.SOUTH);
            SavePanel savePanel = new SavePanel("CoffeeTableDisplay");
            add(savePanel,BorderLayout.NORTH);
        }

        final FPSAnimator animator = new FPSAnimator(gljPanel, 60, true);
        animator.start();

    }
}

