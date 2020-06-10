package SwingLibrary.LayoutManagers;

import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * With GridBagLayout, it lets you customize many properties of the components,
 * such as size, alignment, expandability, etc. Unlike the GridLayout, all cells
 * of the grid do not have to be of the same size.
 * 
 * An object of the GridBagConstraints class defines constraints for a component
 * in a GridBagLayout.
 * 
 * To specify the cell for a component, you need to call the add(Component c,
 * Object constraints) method. If no constraint, all cells are placed in one row
 * (like the FlowLayout).
 * 
 * To specify placement in cell, we must specify location of component with
 * constraint. The first cell depends on the orientation of the container. Left
 * to right, means first cell is upper left. We may use one constraint object
 * for all constraints, but best to create one object per constraint.
 * 
 * In the next files, we discuss each constraint of the gridbag layout.
 */

class SimplestGridBagLayout {
    public static void main(String[] args) {
        String title = "GridBagLayout in its Simplest Form";
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        for (int i = 1; i <= 9; i++) {
            contentPane.add(new JButton("Button " + i));
        }
        frame.pack();
        frame.setVisible(true);
    }
}

class GridBagLayoutWithgridxAndgridy {
    public static void main(String[] args) {
        String title = "GridBagLayout with gridx and gridy";
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        // Create an object for GridBagConstraints to set
        // the constraints for each JButton
        GridBagConstraints gbc = new GridBagConstraints();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                gbc.gridx = x;
                gbc.gridy = y;
                String text = "Button (" + x + ", " + y + ")";
                contentPane.add(new JButton(text), gbc);
            }
        }
        frame.pack();
        frame.setVisible(true);
    }
}