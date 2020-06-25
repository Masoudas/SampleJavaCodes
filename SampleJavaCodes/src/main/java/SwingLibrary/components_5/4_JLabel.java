package SwingLibrary.components_5;

import java.awt.Container;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * A JLabel is a label used to identify or describe another component on the
 * screen. We can also use the Icon constructor of a JLabel to show an image.
 * There's no separate component for showing an image.
 * 
 * The constructor JLabel(Icon icon, int horizontalAlignment) is used for
 * defining the horizontal alignment of the component. Note that we have
 * JLabel.Left, JLabel.Right, Trailing, Leading, Center for that, which all
 * depend on the orientation of the container.
 * 
 * setDisplayedMnemonic(), and setLabelFor(). The setText() method is used to
 * set the text for the JLabel. The setDisplayedMnemonic() method is used to set
 * a keyboard mnemonic for the JLabel. If the keyboard mnemonic is a character
 * that occurs in the text of the JLabel, that character is underlined to give a
 * hint to the user. The setLabelFor() method accepts a reference to another
 * component and it indicates that this JLabel describes that component. The two
 * methods - setDisplayedMnemonic() and setLabelFor() work in tandem. When the
 * mnemonic key for the JLabel is pressed, the focus is set to the component
 * that was used in the setLabelFor() method.
 */

class JLabelExample {
    public static void main(String[] args) {

        // Create a JTextField where the user can enter a name
        JTextField nameTextField = new JTextField("Please enter your name...");
        // Create a JLabel with N as its mnemonic and nameTextField as its label-for
        // component
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setDisplayedMnemonic('N');
        nameLabel.setLabelFor(nameTextField);

        JFrame frame = new JFrame("JButtons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(1, 3, 20, 20));

        container.add(nameLabel);
        container.add(nameTextField);

        frame.pack();
        frame.setVisible(true);

    }
}