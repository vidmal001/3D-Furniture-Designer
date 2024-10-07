package furniture.management.system;
import javax.swing.*;
import java.awt.*;

public class RoundedButton extends JButton {
    private Color startColor;
    private Color endColor;

    public RoundedButton(String text, Color startColor, Color endColor) {
        super(text);
        this.startColor = startColor;
        this.endColor = endColor;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setContentAreaFilled(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                updateGradient((float) 0.8);
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setCursor(Cursor.getDefaultCursor());
                updateGradient((float) 1);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        LinearGradientPaint gradientPaint = new LinearGradientPaint(
                0, 0, 0, getHeight(),
                new float[]{0f, 1f},
                new Color[]{startColor, endColor}
        );

        g2d.setPaint(gradientPaint);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        // Calculate text position
        String text = getText();
        FontMetrics metrics = g2d.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(text)) / 2;
        int y = (getHeight() + metrics.getAscent() - metrics.getDescent()) / 2;

        g2d.drawString(text, x, y);
    }

    private void updateGradient(float factor) {
        startColor = new Color(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), (int) (255 * factor));
        endColor = new Color(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), (int) (255 * factor));
    }
}