package observer3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

public class DisplayColors implements ChangeListener, Subject {

    public static void main(String[] args) {
        SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }

    protected OriginalColorPanel originalColorPanel;
    protected ComplementaryColorPanel complementaryColorPanel;

    protected JSlider hueSlider;
    protected JSlider saturationSlider;
    protected JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    protected JPanel colorsPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        originalColorPanel = createOriginalColorPanel(Color.getHSBColor(0, (float) .5, (float) .5));
        p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
        complementaryColorPanel = createComplimentaryColorPanel(Color.getHSBColor((float) .5, (float) .5, (float) .5), originalColorPanel);
        p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));
        registerObserver((Observer)originalColorPanel);
        return p;
    }

    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        JPanel colorsPanel = colorsPanel();
        JPanel subP = new JPanel();
        subP.setLayout(new GridLayout(3, 1));
        hueSlider = slider();
        subP.add(sliderBox("H", hueSlider, hueValueLabel));
        saturationSlider = slider();
        saturationSlider.setValue(50);
        subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
        brightnessSlider = slider();
        brightnessSlider.setValue(50);
        subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
        p.add(subP);
        p.add(colorsPanel);
        return p;
    }

    private JSlider slider() {
        JSlider slider = new JSlider();
        // WHAT GOES HERE?
        // You need to make it possible for the app to get the slider values out.
        slider.addChangeListener(this);
//        slider.setValue(slider.getMinimum());
        return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel) {
        if (valueLabel == null) {
            valueLabel = new JLabel();
            valueLabel.setFont(SwingFacade.getStandardFont());
            valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(Color.black);
        }
        Box b = Box.createHorizontalBox();
        JLabel label = new JLabel(sliderLabel);
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(Color.black);
        b.add(label);
        b.add(valueLabel);
        b.add(slider);
        b.setPreferredSize(new Dimension(600, 50));
        return b;
    }

    protected OriginalColorPanel createOriginalColorPanel(Color initialColor) {
        OriginalColorPanel colorPanel = new OriginalColorPanel(initialColor);
        colorPanel.setPreferredSize(new Dimension(300, 200));
        return colorPanel;
    }

    protected ComplementaryColorPanel createComplimentaryColorPanel(Color initialColor, OriginalColorPanel originalColorPanel) {
        ComplementaryColorPanel colorPanel = new ComplementaryColorPanel(initialColor, originalColorPanel);
        colorPanel.setPreferredSize(new Dimension(300, 200));
        return colorPanel;
    }


//    public void stateChanged(ChangeEvent e) {
//        if (hueSlider != null && saturationSlider != null && brightnessSlider != null) {
//            float newHue = (float) hueSlider.getValue() / 100;
//            float newSaturation = (float) saturationSlider.getValue() / 100;
//            float newBrightness = (float) brightnessSlider.getValue() / 100;
//            Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
//            float complementaryHue = newHue - (float) 0.5;
//            if (complementaryHue < 0) {
//                complementaryHue = complementaryHue + 1;
//            }
//            Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
//            // WHAT GOES HERE?
//            // You need to update the two color panels with the appropriate colors
//            originalColorPanel.setColor(newColor);
//            complementaryColorPanel.setColor(complementaryColor);
//        }
//    }

    public void stateChanged(ChangeEvent e) {
        notifyObservers();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void notifyObservers(){
        for (int i = 0; i < observers.size(); i++){
            Observer observer = observers.get(i);
            observer.update(hueSlider, saturationSlider, brightnessSlider);
        }
    }
}
    
