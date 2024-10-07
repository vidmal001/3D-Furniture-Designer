package furniture.management.system;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class PantryCupboard extends Furniture {

    // Manager classes
    public RotationManager rotationManager = new RotationManager();
    public ColorManager colorManager = new ColorManager();
    public LightingManager lightingManager = new LightingManager();


    @Override
    public void display(GLAutoDrawable drawable) {
        super.display(drawable);
        final GL2 gl = drawable.getGL().getGL2();

        if (lightingManager != null) {
            lightingManager.applyLighting(gl); // Apply lighting settings
        }

        // Setup
        gl.glTranslatef(0.0f, -2.0f, -15.0f);
        gl.glRotatef(rotationManager.getRotationAngleY(), 0.0f, 1.0f, 0.0f);

        // Drawing components
        drawBaseCabinets(gl);
        drawCountertop(gl);
        drawWallCabinets(gl);
        drawOpenSpaceForOven(gl);

        // Floor and background
        colorManager.applyFloorColor(gl);
        GLUtil.drawFloor(gl);
        colorManager.applyBackgroundColor(gl);
    }

    private void drawBaseCabinets(GL2 gl) {
        // Cabinet dimensions
        float cabinetWidth = 9.5f;
        float cabinetHeight = 1.9f;
        float cabinetDepth = 2.0f;

        // Main Cabinet Color
        gl.glColor3f(0.76f, 0.69f, 0.57f);

        // Cabinet
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, 0.0f);
        GLUtil.drawCube(gl, cabinetWidth, cabinetHeight, cabinetDepth);
        gl.glPopMatrix();

        // Door dimensions
        float doorWidth = cabinetWidth / 4.0f; // Four doors
        float doorHeight = cabinetHeight;
        float doorDepth = 0.3f;
        float doorOffset = doorWidth / 2.0f;

        // Door Color
        gl.glColor3f(0.63f, 0.32f, 0.18f); // A darker shade for the doors

        // Left-most Door
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f * doorOffset, 0.0f, cabinetDepth / 2 + doorDepth / 2);
        GLUtil.drawCube(gl, doorWidth, doorHeight, 0.8f);
        gl.glPopMatrix();



        // Right-center Door
        gl.glPushMatrix();
        gl.glTranslatef(0.5f * doorOffset, 0.0f, cabinetDepth / 2 + doorDepth / 2);
        GLUtil.drawCube(gl, doorWidth, doorHeight, 0.8f);
        gl.glPopMatrix();

        // Right-most Door
        gl.glPushMatrix();
        gl.glTranslatef(1.5f * doorOffset, 0.0f, cabinetDepth / 2 + doorDepth / 2);
        GLUtil.drawCube(gl, doorWidth, doorHeight, 0.8f);
        gl.glPopMatrix();

        //
        gl.glColor3f(1.0f, 1.0f, 1.0f);


    }



    private void drawCountertop(GL2 gl) {
        // Draw the countertop
        // Dimensions should match the total width of the base cabinets and desired overhang
        float countertopWidth = 7.2f;
        float countertopDepth = 0.5f;
        float countertopHeight = 0.2f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 2.0f, 0.0f);
        GLUtil.drawCube(gl, countertopWidth, countertopHeight, countertopDepth);
        gl.glPopMatrix();
    }

    private void drawWallCabinets(GL2 gl) {
        // Wall cabinet parameters
        float wallCabinetWidth = 6.5f;
        float wallCabinetHeight = 2.0f;
        float wallCabinetDepth = 2.5f;
        float verticalSpacing = 0.5f;

        // Cabinet color
        gl.glColor3f(0.76f, 0.60f, 0.42f); // A wood color

        // Draw the wall cabinets
        gl.glPushMatrix();
        gl.glTranslatef(-1.75f, 2.0f + verticalSpacing, 0.0f); // Center the left cabinet above the base cabinet
        GLUtil.drawCube(gl, wallCabinetWidth, wallCabinetHeight, wallCabinetDepth);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(1.75f, 2.0f + verticalSpacing, 0.0f); // Center the right cabinet above the base cabinet
        GLUtil.drawCube(gl, wallCabinetWidth, wallCabinetHeight, wallCabinetDepth);
        gl.glPopMatrix();

        // Lines color
        gl.glColor3f(0.0f, 0.0f, 0.0f); // Black for the lines

        // Distance from the center to the edge of a cabinet
        float edgeOffset = wallCabinetWidth / 2;

        // Draw vertical lines for the separations
        float lineThickness = 0.09f;
        float lineDepth = 0.5f;

        // Calculate the positions for the separation lines
        float firstLinePosition = 0.0f;
        float secondLinePosition = 1.7f;
        float thirdLinePosition = 3.4f;
        float fourthLinePosition = edgeOffset - (wallCabinetWidth / 4);

        // Draw the separation lines

        // First vertical line
        gl.glPushMatrix();
        gl.glTranslatef(firstLinePosition, 2.0f + verticalSpacing, wallCabinetDepth / 2);
        GLUtil.drawCube(gl, lineThickness, wallCabinetHeight, 3.0f);
        gl.glPopMatrix();

        // Second vertical line
        gl.glPushMatrix();
        gl.glTranslatef(secondLinePosition, 2.0f + verticalSpacing, wallCabinetDepth / 2);
        GLUtil.drawCube(gl, lineThickness, wallCabinetHeight, 3.0f);
        gl.glPopMatrix();


        // Third vertical line
        gl.glPushMatrix();
        gl.glTranslatef(thirdLinePosition, 2.0f + verticalSpacing, wallCabinetDepth / 2);
        GLUtil.drawCube(gl, lineThickness, wallCabinetHeight, 3.0f);
        gl.glPopMatrix();



        // Reset color to white (or other default color) after drawing
        gl.glColor3f(1.0f, 1.0f, 1.0f);
    }







    private void drawOpenSpaceForOven(GL2 gl) {
        // Draw an open space for oven or microwave
        float spaceWidth = 1.0f;
        float spaceHeight = 1.5f;
        float spaceDepth = 0.6f;

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, 0.0f);
        gl.glColor3f(0.3f, 0.3f, 0.3f);
        GLUtil.drawCube(gl, spaceWidth, spaceHeight, spaceDepth);
        gl.glPopMatrix();
    }


}
