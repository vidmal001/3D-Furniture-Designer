package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class TvStand extends Furniture {

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
        drawTvStand(gl);
    }

    private void drawTvStand(GL2 gl) {

        //calling the functions
        drawBase(gl);
        drawColumns(gl);
        drawSpeakerSupports(gl);
        drawShelves(gl);
        drawTopShelf(gl);

        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }



    private void drawBase(GL2 gl) {

        float baseWidth = 6.0f; // The overall width of the TV stand base
        float baseDepth = 1.5f; // The depth of the TV stand base
        float baseHeight = 0.3f; // The thickness of the TV stand base

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -2.5f, 0.0f); // Adjusting v1 can make the paper thick...
        GLUtil.drawCube(gl, 8.5f, baseHeight, baseDepth);
        gl.glPopMatrix();
    }



    private void drawColumns(GL2 gl) {

        float columnWidth = 0.3f; // Thickness of the columns
        float columnHeight = 5.5f; // Height (adjusted as per your code)
        float columnDepth = 0.6f; // Depth of the columns
        float gapIncrease = 1.5f; // Amount by which to increase the gap between the columns

        // Front-left column - move it further to the left
        gl.glPushMatrix();
        gl.glTranslatef(-2.0f - gapIncrease, 0.0f, 0.0f);
        GLUtil.drawCube(gl, columnWidth, columnHeight, columnDepth);
        gl.glPopMatrix();

        // Front-right column - move it further to the right
        gl.glPushMatrix();
        gl.glTranslatef(2.0f + gapIncrease, 0.0f, 0.0f);
        GLUtil.drawCube(gl, columnWidth, columnHeight, columnDepth);
        gl.glPopMatrix();

    }





    private void drawSpeakerSupports(GL2 gl) {
        float speakerSupportWidth = 0.6f; // Width of the speaker supports
        float speakerSupportHeight = 3.0f; // Height of the speaker supports
        float speakerSupportDepth = 0.5f; // Depth of the speaker supports

        // Left speaker support - move further left by decreasing the X value
        gl.glPushMatrix();
        gl.glTranslatef(-3.5f, 0.5f, 0.0f); // Changed from -2.0f to -2.5f
        GLUtil.drawCube(gl, speakerSupportWidth, speakerSupportHeight, speakerSupportDepth);
        gl.glPopMatrix();

        // Right speaker support - move further right by increasing the X value
        gl.glPushMatrix();
        gl.glTranslatef(3.5f, 0.5f, 0.0f); // Changed from 2.0f to 2.5f
        GLUtil.drawCube(gl, speakerSupportWidth, speakerSupportHeight, speakerSupportDepth);
        gl.glPopMatrix();
    }


    private void drawShelves(GL2 gl) {
        float shelfWidth = 7.0f; // The width of the shelves
        float shelfThickness = 0.2f; // Thickness of the shelves
        float shelfDepth = 1.7f; // Depth of the shelves from front to back
        float bottomShelfYPosition = -1.8f; // Y position of the bottom shelf
        float shelfDistance = 0.6f; // Distance between the shelves

        // Bottom shelf
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, bottomShelfYPosition, 0.0f);
        GLUtil.drawCube(gl, shelfWidth, shelfThickness, shelfDepth);
        gl.glPopMatrix();

        // Second shelf - placed shelfDistance above the bottom shelf
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, bottomShelfYPosition + shelfDistance, 0.0f);
        GLUtil.drawCube(gl, shelfWidth, shelfThickness, shelfDepth);
        gl.glPopMatrix();

    }






    private void drawTopShelf(GL2 gl) {
        float topShelfWidth = 6.9f;
        float topShelfDepth = 0.5f;
        float topShelfHeight = 0.2f;
        float topShelfElevation = 2.8f;

        // Translate to the correct height and draw the top shelf
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, topShelfElevation, 0.0f);
        GLUtil.drawCube(gl, topShelfWidth, topShelfHeight, topShelfDepth);
        gl.glPopMatrix();
    }


}
