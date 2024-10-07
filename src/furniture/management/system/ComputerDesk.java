package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class ComputerDesk extends Furniture {

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

        gl.glTranslatef(0.0f, -1.0f, -15.0f); // Adjust the translation to position the computer desk
        gl.glRotatef(rotationManager.getRotationAngleY(), 0.0f, 1.0f, 0.0f);
        drawComputerDesk(gl);
    }

    private void drawComputerDesk(GL2 gl) {

        drawTopSurface(gl); // Draw the flat top surface of the desk
        drawBase(gl); // Draw the base of the desk
        drawKeyboardHutch(gl); // Draw the hutch for keyboard
        drawAprons(gl); // Draw aprons connecting top surface to middle
        drawBackSupport(gl); // Draw back support
        drawLeftCabinet(gl); // Draw left side cabinet
        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }

    private void drawTopSurface(GL2 gl) {
        float width = 9.0f;
        float depth = 3.0f;
        float thickness = 0.5f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 2.5f, 0.35f);
        GLUtil.drawCube(gl, width, thickness, depth);
        gl.glPopMatrix();
    }

    private void drawBase(GL2 gl) {
        float width = 10.0f;
        float depth = 3.0f;
        float height = 0.5f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f,-2.5f,0.0f);
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawKeyboardHutch(GL2 gl) {
        float width = 9.0f;
        float depth = 2.5f;
        float height = 0.1f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 1.6f, 0.4f); // Adjust position
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawAprons(GL2 gl) {
        // Draw aprons connecting top surface to middle
        float width = 0.1f;
        float depth = 0.3f;
        float height = 0.7f;

        // Left apron
        gl.glPushMatrix();
        gl.glTranslatef(-4.45f, 2.0f, 1.5f); // Adjust position
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();

        // Right apron
        gl.glPushMatrix();
        gl.glTranslatef(4.45f, 2.0f, 1.5f); // Adjust position
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawBackSupport(GL2 gl) {
        // Draw back support
        float width = 9.0f;
        float depth = 0.3f;
        float height = 9.5f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -2.5f, -1.0f); // Adjust position
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawLeftCabinet(GL2 gl) {

        float height = 3.7f;
        float depth = 2.5f;

        // Draw left side
        gl.glPushMatrix();
        gl.glTranslatef(-4.45f, -0.3f, 0.4f);
        GLUtil.drawCube(gl, 0.1f, height, depth);
        gl.glPopMatrix();

        // Draw right side
        gl.glPushMatrix();
        gl.glTranslatef(-2.45f, -0.3f, 0.4f);
        GLUtil.drawCube(gl, 0.1f, height, depth);
        gl.glPopMatrix();

        float shelfThickness = 0.1f;
        float spaceBetweenShelves = 1.0f;
        float startY = -1.5f; // Starting y position for the first shelf
        for (int i = 0; i < 3; i++) {
            float shelfY = startY + i * (shelfThickness + spaceBetweenShelves);
            gl.glPushMatrix();
            gl.glTranslatef(-3.45f, shelfY, depth / 45.5f);
            GLUtil.drawCube(gl, 2.1f, shelfThickness, -1.3f); // Draw each shelf
            gl.glPopMatrix();
        }
    }
}
