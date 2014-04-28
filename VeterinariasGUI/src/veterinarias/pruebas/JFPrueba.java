package veterinarias.pruebas;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author beastieux
 */
public class JFPrueba extends JFrame {

    private JTable tblEjemplo;
    private JScrollPane scpEjemplo;
    private DefaultTableModel dtmEjemplo;

    public JFPrueba() {
        tblEjemplo = new JTable();
        tblEjemplo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scpEjemplo = new JScrollPane();
        //Llenamos el modelo
        dtmEjemplo = new DefaultTableModel(getFilas(), getColumnas());
        tblEjemplo.setModel(dtmEjemplo);
        scpEjemplo.add(tblEjemplo);
        this.add(scpEjemplo);
        this.setSize(500, 200);
        scpEjemplo.setViewportView(tblEjemplo);
        setEventoMouseClicked(tblEjemplo);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    //Datos de las filas
    private Object[][] getFilas() {
        Object fila[][] = new Object[][] { { "a1", "b1", "c1", "d1" }, { "a2", "b2", "c2", "d2" }, { "a3", "b3", "c3", "d3" } };
        return fila;
    }

    //Encabezados de la tabla
    private String[] getColumnas() {
        String columna[] = new String[] { "A", "B", "C", "D" };
        return columna;
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                tblEjemploMouseClicked(e);
            }
        });
    }

    private void tblEjemploMouseClicked(java.awt.event.MouseEvent evt) {
        String cadena = "";
        int row = tblEjemplo.rowAtPoint(evt.getPoint());
        if (row >= 0 && tblEjemplo.isEnabled()) {
            for (int i = 0; i < tblEjemplo.getColumnCount(); i++) {
                cadena = cadena + " " + dtmEjemplo.getValueAt(row, i).toString();
            }
        }
        JOptionPane.showMessageDialog(null, cadena);
    }

    public static void main(String args[]) {
        JFPrueba obj = new JFPrueba();
        obj.setVisible(true);
    }
}