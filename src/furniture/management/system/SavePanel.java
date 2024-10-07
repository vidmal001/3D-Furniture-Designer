package furniture.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavePanel extends JPanel {
    private List<String> savedPanels;

    public SavePanel(String panelName) {
        savedPanels = new ArrayList<>();

        Color startColor = new Color(143, 108, 74);
        Color endColor = new Color(107, 80, 54);

        RoundedButton saveButton = new RoundedButton("Save Design", startColor, endColor);

        int buttonWidth = 150;
        int buttonHeight = 30;
        Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);
        saveButton.setPreferredSize(buttonSize);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the panel name is already in the list
                if (!savedPanels.contains(panelName)) {
                    // Save the relevant panel name
                    savedPanels.add(panelName);

                    // Save the panel name to a local storage
                    savePanelNamesToLocalFile(savedPanels);
                    JOptionPane.showMessageDialog(null, "Design saved successfully!");
                } else {

                    JOptionPane.showMessageDialog(null, "Design already saved!");
                }
            }
        });

        add(saveButton);
         // Adding vertical space of 10 pixels
        add(Box.createVerticalStrut(50));

        Color backgroundColor = new Color(250,234,177);
        setBackground(backgroundColor);
    }

    // Method to save panel names to a local file
    private void savePanelNamesToLocalFile(List<String> panelNames) {
        try {
            FileWriter writer = new FileWriter("saved_panels.txt", true); // Append mode enabled
            for (String panelName : panelNames) {
                writer.write(panelName + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
