package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class ComputerDesk2D extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        drawComputerDesk2D(gl);
    }

    private void drawComputerDesk2D(GL2 gl) {
        GLUtil2D.drawText(gl, "Computer Desk Front View ( h:75cm * w:120cm * d:60cm ) ", 715, 220);

        // Draw desk top
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        GLUtil2D.drawRectangle(gl, 600, 550, 700, 40); // Thin rectangle as desk top

        // Draw two legs
        gl.glColor3f(0.58f, 0.408f, 0.0f);
        GLUtil2D.drawRectangle(gl, 700, 250, 50, 300); // Left leg
        GLUtil2D.drawRectangle(gl, 1150, 250, 50, 300); // Right leg

        // Draw three rectangles as cabinets
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        GLUtil2D.drawRectangle(gl, 750, 420, 100, 20);
        GLUtil2D.drawRectangle(gl, 750, 380, 100, 20);
        GLUtil2D.drawRectangle(gl, 750, 340, 100, 20);
        GLUtil2D.drawRectangle(gl, 750, 300, 100, 20);
        GLUtil2D.drawRectangle(gl, 750, 260, 100, 20);
    }
}
