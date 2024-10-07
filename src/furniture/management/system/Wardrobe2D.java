package furniture.management.system;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GL2;
public class Wardrobe2D extends Furniture2D{
    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();
        drawWardrobe(gl);
    }

    private void drawWardrobe(GL2 gl) {
        // Draw left wardrobe
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 600, 105, 300, 600);
//        GLUtil2D.drawText(gl, " 31.5 in wide x 70.86 in long", 625, 500);

        // Draw left wardrobe
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 1250, 105, 300, 600);
//        GLUtil2D.drawText(gl, " 31.5 in wide x 70.86 in long", 1300, 500);

        ///////////
        // Draw bottom drawer wardrobe
        gl.glColor3f(0.824f, 0.706f, 0.549f); //light brown
        GLUtil2D.drawRectangle(gl, 900, 105, 350, 150);

//        // Draw middle drawer wardrobe
        gl.glColor3f(0.824f, 0.706f, 0.549f); //light brown
        GLUtil2D.drawRectangle(gl, 900, 350, 350, 150);

//        // Draw top support wardrobe
        gl.glColor3f(0.545f, 0.271f, 0.075f); //brown
        GLUtil2D.drawRectangle(gl, 900, 685, 350, 20);
        GLUtil2D.drawText(gl, "-Top view of Wardrobe ( h:183cm * w:75cm * d:65cm )-", 845, 725);

    }
}
