package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;


public class CoffeeTable extends Furniture{
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

        gl.glTranslatef(0.0f, -1.0f, -15.0f); // Adjust the translation to position the wardrobe
        gl.glRotatef(rotationManager.getRotationAngleY(), 0.0f, 1.0f, 0.0f);
        drawCoffeeTable(gl);
    }
    private void drawCoffeeTable(GL2 gl) {

        drawLeftLeg(gl);
        drawRightLeg(gl);
        drawTableTopOne(gl);
        drawfrontRight(gl);
        drawfrontLeft(gl);
        drawTableTopTwo(gl);
        drawTableTopThree(gl);
        drawTableTopFour(gl);

        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }
    //for the 1st cube just put a translatef and a width as you like

    //for the 2nd cube calculattion, first cube's width should be considered, if right then its (+),
    //if it;s on the left side, it is (-).
    // in the second cube,should have to only calculate the Translatef(x),
    // by getting the 1st cube's width(+(right) or -(left) do the calculation) , and translatef(x).

    //draw left leg-behind
    private void drawLeftLeg(GL2 gl) {
        float tableWidth = 0.2f;
        float tableHeight = 4.5f;
        float tableDepth = 0.15f;

        gl.glPushMatrix();
        gl.glTranslatef(-2.0f, 0.0f, 1.0f);
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }
    //draw right leg-behind
    private void drawRightLeg(GL2 gl) {
        float tableWidth = 0.2f;
        float tableHeight = 4.5f;
        float tableDepth = 0.15f;

        gl.glPushMatrix();
        gl.glTranslatef(1.2f, 0.0f, 1.0f);
        //
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    //////
    //draw front left leg
    private void drawfrontLeft(GL2 gl) {
        float tableWidth = 0.2f;
        float tableHeight = 4.5f;
        float tableDepth = 0.15f;

        gl.glPushMatrix();
        gl.glTranslatef(-2.0f, 0.0f, 3.0f);
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    //draw front right legg
    private void drawfrontRight(GL2 gl) {
        float tableWidth = 0.2f;
        float tableHeight = 4.5f;
        float tableDepth = 0.15f;

        gl.glPushMatrix();
        gl.glTranslatef(1.2f, 0.0f, 3.0f);
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }



    //////////////////////////////////////
    //one - from the left
    private void drawTableTopOne(GL2 gl) {
        float tableWidth = 1f;
        float tableHeight = 0.8f;
        float tableDepth = 3f; //2

        gl.glPushMatrix();
        gl.glTranslatef(-2f, 2f, 2.0f); //3
        //
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }
    //two
    private void drawTableTopTwo(GL2 gl) {
        float tableWidth = 1f;
        float tableHeight = 0.8f;
        float tableDepth = 3f;

        gl.glPushMatrix();
        gl.glTranslatef(-0.95f, 2f, 2f);
        //
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    //three
    private void drawTableTopThree(GL2 gl) {
        float tableWidth = 1f;
        float tableHeight = 0.8f;
        float tableDepth = 3f;

        gl.glPushMatrix();
        gl.glTranslatef(0.1f, 2.0f, 2f);
        //
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    //fourth
    private void drawTableTopFour(GL2 gl) {
        float tableWidth = 1f;
        float tableHeight = 0.8f;
        float tableDepth = 3f;

        gl.glPushMatrix();
        gl.glTranslatef(1.15f, 2.0f, 2f);
        //
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

}

