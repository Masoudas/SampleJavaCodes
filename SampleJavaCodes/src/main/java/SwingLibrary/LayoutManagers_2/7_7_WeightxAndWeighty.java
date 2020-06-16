package SwingLibrary.LayoutManagers;

import java.awt.Container;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * These two constants control how the extra space in the container is
 * allocated. What extra space are we talking about? This would be the extra
 * space, after for example resizing the frame when it's showing. So when these
 * are set to zero, any extra space will appear between the edge of the
 * component and the container.
 * 
 * Weightx determines distribution in the horizontal axis. If all components
 * have the same value, space is equally distributed among them. weighty is for
 * vertical. Absolute value of weightx does not matter, so long as the ratio
 * among all components is equal.
 * 
 * Note that the fill constraint plays a role here too. If we set the fill, the
 * component will fill any extra space that may occur. This however does not
 * mean weight is irrelevant, because the ratio that it creates with other
 * parameters is still important in space distribution.
 * 
 * So in this example, we see that we've not set weighty, so the extra goes all
 * the way to the edge of the component, where as in the horizontal direction,
 * the weight is equally distributed.
 */

class WeightConstraintExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = frame.getContentPane();
        content.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        content.add(new JButton("Button 1"), c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        content.add(new JButton("Button 2"), c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        content.add(new JButton("Button 3"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        content.add(new JButton("Button 4"), c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        content.add(new JButton("Button 5"), c);

        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 1;
        content.add(new JButton("Button 6"), c);

        frame.pack();
        frame.setVisible(true);

    }
}

/**
 * Because we set the fill, the first button always fills, where as the other two leave some space.
 */
class WeightConstraintExampleWithFill {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = frame.getContentPane();
        content.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        content.add(new JButton("Button 1"), c);

        c.fill = GridBagConstraints.NONE; // Resetting the constraint.
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        content.add(new JButton("Button 2"), c);

        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        content.add(new JButton("Button 3"), c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        content.add(new JButton("Button 4"), c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        content.add(new JButton("Button 5"), c);

        c.gridx = 2;
        c.gridy = 1;
        c.weightx = 1;
        content.add(new JButton("Button 6"), c);

        frame.pack();
        frame.setVisible(true);

    }
}