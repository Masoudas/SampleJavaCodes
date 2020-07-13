package SwingLibrary.components_5.JSpinner;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

/**
 * Spins through a value set to give us a choice. IT lets specify the choice
 * set, and also how to display them using a formatter. The list of choices has
 * to be an ordered list. It supports three models of representation:
 * 
 * SpinnerNumberModel
 * 
 * SpinnerDateModel
 * 
 * SpinnerListModel
 */
class JSpinnerExample extends JFrame {
    protected void initFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SpinnerNumberModel channelModel = new SpinnerNumberModel(1, 1, 5, 1);
        JSpinner spinner = new JSpinner(channelModel);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, 9, 5);
        Date value = calendar.getTime();
        
        calendar.set(1980, 1, 1);
        Date start = calendar.getTime();

        calendar.set(2020, 1, 1);
        Date end = calendar.getTime();

        int step = Calendar.DAY_OF_MONTH;   // Steps for the spinner;
        SpinnerDateModel dateModel = new SpinnerDateModel(value, start, end, step);
        JSpinner spinnerDate = new JSpinner(dateModel);

        String[] seasons = {"Spring", "Summer", "Automn", "Winter"};
        SpinnerListModel listModel = new SpinnerListModel(seasons);
        JSpinner listSpinner = new JSpinner(listModel);

        Container contentPane = this.getContentPane();
        contentPane.add(spinner);
        contentPane.add(spinnerDate, BorderLayout.EAST);
        contentPane.add(listSpinner, BorderLayout.WEST);
        
        this.pack();
    }

    public JSpinnerExample(){
        initFrame();
    }

    public static void main(String[] args) {
        JSpinnerExample example = new JSpinnerExample();

        example.setVisible(true);
    }
}