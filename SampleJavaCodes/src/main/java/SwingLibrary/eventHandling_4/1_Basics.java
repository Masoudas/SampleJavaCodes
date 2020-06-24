package SwingLibrary.eventHandling_4;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * An event is an occurance at a certain point in time (like the literal
 * definition.)
 * 
 * We also say event trigger when an even happens.
 * 
 * Taking an action in response to the occurrence of an event is called event
 * handling.
 * 
 * There are three participants in an event: 1- An event source. 2- An event 3-
 * The event handler (or event listener).
 * 
 * For example, an object of the ActionEvent class in the java.awt.event package
 * represents a clicked event for a JButton.
 * 
 * Typically, an event listener is an object that implements a specific
 * interface.
 * 
 * Here's how we handle an event:
 * 
 * 1- Identify the component.
 * 
 * 2- Identify the event in the component.
 * 
 * 3- Identify the event handler (listener) interface.
 * 
 * 4- Implement the event handler interface.
 * 
 * 5- Register the event listener to the event.
 * 
 * In the following example, we add an action listener to a JButton.
 * 
 * The 1_EventClassHierarchy shows the class hierarchy of events.
 * 
 * It's interesting that essentially, there are no methods to access the actuall
 * events for example in a button. Just methods to register handlers. The reason
 * why we need to know them though is that they're passed through the event
 * listener class.
 * 
 * Also interesting is that the source of all event listener interfaces
 * (EvenListener) is in fact in the java.util class.
 */
class SimplestEventHandlingFrame extends JFrame {
    private static final long serialVersionUID = 6884405644795892262L;
    JButton closeButton = new JButton("Close");

    public SimplestEventHandlingFrame() {
        super("Simplest Event Handling JFrame");
        this.initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set a FlowLayout for the content pane
        this.setLayout(new FlowLayout());
        // Add the Close JButton to the content pane
        this.getContentPane().add(closeButton);
        // Add an ActionListener to closeButton
        closeButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SimplestEventHandlingFrame frame = new SimplestEventHandlingFrame();
        frame.pack();
        frame.setVisible(true);
    }
}

/**
 * Keeping a count of how many times the button has been clicked. Note that we
 * can't do this with a lambda, because as we know passing a counter to lambda
 * and then incrementing it violates outside variable change in lambdas
 * (variable effectively final). Hence, we handle the event, using an anonymous
 * class.
 */
class JButtonClickedCounter extends JFrame {
    private static final long serialVersionUID = -7378073541409081941L;
    int counter;
    JButton counterButton = new JButton("Clicked #0");
    JButton closeButton = new JButton("Close");

    public JButtonClickedCounter() {
        super("JButton Clicked Counter");
        this.initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set a FlowLayout for the content pane
        this.setLayout(new FlowLayout());
        // Add two JButtons to the content pane
        this.getContentPane().add(counterButton);
        this.getContentPane().add(closeButton);
        // Add an ActionListener to the counter JButton
        counterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Increment the counter and set the JButton text
                counter++;
                counterButton.setText("Clicked #" + counter);
            }
        });
        // Add an ActionListener to closeButton
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Exit the application, when this button is pressed
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        JButtonClickedCounter frame = new JButtonClickedCounter();
        frame.pack();
        frame.setVisible(true);
    }
}