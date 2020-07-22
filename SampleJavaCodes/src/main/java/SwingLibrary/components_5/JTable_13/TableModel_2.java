package SwingLibrary.components_5.JTable_13;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.AbstractTableModel;

/**
 * Sometimes we want to define a table model of our own, which would enable us
 * to define several properties, like closing the editing possiblity. This is
 * why we use the TableModel interface.
 * 
 * The AbstractTableModel is an abstract class that has implemented an empty
 * method for each interface. We need to at least implement getRowCount(),
 * getColumnCount() and getValueAt(int row, int column). Obviously, we can set
 * the manner in which data is stored in the table (for example a list, array,
 * map or so forth),
 * 
 * Apparently, we prefer to work with our own table models. For example, the
 * fact that we defined the we defined a column as Integer class allows the
 * JTable to by itself right align the numbers (which is what we want?) Had we
 * said string instead, it would've left aligned it (as it did string columns).
 * 
 * Note: Basically with a JScrollPane, the header always remains on top when you
 * move the table, so no need to do anything on that front!
 * 
 */
class CustomTableModel extends AbstractTableModel {
    private static final long serialVersionUID = -3217387281378137L;

    private String[] header = { "ID", "Name", "Gender", "Checked" };
    private Class<?>[] columnClass = { Integer.class, String.class, String.class, Boolean.class };
    private Object[][] cells = { { 1, "Mass", "Trans!", false }, { 2, "Ass", "nonTrans!", false },
            { 3, "Mass", "Trans!", false }, { 4, "Ass", "nonTrans!", false }, { 5, "Mass", "Trans!", false },
            { 6, "Ass", "nonTrans!", false }, { 7, "Mass", "Trans!", false }, { 8, "Ass", "nonTrans!", false } };

    @Override
    public int getRowCount() {
        return cells.length;
    }

    @Override
    public int getColumnCount() {
        return cells[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cells[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClass[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        cells[rowIndex][columnIndex] = aValue;
    }

}

class FrameWithCustomTableModel {
    public static void main(String[] args) {
        JTable table = new JTable(new CustomTableModel());

        JViewport viewPort = new JViewport();
        viewPort.add(table);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewPort);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}