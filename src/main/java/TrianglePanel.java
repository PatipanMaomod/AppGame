import javax.swing.*;
import java.awt.*;

public class TrianglePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        int[] xPoints = {0, getWidth(), getWidth() / 2};
        int[] yPoints = {getHeight(), getHeight(), 0};
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}
