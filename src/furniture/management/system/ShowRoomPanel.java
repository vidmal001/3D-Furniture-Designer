package furniture.management.system;
import javax.swing.*;
import java.awt.*;
class ShowRoomPanel extends JPanel {

    ShowRoomPanel() {
        setBackground(new Color(224, 195, 195));
        setLayout(new GridBagLayout());

        // Add panels to specific locations using GridBagConstraints
        addPanel(new CupboardPanel(false), 0, 0);
        addPanel(new DiningChairDisplay(false), 1, 0);
        addPanel(new DiningTableDisplayPanel(false), 2, 0);
        addPanel(new ComputerDeskDisplayPanel(false), 0, 1);
        addPanel(new BedDisplay(false), 1, 1);
        addPanel(new WardrobeDisplay(false), 2, 1);
        addPanel(new CoffeeTableDisplay(false), 0, 2);
        addPanel(new TvStandDisplay(false), 1, 2);
        addPanel(new PantryCupboardDisplay(false), 2, 2);
    }

    // Helper method to add a panel at a specific location
    private void addPanel(JPanel panel, int gridx, int gridy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        gbc.weightx = 1.0; // Make the panel resize horizontally
        gbc.weighty = 1.0; // Make the panel resize vertically
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding

        add(panel, gbc);
    }
}