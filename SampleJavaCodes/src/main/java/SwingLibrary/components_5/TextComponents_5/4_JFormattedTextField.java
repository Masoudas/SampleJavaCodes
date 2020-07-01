package SwingLibrary.components_5.TextComponents_5;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 * A JFormattedTextField is a JTextField with the following two additional
 * capabilities:
 * 
 * • It lets you specify the format in which the text will be edited and/or
 * displayed.
 * 
 * • It also lets you specify a format when the value in the field is null.
 * 
 * In addition to the getText() and setText() methods, which let you get and set
 * the text in the field, the JFormattedTextField offers two new methods called
 * getValue() and setValue(), which let you work with any type of data instead
 * of just text.
 * 
 * It is necessary to understand the difference between format, formatter, and
 * formatter factory. A java.text.Format object defines the format of an object
 * in a string form. That is, it defines how an object looks as a string; for
 * example, a date object in mm/dd/yyyy format would look like 07/09/2008.
 * 
 * A formatter is represented by a JFormattedTextField.AbstractFormatter object
 * and it uses a java.text.Format object to format an object. Its job is to
 * convert an object to a string and a string back to an object
 * 
 * A formatter factory is a collection of formatters. A JFormattedTextField uses
 * a formatter factory to get a formatter of a specific type. A formatter
 * factory object is represented by an instance of the JFormattedTextField.
 * AbstractFormatterFactory class.
 * 
 * The following snippet of code configures dobField to format the text in it as
 * a date in the current locale format:
 * 
 * JFormattedTextField dobField = new JFormattedTextField();
 * dobField.setValue(new Date());
 * 
 * The following snippet of code configures a salaryField to display a number in
 * the current locale format:
 * 
 * JFormattedTextField salaryField = new JFormattedTextField();
 * salaryField.setValue(new Double(11233.98)); It should be noted that Double is
 * not a formatter. It's just a value that can be displayed. However, for some
 * reason a formatter is set and in the PropertyChangeListener, we see that a
 * number is set, a true is returned, and that when we press enter, the actual
 * value is returned (I think it's better to use mask formatter in any case).
 * 
 * You can also create a JFormattedTextField with a formatter. You need to use
 * the DateFormatter, NumberFormatter, and MaskFormatter classes to format a
 * date, a number, and a string, respectively. These classes are in the
 * javax.swing.text package.
 * 
 * // Have a field to format a date in mm/dd/yyyy format
 * 
 * DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy"); DateFormatter
 * dateFormatter = new DateFormatter(dateFormat); dobField = new
 * JFormattedTextField(dateFormatter);
 * 
 * // Have field to format a number in $#0,000.00 format NumberFormat numFormat
 * = new DecimalFormat("$#0,000.00"); NumberFormatter numFormatter = new
 * NumberFormatter(numFormat); salaryField = new
 * JFormattedTextField(numFormatter);
 * 
 * With mask formatter, we can define a custom representation of a string. We
 * then need to use special chars to create a string format:
 * 
 * # : A number
 * 
 * ? : A char
 * 
 * A: A letter or a number.
 * 
 * *: Anything
 * 
 * U: a char, where lower case is turned into upper case.
 * 
 * L: A char, where upper is turned into lower.
 * 
 * ': A single quote, used for escaping special chars.
 * 
 * Here's how we create a mask formatter, which accepts ###-##-####
 * 
 * MaskFormatter ssnFormatter = null; JFormattedTextField ssnField = null; try {
 * ssnFormatter = new MaskFormatter("###-##-####"); ssnField = new
 * JFormattedTextField(ssnFormatter); } catch (ParseException e) {
 * e.printStackTrace(); }
 * 
 * Use setPlaceholderCharacter of the formatter to place the character that you
 * like in the place of special characters (like sharp here).
 * 
 * You can use the setFormatterFactory() method of JFormattedTextField to change
 * the formatter after you have created the component. For example, to set a
 * date format to a JFormattedTextField named payDate, after you have created
 * it, you write DateFormatter df = new DateFormatter(new
 * SimpleDateFormat("mm/dd/yyyy")); DefaultFormatterFactory dff = new
 * DefaultFormatterFactory(df, df, df, df); dobField.setFormatterFactory(dff);
 */

/**
 * VERY IMPORTANT: See also 6_ValidatingInputText.java
 */
class JFormattedTextFieldExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2, 0));

        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        DateFormatter formatter = new DateFormatter(format);
        JFormattedTextField textField = new JFormattedTextField(formatter);

        JFormattedTextField NA = new JFormattedTextField(new Double("1.70"));

        JFormattedTextField NA1 = null;
        try {
            MaskFormatter mask = new MaskFormatter("#.####");
            NA1 = new JFormattedTextField(mask);
        } catch (ParseException e) {
        }
        NA1.setValue(1.5555);

        contentPane.add(textField);
        contentPane.add(NA);
        contentPane.add(NA1);

        textField.addPropertyChangeListener((t) -> {
            System.out.println(t.getNewValue());
        });
        NA.addPropertyChangeListener((t) -> {
            System.out.println(t.getNewValue());
        });
        NA1.addPropertyChangeListener((t) -> {
            System.out.println(t.getNewValue());
        });

        frame.pack();
        frame.setVisible(true);

    }
}

/**
 * A JFormattedTextField allows you to specify four types of formatters:
 * 
 * 1- A null formatter: It is used when the value in the field is null.
 * 
 * 2- An edit Formatter: It is used when the field has focus.
 * 
 * 3- A display Formatter: It is used when the field does not have focus and it
 * has a non-null value.
 * 
 * 4- A default Formatter: It is used in the absence of any of the above three
 * formatters.
 * 
 * You can specify all four formatters by using a formatter factory in the
 * constructor of the JFormattedTextField class or calling its
 * setFormatterFactory() method. An instance of the JFormattedTextField.
 * AbstractFormatterFactory abstract class represents a formatter factory. The
 * javax.swing.text. DefaultFormatterFactory class is an implementation of the
 * JFormattedTextField.AbstractFormatterFactory class. When you specify a
 * formatter, the same formatter is used in place of four formatters. When you
 * specify a formatter factory, you have the ability to specify different
 * formatters for four different situations
 * 
 * So in the following class, we use the default formatter factory to define all
 * four of the formatters.
 */
class FormatterFactoryExample extends JFormattedTextField.AbstractFormatterFactory {

    @Override
    public AbstractFormatter getFormatter(JFormattedTextField tf) {
        DateFormatter format1 = new DateFormatter(new SimpleDateFormat("dd/mm/yyyy"));
        DateFormatter format2 = new DateFormatter(new SimpleDateFormat("yyyy/mm/dd"));

        DefaultFormatterFactory factory = new DefaultFormatterFactory(format1, format2, format1, format1);

        return null;
    }
}

