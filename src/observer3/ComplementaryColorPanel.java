package observer3;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener {
    private OriginalColorPanel originalColorPanel;
    public ComplementaryColorPanel(Color initialColor, OriginalColorPanel originalColorPanel){
        super(initialColor);
        this.originalColorPanel = originalColorPanel;
        this.originalColorPanel.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent e) {
        float complementaryHue = originalColorPanel.currentHue - (float) 0.5;
        if (complementaryHue < 0) {
            complementaryHue = complementaryHue + 1;
        }
        Color complementaryColor = Color.getHSBColor(complementaryHue, originalColorPanel.currentSaturation, originalColorPanel.currentBrightness);
        this.setColor(complementaryColor);
    }


}
