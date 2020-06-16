package SwingLibrary.LayoutManagers;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * A GridBagLayout gives the preferred width and height to each component. The
 * width of a column is decided by the widest component in the column.
 * Similarly, the height of a row is decided by the highest component in the
 * row. The fill constraint value indicates how a component is expanded
 * horizontally and vertically when its display area is bigger than its size.
 * Note that the fill constraint is only used when the component’s size is
 * smaller than its display area
 * 
 * 
 * It has four values, NONE, HORIZONTAL, VERTICAL, and BOTH. Obviously, each one
 * expands in each direction (or both directions).
 * 
 * 
 * 
 */

class FillConstraintExample {
    public static void main(String[] args) {
        String title = "GridBagLayout with gridx and gridy";

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(new JButton("Button 1"), gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 0;
        contentPane.add(new JButton("Button 2"), gbc);
       
        gbc.gridx = 2;
        gbc.gridy = 0;
        contentPane.add(new JButton("Button 3"), gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(new JButton("Button 4"), gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(new JButton("This is a big Button 5"), gbc);
       
        gbc.gridx = 2;
        gbc.gridy = 1;
        contentPane.add(new JButton("Button 6"), gbc);
       
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(new JButton("Button 7"), gbc);
       
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(new JButton("Button 8"), gbc);
       
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        contentPane.add(new JButton("Button 9"), gbc);

        frame.pack();
        frame.setVisible(true);
    }
}