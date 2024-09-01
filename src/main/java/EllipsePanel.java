import javax.swing.*;
import java.awt.*;

public class EllipsePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        g2d.fillOval(0, 0, 100,100);
    }
}
