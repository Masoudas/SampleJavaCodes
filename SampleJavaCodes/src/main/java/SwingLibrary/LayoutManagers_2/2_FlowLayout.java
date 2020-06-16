package SwingLibrary.LayoutManagers;

import java.awt.Container;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * It sets the components horizontally (left to right or right to left), then
 * vertically, depending on the order they're added. The horizontal direction
 * depends on orientation parameter of the manager, which we set for a container
 * using the setComponentOrientation.
 * 
 * FlowLayout asks for width and height of components, together with the
 * inbounds (or gap between them), but tries to put everything in one row first.
 * 
 * An example is given below. The pack method is used, so that we don't have to
 * specify bounds for every component.
 * 
 * By default, all components are aligned to the center of the frame. You can
 * change this by defining the alignment of the FlowLayout in its constructor.
 * We've LEFT, RIGHT, CENTER, LEADING, TRAILING. For the last two, if the
 * orientation is left to right, alignment is done with the left most component,
 * and vice versa.
 * 
 * You can also set the gap between components in the constructor (or using
 * setHGap and setVGap).
 * 
 * Note also that flowLayout tries to put all components into one row. Hence, it
 * does not ask for a row size (horizontal size we mean). Moreover, when the
 * number of components exceed a row, it does not put them in the next row, it
 * rather hides them! Try and play with the size of the frame size when
 * displayed to see this effect.
 * 
 * As another example, we use a JPanel (which has FlowLayout as manager) and try
 * and add it to another JFrame. The point is that again, we'd only have one row
 * containing both the buttons and the JFrame. Moreover, we'll never see the
 * JPanel break down into two rows (try and play with frame size after
 * compilation). Why? (because it's counted as one component or it will not
 * break down perhaps).
 */

class OrientationOfComponents {
    public static void main(String[] args) {
        // Method – 1
        // Set the orientation of the content pane of a frame to "right to left"
        JFrame frame = new JFrame("Test");
        Container pane = frame.getContentPane();
        pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Method – 2
        // Set the orientation of the content pane and all its children to "right to
        // left"
        JFrame frame1 = new JFrame("Test");
        Container pane1 = frame.getContentPane();
        pane.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

}

class UsingFlowLayout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flow Layout Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        for (int i = 1; i <= 3; i++) {
            contentPane.add(new JButton("Button " + i));
        }

        frame.pack();
        frame.setVisible(true);
    }
}

class UsingFlowLayoutWithGapAndAlignemnt {
    public static void main(String[] args) {
        int hGap = 10;
        int vGap = 30;
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEADING, hGap, vGap);

        JFrame frame = new JFrame("Flow Layout Test");
        frame.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(flowLayout);

        for (int i = 1; i <= 3; i++) {
            contentPane.add(new JButton("Button " + i));
        }

        frame.pack();
        frame.setVisible(true);
    }
}

class JPanelInsideJFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("With Pannel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEADING));
        contentPane.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        for (int i = 1; i <= 3; i++) {
            contentPane.add(new JButton("Button " + i));
        }

        JPanel panel = new JPanel();
        for (int i = 0; i < 3; i++) {
            panel.add(new JButton("Button " + i));
        }

        contentPane.add(panel);

        frame.pack();
        frame.setVisible(true);

    }
}