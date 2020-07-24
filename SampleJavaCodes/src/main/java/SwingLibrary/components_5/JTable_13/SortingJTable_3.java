package SwingLibrary.components_5.JTable_13;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * We can sort a table based on a column value by calling the
 * setAutoCreateRowSorter(true) of the JTable.
 * 
 * You can sort data in a column by clicking the column’s header. After you call
 * this method, a JTable will display an up/down arrow as part of a column
 * header to indicate that a column is sorted in ascending or descending order.
 * 
 * You can also use a row filter that will hide rows in a JTable based on some
 * criteria, as shown:
 * 
 * Here' what we have to do. First, we define a RowFilter (which is in the
 * javax.swing package!!!), which has to generics <TableModel, Column type we
 * want to organize>. Then we need to override the include() method. What it does is that
 * the filter will include the rows that satisfy this criteria, otherwise it excludes tham.
 * After creating the row filter instance, we create a TableRowSorter object, and
 * we setRowFilter() it. And that's pretty much it. 
 * 
 * Note that the actual sort is taken care of with swing, hence the exclusion with
 * the filter is the only part that needs to be taken care of.
 * 
 */
public class SortingJTable_3 {
    public static void main(String[] args) {
        ACustomTableModel model = new ACustomTableModel();
        TableRowSorter<ACustomTableModel> sorter = new TableRowSorter<ACustomTableModel>(model);
        sorter.setRowFilter(new Filter());

        JTable table = new JTable(model);
        table.setRowSorter(sorter);

        JViewport viewPort = new JViewport();
        viewPort.add(table);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewport(viewPort);
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}

class ACustomTableModel extends AbstractTableModel {
    private static final long serialVersionUID = -3217387281378137L;

    private String[] header = { "ID", "Name", "Gender", "Checked" };
    private Class<?>[] columnClass = { Integer.class, String.class, String.class, Boolean.class };
    private Object[][] cells = { { 1, "Mass", "Trans!", false }, { 2, "Ass", "nonTrans!", false },
            { 43, "Mass", "Trans!", false }, { 453534, "Ass", "nonTrans!", false }, { 55, "Mass", "Trans!", false },
            { 6, "Ass", "nonTrans!", false }, { 7543, "Mass", "Trans!", false }, { 8, "Ass", "nonTrans!", false } };

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

class Filter extends RowFilter<ACustomTableModel, Integer> {

    @Override
    public boolean include(Entry<? extends ACustomTableModel, ? extends Integer> entry) {
        ACustomTableModel model = entry.getModel();

        Integer rowIndex = entry.getIdentifier();
        Integer value = (Integer)model.getValueAt(rowIndex, 0);

        if (value < 50){
            return false;
        }
        return true;
    }

}