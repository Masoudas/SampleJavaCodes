package SwingLibrary.components_5.TextComponents_5;

/**
 * We have several forms of text components. The hierarchy is given in
 * 1_HierArchyOfTextComponents.png. The classes are all in the javax.swing.text
 * package.
 * 
 * We have either:
 * 
 * - SingleLineTextComponents: JTextField, JPasswordField, and
 * JFormattedTextField
 * 
 * - MultiLineTextComponenets: JTextArea, JTextPane, JEditorPane.
 * 
 * Or we can think of:
 * 
 * - plainTextComponents: JTextField, JPasswordField, JFormattedTextField, and
 * JTextArea. Note that being plain implies that the entire text has the same
 * format (bold for example).
 * 
 * - styledTextComponents: JEditorPane, JTextArea are both styled.
 * 
 * All Swing components, including Swing text components, are based on a
 * model-view-controller (MVC) pattern. An MVC pattern uses three components: a
 * model, a view, and a controller. The model is responsible for storing the
 * contents (the text). The view is responsible for displaying the contents. The
 * controller is responsible for responding to user actions. Swing combines the
 * view and the controller into one object called the UI, which is responsible
 * for displaying the content and reacting to the user’s actions. It keeps the
 * model separate and it is represented by an instance of the Document
 * interface, which is in the javax.swing.text package. The model of a text
 * component is sometimes also referred to as its document.
 * 
 * We can set the document style of a text in its constructor.
 * 
 * By default, JTextField, JPasswordField, JFormattedTextField, and JTextArea
 * use an instance of the PlainDocument class as their models. If you want to
 * customize the models for these text components, you need to create a class
 * inheriting from the PlainDocument class and override some of the methods. The
 * model for JEditorPane and JTextPane depends on the content type that is being
 * edited and/or displayed. The position of the characters in a text component
 * uses a zero-based index. That is, the first character in the text occurs at
 * index 0.
 * 
 * 
 */