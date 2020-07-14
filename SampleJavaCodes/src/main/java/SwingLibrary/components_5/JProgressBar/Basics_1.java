package SwingLibrary.components_5.JProgressBar;

import javax.swing.JProgressBar;

/**
 * Used for showing the progress of a task. We only need to set the current
 * value. We can also print a string.
 * 
 * Sometimes the current value of the progress of a task is unknown or
 * indeterminate. In such cases, you cannot set the current value for the
 * progress bar. Rather, you can indicate to the user that the task’s execution
 * is in progress. You can set a progress bar in an indeterminate mode using its
 * setIndeterminate() method. Passing true to this method places the progress
 * bar in an indeterminate mode and passing false places the progress bar in a
 * determinate mode. A JProgressBar component displays an animation to indicate
 * its indeterminate state.
 * 
 */
class Basics_1 {
    public static void main(String[] args) {
        /**
         * Progress from zero to 100.
         */
        JProgressBar progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        progressBar.setValue(10);
        progressBar.setString("Task progress.");
        progressBar.setStringPainted(true);
    }
}