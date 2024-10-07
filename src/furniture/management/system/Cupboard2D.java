package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Cupboard2D extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        drawCupboard2D(gl);


    }

    private void drawCupboard2D(GL2 gl) {
        GLUtil2D.drawText(gl, "Standard Size Cupboard ( h:183cm * w:91cm * d:24cm ) Front View ", 735,   75);
        gl.glColor3f(0.77f, 0.6f, 0.31f);
        GLUtil2D.drawRectangle(gl, 750, 105, 500, 700);
        gl.glColor3f(0.58f, 0.408f, 0.0f);
        int numShelves = 5; // Number of shelves
        int shelfHeight = 700 / (numShelves + 1); // Height of each shelf
        for (int i = 0; i < numShelves; i++) {
            int shelfY = 105 + (i + 1) * shelfHeight;
            GLUtil2D.drawRectangle(gl, 750, shelfY, 500, 10); // Draw shelf
        }
    }
}
