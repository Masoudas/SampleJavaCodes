package SwingLibrary.components_5.JSliderBar_9;

import java.util.Hashtable;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/**
 * A JSlider allows you to choose from a set of integer values.
 * 
 * SwingConstants interface determines how the component is oriented. And
 * probably the alignment determines whether labels are put on the left or right
 * of the component.
 * 
 */
class Basics_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JSlider slider = new JSlider(SwingConstants.VERTICAL);
        // slider.setOrientation(SwingConstants.VERTICAL); another way of setting orientation.
        slider.setMinimum(0);
        slider.setMaximum(10);
        slider.setValue(4);
        
        slider.

        int currentValue = slider.getValue();

        // We can set the ticks of the slider by setting the minor and major ticks.
        slider.setMajorTickSpacing(5); // The major ticks, where the tickers are shown.
        slider.setMinorTickSpacing(1); // The minor ticks, where the petit markers are shown.
        slider.setPaintTicks(true);

        // We can also paint the labels for ticks. This method shows automatic labels.
        slider.setPaintLabels(true);

        // We can also define custom labels.
        Hashtable<Integer, JLabel> table = new Hashtable<>();
        table.put(new Integer(1), new JLabel("2"));
        table.put(new Integer(3), new JLabel("3"));
        table.put(new Integer(4), new JLabel("7"));
        slider.setLabelTable(table);
        slider.setPaintLabels(true);

        frame.getContentPane().add(slider);

        frame.pack();
        frame.setVisible(true);

    }
}