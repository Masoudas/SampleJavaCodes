package SwingLibrary.ThreadManagement_6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 * So, it appears in order to run the GUI in event dispatch thread, we need to
 * implement a runner of it. This runner is then used in the create method to
 * actually allow us to run and visualize the frame, and at the same time return
 * an instance of it. If we didn't want to return this instance, we could've 
 * implemented the runnable anonymously, but impossible.
 * 
 * Now, we need to run the method inside other thread. I tried just an anonymous
 * runnable interface inside the action event of the buttom, but it was impossible. 
 * I actually had to use the SwingWorker class to start a new thread. I've no idea why
 * this is the case.
 */
class ViewModel {
    public void methodInsideOtherThread() {
        System.out.println("Outside event dispath thread: " + !SwingUtilities.isEventDispatchThread());
    }

    public static void main(String[] args) {
        ViewModel model = new ViewModel();
        FrameInEventThread.create(model);
    }

}

class FrameInEventThread implements Runnable {

    public static FrameInEventThread create(ViewModel model) {
        FrameInEventThreadRunner runner = new FrameInEventThreadRunner(model);
        SwingUtilities.invokeLater(runner);

        return runner.frame;
    }

    JFrame frame = new JFrame();
    JButton button = new JButton();
    ViewModel model;

    FrameInEventThread(ViewModel model) {
        this.model = model;

    }

    public void show() {
        frame.add(button);

        button.addActionListener((e) -> {
            try {
                new BackgroundTask(model).execute();
            } catch (Exception e1) {
            }
        });

        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    @Override
    public void run() {

    }

}

class BackgroundTask extends SwingWorker<Integer, Integer> {
    ViewModel viewModel;

    public BackgroundTask(ViewModel viewModel) {
        this.viewModel = viewModel;

    }

    @Override
    protected Integer doInBackground() throws Exception {
        viewModel.methodInsideOtherThread();
        return Integer.SIZE;
    }

}

class FrameInEventThreadRunner implements Runnable {
    FrameInEventThread frame;
    ViewModel model;

    public FrameInEventThreadRunner(ViewModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        frame = new FrameInEventThread(model);
        frame.show();
    }

}
