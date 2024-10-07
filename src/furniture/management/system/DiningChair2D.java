package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class DiningChair2D extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        drawDiningChair2D(gl);
    }

    private void drawDiningChair2D(GL2 gl) {
        GLUtil2D.drawText(gl, "Standard Dining Chair ( h:90cm * w:50cm * d:50cm ) Side View ", 705,   140);
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        // Draw seat
        GLUtil2D.drawRectangle(gl, 750, 400, 350, 20);
        // Draw backrest
        GLUtil2D.drawRectangle(gl, 750, 190, 20, 650);
        GLUtil2D.drawRectangle(gl, 1100, 190, 20, 230);
        GLUtil2D.drawRectangle(gl, 750, 220, 350, 20);

    }
}
