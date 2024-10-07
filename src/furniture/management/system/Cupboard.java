
package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Cupboard extends Furniture {

    public RotationManager rotationManager = new RotationManager();
    public ColorManager colorManager = new ColorManager();
    public LightingManager lightingManager = new LightingManager();

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();

        if (lightingManager != null) {
            lightingManager.applyLighting(gl); // Apply lighting settings
        }
        gl.glTranslatef(0.0f, -1.0f, -15.0f); // Adjust the translation to position the cupboard
        gl.glRotatef(rotationManager.getRotationAngleY(), 0.0f, 1.0f, 0.0f);
        drawCupboard(gl);
    }

    private void drawCupboard(GL2 gl) {

        drawCupboardBody(gl); // Draw the main body of the cupboard
        drawShelves(gl); // Draw shelves inside the cupboard
        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }

    private void drawCupboardBody(GL2 gl) {
        // Draw the main body of the cupboard
        float width = 4.0f;
        float height = 8.0f;
        float depth = 2.0f;

        // Draw back panel
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, -depth / 2.0f);
        GLUtil.drawCube(gl, width, height, 0.1f);
        gl.glPopMatrix();

        // Draw left side
        gl.glPushMatrix();
        gl.glTranslatef(-width / 2.0f, 0.0f, 0.0f);
        GLUtil.drawCube(gl, 0.1f, height, depth);
        gl.glPopMatrix();

        // Draw right side
        gl.glPushMatrix();
        gl.glTranslatef(width / 2.0f, 0.0f, 0.0f);
        GLUtil.drawCube(gl, 0.1f, height, depth);
        gl.glPopMatrix();

        // Draw bottom
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -height / 2.0f, 0.0f);
        GLUtil.drawCube(gl, width, 0.1f, depth);
        gl.glPopMatrix();
    }

    private void drawShelves(GL2 gl) {
        // Draw shelves inside the cupboard
        float width = 4.0f;
        float depth = -2.0f;
        float shelfThickness = 0.1f;
        float spaceBetweenShelves = 1.45f;

        float startY = -2.3f; // Starting y position for the first shelf
        for (int i = 0; i < 5; i++) {
            float shelfY = startY + i * (shelfThickness + spaceBetweenShelves);
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, shelfY, depth / 52.5f);
            GLUtil.drawCube(gl, width, shelfThickness, depth); // Draw each shelf
            gl.glPopMatrix();
        }
    }
}