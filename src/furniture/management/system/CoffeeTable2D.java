package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class CoffeeTable2D extends Furniture2D{
    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();

        drawCoffeeTable(gl);
    }

    private void drawCoffeeTable(GL2 gl) {
        // Draw bottom square
        gl.glColor3f(0.824f, 0.706f, 0.549f); //light brown
        GLUtil2D.drawRectangle(gl, 750, 400, 325, 80);

        gl.glColor3f(0.824f, 0.706f, 0.549f); //light brown
        GLUtil2D.drawRectangle(gl, 750, 481, 325, 80);

        gl.glColor3f(0.824f, 0.706f, 0.549f); //light brown
        GLUtil2D.drawRectangle(gl, 750, 562, 325, 80);

        gl.glColor3f(0.824f, 0.706f, 0.549f); //light brown
        GLUtil2D.drawRectangle(gl, 750, 643, 325, 80);
        GLUtil2D.drawText(gl, " 16 in wide x 18 in long", 820, 750);
        GLUtil2D.drawText(gl, "-top view of Coffee Table-", 810, 800);

    }
}
