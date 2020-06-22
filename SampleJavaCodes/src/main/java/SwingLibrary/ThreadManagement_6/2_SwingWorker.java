package SwingLibrary.ThreadManagement_6;

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;
import javax.swing.JFrame;
import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import java.util.List;

/**
 * As we know, we may have to perfrom a time consuming task alongside our
 * current app, and then update the result. The SwingWorker class allow us to
 * accomplish such task. It takes care of starting a new thread and executing
 * some pieces of code in a new background thread and some pieces of code in the
 * event dispatch thread.
 * 
 * The SwingWorker<T,V> class is declared abstract. The type parameter T is the
 * result type produced by this class and the type parameter V is the
 * intermediate result type. You must create your custom class inheriting from
 * it. It contains few methods of interest where you would write your custom
 * code:
 * 
 * • doInBackground(): This is the method where you write the code to perform a
 * time-consuming task. It is executed in a separate worker thread. If you want
 * to publish intermediate results, you can call the publish() method of the
 * SwingWorker class from this method, which in turn will call its process()
 * method. Note that you are not supposed to access any Swing component in this
 * method, as this method does not execute on the event dispatch thread.
 * 
 * • process(): This method is called as a result of a publish() method call.
 * This method executes on the event dispatch thread, and you are free to access
 * any Swing component in this method. A call to the process() method may be a
 * result of many calls to the publish() method. Here are the method signatures
 * for these two methods: protected final void publish(V... chunks) protected
 * void process(List<V> chunks)
 * 
 * • The publish() method accepts a varargs argument. The process() method
 * passes all arguments to the publish() method packed in a List. If more than
 * one call to the publish() method are combined together, the process() method
 * gets all those arguments in its List argument.
 * 
 * • done(): When the doInBackground() method finishes, normally or abnormally,
 * the done() method is called on the event dispatch thread. You can access
 * Swing components in this method. By default, this method does nothing.
 * 
 * • execute(): You call this method when you want to start executing your task
 * in a separate thread. This method schedules the SwingWorker object to be
 * executed on a worker thread.
 * 
 * • get(): This method returns the result of the task as returned from the
 * doInBackground() method. If the SwingWorker object has not finished executing
 * the doInBackground() method, the call to this method blocks until the result
 * is ready. It is not suggested to call this method on the event dispatch
 * thread, as it will block all events until it returns.
 * 
 * • cancel(boolean mayInterruptIfRunning): This method cancels the task if it
 * is still running. If the task has not been started, the task never runs. Make
 * sure to check for the cancelled state and for any interruptions in the
 * doInBackground() method and exit the method accordingly. Otherwise, your
 * process will not respond to the cancel() call.
 * 
 * • isCancelled(): It returns true if the process has been cancelled.
 * Otherwise, it returns false.
 * 
 * • isDone(): It returns true if the task has completed. A task may complete
 * normally or by throwing an exception or by cancellation. Otherwise, it
 * returns false.
 * 
 * It is important to note that a SwingWorker object is of a use-and-throw kind.
 * That is, you cannot use it more than once. Calling its execute() method more
 * than once does not do anything.
 * 
 * Suppose you want to perform a time-consuming task that computes a number, say
 * an integer, in a separate thread. You want to retrieve the result of the
 * processing by polling. That is, you will periodically check if the process
 * has finished processing. Here is a simple use of the SwingWorker class: //
 * First, create a custom SwingWorker class, say MySwingWorker.
 */
class MySwingWorker extends SwingWorker<Integer, Integer> {

    @Override
    protected Integer doInBackground() throws Exception {
        int result = -1; // Write code to perform the task

        return result;
    }

    public static void main(String[] args) {
        // Create an object of your SwingWorker class and execute the task
        MySwingWorker mySW = new MySwingWorker();
        mySW.execute();
        // Keep checking for the result periodically. You need to wrap the get()
        // call inside a try-catch to handle any exceptions.
        if (mySW.isDone()) {
            try {
                int result = mySW.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class SwingWorkerProcessor extends SwingWorker<Integer, Integer> {
    private final SwingWorkerFrame frame;
    private int iteration;
    private int intervalInMillis;

    SwingWorkerProcessor(SwingWorkerFrame frame, int iteration, int intervalInMillis) {
        this.frame = frame;
        this.iteration = iteration;
        if (this.iteration <= 0) {
            this.iteration = 10;
        }
        this.intervalInMillis = intervalInMillis;
        if (this.intervalInMillis <= 0) {
            this.intervalInMillis = 1000;
        }
    }

    @Override
    protected Integer doInBackground() throws Exception {
        int sum = 0;
        for (int counter = 1; counter <= iteration; counter++) {
            sum = sum + counter;
            // Publish the result to the GUI
            this.publish(counter);
            // Make sure it listens to an interruption and exits this
            // method by throwing an appropriate exception
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            // Make sure the loop exits, when the task is cancelled
            if (this.isCancelled()) {
                break;
            }

            // This sleep here has no significance other than making this thread last
            // longer.
            Thread.sleep(intervalInMillis);
        }
        return sum;
    }

    @Override
    protected void process(List<Integer> data) {
        for (int counter : data) {
            frame.updateStatus(counter, iteration);
        }
    }

    @Override
    public void done() {
        frame.doneProcessing();
    }
}

class SwingWorkerFrame extends JFrame {
    String startMessage = "Please click the start button...";
    JLabel statusLabel = new JLabel(startMessage);
    JButton startButton = new JButton("Start");
    JButton cancelButton = new JButton("Cancel");
    SwingWorkerProcessor processor;

    public SwingWorkerFrame(String title) {
        super(title);
        initFrame();
    }

    private void initFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        cancelButton.setEnabled(false);
        contentPane.add(statusLabel, BorderLayout.NORTH);
        contentPane.add(startButton, BorderLayout.WEST);
        contentPane.add(cancelButton, BorderLayout.EAST);
        startButton.addActionListener(e -> startProcessing());
        cancelButton.addActionListener(e -> cancelProcessing());
    }

    public void setButtonStatus(boolean canStart) {
        if (canStart) {
            startButton.setEnabled(true);
            cancelButton.setEnabled(false);
        } else {
            startButton.setEnabled(false);
            cancelButton.setEnabled(true);
        }
    }

    public void startProcessing() {
        setButtonStatus(false);
        processor = new SwingWorkerProcessor(this, 10, 1000);
        processor.execute();
    }

    public void cancelProcessing() {
        // Cancel the processing
        processor.cancel(true);
        setButtonStatus(true);
    }

    public void updateStatus(int counter, int total) {
        String msg = "Processing " + counter + " of " + total;
        statusLabel.setText(msg);
    }

    public void doneProcessing() {
        if (processor.isCancelled()) {
            statusLabel.setText("Process cancelled ...");
        } else {
            try {
                // Get the result of processing
                int sum = processor.get();
                statusLabel.setText("Process completed. Sum is " + sum);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        setButtonStatus(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingWorkerFrame frame = new SwingWorkerFrame("SwingWorker Frame");
            frame.pack();
            frame.setVisible(true);
        });
    }
}