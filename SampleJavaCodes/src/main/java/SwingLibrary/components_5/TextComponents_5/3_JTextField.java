package SwingLibrary.components_5.TextComponents_5;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * This is the class that we would be using ,ost often, because it displays one
 * line of plain text.
 * 
 * We can construct with a string (The string specifies the initial text),
 * number of columns, (with respect to font size, the number of columns
 * specifies the width, and we can place as many as m chars inside), or a
 * document (The Document object specifies the model).
 * 
 * If we want to user to enter strings in a particular format (let's say
 * dd/mm/yyyy). then we need to define a custom document, but we better use
 * JFormattedTextField.
 * 
 */
class JTextFieldExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField field = new JTextField("A simple Text");

        frame.getContentPane().add(field);

        frame.pack();
        frame.setVisible(true);
    }
}

/**
 * Separation of model from UI (view and controller), allow us to use the same
 * model for different views. We use the following example to create a mirror
 * field. The important point of the example is that model automatically sends a
 * notification indicating internal change, so that the view of the other model
 * is updated.
 */
class MirroredTextField extends JFrame {
    private static final long serialVersionUID = -2139321L;
    JLabel nameLabel = new JLabel("Name:");
    JLabel mirroredNameLabel = new JLabel("Mirrored Name:");
    JTextField name = new JTextField(20);
    JTextField mirroredName = new JTextField(20);

    public MirroredTextField() {
        super("Mirrored JTextField");
        this.initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 0));
        Container contentPane = this.getContentPane();
        contentPane.add(nameLabel);
        contentPane.add(name);
        contentPane.add(mirroredNameLabel);
        contentPane.add(mirroredName);
        // Set the model for mirroredName to be the same
        // as name's model, so they share their content's storage.
        Document nameModel = name.getDocument();
        mirroredName.setDocument(nameModel);
    }

    public static void main(String[] args) {
        MirroredTextField frame = new MirroredTextField();
        frame.pack();
        frame.setVisible(true);
    }
}

/**
 * As an example, in the following, we create a document class and override it.
 */
class LimitedCharDocument extends PlainDocument {
    private static final long serialVersionUID = -7517788612431579757L;
    private int limit = -1; // < 0 means an unlimited characters

    public LimitedCharDocument() {
    }

    public LimitedCharDocument(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        String newString = str;
        if (limit >= 0 && str != null) {
            // Check for the limit
            int currentLength = this.getLength();
            int newTextLength = str.length();
            if (currentLength + newTextLength > limit) {
                newString = str.substring(0, limit - currentLength);
            }
        }
        super.insertString(offset, newString, a);
    }
}
