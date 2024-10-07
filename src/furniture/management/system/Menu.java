package furniture.management.system;

import javax.swing.*;
import java.awt.*;

public class Menu {
    JMenuBar menuBar;
    JMenu menu, userMenu;
    JMenuItem i1, i2, i3, i4, i5, i6, i7,i8,i9,i10,i15;
    CardLayout cardLayout;


    Menu(String username) {
        JFrame f = new JFrame("Arpico Furniture Management System");
        menuBar = new JMenuBar();

        menuBar.setBackground(new Color(204, 213, 174));
        menuBar.setPreferredSize(new Dimension(400, 55));
        menu = new JMenu();

        ImageIcon menuIcon = createImageIcon("icons/Menu.png", "Menu Icon");
        menuIcon = new ImageIcon(menuIcon.getImage().getScaledInstance(-1, 30, Image.SCALE_SMOOTH));
        menu.setIcon(menuIcon);

        i1 = new JMenuItem("Dashboard");
        i2 = new JMenuItem("Dining Chair");
        i3 = new JMenuItem("Dining Table");
        i4 = new JMenuItem("Computer Desk");
        i5 = new JMenuItem("Bed");
        i6 = new JMenuItem("Cupboard");
        i7 = new JMenuItem("TvStand");
        i8 =new JMenuItem("PantryCupboard");
        i9 = new JMenuItem("Wardrobe");
        i10 = new JMenuItem("Coffee Table");
        i15 = new JMenuItem("saved designs");




        i1.addActionListener(e -> cardLayout.show(f.getContentPane(), "dashboardPanel"));
        i2.addActionListener(e -> cardLayout.show(f.getContentPane(), "DiningChairStartUpPanel"));
        i3.addActionListener(e -> cardLayout.show(f.getContentPane(), "DiningTableStartUpPanel"));
        i4.addActionListener(e -> cardLayout.show(f.getContentPane(), "ComputerDeskStartUpPanel"));
        i5.addActionListener(e -> cardLayout.show(f.getContentPane(), "BedStartUpPanel"));
        i6.addActionListener(e -> cardLayout.show(f.getContentPane(), "CupboardStartUpPanel"));
        i7.addActionListener(e -> cardLayout.show(f.getContentPane(), "TvStandStartUpPanel"));
        i8.addActionListener(e -> cardLayout.show(f.getContentPane(), "PantryCupboardStartUpPanel"));

        i9.addActionListener(e -> cardLayout.show(f.getContentPane(), "WardrobeStartUpPanel"));
        i10.addActionListener(e -> cardLayout.show(f.getContentPane(), "CoffeeTableStartUpPanel"));
        i15.addActionListener(e -> cardLayout.show(f.getContentPane(), "savedDesignPanel"));


        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
        menu.add(i5);
        menu.add(i6);
        menu.add(i7);
        menu.add(i8);
        menu.add(i9);
        menu.add(i10);
        menu.add(i15);

        // User menu with user's name and Sign Out item
        userMenu = new JMenu();
        ImageIcon userIcon = createImageIcon("icons/user.png", "User Icon");
        userIcon = new ImageIcon(userIcon.getImage().getScaledInstance(-1, 26, Image.SCALE_SMOOTH));

        userMenu.setIcon(userIcon);
        JMenuItem userNameItem = new JMenuItem(username);
        JMenuItem signOutItem = new JMenuItem("Sign Out");

        userMenu.add(userNameItem);
        userMenu.addSeparator(); // Add a separator between name and sign out
        userMenu.add(signOutItem);

        signOutItem.addActionListener(e -> System.exit(0));


        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);


        // Add spacing to the right side of the menu bar
        menuBar.add(Box.createHorizontalStrut(1420));

        // Add User menu to the right
        menuBar.add(userMenu);

        f.setJMenuBar(menuBar);
        cardLayout = new CardLayout();
        f.setLayout(cardLayout);

        f.add(new ShowRoomPanel(), "dashboardPanel");

        f.add(new DiningChairStartUpPanel(), "DiningChairStartUpPanel");
        f.add(new DiningChairDisplay(true), "diningChairDisplay");
        f.add(new DiningChair2DPanel(), "DiningChairDisplay2d");


        f.add(new DiningTableStartUpPanel(), "DiningTableStartUpPanel");
        f.add(new DiningTableDisplayPanel(true), "diningTableDisplay");
        f.add(new DiningTable2DPanel(), "DiningTableDisplay2d");


        f.add(new ComputerDeskStartUpPanel(), "ComputerDeskStartUpPanel");
        f.add(new ComputerDeskDisplayPanel(true), "computerDeskDisplay");
        f.add(new ComputerDesk2DPanel(), "ComputerDeskDisplay2d");

        f.add(new BedStartUpPanel(), "BedStartUpPanel");
        f.add(new BedDisplay(true), "BedDisplay");
        f.add(new Bed2DPanel(),"BedDisplay2d");

        f.add(new CupboardStartUpPanel(), "CupboardStartUpPanel");
        f.add(new CupboardPanel(true), "CupboardDisplay");
        f.add(new Cupboard2DPanel(), "CupboardDisplay2d");

        f.add(new TvStandStartUpPanel(), "TvStandStartUpPanel");
        f.add(new TvStandDisplay(true), "TvStandDisplay");
        f.add(new TvStand2DPanel(), "TvStandDisplay2d");

        f.add(new PantryCupboardStartUpPanel(), "PantryCupboardStartUpPanel");
        f.add(new PantryCupboardDisplay(true), "PantryCupboardDisplay");
        f.add(new PantryCupboard2DPanel(), "PantryCupboardDisplay2d");



        f.add(new WardrobeStartUpPanel(), "WardrobeStartUpPanel");
        f.add(new WardrobeDisplay(true), "WardrobeDisplay");
        f.add(new Wardrobe2DPanel(), "WardrobeDisplay2d");

        f.add(new CoffeeTableStartUpPanel(), "CoffeeTableStartUpPanel");
        f.add(new CoffeeTableDisplay(true), "CoffeeTableDisplay");
        f.add(new CoffeeTable2DPanel(), "CoffeeTableDisplay2d");


        f.add(new SavedPanelsPanel(), "savedDesignPanel");

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setVisible(true);
    }

    // Method to create an ImageIcon
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = ClassLoader.getSystemResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

  public static void main(String[] args) {
        new Menu("sandaru");
  }
}
