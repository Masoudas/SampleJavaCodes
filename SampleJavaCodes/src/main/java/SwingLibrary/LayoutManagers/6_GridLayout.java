package SwingLibrary.LayoutManagers;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

/**
 * The grid layout divides the container into cells of equal size. It does not
 * respect the preferred size of each component.
 * 
 * Suppose ncomponents is the number of components added to the container, and
 * nrows and ncols are the specified number of rows and columns. If nrows is
 * greater than zero, the number of columns in the grid is computed using the
 * following formula:
 * 
 * ncols = (ncomponents + nrows - 1)/nrows
 * 
 * and if nrows is zero using the formula:
 * 
 * nrows = (ncomponents + ncols - 1)/ncols
 * 
 * GridLayout has three constructors that specify the number of rows and
 * columns, and hgap and vgap.
 * 
 * A GridLayout is a simple layout manager to code by hand. However, it is not
 * very powerful, for two reasons. First, it forces each component to have the
 * same size, and second, you cannot specify the row and column number (or exact
 * location) of a component in the grid. That is, you can only add a component
 * to the GridLayout. They will be laid out horizontally, and then vertically in
 * the order you add them to the container. If the container’s orientation is
 * LEFT_TO_RIGHT, components are laid out from left-to-right, and then
 * top-to-bottom. If the container’s orientation is RIGHT_TO_LEFT, components
 * are laid out from right-to-left, and then top-to-bottom. One good use of the
 * GridLayout is to create a group of buttons of the same size. For example,
 * suppose you add two buttons with the text OK and Cancel to a container and
 * want them to have the same size. You can do this by adding the buttons to a
 * container managed by a GridLayout layout manager.
 */

class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid layout example.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 0, 20, 20));
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        for (int i = 0; i < 6; i++) {
            buttonPanel.add(new JButton("Button " + i));
        }

        frame.pack();
        frame.setVisible(true);
    }
}