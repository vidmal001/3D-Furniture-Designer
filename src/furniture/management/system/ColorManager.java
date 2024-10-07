package furniture.management.system;

import com.jogamp.opengl.GL2;

import java.awt.*;

public class ColorManager {

    private final float[] floorColor = {0.898f, 0.729f, 0.451f}; // Initial floor color in RGB
    private final float[] backgroundColor = {0.98f, 0.918f, 0.694f};


    // Method to apply the floor color
    public void applyFloorColor(GL2 gl) {
        gl.glColor3fv(floorColor, 0);
    }

    // Method to change the floor color
    public void setFloorColor(Color newColor) {
        floorColor[0] = newColor.getRed() / 255.0f;
        floorColor[1] = newColor.getGreen() / 255.0f;
        floorColor[2] = newColor.getBlue() / 255.0f;
    }

    // Method to get the current floor color
    public Color getFloorColor() {
        return new Color(floorColor[0], floorColor[1], floorColor[2]);
    }



    // Method to apply the background color
    public void applyBackgroundColor(GL2 gl) {
        gl.glClearColor(backgroundColor[0], backgroundColor[1], backgroundColor[2], 1.0f);
    }

    // Method to change the background color
    public void setBackgroundColor(Color newColor) {
        backgroundColor[0] = newColor.getRed() / 255.0f;
        backgroundColor[1] = newColor.getGreen() / 255.0f;
        backgroundColor[2] = newColor.getBlue() / 255.0f;
    }

    // Method to get the current background color
    public Color getBackgroundColor() {
        return new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]);

    }

    public void resetFloorColor() {
        floorColor[0] = 0.898f;
        floorColor[1] = 0.729f;
        floorColor[2] = 0.451f;
    }

    // Method to reset the background color to default
    public void resetBackgroundColor() {
        backgroundColor[0] = 0.98f;
        backgroundColor[1] = 0.918f;
        backgroundColor[2] = 0.694f;
    }


}
