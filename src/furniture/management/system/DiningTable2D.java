package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class DiningTable2D extends Furniture2D{
    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        drawDiningTable(gl);
    }

    private void drawDiningTable(GL2 gl) {
        // Draw main table
        gl.glColor3f(0.824f, 0.706f, 0.549f); //light brown
        GLUtil2D.drawRectangle(gl, 675, 350, 550, 300);
        GLUtil2D.drawText(gl, "-Dining Table top view-", 850, 500);
        GLUtil2D.drawText(gl, " 36 in wide x 29 in long", 860, 475);

        // Draw top chairs
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 675, 675, 100, 100);

        //2 //50 space :x
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 825, 675, 100, 100);

        //3
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 975, 675, 100, 100);

        //4
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 1125, 675, 100, 100);

        ////////////
        //bottom chairs
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 675, 225, 100, 100);

        //2 //50 space :x
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 825, 225, 100, 100);

        //3
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 975, 225, 100, 100);

        //4
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 1125, 225, 100, 100);
    }
}
