package UI;

import entities.UserAccount;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

class JTableButtonModel extends AbstractTableModel {
    private Object[][] rows = {};
    private final String[] columns = {"User", "Action"};
    public int getRowCount() {
        return rows.length;
    }
    public int getColumnCount() {
        return columns.length;
    }
    public Object getValueAt(int row, int column) {
        return rows[row][column];
    }

    public void setRows(UserAccount[] results) {
        ArrayList<Object[]> toSet = new ArrayList<>();
        for (UserAccount user : results){
            toSet.add(new Object[]{user.get_username(), new JButton("view")});
        }

        this.rows = (Object[][]) toSet.toArray();
    }
}
