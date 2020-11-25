package observer3;

import javax.swing.*;
import java.awt.*;

public class OriginalColorPanel extends ColorPanel implements Observer{

    protected float currentHue;
    protected float currentSaturation;
    protected float currentBrightness;

    public OriginalColorPanel(Color initialColor){
        super(initialColor);
    }

    public void update(JSlider hueSlider, JSlider saturationSlider, JSlider brightnessSlider) {
        if (hueSlider != null && saturationSlider != null && brightnessSlider != null) {
            float newHue = (float) hueSlider.getValue() / 100;
            float newSaturation = (float) saturationSlider.getValue() / 100;
            float newBrightness = (float) brightnessSlider.getValue() / 100;
            currentHue = newHue;
            currentSaturation = newSaturation;
            currentBrightness = newBrightness;
            Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
//            float complementaryHue = newHue - (float) 0.5;
//            if (complementaryHue < 0) {
//                complementaryHue = complementaryHue + 1;
//            }
//            Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
            // WHAT GOES HERE?
            // You need to update the two color panels with the appropriate colors
            this.setColor(newColor);

        }
    }
}
