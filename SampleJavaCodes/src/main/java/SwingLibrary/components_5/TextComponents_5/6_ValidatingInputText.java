package SwingLibrary.components_5.TextComponents_5;

import java.awt.Container;
import java.text.SimpleDateFormat;
import java.awt.*;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * You can attach an input verifier object to any JComponent, including a text
 * component. An input verifier object is simply an object of a class, which
 * inherits from the abstract class named InputVerifier.
 * 
 * public abstract class InputVerifier {
 * 
 * public abstract boolean verify(JComponent input);
 * 
 * public boolean shouldYieldFocus(JComponent input) {return verify(input); } }
 * 
 * You need to override the verify() method of the InputVerifier class. The
 * verify() method contains the logic to verify the input in the text field. If
 * the value in the text field is valid, you return true from this method.
 * Otherwise, you return false.
 * 
 * When the text field is about to lose focus, the verify() method of its input
 * verifier is called. The text field loses focus only if its input verifier’s
 * verify() method returns true. The setInputVerifier() method of a text
 * component is used to attach an input verifier.
 */

/**
 * 6_ValidatingInputText
 */
class ValidatingInputText {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2, 0));

        // Create an area code JTextField
        JTextField areaCodeField = new JTextField(3);
        // Set an input verifier to the area code field
        areaCodeField.setInputVerifier(new MyInputVerifier());

        JTextField anotherField = new JTextField(3);

        frame.add(areaCodeField);
        frame.add(anotherField);

        frame.pack();
        frame.setVisible(true);
    }
}

class MyInputVerifier extends InputVerifier {
    public boolean verify(JComponent input) {
        String areaCode = ((JTextField) input).getText();
        if (areaCode.length() == 0) {
            return true;
        } else if (areaCode.length() != 3) {
            return false;
        }
        try {
            Integer.parseInt(areaCode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
