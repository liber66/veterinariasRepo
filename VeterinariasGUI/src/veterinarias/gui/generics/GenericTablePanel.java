package veterinarias.gui.generics;

import java.awt.Font;
import java.awt.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import veterinarias.gui.utils.tables.models.CeldasNoEditablesModel;

public class GenericTablePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JScrollPane scrollPane;
    private JTable table;
    private GroupLayout gl_panel;
    //Despues sacar
    private int totalAnchoPixelesMinimizadoSinScroll = 664;
    private int totalAnchoPixelesMinimizadoConScroll = 648;

    public GenericTablePanel() {
        super();
        this.setBorder(null);
        this.setOpaque(false);
        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setViewportBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        table = new JTable();
        table.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(table);
        //Armo Group Layout de Panel Socios
        gl_panel = new GroupLayout(this);
        this.setLayout(gl_panel);
        gl_panel.setHorizontalGroup(horizontalGroup());
        gl_panel.setVerticalGroup(verticalGroup());
    }

    public GenericTablePanel(String[] nameColumns, int[] minWidthColumns, int[] prefWidthColumns, int[] maxWidthColumns) {
        super();
        this.setBorder(null);
        this.setOpaque(false);
        scrollPane = new JScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setViewportBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        table = new JTable();
        table.getTableHeader().setReorderingAllowed(false);
        //Para que solo una fila  sea seleccionable
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(table);
        //Armo Group Layout de Panel Socios
        gl_panel = new GroupLayout(this);
        this.setLayout(gl_panel);
        gl_panel.setHorizontalGroup(horizontalGroup());
        gl_panel.setVerticalGroup(verticalGroup());
        this.setModel(nameColumns, 0);
        this.setWidthColumns(minWidthColumns, prefWidthColumns, maxWidthColumns);
    }

    private ParallelGroup horizontalGroup() {
        ParallelGroup result = gl_panel.createParallelGroup(Alignment.LEADING);
        result.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }

    private ParallelGroup verticalGroup() {
        ParallelGroup result = gl_panel.createParallelGroup(Alignment.TRAILING);
        result.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE);
        return result;
    }

    public void setModel(String[] nombresColumnas, int cantFilas) {
        CeldasNoEditablesModel miModelo = new CeldasNoEditablesModel(nombresColumnas, cantFilas);
        table.setModel(miModelo);
    }

    public void setTitleFont(Font fuente) {
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(fuente);
    }

    //Obligatorio: minWidthColumns
    //Opcionales: prefWidthColumns, maxWidthColumns 
    //Pre: todas deben tener mismo tamaño, si no se quiere poner una posicion => pasar -1 en esa pos
    public void setWidthColumns(int[] minWidthColumns, int[] prefWidthColumns, int[] maxWidthColumns) {
        for (int i = 0; i < minWidthColumns.length; i++) {
            table.getColumnModel().getColumn(i).setMinWidth(minWidthColumns[i]);
            if (prefWidthColumns != null && prefWidthColumns[i] != -1) {
                table.getColumnModel().getColumn(i).setPreferredWidth(prefWidthColumns[i]);
            }
            if (maxWidthColumns != null && maxWidthColumns[i] != -1) {
                table.getColumnModel().getColumn(i).setMaxWidth(maxWidthColumns[i]);
            }
        }
    }

    public void centrarColumnas(int[] posColumnas) {
        DefaultTableCellRenderer cellCenterModel = ((CeldasNoEditablesModel) table.getModel()).getCellCenterModel();
        for (int i = 0; i < posColumnas.length; i++) {
            table.getColumnModel().getColumn(posColumnas[i]).setCellRenderer(cellCenterModel);
        }
    }

    public void agregarDatos(Object[][] datos) {
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                table.setValueAt(datos[i][j], i, j);
            }
        }
    }

    public void selectRow(int rowPosition) {
        table.setRowSelectionInterval(rowPosition, rowPosition);
    }

    public void visualizar(boolean visualizar) {
        scrollPane.setVisible(visualizar);
    }

    public int getCantidadFilas() {
        return table.getRowCount();
    }

    public int addRow(Object[] row) {
        DefaultTableModel miModelo = (DefaultTableModel) table.getModel();
        miModelo.addRow(row);
        return table.getRowCount() - 1;
    }

    public int rowAtPoint(Point point) {
        return table.rowAtPoint(point);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
