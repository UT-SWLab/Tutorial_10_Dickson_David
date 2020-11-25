package observer2;

import javax.swing.*;
import java.awt.*;

public class OriginalColorPanel extends ColorPanel{
    public OriginalColorPanel(Color initialColor){
        super(initialColor);
    }

    public void update(JSlider hueSlider, JSlider saturationSlider, JSlider brightnessSlider) {
        if (hueSlider != null && saturationSlider != null && brightnessSlider != null) {
            float newHue = (float) hueSlider.getValue() / 100;
            float newSaturation = (float) saturationSlider.getValue() / 100;
            float newBrightness = (float) brightnessSlider.getValue() / 100;
            Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
            float complementaryHue = newHue - (float) 0.5;
            if (complementaryHue < 0) {
                complementaryHue = complementaryHue + 1;
            }
            Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
            // WHAT GOES HERE?
            // You need to update the two color panels with the appropriate colors
            this.setColor(newColor);

        }
    }
}
