package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class TvStand2D extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();

        // Get the viewport size
        int[] viewport = new int[4];
        gl.glGetIntegerv(GL2.GL_VIEWPORT, viewport, 0);
        int width = viewport[2];
        int height = viewport[3];

        drawTvStand(gl, width, height);
    }

    private void drawTvStand(GL2 gl, int viewportWidth, int viewportHeight) {
        // Calculate the center of the viewport
        int centerX = viewportWidth / 2;
        int centerY = viewportHeight / 4; // Positioning towards the lower half vertically

        // Main TV stand dimensions and position
        int tvStandWidth = 800;
        int tvStandHeight = 100;
        int tvStandX = centerX - (tvStandWidth / 2); // Centering horizontally
        int tvStandY = centerY - (tvStandHeight / 2);

        // Draw the main TV stand body
        gl.glColor3f(0.55f, 0.27f, 0.07f); // Dark wood color
        GLUtil2D.drawRectangle(gl, tvStandX, tvStandY, tvStandWidth, tvStandHeight);


        int tvWidth = 700;
        int tvHeight = 400;
        int tvX = centerX - (tvWidth / 2); // Centering horizontally
        int tvY = tvStandY + tvStandHeight + 10; // Positioning just above the TV stand
        gl.glColor3f(0.1f, 0.1f, 0.1f); // Almost black for the TV
        GLUtil2D.drawRectangle(gl, tvX, tvY, tvWidth, tvHeight);

        // Draw compartments within the TV stand
        int compartmentWidth = 160;
        int compartmentHeight = 90;

        //  compartment positions relative to the TV stand
        gl.glColor3f(0.72f, 0.45f, 0.20f); // Lighter wood color
        GLUtil2D.drawRectangle(gl, tvStandX + 20, tvStandY + 10, compartmentWidth, compartmentHeight); // First compartment
        GLUtil2D.drawRectangle(gl, tvStandX + tvStandWidth - compartmentWidth - 20, tvStandY + 10, compartmentWidth, compartmentHeight); // Second compartment

        GLUtil2D.drawText(gl, " TV Stand Front View ( Large TVs: 55-75 inches diagonal ) ", 715, 130);



    }
}
