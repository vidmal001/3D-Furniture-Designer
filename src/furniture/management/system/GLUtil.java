package furniture.management.system;
import com.jogamp.opengl.GL2;

public class GLUtil {

    // Define color sets for different materials
    private static final float[][] WOOD_COLORS = {
            {0.6f, 0.345f, 0.0f}, // Brown
            {0.58f, 0.32f, 0.09f}, // Brown
            {0.77f, 0.6f, 0.31f},  // Tan
            {0.77f, 0.6f, 0.31f},  // Tan
            {0.98f, 0.58f, 0.23f}, // Orange
            {0.98f, 0.58f, 0.23f}  // Orange
    };

    private static final float[][] METAL_COLORS = {
            {0.42f, 0.42f, 0.42f}, // Dark grey
            {0.42f, 0.42f, 0.42f}, // Light grey
            {0.757f, 0.839f, 0.835f},     // Dark grey
            {0.757f, 0.839f, 0.835f},     // Dark grey
            {0.961f, 0.961f, 0.961f},     // Grey
            {0.961f, 0.961f, 0.961f}      // Grey
    };

    private static final float[][] PLASTIC_COLORS = {
            {0.769f, 0.059f, 0.675f},     // Blue
            {0.769f, 0.059f, 0.675f},     // Blue
            {0.949f, 0.804f, 0.929f},     // Magenta
            {0.949f, 0.804f, 0.929f},     // Magenta
            {0.941f, 0.893f, 0.933f},     // Cyan
            {0.941f, 0.893f, 0.933f}      // Cyan
    };

    // Default color set
    private static float[][] currentColors = WOOD_COLORS;

    // Method to set the current color set
    public static void setCurrentColors(Material material) {
        switch (material) {
            case WOOD:
                currentColors = WOOD_COLORS;
                break;
            case METAL:
                currentColors = METAL_COLORS;
                break;
            case PLASTIC:
                currentColors = PLASTIC_COLORS;
                break;
        }
    }

    public static void drawCube(GL2 gl, float width, float height, float depth) {
        float halfWidth = width / 2.0f;
        float halfHeight = height / 2.0f;
        float halfDepth = depth / 2.0f;

        for (int i = 0; i < 6; i++) {
            gl.glBegin(GL2.GL_QUADS);
            gl.glColor3fv(currentColors[i], 0);
            switch (i) {
                case 0: // Front face
                    gl.glVertex3f(-halfWidth, halfHeight, halfDepth);
                    gl.glVertex3f(-halfWidth, -halfHeight, halfDepth);
                    gl.glVertex3f(halfWidth, -halfHeight, halfDepth);
                    gl.glVertex3f(halfWidth, halfHeight, halfDepth);
                    break;
                case 1: // Back face
                    gl.glVertex3f(-halfWidth, halfHeight, -halfDepth);
                    gl.glVertex3f(-halfWidth, -halfHeight, -halfDepth);
                    gl.glVertex3f(halfWidth, -halfHeight, -halfDepth);
                    gl.glVertex3f(halfWidth, halfHeight, -halfDepth);
                    break;
                case 2: // Left face
                    gl.glVertex3f(-halfWidth, halfHeight, halfDepth);
                    gl.glVertex3f(-halfWidth, -halfHeight, halfDepth);
                    gl.glVertex3f(-halfWidth, -halfHeight, -halfDepth);
                    gl.glVertex3f(-halfWidth, halfHeight, -halfDepth);
                    break;
                case 3: // Right face
                    gl.glVertex3f(halfWidth, halfHeight, halfDepth);
                    gl.glVertex3f(halfWidth, -halfHeight, halfDepth);
                    gl.glVertex3f(halfWidth, -halfHeight, -halfDepth);
                    gl.glVertex3f(halfWidth, halfHeight, -halfDepth);
                    break;
                case 4: // Top face
                    gl.glVertex3f(-halfWidth, halfHeight, halfDepth);
                    gl.glVertex3f(-halfWidth, halfHeight, -halfDepth);
                    gl.glVertex3f(halfWidth, halfHeight, -halfDepth);
                    gl.glVertex3f(halfWidth, halfHeight, halfDepth);
                    break;
                case 5: // Bottom face
                    gl.glVertex3f(-halfWidth, -halfHeight, halfDepth);
                    gl.glVertex3f(-halfWidth, -halfHeight, -halfDepth);
                    gl.glVertex3f(halfWidth, -halfHeight, -halfDepth);
                    gl.glVertex3f(halfWidth, -halfHeight, halfDepth);
                    break;
            }
            gl.glEnd();
        }
    }

    public static void drawFloor(GL2 gl) {
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3f(-10.0f, -2.5f, -10.0f);
        gl.glVertex3f(-10.0f, -2.5f, 10.0f);
        gl.glVertex3f(10.0f, -2.5f, 10.0f);
        gl.glVertex3f(10.0f, -2.5f, -10.0f);
        gl.glEnd();
    }

    // Enum to represent different materials
    public enum Material {
        WOOD,
        METAL,
        PLASTIC

    }
}