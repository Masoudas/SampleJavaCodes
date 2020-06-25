package SwingLibrary.components_5.TextComponents_5;

/**
 * This is the mother of all text components, and an abstract class.
 * 
 * The read(Reader source, Object description) throws IOException reads an puts
 * a stream inside the text. description is a description object. For example,
 * we do --->> FileReader fr = new FileReader("test.txt"); ta.read(fr, "Hello");
 * fr.close(); <<----
 * 
 * write(Writer output) does the opposite of read.
 * 
 * The most commonly used methods of text components are getText() and
 * setText(String text). The getText() method returns the contents of a text
 * component as a String, and the setText(String text) method sets the content
 * of a text component specified in the argument.
 * 
 * 
 */