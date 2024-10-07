package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class GLUtil2D {

    public static void drawRectangle(GL2 gl, float x, float y, float width, float height) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(x, y);
        gl.glVertex2f(x + width, y);
        gl.glVertex2f(x + width, y + height);
        gl.glVertex2f(x, y + height);
        gl.glEnd();
    }
    public static void drawText(GL2 gl, String text, float x, float y) {
        float[] color = new float[]{0.0f, 0.0f, 0.0f};
        gl.glColor3fv(color, 0);
        gl.glRasterPos2f(x, y);
        GLUT glut = new GLUT();
        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, text);
    }
}
