package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Bed extends Furniture {

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

        gl.glTranslatef(0.0f, -1.0f, -15.0f); // Adjust the translation to position the bed
        gl.glRotatef(rotationManager.getRotationAngleY(), 0.0f, 1.0f, 0.0f);
        drawBed(gl);
    }

    private void drawBed(GL2 gl) {

        drawHeadboard(gl);
        drawFootboard(gl);
        drawCleat(gl);
        drawAdditionalCleats(gl);
        drawTopRail(gl);
        drawBottomFrontRail(gl);
        drawFrontLegs(gl);
        drawSideDrawersLegs(gl);
        drawSideRails(gl);
        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }

    private void drawHeadboard(GL2 gl) {
        float width = 8.0f;
        float height = 4.0f;
        float depth = 0.5f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 2.0f, -5.0f);
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawFootboard(GL2 gl) {
        float width = 8.0f;
        float height = 2.0f;
        float depth = 0.5f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -1.0f, 5.0f);
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawCleat(GL2 gl) {
        float width = 7.5f;
        float height = 0.2f;
        float depth = 1.0f;


        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.5f, -4.0f);
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }


    private void drawAdditionalCleats(GL2 gl) {
        float cleatSpacing = 2.0f; // Adjust the spacing between cleats

        // Draw additional cleats at different positions
        for (int i = 1; i <= 4; i++) {
            gl.glPushMatrix();
            gl.glTranslatef(0.0f, 0.0f, i * cleatSpacing); // Adjust the translation along the z-axis
            drawCleat(gl);
            gl.glPopMatrix();
        }
    }



    private void drawTopRail(GL2 gl) {
        float width = 8.0f;
        float height = 0.5f;
        float depth = 0.5f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 3.75f, -5.0f);
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawBottomFrontRail(GL2 gl) {
        float width = 8.0f;
        float height = 0.5f;
        float depth = 0.5f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -2.25f, -5.0f);
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

    private void drawFrontLegs(GL2 gl) {
        // Draw front legs
        float width = 0.5f;
        float height = 2.0f;
        float depth = 0.5f;
        float spaceBetweenLegs = 7.0f;

        float startX = 3.5f; // Starting x position for the first leg
        for (int i = 0; i < 2; i++) {
            float legX = startX - i * spaceBetweenLegs;
            gl.glPushMatrix();
            gl.glTranslatef(legX, -1.0f, -5.0f);
            GLUtil.drawCube(gl, width, height, depth); // Draw each leg
            gl.glPopMatrix();
        }
    }

    private void drawSideDrawersLegs(GL2 gl) {
        // Draw side drawers legs
        float width = 0.5f;
        float height = 2.0f;
        float depth = 0.5f;
        float spaceBetweenLegs = 7.0f;

        float startX = 3.5f; // Starting x position for the first leg
        for (int i = 0; i < 2; i++) {
            float legX = startX - i * spaceBetweenLegs;
            gl.glPushMatrix();
            gl.glTranslatef(legX, -1.0f, 5.0f);
            GLUtil.drawCube(gl, width, height, depth); // Draw each leg
            gl.glPopMatrix();
        }
    }

    private void drawSideRails(GL2 gl) {
        float width = 0.5f;
        float height = 1.0f;
        float depth = 10.0f;

        // Left side rail
        gl.glPushMatrix();
        gl.glTranslatef(-3.5f, -1.0f, 0.0f); // Adjust the position of the left side rail
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();

        // Right side rail
        gl.glPushMatrix();
        gl.glTranslatef(3.5f, -1.0f, 0.0f); // Adjust the position of the right side rail
        GLUtil.drawCube(gl, width, height, depth);
        gl.glPopMatrix();
    }

}
