package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Bed2D extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        drawBed(gl);
    }

    private void drawBed(GL2 gl) {
        // Draw main bed
        gl.glColor3f(0.788f, 0.914f, 0.941f); //light blue
        GLUtil2D.drawRectangle(gl, 750, 105, 500, 770);
        GLUtil2D.drawText(gl, "Bed", 975, 400);
        GLUtil2D.drawText(gl, "Full/Double Bed", 935, 350);
        GLUtil2D.drawText(gl, "54 inches wide x 75 inches long (137 cm x 190.5 cm)", 775, 300);

        // Draw left pillow
        gl.glColor3f(1.0f, 0.988f, 0.0f);
        GLUtil2D.drawRectangle(gl, 785, 700, 200, 140);
        GLUtil2D.drawText(gl, "left pillow", 850, 765);

        // Draw right pillow
        gl.glColor3f(1.0f, 0.988f, 0.0f);
        GLUtil2D.drawRectangle(gl, 1015, 700, 200, 140);
        GLUtil2D.drawText(gl, "right pillow", 1065, 765);


        // Draw left side table
        gl.glColor3f(0.91f, 0.729f, 0.867f);
        GLUtil2D.drawRectangle(gl, 440, 600, 250, 250);
        GLUtil2D.drawText(gl, "left side table", 515,   725);
        //draw right side table
        gl.glColor3f(0.91f, 0.729f, 0.867f);
        GLUtil2D.drawRectangle(gl, 1310, 590, 250, 250);
        GLUtil2D.drawText(gl, "right side table", 1380, 720);
    }
}
