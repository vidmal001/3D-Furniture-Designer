package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class PantryCupboard2D extends Furniture2D {

    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();

        drawPantryCupboard(gl, drawable.getSurfaceWidth(), drawable.getSurfaceHeight());
    }

    private void drawPantryCupboard(GL2 gl, int viewportWidth, int viewportHeight) {
        // Calculate the center of the viewport
        int centerX = viewportWidth / 2;
        int centerY = viewportHeight / 2;

        // Define the main body of the pantry cupboard
        int cupboardWidth = 700;
        int cupboardHeight = 100;
        int cupboardX = centerX - (cupboardWidth / 2);
        int cupboardY = centerY - (cupboardHeight / 2) - 50;

        // Draw the main body of the pantry cupboard
        gl.glColor3f(0.65f, 0.50f, 0.39f); // A wood color

        GLUtil2D.drawRectangle(gl, cupboardX, cupboardY, cupboardWidth, cupboardHeight);

        // Draw the compartments or shelves on the pantry cupboard
        int shelfWidth = 100;
        int shelfHeight = 50;
        int shelfX = cupboardX + 370;
        int shelfY = cupboardY + cupboardHeight + 10;


        gl.glColor3f(0.59f, 0.41f, 0.31f);

        // Draw three compartments or shelves
        for (int i = 0; i < 3; i++) {
            GLUtil2D.drawRectangle(gl, shelfX, shelfY, shelfWidth, shelfHeight);
            shelfX += shelfWidth + 10; // Space between shelves
        }

        // Draw the base in front of the pantry cupboard
        int baseWidth = 700;
        int baseHeight = 80;
        int baseX = centerX - (baseWidth / 2);
        int baseY = cupboardY - 100; // In front of the cupboard


        gl.glColor3f(0.72f, 0.54f, 0.04f);
        GLUtil2D.drawRectangle(gl, baseX, baseY, baseWidth, baseHeight);
        GLUtil2D.drawText(gl, "Pantry Cupboard Front View ( h:180cm * w:60cm * d:60cm ) ", 715, 220);


    }
}
