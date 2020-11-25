package observer2;

import javax.swing.*;
import java.awt.*;

public abstract class ColorPanel extends JPanel implements Observer {
    private Color color;

    public ColorPanel(Color initialColor) {
        this.color = initialColor;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        this.setBackground(color);
        super.paintComponent(g);
    }
}