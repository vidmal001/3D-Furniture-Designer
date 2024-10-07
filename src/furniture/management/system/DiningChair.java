package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class DiningChair extends Furniture {

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

        gl.glTranslatef(0.0f, -1.0f, -15.0f); // Adjust the translation to position the chair
        gl.glRotatef(rotationManager.getRotationAngleY(), 0.0f, 1.0f, 0.0f);
        drawChair(gl);
    }

    private void drawChair(GL2 gl) {

        drawLegs(gl); // Draw the legs of the chair
        drawStretchers(gl); // Draw the stretchers of the chair
        drawAprons(gl); // Draw the aprons of the chair
        drawBack(gl); // Draw the back of the chair
        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }

    private void drawLegs(GL2 gl) {
        float legWidth = 0.3f;
        float legHeight = 3.0f;
        float legDepth = 0.3f;

        // Draw front left leg
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, -1.5f, -1.9f);
        GLUtil.drawCube(gl, legWidth, legHeight, legDepth);
        gl.glPopMatrix();

        // Draw front right leg
        gl.glPushMatrix();
        gl.glTranslatef(1.5f, -1.5f, -1.9f);
        GLUtil.drawCube(gl, legWidth, legHeight, legDepth);
        gl.glPopMatrix();

        // Draw back left leg
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, -1.5f, 1.0f);
        GLUtil.drawCube(gl, legWidth, legHeight, legDepth);
        gl.glPopMatrix();

        // Draw back right leg
        gl.glPushMatrix();
        gl.glTranslatef(1.5f, -1.5f, 1.0f);
        GLUtil.drawCube(gl, legWidth, legHeight, legDepth);
        gl.glPopMatrix();
    }

    private void drawStretchers(GL2 gl) {
        // Draw side stretchers
        float stretcherWidth = 3.0f;
        float stretcherHeight = 0.3f;
        float stretcherDepth = 0.3f;

        // Draw front stretcher
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -2.0f, -1.9f);
        GLUtil.drawCube(gl, stretcherWidth, stretcherHeight, stretcherDepth);
        gl.glPopMatrix();

        // Draw back stretcher
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -2.0f, 1.0f);
        GLUtil.drawCube(gl, stretcherWidth, stretcherHeight, stretcherDepth);
        gl.glPopMatrix();


        // Draw left side stretcher
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, -2.0f, -0.5f);
        GLUtil.drawCube(gl, stretcherDepth, stretcherHeight, 3.0f);
        gl.glPopMatrix();

        // Draw right side stretcher
        gl.glPushMatrix();
        gl.glTranslatef(1.8f - stretcherDepth, -2.0f, -0.5f);
        GLUtil.drawCube(gl, stretcherDepth, stretcherHeight, 3.0f);
        gl.glPopMatrix();

    }

    private void drawAprons(GL2 gl) {
        // Draw aprons to hold the seat
        float apronWidth = 3.0f;
        float apronHeight = 0.3f;
        float apronDepth = 0.3f;

        // Draw back apron
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.15f, -1.9f);
        GLUtil.drawCube(gl, apronWidth, apronHeight, apronDepth);
        gl.glPopMatrix();

        // Draw front apron
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.15f, 1.0f);
        GLUtil.drawCube(gl, apronWidth, apronHeight, apronDepth);


        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, -0.15f, -0.5f);
        GLUtil.drawCube(gl, apronDepth, apronHeight, 3.0f);
        gl.glPopMatrix();

        // Draw right side apron
        gl.glPushMatrix();
        gl.glTranslatef(1.8f - apronDepth, -0.15f, -0.5f);
        GLUtil.drawCube(gl, apronDepth, apronHeight, 3.0f);
        gl.glPopMatrix();
    }

    private void drawBack(GL2 gl) {
        // Draw the back of the chair
        float backWidth = 3.0f;
        float backHeight = 5.0f;
        float backDepth = 0.3f;

        // Draw right side top leg
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, 2.0f, -1.9f);
        GLUtil.drawCube(gl, 0.3f, backHeight, backDepth);
        gl.glPopMatrix();

        //left side top leg
        gl.glPushMatrix();
        gl.glTranslatef(1.5f, 2.0f, -1.9f);
        GLUtil.drawCube(gl, 0.3f, backHeight, backDepth);
        gl.glPopMatrix();

        // Draw back rail
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 1.5f, -1.9f);
        GLUtil.drawCube(gl, backWidth, 0.3f, backDepth);
        gl.glPopMatrix();

        // Draw top rail
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 4.0f, -1.9f);
        GLUtil.drawCube(gl, backWidth, 0.3f, backDepth);
        gl.glPopMatrix();

        // Draw splats
        float splatWidth = 0.3f;
        float splatHeight = 2.6f;
        float splatDepth = 0.1f;

        // Draw first splat
        gl.glPushMatrix();
        gl.glTranslatef(-0.9f, 2.8f, -1.9f);
        GLUtil.drawCube(gl, splatWidth, splatHeight, splatDepth);
        gl.glPopMatrix();

        // Draw second splat
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 2.8f, -1.9f);
        GLUtil.drawCube(gl, splatWidth, splatHeight, splatDepth);
        gl.glPopMatrix();

        // Draw third splat
        gl.glPushMatrix();
        gl.glTranslatef(0.9f, 2.8f, -1.9f);
        GLUtil.drawCube(gl, splatWidth, splatHeight, splatDepth);
        gl.glPopMatrix();
    }
}
