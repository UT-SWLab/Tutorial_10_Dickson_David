package observer3;
import javax.swing.*;

public interface Observer {
    public void update(JSlider hueSlider, JSlider saturationSlider, JSlider brightnessSlider);
}
