package furniture.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class Login extends JFrame {
    JLabel label2;
    JLabel label3 ;
    JTextField textField1;
    JPasswordField passwordField;

    JButton b1;

    Login()  {

        super("Furniture Management System");

        Map<String, String> userCredentials = new HashMap<>();
        userCredentials.put("sandaru", "123");
        userCredentials.put("seraan", "123");

        JLabel logo = new JLabel("Arpico Furniture");
        logo.setForeground(new Color(0, 0, 0));
        logo.setFont(new Font("Papyrus", Font.BOLD, 24));
        logo.setBounds(30, 15, 350, 38);
        add(logo);

        label2 = new JLabel("User Name");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        label2.setBounds(420,170,450,50);
        add(label2);

        textField1 = new JTextField(15) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(200, 230, 250));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);
            }

            @Override
            public void updateUI() {
                super.updateUI();
                setOpaque(false);
            }
        };

        textField1.setBounds(545, 175, 230, 30);
        textField1.setFont(new Font("Source Sans Pro", Font.BOLD, 12));
        textField1.setBorder(BorderFactory.createEmptyBorder());
        add(textField1);

        label3 = new JLabel("Password");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Comic Sans MS",Font.BOLD,17));
        label3.setBounds(420,212,450,50);
        add(label3);



        passwordField = new JPasswordField(15) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(200, 230, 250));
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                super.paintComponent(g);

            }

            @Override
            public void updateUI() {
                super.updateUI();
                setOpaque(false);
            }
        };
        passwordField.setBounds(545,225,230,30);
        passwordField.setFont(new Font("Source Sans Pro",Font.BOLD,12));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        add(passwordField);

        Color startColor = new Color(143, 108, 74);
        Color endColor = new Color(107, 80, 54);
        b1 = new RoundedButton("Click Here to Login", startColor, endColor);
        b1.setBounds(545, 300, 230, 30);
        add(b1);

        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(70, 130, 180));
        footerPanel.setBounds(0, 430, 850, 110);
        add(footerPanel);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/virender-singh-hE0nmTffKtM-unsplash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,850,480);
        add(image);

        setLayout(null);
        setSize(850,540);
        setLocation(380,180);
        setVisible(true);
        b1.addActionListener(e -> {
            // Check if username or password is empty
            String username = textField1.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                // Show an error message
                JOptionPane.showMessageDialog(Login.this, "Username and password are required.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
                SplashScreen loadingScreen = new SplashScreen();

                // Load the menu asynchronously
                SwingUtilities.invokeLater(() -> {
                    new Menu(username);
                    loadingScreen.dispose(); // Close the splash screen after the menu is displayed
                });

                dispose();
            } else {
                // Show an error message for invalid credentials
                JOptionPane.showMessageDialog(Login.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

    }

}
