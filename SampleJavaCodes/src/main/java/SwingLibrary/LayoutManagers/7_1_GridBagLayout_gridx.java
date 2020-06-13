package SwingLibrary.LayoutManagers;

import java.awt.Container;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;

/**
 * 
 * gridx and gridy specify the starting cell of the display area of a component.
 * By default, each component occupies only one cell. As mentioned, which also
 * relies on the orientation of the container as well.
 * 
 * We have these cases:
 * 
 * Case #1:
 * 
 * You have specified values for both gridx and gridy. This is the case of
 * absolute positioning in the grid. Your component is placed according to the
 * value of gridx and gridy that you have specified (like the example in the
 * previous file).
 * 
 * Case #2:
 * 
 * You have specified a value for gridx and you have set the value for gridy to
 * RELATIVE. In this case, the layout manager needs to determine the value for
 * gridy. If we see RelativeY example, button 2 is placed in the second row.
 * Why? Because we said relative, and then layout manager after putting button 1
 * starts looking for the first available row and given that it's row 1, it puts
 * the component there. Then again for button 3, we have specified the column at
 * 1, but y as relative, so it looks for the first available one, which is row
 * 0.
 * 
 * Case #3
 * 
 * You have specified a value for gridy and you have set the value for gridx to
 * RELATIVE. It will be the reverse of case 2.
 * 
 * Case #4
 * 
 * You specify both gridx and gridy as RELATIVE. The layout manager determines
 * the row number first, and then the column number. The row for the component
 * will be the current row, which starts from zero. When you add a component,
 * you can also specify its gridwidth constraint. One of its values is
 * REMAINDER, which means that this is the last component in the row. If you add
 * a component to the first row with its gridwidth set to REMAINDER, the second
 * row becomes the current row. Once row is determined, component is placed in
 * the next column available in that row. This is the reason why if we don't
 * specify any constraint, all components are added to the first row. Because
 * row one is always available, and it always has a next column.
 * 
 * Checkout the examples below
 * 
 */

class RelativeY {
    public static void main(String[] args) {
        String title = "GridBagLayout with gridx and gridy";

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(b1, gbc);
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        contentPane.add(b2, gbc);
        gbc.gridx = 1;
        gbc.gridy = GridBagConstraints.RELATIVE;
        contentPane.add(b3, gbc);

        frame.pack();
        frame.setVisible(true);

    }
}

/**
 * In this example, first button is absolute. For the second one, the next
 * available row is still zero, and column would be one. So button two will be
 * placed there. Then for the next one, row has to be one of course, but then
 * column is relative, so it's placed at one
 */
class RelativeExample1 {
    public static void main(String[] args) {
        String title = "GridBagLayout with gridx and gridy";

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(b1, gbc);

        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE;
        contentPane.add(b2, gbc);

        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = 1;
        contentPane.add(b3, gbc);

        frame.pack();
        frame.setVisible(true);

    }
}

/**
 * This one is easy to predict now I guess.
 */
class RelativeExample2 {
    public static void main(String[] args) {
        String title = "GridBagLayout with gridx and gridy";

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;// Last component in the row
        contentPane.add(b1, gbc);

        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.gridwidth = 1; // Reset to the default value. This why we should use many instances of constraint class!
        contentPane.add(b2, gbc);
        
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = 1;
        contentPane.add(b3, gbc);

        frame.pack();
        frame.setVisible(true);
    }
}