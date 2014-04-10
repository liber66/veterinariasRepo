package veterinarias.gui.utils.tables.models;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CeldasNoEditablesModel extends DefaultTableModel {

    private static final long serialVersionUID = 1L;
    private static Boolean COLUMNAS_EDITABLES = false;

    public CeldasNoEditablesModel(String[] columnNames, int rowCount) {
        super(columnNames, rowCount);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return COLUMNAS_EDITABLES;
    }

    public DefaultTableCellRenderer getCellCenterModel() {
        DefaultTableCellRenderer cellCenterModel = new DefaultTableCellRenderer();
        cellCenterModel.setHorizontalAlignment(SwingConstants.CENTER);
        return cellCenterModel;
    }
}
