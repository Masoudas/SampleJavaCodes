package SwingLibrary.components_5;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * This is a more generic type of JFrame, that is rarely used, and has no title
 * bar, exit button and so forth. It can be used to create windows that appear
 * momentarily and then disappear!
 */

import javax.swing.JPanel;

class DrawingCanvas extends JPanel {
    public DrawingCanvas() {
        this.setPreferredSize(new Dimension(600, 75));
    }

    @Override
    public void paintComponent(Graphics g) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sample Drawings Using a Graphics Object");
        frame.getContentPane().add(new DrawingCanvas());
        frame.pack();
        frame.setVisible(true);
    }
}