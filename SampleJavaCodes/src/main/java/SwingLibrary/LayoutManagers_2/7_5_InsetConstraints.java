package SwingLibrary.LayoutManagers;

import java.awt.Container;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The insets constraint specifies the external padding around the component,
 * using an Inset object.
 */

class InsetConstraint {
    public static void main(String[] args) {
        String title = "GridBagLayout with gridx and gridy";

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        int count = 1;
        for (int y = 0; y < 3; y++) {
            gbc.gridy = y;
            for (int x = 0; x < 3; x++) {
                gbc.gridx = x;
                contentPane.add(new JButton("Button " + count++), gbc);
            }
        }

        frame.pack();
        frame.setVisible(true);
    }
}