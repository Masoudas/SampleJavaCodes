package SwingLibrary.components_5.TextComponents_5;

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
 * salaryField.setValue(new Double(11233.98));
 * 
 * You can also create a JFormattedTextField with a formatter. You need to use
 * the DateFormatter, NumberFormatter, and MaskFormatter classes to format a
 * date, a number, and a string, respectively. These classes are in the
 * javax.swing.text package.
 * 
 * // Have a field to format a date in mm/dd/yyyy format
 * 
 * DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy"); 
 * DateFormatter dateFormatter = new DateFormatter(dateFormat); dobField = new
 * JFormattedTextField(dateFormatter);
 * 
 * // Have field to format a number in $#0,000.00 format 
 * NumberFormat numFormat = new DecimalFormat("$#0,000.00"); 
 * NumberFormatter numFormatter = new NumberFormatter(numFormat); 
 * salaryField = new JFormattedTextField(numFormatter);
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
 * MaskFormatter ssnFormatter = null; 
 * JFormattedTextField ssnField = null;
 * try { 
 *  ssnFormatter = new MaskFormatter("###-##-####");
 *  ssnField = new JFormattedTextField(ssnFormatter);
 * }
    catch (ParseException e) {
        e.printStackTrace();
    }
 */
class JFormattedTextFieldExample {

}