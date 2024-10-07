package furniture.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SavedPanelsPanel extends JPanel {

    private List<String> panelNames;
    private final Map<String, JPanel> panelMap;
    private final JButton deleteButton;
    private final JPanel gridPanel;

    public SavedPanelsPanel() {
        setLayout(new BorderLayout());

        // Create a panel for the button and add it to the top
        JPanel buttonPanel = new JPanel();
        deleteButton = new JButton("Delete All");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAll();
            }
        });
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Create a panel for showing other panels inside GridLayout
        gridPanel = new JPanel(new GridLayout(3, 3, 10, 10));
        add(gridPanel, BorderLayout.CENTER);

        panelMap = new HashMap<>();
        panelNames = readPanelNamesFromLocalFile();
        createPanelsFromNames(panelNames);

        Timer timer = new Timer(5000, e -> {
            List<String> updatedPanelNames = readPanelNamesFromLocalFile();
            if (!panelNames.equals(updatedPanelNames)) {
                panelNames = updatedPanelNames;
                createPanelsFromNames(panelNames);
            }
        });
        timer.start();
    }

    private void deleteAll() {
        panelMap.clear();
        clearFile();
        gridPanel.removeAll(); // Clear all panels from the gridPanel
        revalidate();
        repaint();
    }

    private void clearFile() {
        try (PrintWriter writer = new PrintWriter("saved_panels.txt")) {
            writer.print(""); // Clear the file content
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private List<String> readPanelNamesFromLocalFile() {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("saved_panels.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    private void createPanelsFromNames(List<String> names) {
        for (String name : names) {
            if (!panelMap.containsKey(name) && panelMap.size() < 9) {
                JPanel panel = createPanelByName(name);
                if (panel != null) {
                    panelMap.put(name, panel);
                    gridPanel.add(panel);
                }
            }
        }
        revalidate();
        repaint();
    }

    private JPanel createPanelByName(String name) {
        switch (name) {
            case "CupboardPanel":
                return new CupboardPanel(false);
            // Add cases for other panel types as needed
            case "DiningChairDisplay":
                return new DiningChairDisplay(false);
            case "PantryCupboardDisplay":
                return new PantryCupboardDisplay(false);
            case "TvStandDisplay":
                return new TvStandDisplay(false);
            case "WardrobeDisplay":
                return new WardrobeDisplay(false);
            case "DiningTableDisplayPanel":
                return new DiningTableDisplayPanel(false);
            case "ComputerDeskDisplayPanel":
                return new ComputerDeskDisplayPanel(false);
            case "CoffeeTableDisplay":
                return new CoffeeTableDisplay(false);
            case "BedDisplay":
                return new BedDisplay(false);
            default:
                return null;
        }
    }
}
