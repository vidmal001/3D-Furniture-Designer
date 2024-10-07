package furniture.management.system;
import com.jogamp.opengl.*;


public abstract class Furniture implements GLEventListener {

    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl = drawable.getGL().getGL2();
        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        float fovy = 45.0f;
        float aspect = h;
        float zNear = 1.0f;
        float zFar = 20.0f;

        gl.glFrustum(-aspect * Math.tan(Math.toRadians(fovy) / 2.0),
                aspect * Math.tan(Math.toRadians(fovy) / 2.0),
                -Math.tan(Math.toRadians(fovy) / 2.0),
                Math.tan(Math.toRadians(fovy) / 2.0),
                zNear, zFar);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glShadeModel(GL2.GL_FLAT);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL2.GL_LIGHTING);
        gl.glEnable(GL2.GL_LIGHT0);
        gl.glEnable(GL2.GL_COLOR_MATERIAL);
    }

    public void dispose(GLAutoDrawable drawable) {
    }

}
