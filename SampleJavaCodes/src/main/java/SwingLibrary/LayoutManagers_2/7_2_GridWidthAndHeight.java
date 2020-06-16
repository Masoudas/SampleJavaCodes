package SwingLibrary.LayoutManagers;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The gridwidth and gridheight constraints specify the width and height of the
 * display area of a component, respectively. The default value for both is 1.
 * 
 * Two constants are REMAINDER and RELATIVE. REMAINDER for gridwidth means it
 * will span the rest of the row (last in the row). REMAINDER for gridheight
 * means last item in the column. RELATIVE for gridwidth means that the width of
 * the display area of the component will be from its gridx to the second last
 * cell in the row. For gridheight and means from gridy to the second last in
 * the column.
 */

class GridwidthExample {
    public static void main(String[] args) {
        String title = "GridBagLayout with gridx and gridy";

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Expand the component to fill the whole cell
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(new JButton("Button 1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        contentPane.add(new JButton("Button 2"), gbc);

        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        contentPane.add(new JButton("Button 3"), gbc);

        // Reset gridwidth to its default value 1
        gbc.gridwidth = 1;
        // Place six JButtons in second row
        gbc.gridy = 1;
        for (int i = 0; i < 6; i++) {
            gbc.gridx = i;
            contentPane.add(new JButton("Button " + (i + 4)), gbc);
        }

        frame.pack();
        frame.setVisible(true);
    }
}