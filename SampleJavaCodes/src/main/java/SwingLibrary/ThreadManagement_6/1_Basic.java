package SwingLibrary.ThreadManagement_6;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JComboBox;

/**
 * Most classes in swing are not thread safe (i.e, they can be accessed via
 * several threads.)
 * 
 * Swing’s thread safety rule is very simple. It states that once a Swing
 * component has been realized, you must modify or access that component’s state
 * on the event dispatch thread. A component is considered to be realized if it
 * has been painted or it is ready to be painted. A top-level container in Swing
 * is realized when you call its pack(), setVisible(true), or show() method for
 * the first time. When a top-level container is realized, all of its children
 * are also realized
 * 
 * Event dispatch thread is automatically created by JVM. So everytime an event
 * is generated, its code is executed by this thread.
 * 
 * Two classes SwingUtilities and SwingWorker are important for thread related
 * issues. The System.out.println(SwingUtilities.isEventDispatchThread()) would
 * show whether this thread exists and being executed.
 */

/**
 * This is a bad application, because if we execute the code, it displays that
 * the event is not in the event dispatch thread the first time. Why? Because
 * the first time. This is because the thread is created the first time an event
 * is generated with the GUI. Now with the combo, the first event happens before
 * creating the combo (as we set the default value of combo). So we're still in
 * the main thread. Then after, the events are created inside the GUI, hence,
 * the method returns true.
 * 
 * So two rules must be followed:
 * 
 * 1- is not a good practice to add event handlers to a component first, and
 * then do something that fires that event handler before the GUI is shown. Make
 * it a rule of thumb to add all event handlers to a component at the end of the
 * GUI-building code. You can fix this problem by just moving the addItem()
 * calls before the addItemListener() call in the initFrame() method.
 * 
 * 2- You need to run all GUI code—from GUI building to making it visible—on the
 * event dispatch thread. This is also a simple thing to do. You need to use the
 * invokeLater(Runnable r) static method of the SwingUtilities class. The method
 * takes a Runnable as its argument. It schedules the Runnable to run on the
 * event dispatch thread.
 *
 */
class BadSwingApp extends JFrame {
    JComboBox<String> combo = new JComboBox<>();

    public BadSwingApp(String title) {
        super(title);
        initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.add(combo, BorderLayout.NORTH);
        // Add an ItemEvent listener to the combobox
        combo.addItemListener(
                e -> System.out.println("isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread()));
        combo.addItem("First");
        combo.addItem("Second");
        combo.addItem("Third");
    }

    public static void main(String[] args) {
        BadSwingApp badSwingApp = new BadSwingApp("A bad Swing App");
        badSwingApp.pack();
        badSwingApp.setVisible(true);
    }
}