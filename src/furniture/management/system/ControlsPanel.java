package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class ControlsPanel extends JPanel {

    public ControlsPanel(RotationManager rotationManager, ColorManager colorManager, LightingManager lightingManager) {

        Color startColor = new Color(143, 108, 74);
        Color endColor = new Color(107, 80, 54);

        // Create rounded buttons
        RoundedButton resetColorButton = new RoundedButton("Reset Color", startColor, endColor);
        RoundedButton floorColorButton = new RoundedButton("Floor Color", startColor, endColor);
        RoundedButton backgroundColorButton = new RoundedButton("Background Color", startColor, endColor);
        RoundedButton leftButton = new RoundedButton("Left", startColor, endColor);
        RoundedButton rightButton = new RoundedButton("Right", startColor, endColor);
        RoundedButton changeMaterialButton = new RoundedButton("Change Material", startColor, endColor);
        RoundedButton lightButton = new RoundedButton("Light", startColor, endColor);

        // Set width and height for all buttons
        int buttonWidth = 150;
        int buttonHeight = 30;
        Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);
        resetColorButton.setPreferredSize(buttonSize);
        floorColorButton.setPreferredSize(buttonSize);
        backgroundColorButton.setPreferredSize(buttonSize);
        leftButton.setPreferredSize(buttonSize);
        rightButton.setPreferredSize(buttonSize);
        changeMaterialButton.setPreferredSize(buttonSize);
        lightButton.setPreferredSize(buttonSize);

        // Add action listeners
        leftButton.addActionListener(e -> rotationManager.rotateLeft());
        rightButton.addActionListener(e -> rotationManager.rotateRight());

        // Add action listener for the change material button
        changeMaterialButton.addActionListener(e -> {
            GLUtil.Material selectedMaterial = (GLUtil.Material) JOptionPane.showInputDialog(null,
                    "Choose Material:",
                    "Material Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    GLUtil.Material.values(),
                    GLUtil.Material.values()[0]); // Default to the first material
            GLUtil.setCurrentColors(selectedMaterial);
        });

        // Add action listener for the floor color button
        floorColorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Choose Floor Color", colorManager.getFloorColor());
            if (newColor != null) {
                colorManager.setFloorColor(newColor);
            }
        });

        // Add action listener for the background color button
        backgroundColorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(null, "Choose Background Color", colorManager.getBackgroundColor());
            if (newColor != null) {
                colorManager.setBackgroundColor(newColor);
            }
        });

        // Add action listener to the light button
        lightButton.addActionListener(e -> {
            lightingManager.toggleLighting(); // Toggle lighting state
        });

        resetColorButton.addActionListener(e ->{
            colorManager.resetBackgroundColor();
            colorManager.resetFloorColor();
        });

        // Add buttons to the panel
        add(resetColorButton);
        add(Box.createHorizontalStrut(10));
        add(floorColorButton);
        add(Box.createHorizontalStrut(10));
        add(backgroundColorButton);
        add(Box.createHorizontalStrut(10));
        add(leftButton);
        add(Box.createHorizontalStrut(10));
        add(rightButton);
        add(Box.createHorizontalStrut(10));
        add(changeMaterialButton);
        add(Box.createHorizontalStrut(10));
        add(lightButton);


        add(Box.createVerticalStrut(30));
        Color backgroundColor = new Color(250,234,177); // Example: RGB values for red
        setBackground(backgroundColor);

    }
}
