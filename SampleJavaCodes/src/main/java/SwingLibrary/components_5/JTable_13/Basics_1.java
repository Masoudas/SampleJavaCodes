package SwingLibrary.components_5.JTable_13;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * An environment for creating and editing tables. You can set column names, and
 * sort data at runtime. javax.swing.table is a package dedicated to tables
 * (because it's so complex and powerful).
 * 
 * JTable does not store data, only displays it (like Text classes). TableModel
 * interface is the model. DefaultTableModel is the default model. To add and
 * remove columns, we work with the model.
 * 
 * With the DefaultTableModel, you can double click on a cell and edit it.
 * 
 * The title header can be taken from the table separately, and played with
 * separately, so that for example as we scroll through the table, the header
 * remains fixed on top of the container.
 * 
 * The easiest way to use header column is with the constructor of the JTable.
 * Other than that, setColumnIdentifiers in the default model does the job.
 */

class FirstJTable {
    public static void main(String[] args) {
        // You may want to combine this example with a scroll pane for example!
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setColumnCount(5);
        model.setRowCount(10);
        model.setValueAt("Polarization 0", 0, 0);
        model.setValueAt(new File("c:/"), 1, 1); // Because it uses the toString method
        model.setColumnIdentifiers(new String[] { "Column1", "Column2", "Column3" });

        JTableHeader tableHeader = table.getTableHeader();

        frame.getContentPane().add(table);
        frame.getContentPane().add(tableHeader, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

    }

    public void createSettingRowAndColumn() {
        // Note that with this scheme, data model would not be DefaultDataModel
        JTable table = new JTable(new String[][] { { "a", "b", "c" }, { "d", "e", "f" } },
                new String[] { "Column 1", "Column 2", "Column 3" });

    }
}
