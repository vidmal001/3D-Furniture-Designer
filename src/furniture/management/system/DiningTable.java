package furniture.management.system;
import com.jogamp.opengl.*;
public class DiningTable extends Furniture {

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

        gl.glTranslatef(0.0f, -1.0f, -15.0f); // Adjust the translation to position the table
        gl.glRotatef(rotationManager.getRotationAngleY(), 0.0f, 1.0f, 0.0f);
        drawTable(gl);
    }

    private void drawTable(GL2 gl) {

        drawLegs(gl);
        drawTableTop(gl);
        drawStretchers(gl);
        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }

    private void drawStretchers(GL2 gl) {
        float stretcherWidth = 0.1f;
        float stretcherHeight = 0.2f;
        float stretcherDepth = 1.0f;

        // Connect the front legs
        gl.glPushMatrix();
        gl.glTranslatef(-2.0f, -2.0f, 0.4f);
        GLUtil.drawCube(gl, stretcherWidth, stretcherHeight, stretcherDepth);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(2.0f, -2.0f, 0.4f);
        GLUtil.drawCube(gl, stretcherWidth, stretcherHeight, stretcherDepth);
        gl.glPopMatrix();

        // Connect the back legs
        gl.glPushMatrix();
        gl.glTranslatef(-2.0f, -2.0f, -0.4f);
        GLUtil.drawCube(gl, stretcherWidth, stretcherHeight, stretcherDepth);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(2.0f, -2.0f, -0.4f);
        GLUtil.drawCube(gl, stretcherWidth, stretcherHeight, stretcherDepth);
        gl.glPopMatrix();
    }

    private void drawLegs(GL2 gl) {
        float legWidth = 0.2f;
        float legHeight = 3.5f;

        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                gl.glPushMatrix();
                gl.glTranslatef(i * 2.00f, -2.0f, j * 0.8f);
                GLUtil.drawCube(gl, legWidth, legHeight, legWidth);
                gl.glPopMatrix();
            }
        }
    }

    private void drawTableTop(GL2 gl) {
        float tableWidth = 6.0f;
        float tableHeight = 0.5f;
        float tableDepth = 3.0f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.5f, 0.0f);
        GLUtil.drawCube(gl, tableWidth, tableHeight, tableDepth);
        gl.glPopMatrix();
    }
}
