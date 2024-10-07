package furniture.management.system;

import com.jogamp.opengl.GL2;

public class LightingManager {
    private boolean isLightingEnabled = false;
    public void toggleLighting() {
        isLightingEnabled = !isLightingEnabled;
    }

    public void applyLighting(GL2 gl) {
        if (isLightingEnabled) {
            gl.glEnable(GL2.GL_LIGHTING);
            gl.glEnable(GL2.GL_LIGHT0);

            // Set light position (directional light)
            float[] lightDirection = {0.0f, -1.0f, 0.0f, 0.0f}; // pointing downwards
            gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, lightDirection, 0);

            // Set ambient light
            float[] ambientLight = {0.2f, 0.2f, 0.2f, 1.0f};
            gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambientLight, 0);

            // Set diffuse light
            float[] diffuseLight = {0.8f, 0.8f, 0.8f, 1.0f};
            gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuseLight, 0);

            // Set specular light
            float[] specularLight = {1.0f, 1.0f, 1.0f, 1.0f};
            gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specularLight, 0);
        } else {
            gl.glDisable(GL2.GL_LIGHTING);
        }
    }
}
