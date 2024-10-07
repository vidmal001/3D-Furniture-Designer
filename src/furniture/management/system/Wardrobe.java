package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Wardrobe extends Furniture {
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
        drawWardrobe(gl);
    }

    private void drawWardrobe(GL2 gl) {

        drawLeftRight(gl);
        drawLeftLeft(gl);
        drawRightLeft(gl);
        drawRightRight(gl);
        drawMiddledrawer(gl);
        drawTopSupport(gl);
        drawTopdrawer(gl);

        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }
    //for the 1st cube just put a translatef and a width as you like

    //for the 2nd cube calculattion, first cube's width should be considered, if right then its (+),
    //if it;s on the left side, it is (-).
    // in the second cube,should have to only calculate the Translatef(x),
    // by getting the 1st cube's width(+(right) or -(left) do the calculation) , and translatef(x).

    //left wardrobe
    //right door
    private void drawLeftRight(GL2 gl) {
        float tableWidth = 1.5f;
        float tableHeight = 6.0f;
        float tableDepth = 1.0f;

        gl.glPushMatrix();
        gl.glTranslatef(-3.0f, -0.0f, 0.0f);
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    //left door
    private void drawLeftLeft(GL2 gl) {
        float tableWidth = 1.5f;
        float tableHeight = 6.0f;
        float tableDepth = 1.0f;

        gl.glPushMatrix();
        gl.glTranslatef(-4.51f, -0.0f, 0.0f);
        //
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    //////////////
    //right wardrobe
    //left side
    //left door
    private void drawRightLeft(GL2 gl) {
        float tableWidth = 1.5f;
        float tableHeight = 6.0f;
        float tableDepth = 1.0f;

        gl.glPushMatrix();
        gl.glTranslatef(1.5f, -0.0f, 0.0f);
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }
    private void drawRightRight(GL2 gl) {
        float tableWidth = 1.5f;
        float tableHeight = 6.0f;
        float tableDepth = 1.0f;

        gl.glPushMatrix();
        gl.glTranslatef(3.01f, -0.0f, 0.0f);
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    ///////////
    //middle drawer
    //alocated right next to the left side wordrobe right side
    private void drawMiddledrawer(GL2 gl) {
        float tableWidth = 2.96f; //+4.5
        float tableHeight = 1.0f;
        float tableDepth = 1.0f;

        gl.glPushMatrix();
        gl.glTranslatef(-0.75f, -2.0f, 0.0f); //-1.5
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    //top Support
    private void drawTopSupport(GL2 gl) {
        float tableWidth = 2.99f; //+4.5
        float tableHeight = 0.3f;
        float tableDepth = 1.0f;

        gl.glPushMatrix();
        gl.glTranslatef(-0.75f, 2.85f, 0.0f); //x: -1.5, y:2.5
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }

    private void drawTopdrawer(GL2 gl) {
        float tableWidth = 2.96f; //+4.5
        float tableHeight = 1.0f;
        float tableDepth = 1.0f;

        gl.glPushMatrix();
        gl.glTranslatef(-0.75f, -0.8f, 0.0f); //x: -1.5
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }
}
